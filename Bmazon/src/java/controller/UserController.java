/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import entity.User;
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
import javax.servlet.http.HttpSession;
import model.DAOUser;
import model.DBConnection;

/**
 *
 * @author Admin
 */
public class UserController extends HttpServlet {

    DBConnection dbCon = new DBConnection();
    DAOUser daoUser = new DAOUser(dbCon);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service == null) {
                service = "HomePage";
            }

            //Login service
            if (service.equalsIgnoreCase("login")) {
                String userName = request.getParameter("username");
                String mess = "";
                String userPass = request.getParameter("password");
                User log = daoUser.getUserLogin(userName, userPass);
                if (log != null) {
                    request.getSession().setAttribute("currUser", log);
                    request.getSession().setAttribute("role", log.getSystemRole());
                    ArrayList<Product> ShoppingCart = new ArrayList<>();
                    request.getSession().setAttribute("ShoppingCart", ShoppingCart);
                    sendDispatcher(request, response, "index.jsp");
                } else {
                    mess = "Login failed, check your username or your password.";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "jsp/login.jsp");
                }
            }

            //Logout service
            if (service.equalsIgnoreCase("logout")) {
                request.getSession().invalidate();
                sendDispatcher(request, response, "index.jsp");
            }

            //Forgot password
            if (service.equalsIgnoreCase("forgotPass")) {
                String mess;
                String username = request.getParameter("username");
                String newPassword = request.getParameter("confirm-password");
                String checkMail = request.getParameter("mail");
                String checkPhone = request.getParameter("phone");
                User user = daoUser.getUserByUsername(username);
                String mail = user.getEmail();
                String phone = user.getPhoneNumber();
                if (!mail.equalsIgnoreCase(checkMail)) {
                    mess = "Your mail is not correct!";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "jsp/forgot.jsp");
                } else if (!phone.equalsIgnoreCase(checkPhone)) {
                    mess = "Your phone is not correct!";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "jsp/forgot.jsp");
                } else if (!mail.equalsIgnoreCase(checkMail) && !phone.equalsIgnoreCase(checkPhone)) {
                    mess = "Your mail or your phone is not correct. Please re-enter.";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "jsp/forgot.jsp");
                } else {
                    daoUser.changePassword(username, newPassword);
                    mess = "Change password successfully !!";
                    HttpSession session = request.getSession();
                    session.setAttribute("currUser", user);
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "jsp/login.jsp");
                }
            }

            //changepass
            if (service.equalsIgnoreCase("changepass")) {
                String mess = "";

                HttpSession session = request.getSession();
                User account = (User) session.getAttribute("currUser");

                String user = account.getUsername();
                String xUser = request.getParameter("username");
                String oldpass = request.getParameter("oldpass");
                String newpass = request.getParameter("newpass");

                if (!user.equals(xUser)) {
                    mess = "You are only have permission to change pass of your own account";
                } else if (!account.getPassword().equals(oldpass)) {
                    mess = "Old Password is not correct";
                } else if (oldpass.equals(newpass)) {
                    mess = "New pass still same old pass!";
                } else {
                    daoUser.changePassword(user, newpass);
                    mess = "Change password successfully !!";
                }
                request.setAttribute("mess", mess);
                sendDispatcher(request, response, "jsp/changepass.jsp");
            }

            //register
            if (service.equalsIgnoreCase("register")) {

                String checkRegis = "checked";
                request.setAttribute("checkRegis", checkRegis);
                String mess = "";
                String username = request.getParameter("signupusername");
                String password = request.getParameter("signuppass");
                String repassword = request.getParameter("resignuppass");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");

                if (!password.equals(repassword)) {
                    request.setAttribute("mess", "Password must be same as repeat password");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                    return;
                }

                boolean exist = daoUser.checkExistUserName(username);
                if (exist == false) {
                    daoUser.singup(username, password, email, phone);
                    request.setAttribute("mess", "Signup Successfully!");
                    request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("mess", "Duplicate user!");
                }
                request.getRequestDispatcher("jsp/login.jsp").include(request, response);
            }
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
