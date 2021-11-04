<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
%>
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
            <%if (service.equalsIgnoreCase("employeemanagement") || service.equalsIgnoreCase("updateemployee") || service.equalsIgnoreCase("addemployee")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=employeeanagement">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=employeemanagement">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("employeemanagement") || service.equalsIgnoreCase("updateemployee") || service.equalsIgnoreCase("addemployee")) {%>
                        <i class="fas fa-users"></i>
                        <%} else {%>
                        <i class="fas fa-users" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Employee Management</span>
                </a>
        </li>
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("sellermanagement") || service.equalsIgnoreCase("updatesellerdetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=sellermanagement">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=sellermanagement">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("sellermanagement") || service.equalsIgnoreCase("updateseller")) {%>
                        <i class="fas fa-users"></i>
                        <%} else {%>
                        <i class="fas fa-users" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Seller Management</span>
                </a>
        </li>
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("productmanagement") || service.equalsIgnoreCase("updateproductdetail") || service.equalsIgnoreCase("productdetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=productmanagement">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=productmanagement">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("productmanagement") || service.equalsIgnoreCase("updateproductdetail") || service.equalsIgnoreCase("productdetail")) {%>
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
            <%if (service.equalsIgnoreCase("gallerymanagement") || service.equalsIgnoreCase("updategallerydetail") || service.equalsIgnoreCase("gallerydetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=gallerymanagement">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=gallerymanagement">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("gallerymanagement") || service.equalsIgnoreCase("updategallerydetail") || service.equalsIgnoreCase("gallerydetail")) {%> 
                        <i class="far fa-images"></i>
                        <%} else {%>
                        <i class="far fa-images" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Gallery Management</span>
                </a>
        </li>
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("categorymanagement") || service.equalsIgnoreCase("updatecategorydetail") || service.equalsIgnoreCase("addcategorydetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=categorymanagement">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=categorymanagement">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("categorymanagement") || service.equalsIgnoreCase("updatecategorydetail") || service.equalsIgnoreCase("addcategorydetail")) {%>
                        <i class="fa fa-archive"></i>
                        <%} else {%>
                        <i class="fa fa-archive" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Category Management</span>
                </a>
        </li>

        <li class="nav-item">
            <%if (service.equalsIgnoreCase("orderResponse") || service.equalsIgnoreCase("orderDetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=orderResponse">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=orderResponse">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("orderResponse") || service.equalsIgnoreCase("orderDetail")) {%>
                        <i class="fas fa-reply"></i>
                        <%} else {%>
                        <i class="fas fa-reply" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Order Response</span>
                </a>
        </li>
    </ul>
    <hr>
    <ul class="navbar-nav">
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("userAuthorization")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=userAuthorization">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=userAuthorization">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("userAuthorization")) {%>
                        <i class="fas fa-building"></i>
                        <%} else {%>
                        <i class="fas fa-building" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">User Authorization</span>
                </a>
        </li>
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("roleDisplay") || service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=roleDisplay">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=roleDisplay">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("roleDisplay") || service.equalsIgnoreCase("updateRoleDetail") || service.equalsIgnoreCase("addRoleDetail")) {%>
                        <i class="fas fa-bookmark"></i>
                        <%} else {%>
                        <i class="fas fa-bookmark" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Role Management</span>
                </a>
        </li>
        <li class="nav-item">
            <%if (service.equalsIgnoreCase("sellerResponse") || service.equalsIgnoreCase("acceptSeller")
                        || service.equalsIgnoreCase("denySeller")) {%>
            <a class="nav-link active" href="AdminControllerMap?service=sellerResponse">
                <%} else {%>
                <a class="nav-link" href="AdminControllerMap?service=sellerResponse">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("sellerResponse") || service.equalsIgnoreCase("acceptSeller") || service.equalsIgnoreCase("denySeller")) {%>
                        <i class="fas fa-reply"></i>
                        <%} else {%>
                        <i class="fas fa-reply" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Seller Response</span>
                </a>
        </li>
    </ul>
</div>

