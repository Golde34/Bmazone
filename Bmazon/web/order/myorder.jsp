<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="model.OrderDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Order"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<% DecimalFormat nf = new DecimalFormat("###,###,###");
    OrderDAO odao = new OrderDAO();
%>
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
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
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
            List<Order> list = (List<Order>) request.getAttribute("ListOrder");
        %>

        <jsp:include page="../header.jsp"/>

        <div class="container">
            <br>
            <h1>My Order</h1>

            <br>
            <ul class="nav nav-tabs">
                <li class="active" style="font-size: 18px;"><a data-toggle="tab" href="#myOrder">My Order</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#watingAccept">Waiting Accept</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#delivering">Delivering</a></li>
                <li style="font-size: 18px;"><a data-toggle="tab" href="#delivered">Delivered</a></li>
            </ul>

            <br><br>
            <div class="tab-content">
                <div id="myOrder" class="tab-pane fade in active">  
                    <h3><i class="fa fa-envelope-open-text"></i>     Your Order</h3>
                    <%for (Order order : list) {
                            String state = "";
                            if (order.getState() == 0) {
                                state = "Waiting for acccept";
                            }
                            if (order.getState() == 1) {
                                state = "Order confirmed";
                            }
                            if (order.getState() == 2) {
                                state = "On The Way";
                            }
                            if (order.getState() == 3) {
                                state = "Ready To pickup";
                            }

                    %>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <h6>Order ID: <%=order.getOrderID()%></h6> </a>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"> <strong>Estimated Delivery time:</strong> <br><%=order.getRequiredDate()%> </div>
                                <div class="col"> <strong>Shipping By :</strong><%=order.getCompanyID()%> <br>  | <i class="fa fa-phone"></i><%=order.getShipPhone()%> </div>
                                <div class="col"> <strong>Status:</strong> <br> <%=state%></div>
                                <div class="col"> <strong>Payment Method:</strong> <br> <%=order.getPaymentMethod()%><br> <%=nf.format(order.getTotal())%> </div>
                            </div>
                        </article>
                    </a> <br>
                    <% }%>
                </div>

                <!--waiting for the goods -->
                <div id="watingAccept" class="tab-pane fade">
                    <h3><i class="fa fa-truck-loading"></i>      Waiting for the goods</h3>
                    <%boolean bool0 = false;%>
                    <%for (Order order : list) {
                            if (order.getState() == 0) {
                                bool0 = true;%>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <h6>Order ID: <%=order.getOrderID()%></h6> </a>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"> <strong>Estimated Delivery time:</strong> <br><%=order.getRequiredDate()%> </div>
                                <div class="col"> <strong>Shipping By :</strong><%=order.getCompanyID()%> <br>  | <i class="fa fa-phone"></i><%=order.getShipPhone()%> </div>
                                <div class="col"> <strong>Payment Method:</strong> <br> <%=order.getPaymentMethod()%><br> <%=nf.format(order.getTotal())%> </div>
                            </div>
                        </article>
                    </a> <br>
                    <% } else {
                                bool0 = false;
                            }
                        }%>
                    <%if (bool0 == false) {%>
                    <p>No products.</p>
                    <%}%>
                </div>

                <!--Delivering -->
                <div id="delivering" class="tab-pane fade">
                    <h3><i class="fas fa-truck"></i>    Delivering</h3>
                    <%boolean bool1 = false;%>
                    <%for (Order order : list) {
                            if (order.getState() == 1) {
                                bool0 = true;%>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <h6>Order ID: <%=order.getOrderID()%></h6> </a>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"> <strong>Estimated Delivery time:</strong> <br><%=order.getRequiredDate()%> </div>
                                <div class="col"> <strong>Shipping By :</strong><%=order.getCompanyID()%> <br>  | <i class="fa fa-phone"></i><%=order.getShipPhone()%> </div>
                                <div class="col"> <strong>Payment Method:</strong> <br> <%=order.getPaymentMethod()%><br> <%=nf.format(order.getTotal())%> </div>
                            </div>
                        </article>
                    </a> <br>
                    <% } else {
                                bool1 = false;
                            }
                        }%>
                    <%if (bool1 == false) {%>
                    <p>No products.</p>
                    <%}%>
                </div>

                <!--Delivered -->
                <div id="delivered" class="tab-pane fade">
                    <h3><i class="fas fa-check-circle"></i>       Delivered</h3>
                    <%boolean bool2 = false;%>
                    <%for (Order order : list) {
                            if (order.getState() == 2) {
                                bool0 = true;%>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <h6>Order ID: <%=order.getOrderID()%></h6> </a>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"> <strong>Estimated Delivery time:</strong> <br><%=order.getRequiredDate()%> </div>
                                <div class="col"> <strong>Shipping By :</strong><%=order.getCompanyID()%> <br>  | <i class="fa fa-phone"></i><%=order.getShipPhone()%> </div>
                                <div class="col"> <strong>Payment Method:</strong> <br> <%=order.getPaymentMethod()%><br> <%=nf.format(order.getTotal())%> </div>
                            </div>
                        </article>
                    </a> <br>
                    <% } else {
                                bool2 = false;
                            }
                        }%>
                    <%if (bool2 == false) {%>
                    <p>No products.</p>
                    <%}%>
                </div>

            </div>
        </div>
        <br><br><br>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>