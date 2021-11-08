<%-- 
    Document   : generalBoard
    Created on : Oct 14, 2021, 11:09:35 PM
    Author     : DELL
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="model.OrderDetailDAO"%>
<%@page import="model.OrderDAO"%>
<%@page import="entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="entity.Seller"%>
<%@page import="model.SellerDAO"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductDAO"%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
    <body>
        <%
            User curUser = (User) request.getSession().getAttribute("currUser");
        ProductDAO daoproduct = new ProductDAO();
        SellerDAO sellerDAO = new SellerDAO();
        OrderDAO oDAO = new OrderDAO();
        OrderDetailDAO odDAO = new OrderDetailDAO();
        DecimalFormat nf = new DecimalFormat("###,###,###,###");
        
        Seller seller = sellerDAO.getSellerByUserID(Integer.parseInt(curUser.getUserId()));
        String sellerID = Integer.toString(seller.getSellerID());
        ArrayList<Product> listProduct = daoproduct.getProductBySeller(sellerID);
        List<Order> listOrder = oDAO.getOrderBySellerID(seller.getSellerID());
        %>
        <div class="row" style="margin-bottom:5px;">


                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon"><img style="margin-bottom: 10%" src="https://cdn.iconscout.com/icon/premium/png-256-thumb/new-product-1800178-1528419.png" class="img-circle"></span>
                                <div class="sm-st-info">
                                    <span> <%= listProduct.size() %> </span>
                                    Total Product
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon" style><img style="margin-bottom: 10%" src="https://www.pinclipart.com/picdir/middle/19-190811_customer-order-orders-icon-clipart.png" class="img-circle"></span>
                                <div class="sm-st-info">
                                    <span><%= listOrder.size() %></span>
                                    Total Order
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="sm-st clearfix">
                                <span class="sm-st-icon"><img style="margin-bottom: 10%" src="https://www.pinclipart.com/picdir/middle/524-5249716_dollar-clipart-blue-dollar-blue-transparent-free-for.png" class="img-circle"></span>
                                <div class="sm-st-info">
                                    <span><%= nf.format(odDAO.totalBenefitBySellerID(seller.getSellerID())) %> VND</span>
                                    Total Revenue
                                </div>
                            </div>
                        </div>
                    </div>
    </body>
</html>
