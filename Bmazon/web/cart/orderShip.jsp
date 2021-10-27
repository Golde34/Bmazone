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
        <title>Order State</title>
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
        </style>
    </head>
    <body>
        <%
            String service = request.getParameter("service");
            User x = (User) request.getAttribute("currUser");
        %>

        <jsp:include page="../header.jsp"/>

        <div class="container">
            <br>
            <h1 >Order State</h1>
            <br>
            <ul class="nav nav-tabs">
                <li class="active" style="font-size: 18px;"><a data-toggle="tab" href="#seller-confirmation">Wait for confirmation</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#waiting-goods">Waiting for the goods</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#delivering">Delivering</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#delivered">Delivered</a></li>
            </ul>

            <br><br>
            <div class="tab-content">

                <!--Edit public profile-->
                <div class="tab-pane fade in active" id="seller-confirmation">                
                    <p><i class="fa fa-envelope-open-text"></i> Seller Confirmation</p>
                </div>

                <!--waiting for the goods -->
                <div id="waiting-goods" class="tab-pane fade">
                    <p><i class="fa fa-truck-loading"></i> Waiting for the goods</p>
                </div>
                
                <!--Delivering -->
                <div id="delivering" class="tab-pane fade">
                    <p><i class="fas fa-truck"></i> Delivering</p>
                </div>
                
                <!--Delivered -->
                <div id="Delivered" class="tab-pane fade">
                    <p><i class="fas fa-check-circle"></i> Delivered</p>
                </div>
            </div>
        </div>
        <br><br><br>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>