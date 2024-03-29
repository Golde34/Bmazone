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
                        <input id="user" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="username" placeholder="Enter your google email"
                               class="form-control" required autofocus="">

                        <p class="text-right" style="font-size: 12px;"><%= mess.toString()%></p>
                        <input type="hidden" name="service" value="googleLogin">
                        <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                                class="fas fa-sign-in-alt"></i> Sign-In</button>
                       
                    </form>
                </div>
            </div>
            <div class="col-lg-3"></div>
            <hr>
        </div>

    </body>

    <footer>

        <p style="text-align:center">By Bmazon
        </p>
    </footer>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script src="/script.js"></script>

</html>
