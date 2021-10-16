<%@page import="java.text.DecimalFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    ProductTypeDAO daopt = new ProductTypeDAO();
    SellerDAO sellerdao = new SellerDAO();
    CategoryDAO daocat = new CategoryDAO();
    GenreDAO genredao = new GenreDAO();
    String mess = (String) request.getAttribute("mess");
    if (mess == null) {
        mess = "";
    }
    String state = (String) request.getAttribute("state");
    if (state == null) {
        state = "";
    }
    Category category = (Category) request.getAttribute("category");
    Genre genre = (Genre) request.getAttribute("genre");
    String date = (String) request.getAttribute("date");
    String service = (String) request.getAttribute("service");
    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<Category> listCategory = daocat.getAllCategories();
    ArrayList<Genre> listGenre = (ArrayList<Genre>) request.getAttribute("listGenre");
    Product product = (Product) request.getAttribute("product");
    List<ProductType> listType = daopt.getProductByProductID(product.getProductID());
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
                            <form id="form" class="needs-validation" novalidate="" action="/Bmazon/AdminControllerMap" method="POST">
                                <div class="card">
                                    <div class="card-header pt-5 d-flex justify-content-between">
                                        <h3 class="m-0 font-weight-bold text-primary">General Information</h3>
                                        <a href="AdminControllerMap?service=productmanagement"><btn class="btn btn-primary">Product Management</btn></a>
                                    </div>
                                <% if (state.equals("success")) {%>
                                <h6 class="text-success mt-3 px-4">${mess}</h6>
                                <%}%>
                                <% if (state.equals("fail")) {%>
                                <h6 class="text-danger mt-3 px-4">${mess}</h6>
                                <%}%>
                                <div class="card-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <td style="width: 30%;">Product Name</td>
                                            <td style="width: 70%;"><textarea class="form-control" name="productname"><%=product.getProductName()%></textarea></td>
                                        </tr>
                                        <tr>
                                            <td>Category</td>
                                            <td>
                                                <select name="category" style="width: 50%;" class="form-select" id="category">
                                                    <%for (Category cate : listCategory) {
                                                    %>
                                                    <option
                                                        <%if (cate.getCategoryName().equals(category.getCategoryName())) {%> selected <%}%> value="<%=cate.getCategoryID()%>"> <%=cate.getCategoryName()%>
                                                    </option>
                                                    <%}%>
                                                </select>
                                            </td>
                                        </tr>    
                                        <tr>
                                            <td>Genre</td>
                                            <td>
                                                <select name="genre" style="width: 50%;" class="form-select" id="genre">
                                                    <%for (Genre gen : listGenre) {
                                                    %>
                                                    <option
                                                        <%if (gen.getGenreName().equals(genre.getGenreName())) {%> selected <%}%> value="<%=gen.getGenreID()%>"> <%=gen.getGenreName()%>
                                                    </option>
                                                    <%}%>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Seller</td>
                                            <%Seller seller = sellerdao.getSellerID(String.valueOf(product.getSeller()));%>
                                            <td>
                                                <input class="form-control" readonly value="<%=seller.getSellerShopName()%>" type="text" class="input">
                                                <input type="hidden" name="seller" value="<%=product.getSeller()%>"
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Release Date</td>
                                            <td><input class="form-control" value="<%=product.getReleaseDate()%>" type="date" name="date" class="input"></td>
                                        </tr>
                                        <input type="hidden" value="updateproduct" name="service">
                                        <input type="hidden" value="<%=product.getProductID()%>" name="pid">
                                    </table>
                                </div>
                            </div>
                            <div class="card mt-3">
                                <div class="card-header pt-5 d-flex justify-content-between">
                                    <h3 class="m-0 font-weight-bold text-primary">Detail Information</h3>
                                </div>
                                <div class="card-body">
                                    <table id="productType" class="table table-borderless">
                                        <thead>
                                            <tr>
                                                <th style="width: 35%;">Color</th>
                                                <th style="width: 40%;">Size</th>
                                                <th style="width: 15%;">Price</th>
                                                <th style="width: 5%;">Quantity</th>
                                                <th style="width: 5%;"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (ProductType pt : listType) {%>
                                            <tr>
                                                <td>
                                                    <input style="width: 100%;" type="text" name="color" class="form-control" value="<%=pt.getColor()%>">
                                                    <input type="hidden" name="ptid" value="<%=pt.getProductTypeId()%>">
                                                </td>
                                                <td><input style="width: 100%;" type="text" name="size" class="form-control" value="<%=pt.getSize()%>"></td>
                                                    <%Double price = Double.parseDouble(pt.getPrice());%>
                                                <td><input style="width: 100%;" type="text" name="price" class="form-control price" value="<%=nf.format(price)%>"></td>
                                                <td><input style="width: 100%;"  type="text" name="quantity" class="form-control" value="<%=pt.getQuantity()%>"></td>
                                                <td>
                                                    <%if (pt.getStatus() == 1) {%>
                                                    <a href="AdminControllerMap?service=deleteproducttype&producttypeid=<%=pt.getProductTypeId()%>" onclick="return confirm('Are you sure you want to Remove?');">
                                                        <span class="fas fa-trash-alt mt-3 ml-3 delete"></span>
                                                    </a>
                                                    <%} else {%>
                                                    <a href="AdminControllerMap?service=activeproducttype&producttypeid=<%=pt.getProductTypeId()%>" onclick="return confirm('Are you sure you want to Remove?');">
                                                        <span class="fas fa-link mt-3 ml-3 delete"></span>
                                                    </a><%}%>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <div class="d-flex justify-content-center">
                                        <input type="submit" value="Update Product" class="btn btn-primary mt-3">
                                    </div>
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
        <script src="${contextPath}/js/plugins/perfect-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/smooth-scrollbar.min.js"></script>
        <script src="${contextPath}/js/plugins/chartjs.min.js"></script>
        <!-- Github buttons -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
            $("#category").change(function () {
            var val = $(this).val();
<% for (Category cate : listCategory) {%>
            if (val == "<%=cate.getCategoryID()%>"){
            console.log("<%=cate.getCategoryName()%>");
                    $("#genre").html(
<% ArrayList<Genre> list = genredao.getGenresByCategoryId(cate.getCategoryID());
for (int i = 0; i < list.size(); i++) {
if (list.size() == 1 || i == list.size() - 1) {%>"<option value='<%=list.get(i).getGenreID()%>'><%=list.get(i).getGenreName()%></option>"
<%} else {%>"<option value='<%=list.get(i).getGenreID()%>'><%=list.get(i).getGenreName()%></option>" +
<%}
}%>);
            }
<%}%>
            });
            });
                    $(".price").on('keyup', function () {
            var n = parseInt($(this).val().replace(/\D/g, ''), 10);
                    $(this).val(n.toLocaleString());
            });
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