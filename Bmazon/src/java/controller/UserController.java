/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import APIs.SecurePBKDF2;
import static APIs.SecurePBKDF2.validatePassword;
import entity.Seller;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
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
import model.SellerDAO;
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
    SellerDAO daoSeller = new SellerDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "info";
            }

            //Logout service
            if (service.equalsIgnoreCase("logout")) {
                serviceLogout(request, response);
            }

            //change pass
            if (service.equalsIgnoreCase("changepass")) {
                serviceChangePassword(request, response);
            }

            //
            if (service.equalsIgnoreCase("changepassPage")) {
                serviceChangePasswordPage(request, response);
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

            //edit wallet
            if (service.equalsIgnoreCase("editWallet")) {
                serviceEditWallet(request, response);
            }
            //Turn on seller feature
            if (service.equalsIgnoreCase("turnOnSalesFeature")) {
                serviceTurnOnSalesFeature(request, response);
            }
            //Submit erquest seller
            if (service.equalsIgnoreCase("requestSeller")) {
                serviceSellerRequest(request, response);
            }
        }
    }

    public void serviceLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        sendDispatcher(request, response, "index.jsp");
    }

    public void serviceChangePassword(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String messChangepass = "";

        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("currUser");

        String user = account.getUsername();
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String repass = request.getParameter("renewpass");


        boolean matched = validatePassword(oldpass, account.getPassword());
        if (matched == false && oldpass != null) {
            messChangepass = "Old Password is not correct";
            request.setAttribute("oldpassChange", oldpass);
            request.setAttribute("newpassChange", newpass);
            request.setAttribute("renewpassChange", repass);
        } else if (matched == true && oldpass != null && newpass.equals(repass)) {
            String securePassword = SecurePBKDF2.generateStrongPasswordHash(newpass);
            daoUser.changePassword(user, securePassword);
            messChangepass = "Change password successfully !!";
        }
        request.setAttribute("messChangepass", messChangepass);
        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
//        request.setAttribute("mess", mess);
//        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
    }
    
    public void serviceChangePasswordPage(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String messChangepass = "";

        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("currUser");

        String user = account.getUsername();
        request.setAttribute("messChangepass", messChangepass);
        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
//        request.setAttribute("mess", mess);
//        sendDispatcher(request, response, "loginAndSecurity/changepass.jsp");
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
        u.setPublicName(request.getParameter("username"));
        u.setBio(request.getParameter("bio"));
        u.setGender(Integer.parseInt(request.getParameter("gender")));
        u.setDOB(Date.valueOf(request.getParameter("dob")));
        u.setOccupation(request.getParameter("occupation"));
        u.setAddress(request.getParameter("address"));
        u.setFacebook(request.getParameter("Facebook"));
        u.setInstagram(request.getParameter("Instagram"));
        u.setTwitter(request.getParameter("Twitter"));
        u.setYoutube(request.getParameter("Youtube"));
        daoUser.updatePublicInfo(u);
        System.out.println(daoUser.updateInfoUserByAdmin(u));
        String currentUserID = x.getUserId();
        request.getSession().setAttribute("currUser", daoUser.getUserById(currentUserID));
        sendDispatcher(request, response, "UserControllerMap?service=info");
    }

    private void serviceAccount(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "account.jsp");
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
            System.out.println(u.getPassword() + u.getFullname());
            String currentUserID = x.getUserId();
            request.getSession().setAttribute("currUser", daoUser.getUserById(currentUserID));
            mess = "Change private information successfully!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editPrivateProfile.jsp");
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

    private void serviceEditWallet(HttpServletRequest request, HttpServletResponse response) {
        String amount = request.getParameter("amount");
        String mess = "";
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);

        sendDispatcher(request, response, "user/editWallet.jsp");
    }

    private void serviceTurnOnSalesFeature(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/sellerRequest.jsp");
    }

    private void serviceSellerRequest(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        int userID = Integer.parseInt(x.getUserId());
        String shopName = request.getParameter("shopName");
        String sellerPhone = request.getParameter("sellerPhone");
        String evidence = request.getParameter("evidence");
        int sellerMainProduct = Integer.parseInt(request.getParameter("sellerMainProduct"));

        boolean isExist = false;

        if (daoSeller.checkExistPhone(sellerPhone)) {
            isExist = true;
            mess = "This phone number is already in use by another account";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }

        if (daoSeller.checkExistUserID(userID)) {
            isExist = true;
            mess = "You are already request sales feature.";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }

        if (isExist == false) {
            Seller sel = new Seller(userID, shopName, sellerPhone, evidence, sellerMainProduct, "", 0);
            //Response seller (Admin work)
            User u = x;
            u.setSell(1);
            u.setSystemRole(2);
            daoUser.updateInfoUserByAdmin(u);
            //End
            daoSeller.addSeler(sel);
            mess = "Waiting for adminstrator to verify your registration certificate...";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
