<%@page import="entity.Seller"%>
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
    List<Product> listProduct = (List<Product>) request.getAttribute("listProduct");
    List<Product> listNewArrival = (List<Product>) request.getAttribute("listNewArrival");
    User user = (User) request.getAttribute("user");
    Seller seller = (Seller) request.getAttribute("seller");
    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ArrayList<Category> cateList = daoCate.getTrueCategories();
    ArrayList<Genre> gerneList = genDAO.getTrueGenres();
%>

<!DOCTYPE html>
<html>
    <!--[if IE 9 ]> <html lang="vi" class="ie9 loading-site no-js"> <![endif]-->
    <!--[if IE 8 ]> <html lang="vi" class="ie8 loading-site no-js"> <![endif]-->
    <!--[if (gte IE 9)|!(IE)]><!--><html lang="vi" class="loading-site no-js"> <!--<![endif]-->
        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">    
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <title>BMAZON</title>
            <link rel='stylesheet' href="css/home.css"  type='text/css'>
            <style>
                .bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} 
                .bg-loaded{opacity: 1;}
                .col-md-12{
                    margin-top: 10px;
                    margin-bottom: 10px;
                }
                .container a.active{
                    background-color: #4CAF50;
                }
                .woocommerce-pagination a:hover:not(.active){
                    background-color: chocolate;
                }
                .cover{
                    background-color: black;
                    background-image: url(${contextPath}/upload/<%= user.getBackgroundImage()%>);
                    background-size: cover;
                    background-repeat: no-repeat;
                    background-position:center; 
                    height: 15rem;
                    position: relative;
                    width: 100%;
                    margin-left: auto;
                    margin-right: auto;
                }
            </style>
            <script src="js/1.js"></script>
            <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
            <link rel='stylesheet' href="css/2.css"  type='text/css'>
            <link rel='stylesheet' href="css/3.css"  type='text/css'> 
            <link rel='stylesheet' href="css/slide.css"  type='text/css'> 
            <script src="js/2.js"></script>
            <script src="js.home.js"></script>

        </head>
        <body >
            <jsp:include page="../header.jsp"/>
            <!--Background image-->
            <div class="row cover"></div>
            <br>
            <div class="row" style="margin-top: 20px; background-color: #f6fafb; border-radius: 15px;">
                <div class="col-md-4" style="border-top: 2px solid white; border-radius: 15px; border-bottom: 2px solid white; text-align: center; background-color: #222222;">
                    <%String img = "upload/" + user.getProfileImage();%> 
                    <img style="border-radius: 100%; border: 5px solid #AAAAAA; margin-top: 10px; height: 100px; width: 100px;" src="<%=img%>">
                    <h1 style="text-align: center; margin-top: 8px; margin-bottom: 8px; font-size: 25px;  text-align: center; color: white; background-color: grey; border-radius: 15px;"><%=seller.getSellerShopName()%></h1>
                </div>
                <div class="col-md-4" style="border: 2px solid white; padding-left: 80px; font-family: sans-serif;">
                    <div class="col-md-12" style="font-size: 16px; margin-top: 18px;">
                        <span class="glyphicon glyphicon-home" style="margin-right: 10px;"></span><span>Address: <%=user.getAddress()%></span>
                    </div>
                    <div class="col-md-12" style="font-size: 16px; margin-top: 20px;">
                        <span class="glyphicon glyphicon-phone-alt" style="margin-right: 10px;"></span><span>Phone: <%=seller.getSellerPhone()%></span>
                    </div>
                    <div class="col-md-12" style="font-size: 16px; margin-top: 20px;">
                        <span class="glyphicon glyphicon-pencil" style="margin-right: 10px;"></span><span><%=seller.getDescription()%></span>
                    </div>
                </div>
                <div class="col-md-4" style="border: 2px solid white; font-family: sans-serif">
                    <div class="col-md-12" style="font-size: 16px; margin-top: 18px;">
                        <i class="fa fa-facebook-square" style="margin-right: 10px;"></i><span>FB: <%=user.getFacebook()%></span>
                    </div>
                    <div class="col-md-12" style="font-size: 16px; margin-top: 20px;">
                        <i class="fa fa-instagram" style="margin-right: 10px;"></i><span>Instagram: <%=user.getInstagram()%></span>
                    </div>
                    <div class="col-md-12" style="font-size: 16px; margin-top: 20px;">
                        <span class="glyphicon glyphicon-envelope" style="margin-right: 10px;"></span><span>Email: <%=user.getEmail()%></span>
                    </div>
                </div>
            </div> 

            <section class="section sec_dien_thoai" id="section_1788051855">
                <section class="section sec_dien_thoai" id="section_1788051855">
                    <div class="section-content relative">
                        <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                        <br><br>
                        <div class="row row-collapse align-equal"  id="row-1706731289">
                            <hr>
                            <div class="text">
                                <div class="col-inner text-center" >
                                    <h1><strong>New Arrival</strong></h1>
                                </div>
                            </div>              
                            <br>
                            <br>
                            <br>
                            <div class="col medium-12 small-12 large-12" >
                                <div class="col-inner"  >
                                    <div class="row large-columns-5 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : 3000}'>
                                        <% for (Product pr : listNewArrival) {
                                                String str2 = "images/" + daoGallery.getSampleOfProduct(pr.getProductID());
                                                double price2 = Double.parseDouble(daoProductType.getProductPrice(pr.getProductID()));
                                        %>
                                        <div class="col" >
                                            <div class="col-inner">
                                                <div class="product-small box has-hover box-normal box-text-bottom">
                                                    <div class="box-image" style="width:150px; height:150px ">
                                                        <div class="" >
                                                            <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pr.getProductID()%>">
                                                                <img src="<%=str2%>"></a>
                                                        </div>
                                                    </div><!-- box-image -->
                                                    <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                        <div class="title-wrapper" >		
                                                            <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                            <p class="name product-title"><a href=""> <%=pr.getProductName()%> </a></p>
                                                        </div> 
                                                        <div class="price-wrapper" 
                                                             <span class="price"><del><span class="woocommerce-Price-amount amount"><%=nf.format(price2 * 1.05)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></del> 
                                                                <ins><span class="woocommerce-Price-amount amount"><%=nf.format(price2)%>&nbsp; <span class="woocommerce-Price-currencySymbol">&#8363;</span></span></ins></span>
                                                        </div>							
                                                    </div><!-- box-text -->
                                                </div><!-- box -->
                                            </div><!-- .col-inner -->
                                        </div><!-- col -->
                                        <% }
                                        %>
                                    </div>
                                    <br><br><hr>
                                </div>     
                            </div>
                            <%--Arrival LEFT PIC --%>          
                            <style scope="scope">
                                #row-1706731289 > .col > .col-inner {
                                    background-color: rgb(255, 255, 255);
                                }
                            </style>
                        </div>
                    </div>
                    <style scope="scope">
                        #section_1788051855 {
                            padding-top: 0px;
                            padding-bottom: 0px;
                        }
                    </style>
                </section>
            </section>
            <br>

            <div id="wrapper">
                <div class="col large-12">              
                    <div class="shop-container">
                        <h1 style="text-align: center;"><strong>List All Product</strong></h1>

                        <div class="products row row-small large-columns-5 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1" id="1">
                            <% for (Product pro : listProduct) {
                                    String str = "images/" + daoGallery.getSampleOfProduct(pro.getProductID());
                                    double price = Double.parseDouble(daoProductType.getProductPrice(pro.getProductID()));

                            %>
                            <div class="product-small col has-hover post-1178 product type-product status-publish has-post-thumbnail product_cat-bach-hoa-online product_cat-do-hop-dong-goi first instock shipping-taxable purchasable product-type-simple" style="margin-top: 20px;">
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

                                    <li><a class=" ${page==i?"active":""}" href="HomePageControllerMap?service=shopPage&sid=${sid}&page=${i}">${i}</a></li>
                                    </c:forEach>
                                    ${next}
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>

            <jsp:include page="../footer.jsp"/>
        </body>
    </html>
