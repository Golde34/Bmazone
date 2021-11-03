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
import entity.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpCookie;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import model.*;

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
    ProductDAO productDao = new ProductDAO();
    ProductTypeDAO ptd = new ProductTypeDAO();
    GalleryDAO galdao = new GalleryDAO();
    UserDAO uDao = new UserDAO();
    OrderDAO oDao = new OrderDAO();
    OrderDetailDAO odDao = new OrderDetailDAO();
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

            if (service.equalsIgnoreCase("Billing Page")) {
                serviceBillingPage(out, request, response);
            }

            if (service.equalsIgnoreCase("CheckOut")) {
                serviceCheckOut(request, response);
            }
            if (service.equalsIgnoreCase("MyOrder")) {
                serviceMyOrder(request, response);
            }
            if (service.equalsIgnoreCase("OrderDetail")) {
                serviceOrderDetail(request, response);
            }
            if (service.equalsIgnoreCase("Deactice")) {
                serviceDeactive(request, response);
            }
        }

    }

    public void serviceCart(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");

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
        int quantity = Integer.parseInt(request.getParameter("quantity"));

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
                if (ShoppingCart.get(i).getQuantity() > pt.getQuantity()) {
                    ShoppingCart.get(i).setQuantity(pt.getQuantity());
                    String mess = "You already buy all product!";
                    request.setAttribute("mess", mess);
                }
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
        String action = request.getParameter("action");

        for (int i = 0; i < ShoppingCart.size(); i++) {
            ProductType pt = ptd.getProductTypeByColorAndSize(ShoppingCart.get(i).getColor(), ShoppingCart.get(i).getSize(), String.valueOf(ShoppingCart.get(i).getProductID()));
            if (Integer.parseInt(quantityString[i]) < 1 || Integer.parseInt(quantityString[i]) > pt.getQuantity()) {
                request.getSession().setAttribute("ShoppingCart", ShoppingCart);
                sendDispatcher(request, response, "cart/cart.jsp");
            } else if (ShoppingCart.get(i).getCartID() == Integer.parseInt(idString[i])) {
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
                total += item.getTotalCost();
            }
        } else {
            mess = "You must select at least item!";
            request.setAttribute("mess", mess);
            request.setAttribute("ShoppingCart", ShoppingCart);
            sendDispatcher(request, response, "cart/cart.jsp");
            return;
        }
        User x = (User) request.getSession().getAttribute("currUser");
        request.getSession().setAttribute("currUser", x);
        request.getSession().setAttribute("CheckOutList", CheckOutList);
        request.setAttribute("mess", mess);
        request.setAttribute("total", nf.format(total));
        request.setAttribute("hello", total);
        sendDispatcher(request, response, "cart/checkout.jsp");
    }

    public void serviceCheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Order
        String shipName = request.getParameter("fullname");
        int shipCompany = Integer.parseInt(request.getParameter("shipCompany"));
        String shipAddress = request.getParameter("address");
        String shipCity = request.getParameter("city");
        String shipPhone = request.getParameter("phone");
        String payment = request.getParameter("payment");
        User x = (User) request.getSession().getAttribute("currUser");
        String totalString = request.getParameter("ordertotal");
        String id = x.getUserId();
        double wallet = x.getWallet();
        ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("ShoppingCart");
        ArrayList<Integer> distinctShopId = new ArrayList<>();
        for (CartItem cartItem : ShoppingCart) {
            Product product = productDao.getProductByID(cartItem.getProductID());
            if (!distinctShopId.contains(product.getSeller())) {
                distinctShopId.add(product.getSeller());
            }
        }
        ArrayList<Order> listOrder = new ArrayList<>();
        if ("COD".equals(payment)) {
            for (Integer sellerId : distinctShopId) {
                double total = 0;
                Order o = new Order(id, shipName, shipAddress, shipCity, shipPhone, 0, 0, shipCompany, payment, 0);
                oDao.insertOrder(o);
                Order thisOrder = oDao.getLatestOrder(x.getUserId());
                for (CartItem cartItem : ShoppingCart) {
                    Product product = productDao.getProductByID(cartItem.getProductID());
                    if (product.getSeller() == sellerId) {
                        total += cartItem.getPrice() * cartItem.getQuantity();
                        ProductType productTy = ptd.getExactProductTypeByProductId(cartItem.getProductID(), cartItem.getPrice(), cartItem.getSize(), cartItem.getColor());
                        OrderDetail od = new OrderDetail(thisOrder.getOrderID(), productTy.getProductTypeId(), cartItem.getName(), cartItem.getPrice(), cartItem.getQuantity(), 0);
                        odDao.insertOrderDetail(od);
                    }
                }
                thisOrder.setTotal(total);
                oDao.updateOrder(thisOrder);
                listOrder.add(thisOrder);
            }
//            Order o = new Order(id, shipName, shipAddress, shipCity, shipPhone, 0, Double.parseDouble(totalString), shipCompany, payment, 0);
//            oDao.insertOrder(o);
//            Order thisOrder = oDao.getLatestOrder(x.getUserId());
//                insertOrderDetail
//            for (CartItem cartItem : ShoppingCart) {
//                ProductType productTy = ptd.getExactProductTypeByProductId(cartItem.getProductID(), cartItem.getPrice(), cartItem.getSize(), cartItem.getColor());
//                OrderDetail od = new OrderDetail(thisOrder.getOrderID(), productTy.getProductTypeId(), cartItem.getName(), cartItem.getPrice(), cartItem.getQuantity(), 0);
//                odDao.insertOrderDetail(od);
//            }
//                update session & db
            ShoppingCart.removeAll(ShoppingCart);
            request.getSession().setAttribute("ShoppingCart", ShoppingCart);
            request.getSession().setAttribute("currUser", x);

//            ArrayList<OrderDetail> DetailList = odDao.getAllOrderDetail(thisOrder.getOrderID());
            request.getSession().setAttribute("ShoppingCart", ShoppingCart);
            request.getSession().setAttribute("currUser", x);
            request.setAttribute("listOrder", listOrder);
//            request.setAttribute("order", thisOrder);
//            request.setAttribute("DetailList", DetailList);
            request.setAttribute("mess", "Order Sucessfully!");
//                sendDispatcher(request, response, "cart/cart.jsp");
            sendDispatcher(request, response, "cart/confirmorder.jsp");

        } else if ("Wallet".equals(payment)) {
            if (wallet >= Double.parseDouble(totalString)) {
                for (Integer sellerId : distinctShopId) {
                    double total = 0;
                    Order o = new Order(id, shipName, shipAddress, shipCity, shipPhone, 0, 0, shipCompany, payment, 0);
                    oDao.insertOrder(o);
                    Order thisOrder = oDao.getLatestOrder(x.getUserId());
                    for (CartItem cartItem : ShoppingCart) {
                        Product product = productDao.getProductByID(cartItem.getProductID());
                        if (product.getSeller() == sellerId) {
                            total += cartItem.getPrice() * cartItem.getQuantity();
                            ProductType productTy = ptd.getExactProductTypeByProductId(cartItem.getProductID(), cartItem.getPrice(), cartItem.getSize(), cartItem.getColor());
                            OrderDetail od = new OrderDetail(thisOrder.getOrderID(), productTy.getProductTypeId(), cartItem.getName(), cartItem.getPrice(), cartItem.getQuantity(), 0);
                            odDao.insertOrderDetail(od);
                        }
                    }
                    thisOrder.setTotal(total);
                    oDao.updateOrder(thisOrder);
                    listOrder.add(thisOrder);
                }
//                Order o = new Order(id, shipName, shipAddress, shipCity, shipPhone, 0, Double.parseDouble(totalString), shipCompany, payment, 0);
//                oDao.insertOrder(o);
//                Order thisOrder = oDao.getLatestOrder(x.getUserId());
//                insertOrderDetail
//                for (CartItem cartItem : ShoppingCart) {
//                    ProductType productTy = ptd.getExactProductTypeByProductId(cartItem.getProductID(), cartItem.getPrice(), cartItem.getSize(), cartItem.getColor());
//                    OrderDetail od = new OrderDetail(thisOrder.getOrderID(), productTy.getProductTypeId(), cartItem.getName(), cartItem.getPrice(), cartItem.getQuantity(), 0);
//                    odDao.insertOrderDetail(od);
//                }
//                update session & db
                ShoppingCart.removeAll(ShoppingCart);
                x.setWallet(wallet - Double.parseDouble(totalString));
                uDao.updateInfoUserByAdmin(x);

//            ArrayList<OrderDetail> DetailList = odDao.getAllOrderDetail(thisOrder.getOrderID());
                request.getSession().setAttribute("ShoppingCart", ShoppingCart);
                request.getSession().setAttribute("currUser", x);
                request.setAttribute("listOrder", listOrder);
//            request.setAttribute("order", thisOrder);
//            request.setAttribute("DetailList", DetailList);
                request.setAttribute("mess", "Order Sucessfully!");
//                sendDispatcher(request, response, "cart/cart.jsp");
                sendDispatcher(request, response, "cart/confirmorder.jsp");
            } else {
                request.getSession().setAttribute("ShoppingCart", ShoppingCart);
                request.getSession().setAttribute("currUser", x);
                request.setAttribute("total", nf.format(Double.parseDouble(totalString)));
                request.setAttribute("hello", Double.parseDouble(totalString));
                request.setAttribute("mess", "Your balance is not enough");
                sendDispatcher(request, response, "cart/checkout.jsp");
            }
        }
    }

    public void serviceMyOrder(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        if (x == null) {
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
        int id = Integer.parseInt(x.getUserId());
        String stateString = request.getParameter("state");
        String statusString = request.getParameter("status");

        List<Order> list = oDao.getOrderByUser(id);
        List<Order> listby = new ArrayList<Order>();
        if (stateString != null) {
            int state = Integer.parseInt(stateString);
            for (Order order : list) {
                if (order.getState() == state) {
                    listby.add(order);
                }
            }
            request.setAttribute("active" + state, "active");
            request.setAttribute("ListOrder", listby);
            sendDispatcher(request, response, "order/myorder.jsp");
        }
        if (statusString != null) {
            int status = Integer.parseInt(statusString);
            for (Order order : list) {
                if (order.getStatus() == status) {
                    listby.add(order);
                }
            }
            request.setAttribute("active4", "active");
            request.setAttribute("ListOrder", listby);
            sendDispatcher(request, response, "order/myorder.jsp");
        }
        request.setAttribute("active5", "active");
        request.setAttribute("ListOrder", list);
        sendDispatcher(request, response, "order/myorder.jsp");
    }

    private void serviceOrderDetail(HttpServletRequest request, HttpServletResponse response) {
        String orderidString = request.getParameter("orderID");
        int orderid = Integer.parseInt(orderidString);
        Order o = oDao.getOrderByOrderID(orderid);
        ArrayList<OrderDetail> OrderDetailList = odDao.getAllOrderDetail(orderid);
        request.setAttribute("Order", o);
        int state = o.getState();
        for (int i = 0; i <= state; i++) {
            request.setAttribute("active" + i, "active");
        }

        request.setAttribute("OrderDetailList", OrderDetailList);
        sendDispatcher(request, response, "order/orderdetail.jsp");
    }

    public void serviceDeactive(HttpServletRequest request, HttpServletResponse response) {
        String orderidString = request.getParameter("orderID");
        int orderid = Integer.parseInt(orderidString);
        String statusString = request.getParameter("status");
        int status = Integer.parseInt(statusString);
        oDao.changeStatus(orderid, status);
        sendDispatcher(request, response, "CartControllerMap?service=MyOrder");
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
