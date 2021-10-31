<%-- 
    Document   : index
    Created on : Sep 12, 2021, 3:07:53 PM
    Author     : Admin
--%>
<%@page import="model.ShipCompanyDAO"%>
<%@page import="model.GalleryDAO"%>
<%@page import="model.ProductDAO"%>
<%@page import="entity.OrderDetail"%>
<%@page import="entity.Order"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.CartItem"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Product"%>
<%@page import="entity.ProductType"%>
<%@page import="model.ProductTypeDAO"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% DecimalFormat nf = new DecimalFormat("###,###,###");
    ProductTypeDAO ptd = new ProductTypeDAO();
    ProductDAO pdao = new ProductDAO();
    GalleryDAO gDao = new GalleryDAO();
    ShipCompanyDAO scdao = new ShipCompanyDAO();

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <link rel='stylesheet' href="orderdetail.css"  type='text/css'> 

        <title>JSP Page</title>

    </head>
    <body>

        <div class="wrap">
            <jsp:include page="../header.jsp"/>

            <br>
            <%                Order order = (Order) request.getAttribute("Order");
                ArrayList<OrderDetail> list = (ArrayList<OrderDetail>) request.getAttribute("OrderDetailList");
                String state = "";
                if (order.getState() == 0) {
                    state = "Waiting for acccept";
                }
                if (order.getState() == 1) {
                    state = "Order confirmed";
                }
                if (order.getState() == 2) {
                    state = "On The Way";
                }
                if (order.getState() == 3) {
                    state = "Ready To pickup";
                }
            %>
            <div class="container">
                <article class="card">
                    <header class="card-header"> My Orders / Tracking </header>
                    <div class="card-body">
                        <h6>Order ID: <%=order.getOrderID()%></h6>
                        <article class="card">
                            <div class="card-body row" style="padding: 10px;">
                                <div class="col"> 
                                    <strong>Ship Name :</strong> <%=order.getShipName()%> <br>
                                    <strong>Ship Address :</strong><%=order.getShipAddress()%><br>
                                    <strong>Ship City :</strong><%=order.getShipCity()%><br>

                                </div>
                                <div class="col"> 
                                    <strong>Shipping BY:</strong><%=scdao.getShipCompanyById(order.getCompanyID()).getCompanyName()%> <br> 
                                    <strong><i class="fa fa-phone"></i></strong> <%=order.getShipPhone()%> <br>
                                </div>
                                <div class="col"> <strong>Status:</strong> <br> <%=state%>
                                    <%if (order.getStatus() == 0) {
                                    %>  
                                    <strong style="color: red">(Deactive)</strong>

                                    <%  }
                                    %>
                                </div>
                                <div class="col"> <strong>Payment Method:</strong> <%=order.getPaymentMethod()%><br>
                                    <strong>Order Value:</strong> <%=nf.format(order.getTotal())%>
                                </div>
                            </div>
                        </article>
                        <div class="track">
                            <div class="step ${active0}"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Waiting for accept </span> </div>
                            <div class="step ${active1}"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text"> Order confirmed <br><%=order.getOrderDate()%></span> </div>
                            <div class="step ${active2}"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text"> On the way <br><%=order.getRequiredDate()%> </span> </div>
                            <div class="step ${active3}"> <span class="icon"> <i class="fas fa-box"></i> </span> <span class="text">Ready for pickup <br><%=order.getShippedDate()%></span> </div>
                        </div>
                        <br>
                        <ul class="row">
                            <%for (OrderDetail od : list) {
                                    ProductType pt = ptd.getProductTypeByPTypeID(od.getProductTypeId());
                                    Product p = pdao.getProductByID(pt.getProductID());
                                    String image = "images/" + gDao.getImageByProductTypeID(pt.getProductTypeId());

                            %>
                            <li class="col-md-12">
                                <figure class="itemside mb-3">
                                    <div class="aside"><img src="<%=image%>" class="img-sm border"></div>
                                    <figcaption class="info align-self-center">
                                        <p class="title"><%=p.getProductName()%> <br> <%=pt.getColor() + " " + pt.getSize()%></p> 
                                        <div>
                                            <span class="text-muted"><strong>Unit Price: </strong> <%=nf.format(Double.parseDouble(pt.getPrice()))%> </span>
                                            <br><strong>Quantity: </strong><span><%=od.getQuantity()%></span>
                                        </div>
                                    </figcaption>
                                </figure>
                            </li>
                            <% }%>

                        </ul>
                        <br>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="CartControllerMap?service=MyOrder" class="btn btn-warning" data-abc="true"> <i class="fa fa-chevron-left"></i> Back to orders</a>
                            </div>
                            <div class="col-md-6">

                                <a href="CartControllerMap?service=MyOrder" data-toggle="modal"><btn class="btn btn-success">Add</btn></a>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
            <br>
            
            <style type="text/css">
            .modal .modal-dialog {
                max-width: 400px;
            }
            .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                padding: 20px 30px;
            }
            .modal .modal-content {
                border-radius: 3px;
            }
            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }
            .modal .modal-title {
                display: inline-block;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }	
            .modal form label {
                font-weight: normal;
            }
            .imgho{
                width: 250px; 
                height: 150px; 
            }
            .imgho:hover{
                opacity: 0.7;
                cursor: pointer;
            }
        </style>

            <style>
                @import url('https://fonts.googleapis.com/css?family=Open+Sans&display=swap');

                body {
                    background-color: #eeeeee;
                    font-family: 'Open Sans', serif
                }



                .card {
                    position: relative;
                    display: -webkit-box;
                    display: -ms-flexbox;
                    display: flex;
                    -webkit-box-orient: vertical;
                    -webkit-box-direction: normal;
                    -ms-flex-direction: column;
                    flex-direction: column;
                    min-width: 0;
                    word-wrap: break-word;
                    background-color: #fff;
                    background-clip: border-box;
                    border: 1px solid rgba(0, 0, 0, 0.1);
                    border-radius: 0.10rem
                }

                .card-header:first-child {
                    border-radius: calc(0.37rem - 1px) calc(0.37rem - 1px) 0 0
                }

                .card-header {
                    padding: 0.75rem 1.25rem;
                    margin-bottom: 0;
                    background-color: #fff;
                    border-bottom: 1px solid rgba(0, 0, 0, 0.1)
                }

                .track {
                    position: relative;
                    background-color: #ddd;
                    height: 7px;
                    display: -webkit-box;
                    display: -ms-flexbox;
                    display: flex;
                    margin-bottom: 60px;
                    margin-top: 50px
                }

                .track .step {
                    -webkit-box-flex: 1;
                    -ms-flex-positive: 1;
                    flex-grow: 1;
                    width: 25%;
                    margin-top: -18px;
                    text-align: center;
                    position: relative
                }

                .track .step.active:before {
                    background: #FF5722
                }

                .track .step::before {
                    height: 7px;
                    position: absolute;
                    content: "";
                    width: 100%;
                    left: 0;
                    top: 18px
                }

                .track .step.active .icon {
                    background: #ee5435;
                    color: #fff
                }

                .track .icon {
                    display: inline-block;
                    width: 40px;
                    height: 40px;
                    line-height: 40px;
                    position: relative;
                    border-radius: 100%;
                    background: #ddd
                }

                .track .step.active .text {
                    font-weight: 400;
                    color: #000
                }

                .track .text {
                    display: block;
                    margin-top: 7px
                }

                .itemside {
                    position: relative;
                    display: -webkit-box;
                    display: -ms-flexbox;
                    display: flex;
                    width: 100%
                }

                .itemside .aside {
                    position: relative;
                    -ms-flex-negative: 0;
                    flex-shrink: 0
                }

                .img-sm {
                    width: 80px;
                    height: 80px;
                    padding: 7px
                }

                ul.row,
                ul.row-sm {
                    list-style: none;
                    padding: 0
                }

                .itemside .info {
                    padding-left: 15px;
                    padding-right: 7px
                }

                .itemside .title {
                    display: block;
                    margin-bottom: 5px;
                    color: #212529
                }

                p {
                    margin-top: 0;
                    margin-bottom: 1rem
                }

                .btn-warning {
                    color: #ffffff;
                    background-color: #ee5435;
                    border-color: #ee5435;
                    border-radius: 1px
                }

                .btn-warning:hover {
                    color: #ffffff;
                    background-color: #ff2b00;
                    border-color: #ff2b00;
                    border-radius: 1px
                }</style>

            <jsp:include page="../footer.jsp"/>
        </div>
    </body>


</html>