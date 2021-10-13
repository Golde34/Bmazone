/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.CartItem;
import entity.ProductType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.servlet.RequestDispatcher;
import model.ProductTypeDAO;
import model.GalleryDAO;

/**
 *
 * @author bacon
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductTypeDAO ptd = new ProductTypeDAO();
    GalleryDAO galdao = new GalleryDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service.equalsIgnoreCase("AddToCart")) {
                serviceAddToCart(request, response);
            }
            

        }
        
    }

    public void serviceAddToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        int pid = Integer.parseInt(request.getParameter("pid"));
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String quantitys = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantitys);
        PrintWriter out = response.getWriter();
        ProductType pt = ptd.getProductByPCZ(pid, size, color);
        String image = galdao.getImageByProductTypeID(pt.getProductTypeId());
        double total = quantity * Double.parseDouble(pt.getPrice());

        boolean check = true;
        for (int i = 0; i < ShoppingCart.size(); i++) {
            if (ShoppingCart.get(i).getProductID() == pid
                    && ShoppingCart.get(i).getColor().equals(color)
                    && ShoppingCart.get(i).getSize().equals(size)) {
                ShoppingCart.get(i).setQuantity(ShoppingCart.get(i).getQuantity() + quantity);
                check = false;

            }
        }

        if (check == true) {
            CartItem cartitem = new CartItem(pt.getProductID(), "", pt.getSize(), pt.getColor(), image, Double.parseDouble(pt.getPrice()), quantity, total);
            ShoppingCart.add(cartitem);
        }     
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "cart.jsp");

        
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
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
