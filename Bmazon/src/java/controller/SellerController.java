/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author Nam
 */
public class SellerController extends HttpServlet {

    ProductDAO pDAO = new ProductDAO();
    CategoryDAO cateDAO = new CategoryDAO();
    GenreDAO gDAO = new GenreDAO();
    UserDAO uDAO = new UserDAO();
    WareHouseDAO whDAO = new WareHouseDAO();
    DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductTypeDAO ptDAO = new ProductTypeDAO();
    ProductCategoryDAO pcDAO = new ProductCategoryDAO();
    ProductGenreDAO pgDAO = new ProductGenreDAO();
    SellerDAO sellerDAO = new SellerDAO();
    private static final long serialVersionUID = 1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "SellerDashboard";
            }
            //Seller Dashboard
            if (service.equalsIgnoreCase("SellerDashboard")) {
                serviceSellerDashboard(request, response);
            }

            //Product Management
            if (service.equalsIgnoreCase("productmanagement")) {
                serviceProductManagement(request, response);
            }
            //Product detail to add and update
            if (service.equalsIgnoreCase("productdetail")) {
                serviceProductDetail(request, response);
            }

            //Add Product
            if (service.equalsIgnoreCase("addproduct")) {
                serviceAddProduct(request, response);
            }
            //Update Product 
            if (service.equalsIgnoreCase("updateproductdetail")) {
                serviceUpdateProductDetail(request, response);
            }
            //Delete Product
            if (service.equalsIgnoreCase("deactiveproduct")) {
                serviceDeactiveProduct(request, response);
            }
            
            //Active Product
            if (service.equalsIgnoreCase("activeproduct")) {
                serviceActiveProduct(request, response);
            }

            //Add Product Type
            if (service.equalsIgnoreCase("addproducttype")) {
                serviceAddProductType(request, response);
            }

            //Delete Product Type
            if (service.equalsIgnoreCase("deactiveproducttype")) {
                serviceDeactiveProductType(request, response);
            }
            //Active Product Type
            if (service.equalsIgnoreCase("activeproducttype")) {
                serviceActiveProductType(request, response);
            }

            //Paging User
            if (service.equalsIgnoreCase("pagingproduct")) {
                servicePagingProduct(request, response);
            }
            //Show Page User
            if (service.equalsIgnoreCase("showpageproduct")) {
                serviceShowPageProduct(request, response);
            }

            //Order Management
            if (service.equalsIgnoreCase("ordermanagement")) {
                serviceOrderManagement(request, response);
            }
