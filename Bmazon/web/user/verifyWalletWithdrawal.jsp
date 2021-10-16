<%-- 
    Document   : verify
    Created on : Oct 8, 2021, 2:06:14 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verification Page</title>
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
                <form class="form-signin" action="/Bmazon/UserControllerMap" method="POST">
                    <p style="font-size: 30px;"> Verify Request</p>
                    <br>

                    <!--verify code-->
                    <h4 style="color: ">A verify code has been sent to your email, check it!</h4>
                    <label for="phone" class="label">Code</label>
                    <input id="phone" type="text" pattern="([0-9]{6})\b" name="verifyCode" value="${verifyCode}" class="form-control" placeholder="Verification code" required autofocus="" >

                    <br>

                    <p class="text-right" style="font-size: 12px;"><%= mess.toString()%></p>
                    <input type="hidden" name="service" value="verifyWalletWithdrawal">
                    <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                            class="fas fa-sign-in-alt"></i> Verify my request</button>
                    <br>
                    <div class="row">
                        <a class="col-md-6" style="font-size: 15px;" href="${contextPath}/UserControllerMap?service=editWallet" id="cancel_signup" > Back to Wallet</a>
                        <a class="col-md-6 text-right" style="font-size: 15px;" href="${contextPath}/HomePageControllerMap" id="cancel_signup" > Back to HomePage</a>
                    </div>
                </form>

            </div>

            <hr>
        </div>

    </body>

    <p style="text-align:center">By Bmazon
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
    <script src="/script.js"></script>
</html>