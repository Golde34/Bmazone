<%-- 
    Document   : forgot
    Created on : Sep 13, 2021, 10:07:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <%
            Object mess = request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        %>
        <div class="container">
            <form action="/Bmazon/UserControllerMap" method="POST">
                <div class="row">
                    <div class="col-md-5">
                        <h2 class="text-center">Change Password</h2>

                        <label class="label control-label">Name</label>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" class="form-control" name="username" 
                                   placeholder="Your Name" >
                        </div>

                        <label class="label control-label">Enter mail</label>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-envelope"></span></span>
                            <input type="text" class="form-control" id="mail" name="mail" required>
                        </div>

                        <label class="label control-label">Enter phone</label>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" class="form-control" id="phone" name="phone" required>                   
                        </div>

                        <label class="label control-label">Confirm New Password</label>
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span></span>
                            <input id="confirm_password" type="Password" class="form-control" name="confirm-password" 
                                   placeholder="Confirm your new password" required>
                        </div>

                        <div class="input-group">
                            <button class="btn btn-default" type="submit">Change Password</button>
                            <button class="btn btn-default" type="reset">RESET</button>
                            <input type="hidden" name="service" value="forgotPass">
                        </div>

                        <div class="input-group">
                            <label class="text-danger" style="color: red;"><%= mess.toString()%></label>
                        </div>
                    </div>

                </div>
            </form>
        </div>   
    </body>
</html>
