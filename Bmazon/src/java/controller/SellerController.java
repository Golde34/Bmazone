///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import entity.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.*;
//
///**
// *
// * @author Nam
// */
//public class SellerController extends HttpServlet {
//
//    
//    ProductDAO daoproduct = new ProductDAO();
//    CategoryDAO daocategory = new CategoryDAO();
//    GenreDAO daogenre = new GenreDAO();
//    UserDAO daouser = new UserDAO();
//    WareHouseDAO daowarehouse = new WareHouseDAO();
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String service = request.getParameter("service");
//
//            if (service == null) {
//                service = "SellerDashboard";
//            }
//
//            //Seller Dashboard
//            if (service.equalsIgnoreCase("SellerDashboard")) {
//                serviceSellerDashboard(request, response);
//            }
//
//            //Product Management
//            if (service.equalsIgnoreCase("productmanagement")) {
//                serviceProductManagement(request, response);
//            }
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
//        }
//    }
//
//    public void serviceSellerDashboard(HttpServletRequest request, HttpServletResponse response) {
//        ArrayList<Product> listProduct = daoproduct.getAllProduct();
//        request.setAttribute("listProduct", listProduct);
//        ArrayList<User> listUser = daouser.getAllUser();
//        request.setAttribute(("listUser"), listUser);
//        sendDispatcher(request, response, "admin/admin.jsp");
//    }
//
//    public void serviceProductManagement(HttpServletRequest request, HttpServletResponse response) {
//        ArrayList<User> listUser = daouser.getAllUser();
//        request.setAttribute("listUser", listUser);
//        sendDispatcher(request, response, "admin/usermanagement.jsp");
//    }
//
//    public void serviceEditDetail(String service, HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("service", service);
//        if (service.equalsIgnoreCase("adddetail")) {
//            sendDispatcher(request, response, "admin/detail.jsp");
//            return;
//        }
//        int id = Integer.parseInt(request.getParameter("userid"));
//        User user = daouser.getUserById(id);
//        request.setAttribute("user", user);
//        sendDispatcher(request, response, "admin/detail.jsp");
//    }
//
//    public void serviceAddProduct(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String fullname = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        int gender = Integer.parseInt(request.getParameter("gender"));
//        int role = Integer.parseInt(request.getParameter("role"));
//        boolean isExist = false;
//        if (daouser.checkExistMail(email) == true
//                || daouser.checkExistPhone(phone) == true
//                || daouser.checkExistUserName(username) == true) {
//            isExist = true;
//        }
//        if (isExist == true) {
//            String mess = "Add fail because duplicate information";
//            request.setAttribute("mess", mess);
//            request.setAttribute("service", "adddetail");
//            sendDispatcher(request, response, "admin/detail.jsp");
//        }
//        if (isExist == false) {
//            User user = new User(username, password, email, phone, 0, 0, fullname, address, "", gender, "", "", "", "", "", 0, role, 1);
//            daouser.addUser(user);
//            ArrayList<User> listUser = daouser.getAllUser();
//            request.setAttribute("listUser", listUser);
//            sendDispatcher(request, response, "admin/usermanagement.jsp");
//        }
//    }
//
//    public void serviceUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String fullname = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        int gender = Integer.parseInt(request.getParameter("gender"));
//        int role = Integer.parseInt(request.getParameter("role"));
//        boolean isExist = false;
////                if (daouser.checkExistMail(email) == true
////                        || daouser.checkExistPhone(phone) == true
////                        || daouser.checkExistUserName(username) == true) {
////                    isExist = true;
////                }
////                if (isExist == true) {
////                    String mess = "Add fail because duplicate information";
////                    request.setAttribute("mess", mess);
////                    sendDispatcher(request, response, "admin/detail.jsp");
////                }
//        if (isExist == false) {
//            String id = request.getParameter("id");
//            User user = daouser.getUserById(Integer.parseInt(id));
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setFullname(fullname);
//            user.setEmail(email);
//            user.setPhoneNumber(phone);
//            user.setAddress(address);
//            user.setGender(gender);
//            user.setSystemRole(role);
//            daouser.updateInfoUser(user);
//            ArrayList<User> listUser = daouser.getAllUser();
//            request.setAttribute("listUser", listUser);
//            request.setAttribute("user", user);
//            request.setAttribute("service", "updatedetail");
//            sendDispatcher(request, response, "admin/detail.jsp");
//        }
//    }
//
//    public void serviceDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("userid"));
//        daouser.changeStatus(id, 0);
//        ArrayList<User> listUser = daouser.getAllUser();
//        request.setAttribute("listUser", listUser);
//        sendDispatcher(request, response, "admin/usermanagement.jsp");
//    }
//
//    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
//        try {
//            RequestDispatcher rd = request.getRequestDispatcher(path);
//            rd.forward(request, response);
//
//        } catch (ServletException | IOException ex) {
//            Logger.getLogger(AdminController.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
