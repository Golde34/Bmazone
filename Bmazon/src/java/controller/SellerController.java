/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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

    ProductDAO daoproduct = new ProductDAO();
    CategoryDAO daocategory = new CategoryDAO();
    GenreDAO daogenre = new GenreDAO();
    UserDAO daouser = new UserDAO();
    WareHouseDAO daowarehouse = new WareHouseDAO();
    DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductTypeDAO ptDAO = new ProductTypeDAO();
    ProductCategoryDAO pcDAO = new ProductCategoryDAO();
    CategoryDAO cateDAO = new CategoryDAO();
    SellerDAO daoSeller = new SellerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

            //Paging User
            if (service.equalsIgnoreCase("pagingproduct")) {
                servicePagingProduct(service, request, response);
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
//            //Product detail to add and update
//            if (service.equalsIgnoreCase("updatedetail") || service.equalsIgnoreCase("adddetail")) {
//                serviceEditDetail(service, request, response);
//            }
//
//            //Add product
//            if (service.equalsIgnoreCase("addproduct")) {
//                serviceAddProduct(request, response);
//            }
//
//            //Update product 
//            if (service.equalsIgnoreCase("updateproduct")) {
//                serviceUpdateProduct(request, response);
//            }
//
//            //Delete product
//            if (service.equalsIgnoreCase("deleteproduct")) {
//                serviceDeleteProduct(request, response);
//            }

            //Edit Seller Information
            if (service.equalsIgnoreCase("editSellerInformation")) {
                serviceEditSellerInformation(request, response);
            }
        }
    }

    public void serviceSellerDashboard(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        List<Product> listProduct = daoproduct.getProductBySeller(seller);
        request.setAttribute("listP", listProduct);
        sendDispatcher(request, response, "seller/dashboard.jsp");
    }

    public void serviceProductManagement(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        ArrayList<Product> listPaging = daoproduct.getAllPagingProductBySeller(1, 5, "", seller);
        ArrayList<Product> listProduct = daoproduct.getProductBySeller(seller);
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        sendDispatcher(request, response, "seller/productSeller.jsp");
    }

    public void servicePagingProduct(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        int lastPage = 1;
        PrintWriter pr = response.getWriter();
        request.setAttribute("service", service);
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        ArrayList<Product> listPaging = daoproduct.getAllPagingProductBySeller(index, numOfRow, search, seller);
        request.setAttribute("index", index);
        request.setAttribute("listProduct", listPaging);
        for (Product product : listPaging) {
            int proID = product.getProductID();
            pr.print("<tr>"
                    + "<td><div>" + product.getProductName() + "</div></td>"
                    + "<td>" + product.getReleaseDate() + "</td>"
                    + "<td>" + cateDAO.getCategoryById(pcDAO.getProductCateByProductID(proID).getCategoryID()) + "</td>"
                    + "<td><div><a href=\"SellerControllerMap?service=updatedetail&ptypeid=" + proID + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"SellerControllerMap?service=deleteproduct&ptypeid=" + proID + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );

        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "seller/productmanagement.jsp");
        }
    }

    public void serviceShowPageProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daoproduct.getPageNumber(search);
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
            sendDispatcher(request, response, "seller/productmanagement.jsp");
        }
    }

    public void serviceOrderManagement(HttpServletRequest request, HttpServletResponse response) {
        User account = (User) request.getSession().getAttribute("currUser");
        String seller = account.getUserId();
        List<Product> listProduct = daoproduct.getProductBySeller(seller);
        request.setAttribute("listP", listProduct);
        sendDispatcher(request, response, "seller/orderSeller.jsp");
    }

//    public void serviceEditDetail(String service, HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    public void serviceAddProduct(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    public void serviceUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    public void serviceDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
//    }
    private void serviceEditSellerInformation(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        int userID = Integer.parseInt(x.getUserId());
        Seller seller = daoSeller.getSellerByUserID(userID);

        String shopName = request.getParameter("shopName");
        String sellerPhone = request.getParameter("sellerPhone");
        int sellerMainProduct = Integer.parseInt(request.getParameter("sellerMainProduct"));
        seller.setSellerShopName(shopName);
        seller.setSellerPhone(sellerPhone);
        seller.setSellerMainProduct(sellerMainProduct);

        daoSeller.editSeller(seller);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
