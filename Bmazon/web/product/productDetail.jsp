<%-- 
    Document   : product_detail
    Created on : Sep 21, 2021, 9:50:48 AM
    Author     : AD
--%>
<%@page import="model.CommentDAO"%>
<%@page import="entity.Comment"%>
<%@page import="entity.User"%>
<%@page import="entity.Seller"%>
<%@page import="model.SellerDAO"%>
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
    SellerDAO daoSeller = new SellerDAO();
    GalleryDAO daoGallery = new GalleryDAO();
    ProductDAO daoProduct = new ProductDAO();
    CommentDAO daoComment = new CommentDAO();
    Product product = (Product) request.getAttribute("product");
    List<Gallery> listGallery = (List<Gallery>) request.getAttribute("listGallery");
    List<ProductType> listProductType = (List<ProductType>) request.getAttribute("listProductType");
    ArrayList<Product> listRelated = (ArrayList<Product>) request.getAttribute("listRelated");
    ArrayList<String> listSize = (ArrayList<String>) request.getAttribute("listSize");
    ArrayList<String> listColor = (ArrayList<String>) request.getAttribute("listColor");
    String size = "";
    String color = "";
    ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
    int countNumberComment = daoComment.getNumberOfComment(product.getProductID());
    User x = (User) request.getSession().getAttribute("currUser");
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
                                        <% for (int star = 5; star > 0; star--) {%>
                                        <%if (star <= product.getRating()) {%>
                                        <label for="star<%=star%>" title="text" style="color: #ffe793;"><%=star%> stars</label>
                                        <%} else {%>
                                        <label for="star<%=star%>" title="text"><%=star%> stars</label>
                                        <%}
                                    }%>
                                    </div><span><%=countNumberComment%> reviews</span>
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
                                <%
                                    Seller sel = daoSeller.getSellerByProductId(product.getProductID());%>
                                <div class="product-seller">
                                    <a href="HomePageControllerMap?service=shopPage&sid=<%=daoSeller.getSellerByProductId(product.getProductID()).getSellerID()%>">
                                        <span>Shop: <%=sel.getSellerShopName()%></span>
                                    </a>
                                </div>
                            </div>
                            <form method="POST" action="CartControllerMap" >
                                <div class="row">
                                    <input type="hidden" name="pid" value="<%=product.getProductID()%>">
                                    <input type="hidden" name="name"value="<%=product.getProductName()%>">
                                    <div class="col-md-6">
                                        <label for="size">Size</label>
                                        <select id="size" onchange="getPrice()" name="size" class="form-control">
                                            <%for (String productType : listSize) {%>
                                            <option><%=productType%></option>
                                            <% size = productType;%>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="color">Color</label>
                                        <select id="color" onchange="getPrice()" name="color" class="form-control">
                                            <%for (String productType : listColor) {%>
                                            <option><%=productType%></option>
                                            <% color = productType;%>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="product-count">
                                    <label for="quantity">Quantity</label>
                                    <%  ProductType pt = daoProductType.getProductTypeByColorAndSize(color, size, String.valueOf(product.getProductID()));
                                    %>
                                    <%if (pt.getQuantity() > 0) {%>
                                    <div class="quantity buttons_added">

                                        <input type="button" value="-" class="minus button is-form">		<label class="screen-reader-text" for="quantity_6167ef4cc82d1">Số lượng</label>
                                        <input type="number" class="input-text qty text" step="1" min="1" max="<%=pt.getQuantity()%>" name="quantity" value="1" title="SL" size="4" pattern="[0-9]*" inputmode="numeric" />
                                        <input type="button" value="+" class="plus button is-form">	
                                    </div>
                                </div><br>
                                <p style="color: red">${mess}</p>
                                <button type="submit"class="round-black-btn" name="service" value="AddToCart">Add to Cart</button>
                                <%} else {%>
                                <p>This product is out of stock</p>
                                <br><br>
                                <%}%>



                            </form>

                        </div>
                    </div>
                </div>

                <div class="product-info-tabs">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-selected="true">Description</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review" aria-selected="false">Reviews (<%=countNumberComment%>)</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                            <p><%=product.getDescription()%></p>
                        </div>
                        <div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="review-tab">
                            <div class="review-heading">REVIEWS</div>
                            <%if (!comments.isEmpty() && comments != null) {%>
                            <%
                                for (Comment elem : comments) {
                            %>                   
                            <div class="comment_box">
                                <div class="col-md-6">
                                    <p class="comment_content">
                                        From:<a href="HomePageControllerMap?service=userInteraction&userId=<%=elem.getUserID()%>"> 
                                            <%=daoUser.getUserById(String.valueOf(elem.getUserID())).getFullname()%>
                                        </a>
                                    </p> 
                                    <p class="comment_content">Rating:<%=elem.getRating()%>/5</p>
                                </div>                          
                                <div class="col-md-5"> </div>
                                <div class="col-md-1"> </div>
                                <div class="col-md-12"> 
                                    <div style="border: 1px solid black; border-radius: 5px;padding: 10px;">
                                        <p class="comment_content " > <%=elem.getContent()%></p> 
                                    </div> 
                                </div>
                            </div><hr style="color: black;">
                            <% }
                            } else {%> 
                            <p class="mb-20">There are no reviews yet.</p>
                            <%}%>
                            <br>
                            <%
                                if (x != null && !daoComment.checkExistComment(product.getProductID(), Integer.parseInt(x.getUserId()))) {%>
                            <form action="ProductDetailControllerMap" class="review-form">
                                <div class="form-group">

                                    <p style="color: black; font-size: 18px;">Your rating:    
                                        <input name="rating" type="number" min="0" max="5" style="width: 60px; height: 40px;"> 
                                        <i style="color: #ffe793; height: 30px; width: 30px; " class="fas fa-star"></i>
                                    </p>      
                                    <div class="form-group">
                                        <label>Your message</label>
                                        <textarea name="content" class="form-control" rows="10"></textarea>
                                        <input type="hidden" name ="service" value="comment" >
                                        <input type="hidden" name ="pid" value="<%=product.getProductID()%>" >
                                    </div>
                                    <button class="round-black-btn" type="submit">Submit Review</button>
                                </div>
                            </form>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <section class="section sec_dien_thoai" id="section_1788051855">
            <section class="section sec_dien_thoai" id="section_1788051855">
                <div class="section-content relative">

                    <div class="gap-element" style="display:block; height:auto; padding-top:30px" class="clearfix"></div>
                    <br>
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
                </div>
            </section>
        </section>
        <style scope="scope">
            #section_1788051855 {
                padding-top: 0px;
                padding-bottom: 0px;
            }
        </style>
        <br><br><br>

        <jsp:include page="../footer.jsp"/>
    </body>
    <!--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>-->
    <script>
        var color = document.getElementById("color").value;
        var size = document.getElementById("size").value;
        var quantity = document.getElementById("quantity").value;
        var link = "CartControllerMap?service=AddToCart&pid=" +<%=product.getProductID()%> + "&size=" + size + "&color=" + color + "&quantity=" + quantity;
        $("a[href='AddToCart']").attr('href',
                link);
        console.log(link);

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
                    service: "getPrice"
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
</html>