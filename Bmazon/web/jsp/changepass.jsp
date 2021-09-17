<%-- 
    Document   : changepass
    Created on : Sep 14, 2021, 1:24:38 PM
    Author     : DELL
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChangePass</title>
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="${contextPath}/css/login.css"type="text/css">
    </head>
    <body>
        <% User account = (User) request.getSession().getAttribute("currUser"); %>
        <div class="login-wrap">
	<div class="login-html">
            <h2 style="color: yellow" > Change PassWord</h2>
            <div class="login-form">
			<div class="sign-up-html">
                            <form action="/Bmazon/UserControllerMap" method="get">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input id="user" type="text" name="username" placeholder="<%= account.getUsername() %>" class="input" required autofocus="" >
				</div>
				<div class="group">
					<label for="pass" class="label">Old Password</label>
					<input id="pass" type="password" name="oldpass" class="input" placeholder="Password" data-type="password" required autofocus="" >
				</div>
				<div class="group">
					<label for="pass" class="label">New Password</label>
					<input id="pass" type="password" name="newpass" class="input" placeholder="Repeat Password" data-type="password"required autofocus="" >
				</div>
                                 <h6 style="color: yellow" style="font-size: small" >${mess}</h6>
				<div class="group">
					<input type="submit" class="button" value="Submit">
                                        <input type="hidden" name="service" value="changepass">
				</div>
                            </form>
                            <a style="color: yellow" href="index.jsp" id="cancel_signup" ><i class="fas fa-angle-left"></i> Back to homepage</a>
				<div class="hr"></div>
			</div>
		</div>
	</div>
</div>
    </body>
</html>
