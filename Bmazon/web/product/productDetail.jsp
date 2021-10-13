<%-- 
    Document   : product_detail
    Created on : Sep 21, 2021, 9:50:48 AM
    Author     : AD
--%>


<%@page import="model.ProductDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.ProductTypeDAO"%>
<%@page import="model.UserDAO"%>
<%@page import="model.GalleryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.ProductType"%>
<%@page import="entity.Gallery"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DecimalFormat nf = new DecimalFormat("###,###,###");%>
<%
    ProductTypeDAO daoProductType = new ProductTypeDAO();
    UserDAO daoUser = new UserDAO();
    GalleryDAO daoGallery = new GalleryDAO();
    ProductDAO daoProduct = new ProductDAO();
    Product product = (Product) request.getAttribute("product");
    List<Gallery> listGallery = (List<Gallery>) request.getAttribute("listGallery");
    List<ProductType> listProductType = (List<ProductType>) request.getAttribute("listProductType");
    ArrayList<Product> listRelated = (ArrayList<Product>) request.getAttribute("listRelated");
    ArrayList<String> listSize = (ArrayList<String>) request.getAttribute("listSize");
    ArrayList<String> listColor = (ArrayList<String>) request.getAttribute("listColor");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity=" sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/productDetail.js"></script>
        <style>
            .pd-wrap {
                padding: 40px 0;
                font-family: 'Poppins', sans-serif;
            }
            .heading-section {
                text-align: center;
                margin-bottom: 20px;
            }
            .sub-heading {
                font-family: 'Poppins', sans-serif;
                font-size: 12px;
                display: block;
                font-weight: 600;
                color: #2e9ca1;
                text-transform: uppercase;
                letter-spacing: 2px;
            }
            .heading-section h2 {
                font-size: 32px;
                font-weight: 500;
                padding-top: 10px;
                padding-bottom: 15px;
                font-family: 'Poppins', sans-serif;
            }
            .user-img {
                width: 80px;
                height: 80px;
                border-radius: 50%;
                position: relative;
                min-width: 80px;
                background-size: 100%;
            }
            .carousel-testimonial .item {
                padding: 30px 10px;
            }
            .quote {
                position: absolute;
                top: -23px;
                color: #2e9da1;
                font-size: 27px;
            }
            .name {
                margin-bottom: 0;
                line-height: 14px;
                font-size: 17px;
                font-weight: 500;
            }
            .position {
                color: #adadad;
                font-size: 14px;
            }
            .owl-nav button {
                position: absolute;
                top: 50%;
                transform: translate(0, -50%);
                outline: none;
                height: 25px;
            }
            .owl-nav button svg {
                width: 25px;
                height: 25px;
            }
            .owl-nav button.owl-prev {
                left: 25px;
            }
            .owl-nav button.owl-next {
                right: 25px;
            }
            .owl-nav button span {
                font-size: 45px;
            }
            .owl-item active current{
                width: 150px;
            }
            .owl-item active{
                width: 150px;
            }
            .product-thumb .item img {
                height: 100px;
            }
            .product-name {
                font-size: 24px;
                font-weight: 500;
                line-height: 30px;
                margin-bottom: 8px;
            }
            .product-seller{
                margin-bottom: 12px;
            }
            .product-price-discount {
                font-size: 22px;
                font-weight: 400;
                padding: 10px 0;
                clear: both;
            }
            .product-price-discount span.line-through {
                text-decoration: line-through;
                margin-left: 10px;
                font-size: 14px;
                vertical-align: middle;
                color: #a5a5a5;
            }
            .display-flex {
                display: flex;
            }
            .align-center {
                align-items: center;
            }
            .product-info {
                width: 100%;
            }
            .reviews-counter {
                font-size: 13px;
            }
            .reviews-counter span {
                vertical-align: -2px;
            }
            .rate {
                float: left;
                padding: 0 10px 0 0;
            }
            .rate:not(:checked) > input {
                position:absolute;
                top:-9999px;
            }
            .rate:not(:checked) > label {
                float: right;
                width: 15px;
                overflow: hidden;
                white-space: nowrap;
                cursor: pointer;
                font-size: 21px;
                color:#ccc;
                margin-bottom: 0;
                line-height: 21px;
            }
            .rate:not(:checked) > label:before {
                content: '\2605';
            }
            .rate > input:checked ~ label {
                color: #ffc700;    
            }
            .rate:not(:checked) > label:hover,
            .rate:not(:checked) > label:hover ~ label {
                color: #deb217;  
            }
            .rate > input:checked + label:hover,
            .rate > input:checked + label:hover ~ label,
            .rate > input:checked ~ label:hover,
            .rate > input:checked ~ label:hover ~ label,
            .rate > label:hover ~ input:checked ~ label {
                color: #c59b08;
            }
            .product-dtl p {
                font-size: 14px;
                line-height: 24px;
                color: #7a7a7a;
            }
            .product-dtl .form-control {
                font-size: 15px;
            }
            .product-dtl label {
                line-height: 16px;
                font-size: 15px;
            }
            .form-control:focus {
                outline: none;
                box-shadow: none;
            }
            .product-count {
                margin-top: 15px; 
            }
            .product-count .qtyminus,
            .product-count .qtyplus {
                width: 34px;
                height: 34px;
                background: #212529;
                text-align: center;
                font-size: 19px;
                line-height: 36px;
                color: #fff;
                cursor: pointer;
            }
            .product-count .qtyminus {
                border-radius: 3px 0 0 3px; 
            }
            .product-count .qtyplus {
                border-radius: 0 3px 3px 0; 
            }
            .product-count .qty {
                width: 60px;
                text-align: center;
            }
            .round-black-btn {
                border-radius: 4px;
                background: #212529;
                color: #fff;
                padding: 7px 45px;
                display: inline-block;
                margin-top: 20px;
                border: solid 2px #212529; 
                transition: all 0.5s ease-in-out 0s;
            }
            .round-black-btn:hover,
            .round-black-btn:focus {
                background: transparent;
                color: #212529;
                text-decoration: none;
            }

            .product-info-tabs {
                margin-top: 25px; 
            }
            .product-info-tabs .nav-tabs {
                border-bottom: 2px solid #d8d8d8;
            }
            .product-info-tabs .nav-tabs .nav-item {
                margin-bottom: 0;
            }
            .product-info-tabs .nav-tabs .nav-link {
                border: none; 
                border-bottom: 2px solid transparent;
                color: #323232;
            }
            .product-info-tabs .nav-tabs .nav-item .nav-link:hover {
                border: none; 
            }
            .product-info-tabs .nav-tabs .nav-item.show .nav-link, 
            .product-info-tabs .nav-tabs .nav-link.active, 
            .product-info-tabs .nav-tabs .nav-link.active:hover {
                border: none; 
                border-bottom: 2px solid #d8d8d8;
                font-weight: bold;
            }
            .product-info-tabs .tab-content .tab-pane {
                padding: 30px 20px;
                font-size: 15px;
                line-height: 24px;
                color: #7a7a7a;
            }
            .review-form .form-group {
                clear: both;
            }
            .mb-20 {
                margin-bottom: 20px;
            }

            .review-form .rate {
                float: none;
                display: inline-block;
            }
            .review-heading {
                font-size: 24px;
                font-weight: 600;
                line-height: 24px;
                margin-bottom: 6px;
                text-transform: uppercase;
                color: #000;
            }
            .review-form .form-control {
                font-size: 14px;
            }
            .review-form input.form-control {
                height: 40px;
            }
            .review-form textarea.form-control {
                resize: none;
            }
            .review-form .round-black-btn {
                text-transform: uppercase;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"/>

        <div class="pd-wrap">
            <div class="container">
                <div class="heading-section">
                    <h2>Product Details</h2>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div id="slider" class="owl-carousel product-slider">
                            <%for (Gallery gallery : listGallery) {%>
                            <div class="item">
                                <%String str = "images/" + gallery.getLink();%>
                                <img src="<%=str%>"/>
                            </div>
                            <%}%>
                        </div>
                        <div id="thumb" class="owl-carousel product-thumb">
                            <%for (Gallery gallery : listGallery) {%>
                            <div class="item">
                                <%String str = "images/" + gallery.getLink();%>
                                <img src="<%=str%>"/>
                            </div>
                            <%}%>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product-dtl">
                            <div class="product-info">
                                <div class="product-name"><%=product.getProductName()%></div>
                                <div class="reviews-counter">
                                    <div class="rate">
                                        <input type="radio" id="star5" name="rate" value="5" checked />
                                        <label for="star5" title="text">5 stars</label>
                                        <input type="radio" id="star4" name="rate" value="4" checked />
                                        <label for="star4" title="text">4 stars</label>
                                        <input type="radio" id="star3" name="rate" value="3" checked />
                                        <label for="star3" title="text">3 stars</label>
                                        <input type="radio" id="star2" name="rate" value="2" />
                                        <label for="star2" title="text">2 stars</label>
                                        <input type="radio" id="star1" name="rate" value="1" />
                                        <label for="star1" title="text">1 star</label>
                                    </div>
                                    <span>3 Reviews</span>
                                </div>
                                <%double price1 = Double.parseDouble(daoProductType.getProductPrice(product.getProductID()));%>
                                <div class="product-price-discount">
                                    <span>
                                        <span id="price"><%=nf.format(price1)%></span>&nbsp;
                                        <span class="woocommerce-Price-currencySymbol">&#8363;
                                        </span>
                                    </span>
                                    <span class="line-through"><%=nf.format(price1 * 1.05)%>&nbsp; 
                                        <span class="woocommerce-Price-currencySymbol">&#8363;
                                        </span>
                                    </span>
                                </div>
                                <div class="product-releasedate"><span>Release Date: <%=product.getReleaseDate()%></span></div>
                                <div class="product-seller"><span>Seller: <%=daoUser.getUserByProductId(product.getProductID()).getUsername()%></span></div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <label for="size">Size</label>
                                    <select id="size" onchange="getPrice()" name="size" class="form-control">
                                        <%for (String productType : listSize) {%>
                                        <option><%=productType%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <label for="color">Color</label>
                                    <select id="color" onchange="getPrice()" name="color" class="form-control">
                                        <%for (String productType : listColor) {%>
                                        <option><%=productType%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="product-count">
                                <label for="quantity">Quantity</label>
                                <form action="#" class="display-flex">
                                    <div class="qtyminus">-</div>
                                    <input type="text" name="quantity" value="1" class="qty">
                                    <div class="qtyplus">+</div>
                                </form>
                                <a href="#" class="round-black-btn">Buy Now</a>
                                <a href="#" class="round-black-btn">Add to Cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-info-tabs">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-selected="true">Description</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review" aria-selected="false">Reviews (0)</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                            <p><%=product.getDescription()%></p>
                        </div>
                        <div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="review-tab">
                            <div class="review-heading">REVIEWS</div>
                            <p class="mb-20">There are no reviews yet.</p>
                            <form class="review-form">
                                <div class="form-group">
                                    <label>Your rating</label>
                                    <div class="reviews-counter">
                                        <div class="rate">
                                            <input type="radio" id="star5" name="rate" value="5" />
                                            <label for="star5" title="text">5 stars</label>
                                            <input type="radio" id="star4" name="rate" value="4" />
                                            <label for="star4" title="text">4 stars</label>
                                            <input type="radio" id="star3" name="rate" value="3" />
                                            <label for="star3" title="text">3 stars</label>
                                            <input type="radio" id="star2" name="rate" value="2" />
                                            <label for="star2" title="text">2 stars</label>
                                            <input type="radio" id="star1" name="rate" value="1" />
                                            <label for="star1" title="text">1 star</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Your message</label>
                                    <textarea class="form-control" rows="10"></textarea>
                                </div>

                                <button class="round-black-btn">Submit Review</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <section class="section sec_dien_thoai" id="section_1788051855">

            <div class="section-content relative">

                <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>

                <br><br>

                <div class="row row-collapse align-equal"  id="row-1706731289">
                    <div class="text">
                        <div class="col-inner text-center" >
                            <h1>Related Products</h1>
                        </div>
                        <div class="col-inner text-left" >
                            <p class="orange" style="float: right" ><a href="ProductDetailControllerMap?service=getRelatedProduct&pid=<%=product.getProductID()%>"><label>View All</label></a></p>
                        </div>
                    </div>              
                    <br>
                    <br>
                    <br>
                    <div class="col medium-12 small-12 large-12" >
                        <div class="col-inner"  >
                            <div class="row large-columns-5 medium-columns- small-columns-2 row-collapse has-shadow row-box-shadow-1 slider row-slider slider-nav-reveal slider-nav-push"  data-flickity-options='{"imagesLoaded": true, "groupCells": "100%", "dragThreshold" : 5, "cellAlign": "left","wrapAround": true,"prevNextButtons": true,"percentPosition": true,"pageDots": false, "rightToLeft": false, "autoPlay" : 3000}'>
                                <% for (Product pro : listRelated) {
                                        String str2 = "images/" + daoGallery.getSampleOfProduct(pro.getProductID());
                                        double price2 = Double.parseDouble(daoProductType.getProductPrice(product.getProductID()));
                                %>
                                <div class="col" >
                                    <div class="col-inner">
                                        <div class="product-small box has-hover box-normal box-text-bottom">
                                            <div class="box-image" style="width:150px; height:150px ">
                                                <div class="" >
                                                    <a href="ProductDetailControllerMap?service=getProductDetail&pid=<%=pro.getProductID()%>">
                                                        <img src="<%=str2%>"></a>
                                                </div>

                                            </div><!-- box-image -->
                                            <div class="box-text text-center" style="background-color:rgb(255, 255, 255);">
                                                <div class="title-wrapper" >		
                                                    <p class="category uppercase is-smaller no-text-overflow product-cat op-7">   </p> <%--category--%>
                                                    <p class="name product-title"><a href=""> <%=pro.getProductName()%> </a></p>
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
                        </div>
                    </div>
                    <%--Arrival LEFT PIC --%>          

                    <style scope="scope">
                        #row-1706731289 > .col > .col-inner {
                            background-color: rgb(255, 255, 255);
                        }
                    </style>
                </div>


                <style scope="scope">

                    #section_1788051855 {
                        padding-top: 0px;
                        padding-bottom: 0px;

                    }
                </style>
        </section>
        <br><br><br>






        <jsp:include page="../footer.jsp"/>
    </body>
<!--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>-->
    <script>
        function getPrice() {
            var color = document.getElementById("color").value;
            var size = document.getElementById("size").value;
            console.log(size);
            console.log(color);
            console.log("<%=product.getProductID()%>");
            $.ajax({
                url: "/Bmazon/ProductDetailControllerMap",
                type: "get",
                data: {
                    color: color,
                    size: size,
                    pid: "<%=product.getProductID()%>",
                    service:"getPrice"
                },
                success: function (respone) {
                    var text = document.getElementById("price");
                    text.innerHTML = respone;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
    </script>
</html>
