/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import APIs.SecurePBKDF2;
import static APIs.SecurePBKDF2.validatePassword;
import APIs.SendEmail;
import controller.UserController;
import entity.CartItem;
import entity.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartItemDAO;
import model.DBConnection;
import model.UserDAO;

/**
 *
 * @author nguye
 */
public class LoginService {
    
    DBConnection dbCon = new DBConnection();
    UserDAO daoUser = new UserDAO();
    CartItemDAO cartDAO= new CartItemDAO();
    
    //    public void sendEmail(String toEmail, String subject, String body) {
//        try {
//            Properties props = new Properties();
//            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//            props.put("mail.smtp.port", "587"); //TLS Port
//            props.put("mail.smtp.auth", "true"); //enable authentication
//            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//            Authenticator auth = new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(fromEmail, password);
//                }
//            };
//            Session session = Session.getInstance(props, auth);
//            MimeMessage msg = new MimeMessage(session);
//            //set message headers
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//            msg.setFrom(new InternetAddress(fromEmail, "Quiz Practice System"));
//            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
//            msg.setSubject(subject, "UTF-8");
//            msg.setText(body, "UTF-8");
//            msg.setSentDate(new Date());
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//            Transport.send(msg);
////            System.out.println("Gui mail thanh cong");
//        } catch (MessagingException ex) {
//            Logger.getLogger(SystemEmail.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(SystemEmail.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }\
    public void serviceLogin(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        String checkLogin = "checked";
//        request.setAttribute("checkLogin", checkLogin);
        HttpSession session = request.getSession();
        String userName = request.getParameter("username");
        String messLogin = "";
        String userPass = request.getParameter("password");
        User log = daoUser.getUserByUsername(userName);

        if (log != null) {
            boolean matched = validatePassword(userPass, log.getPassword());
            if (matched == true) {
                session.setAttribute("currUser", log);
                session.setAttribute("role", log.getSystemRole());
                ArrayList<CartItem> ShoppingCart = new ArrayList<>();
                if (cartDAO.getCartByID(Integer.parseInt(log.getUserId()))!=null ) {
                    ShoppingCart= cartDAO.getCartByID(Integer.parseInt(log.getUserId()));
                }
                
                session.setAttribute("ShoppingCart", ShoppingCart);
                sendDispatcher(request, response, "index.jsp");
            } else {
                messLogin = "Login failed, check your username or your password.";
                request.setAttribute("usernameLogin", userName);
                request.setAttribute("userpassLogin", userPass);
                request.setAttribute("mess", messLogin);
                sendDispatcher(request, response, "loginAndSecurity/login.jsp");
            }
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
        HttpSession session = request.getSession();
        String messRegis = "";
        String Username = request.getParameter("signupusername");
        String Password = request.getParameter("signuppass");
        String Repassword = request.getParameter("resignuppass");
        String fullname = request.getParameter("fname");
        String Email = request.getParameter("email");
        String Phone = request.getParameter("phone");

//        if (!Password.equals(Repassword)) {
//            request.setAttribute("mess", "Password must be same as repeat password");
//            request.setAttribute("usernameRegis", Username);
//            request.setAttribute("passwordRegis", Password);
//            request.setAttribute("repasswordRegis", Repassword);
//            request.setAttribute("fullnameRegis", fullname);
//            request.setAttribute("emailRegis", Email);
//            request.setAttribute("phoneRegis", Phone);
//            request.getRequestDispatcher("loginAndSecurity/register.jsp").include(request, response);
//            return;
//        }

        boolean isExist = false;
        if (daoUser.checkExistUserName(Username) == true) {
            messRegis = "Duplicate username!";
            isExist = true;
        } else if (daoUser.checkExistMail(Email) == true) {
            messRegis = "Duplicate mail!";
            isExist = true;
        } else if (daoUser.checkExistPhone(Phone) == true) {
            messRegis = "Duplicate phone!";
            isExist = true;
        } else {
            isExist = false;
        }
        request.setAttribute("usernameRegis", Username);
        request.setAttribute("passwordRegis", Password);
        request.setAttribute("repasswordRegis", Repassword);
        request.setAttribute("fullnameRegis", fullname);
        request.setAttribute("emailRegis", Email);
        request.setAttribute("phoneRegis", Phone);
        request.setAttribute("mess", messRegis);
        if (isExist == false) {
            String option = "register";
            SendEmail sm = new SendEmail();
            //get the 6-digit code
            String code = sm.getRandom();

            //call the send email method
            boolean test = sm.sendEmail(Username, Email, code, option);
            //check if the email send successfully
            if (test == true) {
                session.setAttribute("usernameRegis", Username);
                session.setAttribute("passwordRegis", Password);
                session.setAttribute("repasswordRegis", Repassword);
                session.setAttribute("fullnameRegis", fullname);
                session.setAttribute("emailRegis", Email);
                session.setAttribute("phoneRegis", Phone);
                session.setAttribute("authcode", code);
                sendDispatcher(request, response, "loginAndSecurity/verify.jsp");
                // include: xu ly xong thang path quay lai, forward: ko quay lai.
            } else {
                request.setAttribute("mess", "Failed to send verification email");
                sendDispatcher(request, response, "loginAndSecurity/register.jsp");
            }
        } else {
            sendDispatcher(request, response, "loginAndSecurity/register.jsp");
        }
    }

    public void serviceVerifyAccount(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // get code user submit
        HttpSession session = request.getSession();
        String verifyCode = request.getParameter("veriCode");
        String messVeri = "";

        //get data from serviceRegister
        String Username = (String) session.getAttribute("usernameRegis");
        String Password = (String) session.getAttribute("passwordRegis");
//        String Repassword = (String) session.getAttribute("repasswordRegis"); //(fix FindBugs )
        String fullname = (String) session.getAttribute("fullnameRegis");
        String Email = (String) session.getAttribute("emailRegis");
        String Phone = (String) session.getAttribute("phoneRegis");

        String securePassword = SecurePBKDF2.generateStrongPasswordHash(Password);

        //get code generated
        String authCode = (String) session.getAttribute("authcode");
        if (verifyCode.equals(authCode)) {
            daoUser.addUser(new User(Username, securePassword, Email, Phone, 0, 0, fullname, Username, "", "", "", "", 0, "", "", "", "", "", 0, 0, 1));
            messVeri = "Signup Successfully!";
            request.setAttribute("mess", messVeri);
            sendDispatcher(request, response, "loginAndSecurity/register.jsp");
        } else {
            messVeri = "Verification code is not right!";
            request.setAttribute("veriCode", verifyCode);
            request.setAttribute("mess", messVeri);
            sendDispatcher(request, response, "loginAndSecurity/verify.jsp");
        }

    }

    public void serviceForgotPassword(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SendEmail s = new SendEmail();
        String mess = "";
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        session.setAttribute("username", username);
        String email = request.getParameter("mail");
        boolean exist = daoUser.checkExistUserNameAndMail(username, email);
        if (exist == true) {
            String option = "forgot";
            String href = "<a href = http://localhost:8080/Bmazon/loginAndSecurity/resetPass.jsp>Here</a>";
            boolean test = s.sendEmail(username, email, href, option);
            if (test == true) {
                session.setAttribute("usename", username);
                sendDispatcher(request, response, "loginAndSecurity/notification.jsp");
            } else {
                request.setAttribute("mess", "Failed to send reset email");
                sendDispatcher(request, response, "loginAndSecurity/forgot.jsp");
            }
        } else {
            mess = "Your username or your mail does not exist!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/forgot.jsp");
        }
    }

