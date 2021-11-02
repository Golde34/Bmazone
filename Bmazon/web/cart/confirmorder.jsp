<%-- 
    Document   : index
    Created on : Sep 12, 2021, 3:07:53 PM
    Author     : Admin
--%>
<%@page import="model.OrderDetailDAO"%>
<%@page import="entity.OrderDetail"%>
<%@page import="entity.Order"%>
<%@page import="model.ShipCompanyDAO"%>
<%@page import="entity.ShipCompany"%>
<%@page import="entity.User"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Product"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% DecimalFormat nf = new DecimalFormat("###,###,###");
//    Order o = (Order) request.getAttribute("order");
//    ArrayList<OrderDetail> list = (ArrayList<OrderDetail>) request.getAttribute("DetailList");
    ArrayList<Order> listOrder = (ArrayList<Order>) request.getAttribute("listOrder");
    OrderDetailDAO daoOrderDetail = new OrderDetailDAO();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Billing Page</title>
        <style>
            .topup {
                background-color: #ff531d; 
                color:white; 
                border-radius: 5px;
                width: 115px;
                height: 25px;
                padding-bottom: 12px;
                padding-top: 5px;
                padding-left: 20px;
                padding-right: 20px;
                text-align: center;
                font-weight: bold;
                line-height: 25px;
            }
            .topup:hover {
                background-color: #cc4217; 
                color:white; 
                border-radius: 5px;
                width: 115px;
                height: 25px;
                padding-bottom: 12px;
                padding-top: 5px;
                padding-left: 20px;
                padding-right: 20px;
                font-weight: bold;
                text-align: center;
                line-height: 25px;
            }
        </style>
    </head>
    <body>

        <div class="wrap">
            <jsp:include page="../header.jsp"/>
            <main id="main" class="">
                <div id="content" class="content-area page-wrapper" role="main">
                    <div class="row row-main">
                        <div class="large-12 col">
                            <div class="col-inner">



                                <div class="woocommerce">
                                    <div class="row">


                                        <div class="large-7 col">

                                            <section class="woocommerce-order-details">
                                                <h2 class="woocommerce-order-details__title">Order Detail</h2>
                                                <%for(Order order: listOrder){
                                                            ArrayList<OrderDetail> list = daoOrderDetail.getAllOrderDetail(order.getOrderID());%>
                                                <table class="woocommerce-table woocommerce-table--order-details shop_table order_details">

                                                    <thead>
                                                        <tr>
                                                            <th class="woocommerce-table__product-name product-name">Product</th>
                                                            <th class="woocommerce-table__product-table product-total">Total</th>
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        
                                                            <%for (OrderDetail od : list) {
                                                        double x=od.getPrice();
                                                        %>
                                                        <tr class="woocommerce-table__line-item order_item">
                                                            
                                                            <td class="woocommerce-table__product-name product-name">
                                                                <a href=""><%=od.getProductName()%> </a> <strong class="product-quantity">&times; <%=od.getQuantity()%></strong>	</td>

                                                            <td class="woocommerce-table__product-total product-total">
                                                                <span class="woocommerce-Price-amount amount"><%=nf.format(od.getPrice())%>&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span>	</td>

                                                        </tr>
                                                    <hr>
                                                        <% }%>

                                                    </tbody>

                                                    <tfoot>
                                                        <tr>
                                                            <th scope="row">Sub Total:</th>
                                                            <td><span class="woocommerce-Price-amount amount"><%=nf.format(order.getTotal())%>&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">Delivery:</th>
                                                            <td>Free</td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">Payment Method:</th>
                                                            <td><%=order.getPaymentMethod()%></td>
                                                        </tr>
                                                        <tr>
                                                            <th scope="row">Total:</th>
                                                            <td><span class="woocommerce-Price-amount amount"><%=nf.format(order.getTotal())%>&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                                        <%}%>
                                            </section>


                                        </div>

                                        <div class="large-5 col">
                                            <div class="is-well col-inner entry-content">
                                                <p class="success-color woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received"><strong>Cảm ơn bạn. Đơn hàng của bạn đã được nhận.</strong></p>

                                                <ul class="woocommerce-order-overview woocommerce-thankyou-order-details order_details">
                                                    <% for (Order order : listOrder){%>
                                                    <li class="woocommerce-order-overview__order order">
                                                        OrderID:						<strong><%=order.getOrderID()%></strong>
                                                    </li>

                                                    <li class="woocommerce-order-overview__date date">
                                                        Order Date:							<strong><%=order.getOrderDate()%></strong>
                                                    </li>


                                                    <li class="woocommerce-order-overview__total total">
                                                        Total:						<strong><span class="woocommerce-Price-amount amount"><%=nf.format(order.getTotal())%>&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></strong>
                                                    </li>

                                                    <li class="woocommerce-order-overview__payment-method method">
                                                       Payment Method:							<strong><%=order.getPaymentMethod()%></strong>
                                                    </li>
                                                    <hr>
                                                    <%}%>
                                                </ul>

                                                <div class="clear"></div>
                                            </div>
                                        </div>



                                    </div>
                                </div>


                            </div><!-- .col-inner -->
                        </div><!-- .large-12 -->
                    </div><!-- .row -->
                </div>


            </main>
            <jsp:include page="../footer.jsp"/>
        </div>
    </body>
    <script>
        function checkWallet() {
            var payment = document.getElementById("billing_payment");
            var elementPayment = payment.options[payment.selectedIndex].text;
            var wallet = document.getElementById("wallet");
            if (elementPayment === "COD") {
                wallet.style.display = "none";
            } else if (elementPayment === "Wallet") {
                wallet.style.display = "block";
            }
        }
    </script>
</html>
<!--        47                            <div class="woocommerce-info message-wrapper">
                                        <div class="message-container container medium-text-center">
                                            <span class="widget-title"><i class="icon-tag"></i></span>Có mã ưu đãi? <a href="#" class="showcoupon">Ấn vào đây để nhập mã</a>     </div>
                                    </div>

                                    <form class="checkout_coupon has-border is-dashed" method="post" style="display:none">
                                        <div class="coupon">
                                            <div class="flex-row medium-flex-wrap">
                                                <div class="flex-col flex-grow">
                                                    <input type="text" name="coupon_code" class="input-text" placeholder="Mã ưu đãi" id="coupon_code" value="" />
                                                </div>
                                                <div class="flex-col">
                                                    <input type="submit" class="button expand" name="apply_coupon" value="Áp dụng mã ưu đãi" />
                                                </div>
                                            </div> row 
                                        </div> coupon 
                                    </form>-->