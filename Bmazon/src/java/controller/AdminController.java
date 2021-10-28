/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    private static final long serialVersionUID = 1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "AdminDashBoard";
            }

            //Admin Dashboard
            if (service.equalsIgnoreCase("AdminDashBoard")) {
                serviceAdminDashboard(service, request, response);
            }

            // <editor-fold defaultstate="collapsed" desc="User service. Click on the + sign on the left to edit the code.">
            //User Management
            if (service.equalsIgnoreCase("usermanagement")) {
                serviceUserManagement(service, request, response);
            }
            //User detail to add and update
            if (service.equalsIgnoreCase("updateuserdetail") || service.equalsIgnoreCase("adduserdetail")) {
                serviceUserDetail(service, request, response);
            }
            //Paging User
            if (service.equalsIgnoreCase("paginguser")) {
                servicePagingUser(service, request, response);
            }
            //Show Page User
            if (service.equalsIgnoreCase("showpageuser")) {
                serviceShowPageUser(request, response);
            }
            //Add user
            if (service.equalsIgnoreCase("adduser")) {
                serviceAddUser(service, request, response);
            }
            //Update User 
            if (service.equalsIgnoreCase("updateuser")) {
                serviceUpdateUser(service, request, response);
            }
            //Delete user
            if (service.equalsIgnoreCase("deleteuser")) {
                serviceDeleteUser(service, request, response);
            }
            //Active user
            if (service.equalsIgnoreCase("activeuser")) {
                serviceActiveUser(service, request, response);
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Product service. Click on the + sign on the left to edit the code.">
            //Product Manage
            if (service.equalsIgnoreCase("productmanagement")) {
                serviceProductManagement(service, request, response);
            }
            //Product detail to add and update
            if (service.equalsIgnoreCase("productdetail")) {
                serviceProductDetail(service, request, response);
            }
            //Paging Product
            if (service.equalsIgnoreCase("pagingproduct")) {
                servicePagingProduct(service, request, response);
            }
            //Show Page Product
            if (service.equalsIgnoreCase("showpageproduct")) {
                serviceShowPageProduct(request, response);
            }
            //Add Product
            if (service.equalsIgnoreCase("addproduct")) {
                serviceAddProduct(service, request, response);
            }
            //Update Product 
            if (service.equalsIgnoreCase("updateproduct")) {
                serviceUpdateProduct(service, request, response);
            }
            //Delete Product
            if (service.equalsIgnoreCase("deleteproduct")) {
                serviceDeleteProduct(service, request, response);
            }
            //Active Product
            if (service.equalsIgnoreCase("activeproduct")) {
                serviceActiveProduct(service, request, response);
            }
            //Delete Product Type
            if (service.equalsIgnoreCase("deleteproducttype")) {
                serviceDeleteProductType(service, request, response);
            }
            //Active Product Type
            if (service.equalsIgnoreCase("activeproducttype")) {
                serviceActiveProductType(service, request, response);
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Ship Company service. Click on the + sign on the left to edit the code.">
            //Ship Company Manage
            if (service.equalsIgnoreCase("companymanagement")) {
                serviceCompanyManagement(service, request, response);
            }
            //Paging User
            if (service.equalsIgnoreCase("pagingcompany")) {
                servicePagingCompany(service, request, response);
            }
            //Show Page User
            if (service.equalsIgnoreCase("showpagecompany")) {
                serviceShowPageCompany(request, response);
            }
            //Ship Company detail to add and update
            if (service.equalsIgnoreCase("updatecompanydetail") || service.equalsIgnoreCase("addcompanydetail")) {
                serviceCompanyDetail(service, request, response);
            }

            //Add Ship Company
            if (service.equalsIgnoreCase("addcompany")) {
                serviceAddCompany(service, request, response);
            }
            //Update Ship Company 
            if (service.equalsIgnoreCase("updatecompany")) {
                serviceUpdateCompany(service, request, response);
            }
            //Delete Ship Company
            if (service.equalsIgnoreCase("deletecompany")) {
                serviceDeleteCompany(service, request, response);
            }
            //Delete Ship Company
            if (service.equalsIgnoreCase("activecompany")) {
                serviceActiveCompany(service, request, response);
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Gallery service. Click on the + sign on the left to edit the code.">
            //Gallery Manage
            if (service.equalsIgnoreCase("gallerymanagement")) {
                serviceGalleryManagement(service, request, response);
            }
            //Paging Gallery
            if (service.equalsIgnoreCase("pagingGallery")) {
                servicePagingGallery(service, request, response);
            }
            //Show Page Gallery
            if (service.equalsIgnoreCase("showpageGallery")) {
                serviceShowPageGallery(request, response);
            }
            //Gallery detail to add and update
            if (service.equalsIgnoreCase("gallerydetail")) {
                serviceGalleryDetail(service, request, response);
            }
            //Add Gallery
            if (service.equalsIgnoreCase("addproduct")) {
                serviceAddGallery(service, request, response);
            }
            //Update Gallery 
            if (service.equalsIgnoreCase("updategallery")) {
                serviceUpdateGallery(service, request, response);
            }
            //Delete Gallery
            if (service.equalsIgnoreCase("deletegallery")) {
                serviceDeleteGallery(service, request, response);
            }
            //Active Gallery
            if (service.equalsIgnoreCase("activegallery")) {
                serviceActiveGallery(service, request, response);
            }
            //</editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="Category service. Click on the + sign on the left to edit the code.">
            //Category Management
            if(service.equalsIgnoreCase("categoryManagement")){
                serviceCategoryManagement(service, request, response);
            }
            
            //Category detail to add and update
            if (service.equalsIgnoreCase("updatecategorydetail") || service.equalsIgnoreCase("addcategorydetail")) {
                serviceCategoryDetail(service, request, response);
            }
            //Paging Category
            if (service.equalsIgnoreCase("pagingcategory")) {
                servicePagingCategory(service, request, response);
            }
            //Show Page Category
            if (service.equalsIgnoreCase("showpagecategory")) {
                serviceShowPageCategory(request, response);
            }
            //Add Category
            if (service.equalsIgnoreCase("addcategory")) {
                serviceAddCategory(service, request, response);
            }
            //Update Category 
            if (service.equalsIgnoreCase("updatecategory")) {
                serviceUpdateCategory(service, request, response);
            }
            //Delete Category
            if (service.equalsIgnoreCase("deletecategory")) {
                serviceDeleteCategory(service, request, response);
            }
            //Active Category
            if (service.equalsIgnoreCase("activecategory")) {
                serviceActiveCategory(service, request, response);
            }
            //</editor-fold>

            //User Authorization
            if (service.equalsIgnoreCase("userAuthorization")) {
                serviceUserAuthorization(service, request, response);
            }
            //Delete user
            if (service.equalsIgnoreCase("deleteuserAuthor")) {
                serviceDeleteUserAuthor(service, request, response);
            }
            //Active user
            if (service.equalsIgnoreCase("activeuserAuthor")) {
                serviceActiveUserAuthor(service, request, response);
            }

            // <editor-fold defaultstate="collapsed" desc="Seller Response. Click on the + sign on the left to edit the code.">
            //SellerResposne
            if (service.equalsIgnoreCase("sellerResponse")) {
                serviceSellerResponse(service, request, response);
            }
            //Accept Seller Request
            if (service.equalsIgnoreCase("acceptSeller")) {
                serviceAcceptSellerRequest(service, request, response);
            }
            //Deny Seller Request
            if (service.equalsIgnoreCase("denySeller")) {
                serviceDenySellerRequest(service, request, response);
            }
            //</editor-fold>
            
            // <editor-fold defaultstate="collapsed" desc="Role serive. Click on the + sign on the left to edit the code.">
            //Role Display
            if (service.equalsIgnoreCase("roleDisplay")) {
                serviceRoleManagement(service, request, response);
            }
            //Role Detail
            if (service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {
                serviceRoleDetail(service, request, response);
            }
            //Add role
            if (service.equalsIgnoreCase("addRole")) {
                serviceAddRole(service, request, response);
            }
            //Update role
            if (service.equalsIgnoreCase("updateRole")) {
                serviceUpdateRole(service, request, response);
            }
            //Delete role
            if (service.equalsIgnoreCase("deleteRole")) {
                serviceDeleteRole(service, request, response);
            }
            //Search role
            if (service.equalsIgnoreCase("searchRole")) {
                serviceSearchRole(service, request, response);
            }
            //</editor-fold>
        }
    }

    public void serviceAdminDashboard(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        ArrayList<User> listUser = daouser.getAllUser();
        request.setAttribute(("listUser"), listUser);
        sendDispatcher(request, response, "admin/admin.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="User methods. Click on the + sign on the left to edit the code.">
    public void serviceUserManagement(String service, HttpServletRequest request, HttpServletResponse response) {
        ArrayList<User> listPaging = daouser.getAllPagingUser(1, 5, "");
        ArrayList<User> listUser = daouser.getAllUser();
        int totalPage = listUser.size() / 5;
        if (listUser.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listUser", listPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/usermanagement.jsp");
    }

    public void serviceUserDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("adduserdetail")) {
            sendDispatcher(request, response, "admin/userdetail.jsp");
            return;
        }
        String id = request.getParameter("userid");
        User user = daouser.getUserById(id);
        request.setAttribute("user", user);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/userdetail.jsp");
    }

    public void servicePagingUser(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        ArrayList<User> listPaging = daouser.getAllPagingUser(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listUser", listPaging);
        for (User user : listPaging) {
            pr.print("<tr>"
                    + "<td>" + user.getUsername() + " </td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td>" + user.getFullname() + "</td>"
                    + "<td>" + user.getPhoneNumber() + "</td>"
                    + "<td>" + user.getAddress() + "</td>"
                    + "<td><a href=\"AdminControllerMap?service=updateuserdetail&userid=" + user.getUserId() + "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</td>"
                    + "<td>");
            if (user.getStatus() == 1) {
                pr.print("<a href=\"AdminControllerMap?service=deleteuser&userid=" + user.getUserId() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"AdminControllerMap?service=activeuser&userid=" + user.getUserId() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "admin/usermanagement.jsp");
        }
    }

    public void serviceShowPageUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daouser.getPageNumber(search);
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
            sendDispatcher(request, response, "admin/usermanagement.jsp");
        }
    }

    public void serviceAddUser(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        boolean isExist = false;
        if (daouser.checkExistMail(email) == true
                || daouser.checkExistPhone(phone) == true
                || daouser.checkExistUserName(username) == true) {
            isExist = true;
        }
        if (isExist == true) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("fullname", fullname);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("address", address);
            String mess = "Add fail because duplicate information";
            request.setAttribute("mess", mess);
            String state = "fail";
            request.setAttribute("state", state);
            request.setAttribute("service", "adduserdetail");
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
        if (isExist == false) {
            User user = new User(username, password, email, phone, 0, 0, fullname, "", address, "", "", "", gender, "", "", "", "", "", 0, 0, 1);
            daouser.addUser(user);
            ArrayList<User> listPaging = daouser.getAllPagingUser(1, 5, "");
            String state = "success";
            request.setAttribute("state", state);
            request.setAttribute("listUser", listPaging);
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "adduserdetail");
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
    }

    public void serviceUpdateUser(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("id");
        User user = daouser.getUserById(id);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        boolean isExist = false;
        if ((daouser.checkExistMail(email) && !email.equalsIgnoreCase(user.getEmail()))
                || (daouser.checkExistPhone(phone) && !phone.equalsIgnoreCase(user.getPhoneNumber()))
                || (daouser.checkExistUserName(username) && !username.equalsIgnoreCase(user.getUsername()))) {
            isExist = true;
        }
        if (isExist == true) {
            String state = "fail";
            request.setAttribute("state", state);
            String mess = "Update fail because duplicate information";
            request.setAttribute("mess", mess);
            request.setAttribute("user", user);
            request.setAttribute("service", "updateuserdetail");
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
        if (isExist == false) {
            user.setUsername(username);
            user.setPassword(password);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setPhoneNumber(phone);
            user.setAddress(address);
            user.setGender(gender);
            daouser.updateInfoUserByAdmin(user);
            String state = "success";
            request.setAttribute("state", state);
            ArrayList<User> listPaging = daouser.getAllPagingUser(1, 5, "");
            request.setAttribute("listUser", listPaging);
            request.setAttribute("user", user);
            request.setAttribute("service", "updateuserdetail");
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
    }

    public void serviceDeleteUser(String service, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(id, 0);
        ArrayList<User> listPaging = daouser.getAllPagingUser(1, 5, "");
        ArrayList<User> listUser = daouser.getAllUser();
        int totalPage = listUser.size() / 5;
        if (listUser.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listUser", listPaging);
        request.setAttribute("service", "usermanagement");
        sendDispatcher(request, response, "admin/usermanagement.jsp");
    }

    public void serviceActiveUser(String service, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(id, 1);
        ArrayList<User> listPaging = daouser.getAllPagingUser(1, 5, "");
        ArrayList<User> listUser = daouser.getAllUser();
        int totalPage = listUser.size() / 5;
        if (listUser.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listUser", listPaging);
        request.setAttribute("service", "usermanagement");
        sendDispatcher(request, response, "admin/usermanagement.jsp");
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Product methods. Click on the + sign on the left to edit the code.">
    public void serviceProductManagement(String service, HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> listPaging = daoproduct.getAllPagingProduct(1, 5, "");
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != 5 * totalPage) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void servicePagingProduct(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
//        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy"); //never used (fix FindBugs)
        request.setAttribute("service", service);
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        ArrayList<Product> listPaging = daoproduct.getAllPagingProduct(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listProduct", listPaging);
        for (Product product : listPaging) {
            Seller seller = daoseller.getSellerID(String.valueOf(product.getSeller()));
            Genre genre = daogenre.getGenreById(Integer.parseInt(daopg.getGenreIdByProductId(product.getProductID())));
            String category = daocategory.getCategoryById(Integer.parseInt(daopc.getCategoryIdByProductId(product.getProductID())));
            pr.print("<tr>"
                    + "<td><div>" + product.getProductName() + " </div></td>"
                    + "<td><div>" + category + "</div></td>"
                    + "<td><div>" + genre.getGenreName() + "</div></td>"
                    + "<td><div>" + seller.getSellerShopName() + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=productdetail&productid=" + product.getProductID() + "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</div></td>"
                    + "<td>");
            if (product.getStatus() == 1) {
                pr.print("<a href=\"AdminControllerMap?service=deleteproduct&productid=" + product.getProductID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"AdminControllerMap?service=activeproduct&productid=" + product.getProductID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "admin/productmanagement.jsp");
        }
    }

    public void serviceShowPageProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
//        ArrayList<Product> listPaging = daoproduct.getAllPagingProduct(index, numOfRow, search); //never used (fix FindBugs)
        int totalResult = daoproduct.getPageNumber(search);
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
            sendDispatcher(request, response, "admin/productmanagement.jsp");
        }
    }

    public void serviceProductDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addproductdetail")) {
            sendDispatcher(request, response, "admin/productdetail.jsp");
            return;
        }
        String id = request.getParameter("productid");
        Product product = daoproduct.getProductByID(Integer.parseInt(id));
        String genreid = daopg.getGenreIdByProductId(product.getProductID());
        Genre genre = daogenre.getGenreById(Integer.parseInt(genreid));
        String categoryId = daopc.getCategoryIdByProductId(product.getProductID());
        Category category = daocategory.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = daogenre.getGenresByCategoryId(Integer.parseInt(categoryId));
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        sendDispatcher(request, response, "admin/productdetail.jsp");
    }

    public void serviceAddProduct(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String productname = request.getParameter("productname");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String price = request.getParameter("price");
        String date = request.getParameter("date");
        Product product = new Product();
        product.setProductName(productname);
        product.setReleaseDate(Date.valueOf(date));
        ProductType producttype = new ProductType();
        daoproduct.addProduct(product);
        List<ProductType> listProductType = daoproducttype.getProductByProductID(product.getProductID());
        String producttypeid = "Pr" + product.getProductID() + "Ty" + (listProductType.size() + 1);
        producttype.setProductTypeId(producttypeid);
        producttype.setColor(color);
        producttype.setPrice(price);
        producttype.setSize(size);
        daoproducttype.addProductType(producttype);
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceDeleteProduct(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("productid");
        daoproduct.changeStatus(Integer.parseInt(id), 0);
        ArrayList<Product> listPaging = daoproduct.getAllPagingProduct(1, 5, "");
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != 5 * totalPage) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceActiveProduct(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("productid");
        daoproduct.changeStatus(Integer.parseInt(id), 1);
        ArrayList<Product> listPaging = daoproduct.getAllPagingProduct(1, 5, "");
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        int totalPage = listProduct.size() / 5;
        if (listProduct.size() != 5 * totalPage) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProduct", listPaging);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceDeleteProductType(String service, HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("producttypeid");
        daoproducttype.changeStatus(id, 0);
        int pid = daoproducttype.getProductIdByProductTypeId(id);
        Product product = daoproduct.getProductByID(pid);
        String genreid = daopg.getGenreIdByProductId(pid);
        Genre genre = daogenre.getGenreById(Integer.parseInt(genreid));
        String categoryId = daopc.getCategoryIdByProductId(pid);
        Category category = daocategory.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = daogenre.getGenresByCategoryId(Integer.parseInt(categoryId));
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "admin/productdetail.jsp");
    }

    public void serviceActiveProductType(String service, HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("producttypeid");
        daoproducttype.changeStatus(id, 1);
        int pid = daoproducttype.getProductIdByProductTypeId(id);
        Product product = daoproduct.getProductByID(pid);
        String genreid = daopg.getGenreIdByProductId(pid);
        Genre genre = daogenre.getGenreById(Integer.parseInt(genreid));
        String categoryId = daopc.getCategoryIdByProductId(pid);
        Category category = daocategory.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = daogenre.getGenresByCategoryId(Integer.parseInt(categoryId));
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("product", product);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "admin/productdetail.jsp");
    }

    public void serviceUpdateProduct(String service, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        request.setAttribute("service", service);
        boolean isExist = false;
        //Get information about product
        String pid = request.getParameter("pid");
        String productname = request.getParameter("productname");
        String cat = request.getParameter("category");
        String gen = request.getParameter("genre");
        String sellerId = request.getParameter("seller");
        String date = request.getParameter("date");
        Date sqlDate = Date.valueOf(date);
        //Update product
        ProductCategory pc = daopc.getProductCateByProductID(Integer.parseInt(pid));
        ProductGenre pg = daopg.getProductGenreByProduct(pid);
        Product product = daoproduct.getProductByID(Integer.parseInt(pid));
        product.setProductName(productname);
        product.setReleaseDate(sqlDate);
        product.setSeller(Integer.parseInt(sellerId));
        daoproduct.updateProduct(product);
        pc.setCategoryID(Integer.parseInt(cat));
        daopc.updateProductCategory(pc);
        pg.setGenreID(Integer.parseInt(gen));
        daopg.updateProductGenre(pg);
        //Get information about product type

        String[] typeids = request.getParameterValues("ptid");
        String[] colors = request.getParameterValues("color");
        String[] sizes = request.getParameterValues("size");
        String[] prices = request.getParameterValues("price");
        String[] quantities = request.getParameterValues("quantity");

        //Check information
        for (int i = 0; i < typeids.length; i++) {
            ProductType pt = daoproducttype.getProductTypeByPTypeID(typeids[i]);
            if (daoproducttype.checkExistSizeAndColor(sizes[i], colors[i], Integer.parseInt(pid)) && !colors[i].equalsIgnoreCase(pt.getColor()) && !sizes[i].equalsIgnoreCase(pt.getSize())) {
                isExist = true;
            }
        }
        //Case check fail
        if (isExist == true) {
            String state = "fail";
            String mess = "Update fail because product type exists.";
            String genreid = daopg.getGenreIdByProductId(product.getProductID());
            Genre genre = daogenre.getGenreById(Integer.parseInt(genreid));
            String categoryId = daopc.getCategoryIdByProductId(product.getProductID());
            Category category = daocategory.getCategoryByCateId(categoryId);
            ArrayList<Genre> listGenre = daogenre.getGenresByCategoryId(Integer.parseInt(categoryId));

            //Set attribute
            request.setAttribute("listGenre", listGenre);
            request.setAttribute("category", category);
            request.setAttribute("genre", genre);
            request.setAttribute("state", state);
            request.setAttribute("product", product);
            request.setAttribute("mess", mess);
            request.setAttribute("service", "updateproductdetail");
            sendDispatcher(request, response, "admin/productdetail.jsp");
        }
        //Case check success
        //Update product type
        for (int i = 0; i < typeids.length; i++) {
            ProductType pt = daoproducttype.getProductTypeByPTypeID(typeids[i]);
            pt.setColor(colors[i]);
            pt.setSize(sizes[i]);
            pt.setPrice(prices[i]);
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number nQuantity = 0;
            try {
                nQuantity = format.parse(quantities[i]);
            } catch (ParseException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pt.setQuantity(nQuantity.intValue());
            daoproducttype.editProduct(pt);
        }
        //Success
        String state = "success";
        String mess = "Update successfully";
        String genreid = daopg.getGenreIdByProductId(product.getProductID());
        Genre genre = daogenre.getGenreById(Integer.parseInt(genreid));
        String categoryId = daopc.getCategoryIdByProductId(product.getProductID());
        Category category = daocategory.getCategoryByCateId(categoryId);
        ArrayList<Genre> listGenre = daogenre.getGenresByCategoryId(Integer.parseInt(categoryId));

        //Set attribute
        request.setAttribute("listGenre", listGenre);
        request.setAttribute("category", category);
        request.setAttribute("genre", genre);
        request.setAttribute("state", state);
        request.setAttribute("product", product);
        request.setAttribute("mess", mess);
        request.setAttribute("service", "updateproductdetail");
        sendDispatcher(request, response, "admin/productdetail.jsp");
    }//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Company methods. Click on the + sign on the left to edit the code.">
    public void serviceCompanyManagement(String service, HttpServletRequest request, HttpServletResponse response) {
        List<ShipCompany> listPaging = daocompany.getAllPagingShipCompany(1, 5, "");
        List<ShipCompany> listCompany = daocompany.getAllShipCompany();
        int totalPage = listCompany.size() / 5;
        if (listCompany.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCompany", listPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/companymanagement.jsp");
    }

    public void servicePagingCompany(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        request.setAttribute("service", service);
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        List<ShipCompany> listPaging = daocompany.getAllPagingShipCompany(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listCompany", listPaging);
        for (ShipCompany company : listPaging) {
            DecimalFormat nf = new DecimalFormat("###,###,###");
            pr.print("<tr>"
                    + "<td><div>" + company.getCompanyName() + " </div></td>"
                    + "<td><div>" + company.getCommitDate() + "</div></td>"
                    + "<td><div>" + nf.format(company.getUnitCost()) + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updatecompanydetail&companyid=" + company.getCompanyID() + "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</div></td>"
                    + "<td>");
            if (company.getStatus() == 1) {
                pr.print("<a href=\"AdminControllerMap?service=deletecompany&companyid=" + company.getCompanyID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"AdminControllerMap?service=activecompany&companyid=" + company.getCompanyID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "admin/companymanagement.jsp");
        }
    }

    public void serviceShowPageCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daocompany.getPageNumber(search);
        int totalPage = totalResult / numOfRow;
        if (totalResult != totalPage * numOfRow) {
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
            sendDispatcher(request, response, "admin/companymanagement.jsp");
        }
    }

    public void serviceCompanyDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addcompanydetail")) {
            sendDispatcher(request, response, "admin/companydetail.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("companyid"));
        ShipCompany company = daocompany.getShipCompanyById(id);
        request.setAttribute("company", company);
        sendDispatcher(request, response, "admin/companydetail.jsp");
    }

    public void serviceDeleteCompany(String service, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("companyid");
        daocompany.changeStatus(Integer.parseInt(id), 0);
        sendDispatcher(request, response, "admin/companymanagement.jsp");
        List<ShipCompany> listPaging = daocompany.getAllPagingShipCompany(1, 5, "");
        List<ShipCompany> listCompany = daocompany.getAllShipCompany();
        int totalPage = listCompany.size() / 5;
        if (listCompany.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCompany", listPaging);
        request.setAttribute("service", "companymanagement");
        sendDispatcher(request, response, "admin/companymanagement.jsp");
    }

    public void serviceActiveCompany(String service, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("companyid");
        daocompany.changeStatus(Integer.parseInt(id), 1);
        sendDispatcher(request, response, "admin/companymanagement.jsp");
        List<ShipCompany> listPaging = daocompany.getAllPagingShipCompany(1, 5, "");
        List<ShipCompany> listCompany = daocompany.getAllShipCompany();
        int totalPage = listCompany.size() / 5;
        if (listCompany.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCompany", listPaging);
        request.setAttribute("service", "companymanagement");
        sendDispatcher(request, response, "admin/companymanagement.jsp");
    }

    public void serviceAddCompany(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String companyname = request.getParameter("companyname");
        String unitcost = request.getParameter("unitcost");
        String commitdate = request.getParameter("commitdate");
        boolean isExist = false;
        if (daocompany.checkExistCompanyName(companyname)) {
            isExist = true;
        }
        if (isExist == true) {
            request.setAttribute("companyname", companyname);
            request.setAttribute("unitcost", unitcost);
            request.setAttribute("commitdate", commitdate);
            String state = "fail";
            request.setAttribute("state", state);
            String mess = "Add fail because duplicate information";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "addcompanydetail");
            sendDispatcher(request, response, "admin/companydetail.jsp");
        }
        if (isExist == false) {
            ShipCompany company = new ShipCompany();
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number cost = 0, date = 0;
            try {
                cost = format.parse(unitcost);
                date = format.parse(commitdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String unitCostTemp = String.valueOf(cost);
            company.setCommitDate(date.intValue());
            company.setCompanyName(companyname);
            company.setUnitCost(Double.parseDouble(unitCostTemp));
            company.setStatus(1);
            daocompany.addShipCompany(company);
            List<ShipCompany> listCompany = daocompany.getAllPagingShipCompany(1, 5, "");
            String state = "success";
            request.setAttribute("state", state);
            request.setAttribute("listCompany", listCompany);
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "addcompanydetail");
            sendDispatcher(request, response, "admin/companydetail.jsp");
        }
    }

    public void serviceUpdateCompany(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("id");
        ShipCompany company = daocompany.getShipCompanyById(Integer.parseInt(id));
        String companyname = request.getParameter("companyname");
        String unitcost = request.getParameter("unitcost");
        String commitdate = request.getParameter("commitdate");
        boolean isExist = false;
        if (daocompany.checkExistCompanyName(companyname) && !companyname.equalsIgnoreCase(company.getCompanyName())) {
            isExist = true;
        }
        if (isExist == true) {
            request.setAttribute("service", "updatecompanydetail");
            request.setAttribute("company", company);
            String mess = "Update fail because duplicate information";
            String state = "fail";
            request.setAttribute("state", state);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "admin/companydetail.jsp");
        }
        if (isExist == false) {
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number cost = 0, date = 0;
            try {
                cost = format.parse(unitcost);
                date = format.parse(commitdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String unitCostTemp = String.valueOf(cost);
            company.setCommitDate(date.intValue());
            company.setCompanyName(companyname);
            company.setUnitCost(Double.parseDouble(unitCostTemp));
            daocompany.editShipCompany(company);
            String state = "success";
            request.setAttribute("state", state);
            List<ShipCompany> listCompany = daocompany.getAllPagingShipCompany(1, 5, "");
            request.setAttribute("listCompany", listCompany);
            request.setAttribute("company", company);
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "updatecompanydetail");
            sendDispatcher(request, response, "admin/companydetail.jsp");
        }
    }//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Gallery methods. Click on the + sign on the left to edit the code.">
    public void serviceGalleryManagement(String service, HttpServletRequest request, HttpServletResponse response) {
        List<Gallery> listPaging = daogallery.getAllPagingGallery(1, 5, "");
        List<Gallery> listGallery = daogallery.getAllGallery();
        int totalPage = listGallery.size() / 5;
        if (listGallery.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listGallery", listPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/gallerymanagement.jsp");
    }

    public void servicePagingGallery(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        request.setAttribute("service", service);
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        List<Gallery> listPaging = daogallery.getAllPagingGallery(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listCompany", listPaging);
        for (Gallery gallery : listPaging) {
            Product product = daoproduct.getProductByID(gallery.getProductID());
            ProductType pt = daoproducttype.getProductTypeByPTypeID(gallery.getProductTypeID());
            Seller seller = daoseller.getSellerByProductId(product.getProductID());
            String img = "images/" + gallery.getLink();
            pr.print("<tr>"
                    + "<td>" + product.getProductName() + " </td>"
                    + "<td>" + pt.getColor() + "</td>"
                    + "<td>" + pt.getSize() + "</td>"
                    + "<td><img src=\"" + img + "\" width=\"100px\" height=\"100px\"></td>"
                    + "<td>" + seller.getSellerShopName() + "</td>"
                    + "<td><div><a href=\"AdminControllerMap?service=gallerydetail&galleryid=" + gallery.getGalleryID() + "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</div></td>"
                    + "<td>");
            if (gallery.getStatus() == 1) {
                pr.print("<a href=\"AdminControllerMap?service=deletegallery&galleryid=" + gallery.getGalleryID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"AdminControllerMap?service=activegallery&galleryid=" + gallery.getGalleryID() + "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "admin/gallerymanagement.jsp");
        }
    }

    public void serviceShowPageGallery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daogallery.getPageNumber(search);
        int totalPage = totalResult / numOfRow;
        if (totalResult != totalPage * numOfRow) {
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
            sendDispatcher(request, response, "admin/gallerymanagement.jsp");
        }
    }

    public void serviceGalleryDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addgallerydetail")) {
            sendDispatcher(request, response, "admin/gallerydetail.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("galleryid"));
        Gallery gallery = daogallery.getGalleryById(id);
        Product product = daoproduct.getProductByID(gallery.getProductID());
        ProductType producttype = daoproducttype.getProductTypeByPTypeID(gallery.getProductTypeID());
        Seller seller = daoseller.getSellerByProductId(product.getProductID());
        request.setAttribute(service, service);
        request.setAttribute("seller", seller);
        request.setAttribute("product", product);
        request.setAttribute("producttype", producttype);
        request.setAttribute("gallery", gallery);
        sendDispatcher(request, response, "admin/gallerydetail.jsp");
    }

    public void serviceAddGallery(String service, HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void serviceActiveGallery(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("galleryid");
        daogallery.changeStatus(Integer.parseInt(id), 1);
        List<Gallery> listPaging = daogallery.getAllPagingGallery(1, 5, "");
        List<Gallery> listGallery = daogallery.getAllGallery();
        int totalPage = listGallery.size() / 5;
        if (listGallery.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listGallery", listPaging);
        request.setAttribute("service", "gallerymanagement");
        sendDispatcher(request, response, "admin/gallerymanagement.jsp");
    }

    public void serviceDeleteGallery(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("galleryid");
        daogallery.changeStatus(Integer.parseInt(id), 0);
        List<Gallery> listPaging = daogallery.getAllPagingGallery(1, 5, "");
        List<Gallery> listGallery = daogallery.getAllGallery();
        int totalPage = listGallery.size() / 5;
        if (listGallery.size() > 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listGallery", listPaging);
        request.setAttribute("service", "gallerymanagement");
        sendDispatcher(request, response, "admin/gallerymanagement.jsp");
    }

    public void serviceUpdateGallery(String service, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, FileUploadException {
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
                        String storePath = servletContext.getRealPath("/images");
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        item.write(uploadFile);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id = request.getParameter("galleryid");
        Gallery gallery = daogallery.getGalleryById(Integer.parseInt(id));
        gallery.setLink(filename);
        daogallery.editGallery(gallery);
        Product product = daoproduct.getProductByID(gallery.getProductID());
        ProductType producttype = daoproducttype.getProductTypeByPTypeID(gallery.getProductTypeID());
        Seller seller = daoseller.getSellerByProductId(product.getProductID());
        request.setAttribute("filen", filename);
        request.setAttribute("service", "gallerymanagement");
        request.setAttribute("seller", seller);
        request.setAttribute("product", product);
        request.setAttribute("producttype", producttype);
        request.setAttribute("gallery", gallery);
        request.setAttribute("service", "gallerymanagement");
        sendDispatcher(request, response, "admin/gallerydetail.jsp");
    }//</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Category methods. Click on the + sign on the left to edit the code.">
    public void serviceCategoryManagement(String service, HttpServletRequest request, HttpServletResponse response){
        ArrayList<Category> listPaging = daocategory.getAllPagingCategory(1, 5, "");
        ArrayList<Category> listCategory = daocategory.getTrueCategories();
        int totalPage = listCategory.size() / 5;
        if (listCategory.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCategory", listPaging);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/categorymanagement.jsp");
    }
    
    public void serviceCategoryDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addcategorydetail")) {
            sendDispatcher(request, response, "admin/categorydetail.jsp");
            return;
        }
        String id = request.getParameter("cateid");
        Category category = daocategory.getCategoryByCateId(id);
        request.setAttribute("category", category);
        request.setAttribute("service", service);
        sendDispatcher(request, response, "admin/categorydetail.jsp");
    }

    public void servicePagingCategory(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        ArrayList<Category> listPaging = daocategory.getAllPagingCategory(index, numOfRow, search);
        request.setAttribute("index", index);
        request.setAttribute("listCategory", listPaging);
        for (Category category : listPaging) {
            pr.print("<tr>"
                    + "<td>" + category.getCategoryName()+ " </td>"
                    + "<td>" + category.getStatus()+ "</td>"
                    + "<td><a href=\"AdminControllerMap?service=updateuserdetail&userid=" + category.getCategoryID()+ "\"><button class=\"btn btn-primary\">Edit</button></a>"
                    + "</td>"
                    + "<td>");
            if (category.getStatus() == 1) {
                pr.print("<a href=\"AdminControllerMap?service=deleteuser&userid=" + category.getCategoryID()+ "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Deactive</button></a>");
            } else {
                pr.print("<a href=\"AdminControllerMap?service=activeuser&userid=" + category.getCategoryID()+ "\" onclick=\"return confirm('Are you sure?');\"><button class=\"btn btn-primary\">Active</button></a>");
            }
            pr.print("</td>"
                    + "</tr>"
            );
        }
        if (request.getParameter("row") == null) {
            sendDispatcher(request, response, "admin/categorymanagement.jsp");
        }
    }

    public void serviceShowPageCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index = 1, numOfRow = 5;
        String search = request.getParameter("search");
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if (request.getParameter("row") != null) {
            numOfRow = Integer.parseInt(request.getParameter("row"));
        }
        int totalResult = daocategory.getPageNumber(search);
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
            sendDispatcher(request, response, "admin/categorymanagement.jsp");
        }
    }

    public void serviceAddCategory(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String categoryname = request.getParameter("categoryname");
        boolean isExist = false;
        if (daocategory.checkExistCategoryName(categoryname) == true) {
            isExist = true;
        }
        if (isExist == true) {
            request.setAttribute("categoryname", categoryname);
            String mess = "Add fail because duplicate information";
            request.setAttribute("mess", mess);
            String state = "fail";
            request.setAttribute("state", state);
            request.setAttribute("service", "addcategorydetail");
            sendDispatcher(request, response, "admin/categorydetail.jsp");
        }
        if (isExist == false) {
            Category category = new Category(categoryname, 1);
            daocategory.insertCategory(category);
            ArrayList<Category> listPaging = daocategory.getAllPagingCategory(1, 5, "");
            String state = "success";
            request.setAttribute("state", state);
            request.setAttribute("listCategory", listPaging);
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "addcategorydetail");
            sendDispatcher(request, response, "admin/categorydetail.jsp");
        }
    }

    public void serviceUpdateCategory(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        String id = request.getParameter("id");
        Category category = daocategory.getCategoryByCateId(id);
        String categoryname = request.getParameter("categoryname");
        boolean isExist = false;
        if ((daouser.checkExistMail(categoryname) && !categoryname.equalsIgnoreCase(category.getCategoryName()))) {
            isExist = true;
        }
        if (isExist == true) {
            String state = "fail";
            request.setAttribute("state", state);
            String mess = "Update fail because duplicate information";
            request.setAttribute("mess", mess);
            request.setAttribute("category", category);
            request.setAttribute("service", "updatecategorydetail");
            sendDispatcher(request, response, "admin/categorydetail.jsp");
        }
        if (isExist == false) {
            category.setCategoryName(categoryname);
            daocategory.updateCategory(category);
            String state = "success";
            request.setAttribute("state", state);
            ArrayList<Category> listPaging = daocategory.getAllPagingCategory(1, 5, "");
            request.setAttribute("listCategory", listPaging);
            request.setAttribute("category", category);
            request.setAttribute("service", "updatecategorydetail");
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "admin/categorydetail.jsp");
        }
    }

    public void serviceDeleteCategory(String service, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("cateid"));
        daocategory.changeStatus(id, 0);
        ArrayList<Category> listPaging = daocategory.getAllPagingCategory(1, 5, "");
        ArrayList<Category> listCategory = daocategory.getTrueCategories();
        int totalPage = listCategory.size() / 5;
        if (listCategory.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCategory", listPaging);
        request.setAttribute("service", "categorymanagement");
        sendDispatcher(request, response, "admin/categorymanagement.jsp");
    }

    public void serviceActiveCategory(String service, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(id, 1);
        ArrayList<Category> listPaging = daocategory.getAllPagingCategory(1, 5, "");
        ArrayList<Category> listCategory = daocategory.getTrueCategories();
        int totalPage = listCategory.size() / 5;
        if (listCategory.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listCategory", listPaging);
        request.setAttribute("service", "categorymanagement");
        sendDispatcher(request, response, "admin/categorymanagement.jsp");
    }//</editor-fold>

    public void serviceUserAuthorization(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        HashMap<User, Role> listUser = daouser.getAllAuthorizationUser();
        request.setAttribute("listUser", listUser);
        sendDispatcher(request, response, "admin/authorization/userAuthorization.jsp");
    }
    
    public void serviceDeleteUserAuthor(String service, HttpServletRequest request, HttpServletResponse response) {
        int userid = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(userid, 0);
        HashMap<User, Role> listPaging = daouser.getAllPagingUserHashMap(1, 5, "");
        HashMap<User, Role> listUser = daouser.getAllAuthorizationUser();
        int totalPage = listUser.size() / 5;
        if (listUser.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listUser", listPaging);
        request.setAttribute("service", "userAuthorization");
        sendDispatcher(request, response, "admin/authorization/userAuthorization.jsp");
    }

    public void serviceActiveUserAuthor(String service, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(id, 1);
        HashMap<User, Role> listPaging = daouser.getAllPagingUserHashMap(1, 5, "");
        HashMap<User, Role> listUser = daouser.getAllAuthorizationUser();
        int totalPage = listUser.size() / 5;
        if (listUser.size() != totalPage * 5) {
            totalPage += 1;
        }
        request.setAttribute("index", 1);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listUser", listPaging);
        request.setAttribute("service", "userAuthorization");
        sendDispatcher(request, response, "admin/authorization/userAuthorization.jsp");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Seller Response Method. Click on the + sign on the left to edit the code.">
    public void serviceSellerResponse(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        List<Seller> listSellerRequest = daoseller.getSellerBySellerRequest();
        request.setAttribute("listSellerRequest", listSellerRequest);
        List<Seller> listAllSeller = daoseller.getAllSeller();
        request.setAttribute("listAllSeller", listAllSeller);
        sendDispatcher(request, response, "admin/authorization/sellerResponse.jsp");
    }

    private void serviceAcceptSellerRequest(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        //change seller status
        int sellerID = Integer.parseInt(request.getParameter("sellerID"));
        daoseller.acceptSellerRequest(sellerID);
        String strSellerID = request.getParameter("sellerID");
        //change user status
        Seller s = daoseller.getSellerID(strSellerID);
        User u = daouser.getUserBySellerId(s);
        u.setSell(1);
        u.setSystemRole(2);
        //add parameter to jsp
        List<Seller> listAllSeller = daoseller.getAllSeller();
        request.setAttribute("listAllSeller", listAllSeller);
        List<Seller> listSellerRequest = daoseller.getSellerBySellerRequest();
        request.setAttribute("listSellerRequest", listSellerRequest);
        sendDispatcher(request, response, "admin/authorization/sellerResponse.jsp");
    }

    private void serviceDenySellerRequest(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        int sellerID = Integer.parseInt(request.getParameter("sellerID"));
        daoseller.denySellerRequest(sellerID);
        List<Seller> listAllSeller = daoseller.getAllSeller();
        request.setAttribute("listAllSeller", listAllSeller);
        List<Seller> listSellerRequest = daoseller.getSellerBySellerRequest();
        request.setAttribute("listSellerRequest", listSellerRequest);
        sendDispatcher(request, response, "admin/authorization/sellerResponse.jsp");
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Role methods. Click on the + sign on the left to edit the code.">
    public void serviceRoleManagement(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        List<Role> role = daorole.getAllRole();
        request.setAttribute("role", role);
        sendDispatcher(request, response, "admin/authorization/roleAuthorization.jsp");
    }

    public void serviceRoleDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addRoleDetail")) {
            sendDispatcher(request, response, "admin/authorization/editRole.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("roleID"));
        Role roleDetail = daorole.getRoleId(id);
        request.setAttribute("roleDetail", roleDetail);
        sendDispatcher(request, response, "admin/authorization/editRole.jsp");
    }

    public void serviceAddRole(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        String roleName = request.getParameter("roleName");
        int adminPermission = Integer.parseInt(request.getParameter("adminPermission"));
        int sellerPermission = Integer.parseInt(request.getParameter("sellerPermission"));
        int customerPermission = Integer.parseInt(request.getParameter("customerPermission"));
        boolean isExist = false;

        if (daorole.checkExistRoleName(roleName) || daorole.checkExistRoleId(roleID)) {
            isExist = true;
        }

        if (isExist == true) {
            request.setAttribute("adminPermission", adminPermission);
            request.setAttribute("sellerPermission", sellerPermission);
            request.setAttribute("customerPermission", customerPermission);
            String state = "fail";
            request.setAttribute("state", state);
            String mess = "Add fail because duplicate information";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "addRoleDetail");
            sendDispatcher(request, response, "admin/authorization/editRole.jsp");
        }

        if (isExist == false) {
            Role newRole = new Role();
            newRole.setRoleID(roleID);
            newRole.setRoleName(roleName);
            newRole.setAdminPermission(adminPermission);
            newRole.setSellerPermission(sellerPermission);
            newRole.setCustomerPermission(customerPermission);
            daorole.addRole(newRole);
            String state = "success";
            request.setAttribute("state", state);
            List<Role> listRole = daorole.getAllRole();
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("role", listRole);
            sendDispatcher(request, response, "admin/authorization/roleAuthorization.jsp");
        }
    }

    public void serviceUpdateRole(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        Role role = daorole.getRoleId(roleID);
        String roleName = request.getParameter("roleName");
        int adminPermission = Integer.parseInt(request.getParameter("adminPermission"));
        int sellerPermission = Integer.parseInt(request.getParameter("sellerPermission"));
        int customerPermission = Integer.parseInt(request.getParameter("customerPermission"));
        boolean isExist = false;
        if (daorole.checkExistRoleName(roleName) && !roleName.equals(role.getRoleName())) {
            isExist = true;
        }
        if (daorole.checkExistRoleId(roleID) && roleID != role.getRoleID()) {
            isExist = true;
        }
        if (isExist == true) {
            request.setAttribute("service", "updateRoleDetail");
            request.setAttribute("roleDetail", role);
            String mess = "Update fail because duplicate information";
            String state = "fail";
            request.setAttribute("state", state);
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "admin/authorization/editRole.jsp");
        }
        if (isExist == false) {
            role.setRoleID(roleID);
            role.setRoleName(roleName);
            role.setAdminPermission(adminPermission);
            role.setSellerPermission(sellerPermission);
            role.setCustomerPermission(customerPermission);
            daorole.editRole(role);
            String state = "success";
            request.setAttribute("state", state);
            List<Role> listRole = daorole.getAllRole();
            request.setAttribute("role", listRole);
            request.setAttribute("roleDetail", role);
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "updateRoleDetail");
            sendDispatcher(request, response, "admin/authorization/editRole.jsp");
        }
    }

    public void serviceDeleteRole(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        int id = Integer.parseInt(request.getParameter("roleID"));
        daorole.deleteRole(id);
        List<Role> listRole = daorole.getAllRole();
        request.setAttribute("role", listRole);
        sendDispatcher(request, response, "admin/authorization/roleAuthorization.jsp");
    }

    public void serviceSearchRole(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        request.setAttribute("service", service);
        String search = request.getParameter("search");
        List<Role> listRole = daorole.searchRole(search);
        for (Role role : listRole) {
            pr.print("<tr>"
                    + "<td><div>" + role.getRoleID() + " </div></td>"
                    + "<td><div>" + role.getRoleName() + "</div></td>"
                    + "<td><div>" + role.getAdminPermission() + "</div></td>"
                    + "<td><div>" + role.getSellerPermission() + "</div></td>"
                    + "<td><div>" + role.getCustomerPermission() + "</div></td>"
                    + "<td><div>" + role.getStatus() + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updateRole&roleID=" + role.getRoleID() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deleteRole&roleID=" + role.getRoleID() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
    }//</editor-fold>

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileUploadException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileUploadException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
