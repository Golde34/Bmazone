/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import APIs.SecurePBKDF2;
import static APIs.SecurePBKDF2.validatePassword;
import APIs.SendEmail;
import entity.Category;
import entity.Comment;
import entity.Seller;
import entity.Transaction;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.text.DecimalFormat;
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
import model.CategoryDAO;
import model.CommentDAO;
import model.UserDAO;
import model.DBConnection;
import model.SellerDAO;
import model.TransactionDAO;
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
    CommentDAO daoComment = new CommentDAO();
    TransactionDAO daoTransaction = new TransactionDAO();
    CategoryDAO daoCategory = new CategoryDAO();

    private static final long serialVersionUID = 1;

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

            //verify wallet deposit
            if (service.equalsIgnoreCase("verifyWalletDeposit")) {
                serviceVerifyWalletDeposit(request, response);
            }

            //verify wallet withdrawal
            if (service.equalsIgnoreCase("verifyWalletWithdrawal")) {
                serviceVerifyWalletWithdrawal(request, response);
            }

            //deposit wallet
            if (service.equalsIgnoreCase("deposit")) {
                serviceDeposit(request, response);
            }

            //withdrawal wallet
            if (service.equalsIgnoreCase("withdrawal")) {
                serviceWithdrawal(request, response);
            }

            //history transaction
            if (service.equalsIgnoreCase("historyTransaction")) {
                serviceHistoryTransaction(service, request, response);
            }

            //paging history transaction
            if (service.equalsIgnoreCase("pagingtransaction")) {
                servicePagingTransaction(service, request, response);
            }

            //show page history transaction
            if (service.equalsIgnoreCase("showpagetransaction")) {
                serviceShowPageTransaction(service, request, response);
            }

            //Turn on seller feature
            if (service.equalsIgnoreCase("turnOnSalesFeature")) {
                serviceTurnOnSalesFeature(request, response);
            }
            //Submit request seller
            if (service.equalsIgnoreCase("requestSeller")) {
                serviceSellerRequest(request, response);
            }
            //Denied request
            if (service.equalsIgnoreCase("editDeniedSellerInformation")) {
                serviceEditDenied(request, response);
            }

            //List all comments
            if (service.equalsIgnoreCase("listAllComments")) {
                serviceListComment(request, response);
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
        boolean matched = false;
        if (oldpass != null) {
            matched = validatePassword(oldpass, account.getPassword());
        }
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

//        HttpSession session = request.getSession();
//        User account = (User) session.getAttribute("currUser");
//        String user = account.getUsername();
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
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        sendDispatcher(request, response, "user/editWallet.jsp");
    }

    private void serviceVerifyWalletDeposit(HttpServletRequest request, HttpServletResponse response) {
        // get code user submit
        HttpSession session = request.getSession();
        String verifyCode = request.getParameter("verifyCode");
        String mess = "";

        User x = (User) session.getAttribute("currUser");

        //get code generated
        String authCode = (String) session.getAttribute("authcode");
        double amount = (double) session.getAttribute("amount");

        if (verifyCode.equals(authCode)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Transaction t = new Transaction(x.getUserId(), amount, dtf.format(now), 1);
            daoTransaction.insertTransaction(t);
            mess = "Please wait for acceptance!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=editWallet");
        } else {
            mess = "Verification code is not right!";
            request.setAttribute("verifyCode", verifyCode);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/verifyWalletDeposit.jsp");
        }
    }

    private void serviceVerifyWalletWithdrawal(HttpServletRequest request, HttpServletResponse response) {
        // get code user submit
        HttpSession session = request.getSession();
        String verifyCode = request.getParameter("verifyCode");
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");

        //get code generated
        String authCode = (String) session.getAttribute("authcode");
        double amount = (double) session.getAttribute("amount");

        if (verifyCode.equals(authCode)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Transaction t = new Transaction(x.getUserId(), amount, dtf.format(now), 2);
            daoTransaction.insertTransaction(t);
            //daoUser.withdrawalWalletUser(x, amount);
            //request.getSession().setAttribute("currUser", daoUser.getUserById(x.getUserId()));
            mess = "Please wait for acceptance!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=editWallet");
        } else {
            mess = "Verification code is not right!";
            request.setAttribute("verifyCode", verifyCode);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/verifyWalletWithdrawal.jsp");
        }
    }

    private void serviceDeposit(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String mess = "";
        double amount = Double.parseDouble(request.getParameter("amount"));
        User x = (User) session.getAttribute("currUser");
        if (amount == 0 || amount > 100000000) {
            mess = "Please input amount more than 0 and less than 100000000.";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editWallet.jsp");
        } else {
            String option = "editwallet";
            SendEmail sm = new SendEmail();
            String code = sm.getRandom();
            sm.sendEmail(x.getUsername(), x.getEmail(), code, option);
            session.setAttribute("authcode", code);
            session.setAttribute("amount", amount);
            sendDispatcher(request, response, "user/verifyWalletDeposit.jsp");
        }
    }

    private void serviceWithdrawal(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String mess = "";
        double amount = Double.parseDouble(request.getParameter("amount"));
        User x = (User) session.getAttribute("currUser");
        if (amount == 0) {
            mess = "Please input amount more than 0.";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editWallet.jsp");
        } else if (amount > x.getWallet()) {
            mess = "Your wallet does not have enough money.";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "user/editWallet.jsp");
        } else {
            String option = "editwallet";
            SendEmail sm = new SendEmail();
            String code = sm.getRandom();
            sm.sendEmail(x.getUsername(), x.getEmail(), code, option);
            session.setAttribute("authcode", code);
            session.setAttribute("amount", amount);
            sendDispatcher(request, response, "user/verifyWalletWithdrawal.jsp");
        }
    }

    private void serviceHistoryTransaction(String service, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("currUser");
        ArrayList<Transaction> listHistoryTransactionPaging = daoTransaction.getAllPagingTransactionByUser(1, 5, "", x.getUserId());
        ArrayList<Transaction> listTransaction = daoTransaction.getTransactionByUserID(Integer.parseInt(x.getUserId()));
        int totalPage = listTransaction.size() / 5;
        if (listTransaction.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listHistoryTransaction", listHistoryTransactionPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "user/historyTransaction.jsp");
    }

    public void servicePagingTransaction(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        DecimalFormat nf = new DecimalFormat("###,###,###");
        HttpSession session = request.getSession();
        User x = (User) session.getAttribute("currUser");
        PrintWriter pr = response.getWriter();
        request.setAttribute("service", service);
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        ArrayList<Transaction> listPaging = daoTransaction.getAllPagingTransactionByUser(index, numOfRow, search, x.getUserId());
        request.setAttribute("index", index);
        request.setAttribute("listTransaction", listPaging);
        for (Transaction transaction : listPaging) {
            pr.print("<tr>"
                    + "<td style=\"width: 25%; text-align: center;\">" + transaction.getHistory() + " </td>"
                    + "<td style=\"width: 25%; text-align: center;\">" + nf.format(transaction.getMoney()) + " </td>"
                    );
            if (transaction.getState() == 1) {
                pr.print("<td style=\"width: 25%; text-align: center;\">Deposit</td>");
            } else {
                pr.print("<td style=\"width: 25%; text-align: center;\">Withdrawal</td>");
            }
            if (transaction.getStatus() == 0) {
                pr.print("<td style=\"width: 25%; text-align: center;\"><span style=\"color: red; font-weight: bold;\">Failed</span></td>");
            } else if (transaction.getStatus() == 1) {
                pr.print("<td style=\"width: 25%; text-align: center;\"><span style=\"color: green; font-weight: bold;\">Successfully</span></td>");
            } else {
                pr.print("<td style=\"width: 25%; text-align: center;\"><span style=\"color: blueviolet; font-weight: bold;\">Pending</span></td>");
            }
            pr.print("</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "user/historyTransaction.jsp");
        }
    }

    public void serviceShowPageTransaction(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daoTransaction.getPageNumber(search);
        int totalPage = totalResult / numOfRow;
        if (totalResult != numOfRow * totalPage) {
            totalPage += 1;
        }
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;
        if (totalResult > numOfRow) {
            pr.print("<li data-repair=\"1\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"First\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-backward\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            pr.print("<li data-repair=\"" + prev + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Previous\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-arrow-left\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            for (int i = 1; i <= totalPage; i++) {
                if (i < index - 2) {
                    continue;
                }
                if (index < 3) {
                    if (i > 5) {
                        break;
                    }
                } else {
                    if (i > index + 2) {
                        break;
                    }
                }
                if (index == i) {
                    pr.print("<li  class=\"page-item active\" data-repair=\"" + i + "\">");
                } else {
                    pr.print("<li  class=\"page-item\" data-repair=\"" + i + "\">");
                }
                pr.print("<a class=\"page-link\">");
                pr.print("<div class=\"index\">" + i + "</div>");
                pr.print("<span class=\"sr-only\">(current)</span>");
                pr.print("</a>");
                pr.print("</li>");
            }
            pr.print("<li data-repair=\"" + next + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Next\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-arrow-right\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
            pr.print("<li data-repair=\"" + totalPage + "\" class=\"page-item\">");
            pr.print("<a class=\"page-link\" aria-label=\"Last\">");
            pr.print("<span aria-hidden=\"true\"><i class=\"fas fa-forward\"></i>");
            pr.print("<span class=\"sr-only\">(current)</span> ");
            pr.print("</span>");
            pr.print("</a>");
            pr.print("</li>");
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "user/historyTransaction.jsp");
        }
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
            int verification = 0;
            Seller sel = new Seller(userID, shopName, sellerPhone, evidence, sellerMainProduct, "", verification);
            daoSeller.addSeler(sel);
            mess = "Waiting for adminstrator to verify your registration certificate...";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }
    }

    private void serviceEditDenied(HttpServletRequest request, HttpServletResponse response) {
        String mess = "";

        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        Seller seller = daoSeller.getSellerByUserID(Integer.parseInt(x.getUserId()));

        String shopName = request.getParameter("shopName");
        String sellerPhone = request.getParameter("sellerPhone");
        String evidence = request.getParameter("evidence");
        int sellerMainProduct = Integer.parseInt(request.getParameter("sellerMainProduct"));

        boolean isExist = false;

        if (daoSeller.checkExistPhone(sellerPhone) && !sellerPhone.equalsIgnoreCase(seller.getSellerPhone())) {
            isExist = true;
            mess = "This phone number is already in use by another account";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }

        if (isExist == false) {
            seller.setSellerShopName(shopName);
            seller.setSellerPhone(sellerPhone);
            seller.setEvidence(evidence);
            seller.setSellerMainProduct(sellerMainProduct);
            seller.setSellerVerification(0);
            daoSeller.editSeller(seller);
            mess = "Update successfully!";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "UserControllerMap?service=turnOnSalesFeature");
        }
    }

    private void serviceListComment(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("currUser", x);
        ArrayList<Comment> comments = daoComment.getCommentsByUserId(Integer.parseInt(x.getUserId()));
        request.setAttribute("listComment", comments);
        sendDispatcher(request, response, "user/comments.jsp");
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
