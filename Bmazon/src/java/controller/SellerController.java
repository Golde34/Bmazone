/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Nam
 */
public class SellerController extends HttpServlet {

    ProductDAO pDAO = new ProductDAO();
    CategoryDAO cateDAO = new CategoryDAO();
    CommentDAO comDAO = new CommentDAO();
    GenreDAO gDAO = new GenreDAO();
    UserDAO uDAO = new UserDAO();
    WareHouseDAO whDAO = new WareHouseDAO();
    DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductTypeDAO ptDAO = new ProductTypeDAO();
    ProductCategoryDAO pcDAO = new ProductCategoryDAO();
    ProductGenreDAO pgDAO = new ProductGenreDAO();
    SellerDAO sellerDAO = new SellerDAO();
    GalleryDAO galleryDAO = new GalleryDAO();
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

            //Paging Product
            if (service.equalsIgnoreCase("pagingproduct")) {
                servicePagingProduct(request, response);
            }
            //Show Page Product
            if (service.equalsIgnoreCase("showpageproduct")) {
                serviceShowPageProduct(request, response);
            }

            //Paging Product Type
            if (service.equalsIgnoreCase("pagingproducttype")) {
                servicePagingProductType(request, response);
            }
            //Show Page ProductType
            if (service.equalsIgnoreCase("showpageproducttype")) {
                serviceShowPageProductType(request, response);
            }

            //Order Management
            if (service.equalsIgnoreCase("ordermanagement")) {
                serviceOrderManagement(request, response);
            }

            //Order Detail
            if (service.equalsIgnoreCase("orderdetail")) {
                serviceOrderDetail(request, response);
            }
            //Edit Seller Information
            if (service.equalsIgnoreCase("editSellerInformation")) {
                serviceEditSellerInformation(request, response);
            }
            if (service.equalsIgnoreCase("feedback")) {
                serviceFeedBack(request, response);
            }
            if (service.equalsIgnoreCase("showpagecomment")) {
                servicePageComment(request, response);
            }
             if (service.equalsIgnoreCase("commentpaging")) {
                servicePagingComment(request, response);
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

        List<ProductType> listProductType = ptDAO.getProductByProductID(Integer.parseInt(id));
        ArrayList<ProductType> listPaging = ptDAO.getAllPagingProductType(1, 1, "", id);
        int totalPage = listProductType.size() / 1;
        if (listProductType.size() != totalPage * 1) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProductType", listPaging);
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        sendDispatcher(request, response, "seller/productdetail.jsp");
    }

    public void servicePagingProductType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 1;
        String pid = request.getParameter("productid");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        ArrayList<ProductType> listPaging = ptDAO.getAllPagingProductType(index, numOfRow, "", pid);
        request.setAttribute("index", index);
        request.setAttribute("listProductType", listPaging);
        for (ProductType ptype : listPaging) {
//            int proID = ptype.getProductID();
//            String genreid = pgDAO.getGenreIdByProductId(ptype.getProductID());
//            Genre genre = gDAO.getGenreById(Integer.parseInt(genreid));
            Double price = Double.parseDouble(ptype.getPrice());
            pr.print("<tr>"
                    + "<td style=\"width: 90px;\"><label>Color</label></td>"
                    + "<td>\n"
                    + "<input required style=\"width: 100px;\" type=\"text\" name=\"color\" class=\"form-control\" value=\"" + ptype.getColor() + "\">\n"
                    + "<input type=\"hidden\" name=\"ptid\" value=\"" + ptype.getProductTypeId() + "\">\n"
                    + "</td>"
                    + "<td><label>Size</label></td>\n"
                    + "                                                        <td><input required style=\"width: 100px;\" type=\"text\" name=\"size\" class=\"form-control\" value=\"" + ptype.getSize() + "\"></td>"
                    + "<td><label>Price</label></td>\n"
                    + "                                                        <td><input required style=\"width: 100px;\" type=\"text\" name=\"price\" class=\"form-control price\" value=\"" + nf.format(price) + "\"></td>"
                    + "<td><label>Quantity</label></td>\n"
                    + "                                                        <td><input required style=\"width: 100px;\"  type=\"text\" name=\"quantity\" class=\"form-control\" value=\"" + ptype.getQuantity() + "\"></td>"
                    + "<td>");
            if (ptype.getStatus() == 1) {
                pr.print("<a href=\"SellerControllerMap?service=deactiveproducttype&producttypeid=" + ptype.getProductTypeId() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-danger\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"SellerControllerMap?service=activeproducttype&producttypeid=" + ptype.getProductTypeId() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-success\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td><label>Image</label></td>\n"
                    + "<td>\n");
            List<Gallery> listGallery = galleryDAO.getAllImageByProductTypeID(ptype.getProductTypeId());
            for (Gallery gallery : listGallery) {
                pr.print(
                        "<label class=\"imgho\" for=\"file\">\n"
                        + "<img id=\"img\" src=\"images/" + gallery.getLink() + "\">\n"
                        + "</label>\n"
                        + "<input required accept=\"image/*\" onchange=\"loadFile(event)\" id=\"file\" type=\"file\" name=\"photo\" style=\"display: none;\">"
                        + "</td>\n");
            }
            pr.print(
                    "</tr>"
            );
        }
    }

