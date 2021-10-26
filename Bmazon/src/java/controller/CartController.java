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
import entity.Order;
import entity.ProductType;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.ProductTypeDAO;
import model.GalleryDAO;
import model.OrderDAO;
import model.UserDAO;

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
    UserDAO uDao = new UserDAO();
    OrderDAO oDao = new OrderDAO();
    private static final long serialVersionUID = 1;
    DecimalFormat nf = new DecimalFormat("###,###,###");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");
            if (service.equalsIgnoreCase("Cart")) {
                serviceCart(request, response);
            }

            if (service.equalsIgnoreCase("AddToCart")) {
                serviceAddToCart(request, response);
            }

            if (service.equalsIgnoreCase("Delete")) {
                serviceDelete(request, response);
            }

            if (service.equalsIgnoreCase("Update")) {
                serviceUpdate(request, response);
            }

            if (service.equalsIgnoreCase("BillingPage")) {
                serviceBillingPage(out, request, response);
            }

            if (service.equalsIgnoreCase("Checkout")) {
                serviceCheckOut(request, response);
            }
        }

    }

    public void serviceCart(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
//         if (ShoppingCart.isEmpty()) {
//             
//         }
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "cart/cart.jsp");
    }

    public void serviceAddToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User x = (User) request.getSession().getAttribute("currUser");
        if (x == null) {
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        String pid = request.getParameter("pid");
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String name = request.getParameter("name");
        String quantitys = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantitys);
//        PrintWriter out = response.getWriter(); // ( fix Findbugs)
        ProductType pt = ptd.getProductTypeByColorAndSize(color, size, pid);
        String image = galdao.getImageByProductTypeID(pt.getProductTypeId());
        double total = quantity * Double.parseDouble(pt.getPrice());
        int pid1 = Integer.parseInt(pid);
        boolean check = true;
        for (int i = 0; i < ShoppingCart.size(); i++) {
            if (ShoppingCart.get(i).getProductID() == pid1
                    && ShoppingCart.get(i).getColor().equals(color)
                    && ShoppingCart.get(i).getSize().equals(size)) {
                ShoppingCart.get(i).setQuantity(ShoppingCart.get(i).getQuantity() + quantity);
                ShoppingCart.get(i).setTotalCost(ShoppingCart.get(i).getQuantity() * Double.parseDouble(pt.getPrice()));
                check = false;
            }
        }
        if (check == true) {
            CartItem cartitem = new CartItem(ShoppingCart.size() + 1, pt.getProductID(), name, pt.getSize(), pt.getColor(), image, Double.parseDouble(pt.getPrice()), quantity, total);
            ShoppingCart.add(cartitem);
        }
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "ProductDetailControllerMap?service=getProductDetail&pid=" + pid);

    }

    public void serviceUpdate(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        String[] idString = request.getParameterValues("cartID");
        String[] quantityString = request.getParameterValues("quantity");

        for (int i = 0; i < ShoppingCart.size(); i++) {
            if (ShoppingCart.get(i).getCartID() == Integer.parseInt(idString[i])) {
                ShoppingCart.get(i).setQuantity(Integer.parseInt(quantityString[i]));
                ShoppingCart.get(i).setTotalCost(Integer.parseInt(quantityString[i]) * (ShoppingCart.get(i).getPrice()));
            }
        }
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "cart/cart.jsp");
    }

    public void serviceDelete(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        String ID = request.getParameter("cartID");
        int cartID = Integer.parseInt(ID);
        for (int i = 0; i < ShoppingCart.size(); i++) {
            if (ShoppingCart.get(i).getCartID() == cartID) {
                ShoppingCart.remove(i);
//
            }
        }
        for (int i = 0; i < ShoppingCart.size(); i++) {
            ShoppingCart.get(i).setCartID(i + 1);

        }

        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "cart/cart.jsp");
    }

    public void serviceBillingPage(PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mess = "";
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        ArrayList<CartItem> CheckOutList = new ArrayList<>();
        String[] choose = request.getParameterValues("checkitem");
        double total = 0;
        if (choose != null) {
            for (int i = 0; i < ShoppingCart.size(); i++) {
                for (int j = 0; j < choose.length; j++) {
                    if (ShoppingCart.get(i).getCartID() == Integer.parseInt(choose[j])) {
                        CheckOutList.add(ShoppingCart.get(i));
                    }
                }
            }
            for (CartItem item : CheckOutList) {
                total += item.getPrice();
            }
        } else {
            mess = "You must select at least item!";
            request.setAttribute("mess", mess);
            request.setAttribute("ShoppingCart", ShoppingCart);
            sendDispatcher(request, response, "cart/cart.jsp");
            return;
        }
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        request.setAttribute("CheckOutList", CheckOutList);
        request.setAttribute("mess", mess);
        request.setAttribute("total", nf.format(total));
        sendDispatcher(request, response, "cart/checkout.jsp");
    }

    public void serviceCheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullname = request.getParameter("fullname");
        String shipCompany = request.getParameter("shipCompany");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String wallet = request.getParameter("wallet");

        User x = (User) request.getSession().getAttribute("currUser");
        x.setAddress(address);
        x.setFullname(fullname);
        x.setPhoneNumber(phone);
        x.setEmail(email);
        uDao.updateInfoUserByAdmin(x);
        Order o = new Order();
        oDao.insertOrder(o);
        
        sendDispatcher(request, response, "cart/orderShip.jsp");
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
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
