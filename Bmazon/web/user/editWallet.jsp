<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <style>
            body {
                background-color: #FAFAFA;
                font-family: "Amazon Ember",Arial,sans-serif;
            }

            .container .form-edit{
                background-color: #ffffff;
                padding-left: 25px;
            }

            .nav nav-tabs {
                font-family: "Amazon Ember",Arial,sans-serif;
            }

            p {
                font-size: 15px;
            }

            .card {
                padding: 15px;
            }
            .title h1{
                font-size: 50px;
            }
        </style>
    </head>
    <body>
        <%
            User x = (User) request.getSession().getAttribute("currUser");

            String mess = (String) request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        %>

        <jsp:include page="../header.jsp"/>

        <div class="container">
            <br>
            <div class="title" style="text-align: center;">
                <h1>Wallet</h1>
            </div>
            <br>
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <%--change--%>
                <div class="card">
                    <div class="box">
                        <form action="UserControllerMap" method="POST" >

                            <label class="label control-label">Display Name</label>
                            <div class="input-group" >
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" class="form-control" name="name" 
                                       placeholder="Your Name" value="<%=x.getFullname()%>" readonly="">
                            </div>

                            <label class="label control-label">E-mail</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-envelope"></span></span>
                                <input type="email" class="form-control" name="mail" 
                                       placeholder="Your E-mail" value="<%=x.getEmail()%>" readonly="">
                            </div>

                            <label class="label control-label">Phone</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-phone"></span></span>
                                <input id="mobile" type="text" class="form-control" name="phone" 
                                       placeholder="Your Phone" value="<%=x.getPhoneNumber()%>" readonly="">
                                <span id='message1'></span>
                            </div>

                            <label class="label control-label">Wallet</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-usd"></span></span>
                                <input id="mobile" type="text" class="form-control" name="wallet" 
                                       placeholder="Your Phone" value="<%=x.getWallet()%>" readonly="">
                                <span id='message1'></span>
                            </div>

                            <label class="label control-label">Amount</label>
                            <div class="input-group">
                                <input id="amount" type="text" pattern="[0-9]{1,15}" class="form-control" name="amount" 
                                       placeholder="Enter the amount to deposit or withdrawal" required>
                            </div>
                            <br>
                            <h6 style="color: blue" style="font-size: small" >${mess}</h6>

                            <div class="row">
                                <br><br>
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    <button type="submit" name="service" value="deposit" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-danger" > Deposit
                                    </button>
                                    <button type="submit" name="service" value="withdrawal" style="text-align:center; color:white;border-radius: 15px;height: 2em; width: 8em;" class="btn-success" > Withdrawal
                                    </button> 
                                </div>
                            </div> 
                            <br><br>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br><br><br>
<jsp:include page="../footer.jsp"/>
<%--JS--%>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://kit.fontawesome.com/9650a62e47.js" crossorigin="anonymous"></script>
</body>
</html>
