/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Comment;
import entity.Gallery;
import entity.Product;
import entity.ProductType;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CommentDAO;
import model.DBConnection;
import model.GalleryDAO;
import model.ProductDAO;
import model.ProductTypeDAO;

/**
 *
 * @author AD
 */
public class ProductDetailController extends HttpServlet {

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
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    DBConnection dbCon = new DBConnection();
    ProductDAO daoProduct = new ProductDAO();
    GalleryDAO daoGallery = new GalleryDAO();
    ProductTypeDAO daoProductType = new ProductTypeDAO();
    CommentDAO daoComment = new CommentDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service == null) {
                service = "";
            }

            if (service.equalsIgnoreCase("getProductDetail")) {
                serviceProductDetail(request, response);
            }

            if (service.equalsIgnoreCase("getRelatedProduct")) {
                serviceRelatedProduct(request, response);
            }

            if (service.equalsIgnoreCase("getRelatedProduct")) {
                serviceRelatedProduct(request, response);
            }
            if (service.equalsIgnoreCase("getPrice")) {
                serviceGetPrice(request, response);
            }
        }
    }

    public void serviceProductDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("pid"));
        Product product = daoProduct.getProductByID(id);
        request.setAttribute("product", product);
        List<Gallery> listGallery = daoGallery.getAllGalleryOfProduct(id);
        request.setAttribute("listGallery", listGallery);
        List<ProductType> listProductType = daoProductType.getProductByProductID(id);
        request.setAttribute("listProductType", listProductType);
        ArrayList<Product> listRelated = daoProduct.getRelatedProductByProductID(id);
        request.setAttribute("listRelated", listRelated);
        ArrayList<String> listSize = daoProductType.getAllSizeOfProduct(id);
        request.setAttribute("listSize", listSize);
        ArrayList<String> listColor = daoProductType.getAllColorOfProduct(id);
        request.setAttribute("listColor", listColor);
        ArrayList<Comment> comments = daoComment.getCommentsByProductId(id);
        request.setAttribute("comments", comments);
        int count = 0;
        for (Comment comment : comments) {
            count++;
        }
        request.setAttribute("count", count);
        sendDispatcher(request, response, "product/productDetail.jsp");
    }

    public void serviceRelatedProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("pid"));
        Product product = daoProduct.getProductByID(id);
        request.setAttribute("product", product);
        List<Gallery> listGallery = daoGallery.getAllGalleryOfProduct(id);
        request.setAttribute("listGallery", listGallery);
        List<ProductType> listProductType = daoProductType.getProductByProductID(id);
        request.setAttribute("listProductType", listProductType);
        ArrayList<Product> listRelated = daoProduct.getRelatedProductByProductID(id);
        request.setAttribute("listRelated", listRelated);
        sendDispatcher(request, response, "product/relatedProduct.jsp");
    }

    private void serviceGetPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String productId = request.getParameter("pid");
        ProductType pt = daoProductType.getProductTypeByColorAndSize(color, size, productId);
        DecimalFormat nf = new DecimalFormat("###,###,###");
        Double price = Double.parseDouble(pt.getPrice());
        String price1 = nf.format(price);
        pr.print(price1);
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
