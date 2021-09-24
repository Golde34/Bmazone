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
<%

    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ProductDAO proDAO = new ProductDAO();
    GalleryDAO gallDAO = new GalleryDAO();
    ProductTypeDAO ptDAO = new ProductTypeDAO();
    List<Category> cateList = daoCate.getTrueCategories();
    List<Genre> gerneList = genDAO.getTrueGenres();
    List<Product> ListSale = proDAO.getProductSale();
    List<Product> ListNew = proDAO.getProductNew();
    List<Product> ListApple = proDAO.getProductApple();


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
        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]--> 
        <script src="js/1.js"></script>
        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
        <link rel='stylesheet' href="css/2.css"  type='text/css'>
        <link rel='stylesheet' href="css/3.css"  type='text/css'> 
        <link rel='stylesheet' href="css/slide.css"  type='text/css'> 

        <script src="js/2.js"></script>


        <script src="js.home.js"></script>
    </head>
    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow" >

        <div id="wrapper">

            <main id="main" class="" style="">


                <div id="content" role="main" class="content-area" style="background-color: #000">


                    <section class="section" id="section_2111671223">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:5px" class="clearfix"></div>
                            <section class="section sec_tab_banner" id="section_992612852">
                                <div class="bg section-bg fill bg-fill  bg-loaded" >





                                </div><!-- .section-bg -->

                                <div class="section-content relative">

                                    <div class="row row-collapse"  id="row-1954119617">

                                        <div class="col small-12 large-12"  ><div class="col-inner"  >
                                                <div>
                                                    <div class="slideshow-container">

                                                        <div class="mySlides fade">
                                                            <div class="numbertext">1 / 3</div>
                                                            <img src="images/slide1.jpg" style="width:1000px ;height: 500px">
                                                            <div class="text">Caption Text</div>
                                                        </div>

                                                        <div class="mySlides fade">
                                                            <div class="numbertext">2 / 3</div>
                                                            <img src="images/slide2.jpg" style="width:1000px ;height: 500px">
                                                            <div class="text">Caption Two</div>
                                                        </div>

                                                        <div class="mySlides fade">
                                                            <div class="numbertext">3 / 3</div>
                                                            <img src="images/slide3.jpg" style="width:1000px ;height: 500px">
                                                            <div class="text">Caption Three</div>
                                                        </div>

                                                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                                                        <a class="next" onclick="plusSlides(1)">&#10095;</a>

                                                    </div>
                                                    <br>

                                                    <div style="text-align:center">
                                                        <span class="dot" onclick="currentSlide(1)"></span> 
                                                        <span class="dot" onclick="currentSlide(2)"></span> 
                                                        <span class="dot" onclick="currentSlide(3)"></span> 
                                                    </div>
                                                    <script src="js/slide.js"></script>
                                                </div>
                                            </div>
                                        </div>                             
                                    </div>

                                </div><!-- .section-content -->


                                <style scope="scope">

                                    #section_992612852 {
                                        padding-top: 0px;
                                        padding-bottom: 0px;
                                    }
                                </style>
                            </section>

                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_2111671223 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>

                    <section class="section sec_flash_sale" id="section_1352472076">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse align-middle"  id="row-1649239858">
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner"  >
                                        <div class="img has-hover x md-x lg-x y md-y lg-y" id="image_1627766676">
                                            <div class="img-inner dark" >
                                                <img width="480" height="92" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale.png" class="attachment-original size-original" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale.png 480w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-300x58.png 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-24x5.png 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-36x7.png 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-48x9.png 48w" sizes="(max-width: 480px) 100vw, 480px" />						
                                            </div>

                                            <style scope="scope">

                                                #image_1627766676 {
                                                    width: 75%;
                                                }
                                            </style>
                                        </div>

                                    </div></div>
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner" style="padding:0px 0px 0px 0px;" >


                                    </div></div>
                                <div class="col medium-8 small-12 large-8"  ><div class="col-inner text-right"  >
                                        <p class="orange"><a href="">Xem Tất Cả &gt;</a></p>
                                    </div></div>

                                <style scope="scope">

                                </style>
                            </div>
                            <div class="row row-collapse"  id="row-1976639540">
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner"  >
                                        <div class="img has-hover x md-x lg-x y md-y lg-y" id="image_1911105025">
                                            <div class="img-inner dark" >
                                                <img width="466" height="666" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale.jpg" class="attachment-original size-original" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale.jpg 466w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale-210x300.jpg 210w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale-17x24.jpg 17w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale-25x36.jpg 25w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-flash-sale-34x48.jpg 34w" sizes="(max-width: 466px) 100vw, 466px" />						
                                            </div>

                                            <style scope="scope">

                                                #image_1911105025 {
                                                    width: 100%;
                                                }
                                            </style>
                                        </div>

                                    </div></div>
                                <div class="col medium-10 small-12 large-10"  ><div class="col-inner"  >


                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>

                                            <% for (Product ps : ListSale) {
                                                    String str1 = "images/" + gallDAO.getSampleOfProduct(ps.getProductID());
                                                    String price=ptDAO.getProductPrice(ps.getProductID());
                                                    

                                            %>


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">

                                                          

                                                            <div class=""  >
                                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>">


                                                                    <img src="<%=str1%>"></a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                </p> <p class="name product-title"><a href="ProductDetailMap?service=getProductDetail&pid=<%=ps.getProductID()%>"> <%=ps.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                    <ins><span class="woocommerce-Price-amount amount"> <%=price %> <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->
                                            <%

                                                }
                                            %>



                                        </div>
                                    </div></div>


                            </div>
                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_1352472076 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>







                    <section class="section sec_top_deal" id="section_1299208273">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  id="row-7631193">
                                <div class="col small-12 large-12"  ><div class="col-inner"  >
                                        <h4>New Arrival</h4>
                                    </div></div>

                            </div>
                            <div class="row row-collapse align-equal"  id="row-1706731289">
                                <div class="col medium-10 small-12 large-10"  ><div class="col-inner"  >


                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : 3000}'>



                                            <% for (Product pn : ListNew) {
                                                    String str2 = "images/" + gallDAO.getSampleOfProduct(pn.getProductID());

                                            %>
                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                            <div class="" >
                                                                <a href="HomepageControllerMap?service=detail">

                                                                    <img src="<%=str2%>"></a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >		
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                                <p class="name product-title"><a href=""> <%=pn.getProductName()%> </a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                    <ins><span class="woocommerce-Price-amount amount">145,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->

                                            <%    }
                                            %>

                                        </div>
                                    </div>
                                </div>
                                <%--Arrival LEFT PIC --%>          
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner"  >
                                        <div class="img has-hover x md-x lg-x y md-y lg-y" id="image_683044710">
                                            <div class="img-inner dark" >
                                                <img width="466" height="666" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal.jpg" class="attachment-original size-original" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal.jpg 466w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal-210x300.jpg 210w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal-17x24.jpg 17w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal-25x36.jpg 25w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-deal-34x48.jpg 34w" sizes="(max-width: 466px) 100vw, 466px" />						
                                            </div>

                                            <style scope="scope">

                                                #image_683044710 {
                                                    width: 100%;
                                                }
                                            </style>
                                        </div>

                                    </div>
                                </div>
                                <style scope="scope">

                                    #row-1706731289 > .col > .col-inner {
                                        background-color: rgb(255, 255, 255);
                                    }
                                </style>
                            </div>
                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_1299208273 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>

                    <section class="section sec_dien_thoai" id="section_1788051855">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  style="height: 30px">
                                <div class="col small-12 large-12" ><div class="col-inner"   >
                                        <h4><img src="images/Apple1.jpg"  style="height: 40px"></h4>
                                    </div></div>


                            </div>
                            <br><br>
                            <div class="row row-collapse align-equal"  id="row-803623343">

                                <div class="col medium-12 small-12 large-12"  ><div class="col-inner"  >

                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>

                                            <% for (Product pa : ListApple) {
                                                    String str3 = "images/" + gallDAO.getSampleOfProduct(pa.getProductID());

                                            %>
                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                            <div class="" >
                                                                <a href="HomepageControllerMap?service=detail">

                                                                    <img src="<%=str3%>"></a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >		
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                                <p class="name product-title"><a href=""> <%=pa.getProductName()%> </a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                    <ins><span class="woocommerce-Price-amount amount">145,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->

                                            <%    }
                                            %>



                                        </div>
                                    </div></div>

                                <style scope="scope">

                                    #row-803623343 > .col > .col-inner {
                                        background-color: rgb(255, 255, 255);
                                    }
                                </style>
                            </div>
                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_1788051855 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>

                    <section class="section sec_oto_xemay" id="section_223985075">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  id="row-1330870627">
                                <div class="col small-12 large-12"  ><div class="col-inner"  >
                                        <h4>Ô tô &amp; Xe máy &#8211; Deal hot trong ngày</h4>
                                    </div></div>

                                <style scope="scope">

                                </style>
                            </div>
                            <div class="row row-collapse align-equal"  id="row-818385982">
                                <div class="col medium-10 small-12 large-10"  ><div class="col-inner"  >


                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>

                                            <% for (Product pa : ListApple) {
                                                    String str3 = "images/" + gallDAO.getSampleOfProduct(pa.getProductID());

                                            %>
                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                            <div class="" >
                                                                <a href="HomepageControllerMap?service=detail">

                                                                    <img src="<%=str3%>"></a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >		
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                                <p class="name product-title"><a href=""> <%=pa.getProductName()%> </a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                    <ins><span class="woocommerce-Price-amount amount">145,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->

                                            <%    }
                                            %>






                                        </div>
                                    </div></div>
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner"  >
                                        <div class="img has-hover x md-x lg-x y md-y lg-y" id="image_2009107627">
                                            <div class="img-inner dark" >
                                                <img width="466" height="666" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that.jpg" class="attachment-original size-original" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that.jpg 466w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that-210x300.jpg 210w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that-17x24.jpg 17w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that-25x36.jpg 25w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/banner-noi-that-34x48.jpg 34w" sizes="(max-width: 466px) 100vw, 466px" />						
                                            </div>

                                            <style scope="scope">

                                                #image_2009107627 {
                                                    width: 100%;
                                                }
                                            </style>
                                        </div>

                                    </div></div>

                                <style scope="scope">

                                    #row-1008069511 > .col > .col-inner {
                                        background-color: rgb(255, 255, 255);
                                    }
                                </style>
                            </div>
                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_993802315 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>

                    <section class="section sec_top_sale" id="section_56152490">
                        <div class="bg section-bg fill bg-fill  bg-loaded" >





                        </div><!-- .section-bg -->

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  id="row-649522308">
                                <div class="col small-12 large-12"  ><div class="col-inner"  >
                                        <h4>Top Sellers</h4>
                                    </div></div>

                                <style scope="scope">

                                </style>
                            </div>
                            <div class="row row-collapse align-equal"  id="row-1448676555">
                                <div class="col small-12 large-12"  ><div class="col-inner"  >


                                        <div class="row large-columns-5 medium-columns-3 small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>




                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/ao-so-mi-caro-kem-belt/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-768x768.jpg 768w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-180x180.jpg 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-600x600.jpg 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-24x24.jpg 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-36x36.jpg 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02-48x48.jpg 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-02.jpg 960w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-768x768.jpg 768w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-600x600.jpg 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/AoSomiCaroNu-01.jpg 960w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Áo		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/ao-so-mi-caro-kem-belt/">Áo sơ mi caro kèm belt</a></p></div><div class="price-wrapper"><div class="star-rating"><span style="width:100%">Được xếp hạng <strong class="rating">5.00</strong> 5 sao</span></div>
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">145,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-33%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/xiaomi-note-4x-16gb-ram-3gb-2017-black-hang-nhap-khau/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-300x300.png" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-300x300.png 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-150x150.png 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-768x770.png 768w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-180x180.png 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-600x600.png 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-24x24.png 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-36x36.png 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04-48x48.png 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-04.png 943w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-300x300.png" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-300x300.png 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-150x150.png 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-180x180.png 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-600x600.png 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-24x24.png 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-36x36.png 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/xiaomi-note-4x-03-48x48.png 48w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Điện thoại		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/xiaomi-note-4x-16gb-ram-3gb-2017-black-hang-nhap-khau/">Xiaomi Note 4X 16GB Ram 3GB 2017 ( Black) &#8211; Hàng nhập khẩu</a></p></div><div class="price-wrapper">
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">4,127,732&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">2,761,999&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-40%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/nhot-motul-xe-tay-ga-scooter-expert-le-10w40-800ml/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-02-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-02-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-02-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-02-180x180.jpg 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-02-600x600.jpg 600w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-768x768.jpg 768w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-600x600.jpg 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/nhot-motul-01.jpg 850w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Chăm sóc		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/nhot-motul-xe-tay-ga-scooter-expert-le-10w40-800ml/">Nhớt MOTUL xe tay ga Scooter Expert LE 10W40 800ml</a></p></div><div class="price-wrapper">
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">159,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">95,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-19%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/samsung-galaxy-j7-pro-2017-32gb-ram-3gb-den/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-300x300.png" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-300x300.png 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-150x150.png 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-180x180.png 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-600x600.png 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-24x24.png 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-36x36.png 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-01-48x48.png 48w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-300x300.png" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-300x300.png 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-150x150.png 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-180x180.png 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-600x600.png 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-24x24.png 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-36x36.png 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/samsung-j7-03-48x48.png 48w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Điện thoại		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/samsung-galaxy-j7-pro-2017-32gb-ram-3gb-den/">Samsung Galaxy J7 Pro 2017 32GB Ram 3GB (Đen)</a></p></div><div class="price-wrapper">
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">6,990,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">5,684,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-18%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/goi-om-brown-%e2%9d%a4%ef%b8%8f-cony/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-02-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-02-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-02-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-02-180x180.jpg 180w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-600x600.jpg 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/GauOm-01.jpg 640w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Chăn		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/goi-om-brown-%e2%9d%a4%ef%b8%8f-cony/">Gối ôm Brown  ❤️  Cony</a></p></div><div class="price-wrapper">
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">170,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">140,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-25%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/keo-milo-cube-275g-100-vien/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-768x768.jpg 768w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-180x180.jpg 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-600x600.jpg 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-24x24.jpg 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-36x36.jpg 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02-48x48.jpg 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-02.jpg 960w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-768x768.jpg 768w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-1024x1024.jpg 1024w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-600x600.jpg 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/milo-cube-01.jpg 1200w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Ăn vặt &amp; Bánh kẹo		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/keo-milo-cube-275g-100-vien/">Kẹo MILO CUBE 275g &#8211; 100 viên</a></p></div><div class="price-wrapper">
                                                                <span class="price"><del><span class="woocommerce-Price-amount amount">170,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> <ins><span class="woocommerce-Price-amount amount">127,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/set-the-thao-ao-khoac-day-keo/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-180x180.jpg 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-600x600.jpg 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-24x24.jpg 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-36x36.jpg 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02-48x48.jpg 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-02.jpg 750w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/SetTheThao-01.jpg 553w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Giày &amp; Trang phục thể thao		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/set-the-thao-ao-khoac-day-keo/">Set Thể Thao Áo Khoác Dây Kéo</a></p></div><div class="price-wrapper">
                                                                <span class="price"><span class="woocommerce-Price-amount amount">299,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->


                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:74%;">
                                                            <div class="" >
                                                                <a href="http://mauweb.monamedia.net/lazada/san-pham/vo-case-xigmatek-shockwave/">
                                                                    <img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-300x300.jpg" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-300x300.jpg 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-150x150.jpg 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-180x180.jpg 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-24x24.jpg 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-36x36.jpg 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03-48x48.jpg 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-03.jpg 374w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-300x300.jpg" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-300x300.jpg 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-150x150.jpg 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-180x180.jpg 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-24x24.jpg 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-36x36.jpg 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01-48x48.jpg 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/VoCase-01.jpg 374w" sizes="(max-width: 300px) 100vw, 300px" />									</a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" >
                                                            <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                    Linh kiện máy tính		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/vo-case-xigmatek-shockwave/">Vỏ Case Xigmatek Shockwave</a></p></div><div class="price-wrapper">
                                                                <span class="price"><span class="woocommerce-Price-amount amount">890,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></span>
                                                            </div>							</div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->

                                        </div>
                                    </div></div>

                                <style scope="scope">

                                    #row-1448676555 > .col > .col-inner {
                                        background-color: rgb(255, 255, 255);
                                    }
                                </style>
                            </div>
                            <div class="gap-element" style="display:block; height:auto; padding-top:60px" class="clearfix"></div>
                        </div><!-- .section-content -->


                        <style scope="scope">

                            #section_56152490 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>



                </div>



            </main>
        </div>



    </body>
</html>
