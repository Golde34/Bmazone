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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBConnection;
import model.UserDAO;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DBConnection dbCon = new DBConnection();
    UserDAO daoUser = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            /* TODO output your page here. You may use following sample code. */
            //Login service
            if (service.equalsIgnoreCase("login")) {
                serviceLogin(request, response);
            }

            //Login google
            if (service.equalsIgnoreCase("googleLogin")) {
                serviceGoogleLogin(request, response);
            }

            //Login facebook
            if (service.equalsIgnoreCase("facebookLogin")) {
                serviceFacebookLogin(request, response);
            }

            //register
            if (service.equalsIgnoreCase("register")) {
                serviceRegister(request, response);
            }

            //Forgot password
            if (service.equalsIgnoreCase("forgotPass")) {
                serviceForgotPassword(request, response);
            }
        }
    }

    public void serviceLogin(HttpServletRequest request, HttpServletResponse response) {
        String checkLogin = "checked";
        request.setAttribute("checkLogin", checkLogin);
        String userName = request.getParameter("username");
        String messLogin = "";
        String userPass = request.getParameter("password");
        User log = new User();

        log = daoUser.getUserLogin(userName, userPass);
        if (log != null) {
            request.getSession().setAttribute("currUser", log);
            request.getSession().setAttribute("role", log.getSystemRole());
            ArrayList<Product> ShoppingCart = new ArrayList<>();
            request.getSession().setAttribute("ShoppingCart", ShoppingCart);
            sendDispatcher(request, response, "index.jsp");
        } else {
            messLogin = "Login failed, check your username or your password.";
            request.setAttribute("usernameLogin", userName);
            request.setAttribute("userpassLogin", userPass);
            request.setAttribute("mess", messLogin);
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
    }

    public void serviceRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String checkRegis = "checked";
//        request.setAttribute("checkRegis", checkRegis);
        String messRegis = "";
        String Username = request.getParameter("signupusername");
        String Password = request.getParameter("signuppass");
        String Repassword = request.getParameter("resignuppass");
        String fullname = request.getParameter("fname");
        String Email = request.getParameter("email");
        String Phone = request.getParameter("phone");

        if (!Password.equals(Repassword)) {
            request.setAttribute("messRegis", "Password must be same as repeat password");
            request.getRequestDispatcher("loginAndSecurity/register.jsp").include(request, response);
            return;
        }

        boolean exist = daoUser.checkExistUserName(Username);
        if (exist == false) {
            daoUser.singup(Username, Password, Email, Phone, fullname);
            messRegis = "Signup Successfully!";
//            daoUser.singup(username, password, email, phone, fname);
//            mess = "Signup Successfully!";
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("loginAndSecurity/login.jsp").forward(request, response);
        } else {
            messRegis = "Duplicate user!";
            request.setAttribute("usernameRegis", Username);
            request.setAttribute("passwordRegis", Password);
            request.setAttribute("repasswordRegis", Repassword);
            request.setAttribute("fullnameRegis", fullname);
            request.setAttribute("emailRegis", Email);
            request.setAttribute("phoneRegis", Phone);
        }
        request.setAttribute("mess", messRegis);
//        request.getRequestDispatcher("jsp/login.jsp").include(request, response);
        request.getRequestDispatcher("loginAndSecurity/register.jsp").include(request, response);
    }

    public void serviceForgotPassword(HttpServletRequest request, HttpServletResponse response) {
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
            sendDispatcher(request, response, "loginAndSecurity/forgot.jsp");
        } else if (!phone.equalsIgnoreCase(checkPhone)) {
            mess = "Your phone is not correct!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/forgot.jsp");
        } else if (!mail.equalsIgnoreCase(checkMail) && !phone.equalsIgnoreCase(checkPhone)) {
            mess = "Your mail or your phone is not correct. Please re-enter.";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/forgot.jsp");
        } else {
            daoUser.changePassword(username, newPassword);
            mess = "Change password successfully !!";
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
    }

    public void serviceGoogleLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = "gg." + request.getParameter("username");
        String messLogin = "";
        String userPass = "guest";
        User log = null;
        log = new User(userName, userPass, userName, 0, "gg.guest", "gg.guest", 0, 1);
        request.getSession().setAttribute("currUser", log);
        request.getSession().setAttribute("role", log.getSystemRole());
        ArrayList<Product> ShoppingCart = new ArrayList<>();
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "index.jsp");
    }

    public void serviceFacebookLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = "fb." + request.getParameter("username");
        String messLogin = "";
        String userPass = "guest";
        User log = null;
        log = new User(userName, userPass, "", 0, "fb.guest", "fb.guest", 0, 1);
        request.getSession().setAttribute("currUser", log);
        request.getSession().setAttribute("role", log.getSystemRole());
        ArrayList<Product> ShoppingCart = new ArrayList<>();
        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
        sendDispatcher(request, response, "index.jsp");
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class
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
