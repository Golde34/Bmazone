/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
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
        List<Product> listProduct = daoproduct.getProductBySeller(seller);
        request.setAttribute("listP", listProduct);
        sendDispatcher(request, response, "seller/productSeller.jsp");
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
