/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

/**
 *
 * @author nguye
 */
public class UserViewModel {

    UserService userService = new UserService();

    public void userController(String service, HttpServletRequest request, HttpServletResponse response, ServletContext servlet) throws 
            NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        //Logout service
        if (service.equalsIgnoreCase("logout")) {
            userService.serviceLogout(request, response);
        }
        if (service.equalsIgnoreCase("changepass")) {
            userService.serviceChangePassword(request, response);
        }
        if (service.equalsIgnoreCase("changepassPage")) {
            userService.serviceChangePasswordPage(request, response);
        }
        if (service.equalsIgnoreCase("account")) {
            userService.serviceAccount(request, response);
        }
        if (service.equalsIgnoreCase("info")) {
            userService.serviceInfo(request, response);
        }

        //Edit public profile Service

        if (service.equalsIgnoreCase("editProfile")) {
            userService.serviceEditProfile(request, response);
        }
        if (service.equalsIgnoreCase("changeInfo")) {
            userService.serviceChangeInfoPublicProfile(request, response);
        }
        if (service.equalsIgnoreCase("editPrivateProfile")) {
            userService.serviceEditPrivateProfile(request, response);
        }
        if (service.equalsIgnoreCase("changePrivateInfo")) {
            userService.serviceChangeInfoPrivateProfile(request, response);
        }
        if (service.equalsIgnoreCase("uploadProfileImage")) {
            userService.serviceUploadProfileImage(request, response);
        }
        if (service.equalsIgnoreCase("updateProfileImage")) {
            userService.serviceUpdateProfileImage(request, response, servlet);
        }
        if (service.equalsIgnoreCase("uploadBackgroundImage")) {
            userService.serviceUploadBackgroundImage(request, response);
        }
        if (service.equalsIgnoreCase("updateBackgroundImage")) {
            userService.serviceUpdateBackgroundImage(request, response, servlet);
        }
        if (service.equalsIgnoreCase("editWallet")) {
            userService.serviceEditWallet(request, response);
        }
        if (service.equalsIgnoreCase("verifyWalletDeposit")) {
            userService.serviceVerifyWalletDeposit(request, response);
        }
        if (service.equalsIgnoreCase("verifyWalletWithdrawal")) {
            userService.serviceVerifyWalletWithdrawal(request, response);
        }
        if (service.equalsIgnoreCase("deposit")) {
            userService.serviceDeposit(request, response);
        }
        if (service.equalsIgnoreCase("withdrawal")) {
            userService.serviceWithdrawal(request, response);
        }
        if (service.equalsIgnoreCase("historyTransaction")) {
            userService.serviceHistoryTransaction(service, request, response);
        }
        if (service.equalsIgnoreCase("pagingtransaction")) {
            userService.servicePagingTransaction(service, request, response);
        }
        if (service.equalsIgnoreCase("showpagetransaction")) {
            userService.serviceShowPageTransaction(service, request, response);
        }
        if (service.equalsIgnoreCase("turnOnSalesFeature")) {
            userService.serviceTurnOnSalesFeature(request, response);
        }
        if (service.equalsIgnoreCase("requestSeller")) {
            userService.serviceSellerRequest(request, response);
        }
        if (service.equalsIgnoreCase("editDeniedSellerInformation")) {
            userService.serviceEditDenied(request, response);
        }
        if (service.equalsIgnoreCase("listAllComments")) {
            userService.serviceListComment(request, response);
        }
    }

}
