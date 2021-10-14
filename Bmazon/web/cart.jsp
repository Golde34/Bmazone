<%-- 
    Document   : index
    Created on : Sep 12, 2021, 3:07:53 PM
    Author     : Admin
--%>
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
        <title>JSP Page</title>
    </head>
    <body>

        <div class="wrap">
            <jsp:include page="header.jsp"/>
            <%  ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) session.getAttribute("ShoppingCart");

            %>


            <main id="main" class="">
                <div id="content" class="content-area page-wrapper" role="main">
                    <div class="row row-main">
                        <div class="large-12 col">
                            <div class="col-inner">



                                <div class="woocommerce"><div class="woocommerce row row-large row-divided">
                                        <div class="col large-7 pb-0 ">


                                            <form action="CartControllerMap" method="POST" class="woocommerce-cart-form">
                                                <div class="cart-wrapper sm-touch-scroll">


                                                    <table class="shop_table shop_table_responsive cart woocommerce-cart-form__contents" cellspacing="0">
                                                        <thead>
                                                            <tr>
                                                                <th class="choose" > Check</th>
                                                                <th class="product-name" colspan="3">Sản phẩm</th>
                                                                <th class="product-price">Giá</th>
                                                                <th class="product-quantity">Số lượng</th>
                                                                <th class="product-subtotal">Tổng cộng</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <

                                                            <%      for (CartItem item : ShoppingCart) {
                                                                    String image = "images/" + item.getImage();
                                                            %>

                                                            <tr class="woocommerce-cart-form__cart-item cart_item">
                                                        <input type="hidden" value="<%=item.getCartID()%>" name="cartID">
                                                        <td class="product-remove">
                                                            <input type="checkbox" > </td>

                                                        <td class="product-remove">
                                                            <a href="CartControllerMap?service=Delete&cartID=<%=item.getCartID()%>" class="remove" aria-label="Xóa sản phẩm này" data-product_id="139" data-product_sku="">&times;</a>          </td>


                                                        <td class="product-thumbnail">
                                                            <a href="">
                                                                <img width="180" height="180" src="<%=image%>"/></a>          </td>

                                                        <td class="product-name" data-title="Sản phẩm">
                                                            <a href=""> </a><%=item.getName() + "(" + item.getSize() + ")" + "(" + item.getColor() + ")"%>       </td>

                                                        <td class="product-price" data-title="Giá">
                                                            <span class="woocommerce-Price-amount amount"><%=nf.format(item.getPrice())%>&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span>          </td>

                                                        <td class="product-quantity" data-title="Số lượng">
                                                            <div class="quantity buttons_added">

                                                                <input type="button" value="-" class="minus button is-form">		<label class="screen-reader-text" for="quantity_6167ef4cc82d1">Số lượng</label>
                                                                <input type="number" class="input-text qty text" step="1" min="0" max="9999" name="quantity" value="<%=item.getQuantity()%>" title="SL" size="4" pattern="[0-9]*" inputmode="numeric" />
                                                                <input type="button" value="+" class="plus button is-form">	</div>
                                                        </td>

                                                        <td class="product-subtotal" data-title="Tổng cộng">
                                                            <span class="woocommerce-Price-amount amount"><%=nf.format(item.getTotalCost())%><span class="woocommerce-Price-currencySymbol">&#8363;</span></span>            </td>


                                                        </tr>
                                                        <% }%>

                                                        <tr>
                                                            <td colspan="6" class="actions clear">

                                                                <div class="continue-shopping pull-left text-left">
                                                                    <a class="button-continue-shopping button primary is-outline"  href="HomePageControllerMap?service=Homepage">
                                                                        Continue Shopping    </a>
                                                                </div>

                                                                <input type="submit" class="button primary mt-0 pull-left small" name="service" value="Update" />


                                                            </td>
                                                        </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </form>
                                        </div>

                                        <div class="cart-collaterals large-5 col pb-0">
                                            <div class="cart-sidebar col-inner ">
                                                <div class="cart_totals ">

                                                    <table cellspacing="0">
                                                        <thead>
                                                            <tr>
                                                                <th class="product-name" colspan="2" style="border-width:3px;">Tổng số lượng</th>
                                                            </tr>
                                                        </thead>
                                                    </table>

                                                    <h2>Tổng số lượng</h2>

                                                    <table cellspacing="0" class="shop_table shop_table_responsive">


                                                        <tr class="order-total">
                                                            <th>Tổng cộng</th>
                                                            <td data-title="Tổng cộng"><strong><span class="woocommerce-Price-amount amount">459,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></strong> </td>
                                                        </tr>


                                                    </table>

                                                    <div class="wc-proceed-to-checkout">

                                                        <a href="http://mauweb.monamedia.net/lazada/thanh-toan/" class="checkout-button button alt wc-forward">
                                                            Tiến hành thanh toán</a>
                                                    </div>


                                                </div>


                                                <div class="cart-sidebar-content relative"></div>	</div>
                                        </div>
                                    </div>
                                    <div class="cart-footer-content after-cart-content relative"></div></div>


                            </div><!-- .col-inner -->
                        </div><!-- .large-12 -->
                    </div><!-- .row -->
                </div>


            </main><!-- #main -->

            <jsp:include page="footer.jsp"/>
        </div>


    </body>
</html>
