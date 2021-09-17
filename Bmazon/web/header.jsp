<%@page import="entity.Gallery"%>
<%@page import="entity.User"%>
<%@page import="model.DBConnection"%>
<%@page import="model.DAOGallery"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]--> 
        <script src="js/1.js"></script>
        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
        <link rel='stylesheet' href="css/2.css"  type='text/css'>
        <script type="text/javascript">var essb_settings = {"ajax_url": "http:\/\/mauweb.monamedia.net\/lazada\/wp-admin\/admin-ajax.php", "essb3_nonce": "2096ea4430", "essb3_plugin_url": "http:\/\/mauweb.monamedia.net\/lazada\/wp-content\/plugins\/easy-social-share-buttons3", "essb3_facebook_total": true, "essb3_admin_ajax": false, "essb3_internal_counter": false, "essb3_stats": false, "essb3_ga": false, "essb3_ga_mode": "simple", "essb3_counter_button_min": 0, "essb3_counter_total_min": 0, "blog_url": "http:\/\/mauweb.monamedia.net\/lazada\/", "ajax_type": "wp", "essb3_postfloat_stay": false, "essb3_no_counter_mailprint": false, "essb3_single_ajax": false, "twitter_counter": "self", "post_id": 16};</script>
        <link rel='stylesheet' href="css/3.css"  type='text/css'> 

        <script src="js/2.js"> </script>

        <script src="js.home.js"> </script>
    </head>
    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow" >

        <a class="skip-link screen-reader-text" href="#main">Skip to content</a>

        <div id="wrapper">


            <header id="header" class="header has-sticky sticky-jump" >
                <div class="header-wrapper">
                    <div id="top-bar" class="header-top hide-for-sticky nav-dark">
                        <div class="flex-row container">
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

                                        <a href="jsp/login.jsp"class="nav-top-link nav-top-not-logged-in ">
                                            <span>
                                                Login     / Register  </span>
                                        </a><!-- .account-login-link -->

                                    </li>
                                    <%} else {%>
                                    <li class=" menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown"><a><span> Hello <%=x.getFullname()%></span></a>
                                        <ul class='nav-dropdown nav-dropdown-simple'>
                                            <%if (x.getSystemRole() == 1) {%>
                                            <li  ><a href="AdminControllerMap" class="menu-image-title-after"><span >Admin Dashboard</span></a></li>
                                                <%}%>
                                            
                                            <li  ><a href="UserControllerMap?service=info" class="menu-image-title-after"><span >User profile</span></a></li>
                                            <li  ><a href="UserControllerMap?service=changepass" class="menu-image-title-after"><span >Change Password</span></a></li>
                                            <li  ><a href="UserControllerMap?service=logout" class="menu-image-title-after"><span >Logout</span></a></li>

                                        </ul>
                                    </li>
                                    <%}%>
                                </ul>
                            </div><!-- .flex-col right -->



                        </div><!-- .flex-row -->
                    </div><!-- #header-top -->
                    <div id="masthead" class="header-main nav-dark" style="background:black ">
                        <div class="header-inner flex-row container logo-left medium-logo-center" role="navigation">

                            <!-- Logo -->
                            <div id="logo" class="flex-col logo">
                                <!-- Header logo -->
                                <a href="" title="BMAZON" rel="home">

                                    <img  width="124" height="75" src="images/fpt.png" class="header-logo-dark" /></a>
                            </div>




                            <!-- Left Elements -->
                            <div class="flex-col hide-for-medium flex-left
                                 flex-grow" >
                                <ul class="header-nav header-nav-main nav nav-left  nav-uppercase" >
                                    <li class="header-search-form search-form html relative has-icon">
                                        <div class="header-search-form-wrapper">
                                            <div class="searchform-wrapper ux-search-box relative form- is-normal"><form method="get" class="searchform" action="" role="search">
                                                    <div class="flex-row relative">
                                                        <div class="flex-col flex-grow">
                                                            <input type="search" class="search-field mb-0" name="" value="" placeholder="Find Product" />
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
                                    </li><li>
                                        <i>   <img src="iamges/car.png" style="height: 10px; width: 10px"></i>

                                        <a href="" title="Cart" class="header-cart-link is-small">



                                            <i class="fa fa-shopping-cart"
                                               data-icon-label="0">
                                            </i>
                                        </a>

                                        <ul class="nav-dropdown nav-dropdown-simple">
                                            <li class="html widget_shopping_cart">
                                                <div class="widget_shopping_cart_content">


                                                    <p class="woocommerce-mini-cart__empty-message">The cart is empty</p>


                                                </div>
                                            </li>
                                        </ul><!-- .nav-dropdown -->

                                    </li>
                                </ul>
                            </div>

                            <!-- Right Elements -->
                            <!-- logo ben trai-->
                            <div class="flex-col hide-for-medium flex-right" style="background:black ">
                                <ul class="header-nav header-nav-main nav nav-right  nav-uppercase">
                                    <li class="html custom html_nav_position_text"><img class="header_promotion" 
                                                                                        src="images/FPT.jpg" alt="promotion" style="height: 40px;width: 170px;"></li>            </ul>
                            </div>



                        </div>


                    </div>
              
                    
                    
                    
          
                </div>
            </header>



    </body>
</html>