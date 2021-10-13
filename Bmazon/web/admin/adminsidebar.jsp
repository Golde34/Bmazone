<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>
            Admin Dashboard
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <!-- Nucleo Icons -->
        <link href="../css/nucleo-icons.css" rel="stylesheet" />
        <link href="../css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- CSS Files -->
        <link id="pagestyle" href="../css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
    </head>

    <body>
        <div class="sidenav-header">
            <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}/HomePageControllerMap">
                <div class="sidebar-brand-icon">
                    <img  width="124" height="75" src="${contextPath}/images/fpt.png" class="header-logo-dark" />
                </div>
                <!--                    <div class="sidebar-brand-text mx-3 my-3">Bmazon</div>-->
            </a>
        </div>
        <hr class="horizontal dark mt-0">
        <!--            collapse navbar-collapse w-auto max-height-vh-100 h-100-->
        <div class="" id="sidenav-collapse-main">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("AdminDashBoard")) {%>
                    <a class="nav-link active" href="AdminControllerMap">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("AdminDashBoard")) {%>
                                <i class="fas fa-fw fa-tachometer-alt"></i>
                                <%} else {%>
                                <i class="fas fa-fw fa-tachometer-alt" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1">Dashboard</span>
                        </a>
                </li>
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("usermanagement") || service.equalsIgnoreCase("updateuserdetail") || service.equalsIgnoreCase("adduserdetail")) {%>
                    <a class="nav-link active" href="AdminControllerMap?service=usermanagement">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap?service=usermanagement">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("usermanagement") || service.equalsIgnoreCase("updateuserdetail") || service.equalsIgnoreCase("adduserdetail")) {%> 
                                <i class="fas fa-users"></i>
                                <%} else {%>
                                <i class="fas fa-users" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1">User Management</span>
                        </a>
                </li>
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("productmanagement") || service.equalsIgnoreCase("updateproductdetail") || service.equalsIgnoreCase("addproductdetail")) {%>
                    <a class="nav-link active" href="AdminControllerMap?service=productmanagement">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap?service=productmanagement">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("productmanagement") || service.equalsIgnoreCase("updateproductdetail") || service.equalsIgnoreCase("addproductdetail")) {%>
                                <i class="fas fa-layer-group"></i>
                                <%} else {%>
                                <i class="fas fa-layer-group" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1 ">Product Management</span>
                        </a>
                </li>
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("companymanagement") || service.equalsIgnoreCase("updatecompanydetail") || service.equalsIgnoreCase("addcompanydetail")) {%>
                    <a class="nav-link active" href="AdminControllerMap?service=companymanagement">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap?service=companymanagement">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("companymanagement") || service.equalsIgnoreCase("updatecompanydetail") || service.equalsIgnoreCase("addcompanydetail")) {%>
                                <i class="far fa-building"></i>
                                <%} else {%>
                                <i class="far fa-building" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1">Company Management</span>
                        </a>
                </li>
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("gallerymanagement") || service.equalsIgnoreCase("updategallerydetail") || service.equalsIgnoreCase("addgallerydetail")) {%>
                    <a class="nav-link active" href="AdminControllerMap?service=gallerymanagement">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap?service=gallerymanagement">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("gallerymanagement") || service.equalsIgnoreCase("updategallerydetail") || service.equalsIgnoreCase("addgallerydetail")) {%> 
                                <i class="far fa-images"></i>
                                <%} else {%>
                                <i class="far fa-images" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1">Gallery Management</span>
                        </a>
                </li>
            </ul>
            <hr>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <%if (service.equalsIgnoreCase("userAuthorization") || service.equalsIgnoreCase("roleDisplay") || 
                            service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {%>
                    <a class="nav-link active" href="AdminControllerMap?service=userAuthorization">
                        <%} else {%>
                        <a class="nav-link" href="AdminControllerMap?service=userAuthorization">
                            <%}%>
                            <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                                <%if (service.equalsIgnoreCase("userAuthorization") || service.equalsIgnoreCase("roleDisplay") || 
                                        service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {%>
                                <i class="fas fa-building"></i>
                                <%} else {%>
                                <i class="fas fa-building" style="color: black"></i>
                                <%}%>
                            </div>
                            <span class="nav-link-text ms-1">User Authorization</span>
                        </a>
                </li>
            </ul>
        </div>
        <!--   Core JS Files   -->
        <script src="../js/core/popper.min.js"></script>
        <script src="../js/core/bootstrap.min.js"></script>
        <script src="../js/plugins/perfect-scrollbar.min.js"></script>
        <script src="../js/plugins/smooth-scrollbar.min.js"></script>
        <script src="../js/plugins/chartjs.min.js"></script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>