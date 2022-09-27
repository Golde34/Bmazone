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
import service.SellerService;

/**
 *
 * @author nguye
 */
public class SellerViewModel {

    SellerService sellerService = new SellerService();

    public void dashboardController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("SellerDashboard")) {
            sellerService.serviceSellerDashboard(request, response);
        }
        if (service.equalsIgnoreCase("pagingdashboard")) {
            sellerService.servicePagingDashboard(request, response);
        }
        if (service.equalsIgnoreCase("showpagedashboard")) {
            sellerService.serviceShowPageDashboard(request, response);
        }
        if (service.equalsIgnoreCase("dashboarddetail")) {
            sellerService.serviceSellerDashboardDetail(request, response);
        }
    }

    public void productController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        if (service.equalsIgnoreCase("productmanagement")) {
            sellerService.serviceProductManagement(request, response);
        }
        if (service.equalsIgnoreCase("productdetail")) {
            sellerService.serviceProductDetail(request, response);
        }
        if (service.equalsIgnoreCase("addproduct")) {
            sellerService.serviceAddProduct(request, response);
        }
        if (service.equalsIgnoreCase("updateproductdetail")) {
            sellerService.serviceUpdateProductDetail(request, response);
        }
        if (service.equalsIgnoreCase("deactiveproduct")) {
            sellerService.serviceDeactiveProduct(request, response);
        }
        if (service.equalsIgnoreCase("activeproduct")) {
            sellerService.serviceActiveProduct(request, response);
        }
        if (service.equalsIgnoreCase("addproducttype")) {
            sellerService.serviceAddProductType(request, response);
        }
        if (service.equalsIgnoreCase("deactiveproducttype")) {
            sellerService.serviceDeactiveProductType(request, response);
        }
        if (service.equalsIgnoreCase("activeproducttype")) {
            sellerService.serviceActiveProductType(request, response);
        }
        if (service.equalsIgnoreCase("pagingproduct")) {
            sellerService.servicePagingProduct(request, response);
        }
        if (service.equalsIgnoreCase("showpageproduct")) {
            sellerService.serviceShowPageProduct(request, response);
        }
        if (service.equalsIgnoreCase("pagingproducttype")) {
            sellerService.servicePagingProductType(request, response);
        }
        if (service.equalsIgnoreCase("showpageproducttype")) {
            sellerService.serviceShowPageProductType(request, response);
        }
    }

    public void orderController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("ordermanagement")) {
            sellerService.serviceOrderManagement(request, response);
        }
        if (service.equalsIgnoreCase("pagingorder")) {
            sellerService.servicePagingOrder(request, response);
        }
        if (service.equalsIgnoreCase("showpageorder")) {
            sellerService.serviceShowPageOrder(request, response);
        }

        //OrderResponse
        if (service.equalsIgnoreCase("orderResponse")) {
            sellerService.serviceOrderResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("pagingOrderResponse")) {
            sellerService.servicePagingOrderResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("showPageOrderResponse")) {
            sellerService.serviceShowPageOrderResponse(service, request, response);
        }
        if (service.equalsIgnoreCase("handleOrder")) {
            sellerService.serviceHandleOrder(service, request, response);
        }
        if (service.equalsIgnoreCase("orderdetail")) {
            sellerService.serviceOrderDetail(request, response);
        }
    }

    public void galleryController(String service, HttpServletRequest request, HttpServletResponse response, ServletContext servlet) throws IOException, ServletException, FileUploadException {
        if (service.equalsIgnoreCase("gallerymanagement")) {
            sellerService.serviceGalleryManagement(request, response);
        }
        if (service.equalsIgnoreCase("showpagegallery")) {
            sellerService.serviceShowPageGallery(request, response);
        }
        if (service.equalsIgnoreCase("paginggallery")) {
            sellerService.servicePagingGallery(request, response);
        }
        if (service.equalsIgnoreCase("addgallery")) {
            sellerService.serviceAddGallery(request, response, servlet);
        }
        if (service.equalsIgnoreCase("gallerydetail")) {
            sellerService.serviceGalleryDetail(request, response);
        }
        if (service.equalsIgnoreCase("updategallery")) {
            sellerService.serviceUpdateGallery(request, response, servlet);
        }
        if (service.equalsIgnoreCase("deactivegallery")) {
            sellerService.serviceDeactiveGallery(request, response);
        }
        if (service.equalsIgnoreCase("activegallery")) {
            sellerService.serviceActiveGallery(request, response);
        }
    }

    public void informationController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("editSellerInformation")) {
            sellerService.serviceEditSellerInformation(request, response);
        }
        if (service.equalsIgnoreCase("feedback")) {
            sellerService.serviceFeedBack(request, response);
        }
        if (service.equalsIgnoreCase("showpagecomment")) {
            sellerService.servicePageComment(request, response);
        }
        if (service.equalsIgnoreCase("commentpaging")) {
            sellerService.servicePagingComment(request, response);
        }
    }

    public void customerController(String service, HttpServletRequest request, HttpServletResponse response) {
        if (service.equalsIgnoreCase("customermanagement")) {
            sellerService.serviceCustomerManagement(request, response);
        }
        if (service.equalsIgnoreCase("customerdetail")) {
            sellerService.serviceCustomerDetail(request, response);
        }
        if (service.equalsIgnoreCase("sendthanks")) {
            sellerService.serviceSendThanks(request, response);
        }
    }
}
