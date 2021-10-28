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
<%@page import="entity.ProductType"%>
<%@page import="model.ProductTypeDAO"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% DecimalFormat nf = new DecimalFormat("###,###,###");
ProductTypeDAO ptd= new ProductTypeDAO();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="wrap">
            <jsp:include page="../header.jsp"/>
            <%  ArrayList<CartItem> ShoppingCart = (ArrayList<CartItem>) session.getAttribute("ShoppingCart");

            %>


            <main id="main" class="">
                <div id="content" class="content-area page-wrapper" role="main">
                    <div class="row row-main">
                        <div class="large-12 col">
                            <div class="col-inner">
                                <form action="CartControllerMap" method="POST" class="woocommerce-cart-form">
                                    <div class="woocommerce">
                                        <div class="woocommerce row row-large row-divided">
                                            <div class="col large-7 pb-0 ">

                                                <div class="cart-wrapper sm-touch-scroll">
                                                    <table class="shop_table shop_table_responsive cart woocommerce-cart-form__contents" cellspacing="0">
                                                        <thead>
                                                            <tr>
                                                                <th class="choose" > </th>
                                                                <th class="product-name" colspan="2">Product</th>
                                                                <th class="product-price">Price</th>
                                                                <th class="product-quantity">Quantity</th>
                                                                <th class="product-subtotal">Total Cost</th>
                                                                <th class=""></th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%      for (CartItem item : ShoppingCart) {
                                                                    String image = "images/" + item.getImage();
                                                                    String id=""+ item.getProductID();
                                                                    ProductType pt = ptd.getProductTypeByColorAndSize(item.getColor(),item.getSize(), id);
                                                            %>
                                                            <tr class="woocommerce-cart-form__cart-item cart_item1">
                                                        <input type="hidden" value="<%=item.getCartID()%>" name="cartID">
                                                        <td class="product-remove">
                                                            <input class="check" onclick="myFunction()" type="checkbox" style="font-size:50px " name="checkitem" value="<%=item.getCartID()%>"> 
                                                        </td>


                                                        <td class="product-thumbnail">
                                                            <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=item.getProductID()%>">
                                                                <img width="180" height="180" src="<%=image%>"/></a>          </td>

                                                        <td class="product-name" data-title="Product">
                                                            <a href=""> </a><%=item.getName() + "(" + item.getSize() + ")" + "(" + item.getColor() + ")"%>       </td>
                                                        <!--Price-->
                                                        <td class="product-price" data-title="Price">
                                                            <span class="woocommerce-Price-amount amount">
                                                                <p><%=nf.format(item.getPrice())%>
                                                                </p>&nbsp;
                                                                <span class="woocommerce-Price-currencySymbol">&#8363;</span>
                                                            </span>    
                                                        </td>

                                                        <td class="product-quantity" data-title="Quantity">
                                                            <div class="quantity buttons_added">

                                                                <input type="button" value="-" class="minus button is-form">		<label class="screen-reader-text" for="quantity_6167ef4cc82d1">Số lượng</label>
                                                                <input type="number" class="input-text qty text" step="1" min="1" max="<%=pt.getQuantity()%>" name="quantity" value="<%=item.getQuantity()%>" title="SL" size="4" pattern="[0-9]*" inputmode="numeric" />
                                                                <input type="button" value="+" class="plus button is-form">	</div>
                                                        </td>

                                                        <td class="product-subtotal" data-title="TotalCost">
                                                            <div class="price">
                                                                <span class="woocommerce-Price-amount amount">
                                                                    <p><%=nf.format(item.getTotalCost())%></p>
                                                                    <span class="woocommerce-Price-currencySymbol">&#8363;</span>

                                                                </span>   
                                                            </div>
                                                        </td>

                                                        <td class="product-remove">
                                                            <a href="CartControllerMap?service=Delete&cartID=<%=item.getCartID()%>" class="remove" aria-label="Xóa sản phẩm này" >&times;</a>      
                                                        </td>



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

                                            </div>

                                            <div class="cart-collaterals large-5 col pb-0">
                                                <div class="cart-sidebar col-inner ">
                                                    <div class="cart_totals ">

                                                        <table cellspacing="0">
                                                            <thead>
                                                                <tr>
                                                                    <th class="product-name" colspan="2" style="border-width:3px;">Total</th>
                                                                </tr>
                                                            </thead>
                                                        </table>

                                                        <h2>Total</h2>

                                                        <table cellspacing="0" class="shop_table shop_table_responsive">


                                                            <tr class="order-total">
                                                                <th>Total</th>
                                                                <td data-title="Tổng cộng"><strong><span class="woocommerce-Price-amount amount"><p id="sum">0&nbsp;</p><span class="woocommerce-Price-currencySymbol">&#8363;</span></span></strong> </td>
                                                            </tr>


                                                        </table>

                                                        <div class="wc-proceed-to-checkout">
                                                            <input type="submit" class="button primary mt-0 pull-left small" name="service" value="BillingPage" />
                                                        </div>
                                                        <p style="color: red; font-size: 18px;">${mess}</p>

                                                    </div>


                                                    <div class="cart-sidebar-content relative"></div>	</div>
                                            </div>
                                        </div>


                                    </div>

                                </form>
                            </div><!-- .col-inner -->
                        </div><!-- .large-12 -->
                    </div><!-- .row -->
                </div>

            </main><!-- #main -->

            <jsp:include page="../footer.jsp"/>
        </div>
    </body>
    <script>
        function myFunction() {
            let priceText = document.getElementsByClassName("price");
            let check = document.getElementsByClassName("check");
            let sum = document.getElementById("sum");
            var item = Object.entries(priceText);
            var cartLength = priceText.length;
            var arrayCheck = [];
            var itemPriceValue = [];
            for (var i = 0; check[i]; ++i) {
                if (check[i].checked) {
                    arrayCheck[i] = check[i].value;
                }
            }
            for (var i = 0, max = cartLength; i < max; i++) {
                itemPriceValue[i] = item[i][1].childNodes[1].childNodes[1].innerHTML.split(',').join('');
                console.log(arrayCheck[i]);
            }
            var answer = 0;
            for (var i = 0, max = cartLength; i < max; i++) {
                if (arrayCheck[i] > 0) {
                    answer += parseInt(itemPriceValue[i], 10);
                }
            }
            console.log(answer);
            sum.textContent = answer;
        }
    </script>
</html>