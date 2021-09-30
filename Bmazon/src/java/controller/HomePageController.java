/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
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
import model.ProductDAO;
import model.CategoryDAO;
import model.GenreDAO;
import entity.Genre;
import java.util.List;
import model.DBConnection;

/**
 *
 * @author Admin
 */
public class HomePageController extends HttpServlet {

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
    CategoryDAO cateDAO = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ProductDAO proDAO = new ProductDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");
            if (service == null) {
                service = "Homepage";
            }
            if (service.equalsIgnoreCase("Homepage")) {
                serviceHomepage(request, response);
            }

            if (service.equalsIgnoreCase("list")) {
                serviceList(request, response);
            }
            if (service.equalsIgnoreCase("ByCate")) {
                serviceByCate(request, response);
            }
            if (service.equalsIgnoreCase("ByGenre")) {
                serviceByGenre(request, response);
            }
             if (service.equalsIgnoreCase("search")) {
                serviceSearch(request, response);
            }
        }
    }

    public void serviceHomepage(HttpServletRequest request, HttpServletResponse response) {
        List<Category> cateList = cateDAO.getTrueCategories();
        List<Genre> gerneList = genDAO.getTrueGenres();
        List<Product> ListSale = proDAO.getProductSale();
        List<Product> ListNew = proDAO.getProductNew();
        List<Product> ListApple = proDAO.getProductApple();
        List<Product> ListSuggest = proDAO.getProducSuggest();
        request.setAttribute("cateList", cateList);
        request.setAttribute("gerneList", gerneList);
        request.setAttribute("ListSale", ListSale);
        request.setAttribute("ListNew", ListNew);
        request.setAttribute("listApple", ListApple);
        request.setAttribute("listSuggest", ListSuggest);
        sendDispatcher(request, response, "/index.jsp");

    }

    public void serviceList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> ListP = proDAO.getTrueProduct();
        request.setAttribute("listP", ListP);

        sendDispatcher(request, response, "/list.jsp");

    }

    public void serviceByCate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("cid"));
        List<Product> ListP = proDAO.getProductByCategory(id);
        request.setAttribute("listP", ListP);
        sendDispatcher(request, response, "/list.jsp");

    }

    public void serviceByGenre(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("gid"));
        List<Product> ListP = proDAO.getProductByGenre(id);
        request.setAttribute("listP", ListP);
        sendDispatcher(request, response, "/list.jsp");

    }
     public void serviceSearch(HttpServletRequest request, HttpServletResponse response) {
        String str=request.getParameter("search");
        List<Product> ListP = proDAO.getProductByName(str);
        request.setAttribute("listP", ListP);
        sendDispatcher(request, response, "/list.jsp");

    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
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
