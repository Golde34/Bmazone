<%@page import="entity.Seller"%>
<%@page import="java.util.List"%>
<%@page import="model.UserDAO"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    List<Seller> listRequestSeller = (List<Seller>) request.getAttribute("listSellerRequest");
    List<Seller> listNewSeller = (List<Seller>) request.getAttribute("listNewSeller");
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <title>
            Admin Dashboard
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- CSS Files -->
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show  bg-gray-100">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3 " id="sidenav-main">
            <jsp:include page="../adminsidebar.jsp"></jsp:include>
            </aside>
            <main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
                <!-- Navbar -->
            <jsp:include page="../adminheader.jsp"></jsp:include>
                <!-- End Navbar -->
                <div class="container-fluid py-4">
                    <div class="row my-4">
                        <div class="col-lg-12 col-md-12 mb-md-0 mb-4">
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3" 
                                         style="display: flex;
                                         justify-content: space-between;">
                                        <h3 class="m-0 font-weight-bold text-primary">Seller Request </h3>
                                        <a href="AdminControllerMap?service=userAuthorization">
                                            <button class="btn-primary btn">User Authorization</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3" style="display: flex;
                                             justify-content: space-between;">
                                            <div class="tb_search">
                                                <input style="width: 100%;" type="text" oninput="searchByName(this)" placeholder="Search.." class="form-control">
                                            </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped" id="dataTable" style="text-align: center;">
                                                <thead>
                                                    <tr>
                                                        <th>Seller ID</th>
                                                        <th>Seller Shop Name</th>
                                                        <th>Seller Phone</th>
                                                        <th>Seller Certification</th>
                                                        <th>Main Product</th>
                                                        <th>Seller Verification</th>
                                                        <th></th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="role">
                                                <%for (Seller seller : listRequestSeller) {%>
                                                <tr>
                                                    <td><%=seller.getSellerID()%></td>
                                                    <td><%=seller.getSellerShopName()%></td>
                                                    <td><%=seller.getSellerPhone()%></td>
                                                    <td><%=seller.getEvidence()%></td>
                                                    <td><%=seller.getSellerMainProduct()%></td>
                                                    <td><%=seller.getSellerVerification()%></td>
                                                    <td>
                                                        <a style=" background-color: #F56565; border-radius:10px; padding:5px; color: white; " href="AdminControllerMap?service=acceptSeller&sellerID=<%=seller.getSellerID()%>">
                                                            <i class="fas fa-check"></i>   Accept </a>
                                                    </td>
                                                    <td><a style=" background-color: #CB0C9F ; border-radius:10px; padding:5px; color: white;" href="AdminControllerMap?service=denySeller&sellerID=<%=seller.getSellerID()%>" onclick="return confirm('Are you sure you want to Deny this seller?');">
                                                            <i class="fas fa-times"></i>   Deny </a>
                                                    </td>
                                                </tr>
                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3" 
                                         style="display: flex;
                                         justify-content: space-between; margin:0;">
                                        <h3 class="m-0 font-weight-bold text-primary">New Seller</h3>
                                        <a href="#">
                                            <button class="btn-primary btn">Seller Management</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3" style="display: flex;
                                             justify-content: space-between;">
                                            <!--<a href="AdminControllerMap?service=sellerManagement">Show all</a>-->
                                            <a style="font-size: 20px;  " href="#">Show all</a>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-striped" id="dataTable" style="text-align: center;">
                                                <thead>
                                                    <tr>
                                                        <th>Seller ID</th>
                                                        <th>Seller Shop Name</th>
                                                        <th>Seller Phone</th>
                                                        <th>Seller Certification</th>
                                                        <th>Main Product</th>
                                                        <th>Seller Verification</th>                                                 
                                                        <th>Status</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="role">
                                                    <%for (Seller seller : listNewSeller) {%>
                                                    <tr>
                                                        <td><%=seller.getSellerID()%></td>
                                                        <td><%=seller.getSellerShopName()%></td>
                                                        <td><%=seller.getSellerPhone()%></td>
                                                        <td><%=seller.getEvidence()%></td>
                                                        <td><%=seller.getSellerMainProduct()%></td>
                                                        <td><%=seller.getSellerVerification()%></td>
                                                        <%if (seller.getStatus() == 0) {%>
                                                        <td>Deactive</td>
                                                        <%} else {%>
                                                        <td>Active</td>
                                                        <%}%>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </main>
        <script>
            function searchByName(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/Bmazon/AdminControllerMap",
                    type: "get",
                    data: {
                        search: txtSearch,
                        service: "searchSeller"
                    },
                    success: function (respone) {
                        var text = document.getElementById("role");
                        text.innerHTML = respone;
                        getPagination('#dataTable');
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }
        </script>
        <!--   Core JS Files   -->
        <script src="${contextPath}/js/core/popper.min.js"></script>
        <script src="${contextPath}/js/core/bootstrap.min.js"></script>
        <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="${contextPath}/js/tablepagination.js"></script>

        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->
    </body>

</html>