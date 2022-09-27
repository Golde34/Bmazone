/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import APIs.SendEmail;
import controller.EmployeeController;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author nguye
 */
public class EmployeeService {
    
    OrderDetailDAO daoOrderDetail = new OrderDetailDAO();
    OrderDAO daoorder = new OrderDAO();
    ProductCategoryDAO daopc = new ProductCategoryDAO();
    ProductGenreDAO daopg = new ProductGenreDAO();
    SellerDAO daoseller = new SellerDAO();
    GalleryDAO daogallery = new GalleryDAO();
    ShipCompanyDAO daocompany = new ShipCompanyDAO();
    ProductDAO daoproduct = new ProductDAO();
    ProductTypeDAO daoproducttype = new ProductTypeDAO();
    CategoryDAO daocategory = new CategoryDAO();
    GenreDAO daogenre = new GenreDAO();
    UserDAO daouser = new UserDAO();
    WareHouseDAO daowarehouse = new WareHouseDAO();
    RoleDAO daorole = new RoleDAO();
    TransactionDAO daotransaction = new TransactionDAO();
    
    public void serviceTopUpResponse(String service, HttpServletRequest request, HttpServletResponse response) {
        List<Transaction> listTransactionPaging = daotransaction.getAllPagingTransaction(1, 5, "");
        List<Transaction> listRequestTransaction = daotransaction.getAllTransaction();
        int totalPage = listRequestTransaction.size() / 5;
        if (listRequestTransaction.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listTransaction", listTransactionPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "employee/topUpResponse.jsp");
    }

    public void servicePagingTopUpResponse(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        DecimalFormat nf = new DecimalFormat("###,###,###");
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
        List<Transaction> listPaging = daotransaction.getAllPagingTransaction(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listTransaction", listPaging);
        for (Transaction transaction : listPaging) {
            pr.print("<tr>"
                    + "<td>" + daouser.getUserById(transaction.getUserID()).getFullname() + " </td>"
                    + "<td>" + transaction.getHistory() + "</td>"
                    + "<td>" + daouser.getUserById(transaction.getUserID()).getPhoneNumber() + "</td>"
                    + "<td>" + nf.format(transaction.getMoney()) + "</td>");
            if (transaction.getState() == 1) {
                pr.print("<td>Deposit</td>");
            } else {
                pr.print("<td>Withdrawal</td>");
            }
            pr.print("<td style='white-space: nowrap'>"
                    + "<a href=\"EmployeeControllerMap?service=accepttopup&transactionID=" + transaction.getTransactionID() + "\" onclick=\"return confirm('Are you sure?');\"><button style='margin-right:4px' class=\"btn btn-primary\">Accept</button></a>"
                    + "<a href=\"EmployeeControllerMap?service=denytopup&transactionID=" + transaction.getTransactionID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Refuse</button></a>"
                    + "</td>");
            pr.print("</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "employee/topUpResponse.jsp");
        }
    }

    public void serviceShowPageTopUpResponse(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daotransaction.getPageNumber(search);
        int totalPage = totalResult / numOfRow;

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
            sendDispatcher(request, response, "employee/topUpResponse.jsp");
        }
    }

    public void serviceAcceptTopUpRequest(String service, HttpServletRequest request, HttpServletResponse response) {
        DecimalFormat nf = new DecimalFormat("###,###,###");
        SendEmail s = new SendEmail();
        HttpSession session = request.getSession();
        User x = (User) request.getSession().getAttribute("currUser");
        request.setAttribute("service", service);
        int transactionid = Integer.parseInt(request.getParameter("transactionID"));
        daotransaction.acceptTopUpRequest(transactionid);

        User u = daouser.getUserById(daotransaction.getTransactionByTransactionID(transactionid).getUserID());
        double money = daotransaction.getTransactionByTransactionID(transactionid).getMoney();
        
        String option = "topup";
        if (daotransaction.getTransactionByTransactionID(transactionid).getState() == 1) {
            daouser.depositWalletUser(u, money);
            String text1 = "Deposit: " + nf.format(money) + ".";
            s.sendEmail(u.getUsername(), u.getEmail(), text1, option);
        } else {
            daouser.withdrawalWalletUser(u, money);
            String text2 = "Withdrawal: " + nf.format(money) + ".";
            s.sendEmail(u.getUsername(), u.getEmail(), text2, option);
        }
        
        session.setAttribute("currUser", daouser.getUserById(x.getUserId()));

        List<Transaction> listTransactionPaging = daotransaction.getAllPagingTransaction(1, 5, "");
        List<Transaction> listRequestTransaction = daotransaction.getAllTransaction();
        int totalPage = listRequestTransaction.size() / 5;
        if (listRequestTransaction.size() > 5) {
            totalPage += 1;
        }

        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listTransaction", listTransactionPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "employee/topUpResponse.jsp");
    }

    public void serviceDenyTopUpRequest(String service, HttpServletRequest request, HttpServletResponse response) {
        DecimalFormat nf = new DecimalFormat("###,###,###");
        SendEmail s = new SendEmail();
        request.setAttribute("service", service);
        int transactionid = Integer.parseInt(request.getParameter("transactionID"));
        daotransaction.denyTopUpRequest(transactionid);
        
        User u = daouser.getUserById(daotransaction.getTransactionByTransactionID(transactionid).getUserID());
        double money = daotransaction.getTransactionByTransactionID(transactionid).getMoney();
        
        String option = "denytopup";
        if (daotransaction.getTransactionByTransactionID(transactionid).getState() == 1) {
            String text1 = "Deposit: " + nf.format(money) + ".";
            s.sendEmail(u.getUsername(), u.getEmail(), text1, option);
        }else{
            String text2 = "Withdrawal: " + nf.format(money) + ".";
            s.sendEmail(u.getUsername(), u.getEmail(), text2, option);
        }

        List<Transaction> listTransactionPaging = daotransaction.getAllPagingTransaction(1, 5, "");
        List<Transaction> listRequestTransaction = daotransaction.getAllTransaction();
        int totalPage = listRequestTransaction.size() / 5;
        if (listRequestTransaction.size() > 5) {
            totalPage += 1;
        }

        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listTransaction", listTransactionPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "employee/topUpResponse.jsp");
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
