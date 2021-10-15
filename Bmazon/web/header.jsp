<%@page import="entity.Gallery"%>
<%@page import="entity.User"%>
<%@page import="model.DBConnection"%>
<%@page import="model.GalleryDAO"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CategoryDAO"%>
<%@page import="entity.Category"%>
<%@page import="entity.Genre"%>
<%@page import="model.GenreDAO"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    DBConnection dbCon = new DBConnection();
    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ArrayList<Category> cateList = daoCate.getTrueCategories();
    ArrayList<Genre> gerneList = genDAO.getTrueGenres();

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
        <link rel="stylesheet" href="${contextPath}/css/1.css">
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
        <link rel='stylesheet' href="${contextPath}/css/home.css"  type='text/css'>
        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]--> 
        <script src="js/1.js"></script>
        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
        <link rel='stylesheet' href="${contextPath}/css/2.css"  type='text/css'>
        <link rel='stylesheet' href="${contextPath}/css/3.css"  type='text/css'> 

        <script src="js/2.js"></script>

        <script src="js.home.js"></script>
    </head>
    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow" >
        <div id="wrapper">


            <header id="header" class="header has-sticky sticky-jump">
                <div class="header-wrapper">
                    <div id="top-bar" class="header-top hide-for-sticky nav-dark" >
                        <div class="flex-row container" >
                            <div class="flex-col hide-for-medium flex-left">
                                <ul class="nav nav-left medium-nav-center nav-small  nav-">
                                </ul>
                            </div><!-- flex-col left -->

                            <div class="flex-col hide-for-medium flex-center">
                                <ul class="nav nav-center nav-small  nav-">
                                </ul>
                            </div><!-- center -->

                            <div class="flex-col hide-for-medium flex-right">
                                <ul class="nav top-bar-nav nav-right nav-small  nav-">
                                    <li class="html custom html_topbar_right"><p class="topbarlink"><a href="" style="color:#37cfdd">Be one of us</a></p></li>
                                    <li class="html custom html_top_right_text"><p class="topbarlink"><a href="#">Customer Service</a></p></li>
                                    <li class="html custom html_nav_position_text_top"><p class="topbarlink"><a href="#">Check Order</a></p></li>
                                        <%User x = (User) request.getSession().getAttribute("currUser");%>
                                        <%if (x == null) {%>
                                    <li class="account-item has-icon ">
                                        <a href="${contextPath}/loginAndSecurity/login.jsp"class="nav-top-link nav-top-not-logged-in ">
                                            <span> Login </span>
                                        </a><!-- .account-login-link -->
                                    </li>
                                    <p style="color: white; font-size: 12px; ">/</p>
                                    <li class="account-item has-icon ">
                                        <a href="${contextPath}/loginAndSecurity/register.jsp"class="nav-top-link nav-top-not-logged-in ">
                                            <span> Register </span>
                                        </a><!-- .account-login-link -->
                                    </li>
                                    <%} else {%>
                                    <li class=" menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown" style="cursor: pointer;">
                                        <a href="${contextPath}/UserControllerMap?service=account"><span> Hello <%=x.getFullname()%></span></a>
                                        <ul class='nav-dropdown nav-dropdown-simple'>
                                            <% if (x.getSystemRole() == 1) {%>
                                            <li  ><a href="${contextPath}/AdminControllerMap" class="menu-image-title-after"><span >Admin Dashboard</span></a></li>
                                                <%}%>
                                                <% if (x.getSell() == 1) { %>
                                            <li  ><a href="${contextPath}/SellerControllerMap" class="menu-image-title-after"><span >Seller Dashboard</span></a></li>
                                                <%}%>
                                            <li  ><a href="${contextPath}/UserControllerMap?service=account" class="menu-image-title-after"><span >Account</span></a></li>
                                            <li  ><a href="${contextPath}/UserControllerMap?service=info" class="menu-image-title-after"><span >User profile</span></a></li>

                                            <li  ><a href="${contextPath}/UserControllerMap?service=changepass" class="menu-image-title-after"><span >Change Password</span></a></li>
                                            <li  ><a href="${contextPath}/UserControllerMap?service=logout" class="menu-image-title-after"><span >Logout</span></a></li>

                                        </ul>
                                    </li>
                                    <%}%>
                                </ul>
                            </div><!-- .flex-col right -->




                        </div><!-- .flex-row -->
                    </div><!-- #header-top -->
                    <div id="masthead" class="header-main nav-dark" style="background-color: black">
                        <div class="header-inner flex-row container logo-left medium-logo-center" role="navigation">

                            <!-- Logo -->
                            <div id="logo" class="flex-col logo">
                                <!-- Header logo -->
                                <a href="HomePageControllerMap" title="BMAZON" rel="home">

                                    <img  width="124" height="75" src="${contextPath}/images/fpt.png" class="header-logo-dark" /></a>
                            </div>

                            <!-- Mobile Left Elements -->
                            <div class="flex-col show-for-medium flex-left">
                                <ul class="mobile-nav nav nav-left ">
                                    <li class="nav-icon has-icon">
                                        <a href="#" data-open="#main-menu" data-pos="left" data-bg="main-menu-overlay" data-color="" class="is-small" aria-controls="main-menu" aria-expanded="false">

                                            <i class='fa fa-bars' style='font-size:36px; margin-left: 15px;' ></i>
                                        </a>
                                    </li>           
                                </ul>

                            </div>


                            <!-- Left Elements -->
                            <div class="flex-col hide-for-medium flex-left
                                 flex-grow" >
                                <ul class="header-nav header-nav-main nav nav-left  nav-uppercase" >
                                    <li class="header-search-form search-form html relative has-icon">
                                        <div class="header-search-form-wrapper">
                                            <div class="searchform-wrapper ux-search-box relative form- is-normal">
                                                <form method="POST" class="searchform" action="HomePageControllerMap?service=search" role="search">
                                                    <div class="flex-row relative">
                                                        <div class="flex-col flex-grow">
                                                            <input type="search" name="search" value="${search}" placeholder="Find Product" required/>


                                                        </div><!-- .flex-col -->
                                                        <div class="flex-col">
                                                            <button type="submit" class="ux-search-submit submit-button secondary button icon mb-0">
                                                                <i class="fa fa-search" ></i>				</button>
                                                        </div><!-- .flex-col -->
                                                    </div><!-- .flex-row -->
                                                    <div class="live-search-results text-left z-top"></div>
                                                </form>
                                            </div>	</div>
                                    </li>
                                    <li class="cart-item has-icon
                                        has-dropdown" style="margin-left: 10px">

                                        <a href="cart.jsp" title="Giỏ hàng" class="header-cart-link is-small">



                                            <i class="fa fa-shopping-cart"
                                               data-icon-label="0">
                                                <%-- so luong item in cart--%>
                                            </i>
                                        </a>



                                    </li>
                                </ul>
                                </di
                                </ul>
                            </div>

                            <!-- Right Elements -->
                            <div class="flex-col hide-for-medium flex-right" style="background:black ">
                                <ul class="header-nav header-nav-main nav nav-right  nav-uppercase">
                                    <li class="html custom html_nav_position_text"><img class="header_promotion" 
                                                                                        src="${contextPath}/images/FPT.jpg" alt="promotion" style="height: 40px;width: 170px;"></li>            </ul>
                            </div>

                            <!-- Mobile Right Elements -->
                            <!-- Mobile Right Elements -->
                            <div class="flex-col show-for-medium flex-right" style="margin-right:20px ">
                                <ul class="mobile-nav nav nav-right ">
                                    <li class="cart-item has-icon">


                                        <a href="http://mauweb.monamedia.net/lazada/gio-hang/" class="header-cart-link off-canvas-toggle nav-top-link is-small" data-open="#cart-popup" data-class="off-canvas-cart" title="Giỏ hàng" data-pos="right">

                                            <i class="fa fa-shopping-cart"
                                               data-icon-label="1">
                                            </i>
                                        </a>


                                        <!-- Cart Sidebar Popup -->
                                        <div id="cart-popup" class="mfp-hide widget_shopping_cart">
                                            <div class="cart-popup-inner inner-padding">
                                                <div class="cart-popup-title text-center">
                                                    <h4 class="uppercase">Giỏ hàng</h4>
                                                    <div class="is-divider"></div>
                                                </div>
                                                <div class="widget_shopping_cart_content">


                                                    <ul class="woocommerce-mini-cart cart_list product_list_widget ">
                                                        <li class="woocommerce-mini-cart-item mini_cart_item">
                                                            <a href="http://mauweb.monamedia.net/lazada/gio-hang/?remove_item=e46de7e1bcaaced9a54f1e9d0d2f800d&#038;_wpnonce=ebda79b9a7" class="remove remove_from_cart_button" aria-label="Xóa sản phẩm này" data-product_id="397" data-cart_item_key="e46de7e1bcaaced9a54f1e9d0d2f800d" data-product_sku="">&times;</a>													<a href="http://mauweb.monamedia.net/lazada/san-pham/balo-nho-thoi-trang-chu-thap-xinhstore/">
                                                                <img width="180" height="180" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-180x180.jpg" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-600x600.jpg 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/Balo-01.jpg 741w" sizes="(max-width: 180px) 100vw, 180px" />Balo Nhỏ Thời Trang Chử Thập XinhStore&nbsp;							</a>

                                                            <span class="quantity">1 &times; <span class="woocommerce-Price-amount amount">69,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></span>					</li>
                                                    </ul>

                                                    <p class="woocommerce-mini-cart__total total"><strong>Tổng cộng:</strong> <span class="woocommerce-Price-amount amount">69,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></p>


                                                    <p class="woocommerce-mini-cart__buttons buttons"><a href="http://mauweb.monamedia.net/lazada/gio-hang/" class="button wc-forward">Xem giỏ hàng</a><a href="http://mauweb.monamedia.net/lazada/thanh-toan/" class="button checkout wc-forward">Thanh toán</a></p>


                                                </div>
                                                <div class="cart-sidebar-content relative"></div>  </div>
                                        </div>

                                    </li>
                                </ul>
                            </div>


                        </div><!-- .header-inner -->

                        <!-- Header divider -->
                        <div class="container"><div class="top-divider full-width"></div></div>
                    </div> <div id="wide-nav" class="header-bottom wide-nav nav-dark flex-has-center hide-for-medium" style="background-color: black">
                        <div class="flex-row container">


                            <div class="flex-col hide-for-medium flex-center">

                                <ul class="nav header-nav header-bottom-nav nav-center  nav-line-bottom nav-spacing-xsmall nav-uppercase">
                                    <% for (Category c : cateList) {%>
                                    <li  class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown" style=" margin-left: 70px">
                                        <a href="${contextPath}/HomePageControllerMap?service=ByCate&cid=<%=c.getCategoryID()%>" class="menu-image-title-after nav-top-link">
                                            <span class="menu-image-title"><%=c.getCategoryName()%></span></a>

                                        <ul class='nav-dropdown nav-dropdown-simple'>
                                            <% for (Genre g : gerneList) {
                                                    if (g.getCategoryID() == c.getCategoryID()) {

                                            %>
                                            <li class="menu-item menu-item-type-taxonomy menu-item-object-product_cat  ">
                                                <a href="${contextPath}/HomePageControllerMap?service=ByGenre&gid=<%=g.getGenreID()%>" class="menu-image-title-after">
                                                    <span class="menu-image-title"><%=g.getGenreName()%></span></a></li>
                                                    <% } %>
                                                    <% } %>
                                        </ul>
                                    </li>
                                    <% }%>
                                </ul>
                            </div><!-- flex-col -->



                        </div><!-- .flex-row -->
                    </div><!-- .header-bottom -->

                    <div class="header-bg-container fill"><div class="header-bg-image fill"></div><div class="header-bg-color fill"></div></div><!-- .header-bg-container -->   </div><!-- header-wrapper-->
            </header>

        </div>
        <div id="main-menu" class="mobile-sidebar no-scrollbar mfp-hide">
            <div class="sidebar-menu no-scrollbar ">
                <ul class="nav nav-sidebar  nav-vertical nav-uppercase">
                    <li class="header-search-form search-form html relative has-icon">
                        <div class="header-search-form-wrapper">
                            <div class="searchform-wrapper ux-search-box relative form- is-normal"><form method="POST" class="searchform" action="HomePageController?service=search" role="search">
                                    <div class="flex-row relative">
                                        <div class="flex-col flex-grow">
                                            <input type="search" class="search-field mb-0" name="${search}" value="" placeholder="Search" />
                                            <input type="hidden" name="post_type" value="product" />
                                        </div><!-- .flex-col -->
                                        <div class="flex-col">
                                            <button type="submit" class="ux-search-submit submit-button secondary button icon mb-0">
                                                <i class="fa fa-search" ></i>				</button>
                                        </div><!-- .flex-col -->
                                    </div><!-- .flex-row -->
                                    <div class="live-search-results text-left z-top"></div>
                                </form>
                            </div>	</div>
                    </li>


                    <%if (x == null) {%>
                    <li class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children menu-item-1236 ">
                        <a href="${contextPath}/loginAndSecurity/login.jsp"class="nav-top-link nav-top-not-logged-in ">
                            <span> Login </span>
                        </a><!-- .account-login-link -->
                    </li>
                    <p style="color: white; font-size: 12px; ">/</p>
                    <li class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children menu-item-1236">
                        <a href="${contextPath}/loginAndSecurity/register.jsp"class="nav-top-link nav-top-not-logged-in ">
                            <span> Register </span>
                        </a><!-- .account-login-link -->
                    </li>
                    <%} else {%>
                    <li class=" menu-item  " style="cursor: pointer;">
                        <a href="${contextPath}/UserControllerMap?service=account"><span> Hello <%=x.getFullname()%></span></a>
                        <ul class='children'>
                            <% if (x.getSystemRole() == 1) {%>
                            <li  ><a href="${contextPath}/AdminControllerMap" class="menu-image-title-after"><span >Admin Dashboard</span></a></li>
                                <%}%>
                                <% if (x.getSell() == 1) { %>
                            <li  ><a href="${contextPath}/SellerControllerMap" class="menu-image-title-after"><span >Seller Dashboard</span></a></li>
                                <%}%>

                            <li  ><a href="${contextPath}/UserControllerMap?service=account" class="menu-image-title-after"><span >Account</span></a></li>
                            <li  ><a href="${contextPath}/UserControllerMap?service=info" class="menu-image-title-after"><span >User profile</span></a></li>

                            <li  ><a href="${contextPath}/UserControllerMap?service=changepassPage" class="menu-image-title-after"><span >DKM</span></a></li>
                            <li  ><a href="${contextPath}/UserControllerMap?service=logout" class="menu-image-title-after"><span >Logout</span></a></li>

                        </ul>
                    </li>
                    <%}%>      
                </ul>

            </div><!-- inner -->
        </div><!-- #mobile-menu -->

        <ul class="nav top-bar-nav nav-right nav-small  nav-">

        </ul>

    </body>
</html>