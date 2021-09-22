<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Information</title>
<!--        <link rel="shortcut icon" type="image/png" href="images/80jslogo.png">-->
        <%--js,css--%>   
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/editProfile.css">
    </head>
    <body>

        <%
            User x = (User) request.getAttribute("currUser");
        %>

        <div class="container">
            <div class="col-md-5">
                <div class="card">
                    <div class="box">
                        <div class="content">
                            <h2>Your profile</h2>
                            <p>Name: <%=x.getUsername()%> </p>
                            <p>Mail: <%=x.getEmail()%> </p>
                            <p>Phone number: <%=x.getPhoneNumber()%></p>
                            <p>Address: <%=x.getAddress()%> </p>
                        </div>
                    </div>
                </div>
                <a style="right: 50%;" href="index.jsp" >        
                    <button style="text-align:center; color:white;border-radius: 15px;height: 4em; width: 10em;" class="btn-danger" >
                        <i class="fas fa-arrow-alt-circle-left"></i> Homepage
                    </button> </a>
            </div>
            <div class="col-md-7">
                <%--change--%>
                <div class="card1">
                    <div class="box1">
                        <div class="content1">
                            <form action="UserControllerMap" method="POST" >
                                <input type="hidden" name ="service" value="changeInfo">
                                <h1 class="text-center">Edit Profile</h1>

                                <label class="label control-label">Display Name</label>
                                <div class="input-group" >
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" class="form-control" name="name" 
                                           placeholder="Your Name" required>
                                </div>

                                <label class="label control-label">E-mail</label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-envelope"></span></span>
                                    <input type="email" class="form-control" name="mail" 
                                           placeholder="Your E-mail" required>
                                </div>

                                <label class="label control-label">Phone</label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-phone"></span></span>
                                    <input id="mobile" type="text" class="form-control" name="phone" 
                                           placeholder="Your Phone" required>
                                    <span id='message1'></span>
                                </div>

                                <label class="label control-label">Address</label>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" class="form-control" name="address" 
                                           placeholder="Your address" required>
                                </div>

                                <label class="label control-label">Password</label>
                                <div class="input-group">
                                    <input id="password" type="password" class="form-control" name="pass" 
                                           placeholder="Password" required>
                                </div>
                                <button type="reset" class="btn btn-info">Reset</button>
                                <button type="submit" class="btn btn-success">Change</button>
                                <br><br>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <%--JS--%>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="https://kit.fontawesome.com/9650a62e47.js" crossorigin="anonymous"></script>
    </body>
</html>
