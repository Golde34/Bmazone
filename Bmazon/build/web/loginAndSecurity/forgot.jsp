<%-- 
    Document   : forgot
    Created on : Sep 13, 2021, 10:07:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="${contextPath}/css/login.css"type="text/css">
    </head>
    <body>
        <%
            Object mess = request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        %>
        <div class="login-wrap">
            <div class="login-html">
                <h2 style="color: yellow" > Forgot Password</h2>
                <div class="login-form">
                    <div class="sign-up-html">
                        <form action="/Bmazon/LoginControllerMap" method="POST">
                            <div class="group">
                                <label class="label">Username</label>
                                <input type="text" name="username"  class="input" placeholder="Username">
                            </div>
                            <div class="group">
                                <label class="label">Enter Email</label>
                                <input type="text" name="mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="input" id="mail" placeholder="Email" required autofocus="" >
                            </div>
                            <div class="group">
                                <label class="label">Enter Phone</label>
                                <input type="text" name="phone" pattern="([\+84|84|0]+(2|3|5|7|8|9)+([0-9]{8})" class="input" id="phone" placeholder="Phone" required autofocus="" >
                            </div>
                            <div class="group">
                                <label class="label">Confirm New Password</label>
                                <input id="confirm_password" type="Password" name="confirm-password" class="input" placeholder="New password" required autofocus="" >
                            </div>
                            <h6 style="color: yellow" style="font-size: small" ><%= mess.toString()%></h6>
                            <div class="group">                               
                                <input type="submit" class="button" value="Submit">
                                <input type="hidden" name="service" value="forgotPass">
                            </div>
                        </form>
                        <a style="color: yellow" href="${contextPath}/loginAndSecurity/login.jsp" id="cancel_signup" ><i class="fas fa-angle-left"></i> Back to Login</a>
                        <div class="hr"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
