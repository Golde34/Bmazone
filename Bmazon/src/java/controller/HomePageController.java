/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CartItem;
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
import entity.Seller;
import entity.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.DBConnection;
import model.SellerDAO;
import model.UserDAO;

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
    SellerDAO sellerDAO = new SellerDAO();
    UserDAO userDAO = new UserDAO();
    private static final long serialVersionUID = 1;

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
            if (service.equalsIgnoreCase("shopPage")) {
                serviceShopPage(request, response);
            }
            if (service.equalsIgnoreCase("check")) {
                serviceFilter(request, response);
            }
        }
    }

    public void serviceHomepage(HttpServletRequest request, HttpServletResponse response) {

        List<Product> ListSale = proDAO.getProductSale();
        List<Product> ListNew = proDAO.getProductNew();
        List<Product> ListApple = proDAO.getProductApple();
        List<Product> ListSuggest = proDAO.getProductSuggest();
        request.setAttribute("ListSale", ListSale);
        request.setAttribute("ListNew", ListNew);
        request.setAttribute("ListApple", ListApple);
        request.setAttribute("ListSuggest", ListSuggest);
        sendDispatcher(request, response, "/index.jsp");

    }

    public void serviceList(HttpServletRequest request, HttpServletResponse response) {
        int count = proDAO.totalProduct();
        String[] pageshow=null;
        int size=20;
        int total=count/size;
        int page,end;
        String pageString = request.getParameter("page");
        if (pageString == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        int begin = page;
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=list&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=list&page=" + (page + 1) + ">N</a></li>";
        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        } else {
            end = total;
            begin = total - 2;
        }
        if (page == 1) {
            request.setAttribute("next", next);
        } else if (page == total) {
            request.setAttribute("previous", previous);
        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }
        List<Product> ListP = proDAO.getTrueProduct(page);
        request.setAttribute("end", end);
        request.setAttribute("href", "list");
        request.setAttribute("begin", begin);
        request.setAttribute("listP", ListP);
        request.setAttribute("count", count);
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceByCate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("cid"));
        List<Product> ListP = proDAO.getProductByCategory(id);
        String address;
        address = "<a href=" + "HomePageControllerMap?service=ByCate&cid=" + id + ">" + cateDAO.getCategoryById(id) + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", address);
        request.setAttribute("listP", ListP);
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceByGenre(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("gid"));
        List<Product> ListP = proDAO.getProductByGenre(id);
        String address;
        address = "<a href=" + "HomePageControllerMap?service=ByCate&cid=" + genDAO.getGenreById(id).getCategoryID() + ">" + cateDAO.getCategoryById(genDAO.getGenreById(id).getCategoryID()) + "  </a> <span class=" + "divider" + ">&#47;</span>";

        address += "<a href=" + "HomePageControllerMap?service=ByGenre&gid=" + id + ">" + genDAO.getGenreById(id).getGenreName() + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", address);
        request.setAttribute("listP", ListP);
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceSearch(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("search").trim();
        int count = proDAO.totalSearchProduct(str);
        String address;
        int size=20;
        int total=count/size;
        int page,end;       
        String pageString = request.getParameter("page");
        if (pageString == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        int begin = page;
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=search&search=" + str + "&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=search&search=" + str + "&page=" + (page + 1) + ">N</a></li>";
        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        } else {
            end = total;
            begin = total - 2;
        }
        if (page == 1) {
            request.setAttribute("next", next);
        } else if (page == total) {
            request.setAttribute("previous", previous);
        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }
        List<Product> ListP = proDAO.getProductByName(page, str);
        address = "<a>" + " Results for " + str + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", address);
        request.setAttribute("end", end);
        request.setAttribute("begin", begin);
        request.setAttribute("listP", ListP);
        request.setAttribute("search", str);
        request.setAttribute("count", count);
        request.setAttribute("href",("search&search="+str));
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceShopPage(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("sid");
        int count = proDAO.totalProductSeller(id);
        
        User user = userDAO.getUserById(id);
        request.setAttribute("user", user);

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
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=shopPage&sid=" + id + "&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=shopPage&sid=" + id + "&page=" + (page + 1) + ">N</a></li>";

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

        List<Product> listProduct = proDAO.getProductBySellerPaging(page, id);

        request.setAttribute("end", end);
        request.setAttribute("begin", begin);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("sid", id);
        request.setAttribute("count", count);
        

        sendDispatcher(request, response, "seller/shopPage.jsp");
    }
     public void serviceFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
       PrintWriter out = response.getWriter();
       out.print("thinh dep trai");
        
     

        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
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
