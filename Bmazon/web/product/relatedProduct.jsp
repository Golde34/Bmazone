<%@page import="model.UserDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="entity.Gallery"%>
<%@page import="entity.User"%>
<%@page import="model.DBConnection"%>
<%@page import="model.GalleryDAO"%>
<%@page import="entity.Product"%>
<%@page import="model.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CategoryDAO"%>
<%@page import="entity.Category"%>
<%@page import="entity.Genre"%>
<%@page import="model.GenreDAO"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="entity.ProductType"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<% DecimalFormat nf = new DecimalFormat("###,###,###");%>
<%
    ProductTypeDAO daoProductType = new ProductTypeDAO();
    UserDAO daoUser = new UserDAO();
    GalleryDAO daoGallery = new GalleryDAO();
    Product product = (Product) request.getAttribute("product");
    List<Gallery> listGallery = (List<Gallery>) request.getAttribute("listGallery");
    List<ProductType> listProductType = (List<ProductType>) request.getAttribute("listProductType");
    ArrayList<Product> listRelated = (ArrayList<Product>) request.getAttribute("listRelated");
%>
<!DOCTYPE html>
<!--[if IE 9 ]> <html lang="vi" class="ie9 loading-site no-js"> <![endif]-->
<!--[if IE 8 ]> <html lang="vi" class="ie8 loading-site no-js"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="vi" class="loading-site no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>(function (html) {
                html.className = html.className.replace(/\bno-js\b/, 'js')
            })(document.documentElement);</script>
        <title>BMAZON</title>
        <link rel="stylesheet" href="css/1.css">
        <link rel='stylesheet' id='contact-form-7-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.9.1' type='text/css' media='all' />
        <link rel='stylesheet' id='menu-image-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/menu-image/menu-image.css?ver=1.1' type='text/css' media='all' />
        <link rel='stylesheet' id='woof-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/css/front.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='chosen-drop-down-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/chosen/chosen.min.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_by_text_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/by_text/css/by_text.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_color_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/color/css/html_types/color.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_label_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/label/css/html_types/label.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_select_hierarchy_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_hierarchy/css/html_types/select_hierarchy.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='woof_select_radio_check_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_radio_check/css/html_types/select_radio_check.css?ver=4.8.14' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-icons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/fl-icons.css?ver=3.3' type='text/css' media='all' />
        <link rel='stylesheet' id='easy-social-share-buttons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/assets/css/default-retina/easy-social-share-buttons.css?ver=3.7.3' type='text/css' media='all' />
        <link rel='stylesheet' id='essb-cct-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/lib/modules/click-to-tweet/assets/css/styles.css?ver=3.7.3' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-main-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome.css?ver=3.4.0' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-shop-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome-shop.css?ver=3.4.0' type='text/css' media='all' />
        <link rel='stylesheet' id='flatsome-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome-child/style.css?ver=3.4.0' type='text/css' media='all' />
        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>
        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
        <link rel='https://api.w.org/' href='http://mauweb.monamedia.net/lazada/wp-json/' />
        <link rel='stylesheet' href="css/home.css"  type='text/css'>
        <style>
            .bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} 
            .bg-loaded{opacity: 1;}
            .col-inner text-center{

            }
        </style><!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]--> 
        <script src="js/1.js"></script>
        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
        <link rel='stylesheet' href="css/2.css"  type='text/css'>
        <link rel='stylesheet' href="css/3.css"  type='text/css'> 
        <link rel='stylesheet' href="css/slide.css"  type='text/css'> 
        <script src="js/2.js"></script>
        <script src="js.home.js"></script>
        
    </head>
    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow" >
        <jsp:include page="../header.jsp"/>

        <div class="col-inner text-center" style="margin-top: 20px;">
            <h1 style="font-size: 50px;">Related Products</h1>
        </div>
        <div id="wrapper">
            <br><br><br>
            <main id="main" class="">
                <div class="col large-12">              
                    <div class="shop-container">

                        <div class="products row row-small large-columns-5 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1" id="1" style="background-color: #e5e5e5; padding-top: 20px;">
                            <% for (Product pro : listRelated) {
                                    String str = "images/" + daoGallery.getSampleOfProduct(pro.getProductID());
                                    double price = Double.parseDouble(daoProductType.getProductPrice(product.getProductID()));

                            %>
                            <div class="product-small col has-hover post-1178 product type-product status-publish has-post-thumbnail product_cat-bach-hoa-online product_cat-do-hop-dong-goi first instock shipping-taxable purchasable product-type-simple">
                                <div class="col-inner">

                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                        <div class="box-image" style="width:150px; height:150px ">
                                            <div class="" >
                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pro.getProductID()%>">

                                                    <img src="<%=str%>"></a>
                                            </div>
                                            <div class="image-tools z-top top right show-on-hover">
                                            </div>
                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                            </div>
                                        </div><!-- box-image -->

                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                            <div class="title-wrapper" >		
                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pro.getProductID()%>"> <%=pro.getProductName()%> </a></p>
                                            </div> 
                                            <div class="price-wrapper" 
                                                 <span class="price"><del><span class="woocommerce-Price-amount amount"><%=nf.format(price * 1.05)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                    <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                            </div>			
                                        </div><!-- box-text -->
                                    </div><!-- box -->
                                </div><!-- .col-inner -->
                            </div><!-- col -->
                            <%    }
                            %>
                        </div>
                    </div>
                    <div class="container" style="margin-top: 35px;">
                        <nav class="woocommerce-pagination">
                            <ul class="page-numbers nav-pagination links text-center">
                                ${previous}
                                <c:forEach  begin="${begin}" end="${end}" var="i">

                                    <li><a class=" ${page==i?"active":""}" href="ProductDetailControllerMap?service=getRelatedProduct&pid=${pid}&page=${i}">${i}</a></li>
                                    </c:forEach>
                                    ${next}
                            </ul>
                        </nav>
                    </div>
                </div>

            </main><!-- #main -->
        </div>
        

        <jsp:include page="../footer.jsp"/>
    </body>
</html>
