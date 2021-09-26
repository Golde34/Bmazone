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


                <div id="content" role="main" class="content-area" >


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
                                                    String price = ptDAO.getProductPrice(ps.getProductID());


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
                                                                </p> <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>"> <%=ps.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price"><del><span class="woocommerce-Price-amount amount">290,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                    <ins><span class="woocommerce-Price-amount amount"> <%=price%> <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
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
                                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pn.getProductID()%>">

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

                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pn.getProductID()%>""> <%=pn.getProductName()%> </a></p>
]
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pn.getProductID()%>"> <%=pn.getProductName()%> </a></p>

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
                                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pa.getProductID()%>">

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
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pa.getProductID()%>"> <%=pa.getProductName()%> </a></p>
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
                                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pa.getProductID()%>">

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
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pa.getProductID()%>"> <%=pa.getProductName()%> </a></p>
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
                                            <div class="shop-container">

                                                <div class="woof_products_top_panel"></div>

                                                <div class="products row row-small large-columns-4 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1">



                                                    <div class="product-small col has-hover post-1178 product type-product status-publish has-post-thumbnail product_cat-bach-hoa-online product_cat-do-hop-dong-goi first instock shipping-taxable purchasable product-type-simple">
                                                        <div class="col-inner">

                                                            <div class="badge-container absolute left top z-1">
                                                            </div>
                                                            <div class="product-small box ">
                                                                <div class="box-image">
                                                                    <div class="image-fade_in_back">
                                                                        <a href="http://mauweb.monamedia.net/lazada/san-pham/bo-2-nuoc-giat-omo-mactic-cua-truoc-2-7kg/">
                                                                            <img width="300" height="300" src="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-300x300.png" class="attachment-shop_catalog size-shop_catalog wp-post-image" alt="" srcset="//mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-300x300.png 300w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-150x150.png 150w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-768x768.png 768w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-180x180.png 180w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-600x600.png 600w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-24x24.png 24w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-36x36.png 36w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-48x48.png 48w, //mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01.png 1024w" sizes="(max-width: 300px) 100vw, 300px" /><img width="300" height="300" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-300x300.png" class="show-on-hover absolute fill hide-for-small back-image" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-300x300.png 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-150x150.png 150w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-768x768.png 768w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-180x180.png 180w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-600x600.png 600w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-24x24.png 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-36x36.png 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01-48x48.png 48w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/11/omo-matic-01.png 1024w" sizes="(max-width: 300px) 100vw, 300px" />				</a>
                                                                    </div>
                                                                    <div class="image-tools is-small top right show-on-hover">
                                                                    </div>
                                                                    <div class="image-tools is-small hide-for-small bottom left show-on-hover">
                                                                    </div>
                                                                    <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                                    </div>
                                                                </div><!-- box-image -->

                                                                <div class="box-text box-text-products text-center grid-style-2">
                                                                    <div class="title-wrapper">		<p class="category uppercase is-smaller no-text-overflow product-cat op-7">
                                                                            Bách hóa online		</p> <p class="name product-title"><a href="http://mauweb.monamedia.net/lazada/san-pham/bo-2-nuoc-giat-omo-mactic-cua-truoc-2-7kg/">Bộ 2 nước giặt OMO Mactic cửa trước 2.7kg</a></p></div><div class="price-wrapper">
                                                                        <span class="price"><span class="woocommerce-Price-amount amount">314,000&nbsp;<span class="woocommerce-Price-currencySymbol">&#8363;</span></span></span>
                                                                    </div>		</div><!-- box-text -->
                                                            </div><!-- box -->
                                                        </div><!-- .col-inner -->
                                                    </div><!-- col -->

                                                </div><!-- row -->






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
