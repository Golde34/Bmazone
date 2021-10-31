<%@page import="java.text.DecimalFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    OrderDetailDAO daoOrderDetail = new OrderDetailDAO();
    Order order = (Order) request.getAttribute("order");
    ArrayList<OrderDetail> listOrderDetail = daoOrderDetail.getOrderDetailByOrderId(order.getOrderID());
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    DecimalFormat nf = new DecimalFormat("###,###,###");
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title> Admin Dashboard</title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- CSS Files -->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css" rel="stylesheet" />
    </head>
    <style>
        th,td{
            padding: 12px 15px;
        }
        tbody tr:nth-child(even){
            background-color: #f2f2f2;
        }
    </style>
    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <jsp:include page="adminsidebar.jsp"></jsp:include>
            </aside>
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Navbar -->
            <jsp:include page="adminheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <form id="form" class="needs-validation" novalidate="" action="/Bmazon/AdminControllerMap" method="POST">
                                <div class="card">
                                    <div class="card-header pt-5 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">General Information</h3>
                                        <a href="AdminControllerMap?service=orderResponse"><btn class="btn btn-primary">Order Response</btn></a>
                                    </div>
                                    <div class="card-body">
                                        <table style="width: 100%;">
                                            <tr>
                                                <td style="width: 30%;">Customer</td>
                                                <td style="width: 70%;"><input readonly class="form-control" value="<%=order.getShipName()%>"></td>
                                        </tr>
                                        <tr>
                                            <td>Address</td>
                                            <td><input readonly class="form-control" value="<%=order.getShipAddress()%> - <%=order.getShipCity()%>"></td>
                                        </tr>    
                                        <tr>
                                            <td>Phone</td>
                                            <td><input readonly class="form-control" value="<%=order.getShipPhone()%>"></td>
                                        </tr>
                                        <tr>
                                            <td>Payment Method</td>
                                            <td><input readonly class="form-control" value="<%=order.getPaymentMethod()%>"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="card mt-3">
                                <div class="card-header pt-5 d-flex justify-content-between">
                                    <h3 class="m-0 font-weight-bold text-primary">Detail Information</h3>
                                </div>
                                <div class="card-body">
                                    <table class="text-center" style="width: 100%;">
                                        <thead class="text-uppercase bg-gray-200">
                                            <tr>
                                                <th style="width: 30%;padding: 20px;">ID</th>
                                                <th style="width: 30%">Product Name</th>
                                                <th style="width: 40%;">Unit Cost</th>
                                                <th style="width: 15%;">Quantity</th>
                                                <th style="width: 10%;">Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (OrderDetail od : listOrderDetail) {%>
                                            <tr>
                                                <% int i=1;%>
                                                <td><%=i%></td>
                                                <td><%=od.getProductName()%></td>
                                                <td><%=nf.format(od.getPrice())%></td>
                                                <td><%=od.getQuantity()%></td>
                                                <%Double priceline = od.getQuantity() * od.getPrice();%>
                                                <td><%=nf.format(priceline)%></td>
                                                <% i+=1;%>
                                            </tr>
                                            <%}%>
                                            <tr>
                                                <td>Total</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td><%=nf.format(order.getTotal() - order.getShipMoney())%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>

        <!--   Core JS Files   -->
        <script src="${contextPath}/js/core/popper.min.js"></script>
        <script src="${contextPath}/js/core/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    </body>

</html>