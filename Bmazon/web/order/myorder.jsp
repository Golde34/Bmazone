<%-- 
    Document   : editProfile
    Created on : Sep 19, 2021, 10:51:53 AM
    Author     : Admin
--%>
<%@page import="model.ShipCompanyDAO"%>
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
    ShipCompanyDAO scdao= new ShipCompanyDAO();
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
                <li class="${active5}" style="font-size: 18px;"><a href="CartControllerMap?service=MyOrder">My Order</a></li>
                <li class="${active0}"style="font-size: 18px;"><a href="CartControllerMap?service=MyOrder&state=0">Waiting Accept</a></li>
                <li class="${active1}" style="font-size: 18px;"><a href="CartControllerMap?service=MyOrder&state=1">Order Confirm</a></li>
                <li class="${active2}"style="font-size: 18px;"><a  href="CartControllerMap?service=MyOrder&state=2">Delivering</a></li>
                <li class="${active3}"style="font-size: 18px;"><a href="CartControllerMap?service=MyOrder&state=3">Delivered</a></li>
                <li class="${active4}"style="font-size: 18px;"><a href="CartControllerMap?service=MyOrder&status=0">Deactive Order</a></li>
            </ul>

            <br><br>
            <div class="tab-content">
                <div id="myOrder" class="tab-pane fade in active">  
                    <h3><i class="fa fa-envelope-open-text"></i>     Your Order</h3>
                    <%if (list.isEmpty()) {
                    %>
                    <p>You have not bought any products</p>
                    <%}%>
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
                    <div class="row">
                        <div class="col-md-6">
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        
                        <h6>Order ID: <%=order.getOrderID()%> (<%=order.getOrderDate()%>)</h6> </a>
                    
                          
                    </div>
                    <a href="CartControllerMap?service=OrderDetail&orderID=<%=order.getOrderID()%>">
                        <article class="card">
                            <div class="card-body row">
                                <div class="col"> <strong>Ship Name :</strong> <br><%=order.getShipName()%> </div>
                                <div class="col"> <strong>Shipping By :</strong><%=scdao.getShipCompanyById(order.getCompanyID()).getCompanyName() %> <br>   <i class="fa fa-phone"></i><%=order.getShipPhone()%> </div>
                                <div class="col"> 
                                    <strong>Status:</strong> <br> <%=state%> <%=order.getOrderDate()%>
                                   <%if (order.getStatus()==0) {
                                    %>  
                                    <strong style="color: red">(Deactive)</strong>
                                             
                                <%  }
                                %>
                          
                                
                                </div> 
                                <div class="col"> <strong>Payment Method:</strong> <br> <%=order.getPaymentMethod()%><br> <%=nf.format(order.getTotal())%> </div>
                                    </div>
                         <%if (order.getState()==0&&order.getStatus()==1) {
                                    %>
                                     <div class="col">
                                    <a href="CartControllerMap?service=Deactice&orderID=<%=order.getOrderID()%>&status=0" style="float: right"><button class="button" onclick="return confirm('Are you sure not to buy these products?');">Stop Buying</button></a>
                                     </div>
                                     
                                <%  }
                                %>
                                   
                            </div>
                        </article>
                    </a> <br>
                    <% }%>
                </div>





                <!--Delivered -->


            </div>
        </div>
        <br><br><br>
        <jsp:include page="../footer.jsp"/>

    </body>
    
</html>