    public void serviceShowPageProductType(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 1;
        String pid = request.getParameter("productid");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        int totalResult = ptDAO.getPageNumber("", pid);
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

//        String filename = null;
//        // Create a factory for disk-based file items
//        try {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletContext servletContext = this.getServletConfig().getServletContext();
//            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//            factory.setRepository(repository);
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> items = upload.parseRequest(request);
//            // Process the uploaded items
//            Iterator<FileItem> iter = items.iterator();
//            HashMap<String, String> fields = new HashMap<>();
//            while (iter.hasNext()) {
//                FileItem item = iter.next();
//                if (item.isFormField()) {
//                    fields.put(item.getFieldName(), item.getString());
//                    String name = item.getFieldName();
//                    String value = item.getString();
//                    System.out.println(name + " " + value);
//                } else {
//                    filename = item.getName();
//                    if (filename == null || filename.equals("")) {
//                        break;
//                    } else {
//                        Path path = Paths.get(filename);
//                        String storePath = servletContext.getRealPath("/images");
//                        File uploadFile = new File(storePath + "/" + path.getFileName());
//                        item.write(uploadFile);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        Gallery gallery = new Gallery();
//        gallery.setLink(filename);
//        gallery.setProductID(pid);
//        gallery.setProductTypeID(ptypeID);
//        gallery.setStatus(1);
//        galleryDAO.addGallery(gallery);
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
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number nQuantity = 0;
            try {
                nQuantity = format.parse(quantities[i]);
            } catch (ParseException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pt.setQuantity(nQuantity.intValue());
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

        List<ProductType> listProductType = ptDAO.getProductByProductID(Integer.parseInt(pid));
        ArrayList<ProductType> listPaging = ptDAO.getAllPagingProductType(1, 1, "", pid);
        int totalPage = listProductType.size() / 1;
        if (listProductType.size() != totalPage * 1) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProductType", listPaging);

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
        sendDispatcher(request, response, "seller/orderSeller.jsp");
    }

    public void serviceOrderDetail(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productid");
        Product product = pDAO.getProductByID(Integer.parseInt(id));

        String genreid = pgDAO.getGenreIdByProductId(product.getProductID());
        Genre genre = gDAO.getGenreById(Integer.parseInt(genreid));

        String categoryId = pcDAO.getCategoryIdByProductId(product.getProductID());
        Category category = cateDAO.getCategoryByCateId(categoryId);

        List<ProductType> listProductType = ptDAO.getProductByProductID(Integer.parseInt(id));
        request.setAttribute("listProductType", listProductType);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        sendDispatcher(request, response, "seller/orderdetail.jsp");
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
        seller.setStatus(0);
        sellerDAO.editSeller(seller);
        mess = "Update successfully!";
        request.setAttribute("mess", mess);
        sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
    }

    public void serviceFeedBack(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String userID = account.getUserId();
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(userID));
        String sellerID = Integer.toString(seller.getSellerID());
        ArrayList<Comment> listProduct = comDAO.getCommentsBySeller(5);
        ArrayList<Comment> listPaging = comDAO.getCommentsBySellerPaging(1, 5, "", 5);
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        sendDispatcher(request, response, "seller/sellerfeedback.jsp");
    }

    public void servicePageComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        int totalResult =comDAO.getNumberOfCommentPaging(search,sellerID);
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
            sendDispatcher(request, response, "seller/sellerfeedback.jsp");
        }
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
     public void servicePagingComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        ArrayList<Comment> listPaging = comDAO.getCommentsBySellerPaging(index, numOfRow, search,seller.getSellerID());
        request.setAttribute("index", index);
        request.setAttribute("listProduct", listPaging);
        for (Comment comment : listPaging) {
            String id= ""+comment.getUserID();
           User u= uDAO.getUserById(id);
            pr.print("<tr>"
                    + "<td><div>" + comment.getContent() + "</div></td>"
                    + "<td>" +comment.getRating() + "/5</td>"
                    + "<td>" + u.getPublicName()+ "</td>"
                    + "<td>" + pDAO.getProductByID(comment.getProductID()).getProductName()+ "</td>"                  
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "seller/sellerfeedback.jsp");
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
