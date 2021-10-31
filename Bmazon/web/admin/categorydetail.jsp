<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    Category category = new Category();
    if (request.getAttribute("category") != null) {
        category = (Category) request.getAttribute("category");
    }
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
    }
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Category> listCategory = (ArrayList<Category>) request.getAttribute("listCategory");
    ArrayList<Genre> listGenre = (ArrayList<Genre>) request.getAttribute("listGenre");
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
        <link id="pagestyle" href="${contextPath}/css/soft-ui-dashboard.css" rel="stylesheet" />
    </head>
    <style>
        th,td{
            padding: 12px 15px;
        }
        tbody tr:nth-child(odd){
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
                            <form class="needs-validation" novalidate action="/Bmazon/AdminControllerMap" method="POST">
                                <div class="card">
                                    <div class="card-body px-0 pb-2" >    
                                        <div class="card-header py-3 d-flex justify-content-between">
                                            <h3 class="m-0 font-weight-bold text-primary">Category Detail</h3>
                                            <a href="AdminControllerMap?service=categorymanagement"><btn class="btn btn-primary">Category Management</btn></a>
                                        </div>
                                    <% if (state.equals("success")) {%>
                                    <h6 class="text-success mt-3 px-4">${mess}</h6>
                                    <%}%>
                                    <% if (state.equals("fail")) {%>
                                    <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                    <%}%>
                                    <div class="card-body">
                                        <%if (service.equalsIgnoreCase("addcategorydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td style="width: 30%;">Category Name</td>
                                                <td style="width: 70%;">
                                                    <input type="hidden" name="catid" value="<%=category.getCategoryID()%>">
                                                    <input pattern="[^' ']+" class="form-control" type="text" value="<%=category.getCategoryName()%>" name="categoryname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add Category" class="btn btn-primary">
                                                    <input type="hidden" value="addcategory" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updatecategorydetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Category Name</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" value="<%=category.getCategoryName()%>" type="text" name="categoryname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <input type="hidden" value="updatecategory" name="service">
                                            <input type="hidden" value="<%=category.getCategoryID()%>" name="id">
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="card" style="margin-top: 50px;">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Genre Management</h3>
                                        <a href="AdminControllerMap?service=addgenredetail">
                                            <button class="btn-primary btn">Add new genre</button></a>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table style="width: 100%;" class="text-center">
                                                <thead>
                                                    <tr>
                                                        <th>Genre Name</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="genre">
                                                    <%for (Genre genre : listGenre) {
                                                    %>
                                                    <tr>
                                                        <td><input required style="width: 100%;" type="text" name="genrename" class="form-control" value="<%=genre.getGenreName()%>"></td>
                                                            <input type="hidden" name="genid" value="<%=genre.getGenreID()%>">
                                                        <td>
                                                            <% if (genre.getStatus() == 1) {%>
                                                            <a class="btn btn-primary" href="AdminControllerMap?service=deletegenre&genreid=<%=genre.getGenreID()%>" onclick="return confirm('Are you sure?');">Deactive</a>
                                                            <%} else {%>
                                                            <a class="btn btn-primary" href="AdminControllerMap?service=activegenre&genreid=<%=genre.getGenreID()%>" onclick="return confirm('Are you sure?');">Active</a>
                                                            <%}%>
                                                        </td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                            <br>
                                            <div class="d-flex justify-content-center">
                                                <input type="submit" value="Update" class="btn btn-primary mt-3">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </form>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            (function () {
                'use strict'
                var forms = document.querySelectorAll('.needs-validation')
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }
                                form.classList.add('was-validated')
                            }, false)
                        })
            })()
        </script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>