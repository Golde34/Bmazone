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
    </head>
    <body>
        <%
            String mess = (String) request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        %>
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" checked="checked" name="tab" class="sign-in" ><label for="tab-1" class="tab">Sign In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up" ><label for="tab-2" class="tab">Sign Up</label> 
                <div class="login-form">
                    <!--Sign in Service-->
                    <div class="sign-in-htm">
                        <form action="/Bmazon/UserControllerMap" method="POST">
                            <div class="group">
                                <label for="user" class="label" >Username</label>
                                <input id="user" type="text" name="username" placeholder="Username" class="input" required autofocus="">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="pass" type="password" name="password" placeholder="Password" class="input" data-type="password" required autofocus="">
                            </div>
                            <h6 style="color: yellow" style="font-size: small" ><%= mess%></h6>
                            <div class="group">
                                <input type="hidden" name="service" value="login">
                                <input type="submit" class="button" value="Sign In">
                            </div>
                        </form>
                        <br>
                        <a style="color: yellow" href="${contextPath}/jsp/forgot.jsp" >
                            <i class="fas fa-angle-left"></i> Forgot Password
                        </a>
                        <div class="hr"></div>
                    </div>
                    <!--Sign up Service-->
                    <div class="sign-up-htm">
                        <form action="/Bmazon/UserControllerMap" method="get">
                            <div class="group">
                                <label for="user" class="label">Username</label>
                                <input id="user" type="text" name="signupusername" placeholder="Username" class="input" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="pass" type="password" name="signuppass" class="input" placeholder="Password" data-type="password" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Repeat Password</label>
                                <input id="pass" type="password" name="resignuppass" class="input" placeholder="Repeat Password" data-type="password"required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Full Name</label>
                                <input id="pass" type="text" name="fname" class="input" placeholder="NguyenVanA" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Email</label>
                                <input id="pass" type="text" name="email" class="input" placeholder="abc@xyz.com" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Phone</label>
                                <input id="pass" type="text" name="phone" class="input" placeholder="0987654321" required autofocus="" >
                            </div>
                            <h6 style="color: yellow;" style="font-size: small" >${mess}</h6>
                            <div class="group">
                                <input type="submit" class="button" value="Sign Up">
                                <input type="hidden" name="service" value="register">
                            </div>
                        </form>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <label for="tab-1">Already Member?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
