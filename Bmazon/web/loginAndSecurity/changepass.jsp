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
        <% String mess = (String) request.getAttribute("messChangepass");
            if (mess == null) {
                mess = "";
            }
            User account = (User) request.getSession().getAttribute("currUser");%>
        <div class="container">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div id="logreg-forms">
                    <form action="/Bmazon/UserControllerMap" method="post">
                        <p style="font-size: 30px;"> Change Password</p>
                        <label for="pass" class="label">Old Password</label>
                        <input id="oldpass" type="password" pattern="^\S+$" name="oldpass" class="form-control" placeholder="Old Password" data-type="password" value="${oldpassChange}" required autofocus="" >

                        <label for="pass" class="label">New Password</label>
                        <input id="newpass" oninput="checkDup(this)" pattern="^\S+$" type="password" name="newpass" class="form-control" placeholder="New password" data-type="password" value="${newpassChange}" required autofocus="" >

                        <label for="pass" class="label">Confirm New Password</label>
                        <input id="repass" oninput="check(this)" pattern="^\S+$" type="password" name="renewpass" class="form-control" placeholder="Re-New password" data-type="password" value="${renewpassChange}" required autofocus="" >

                        <p class="text-right" style="font-size: 12px;"><%= mess.toString() %></p>
                            <input type="hidden" name="service" value="changepass">
                            <button class="btn btn-secondary btn-block buttonSignIn" type="submit"><i
                                    class="fas fa-sign-in-alt"></i> Submit </button>
                        <br>
                        <div class="row">
                            <a class="col-md-6" style="font-size: 15px;" href="${contextPath}/HomePageControllerMap" id="cancel_signup" > Back to HomePage</a>
                        </div>
                    </form>
                </div>

            </div>
            <div class="col-lg-3"></div>
            <hr>
        </div>
        <script language='javascript' type='text/javascript'>
            function check(input) {
                if (input.value != document.getElementById('newpass').value) {
                    input.setCustomValidity('New Password not Matching.');
                } else {
                    // input is valid -- reset the error message
                    input.setCustomValidity('');
                }
            }
            function checkDup(input) {
                if (input.value != document.getElementById('oldpass').value) {
                    input.setCustomValidity('');
                } else {
                    // input is valid -- reset the error message
                    input.setCustomValidity('New Pass is duplicate with Old Pass.');
                }
            }
        </script>
</html>