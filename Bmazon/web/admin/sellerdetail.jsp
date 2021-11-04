<%@page import="model.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    CategoryDAO daocate = new CategoryDAO();
    Seller seller = new Seller();
    if (request.getAttribute("seller") != null) {
        seller = (Seller) request.getAttribute("seller");
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
    ArrayList<Seller> listSeller = (ArrayList<Seller>) request.getAttribute("listSeller");
    ArrayList<Category> listCategory = daocate.getAllCategories();
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
                            <div class="card">
                                <div class="card-body px-0 pb-2" >    
                                    <div class="card-header py-3 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">Seller Detail</h3>
                                        <a href="AdminControllerMap?service=sellermanagement"><btn class="btn btn-primary">Seller Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <form class="needs-validation" novalidate action="/Bmazon/AdminControllerMap" method="POST">
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Shop Name</td>
                                                <td>
                                                    <input pattern="[^' ']+" class="form-control" value="<%=seller.getSellerShopName()%>" type="text" name="shopname" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Phone</td>
                                                <td>
                                                    <input pattern="(09|03|07|08|05)+([0-9]{8})" class="form-control" value="<%=seller.getSellerPhone()%>" type="text" name="phone" required>
                                                    <div class="invalid-feedback">
                                                        Input correct phone number in Viet Nam
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Evidence</td>
                                                <td>
                                                    <input class="form-control" value="<%=seller.getEvidence()%>" type="text" name="evidence" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Description</td>
                                                <td>
                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" class="form-control" value="<%=seller.getDescription()%>" type="text" name="description" required>
                                                    <div class="invalid-feedback">
                                                        Not blank and no space at beginning or ending
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Seller" class="btn btn-primary">
                                                    <input type="hidden" value="updateseller" name="service">
                                                    <input type="hidden" value="<%=seller.getSellerID()%>" name="id">
                                                </td>
                                            </tr>
                                        </table>
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