//

            //Edit Seller Information
            if (service.equalsIgnoreCase("editSellerInformation")) {
                serviceEditSellerInformation(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Dashboard methods. Click on the + sign on the left to edit the code.">
    public void serviceSellerDashboard(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        List<Product> listProduct = pDAO.getProductBySeller(seller);
        request.setAttribute("listP", listProduct);
        sendDispatcher(request, response, "seller/dashboard.jsp");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Product methods. Click on the + sign on the left to edit the code.">
    public void serviceProductManagement(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String userID = account.getUserId();
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(userID));
        String sellerID = Integer.toString(seller.getSellerID());
        ArrayList<Product> listProduct = pDAO.getProductBySeller(sellerID);
        ArrayList<Product> listPaging = pDAO.getAllPagingProductBySeller(1, 5, "", sellerID);
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        sendDispatcher(request, response, "seller/productSeller.jsp");
    }

    public void servicePagingProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User account = (User) request.getSession().getAttribute("currUser");
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(account.getUserId()));
        String sellerID = Integer.toString(seller.getSellerID());
        
        PrintWriter pr = response.getWriter();

        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        ArrayList<Product> listPaging = pDAO.getAllPagingProductBySeller(index, numOfRow, search, sellerID);
        request.setAttribute("index", index);
        request.setAttribute("listProduct", listPaging);
        for (Product product : listPaging) {
            int proID = product.getProductID();
            String genreid = pgDAO.getGenreIdByProductId(product.getProductID());
            Genre genre = gDAO.getGenreById(Integer.parseInt(genreid));
            pr.print("<tr>"
                    + "<td><div>" + product.getProductName() + "</div></td>"
                    + "<td>" + product.getReleaseDate() + "</td>"
                    + "<td>" + cateDAO.getCategoryById(pcDAO.getProductCateByProductID(proID).getCategoryID()) + "</td>"
                    + "<td>" + genre.getGenreName() + "</td>"
                    + "<td><div><a href=\"SellerControllerMap?service=productdetail&productid=" + product.getProductID() + "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</div></td>"
                    + "<td>");
            if (product.getStatus() == 1) {
                pr.print("<a href=\"SellerControllerMap?service=deactiveproduct&productid=" + product.getProductID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-danger\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"SellerControllerMap?service=activeproduct&productid=" + product.getProductID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-success\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "seller/productSeller.jsp");
        }
    }

    public void serviceShowPageProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User account = (User) request.getSession().getAttribute("currUser");
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(account.getUserId()));
        int sellerID = seller.getSellerID();
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = pDAO.getPageNumberBySeller(search, sellerID);
        int totalPage = totalResult / numOfRow;
        if (totalResult != numOfRow * totalPage) {
            totalPage += 1;
        }
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;
        if (totalResult > numOfRow) {
            pr.print("<li data-repair=\"1\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"First\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-backward\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            pr.print("<li data-repair=\"" + prev + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Previous\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-arrow-left\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            for (int i = 1; i <= totalPage; i++) {
                if (i < index - 2) {
                    continue;
                }
                if (index < 3) {
                    if (i > 5) {
                        break;
                    }
                } else {
                    if (i > index + 2) {
                        break;
                    }
                }
                if (index == i) {
                    pr.print("<li  class=\"page-item active\" data-repair=\"" + i + "\">");
                } else {
                    pr.print("<li  class=\"page-item\" data-repair=\"" + i + "\">");
                }
                pr.print("<a class=\"page-link\">");
                pr.print("<div class=\"index\">" + i + "</div>");
                pr.print("<span class=\"sr-only\">(current)</span>");
                pr.print("</a>");
                pr.print("</li>");
            }
            pr.print("<li data-repair=\"" + next + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Next\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-arrow-right\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            pr.print("<li data-repair=\"" + totalPage + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Last\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-forward\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "seller/productSeller.jsp");
        }
    }

    public void serviceProductDetail(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productid");
        Product product = pDAO.getProductByID(Integer.parseInt(id));
        String genreid = pgDAO.getGenreIdByProductId(product.getProductID());
        Genre genre = gDAO.getGenreById(Integer.parseInt(genreid));
        String categoryId = pcDAO.getCategoryIdByProductId(product.getProductID());
        Category category = cateDAO.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = gDAO.getGenresByCategoryId(Integer.parseInt(categoryId));
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        sendDispatcher(request, response, "seller/productdetail.jsp");
    }

    public void serviceAddProduct(HttpServletRequest request, HttpServletResponse response) {

        //get data input
        String productname = request.getParameter("pname");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        int category = Integer.parseInt(request.getParameter("category"));
        int genre = Integer.parseInt(request.getParameter("genre"));
        Product product = new Product();
        User account = (User) request.getSession().getAttribute("currUser");
        String userID = account.getUserId();
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(userID));

        // Add product
        product.setProductName(productname);
        product.setDescription(description);
        product.setReleaseDate(Date.valueOf(date));
        product.setSeller(seller.getSellerID());

        pDAO.addProduct(product);
        Product productToken = pDAO.getProductLatest(seller.getSellerID());

        // Add product cate
//        pc.setProductID(product.getProductID());
        pcDAO.addProductCategory(productToken.getProductID(), category);

        //Add product genre
//        pg.setProductID(product.getProductID());
//        pg.setGenreID(Integer.parseInt(genre));
        pgDAO.addProductGenre(productToken.getProductID(), genre);

        ArrayList<Product> listProduct = pDAO.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        sendDispatcher(request, response, "SellerControllerMap?service=productmanagement");
    }

    public void serviceAddProductType(HttpServletRequest request, HttpServletResponse response) {

//        String productname = request.getParameter("productname");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int warehouse = Integer.parseInt(request.getParameter("warehouse"));
        int pid = Integer.parseInt(request.getParameter("proID"));
        Product product = pDAO.getProductByID(pid);
        List<ProductType> listProductType = ptDAO.getProductByProductID(product.getProductID());
        String ptypeID = "Pr" + product.getProductID() + "Ty" + (listProductType.size() + 1);
        ProductType pt = new ProductType(ptypeID, pid, size, color, price, warehouse, quantity, 1);
        pt.setProductTypeId(ptypeID);
        pt.setColor(color);
        pt.setPrice(price);
        pt.setSize(size);
        pt.setQuantity(quantity);
        pt.setWareHouseID(warehouse);
        ptDAO.addProductType(pt);
        sendDispatcher(request, response, "SellerControllerMap?service=productdetail&productid=" + pid + "");
    }

    public void serviceDeactiveProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productid");
        pDAO.changeStatus(Integer.parseInt(id), 0);
        sendDispatcher(request, response, "SellerControllerMap?service=productmanagement");
    }

    public void serviceActiveProduct(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("productid");
        pDAO.changeStatus(Integer.parseInt(id), 1);
        sendDispatcher(request, response, "SellerControllerMap?service=productmanagement");
    }

    public void serviceDeactiveProductType(HttpServletRequest request, HttpServletResponse response) {

        String pid = request.getParameter("productid");
        String ptypeid = request.getParameter("producttypeid");
        ptDAO.changeStatus(ptypeid, 0);
        request.setAttribute("productid", pid);
        sendDispatcher(request, response, "SellerControllerMap?service=productdetail");
    }

    public void serviceActiveProductType(HttpServletRequest request, HttpServletResponse response) {

        String pid = request.getParameter("productid");
        String id = request.getParameter("producttypeid");
        ptDAO.changeStatus(id, 1);
        request.setAttribute("productid", pid);
        sendDispatcher(request, response, "SellerControllerMap?service=productdetail");
    }

    public void serviceUpdateProductDetail(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        //Get information about product
        String pid = request.getParameter("pid");
        String productname = request.getParameter("productname");
        String cat = request.getParameter("category");
        String gen = request.getParameter("genre");
        String date = request.getParameter("date");
        Date sqlDate = Date.valueOf(date);
        //Update product
        ProductCategory pc = pcDAO.getProductCateByProductID(Integer.parseInt(pid));
        ProductGenre pg = pgDAO.getProductGenreByProduct(pid);
        Product product = pDAO.getProductByID(Integer.parseInt(pid));
        product.setProductName(productname);
        product.setReleaseDate(sqlDate);
        pDAO.updateProduct(product);
        pc.setCategoryID(Integer.parseInt(cat));
        pcDAO.updateProductCategory(pc);
        pg.setGenreID(Integer.parseInt(gen));
        pgDAO.updateProductGenre(pg);
        //Get information about product type

        String[] typeids = request.getParameterValues("ptid");
        String[] colors = request.getParameterValues("color");
        String[] sizes = request.getParameterValues("size");
        String[] prices = request.getParameterValues("price");
        String[] quantities = request.getParameterValues("quantity");

        //Update product type
        for (int i = 0; i < typeids.length; i++) {
            ProductType pt = ptDAO.getProductTypeByPTypeID(typeids[i]);
            pt.setColor(colors[i]);
            pt.setSize(sizes[i]);
            pt.setPrice(prices[i]);
            pt.setQuantity(Integer.parseInt(quantities[i]));
            ptDAO.editProduct(pt);
        }
        //Success
        String state = "success";
        String mess = "Update successfully";
        String genreid = pgDAO.getGenreIdByProductId(product.getProductID());
        Genre genre = gDAO.getGenreById(Integer.parseInt(genreid));
        String categoryId = pcDAO.getCategoryIdByProductId(product.getProductID());
        Category category = cateDAO.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = gDAO.getGenresByCategoryId(Integer.parseInt(categoryId));

        //Set request
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("state", state);
        request.setAttribute("product", product);
        request.setAttribute("mess", mess);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "seller/productdetail.jsp");
    }//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Order methods. Click on the + sign on the left to edit the code.">
    public void serviceOrderManagement(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        List<Product> listProduct = pDAO.getProductBySeller(seller);
        request.setAttribute("listP", listProduct);
        sendDispatcher(request, response, "seller/orderSeller.jsp");
    }
    //</editor-fold>

    //
    private void serviceEditSellerInformation(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        int userID = Integer.parseInt(x.getUserId());
        Seller seller = sellerDAO.getSellerByUserID(userID);

        String shopName = request.getParameter("shopName");
        String sellerPhone = request.getParameter("sellerPhone");
        int sellerMainProduct = Integer.parseInt(request.getParameter("sellerMainProduct"));
        seller.setSellerShopName(shopName);
        seller.setSellerPhone(sellerPhone);
        seller.setSellerMainProduct(sellerMainProduct);

        sellerDAO.editSeller(seller);
        mess = "Update successfully!";
        request.setAttribute("mess", mess);
        sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdminController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeObject(ObjectOutputStream stream)
            throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SellerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
