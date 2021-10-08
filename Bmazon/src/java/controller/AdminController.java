/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

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
    GalleryDAO daogallery = new GalleryDAO();
    ShipCompanyDAO daocompany = new ShipCompanyDAO();
    ProductDAO daoproduct = new ProductDAO();
    ProductTypeDAO daoproducttype = new ProductTypeDAO();
    CategoryDAO daocategory = new CategoryDAO();
    GenreDAO daogenre = new GenreDAO();
    UserDAO daouser = new UserDAO();
    WareHouseDAO daowarehouse = new WareHouseDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            if (service == null) {
                service = "AdminDashBoard";
            }

            //Admin Dashboard
            if (service.equalsIgnoreCase("AdminDashBoard")) {
                serviceAdminDashboard(request, response);
            }

            //User Management
            if (service.equalsIgnoreCase("usermanagement")) {
                serviceUserManagement(request, response);
            }

            //User detail to add and update
            if (service.equalsIgnoreCase("updateuserdetail") || service.equalsIgnoreCase("adduserdetail")) {
                serviceUserDetail(service, request, response);
            }

            //Paging User
            if (service.equalsIgnoreCase("paging")) {
                servicePagingUser(request, response);
            }

            //Search User
            if (service.equalsIgnoreCase("searchuser")) {
                serviceSearchUser(request, response);
            }

            //Add user
            if (service.equalsIgnoreCase("adduser")) {
                serviceAddUser(request, response);
            }

            //Update User 
            if (service.equalsIgnoreCase("updateuser")) {
                serviceUpdateUser(request, response);
            }

            //Delete user
            if (service.equalsIgnoreCase("deleteuser")) {
                serviceDeleteUser(request, response);
            }

            //Product Manage
            if (service.equalsIgnoreCase("productmanagement")) {
                serviceProductManagement(request, response);
            }

            //Product detail to add and update
            if (service.equalsIgnoreCase("updateproductdetail") || service.equalsIgnoreCase("addproductdetail")) {
                serviceProductDetail(service, request, response);
            }

            //Search Product
            if (service.equalsIgnoreCase("searchproduct")) {
                serviceSearchProduct(request, response);
            }

            //Add Product
            if (service.equalsIgnoreCase("addproduct")) {
                serviceAddProduct(request, response);
            }

            //Update Product 
            if (service.equalsIgnoreCase("updateproduct")) {
                serviceUpdateProduct(request, response);
            }

            //Delete Product
            if (service.equalsIgnoreCase("deleteproduct")) {
                serviceDeleteProduct(request, response);
            }

            //Ship Company Manage
            if (service.equalsIgnoreCase("companymanagement")) {
                serviceCompanyManagement(request, response);
            }

            //Ship Company detail to add and update
            if (service.equalsIgnoreCase("updatecompanydetail") || service.equalsIgnoreCase("addcompanydetail")) {
                serviceCompanyDetail(service, request, response);
            }

            //Search Ship Company
            if (service.equalsIgnoreCase("searchcompany")) {
                serviceSearchCompany(request, response);
            }

            //Add Ship Company
            if (service.equalsIgnoreCase("addcompany")) {
                serviceAddCompany(request, response);
            }

            //Update Ship Company 
            if (service.equalsIgnoreCase("updatecompany")) {
                serviceUpdateCompany(request, response);
            }

            //Delete Ship Company
            if (service.equalsIgnoreCase("deletecompany")) {
                serviceDeleteCompany(request, response);
            }

            //Gallery Manage
            if (service.equalsIgnoreCase("gallerymanagement")) {
                serviceGalleryManagement(request, response);
            }

            //Gallery detail to add and update
            if (service.equalsIgnoreCase("updategallerydetail") || service.equalsIgnoreCase("addgallerydetail")) {
                serviceGalleryDetail(service, request, response);
            }

            //Search Gallery
            if (service.equalsIgnoreCase("searchgallery")) {
                serviceSearchGallery(request, response);
            }

            //Add Gallery
            if (service.equalsIgnoreCase("addproduct")) {
                serviceAddGallery(request, response);
            }

            //Update Gallery 
            if (service.equalsIgnoreCase("updategallery")) {
                serviceUpdateGallery(request, response);
            }

            //Delete Gallery
            if (service.equalsIgnoreCase("deletegallery")) {
                serviceDeleteGallery(request, response);
            }
        }
    }

    public void serviceAdminDashboard(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        ArrayList<User> listUser = daouser.getAllUser();
        request.setAttribute(("listUser"), listUser);
        sendDispatcher(request, response, "admin/admin.jsp");
    }
    // <editor-fold defaultstate="collapsed" desc="User methods. Click on the + sign on the left to edit the code.">

    public void serviceUserManagement(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<User> listPaging = daouser.pagingUser(1, 5,"");
        ArrayList<User> listUser =  daouser.getAllUser();
        int total = listUser.size()/5;
        request.setAttribute("index", 1);
        request.setAttribute("total", total+1);
        request.setAttribute("listUser", listPaging);
        sendDispatcher(request, response, "admin/paging.jsp");
    }

    public void serviceUserDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("adduserdetail")) {
            sendDispatcher(request, response, "admin/userdetail.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("userid"));
        User user = daouser.getUserById(id);
        request.setAttribute("user", user);
        sendDispatcher(request, response, "admin/userdetail.jsp");
    }
    
    public void servicePagingUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        int index=1, numOfRow=5;
        String search = request.getParameter("search");
        if(request.getParameter("index")!=null){
            index=Integer.parseInt(request.getParameter("index"));
        }
        if(request.getParameter("row")!=null){
            numOfRow=Integer.parseInt(request.getParameter("row"));
        }
        ArrayList<User> listPaging = daouser.pagingUser(index, numOfRow,search);
        ArrayList<User> listUser =  daouser.getAllUser();
        int totalResult = daouser.getPageNumber(search);
        int totalPage = listUser.size()/numOfRow;
        request.setAttribute("index", index);
        request.setAttribute("total", totalPage+1);
        request.setAttribute("listUser", listPaging);
        for (User user : listPaging) {
            pr.print("<tr>"
                    + "<td>" + user.getUsername() + " </td>"
                    + "<td>" + user.getPassword() + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td>" + user.getFullname() + "</td>"
                    + "<td>" + user.getPhoneNumber() + "</td>"
                    + "<td>" + user.getAddress() + "</td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updateuserdetail&userid=" + user.getUserId() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deleteuser&userid=" + user.getUserId() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
        if(request.getParameter("row")==null)
        sendDispatcher(request, response, "admin/paging.jsp");
    }

    public void serviceSearchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        String search = request.getParameter("search");
        ArrayList<User> listUser = daouser.searchUser(search);
        for (User user : listUser) {
            pr.print("<tr>"
                    + "<td>" + user.getUsername() + " </td>"
                    + "<td>" + user.getPassword() + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td>" + user.getFullname() + "</td>"
                    + "<td>" + user.getPhoneNumber() + "</td>"
                    + "<td>" + user.getAddress() + "</td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updateuserdetail&userid=" + user.getUserId() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deleteuser&userid=" + user.getUserId() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
    }

    public void serviceAddUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int role = Integer.parseInt(request.getParameter("role"));
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
            User user = new User(username, password, email, phone, 0, 0, fullname, "", address, "", "", "", gender, "", "", "", "", "", 0, role, 1);
            daouser.addUser(user);
            ArrayList<User> listUser = daouser.getAllUser();
            String state = "success";
            request.setAttribute("state", state);
            request.setAttribute("listUser", listUser);
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "adduserdetail");
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
    }

    public void serviceUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        User user = daouser.getUserById(Integer.parseInt(id));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int role = Integer.parseInt(request.getParameter("role"));
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
            user.setSystemRole(role);
            daouser.updateInfoUserByAdmin(user);
            String state = "success";
            request.setAttribute("state", state);
            ArrayList<User> listUser = daouser.getAllUser();
            request.setAttribute("listUser", listUser);
            request.setAttribute("user", user);
            request.setAttribute("service", "updateuserdetail");
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            sendDispatcher(request, response, "admin/userdetail.jsp");
        }
    }

    public void serviceDeleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("userid"));
        daouser.changeStatus(id, 0);
        ArrayList<User> listUser = daouser.getAllUser();
        request.setAttribute("listUser", listUser);
        sendDispatcher(request, response, "admin/usermanagement.jsp");
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Product methods. Click on the + sign on the left to edit the code.">
    public void serviceProductManagement(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceProductDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addproductdetail")) {
            sendDispatcher(request, response, "admin/productdetail.jsp");
            return;
        }
        String id = request.getParameter("producttypeid");
        ProductType producttype = daoproducttype.getProductTypeByPTypeID(id);
        Product product = daoproduct.getProductByID(producttype.getProductID());
        request.setAttribute("producttype", producttype);
        request.setAttribute("product", product);
        sendDispatcher(request, response, "admin/productdetail.jsp");
    }

    public void serviceSearchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        String search = request.getParameter("search");
        ArrayList<Product> listProduct = daoproduct.searchProduct(search);
        for (Product product : listProduct) {
            User user = daouser.getUserByProductId(product.getProductID());
            pr.print("<tr>"
                    + "<td><div>" + product.getProductName() + " </div></td>"
                    + "<td><div>" + product.getDescription() + "</div></td>"
                    + "<td><div>" + product.getRating() + "</div></td>"
                    + "<td><div>" + user.getFullname() + "</div></td>"
                    + "<td><div>" + product.getReleaseDate() + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updateproductdetail&producttypeid=" + product.getProductID() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deleteproduct&producttypeid=" + product.getProductID() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
    }

    public void serviceAddProduct(HttpServletRequest request, HttpServletResponse response) {
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
        producttype.setColor(color);
        producttype.setPrice(price);
        producttype.setSize(size);
        daoproducttype.addProductType(producttype);
        ArrayList<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("producttypeid");
        daoproducttype.deleteProductType(id);
        List<Product> listProduct = daoproduct.getAllProduct();
        request.setAttribute("listProduct", listProduct);
        sendDispatcher(request, response, "admin/productmanagement.jsp");
    }

    public void serviceUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Company methods. Click on the + sign on the left to edit the code.">
    public void serviceCompanyManagement(HttpServletRequest request, HttpServletResponse response) {
        List<ShipCompany> listCompany = daocompany.getAllShipCompany();
        request.setAttribute("listCompany", listCompany);
        sendDispatcher(request, response, "admin/companymanagement.jsp");
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

    public void serviceSearchCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        String search = request.getParameter("search");
        List<ShipCompany> listCompany = daocompany.searchShipCompany(search);
        for (ShipCompany company : listCompany) {
            pr.print("<tr>"
                    + "<td><div>" + company.getCompanyName() + " </div></td>"
                    + "<td><div>" + company.getCommitDate() + "</div></td>"
                    + "<td><div>" + company.getUnitCost() + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updatecompanydetail&companyid=" + company.getCompanyID() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deletecompany&companyid=" + company.getCompanyID() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
    }

    public void serviceDeleteCompany(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("companyid");
        daocompany.deleteShipCompany(id);
        List<ShipCompany> listCompany = daocompany.getAllShipCompany();
        request.setAttribute("listCompany", listCompany);
        sendDispatcher(request, response, "admin/companymanagement.jsp");
    }

    public void serviceAddCompany(HttpServletRequest request, HttpServletResponse response) {
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
            company.setCommitDate(Integer.parseInt(commitdate));
            company.setCompanyName(companyname);
            company.setUnitCost(Double.parseDouble(unitcost));
            company.setStatus(1);
            daocompany.addShipCompany(company);
            String state = "success";
            request.setAttribute("state", state);
            List<ShipCompany> listCompany = daocompany.getAllShipCompany();
            String mess = "Add successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("listCompany", listCompany);
            sendDispatcher(request, response, "admin/companymanagement.jsp");
        }
    }

    public void serviceUpdateCompany(HttpServletRequest request, HttpServletResponse response) {
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
            company.setCommitDate(Integer.parseInt(commitdate));
            company.setCompanyName(companyname);
            company.setUnitCost(Double.parseDouble(unitcost));
            daocompany.editShipCompany(company);
            String state = "success";
            request.setAttribute("state", state);
            List<ShipCompany> listCompany = daocompany.getAllShipCompany();
            request.setAttribute("listCompany", listCompany);
            request.setAttribute("company", company);
            String mess = "Update successfully";
            request.setAttribute("mess", mess);
            request.setAttribute("service", "updatecompanydetail");
            sendDispatcher(request, response, "admin/companydetail.jsp");
        }
    }//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Gallery methods. Click on the + sign on the left to edit the code.">
    public void serviceGalleryManagement(HttpServletRequest request, HttpServletResponse response) {
        List<Gallery> listGallery = daogallery.getAllGallery();
        request.setAttribute("listGallery", listGallery);
        sendDispatcher(request, response, "admin/gallerymanagement.jsp");
    }

    public void serviceGalleryDetail(String service, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", service);
        if (service.equalsIgnoreCase("addgallerydetail")) {
            sendDispatcher(request, response, "admin/gallerydetail.jsp");
            return;
        }
        int id = Integer.parseInt(request.getParameter("galleryid"));
        Gallery gallery = daogallery.getGalleryById(1);
        Product product = daoproduct.getProductByID(gallery.getProductID());
        ProductType producttype = daoproducttype.getProductTypeByPTypeID(gallery.getProductTypeID());
        request.setAttribute("product", product);
        request.setAttribute("producttype", producttype);
        request.setAttribute("gallery", gallery);
        sendDispatcher(request, response, "admin/gallerydetail.jsp");
    }

    public void serviceSearchGallery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pr = response.getWriter();
        String search = request.getParameter("search");
        ArrayList<User> listUser = daouser.searchUser(search);
        for (User user : listUser) {
            pr.print("<tr>"
                    + "<td>" + user.getUsername() + " </td>"
                    + "<td>" + user.getPassword() + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td>" + user.getFullname() + "</td>"
                    + "<td>" + user.getPhoneNumber() + "</td>"
                    + "<td>" + user.getAddress() + "</td>"
                    + "<td><div><a href=\"AdminControllerMap?service=updateuserdetail&userid=" + user.getUserId() + "\"><span class=\"fas fa-edit\"></span></a>"
                    + "</div></td>"
                    + "<td><div><a href=\"AdminControllerMap?service=deleteuser&userid=" + user.getUserId() + "\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"fas fa-trash-alt\"></span></a></div></td>" + "</tr>"
            );
        }
    }

    public void serviceAddGallery(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void serviceDeleteGallery(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("galleryid");
        daogallery.deleteGallery(Integer.parseInt(id));
        List<Gallery> listGallery = daogallery.getAllGallery();
        request.setAttribute("listGallery", listGallery);
        sendDispatcher(request, response, "admin/gallerymanagement.jsp");
    }

    public void serviceUpdateGallery(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//</editor-fold>

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdminController.class
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
