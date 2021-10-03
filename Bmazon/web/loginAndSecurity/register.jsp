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
            <div id="logreg-forms">
                <form class="form-signin" action="/Bmazon/LoginControllerMap" method="POST">
                    <p style="font-size: 30px;"> Sign-Up</p>
                    <!--sign up-->
                    <label for="user" class="label">Username</label>
                    <input id="user" type="text" name="signupusername" placeholder="Username" pattern="^\S+$"
                           value="${usernameRegis}" class="form-control" required autofocus="">

                    <label for="fullname" class="label">Full Name</label>
                    <input id="fullname" type="text" pattern=".*\S+.*" name="fname" class="form-control" value="${fullnameRegis}" placeholder="Your full name" required autofocus="" >

                    <label for="email" class="label">Email</label>
                    <input id="email" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" value="${emailRegis}" class="form-control" placeholder="Your email" required autofocus="" >

                    <label for="phone" class="label">Phone</label>
                    <input id="phone" type="text" pattern="(0[3|5|7|8|9])+([0-9]{8})\b" name="phone" value="${phoneRegis}" class="form-control" placeholder="Your phone" required autofocus="" >

                    <label for="pass" class="label">Password</label>
                    <input id="pass" type="password" name="signuppass" placeholder="Password" pattern="^\S+$"
                           value="${passwordRegis}" class="form-control" data-type="password" required autofocus="">

                    <label for="pass" class="label">Repeat Password</label> 
                    <input id="repassword" oninput="check(this)" type="password" pattern="^\S+$" name="resignuppass" value="${repasswordRegis}" class="form-control" placeholder="Repeat Password" data-type="password"required autofocus="" >

                    <br>

                    <p class="text-right" style="font-size: 12px;"><%= mess.toString()%></p>
                    <input type="hidden" name="service" value="register">
                    <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                            class="fas fa-sign-in-alt"></i> Sign-Up</button>
                    <br>
                    <p style="font-size: 15px;">Already have an account?</p>
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