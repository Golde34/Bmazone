/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileUploadException;
import service.AdminService;

/**
 *
 * @author nguye
 */
public class AdminViewModel {

    //Service initialze
    AdminService adminService = new AdminService();

    public void adminDashBoardController(String service, HttpServletResponse response, HttpServletRequest request) {
        //Admin Dashboard
        if (service.equalsIgnoreCase("AdminDashBoard")) {
            adminService.serviceAdminDashboard(service, request, response);
        }
    }

    public void userController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //User Management
        if (service.equalsIgnoreCase("usermanagement")) {
            adminService.serviceUserManagement(service, request, response);
        }
        //User detail to add and update
        if (service.equalsIgnoreCase("updateuserdetail") || service.equalsIgnoreCase("adduserdetail")) {
            adminService.serviceUserDetail(service, request, response);
        }
        //Paging User
        if (service.equalsIgnoreCase("paginguser")) {
            adminService.servicePagingUser(service, request, response);
        }
        //Show Page User
        if (service.equalsIgnoreCase("showpageuser")) {
            adminService.serviceShowPageUser(request, response);
        }
        //Add user
        if (service.equalsIgnoreCase("adduser")) {
            adminService.serviceAddUser(service, request, response);
        }
        //Update User 
        if (service.equalsIgnoreCase("updateuser")) {
            adminService.serviceUpdateUser(service, request, response);
        }
        //Delete user
        if (service.equalsIgnoreCase("deleteuser")) {
            adminService.serviceDeleteUser(service, request, response);
        }
        //Active user
        if (service.equalsIgnoreCase("activeuser")) {
            adminService.serviceActiveUser(service, request, response);
        }
    }

    public void userAuthorizationController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("userAuthorization")) {
            adminService.serviceUserAuthorization(service, request, response);
        }
        if (service.equalsIgnoreCase("showpageuserAu")) {
            adminService.serviceShowPageUserAu(request, response);
        }
        if (service.equalsIgnoreCase("paginguserAu")) {
            adminService.servicePagingUserAu(service, request, response);
        }
        if (service.equalsIgnoreCase("deleteuserAuthor")) {
            adminService.serviceDeleteUserAuthor(service, request, response);
        }
        if (service.equalsIgnoreCase("activeuserAuthor")) {
            adminService.serviceActiveUserAuthor(service, request, response);
        }
    }

    public void employeeController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if (service.equalsIgnoreCase("employeemanagement")) {
            adminService.serviceEmployeeManagement(service, request, response);
        }
        if (service.equalsIgnoreCase("updateemployeedetail") || service.equalsIgnoreCase("addemployeedetail")) {
            adminService.serviceEmployeeDetail(service, request, response);
        }
        if (service.equalsIgnoreCase("pagingemployee")) {
            adminService.servicePagingEmployee(service, request, response);
        }
        if (service.equalsIgnoreCase("showpageemployee")) {
            adminService.serviceShowPageEmployee(request, response);
        }
        if (service.equalsIgnoreCase("addemployee")) {
            adminService.serviceAddEmployee(service, request, response);
        }
        if (service.equalsIgnoreCase("updateemployee")) {
            adminService.serviceUpdateEmployee(service, request, response);
        }
        if (service.equalsIgnoreCase("deleteemployee")) {
            adminService.serviceDeleteEmployee(service, request, response);
        }
        if (service.equalsIgnoreCase("activeemployee")) {
            adminService.serviceActiveEmployee(service, request, response);
        }
    }

    public void sellerController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("sellermanagement")) {
                adminService.serviceSellerManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("updatesellerdetail")) {
                adminService.serviceSellerDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingseller")) {
                adminService.servicePagingSeller(service, request, response);
            }
            if (service.equalsIgnoreCase("showpageseller")) {
                adminService.serviceShowPageSeller(request, response);
            }
            if (service.equalsIgnoreCase("updateseller")) {
                adminService.serviceUpdateSeller(service, request, response);
            }
            if (service.equalsIgnoreCase("deleteseller")) {
                adminService.serviceDeleteSeller(service, request, response);
            }
            if (service.equalsIgnoreCase("activeseller")) {
                adminService.serviceActiveSeller(service, request, response);
            }
    }

    public void productController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
            if (service.equalsIgnoreCase("productmanagement")) {
                adminService.serviceProductManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("productdetail")) {
                adminService.serviceProductDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingproduct")) {
                adminService.servicePagingProduct(service, request, response);
            }
            if (service.equalsIgnoreCase("showpageproduct")) {
                adminService.serviceShowPageProduct(request, response);
            }
            if (service.equalsIgnoreCase("addproduct")) {
                adminService.serviceAddProduct(service, request, response);
            }
            if (service.equalsIgnoreCase("updateproduct")) {
                adminService.serviceUpdateProduct(service, request, response);
            }
            if (service.equalsIgnoreCase("deleteproduct")) {
                adminService.serviceDeleteProduct(service, request, response);
            }
            if (service.equalsIgnoreCase("activeproduct")) {
                adminService.serviceActiveProduct(service, request, response);
            }
            if (service.equalsIgnoreCase("deleteproducttype")) {
                adminService.serviceDeleteProductType(service, request, response);
            }
            if (service.equalsIgnoreCase("activeproducttype")) {
                adminService.serviceActiveProductType(service, request, response);
            }

    }

    public void shipCompanyController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("companymanagement")) {
                adminService.serviceCompanyManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingcompany")) {
                adminService.servicePagingCompany(service, request, response);
            }
            if (service.equalsIgnoreCase("showpagecompany")) {
                adminService.serviceShowPageCompany(request, response);
            }
            if (service.equalsIgnoreCase("updatecompanydetail") || service.equalsIgnoreCase("addcompanydetail")) {
                adminService.serviceCompanyDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("addcompany")) {
                adminService.serviceAddCompany(service, request, response);
            }
            if (service.equalsIgnoreCase("updatecompany")) {
                adminService.serviceUpdateCompany(service, request, response);
            }
            if (service.equalsIgnoreCase("deletecompany")) {
                adminService.serviceDeleteCompany(service, request, response);
            }
            if (service.equalsIgnoreCase("activecompany")) {
                adminService.serviceActiveCompany(service, request, response);
            }
    }

    public void galleryController(String service, HttpServletResponse response, HttpServletRequest request, ServletContext servlet) throws IOException, ServletException, FileUploadException {
            if (service.equalsIgnoreCase("gallerymanagement")) {
                adminService.serviceGalleryManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingGallery")) {
                adminService.servicePagingGallery(service, request, response);
            }
            if (service.equalsIgnoreCase("showpageGallery")) {
                adminService.serviceShowPageGallery(request, response);
            }
            if (service.equalsIgnoreCase("gallerydetail")) {
                adminService.serviceGalleryDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("addproduct")) {
                adminService.serviceAddGallery(service, request, response);
            }
            if (service.equalsIgnoreCase("updategallery")) {
                adminService.serviceUpdateGallery(service, request, response, servlet);
            }
            if (service.equalsIgnoreCase("deletegallery")) {
                adminService.serviceDeleteGallery(service, request, response);
            }
            if (service.equalsIgnoreCase("activegallery")) {
                adminService.serviceActiveGallery(service, request, response);
            }
    }

    public void categoryController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("categorymanagement")) {
                adminService.serviceCategoryManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("updatecategorydetail") || service.equalsIgnoreCase("addcategorydetail")) {
                adminService.serviceCategoryDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("addgenredetail")) {
                adminService.serviceGenreDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingcategory")) {
                adminService.servicePagingCategory(service, request, response);
            }
            if (service.equalsIgnoreCase("showpagecategory")) {
                adminService.serviceShowPageCategory(request, response);
            }
            if (service.equalsIgnoreCase("addcategory")) {
                adminService.serviceAddCategory(service, request, response);
            }
            if (service.equalsIgnoreCase("addgenre")) {
                adminService.serviceAddGenre(service, request, response);
            }
            if (service.equalsIgnoreCase("updatecategory")) {
                adminService.serviceUpdateCategory(service, request, response);
            }
            if (service.equalsIgnoreCase("deletecategory")) {
                adminService.serviceDeleteCategory(service, request, response);
            }
            if (service.equalsIgnoreCase("activecategory")) {
                adminService.serviceActiveCategory(service, request, response);
            }
            if (service.equalsIgnoreCase("deletegenre")) {
                adminService.serviceDeleteGenre(service, request, response);
            }
            if (service.equalsIgnoreCase("activegenre")) {
                adminService.serviceActiveGenre(service, request, response);
            }
    }

    public void orderResponseController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("orderResponse")) {
                adminService.serviceOrderResponse(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingOrderResponse")) {
                adminService.servicePagingOrderResponse(service, request, response);
            }
            if (service.equalsIgnoreCase("showPageOrderResponse")) {
                adminService.serviceShowPageOrderResponse(service, request, response);
            }
            if (service.equalsIgnoreCase("orderDetail")) {
                adminService.serviceOrderDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("handleOrder")) {
                adminService.serviceHandleOrder(service, request, response);
            }
    }

    public void sellerResponseController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("sellerResponse")) {
                adminService.serviceSellerResponse(service, request, response);
            }
            if (service.equalsIgnoreCase("acceptSeller")) {
                adminService.serviceAcceptSellerRequest(service, request, response);
            }
            if (service.equalsIgnoreCase("denySeller")) {
                adminService.serviceDenySellerRequest(service, request, response);
            }
            if (service.equalsIgnoreCase("pagingSellerResponse")) {
                adminService.servicePagingSellerResponse(service, request, response);
            }
            if (service.equalsIgnoreCase("showpageSellerResponse")) {
                adminService.serviceShowPageSellerResponse(request, response);
            }
    }

    public void roleController(String service, HttpServletResponse response, HttpServletRequest request) throws IOException {
            if (service.equalsIgnoreCase("roleDisplay")) {
                adminService.serviceRoleManagement(service, request, response);
            }
            if (service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {
                adminService.serviceRoleDetail(service, request, response);
            }
            if (service.equalsIgnoreCase("addRole")) {
                adminService.serviceAddRole(service, request, response);
            }
            if (service.equalsIgnoreCase("updateRole")) {
                adminService.serviceUpdateRole(service, request, response);
            }
            if (service.equalsIgnoreCase("deleteRole")) {
                adminService.serviceDeleteRole(service, request, response);
            }
            if (service.equalsIgnoreCase("searchRole")) {
                adminService.serviceSearchRole(service, request, response);
            }
    }
}
