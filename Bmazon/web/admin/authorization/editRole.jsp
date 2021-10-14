<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    Role role = (Role) request.getAttribute("roleDetail");
    String mess = (String) request.getAttribute("mess");
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
    }
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
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
                                    <div class="card-header py-3" style="display: flex;
                                         justify-content: space-between;">
                                        <h6 class="m-0 font-weight-bold text-primary">Role Detail</h6>
                                        <a href="AdminControllerMap?service=roleDisplay"><btn class="btn btn-primary">Role Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <form class="form" action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("addRoleDetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Role ID</td>
                                                <td><input type="text" name="roleID" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Role name</td>
                                                <td><input type="text" name="roleName" class="form-control"></td>
                                            </tr>    
                                            <tr>
                                                <td>Administrator Permission<p></td>
                                                <td><input type="text" name="adminPermission" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Seller Permission<p></td>
                                                <td><input type="text" name="sellerPermission" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Customer Permission<p></td>
                                                <td><input type="text" name="customerPermission" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add Role" class="btn btn-primary">
                                                    <input type="hidden" value="addRole" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updateRoleDetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Role ID</td>
                                                <td><input type="text" name="roleID" value="<%=role.getRoleID()%>" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Role name</td>
                                                <td><input type="text" name="roleName" value="<%=role.getRoleName()%>" class="form-control"></td>
                                            </tr>    
                                            <tr>
                                                <td>Administrator Permission<p></td>
                                                <td><input type="text" name="adminPermission" value="<%=role.getAdminPermission()%>" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Seller Permission<p></td>
                                                <td><input type="text" name="sellerPermission" value="<%=role.getSellerPermission()%>" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td>Customer Permission<p></td>
                                                <td><input type="text" name="customerPermission" value="<%=role.getCustomerPermission()%>" class="form-control"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Role" class="btn btn-primary">
                                                    <input type="hidden" value="updateRole" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--   Core JS Files   -->
        <script src="${contextPath}/js/core/popper.min.js"></script>
        <script src="${contextPath}/js/core/bootstrap.min.js"></script>
        <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>