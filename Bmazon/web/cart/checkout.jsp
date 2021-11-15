<%-- 
    Document   : index
    Created on : Sep 12, 2021, 3:07:53 PM
    Author     : Admin
--%>
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
<% DecimalFormat nf = new DecimalFormat("###,###,###");%>

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
            <%  ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) request.getSession().getAttribute("CheckOutList");
                User x = (User) request.getSession().getAttribute("currUser");
                ShipCompanyDAO sComDAO = new ShipCompanyDAO();
                ArrayList<ShipCompany> listCompany = (ArrayList<ShipCompany>) sComDAO.getAllShipCompany();
                String total = (String) request.getAttribute("total");
            %>

            <main id="main" class="">
                <div id="content" class="content-area page-wrapper" role="main">
                    <div class="row row-main">
                        <div class="large-12 col">
                            <div class="col-inner">

                                <div class="woocommerce">
                                    <%if (x == null) {%>
                                    <div class="woocommerce-info message-wrapper">
                                        <div class="message-container container medium-text-center">
                                            Bạn đã có tài khoản? <a href="#" class="showlogin">Ấn vào đây để đăng nhập</a>     </div>
                                    </div>
                                    <%}%>

                                    <form action="CartControllerMap" method="POST" class="checkout woocommerce-checkout" >

                                        <div class="row pt-0 ">
                                            <div class="large-7 col  ">
                                                <div id="customer_details">
                                                    <div class="clear">
                                                        <div class="woocommerce-billing-fields">

                                                            <h3>Billing Information</h3>

                                                            <div class="woocommerce-billing-fields__field-wrapper">
                                                                <!--Fullname-->
                                                                <p class="form-row form-row-wide validate-required" id="billing_full_name_field" data-priority="10">
                                                                    <label for="billing_full_name" class=""> Your Full Name </label>
                                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" type="text" class="input-text " name="fullname" 
                                                                           value="<%=x.getFullname()%>" id="billing_full_name" placeholder="" 
                                                                           autocomplete="given-name" autofocus="autofocus" />
                                                                </p>
                                                                <!--Ship Company-->
                                                                <p class="form-row form-row-wide" id="billing_country_field" data-priority="30">
                                                                    <label for="billing_company" class="">Ship Company </label>
                                                                    <select name="shipCompany" id="billing_company" class="country_to_state country_select " autocomplete="company">
                                                                        <% for (ShipCompany company : listCompany) {%> 
                                                                        <option value="<%=company.getCompanyID()%>" ><%=company.getCompanyName()%></option> 
                                                                        <%}%>
                                                                    </select>  
                                                                </P>
                                                                <!--Address-->
                                                                <p class="form-row form-row-wide address-field validate-required" id="billing_address_1_field" data-priority="50">
                                                                    <label for="billing_address_1" class="">Address</label>
                                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" type="text" class="input-text " 
                                                                           name="address" id="billing_address_1" placeholder="Your Address"  
                                                                           value="<%=x.getAddress()%>" autocomplete="address-line1" />
                                                                </p>
                                                                <!-- City -->
                                                                <p class="form-row form-row-wide city-field validate-required" id="billing_city_field" data-priority="50">
                                                                    <label for="billing_city" class="">Your city</label>
                                                                    <input pattern="^[^\s]+(\s+[^\s]+)*$" type="text" class="input-text" 
                                                                           name="city" id="billing_city" placeholder="Your City"  
                                                                           value="Ha Noi" />
                                                                </p>
                                                                <!--Phone number-->
                                                                <p class="form-row form-row-first validate-required validate-phone" id="billing_phone_field" data-priority="100">
                                                                    <label for="billing_phone" class=""> Phone number</label>
                                                                    <input pattern="(09|03|07|08|05)+([0-9]{8})" type="tel" class="input-text " 
                                                                           name="phone" id="billing_phone" placeholder=""  
                                                                           value="<%=x.getPhoneNumber()%>" autocomplete="tel" />
                                                                </p>

                                                                <p class="form-row form-row-last validate-required validate-email" id="billing_country_field" data-priority="30">
                                                                    <label for="billing_payment" class="">Payment </label>
                                                                    <select onclick="checkWallet();" name="payment" id="billing_payment" class="country_to_state country_select " >
                                                                        <option value="Wallet" >Wallet</option>
                                                                        <option value="COD" >COD</option> 
                                                                    </select>  
                                                                </P>

                                                                <!--Wallet-->
                                                                <div id="wallet">
                                                                    <p class="form-row form-row-first" id="billing_wallet_field" data-priority="10">
                                                                        <label for="billing_wallet" class=""> Your Wallet </label>
                                                                        <input type="text" class="input-text " name="wallet" value="<%=nf.format(x.getWallet())%>" id="billing_wallet" 
                                                                               placeholder="" autocomplete="given-name" autofocus="autofocus" />
                                                                    </p>
                                                                    <p class="form-row form-row-last validate-required" data-priority="0">
                                                                        <label>Recharged more money</label>
                                                                        <a class="topup" href="UserControllerMap?service=editWallet">Top up</a>
                                                                    </p> 
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>                                               
                                                </div>
                                            </div><!-- large-7 -->


                                            <div class="large-5 col">
                                                <div class="col-inner has-border">
                                                    <div class="checkout-sidebar sm-touch-scroll">
                                                        <h3 id="order_review_heading">Your Orders</h3>
                                                        <div id="order_review" class="woocommerce-checkout-review-order">
                                                            <table class="shop_table woocommerce-checkout-review-order-table">
                                                                <thead>
                                                                    <tr>
                                                                        <th class="product-name">Product</th>
                                                                        <th class="product-total">Total</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%-- Cart order --%>
                                                                    <%      for (CartItem item : ShoppingCart) {%>
                                                                    <tr class="cart_item">
                                                                        <td class="product-name">
                                                                            <%=item.getName() + "(" + item.getSize() + ")" + "(" + item.getColor() + ")" + " x" + item.getQuantity()%><strong class="product-quantity"></strong>													</td>
                                                                        <td class="product-total">
                                                                            <span class="woocommerce-Price-amount amount"><%=nf.format(item.getTotalCost())%><span class="woocommerce-Price-currencySymbol">&#8363;</span></span>						</td>
                                                                    </tr>
                                                                    <% }%>
                                                                </tbody>
                                                                <tfoot>

                                                                    <tr class="cart-subtotal">
                                                                        <th>Products Price</th>
                                                                        <td><span class="woocommerce-Price-amount amount"><%=total%><span class="woocommerce-Price-currencySymbol">&#8363;</span></span></td>
                                                                    </tr>
                                                                    <tr class="shipping">
                                                                        <th>Shipping Fee</th>
                                                                        <td>Free ship <input type="hidden"data-index="0" id="shipping_method_0" class="shipping_method" /> </td>
                                                                    </tr>
                                                                    <tr class="order-total">
                                                                        <th>Total</th>
                                                                        <td><strong><span class="woocommerce-Price-amount amount"><input type="hidden" name="ordertotal" value="${hello}"/><%=total%><span class="woocommerce-Price-currencySymbol">&#8363;</span></span></strong> </td>
                                                                    </tr>

                                                                </tfoot>
                                                            </table>
                                                            <div id="payment" class="woocommerce-checkout-payment">
                                                                <div class="form-row place-order">
                                                                    <input type="hidden" name="service" value="CheckOut"/>
                                                                    <input type="submit" class="button alt" value="Order"/>
                                                                </div>
                                                            </div>
                                                            <p style="color: red; font-size: 18px;">${mess}</p>
                                                        </div>
                                                        <div class="html-checkout-sidebar pt-half"></div>  			
                                                    </div>
                                                </div>
                                            </div><!-- large-5 -->

                                        </div><!-- row -->
                                    </form>
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