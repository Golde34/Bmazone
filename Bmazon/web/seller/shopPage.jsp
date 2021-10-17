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
    User user = (User) request.getAttribute("user");
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">    
        <title>BMAZON</title>
        <link rel='stylesheet' href="css/home.css"  type='text/css'>
        <style>
            .cover {
                background-color: black;
                background-image: url(${contextPath}/upload/<%= user.getBackgroundImage()%>);
                background-size: cover;
                background-repeat: no-repeat;
                background-position:center; 
                height: 230px;
                position: relative;
                width: 100%;
                margin-left: auto;
                margin-right: auto;
            } 
            
        </style>
        <!--[if IE]><link rel="stylesheet" type="text/css" href="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css"><script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src="http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js"></script><![endif]--> 
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

        <div class="row" style="background-color: #CCCCFF;">
            <div class="col-md-4" style="border: 2px solid white">
                <div class="row">
                    <a class="navbar-brand" href="#">
                    <div class="logo-image">
                        <div class="col-md-6">
                        <img src="${contextPath}/upload/<%= user.getProfileImage()%>" width="120" height="120">
                        </div>
                        <div class="col-md-6">
                            <h1 style="text-align: center; margin-top: 35px; font-size: 40px;"><%=user.getUsername()%></h1></div>
                    </div>
                    </a>
                    <div>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-4" style="border: 2px solid white">
                <div class="col-md-12">
                    <span>Address: <%=user.getAddress()%></span>
                </div>
                <div class="col-md-12">
                    <span>Phone: <%=user.getPhoneNumber()%></span>
                </div>
                <div class="col-md-12">
                    <span>Bio: <%=user.getBio()%></span>
                </div>
                <div class="col-md-12">
                    <span>Twitter: <%=user.getTwitter()%></span>
                </div>
            </div>
            <div class="col-md-4" style="border: 2px solid white">
                <div class="col-md-12">
                    <span>Email: <%=user.getEmail()%></span>
                </div>
                <div class="col-md-12">
                    <span>FB: <%=user.getFacebook()%></span>
                </div>
                <div class="col-md-12">
                    <span>Instagram: <%=user.getInstagram()%></span>
                </div>
                <div class="col-md-12">
                    <span>Youtube: <%=user.getYoutube()%></span>
                </div>
            </div>
        </div>

        <div class="row" style="margin-top: 20px;">
            <div class="col-md-12" style="background-color: #CCCCFF">
                <div class="flex-row container">
                    <div class="flex-col hide-for-medium flex-center">
                        <ul class="nav header-nav header-bottom-nav nav-center  nav-line-bottom nav-spacing-xsmall nav-uppercase">
                            <% for (Category c : cateList) {%>
                            <li  class="menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown" style=" margin-left: 70px;">
                                <a href="${contextPath}/HomePageControllerMap?service=ByCate&cid=<%=c.getCategoryID()%>" class="menu-image-title-after nav-top-link">
                                    <span class="menu-image-title" style="color: black"><%=c.getCategoryName()%></span></a>
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
            </div>
        </div>


        <div id="wrapper">
            <br><br><br>
            <main id="main" class="">
                <div class="col large-12">              
                    <div class="shop-container">

                        <div class="products row row-small large-columns-5 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1" id="1" style="background-color: #CCCCFF">
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

                                    <li><a class="active" href="HomePageControllerMap?service=shopPage&sid=${sid}&page=${i}">${i}</a></li>
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
