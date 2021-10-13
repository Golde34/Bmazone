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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<% DecimalFormat nf = new DecimalFormat("###,###,###");%>
<%

    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ProductDAO proDAO = new ProductDAO();
    GalleryDAO gallDAO = new GalleryDAO();
    ProductTypeDAO ptDAO = new ProductTypeDAO();
    List<Product> ListSale = proDAO.getProductSale();
    List<Product> ListNew = proDAO.getProductNew();
    List<Product> ListApple = proDAO.getProductApple();
    List<Product> ListSuggest = proDAO.getProductSuggest();
    List<Genre> ListGenre = genDAO.getHomeGenre();


%>
<!DOCTYPE html>
<!--[if IE 9 ]> <html lang="vi" class="ie9 loading-site no-js"> <![endif]-->
<!--[if IE 8 ]> <html lang="vi" class="ie8 loading-site no-js"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="vi" class="loading-site no-js"> <!--<![endif]-->
    <head>
       
    </head>
    <body class="home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow" >

        <div id="wrapper">


            <main id="main" class="" style="">
                

                <div id="content" role="main" class="content-area" >
                    <section class="section" id="section_2111671223">                   
                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:5px" class="clearfix"></div>
                            <section class="section sec_tab_banner" id="section_992612852">

                                <div class="section-content relative">
                                    <div class="row">

                                    <div class="row row-collapse"  id="row-1954119617">

                                        <div class="col small-8 large-8"  >
                                            <div class="col-inner"  >



                                                <img class="mySlides" src="images/slide1.jpg"  style="height: 495.7px;width: 800px">
                                                <img class="mySlides" src="images/slide2.jpg"  style="height: 495.7px;width: 800px">
                                                <img class="mySlides" src="images/slide3.jpg"  style="height: 495.7px;width: 800px">
                                                <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
                                                    <div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
                                                    <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
                                                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
                                                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
                                                    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
                                                </div>



                                                <script src="js/slide.js"></script>

                                            </div>
                                        </div>    
                                        <div class="col small-4 large-4"  >
                                            <div class="col-inner"  >
                                                <img src="images/im1.jpg" >
                                                <img src="images/im2.jpg" >

                                            </div>
                                        </div>    
                                    </div>
                                        <div>
                                </div>
                                <!-- .section-content -->
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
                    
                    <section class="section sec_flash_sale" id="section_16406982">
                        <div class="section-content relative">
                            <br><br>
                            <div class="row row-collapse align-middle"  id="row-1888902941">
                                <div class="col medium-2 small-12 large-2"  ><div class="col-inner"  >
                                        <div class="img has-hover x md-x lg-x y md-y lg-y" id="image_510021313">
                                            <div class="img-inner dark" >
                                                <img width="480" height="92" src="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale.png" class="attachment-original size-original" alt="" srcset="http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale.png 480w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-300x58.png 300w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-24x5.png 24w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-36x7.png 36w, http://mauweb.monamedia.net/lazada/wp-content/uploads/2017/10/flash-sale-48x9.png 48w" sizes="(max-width: 480px) 100vw, 480px" />						
                                            </div>

                                            <style scope="scope">

                                                #image_510021313 {
                                                    width: 75%;
                                                }
                                            </style>
                                        </div>

                                    </div></div>

                                <div class="col medium-12 small-12 large-12"  >
                                    <div class="col-inner text-right" >
                                        <p class="orange" style="float: right" ><a href="HomePageControllerMap?service=list">Xem Tất Cả &gt;</a></p>
                                    </div>
                                </div>


                            </div>
                            <div class="row row-collapse"  id="row-698964333">

                                <div class="col medium-12 small-12 large-12"  >
                                    <div class="col-inner"  >
                                        <div class="row large-columns-5 medium-columns-5 small-columns-5 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>
                                            <% for (Product p : ListNew) {
                                                    String str = "images/" + gallDAO.getSampleOfProduct(p.getProductID());
                                                    double price = Double.parseDouble(ptDAO.getProductPrice(p.getProductID()));


                                            %>
                                            <div class="col" >
                                                <div class="col-inner">
                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                                <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>">
                                                                    <img src="<%=str%>"></a>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7"></p> 
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=p.getProductID()%>"> <%=p.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price">

                                                                    <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->
                                            <%
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- .section-content -->
                        <style scope="scope">

                            #section_16406982 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>


                    <section class="section sec_danh_muc" id="section_1885747892">
                        <div class="section-content relative">
                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  id="row-1147262871">
                                <div class="col small-12 large-12"  >
                                    <div class="col-inner"  >
                                        <h3>Categories</h3>
                                        <div class="slider-wrapper relative " id="slider-1053478107" >
                                            <div class="slider slider-nav-circle slider-nav-large slider-nav-light slider-style-normal"
                                                 data-flickity-options='{
                                                 "cellAlign": "center",
                                                 "imagesLoaded": true,
                                                 "lazyLoad": 1,
                                                 "freeScroll": false,
                                                 "wrapAround": true,
                                                 "autoPlay": false,
                                                 "pauseAutoPlayOnHover" : true,
                                                 "prevNextButtons": true,
                                                 "contain" : true,
                                                 "adaptiveHeight" : true,
                                                 "dragThreshold" : 5,
                                                 "percentPosition": true,
                                                 "pageDots": true,
                                                 "rightToLeft": false,
                                                 "draggable": true,
                                                 "selectedAttraction": 0.1,
                                                 "parallax" : 0,
                                                 "friction": 0.6        }'
                                                 >

                                                <div class="row row-collapse"  id="row-75835749">
                                                    <div class="col small-12 large-12"  ><div class="col-inner"  >


                                                            <div class="row large-columns-8 medium-columns-3 small-columns-2 row-collapse has-shadow row-box-shadow-1">
                                                                <% for (Genre g : ListGenre) {
                                                                        String str = "images/Genre/" + g.getImages();
                                                                %>
                                                                <div class="product-category col" >
                                                                    <div class="col-inner">
                                                                        <a href="HomePageControllerMap?service=ByGenre&gid=<%=g.getGenreID()%>">               
                                                                            <div class="box box-category has-hover box-normal ">
                                                                                <div class="box-image" style="width:50%;">
                                                                                    <div class="" >
                                                                                        <img src="<%=str%>"  width="300" height="300" />          
                                                                                    </div>
                                                                                </div><!-- box-image -->
                                                                                <div class="box-text text-center" >
                                                                                    <div class="box-text-inner">
                                                                                        <h5 class="uppercase header-title">
                                                                                            <%=g.getGenreName()%>                   </h5>

                                                                                    </div><!-- .box-text-inner -->
                                                                                </div><!-- .box-text -->
                                                                            </div><!-- .box -->
                                                                        </a>            </div><!-- .col-inner -->
                                                                </div><!-- .col -->
                                                                <%

                                                                    }
                                                                %>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- .ux-slider-wrapper -->
                                    </div>
                                </div>    
                            </div>
                        </div><!-- .section-content -->
                        <style scope="scope">

                            #section_1885747892 {
                                padding-top: 0px;
                                padding-bottom: 0px;
                                background-color: rgb(241, 241, 241);
                            }
                        </style>
                    </section>

                    <section class="section sec_top_deal" id="section_1299208273">
                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  id="row-7631193">
                                <div class="col small-12 large-12"  >
                                    <div class="col-inner"  >
                                        <h3>New Arrival</h3>
                                    </div>
                                    <div class="col-inner text-right" >
                                        <p class="orange" ><a href="HomePageControllerMap?service=list">Xem Tất Cả &gt;</a></p>
                                    </div>
                                </div>

                            </div>

                            <div class="row row-collapse align-equal"  id="row-1706731289">
                                <div class="col medium-10 small-12 large-10"  ><div class="col-inner"  >

                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>

                                            <% for (Product ps : ListNew) {
                                                    String str = "images/" + gallDAO.getSampleOfProduct(ps.getProductID());
                                                    double price = Double.parseDouble(ptDAO.getProductPrice(ps.getProductID()));


                                            %>
                                            <div class="col" >
                                                <div class="col-inner">
                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                            <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>">
                                                                <img src="<%=str%>"></a>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7"></p> 
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>"> <%=ps.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price">

                                                                    <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->
                                            <%
                                                }
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

                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  style="height: 30px">
                                <div class="col small-12 large-12" ><div class="col-inner"   >
                                        <h4><img src="images/Apple1.jpg"  style="height: 40px"></h4>
                                    </div>
                                    <div class="col-inner text-right" >
                                        <p class="orange" ><a href="HomepageControllerMap?service=">Xem Tất Cả &gt;</a></p>
                                    </div>
                                </div>

                            </div>
                            <br><br>
                            <div class="row row-collapse align-equal"  id="row-803623343">

                                <div class="col medium-12 small-12 large-12"  ><div class="col-inner"  >

                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : false}'>

                                            <% for (Product ps : ListApple) {
                                                    String str = "images/" + gallDAO.getSampleOfProduct(ps.getProductID());
                                                    double price = Double.parseDouble(ptDAO.getProductPrice(ps.getProductID()));


                                            %>
                                            <div class="col" >
                                                <div class="col-inner">

                                                    <div class="badge-container absolute left top z-1">
                                                        <div class="callout badge badge-square"><div class="badge-inner secondary on-sale"><span class="onsale">-50%</span></div></div>
                                                    </div>
                                                    <div class="product-small box has-hover box-normal box-text-bottom">
                                                        <div class="box-image" style="width:150px; height:150px ">
                                                            <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>">
                                                                <img src="<%=str%>"></a>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7"></p> 
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>"> <%=ps.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price">

                                                                    <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
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
                        <div class="section-content relative">

                            <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                            <div class="row row-collapse"  style="height: 30px">
                                <div class="col small-12 large-12" ><div class="col-inner"   >
                                        <h3>Suggest For You</h3>
                                    </div>
                                </div>
                            </div>
                            <br><br>
                            <div class="row row-collapse align-equal"  id="row-803623343">

                                <div class="col medium-12 small-12 large-12"  ><div class="col-inner"  >

                                        <div class="row large-columns-4 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 "  >

                                            <% for (Product ps : ListSuggest) {
                                                    String str = "images/" + gallDAO.getSampleOfProduct(ps.getProductID());
                                                    double price = Double.parseDouble(ptDAO.getProductPrice(ps.getProductID()));


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


                                                                    <img src="<%=str%>"></a>
                                                            </div>
                                                            <div class="image-tools z-top top right show-on-hover">
                                                            </div>
                                                            <div class="image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover">
                                                            </div>
                                                        </div><!-- box-image -->

                                                        <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                            <div class="title-wrapper" >
                                                                <p class="category uppercase is-smaller no-text-overflow product-cat op-7"></p> 
                                                                <p class="name product-title"><a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=ps.getProductID()%>"> <%=ps.getProductName()%> <br></a></p>
                                                            </div> 
                                                            <div class="price-wrapper" 
                                                                 <span class="price">

                                                                    <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                            </div>							
                                                        </div><!-- box-text -->
                                                    </div><!-- box -->
                                                </div><!-- .col-inner -->
                                            </div><!-- col -->
                                            <%

                                                }
                                            %>
                                                                                                                 
                                            <button class="button" onclick="window.location.href = 'HomePageControllerMap?service=list'" style=" border-radius: 5px;margin: auto; ">View More</button>

                                        </div>
                                    </div>
                                </div>

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
                </div>
            </main>
        </div>
                                                                      <br><br><br><br>
    </body>
</html>
