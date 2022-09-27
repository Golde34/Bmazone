/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.HomePageController;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author nguye
 */
public class ProductDetailService {
    
    DBConnection dbCon = new DBConnection();
    ProductDAO daoProduct = new ProductDAO();
    GalleryDAO daoGallery = new GalleryDAO();
    ProductTypeDAO daoProductType = new ProductTypeDAO();
    CommentDAO daoComment = new CommentDAO();
    ViewDAO viewDAO = new ViewDAO();
    
    public void serviceProductDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("pid"));
        User x = (User) request.getSession().getAttribute("currUser");
        ArrayList<Comment> comments = daoComment.getCommentsByProductId(id);
        if (comments.size() > 0) {
            Product p = daoProduct.getProductByID(id);
            int updateRating = 0;
            for (Comment comment : comments) {
                updateRating += comment.getRating();
            }
            updateRating /= comments.size();
            p.setRating(updateRating);
            daoProduct.updateProduct(p);
        }
        if (x != null) {
            View view = viewDAO.getView(id, Integer.parseInt(x.getUserId()));
            if (view == null) {
                View insert = new View(Integer.parseInt(x.getUserId()), id, 1);
                viewDAO.insertClick(insert);
            } else {
                viewDAO.changeClick(view);

            }
        }
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
        request.setAttribute("comments", comments);
        int count = 0;
//        for (Comment comment : comments) {
//            count++;
//        }
        request.setAttribute("count", count);
        sendDispatcher(request, response, "product/productDetail.jsp");
    }

    public void serviceRelatedProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("pid"));
        int count = daoProduct.totalRelatedProduct(id);

        Product product = daoProduct.getProductByID(id);
        request.setAttribute("product", product);
        List<Gallery> listGallery = daoGallery.getAllGalleryOfProduct(id);
        request.setAttribute("listGallery", listGallery);
        List<ProductType> listProductType = daoProductType.getProductByProductID(id);
        request.setAttribute("listProductType", listProductType);

        int size = 10;
        int total = count / size;
        int page, end;

        String page1 = request.getParameter("page");
        if (page1 == null) {
            page = 1;

        } else {
            page = Integer.parseInt(page1);
        }
        int begin = page;
        String previous = "  <li><a class='' href=" + "ProductDetailControllerMap?service=getRelatedProduct&pid=" + id + "&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "ProductDetailControllerMap?service=getRelatedProduct&pid=" + id + "&page=" + (page + 1) + ">N</a></li>";

        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        } else {
            end = total;
            begin = total - 1 /* ban dau la total - 2*/;
        }
        if (page == 1) {
            request.setAttribute("next", next);
        } else if (page == total) {
            request.setAttribute("previous", previous);
        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }

        ArrayList<Product> listRelated = daoProduct.getRelatedProductByProductIDPaging(page, id);

        request.setAttribute("listRelated", listRelated);
        request.setAttribute("end", end);
        request.setAttribute("begin", begin);
        request.setAttribute("pid", id);
        request.setAttribute("count", count);

        sendDispatcher(request, response, "product/relatedProduct.jsp");
    }

    public void serviceGetPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    public void serviceComment(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("currUser");
        int id = Integer.parseInt(request.getParameter("pid"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String content = (String) request.getParameter("content");
        ArrayList<Comment> comments = daoComment.getCommentsByProductId(id);
        if (comments.size() > 0) {
            Product p = daoProduct.getProductByID(id);
            int updateRating = 0;
            for (Comment comment : comments) {
                updateRating += comment.getRating();
            }
            updateRating /= comments.size();
            p.setRating(updateRating);
        }
        Comment newCom = new Comment();
        newCom.setProductID(id);
        newCom.setUserID(Integer.parseInt(user.getUserId()));
        newCom.setRating(rating);
        newCom.setContent(content);
        if (!daoComment.checkExistComment(id, Integer.parseInt(user.getUserId()))) {
            daoComment.insertComment(newCom);
        } else {
            daoComment.updateComment(newCom);
        }
        sendDispatcher(request, response, "ProductDetailControllerMap?service=getProductDetail&pid=" + id);
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
