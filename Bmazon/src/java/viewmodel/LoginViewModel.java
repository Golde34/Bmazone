/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;

/**
 *
 * @author nguye
 */
public class LoginViewModel {

    LoginService loginService = new LoginService();

    public void loginController(String service, HttpServletRequest request, HttpServletResponse response) throws ServletException, 
            IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        if (service.equalsIgnoreCase("login")) {
            loginService.serviceLogin(request, response);
        }

//            //Login google
//            if (service.equalsIgnoreCase("googleLogin")) {
//                serviceGoogleLogin(request, response);
//            }
//
//            //Login facebook
//            if (service.equalsIgnoreCase("facebookLogin")) {
//                serviceFacebookLogin(request, response);
//            }
        if (service.equalsIgnoreCase("register")) {
            loginService.serviceRegister(request, response);
        }
        if (service.equalsIgnoreCase("verify")) {
            loginService.serviceVerifyAccount(request, response);
        }
        if (service.equalsIgnoreCase("forgotPass")) {
            loginService.serviceForgotPassword(request, response);
        }
        if (service.equalsIgnoreCase("resetPass")) {
            loginService.serviceResetPassword(request, response);
        }
    }
}
