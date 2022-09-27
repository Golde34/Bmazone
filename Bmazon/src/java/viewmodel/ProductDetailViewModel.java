/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductDetailService;

/**
 *
 * @author nguye
 */
public class ProductDetailViewModel {

    ProductDetailService productDetailService = new ProductDetailService();

    public void productDetailController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("getProductDetail")) {
            productDetailService.serviceProductDetail(request, response);
        }
        if (service.equalsIgnoreCase("getRelatedProduct")) {
            productDetailService.serviceRelatedProduct(request, response);
        }
        if (service.equalsIgnoreCase("getPrice")) {
            productDetailService.serviceGetPrice(request, response);
        }
        if (service.equalsIgnoreCase("comment")) {
            productDetailService.serviceComment(request, response);
        }
    }
}
