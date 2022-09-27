/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.HomePageService;

/**
 *
 * @author nguye
 */
public class HomePageViewModel {

    HomePageService homePageService = new HomePageService();

    public void homePageController(String service, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (service.equalsIgnoreCase("Homepage")) {
            homePageService.serviceHomepage(request, response);
        }

        if (service.equalsIgnoreCase("list")) {
            homePageService.serviceList(request, response);
        }
        if (service.equalsIgnoreCase("ByCate")) {
            homePageService.serviceByCate(request, response);
        }
        if (service.equalsIgnoreCase("ByGenre")) {
            homePageService.serviceByGenre(request, response);
        }
        if (service.equalsIgnoreCase("search")) {
            homePageService.serviceSearch(request, response);
        }
        if (service.equalsIgnoreCase("shopPage")) {
            homePageService.serviceShopPage(request, response);
        }
        if (service.equalsIgnoreCase("check")) {
            homePageService.serviceFilter(request, response);
        }
        if (service.equalsIgnoreCase("filter")) {
            homePageService.Filter(request, response);
        }
        if (service.equalsIgnoreCase("shopPageProduct")) {
            homePageService.serviceShopPageProduct(request, response);
        }
        if (service.equalsIgnoreCase("userInteraction")) {
            homePageService.serviceUserInteraction(request, response);
        }
    }
}