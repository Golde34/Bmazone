<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    UserDAO userdao = new UserDAO();
    ShipCompany company = (ShipCompany) request.getAttribute("company");
    ProductType producttype = (ProductType) request.getAttribute("producttype");
    Product product = (Product) request.getAttribute("product");
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
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
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3" 
                                         style="display: flex;
                                         justify-content: space-between;">
                                        <h6 class="m-0 font-weight-bold text-primary">Product Detail</h6>
                                    </div>
                                    <div class="card-body">
                                        <form class="needs-validation" novalidate="" action="/Bmazon/AdminControllerMap" method="POST">
                                        <%if (service.equalsIgnoreCase("addproductdetail")) {%>
                                        <table class="table">
                                            <tr>
                                                <td style="width: 30%;">Product Name</td>
                                                <td style="width: 70%;"><textarea class="form-control" name="productname"></textarea></td>
                                            </tr>
                                            <tr>
                                                <td>Description</td>
                                                <td><textarea class="form-control" name="description" rows="7"></textarea></td>
                                            </tr>    
                                            <tr>
                                                <td>Rating<p></td>
                                                <td><input class="form-control" type="text" name="rating" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td>Seller<p></td>
                                                <td><input class="form-control" class="form-control" type="text" name="seller" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td>Release Date<p></td>
                                                <td><input class="form-control" type="date" name="date" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Add Product" class="btn btn-primary">
                                                    <input type="hidden" value="addproduct" name="service">
                                                </td>
                                            </tr>
                                        </table>
                                        <%}%>
                                        <%if (service.equalsIgnoreCase("updateproductdetail")) {%>
                                        <table class="table table-striped">
                                            <tr>
                                                <td style="width: 30%;">Product Name</td>
                                                <td style="width: 70%;"><textarea class="form-control" name="productname"><%=product.getProductName()%></textarea></td>
                                            </tr>
                                            <tr>
                                                <td>Description</td>
                                                <td><textarea class="form-control" name="description" rows="7"><%=product.getDescription()%></textarea></td>
                                            </tr>    
                                            <tr>
                                                <td>Rating</td>
                                                <td><input class="form-control" value="<%=product.getRating()%>" type="text" name="rating" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td>Seller</td>
                                                <%User user = userdao.getUserById(product.getProductID());%>
                                                <td><input class="form-control" value="<%=user.getFullname()%>" type="text" name="seller" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td>Release Date</td>
                                                <td><input class="form-control" value="<%=product.getReleaseDate()%>" type="date" name="date" class="input"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" value="Update Product" class="btn btn-primary">
                                                    <input type="hidden" value="updateproduct" name="service">
                                                    <input type="hidden" value="<%=product.getProductID()%>" name="id">
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
        <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->

    </body>

</html>