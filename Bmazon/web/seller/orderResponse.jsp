<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="entity.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Order Response</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${contextPath}/css/seller/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/iCheck/all.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link href="${contextPath}/css/seller/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css"> 
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    </head>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat nf = new DecimalFormat("###,###,###");
        SellerDAO sDAO = new SellerDAO();
        int index = (Integer) request.getAttribute("index");
        int totalPage = (Integer) request.getAttribute("totalPage");
        int prev = index == 1 ? 1 : index - 1;
        int next = index == totalPage ? totalPage : index + 1;
        User curUser = (User) request.getSession().getAttribute("currUser");
        List<Order> listO = (ArrayList<Order>) request.getAttribute("listOrder");

        String userID = curUser.getUserId();
        Seller seller = sDAO.getSellerByUserID(Integer.parseInt(userID));
        int sellerID = seller.getSellerID();
    %>

    <body class="skin-black">
        <jsp:include page="headerSeller.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="upload/<%= curUser.getProfileImage()%>" class="img-circle"/>
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= curUser.getUsername()%></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li><!-- class="tablinks" -->
                            <!--<a href="" onclick="openObject(event, 'Dashboard')">-->
                            <a href="SellerControllerMap">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=productmanagement">
                                <i class="fa fa-gavel"></i> <span>Product Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=gallerymanagement">
                                <i class="fa fa-image"></i> <span>Gallery Management</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="SellerControllerMap?service=orderResponse">
                                <i class="fa fa-globe"></i> <span>Order Response</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=feedback">
                                <i class="fa fa-empire"></i> <span>Feed Back</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=customermanagement">
                                <i class="fa fa-empire"></i> <span>Customer Management</span>
                            </a>
                        </li>
                    </ul>
                </section>
            </aside>
            <aside class="right-side">
                <section class="content">
                    <div class="row d-block" id="Order" name="tabcontent">
                        <div class="col-md-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Orders
                                </header>
                                <div class="table_head py-3 d-flex justify-content-between">
                                    <div class="rowNum" style="padding:20px">
                                        <h3 class="d-inline">Select number of Rows</h3>
                                        <div class="form-group d-inline">
                                            <select onchange="pagination()" name="state" id="maxRows" class="form-control d-inline" style="width:80px">
                                                <option value="5">5</option>
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="5000">Show All</option>
                                            </select>
                                        </div>
                                    </div>
<!--                                    <div>
                                        <input id="search" style="width: 100%;" type="text" oninput="pagination()" placeholder="Search.." class="form-control">
                                    </div>-->
                                </div>
                                <div class="panel-body table-responsive">
                                    <table class="text-center" style="width: 100%;">
                                        <thead class="text-uppercase bg-gray-200">
                                            <tr>
                                                <th style="width: 15%;padding: 20px;">Customer</th>
                                                <th style="width: 20%">Order Date</th>
                                                <th style="width: 15%">Address</th>
                                                <th style="width: 20%">Phone</th>
                                                <th style="width: 15%">Payment Method</th>
                                                <th style="width: 15%">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="order">
                                            <%for (Order order : listO) {%>
                                            <tr>
                                                <td><%=order.getShipName()%></td>
                                                <td><%=sdf.format(order.getOrderDate())%></td>
                                                <td><%=order.getShipAddress()%>-<%=order.getShipCity()%></td>
                                                <td><%=order.getShipPhone()%></td>
                                                <td><%=order.getPaymentMethod()%></td>
                                                <td style='white-space: nowrap'>
                                                    <a href="SellerControllerMap?service=orderDetail&orderid=<%=order.getOrderID()%>"><button class="btn btn-primary">View</button></a>
                                                    <a href="SellerControllerMap?service=handleOrder&action=accept&orderId=<%=order.getOrderID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-success">Accept</button></a>
                                                    <a href="SellerControllerMap?service=handleOrder&action=refuse&orderId=<%=order.getOrderID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-danger">Refuse</button></a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="pagination-container mt-4 d-flex justify-content-around" style="cursor: pointer;">
                                    <nav>
                                        <%if (totalPage > 1) {%>
                                        <ul class="pagination" id="showpage">
                                            <li data-repair="1" class="page-item">
                                                <a class="page-link" aria-label="First">
                                                    <span aria-hidden="true"><i class="fas fa-backward"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <li data-repair="<%=prev%>" class="page-item">
                                                <a class="page-link" aria-label="Previous">
                                                    <span aria-hidden="true"><i class="fas fa-arrow-left"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <%int limit = totalPage > 5 ? 5 : totalPage;%>
                                            <%for (int i = 1; i <= limit; i++) {%>
                                            <%if (index == i) {%>
                                            <li  class="page-item active" data-repair="<%=i%>">
                                            <%} else {%><li  class="page-item" data-repair="<%=i%>"> <%}%>
                                                <a class="page-link">
                                                    <div class="index"><%=i%></div>
                                                    <span class="sr-only">(current)</span>
                                                </a>
                                            </li>
                                            <%}%>
                                            <li data-repair="<%=next%>" class="page-item">
                                                <a class="page-link" aria-label="Next">
                                                    <span aria-hidden="true"><i class="fas fa-arrow-right"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                            <li data-repair="<%=totalPage%>" class="page-item">
                                                <a class="page-link" aria-label="Last">
                                                    <span aria-hidden="true"><i class="fas fa-forward"></i>
                                                        <span class="sr-only">(current)</span> 
                                                    </span>
                                                </a>
                                            </li>
                                        </ul>
                                        <%}%>
                                    </nav>
                                </div>
                            </section>
                        </div>
                    </div>
                </section>
<!--                <div class="footer-main">
                    &copy Bmazon, 2021
                </div>-->
            </aside>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <script src="${contextPath}/js/core/popper.min.js"></script>
    <script src="${contextPath}/js/core/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        var pageNum;
        $(document).on('click', '.pagination li', function () {
            pageNum = $(this).data('repair');
            pagination();
        });
        function pagination() {
            var row = document.getElementById("maxRows").value;
//                var search = document.getElementById("search").value;
            $(document).on('change', '#maxRows', function () {
                pageNum = 1;
            });
            $(document).on('input', '#search', function () {
                pageNum = 1;
            });
            $.ajax({
                url: "/Bmazon/AdminControllerMap",
                type: "get",
                data: {
//                        search: search,
                    row: row,
                    index: pageNum,
                    service: "pagingOrderResponse"
                },
                success: function (respone) {
                    var text = document.getElementById("order");
                    text.innerHTML = respone;
                    showpage();
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
        function showpage() {
            var row = document.getElementById("maxRows").value;
//                var search = document.getElementById("search").value;
            $(document).on('change', '#maxRows', function () {
                pageNum = 1;
            });
            $(document).on('input', '#search', function () {
                pageNum = 1;
            });
            $.ajax({
                url: "/Bmazon/AdminControllerMap",
                type: "get",
                data: {
//                        search: search,
                    row: row,
                    index: pageNum,
                    service: "showPageOrderResponse"
                },
                success: function (respone) {
                    var text = document.getElementById("showpage");
                    text.innerHTML = respone;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
    </script>
</html>