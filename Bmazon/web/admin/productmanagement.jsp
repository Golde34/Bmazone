<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.UserDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    UserDAO userdao = new UserDAO();
    int index = (Integer) request.getAttribute("index");
    int totalPage = (Integer) request.getAttribute("totalPage");
    int prev = index == 1 ? 1 : index-1;
    int next = index == totalPage ? totalPage : index+1;
    User curUser = (User) request.getSession().getAttribute("currUser");
    List<Product> listProduct = (List<Product>) request.getAttribute("listProduct");
    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
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
                                    <a href="AdminControllerMap?service=addproductdetail">
                                        <button class="btn btn-primary">Add new product</button></a>
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
                                        <table class="table-bordered" style="table-layout: fixed;width: 100%;text-align: center;" id="dataTable">
                                            <thead>
                                                <tr>
                                                    <th style="width: 30%;">Product Name</th>
                                                    <th style="width: 30%;">Description</th>
                                                    <th style="width: 8%;">Rating</th>
                                                    <th style="width: 10%;">Seller</th>
                                                    <th style="width: 12%;">Release Date</th>
                                                    <th style="width: 5%;"></th>
                                                    <th style="width: 5%;"></th>
                                                </tr>
                                            </thead>
                                            <tbody id="product">
                                                <%for (Product product : listProduct) {
                                                        User user = userdao.getUserByProductId(product.getProductID());
                                                %>
                                                <tr>
                                                    <td><%=product.getProductName()%></td>
                                                    <td><%=product.getDescription()%></td>
                                                    <td><%=product.getRating()%></td>
                                                    <td><%=user.getFullname()%></td>
                                                    <td><%=dateformat.format(product.getReleaseDate())%></td>
                                                    <td><div><a href="AdminControllerMap?service=updateproductdetail&productid=<%=product.getProductID()%>"><span class="fas fa-edit"></span></a>
                                                        </div></td>
                                                    <td><div><a href="AdminControllerMap?service=deleteproduct&productid=<%=product.getProductID()%>" onclick="return confirm('Are you sure you want to Remove?');"><span class="fas fa-trash-alt"></span></a></div></td>
                                                </tr>

                                                <%}%>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="pagination-container mt-4" style="display: flex;
                                         justify-content: space-around;cursor: pointer;">
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
                                                <%int limit = totalPage>5 ? 5 : totalPage;%>
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