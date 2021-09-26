/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserDAO;
import model.DBConnection;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class UserController extends HttpServlet {

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

            if (service == null) {
                service = "HomePage";
            }

            //Login service
            if (service.equalsIgnoreCase("login")) {
                serviceLogin(request, response);
            }

            //Logout service
            if (service.equalsIgnoreCase("logout")) {
                serviceLogout(request, response);
            }

            //Forgot password
            if (service.equalsIgnoreCase("forgotPass")) {
                serviceForgotPassword(request, response);
            }

            //change pass
            if (service.equalsIgnoreCase("changepass")) {
                serviceChangePassword(request, response);
            }

            //register
            if (service.equalsIgnoreCase("register")) {
                serviceRegister(request, response);
            }

            //account page to see profile, security, orders, payments, profile, list
            if (service.equalsIgnoreCase("account")) {
                serviceAccount(request, response);
            }

            //profile
            if (service.equalsIgnoreCase("info")) {
                serviceInfo(request, response);
            }

            //Edit public profile Service
            //Edit Profile Page
            if (service.equalsIgnoreCase("editProfile")) {
                serviceEditProfile(request, response);
            }
            //Change Info Profile
            if (service.equalsIgnoreCase("changeInfo")) {
                serviceChangeInfoPublicProfile(request, response);
            }

            //Edit private profile service
            if (service.equalsIgnoreCase("editPrivateProfile")) {
                serviceEditPrivateProfile(request, response);
            }
            //Change info
            if (service.equalsIgnoreCase("changePrivateInfo")) {
                serviceChangeInfoPrivateProfile(request, response);
            }

            //Upload profile image
            if (service.equalsIgnoreCase("uploadProfileImage")) {
                serviceUploadProfileImage(request, response);
            }
            //Update
            if (service.equalsIgnoreCase("updateProfileImage")) {
                serviceUpdateProfileImage(request, response);
            }
            
            //Upload background image
            if (service.equalsIgnoreCase("uploadBackgroundImage")) {
                serviceUploadBackgroundImage(request, response);
            }
            //Update
            if (service.equalsIgnoreCase("updateBackgroundImage")) {
                serviceUpdateBackgroundImage(request, response);
            }
        }
    }

    public void serviceLogin(HttpServletRequest request, HttpServletResponse response) {
        String checkLogin = "checked";
        request.setAttribute("checkLogin", checkLogin);
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
            request.setAttribute("userName", userName);
            request.setAttribute("userPass", userPass);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
    }

    public void serviceLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        sendDispatcher(request, response, "index.jsp");
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
            HttpSession session = request.getSession();
            session.setAttribute("currUser", user);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
    }

    public void serviceChangePassword(HttpServletRequest request, HttpServletResponse response) {
        String mess3 = "";

        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("currUser");

        String user = account.getUsername();
        String xUser = request.getParameter("username");
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");

//        if (!newpass.equals(repass)) {
//            mess3 = "You are only have permission to change pass of your own account";
//        } else 
        if (!account.getPassword().equals(oldpass)) {
            mess3 = "Old Password is not correct";
        } else {
            daoUser.changePassword(user, newpass);
            mess3 = "Change password successfully !!";
        }
        request.setAttribute("mess3", mess3);
        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
//        request.setAttribute("mess", mess);
//        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
    }

    public void serviceRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkRegis = "checked";
        request.setAttribute("checkRegis", checkRegis);
        String mess2 = "";
        String Username = request.getParameter("signupusername");
        String Password = request.getParameter("signuppass");
        String Repassword = request.getParameter("resignuppass");
        String fullname = request.getParameter("fname");
        String Email = request.getParameter("email");
        String Phone = request.getParameter("phone");
        request.setAttribute("Username", Username);
        request.setAttribute("Password", Password);
        request.setAttribute("Repassword", Repassword);
        request.setAttribute("fullname", fullname);
        request.setAttribute("Email", Email);
        request.setAttribute("Phone", Phone);

        if (!Password.equals(Repassword)) {
            request.setAttribute("mess2", "Password must be same as repeat password");
            request.getRequestDispatcher("login.jsp").include(request, response);
            return;
        }

        boolean exist = daoUser.checkExistUserName(Username);
        if (exist == false) {
            daoUser.singup(Username, Password, Email, Phone, fullname);
            mess2 = "Signup Successfully!";
            request.setAttribute("mess2", mess2);
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
//            daoUser.singup(username, password, email, phone, fname);
//            mess = "Signup Successfully!";
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("loginAndSecurity/login.jsp").forward(request, response);
            return;
        } else {
            mess2 = "Duplicate user!";
            request.setAttribute("mess2", mess2);
        }
        request.setAttribute("Username", Username);
        request.setAttribute("Password", Password);
        request.setAttribute("Repassword", Repassword);
        request.setAttribute("fullname", fullname);
        request.setAttribute("Email", Email);
        request.setAttribute("Phone", Phone);
