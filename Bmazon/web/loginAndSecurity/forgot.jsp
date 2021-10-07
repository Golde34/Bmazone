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
        <!--css, js-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
              crossorigin="anonymous">
        <link rel="stylesheet" href="${contextPath}/css/login.css"type="text/css">
    </head>
    <body>
        <%
            Object mess = request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        %>
        <div class="container">
            <div id="logreg-forms">
                <form class="form-signin" action="/Bmazon/LoginControllerMap" method="POST">
                    <p style="font-size: 30px;"> Forgot password</p>
                    <!--sign in-->
                    <label for="user" class="label">Username</label>
                    <input id="user" type="text" name="username" placeholder="Username" class="form-control" required >
                    <!--Email-->
                    <label class="label">Enter Email</label>
                    <input type="text" name="mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" class="form-control" 
                           id="mail" placeholder="Email" required autofocus="" >
                    <!--Phone-->
                    <label class="label">Enter Phone</label>
                    <input type="text" name="phone" pattern="([\+84|84|0]+(2|3|5|7|8|9)+([0-9]{8})" class="form-control" id="phone" placeholder="Phone" required>
                    <!--Confirm password-->
                    <label class="label">Confirm New Password</label>
                    <input id="confirm_password" type="Password" name="confirm-password" class="form-control" 
                           placeholder="New password" required autofocus="" >
                    <!--Submit-->
                    <p class="text-right" style="font-size: 12px;"><%= mess.toString()%></p>
                    <input type="hidden" name="service" value="forgotPass">
                    <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                            class="fas fa-sign-in-alt"></i> Submit</button>
                    <div class="row"> 
                        <a class="col-md-6" style="font-size: 15px;" href="${contextPath}/loginAndSecurity/login.jsp" id="cancel_signup" > Back to Login</a>
                        <a class="col-md-6 text-right" style="font-size: 15px;" href="${contextPath}/HomePageControllerMap" id="cancel_signup" > Back to HomePage</a>
                    </div>
                </form>
            </div>
            <hr>
        </div>
    </body>
    <p style="text-align:center">
        <a href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
           e.preventDefault();
           $('#logreg-forms .form-signin').toggle() // display:block or none
           $('#logreg-forms .form-reset').toggle() // display:block or none
           }

           function toggleSignUp(e){
           e.preventDefault();
           $('#logreg-forms .form-signin').toggle(); // display:block or none
           $('#logreg-forms .form-signup').toggle(); // display:block or none
           }

           $(()=>{
           // Login Register Form
           $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
           $('#logreg-forms #cancel_reset').click(toggleResetPswd);
           $('#logreg-forms #btn-signup').click(toggleSignUp);
           $('#logreg-forms #cancel_signup').click(toggleSignUp);
           })g" target="_blank" style="color:black">By Bmazon</a>
    </p>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script src="/script.js"></script>

</html>
