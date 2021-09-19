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
 * @author Admin
 */
public class AdminController extends HttpServlet {

    DBConnection dbconn = new DBConnection();
    DAOProduct daoproduct = new DAOProduct(dbconn);
    DAOCategory daocategory = new DAOCategory(dbconn);
    DAOGenre daogenre = new DAOGenre(dbconn);
    DAOUser daouser = new DAOUser(dbconn);
    DAOWareHouse daowarehouse = new DAOWareHouse(dbconn);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "AdminDashBoard";
            }

            //Admin Dashboard
            if (service.equalsIgnoreCase("AdminDashBoard")) {
                ArrayList<Product> listProduct = daoproduct.getAllProduct();
                request.setAttribute("listProduct", listProduct);
                ArrayList<User> listUser = daouser.getAllUser();
                request.setAttribute(("listUser"), listUser);
                sendDispatcher(request, response, "admin/admin.jsp");
            }
            //User Management
            if (service.equalsIgnoreCase("usermanagement")) {
                ArrayList<User> listUser = daouser.getAllUser();
                request.setAttribute("listUser", listUser);
                sendDispatcher(request, response, "admin/usermanagement.jsp");
            }

            //User detail to add and update
            if (service.equalsIgnoreCase("updatedetail") || service.equalsIgnoreCase("adddetail")) {
                request.setAttribute("service", service);
                if (service.equalsIgnoreCase("adddetail")) {
                    sendDispatcher(request, response, "admin/detail.jsp");
                    return;
                }
                int id = Integer.parseInt(request.getParameter("userid"));
                User user = daouser.getUserById(id);
                request.setAttribute("user", user);
                sendDispatcher(request, response, "admin/detail.jsp");
            }

            //Add user
            if (service.equalsIgnoreCase("adduser")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String fullname = request.getParameter("fullname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                int gender = Integer.parseInt(request.getParameter("gender"));
                int role = Integer.parseInt(request.getParameter("role"));
                boolean isExist = false;
                if (daouser.checkExistMail(email) == true
                        || daouser.checkExistPhone(phone) == true
                        || daouser.checkExistUserName(username) == true) {
                    isExist = true;
                }
                if (isExist == true) {
                    String mess = "Add fail because duplicate information";
                    request.setAttribute("mess", mess);
                    request.setAttribute("service","adddetail" );
                    sendDispatcher(request, response, "admin/detail.jsp");
                }
                if (isExist == false) {
                    User user = new User(username, password, email, phone, 0, 0, fullname, address, "", gender, "", "", "", "", "", 0, role, 1);
                    daouser.addUser(user);
                    ArrayList<User> listUser = daouser.getAllUser();
                    request.setAttribute("listUser", listUser);
                    sendDispatcher(request, response, "admin/usermanagement.jsp");
                }
            }
            //Update User 
            if (service.equalsIgnoreCase("updateuser")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String fullname = request.getParameter("fullname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                int gender = Integer.parseInt(request.getParameter("gender"));
                int role = Integer.parseInt(request.getParameter("role"));
                boolean isExist = false;
//                if (daouser.checkExistMail(email) == true
//                        || daouser.checkExistPhone(phone) == true
//                        || daouser.checkExistUserName(username) == true) {
//                    isExist = true;
//                }
//                if (isExist == true) {
//                    String mess = "Add fail because duplicate information";
//                    request.setAttribute("mess", mess);
//                    sendDispatcher(request, response, "admin/detail.jsp");
//                }
                if(isExist==false){
                    String id = request.getParameter("id");
                    User user = daouser.getUserById(Integer.parseInt(id));
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setFullname(fullname);
                    user.setEmail(email);
                    user.setPhoneNumber(phone);
                    user.setAddress(address);
                    user.setGender(gender);
                    user.setSystemRole(role);
                    daouser.updateInfoUser(user);
                    ArrayList<User> listUser = daouser.getAllUser();
                    request.setAttribute("listUser", listUser);
                    request.setAttribute("user", user);
                    request.setAttribute("service","updatedetail" );
                    sendDispatcher(request, response, "admin/detail.jsp");
                }
            }

            //Delete user
            if (service.equalsIgnoreCase("deleteuser")) {
                int id = Integer.parseInt(request.getParameter("userid"));
                daouser.changeStatus(id, 0);
                ArrayList<User> listUser = daouser.getAllUser();
                request.setAttribute("listUser", listUser);
                sendDispatcher(request, response, "admin/usermanagement.jsp");
            }
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