//        request.getRequestDispatcher("jsp/login.jsp").include(request, response);
        request.getRequestDispatcher("loginAndSecurity/login.jsp").include(request, response);
    }

    public void serviceInfo(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/profile.jsp");
    }

    private void serviceEditProfile(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/editProfile.jsp");
    }

    private void serviceChangeInfoPublicProfile(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        User u = x;
        u.setUsername(request.getParameter("username"));
        u.setBio(request.getParameter("bio"));
        u.setGender(Integer.parseInt(request.getParameter("gender")));
        u.setDOB(Date.valueOf(request.getParameter("dob")));
        u.setAddress(request.getParameter("address"));
        u.setFacebook(request.getParameter("Facebook"));
        u.setInstagram(request.getParameter("Instagram"));
        u.setTwitter(request.getParameter("Twitter"));
        u.setYoutube(request.getParameter("Youtube"));
        daoUser.updatePublicInfo(u);
        System.out.println(daoUser.updateInfoUserByAdmin(u));
        int currentUserID = Integer.parseInt(x.getUserId());
        request.getSession().setAttribute("currUser", daoUser.getUserById(currentUserID));
        sendDispatcher(request, response, "UserControllerMap?service=info");
    }

    private void serviceAccount(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/account.jsp");
    }

    private void serviceEditPrivateProfile(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/editPrivateProfile.jsp");
    }

    private void serviceChangeInfoPrivateProfile(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String pass = request.getParameter("pass");

        if (daoUser.checkExistMail(mail) && !mail.equals(x.getEmail())) {
            mess = "This email is already in use by another account";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editPrivateProfile.jsp");
        }
        if (daoUser.checkExistPhone(phone) && !phone.equals(x.getPhoneNumber())) {
            mess = "This phone number is already in use by another account";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editPrivateProfile.jsp");
        }
        if (x.getPassword().equals(pass)) {
            User u = x;
            u.setFullname(name);
            u.setEmail(mail);
            u.setPhoneNumber(phone);
            daoUser.updatePrivateInfo(u);
            int currentUserID = Integer.parseInt(x.getUserId());
            request.getSession().setAttribute("currUser", daoUser.getUserById(currentUserID));
            sendDispatcher(request, response, "UserControllerMap?service=account");
        } else {
            mess = "You must enter the correct password";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editPrivateProfile.jsp");
        }
    }

    private void serviceUploadProfileImage(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/uploadProfileImage.jsp");
    }

    private void serviceUpdateProfileImage(HttpServletRequest request, HttpServletResponse response) {
        String filename = null;
        // Create a factory for disk-based file items
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    fields.put(item.getFieldName(), item.getString());
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name + " " + value);
                } else {
                    filename = item.getName();
                    if (filename == null || filename.equals("")) {
                        break;
                    } else {
                        Path path = Paths.get(filename);
                        String storePath = servletContext.getRealPath("/upload");
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        item.write(uploadFile);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        User x = (User) request.getSession().getAttribute("currUser");
        x.setProfileImage(filename);
        daoUser.uploadprofileImage(x, filename);
        request.getSession().setAttribute("currUser", x);
        sendDispatcher(request, response, "UserControllerMap?service=info");
    }

    private void serviceUploadBackgroundImage(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/uploadBackgroundImage.jsp");
    }

    private void serviceUpdateBackgroundImage(HttpServletRequest request, HttpServletResponse response) {
        String filename = null;
        // Create a factory for disk-based file items
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    fields.put(item.getFieldName(), item.getString());
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name + " " + value);
                } else {
                    filename = item.getName();
                    if (filename == null || filename.equals("")) {
                        break;
                    } else {
                        Path path = Paths.get(filename);
                        String storePath = servletContext.getRealPath("/upload");
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        item.write(uploadFile);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        User x = (User) request.getSession().getAttribute("currUser");
        x.setBackgroundImage(filename);
        daoUser.uploadBackgroundImage(x, filename);
        request.getSession().setAttribute("currUser", x);
        sendDispatcher(request, response, "UserControllerMap?service=info");
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

    public void sendDispatcherInclude(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.include(request, response);

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
