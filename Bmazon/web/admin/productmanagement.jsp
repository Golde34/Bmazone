<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    ProductCategoryDAO pcdao = new ProductCategoryDAO();
    ProductGenreDAO pgdao = new ProductGenreDAO();
    GenreDAO genredao = new GenreDAO();
    CategoryDAO catdao = new CategoryDAO();
    SellerDAO sellerdao = new SellerDAO();
    UserDAO userdao = new UserDAO();
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index - 1;
    int next = index == totalPage ? totalPage : index + 1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<Product> listProduct = (List<Product>) request.getAttribute("listProduct");
    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
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
                            <div class="card">
                                <div class="card-body px-0 pb-2">
                                    <div class="card-header py-3" 
                                         style="display: flex;
                                         justify-content: space-between;">
                                        <h3 class="m-0 font-weight-bold text-primary">Product Management</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="table_head py-3" style="display: flex;
                                             justify-content: space-between;">
                                            <div class="rowNum">
                                                <h6 style="display: inline">Select number of Rows</h6>
                                                <div class="form-group" style="display: inline;">
                                                    <select onchange="pagination()" name="state" id="maxRows" class="form-control" style="width:80px;display:inline;">
                                                        <option value="5">5</option>
                                                        <option value="10">10</option>
                                                        <option value="20">20</option>
                                                        <option value="5000">Show All</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="tb_search">
                                                <input id="search" style="width: 100%;" type="text" oninput="pagination()" placeholder="Search.." class="form-control">
                                            </div>
                                        </div>
                                        <div class="table-responsive-md">
                                            <table style="width: 100%" class="table-bordered text-center">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 30%;">Product Name</th>
                                                        <th style="width: 20%;">Category</th>
                                                        <th style="width: 20%;">Genre</th>
                                                        <th style="width: 20%;">Seller</th>
                                                        <th style="width: 5%;"></th>
                                                        <th style="width: 5%;"></th>
                                                    </tr>
                                                </thead>
                                                <tbody id="product">
                                                <%for (Product product : listProduct) {
                                                        Seller seller = sellerdao.getSellerID(String.valueOf(product.getSeller()));
                                                        String genreid = pgdao.getGenreIdByProductId(product.getProductID());
                                                        Genre genre = genredao.getGenreById(Integer.parseInt(genreid));
                                                        String categoryId = pcdao.getCategoryIdByProductId(product.getProductID());
                                                        String categoryName = catdao.getCategoryById(Integer.parseInt(categoryId));
                                                %>
                                                <tr>
                                                    <td><%=product.getProductName()%></td>
                                                    <td><%=categoryName%></td>
                                                    <td><%=genre.getGenreName()%></td>
                                                    <td><%=seller.getSellerShopName()%></td>
                                                    <td><div><a href="AdminControllerMap?service=productdetail&productid=<%=product.getProductID()%>"><button class="btn btn-primary">Edit</button></a>
                                                        </div></td>
                                                    <td>
                                                        <% if(product.getStatus()==1){%>
                                                    <a href="AdminControllerMap?service=deleteproduct&productid=<%=product.getProductID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Deactive</button></a>
                                                    <%}else{%>
                                                    <a href="AdminControllerMap?service=activeproduct&productid=<%=product.getProductID()%>" onclick="return confirm('Are you sure?');"><button class="btn btn-primary">Active</button></a>
                                                    <%}%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
                                                        var pageNum;
                                                        $(document).on('click', '.pagination li', function () {
                                                            pageNum = $(this).data('repair');
                                                            pagination();
                                                        });
                                                        function pagination() {
                                                            var row = document.getElementById("maxRows").value;
                                                            var search = document.getElementById("search").value;
                                                            console.log(row);
                                                            console.log(search);
                                                            console.log(pageNum);
                                                            $.ajax({
                                                                url: "/Bmazon/AdminControllerMap",
                                                                type: "get",
                                                                data: {
                                                                    search: search,
                                                                    row: row,
                                                                    index: pageNum,
                                                                    service: "pagingproduct"
                                                                },
                                                                success: function (respone) {
                                                                    var text = document.getElementById("product");
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
                                                            var search = document.getElementById("search").value;
                                                            $.ajax({
                                                                url: "/Bmazon/AdminControllerMap",
                                                                type: "get",
                                                                data: {
                                                                    search: search,
                                                                    row: row,
                                                                    index: pageNum,
                                                                    service: "showpageproduct"
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
    </body>

</html>
<!-- Github buttons -->
<!--        <script async defer src="https://buttons.github.io/buttons.js"></script>-->
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<!--        <script src="${contextPath}/js/soft-ui-dashboard.min.js?v=1.0.3"></script>-->