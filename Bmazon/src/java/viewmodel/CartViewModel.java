/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CartService;

/**
 *
 * @author nguye
 */
public class CartViewModel {
    
    CartService cartService = new CartService();
    
    public void cartController(PrintWriter out, String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("Cart")) {
                cartService.serviceCart(request, response);
            }

            if (service.equalsIgnoreCase("AddToCart")) {
                cartService.serviceAddToCart(request, response);
            }

            if (service.equalsIgnoreCase("Delete")) {
                cartService.serviceDelete(request, response);
            }

            if (service.equalsIgnoreCase("Update")) {
                cartService.serviceUpdate(request, response);
            }

            if (service.equalsIgnoreCase("Billing Page")) {
                cartService.serviceBillingPage(out, request, response);
            }

            if (service.equalsIgnoreCase("CheckOut")) {
                cartService.serviceCheckOut(request, response);
            }
            if (service.equalsIgnoreCase("MyOrder")) {
                cartService.serviceMyOrder(request, response);
            }
            if (service.equalsIgnoreCase("OrderDetail")) {
                cartService.serviceOrderDetail(request, response);
            }
            if (service.equalsIgnoreCase("Deactice")) {
                cartService.serviceDeactive(request, response);
            }
    }
}
