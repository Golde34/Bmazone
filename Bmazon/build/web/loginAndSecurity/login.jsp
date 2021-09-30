<%-- 
    Document   : login
    Created on : Jun 29, 2021, 11:45:24 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="${contextPath}/css/login.css"type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    </head>
    <body>
        <style>
            body{
                background-image: white;
            }
        </style>
        <div class="login-wrap">
            <div class="login-html">
                <div class="login-form">
                    <div class="sign-up-html">
                        <div class="col s12 m6 offset-m3 center-align">
                            <a class="oauth-container btn darken-4 white black-text" href="#" style="text-transform:none; border-radius: 10px">
                                <div class="left">
                                    <img width="20px" style="margin-top:7px; margin-right:8px" alt="Google sign-in" 
                                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
                                </div>
                                Sign in with Google
                            </a>
                        </div>
                        <br>
                        <div class="col s12 m6 offset-m3 center-align">
                            <a class="oauth-container btn darken-4 white black-text" href="${contextPath}/loginAndSecurity/loginPass.jsp" style="text-transform:none; border-radius: 10px">
                                <div class="left">
                                    <img width="20px" style="margin-top:7px; margin-right:8px" alt="User sign-in" 
                                         src="https://png.pngtree.com/png-vector/20190511/ourmid/pngtree-vector-key-icon-png-image_1028662.jpg" />
                                </div>
                                Sign in with Password
                            </a>
                        </div>
                        <br>
                        
                        <div class="col s12 m6 offset-m3 center-align">
                        No account?<a style="color: blue" href="${contextPath}/LoginControllerMap?service=loginDemo" >
                            <i class="fas fa-angle-left"></i> Request a demo here!
                        </a>
                        </div>
                    </div>
                </div>
            </div>
    </body>
    <script language='javascript' type='text/javascript'>
        function check(input) {
            if (input.value != document.getElementById('password').value) {
                input.setCustomValidity('Password Must be Matching.');
            } else {
                // input is valid -- reset the error message
                input.setCustomValidity('');
            }
        }
    </script>

</html>
