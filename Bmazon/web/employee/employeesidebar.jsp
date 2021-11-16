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
            <%if (service.equalsIgnoreCase("topupresponse")) {%>
            <a class="nav-link active" href="EmployeeControllerMap?service=topupresponse">
                <%} else {%>
                <a class="nav-link" href="EmployeeControllerMap?service=topupresponse">
                    <%}%>
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <%if (service.equalsIgnoreCase("topupresponse")) {%> 
                        <i class="fas fa-users"></i>
                        <%} else {%>
                        <i class="fas fa-users" style="color: black"></i>
                        <%}%>
                    </div>
                    <span class="nav-link-text ms-1">Top Up Response</span>
                </a>
        </li>
    </ul>
    <hr>
</div>

