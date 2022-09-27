/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.HomePageController;
import entity.*;
import java.io.IOException;
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
public class HomePageService {
    
    DBConnection dbCon = new DBConnection();
    CategoryDAO cateDAO = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ProductDAO proDAO = new ProductDAO();
    SellerDAO sellerDAO = new SellerDAO();
    UserDAO userDAO = new UserDAO();
    
    public void serviceHomepage(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("Home", "home");
        sendDispatcher(request, response, "/index.jsp");
    }

    public void serviceList(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        int id = 0;
        if (x != null) {
            id = Integer.parseInt(x.getUserId());
        }

        int count = proDAO.totalProduct();
        int size = 20;
        int total = count / size;
        int page, end;
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
        } else if (total > 2) {
            end = total;
            begin = total - 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
        if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }

        List<Product> ListP = proDAO.getProductSuggest(page, id);

        request.setAttribute(
                "end", end);
        request.setAttribute(
                "href", "list");
        request.setAttribute(
                "begin", begin);
        request.setAttribute(
                "listP", ListP);
        request.setAttribute(
                "count", count);
        request.setAttribute(
                "count2", count);
        sendDispatcher(request, response,
                "productList/list.jsp");

    }

    public void serviceByCate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("cid"));
        int count = proDAO.getProductBycate(id).size();
        int size = 24;
        int total = count / size;
        int page, end;
        String pageString = request.getParameter("page");
        if (pageString == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        int begin = page;
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=ByCate&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=ByCate&page=" + (page + 1) + ">N</a></li>";
        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        }
        if (total > 2) {
            end = total;
            begin = total - 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
          if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }


        List<Product> ListP = proDAO.getProductByCategory(id, page);
        request.setAttribute("end", end);
        request.setAttribute("href", "ByCate&id=" + id);
        request.setAttribute("begin", begin);
        request.setAttribute("listP", ListP);
        request.setAttribute("count", count);
        String address;
        address = "<a href=" + "HomePageControllerMap?service=ByCate&cid=" + id + ">" + cateDAO.getCategoryById(id) + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", address);
        request.setAttribute("count2", count);
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceByGenre(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("gid"));
        int count = proDAO.getProductByGenre(id).size();
        int size = 24;
        int total = count / size;
        int page, end;
        String pageString = request.getParameter("page");
        if (pageString == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        int begin = page;
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=ByCate&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=ByCate&page=" + (page + 1) + ">N</a></li>";
        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        }
        if (total > 2) {
            end = total;
            begin = total - 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
          if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }


        List<Product> ListP = proDAO.getProductByGenre(id, page);
        request.setAttribute("end", end);
        request.setAttribute("href", "ByGenre&id=" + id);
        request.setAttribute("begin", begin);
        request.setAttribute("listP", ListP);
        String address;
        address = "<a href=" + "HomePageControllerMap?service=ByCate&cid=" + genDAO.getGenreById(id).getCategoryID() + ">" + cateDAO.getCategoryById(genDAO.getGenreById(id).getCategoryID()) + "  </a> <span class=" + "divider" + ">&#47;</span>";

        address += "<a href=" + "HomePageControllerMap?service=ByGenre&gid=" + id + ">" + genDAO.getGenreById(id).getGenreName() + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", address);
        request.setAttribute("count", count);
        request.setAttribute("count2", count);
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceSearch(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("search").trim();

        int count = proDAO.totalSearchProduct(str);
        String address;
        int size = 20;
        int total = count / size;
        int page, end;
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
        } else if (total > 2) {
            end = total;
            begin = total - 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
         if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

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
        request.setAttribute("count2", count);
        request.setAttribute("href", ("search&search=" + str));
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceShopPage(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("sid");

        Seller seller = sellerDAO.getSellerID(id);
        User user = userDAO.getUserBySellerId(seller);
        request.setAttribute("seller", seller);
        request.setAttribute("user", user);

        List<Product> listProduct = proDAO.getProductBySeller(id);
        List<Product> listNewArrival = proDAO.getNewProductSeller(id);

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listNewArrival", listNewArrival);

        sendDispatcher(request, response, "seller/shopPage.jsp");
    }

    public void serviceShopPageProduct(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("sid");
        int count = proDAO.totalProductSeller(id);
        Seller seller = sellerDAO.getSellerID(id);
        User user = userDAO.getUserBySellerId(seller);
        request.setAttribute("seller", seller);
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
        String previous = "  <li><a class='' href=" + "HomePageControllerMap?service=shopPageProduct&sid=" + id + "&page=" + (page - 1) + ">P</a></li>";
        String next = "  <li><a class='' href=" + "HomePageControllerMap?service=shopPageProduct&sid=" + id + "&page=" + (page + 1) + ">N</a></li>";

        if (count % size != 0) {
            total += 1;
        }
        if (page <= total - 2) {
            end = page + 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
          if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }


        List<Product> listProduct = proDAO.getProductBySellerPaging(page, Integer.parseInt(id));

        request.setAttribute("end", end);
        request.setAttribute("begin", begin);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("sid", id);
        request.setAttribute("count", count);

        sendDispatcher(request, response, "seller/shopPageProduct.jsp");
    }

    public void Filter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String str = request.getParameter("search").trim();
        String[] x = request.getParameterValues("cid");
        if (x == null || x.length == 0) {
            sendDispatcher(request, response, "HomePageControllerMap?service=search&search=" + str);
        }
        String[] idcate = x;
        session.setAttribute("idcate", idcate);
        session.setAttribute("str", str);
        sendDispatcher(request, response, "HomePageControllerMap?service=check");
    }

    public void serviceFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] idcate = (String[]) request.getSession().getAttribute("idcate");

        String str = (String) request.getSession().getAttribute("str");
        int count = proDAO.totalSearchProductFilter(str, idcate);

        String address;
        int size = 20;
        int total = count / size;
        int page, end;
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
        } else if (total > 2) {
            end = total;
            begin = total - 2;
        } else if (total == 1) {
            end = 1;
            begin = 1;
        } else {
            end = 2;
            begin = 1;

        }
         if (page == 1 && total != 1) {
            request.setAttribute("next", next);
        } else if (page == total && total != 1) {
            request.setAttribute("previous", previous);
        } else if (total == 1) {

        } else {
            request.setAttribute("next", next);
            request.setAttribute("previous", previous);
        }


        List<Product> ListP = proDAO.getProductByFilter(page, str, idcate);
        address = "<a>" + " Results for " + str + "  </a> <span class=" + "divider" + ">&#47;</span>";
        request.setAttribute("address", "");
        request.setAttribute("end", end);
        request.setAttribute("begin", begin);
        request.setAttribute("listP", ListP);
        request.setAttribute("search", str);
        request.setAttribute("count", count);
        request.setAttribute("count2", count);
        request.setAttribute("idcate", idcate);
        request.setAttribute("href", ("check"));
        sendDispatcher(request, response, "productList/list.jsp");

    }

    public void serviceUserInteraction(HttpServletRequest request, HttpServletResponse response) {
        User x = (User) request.getSession().getAttribute("currUser");
        String userId = request.getParameter("userId");
        User u = userDAO.getUserById(userId);
        if (x == null) {
            request.setAttribute("otherUser", u);
            sendDispatcher(request, response, "user/otherUser.jsp");
        } else {
            if (u.getUserId().equals(x.getUserId())) {
                request.setAttribute("currUser", x);
                sendDispatcher(request, response, "user/profile.jsp");
            } else {
                request.setAttribute("otherUser", u);
                sendDispatcher(request, response, "user/otherUser.jsp");
            }
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(HomePageController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
