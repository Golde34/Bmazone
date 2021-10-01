<%-- 
    Document   : loginPass
    Created on : Sep 30, 2021, 2:32:23 PM
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
            Object checkLogin = request.getAttribute("checkLogin");
            Object checkRegis = request.getAttribute("checkRegis");
            if (checkLogin == null) {
                checkLogin = "checked";
            }
        %>
        <div class="login-wrap">
            <div class="login-html" >
                <input id="tab-1" type="radio" name="tab" class="sign-in" <%= checkLogin%> ><label for="tab-1" class="tab">Sign In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up" <%= checkRegis%> ><label for="tab-2" class="tab">Sign Up</label> 
                <div class="login-form">
                    <!--Sign in Service-->
                    <div class="sign-in-htm">
                        <form action="/Bmazon/LoginControllerMap" method="POST">
                            <div class="group">
                                <label for="user" class="label" >Username/Email</label>
                                <input id="user" type="text" name="username" placeholder="Username or Email" value="${usernameLogin}" class="input" required autofocus="">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="pass" type="password" name="password" placeholder="Password" value="${userpassLogin}" class="input" data-type="password" required autofocus="">
                            </div>
                            <h6 style="color: yellow" style="font-size: small" >${messLogin}</h6>
                            <div class="group" style="width: 50%; margin-left: 25%">
                                <input type="hidden" name="service" value="login">
                                <input type="submit" class="button" value="Sign In">
                            </div>
                        </form>
<!--                        <br>
                        <div class="foot-lnk">
                            <a href="${contextPath}/loginAndSecurity/loginGoogle.jsp">Already have an account?</a>
                        </div>-->
                        <br>
                        <a style="color: yellow; text-align: right;" href="${contextPath}/loginAndSecurity/forgot.jsp" >
                            <i class="fas fa-angle-left"></i> Forgot Password
                        </a>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a href="${contextPath}/loginAndSecurity/login.jsp">Back</a>
                            </a>
                        </div>
                    </div>
                    <!--Sign up Service-->
                    <div class="sign-up-htm">
                        <form action="/Bmazon/LoginControllerMap" method="POST">
                            <div class="group">
                                <label for="user" class="label">Username</label>
                                <input id="user" type="text" name="signupusername" value="${usernameRegis}" placeholder="Username"  class="input" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="password" type="password" name="signuppass" value="${passwordRegis}" class="input" placeholder="Password" data-type="password" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Repeat Password</label>
                                <input id="repassword" oninput="check(this)" type="password" name="resignuppass" value="${repasswordRegis}" class="input" placeholder="Repeat Password" data-type="password"required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Full Name</label>
                                <input id="name" type="text" name="fname" class="input" value="${fullnameRegis}" placeholder="NguyenVanA" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Email</label>
                                <input id="email" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" value="${emailRegis}" class="input" placeholder="abc@xyz.com" required autofocus="" >
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Phone</label>
                                <input id="phone" type="text" pattern="([\+84|84|0]+(2|3|5|7|8|9)+([0-9]{8})" name="phone" value="${phoneRegis}" class="input" placeholder="0987654321" required autofocus="" >
                            </div>
                            <h6 style="color: yellow;" style="font-size: small" >${messRegis}</h6>
                            <div class="group">
                                <input type="submit" class="button" value="Sign Up">
                                <input type="hidden" name="service" value="register">
                            </div>
                        </form>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <label for="tab-1">Already Member?</label>
                        </div>
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