    public void serviceResetPassword(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {
        HttpSession session = request.getSession();
        String mess = "";
        String newPass = request.getParameter("newPass");
        String reNewPass = request.getParameter("reNewPass");
        String username = (String) session.getAttribute("username");
        if (!newPass.equals(reNewPass)) {
            mess = "New password and Re-new password do not match";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/resetPass.jsp");
        } else {
            String securePassword = SecurePBKDF2.generateStrongPasswordHash(newPass);
            daoUser.changePassword(username, securePassword);
            mess = "Reset password successfully!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "loginAndSecurity/login.jsp");
        }
    }

//    public void serviceGoogleLogin(HttpServletRequest request, HttpServletResponse response) {
//        String userName = "gg." + request.getParameter("username");
//        String messLogin = "";
//        String userPass = "guest";
//        User log = null;
//        log = new User(userName, userPass, userName, 0, "gg.guest", "gg.guest", 0, 1);
//        request.getSession().setAttribute("currUser", log);
//        request.getSession().setAttribute("role", log.getSystemRole());
//        ArrayList<CartItem> ShoppingCart = new ArrayList<>();
//        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
//        sendDispatcher(request, response, "index.jsp");
//    }
//
//    public void serviceFacebookLogin(HttpServletRequest request, HttpServletResponse response) {
//        String userName = "fb." + request.getParameter("username");
//        String messLogin = "";
//        String userPass = "guest";
//        User log = null;
//        log = new User(userName, userPass, "", 0, "fb.guest", "fb.guest", 0, 1);
//        request.getSession().setAttribute("currUser", log);
//        request.getSession().setAttribute("role", log.getSystemRole());
//        ArrayList<CartItem> ShoppingCart = new ArrayList<>();
//        request.getSession().setAttribute("ShoppingCart", ShoppingCart);
//        sendDispatcher(request, response, "index.jsp");
//    }
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
