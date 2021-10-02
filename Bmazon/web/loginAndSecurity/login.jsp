<%-- Document : login Created on : Jun 29, 2021, 11:45:24 PM Author : DELL --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
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
        <% Object mess = request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }%>
        <div class="container">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div id="logreg-forms">
                    <form class="form-signin" action="/Bmazon/LoginControllerMap" method="POST">
                        <p style="font-size: 30px;"> Sign-In</p>
                        <!--sign in-->
                        <label for="user" class="label">Username</label>
                        <input id="user" type="text" name="username" placeholder="Username"
                               value="${usernameLogin}" class="form-control" required autofocus="">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" type="password" name="password" placeholder="Password"
                               value="${userpassLogin}" class="form-control" data-type="password" required autofocus="">
                        <br>

                        <p class="text-right" style="font-size: 12px;"><%= mess.toString()%></p>
                        <input type="hidden" name="service" value="login">
                        <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                                class="fas fa-sign-in-alt"></i> Sign-In</button>
                        <!--forgot-->
                        <a style="font-size: 15px; text-align: right; color: #415a70"
                           href="${contextPath}/loginAndSecurity/forgot.jsp">
                            <i class="fas fa-angle-left"></i> Forgot Password</a>
                        <hr>
                        <p style="font-size: 15px; color: #3C589C">Wanna sign in by another way?</p>
                        <div class="row">
                            <div class="col-md-6 googleButton">
                                <a href="${contextPath}/loginAndSecurity/googleLogin.jsp" >
                                    <u style="text-decoration: none;"><img width="20px" style="color: #415a70;" alt="Google sign-in"
                                             src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png" />
                                        Sign in with Google</u>
                                </a>
                            </div>
                            <div class="col-md-6 facebookButton">
                                <a href="${contextPath}/loginAndSecurity/facebookLogin.jsp" >
                                    <u style="text-decoration: none;"><img width="20px" style="color: #415a70;" alt="Facebook sign-in"
                                             src="https://upload.wikimedia.org/wikipedia/en/thumb/0/04/Facebook_f_logo_%282021%29.svg/100px-Facebook_f_logo_%282021%29.svg.png" />
                                        Sign in with Facebook</u>
                                </a>
                            </div>
                        </div>                     
                        <hr>
                        <p style="font-size: 15px; color: #3C589C">Don't have an account?</p>
                        <a href="${contextPath}/loginAndSecurity/register.jsp"><button class="btn btn-secondary btn-block buttonSignUp" type="button" id="btn-signup"><i
                                    class="fas fa-user-plus"></i> Create your New Account</button></a>
                </div>
            </div>
            <div class="col-lg-3"></div>
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