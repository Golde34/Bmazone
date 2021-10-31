<%-- 
    Document   : orderdetail
    Created on : Oct 28, 2021, 11:33:08 PM
    Author     : Admin
--%>

<%@page import="model.ShipCompanyDAO"%>
<%@page import="entity.Order"%>
<%@page import="entity.OrderDetail"%>
<%@page import="model.OrderDetailDAO"%>
<%@page import="entity.Gallery"%>
<%@page import="model.GalleryDAO"%>
<%@page import="model.WareHouseDAO"%>
<%@page import="model.GenreDAO"%>
<%@page import="model.CategoryDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="entity.User"%>
<%@page import="entity.Category"%>
<%@page import="entity.Genre"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller | Order Detail</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <meta name="description" content="Developed By M Abdur Rokib Promy">
        <meta name="keywords" content="Admin, Bootstrap 3, Template, Theme, Responsive">
        <!-- bootstrap 3.0.2 -->
        <link href="${contextPath}/css/seller/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <link href="${contextPath}/css/seller/iCheck/all.css" rel="stylesheet" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link href="${contextPath}/css/seller/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css"> 
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body class="skin-black">
        <%
            ProductTypeDAO daopt = new ProductTypeDAO();
            CategoryDAO daocat = new CategoryDAO();
            GenreDAO genredao = new GenreDAO();
            WareHouseDAO whdao = new WareHouseDAO();
            GalleryDAO gallerydao = new GalleryDAO();
            OrderDetailDAO oddao = new OrderDetailDAO();
            ShipCompanyDAO spDAO = new ShipCompanyDAO();

            User curUser = (User) request.getSession().getAttribute("currUser");
            DecimalFormat nf = new DecimalFormat("###,###,###");
            Order order = (Order) request.getAttribute("order");
            List<OrderDetail> listOD = (List<OrderDetail>) request.getAttribute("listOD");
        %>
        <jsp:include page="headerSeller.jsp"/>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="upload/<%= curUser.getProfileImage()%>" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, <%= curUser.getUsername()%></p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!--                             search form 
                                                <form action="#" method="get" class="sidebar-form">
                                                    <div class="input-group">
                                                        <input type="text" name="q" class="form-control" placeholder="Search..."/>
                                                        <span class="input-group-btn">
                                                            <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                                                        </span>
                                                    </div>
                                                </form>-->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li><!-- class="tablinks" -->
                            <!--<a href="" onclick="openObject(event, 'Dashboard')">-->
                            <a href="SellerControllerMap?service=SellerDashboard">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="SellerControllerMap?service=productmanagement">
                                <i class="fa fa-gavel"></i> <span>Product Management</span>
                            </a>
                        </li>

                        <li class="active">
                            <a href="SellerControllerMap?service=ordermanagement">
                                <i class="fa fa-globe"></i> <span>Order Management</span>
                            </a>
                        </li>
                       <li class="active">
                            <a href="SellerControllerMap?service=feedback">
                                <i class="fa fa-empire"></i> <span>Feed Back</span>
                            </a>
                        </li>



                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <style>
                .row {
                    display: -ms-flexbox; /* IE10 */
                    display: flex;
                    -ms-flex-wrap: wrap; /* IE10 */
                    flex-wrap: wrap;
                    margin: 0 -16px;
                }

                .col-25 {
                    -ms-flex: 25%; /* IE10 */
                    flex: 25%;
                }

                .col-50 {
                    -ms-flex: 50%; /* IE10 */
                    flex: 50%;
                }

                .col-75 {
                    -ms-flex: 75%; /* IE10 */
                    flex: 75%;
                }

                .col-25,
                .col-50,
                .col-75 {
                    padding: 0 16px;
                }

                .container {
                    background-color: #f2f2f2;
                    padding: 5px 20px 15px 20px;
                    border: 1px solid lightgrey;
                    border-radius: 3px;
                }

                input[type=text] {
                    width: 100%;
                    margin-bottom: 20px;
                    padding: 12px;
                    border: 1px solid #ccc;
                    border-radius: 3px;
                }

                label {
                    margin-bottom: 10px;
                    display: block;
                }

                .icon-container {
                    margin-bottom: 20px;
                    padding: 7px 0;
                    font-size: 24px;
                }

                .btn {
                    background-color: #04AA6D;
                    color: white;
                    padding: 12px;
                    margin: 10px 0;
                    border: none;
                    width: 100%;
                    border-radius: 3px;
                    cursor: pointer;
                    font-size: 17px;
                }

                .btn:hover {
                    background-color: #45a049;
                }

                span.price {
                    float: right;
                    color: grey;
                }

                /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (and change the direction - make the "cart" column go on top) */
                @media (max-width: 800px) {
                    .row {
                        flex-direction: column-reverse;
                    }
                    .col-25 {
                        margin-bottom: 20px;
                    }
                }
            </style>

            <aside class="right-side">
                <div class="row">
                    <div class="col-75">
                        <div class="container">
                            <form action="/action_page.php">

                                <div class="row">
                                    <div class="col-50">
                                        <h3>Billing Address</h3>
                                        <label for="fname"><i class="fa fa-user"></i> Customer Name</label>
                                        <input type="text" id="fname" readonly="" value="<%= order.getShipName()%>">
                                        <label for="email"><i class="fa fa-envelope"></i> Ship Company</label>
                                        <input type="text" id="email" readonly="" value="<%= spDAO.getShipCompanyById(order.getCompanyID()).getCompanyName()%>"
                                               <label for="adr"><i class="fa fa-address-card-o"></i> Order Date</label>
                                        <input type="text" id="adr" readonly="" value="<%=order.getOrderDate()%>">
                                        <label for="city"><i class="fa fa-institution"></i> City</label>
                                        <input type="text" id="city" readonly="" value="<%= order.getShipCity()%>" >

                                        <div class="row">
                                            <div class="col-50">
                                                <label for="state">Phone</label>
                                                <input type="text" id="state" readonly="" value="0<%= order.getShipPhone()%>" >
                                            </div>
                                            <div class="col-50">
                                                <label for="zip">Payment</label>
                                                <input type="text" id="zip" readonly="" value="<%=order.getPaymentMethod()%>" >
                                            </div>
                                        </div>
                                    </div>


                                </div>

                            </form>
                        </div>
                    </div>
                    <div class="col-25">
                        <div class="container">
                            <h3 id="order_review_heading">Order Detail</h3>
                            <%      double result = 0;
                                for (OrderDetail item : listOD) {
                                    ProductType pt = daopt.getProductTypeByPTypeID(item.getProductTypeId());
                                    double total = (item.getPrice() * item.getQuantity());
                                    result += total;
                            %>

                            <p><%=item.getProductName() + "(" + pt.getSize() + ")" + "(" + pt.getColor() + ") " + " x " + item.getQuantity()%><span class="price"><%= nf.format(total)%></span></p>
                                <% }%>
                            <p><strong>Product price </strong><span class="price" style="color:black"><b><%= nf.format(result)%></b></span></p>
                            <p><strong>Shipping Fee </strong><span class="price" style="color:black"><b>Free ship</b></span></p>
                            <hr>
                            <p><strong>Total </strong><span class="price" style="color:black"><b><%= nf.format(result)%></b></span></p>
                                        <% if (order.getState() == 0) {%>
                            <span class="label label-danger">Wait for accept</span>
                            <span class="badge badge-danger">0%</span>
                            <span class="label label-primary">Order confirmed</span>
                            <span class="badge badge-primary">25%</span>
                            <% } else if (order.getState() == 2) {%>
                            <span class="label label-warning">On The Way</span>
                            <span class="badge badge-warning">50%</span>
                            <% } else { %>
                            <span class="label label-success">Success</span>
                            <span class="badge badge-success">100%</span>
                            <% }%>
                        </div>
                    </div>
                </div>

                <a href="SellerControllerMap?service=ordermanagement"><btn class="btn btn-default">Back</btn></a>
                </body>

                <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
                </html>
