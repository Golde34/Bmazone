package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\" sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <style>\n");
      out.write("            .pd-wrap {\n");
      out.write("                padding: 40px 0;\n");
      out.write("                font-family: 'Poppins', sans-serif;\n");
      out.write("            }\n");
      out.write("            .heading-section {\n");
      out.write("                text-align: center;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            .sub-heading {\n");
      out.write("                font-family: 'Poppins', sans-serif;\n");
      out.write("                font-size: 12px;\n");
      out.write("                display: block;\n");
      out.write("                font-weight: 600;\n");
      out.write("                color: #2e9ca1;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                letter-spacing: 2px;\n");
      out.write("            }\n");
      out.write("            .heading-section h2 {\n");
      out.write("                font-size: 32px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                padding-top: 10px;\n");
      out.write("                padding-bottom: 15px;\n");
      out.write("                font-family: 'Poppins', sans-serif;\n");
      out.write("            }\n");
      out.write("            .user-img {\n");
      out.write("                width: 80px;\n");
      out.write("                height: 80px;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                position: relative;\n");
      out.write("                min-width: 80px;\n");
      out.write("                background-size: 100%;\n");
      out.write("            }\n");
      out.write("            .carousel-testimonial .item {\n");
      out.write("                padding: 30px 10px;\n");
      out.write("            }\n");
      out.write("            .quote {\n");
      out.write("                position: absolute;\n");
      out.write("                top: -23px;\n");
      out.write("                color: #2e9da1;\n");
      out.write("                font-size: 27px;\n");
      out.write("            }\n");
      out.write("            .name {\n");
      out.write("                margin-bottom: 0;\n");
      out.write("                line-height: 14px;\n");
      out.write("                font-size: 17px;\n");
      out.write("                font-weight: 500;\n");
      out.write("            }\n");
      out.write("            .position {\n");
      out.write("                color: #adadad;\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("            .owl-nav button {\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                transform: translate(0, -50%);\n");
      out.write("                outline: none;\n");
      out.write("                height: 25px;\n");
      out.write("            }\n");
      out.write("            .owl-nav button svg {\n");
      out.write("                width: 25px;\n");
      out.write("                height: 25px;\n");
      out.write("            }\n");
      out.write("            .owl-nav button.owl-prev {\n");
      out.write("                left: 25px;\n");
      out.write("            }\n");
      out.write("            .owl-nav button.owl-next {\n");
      out.write("                right: 25px;\n");
      out.write("            }\n");
      out.write("            .owl-nav button span {\n");
      out.write("                font-size: 45px;\n");
      out.write("            }\n");
      out.write("            .product-thumb .item img {\n");
      out.write("                height: 100px;\n");
      out.write("            }\n");
      out.write("            .product-name {\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-weight: 500;\n");
      out.write("                line-height: 22px;\n");
      out.write("                margin-bottom: 4px;\n");
      out.write("            }\n");
      out.write("            .product-price-discount {\n");
      out.write("                font-size: 22px;\n");
      out.write("                font-weight: 400;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                clear: both;\n");
      out.write("            }\n");
      out.write("            .product-price-discount span.line-through {\n");
      out.write("                text-decoration: line-through;\n");
      out.write("                margin-left: 10px;\n");
      out.write("                font-size: 14px;\n");
      out.write("                vertical-align: middle;\n");
      out.write("                color: #a5a5a5;\n");
      out.write("            }\n");
      out.write("            .display-flex {\n");
      out.write("                display: flex;\n");
      out.write("            }\n");
      out.write("            .align-center {\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("            .product-info {\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .reviews-counter {\n");
      out.write("                font-size: 13px;\n");
      out.write("            }\n");
      out.write("            .reviews-counter span {\n");
      out.write("                vertical-align: -2px;\n");
      out.write("            }\n");
      out.write("            .rate {\n");
      out.write("                float: left;\n");
      out.write("                padding: 0 10px 0 0;\n");
      out.write("            }\n");
      out.write("            .rate:not(:checked) > input {\n");
      out.write("                position:absolute;\n");
      out.write("                top:-9999px;\n");
      out.write("            }\n");
      out.write("            .rate:not(:checked) > label {\n");
      out.write("                float: right;\n");
      out.write("                width: 15px;\n");
      out.write("                overflow: hidden;\n");
      out.write("                white-space: nowrap;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 21px;\n");
      out.write("                color:#ccc;\n");
      out.write("                margin-bottom: 0;\n");
      out.write("                line-height: 21px;\n");
      out.write("            }\n");
      out.write("            .rate:not(:checked) > label:before {\n");
      out.write("                content: '\\2605';\n");
      out.write("            }\n");
      out.write("            .rate > input:checked ~ label {\n");
      out.write("                color: #ffc700;    \n");
      out.write("            }\n");
      out.write("            .rate:not(:checked) > label:hover,\n");
      out.write("            .rate:not(:checked) > label:hover ~ label {\n");
      out.write("                color: #deb217;  \n");
      out.write("            }\n");
      out.write("            .rate > input:checked + label:hover,\n");
      out.write("            .rate > input:checked + label:hover ~ label,\n");
      out.write("            .rate > input:checked ~ label:hover,\n");
      out.write("            .rate > input:checked ~ label:hover ~ label,\n");
      out.write("            .rate > label:hover ~ input:checked ~ label {\n");
      out.write("                color: #c59b08;\n");
      out.write("            }\n");
      out.write("            .product-dtl p {\n");
      out.write("                font-size: 14px;\n");
      out.write("                line-height: 24px;\n");
      out.write("                color: #7a7a7a;\n");
      out.write("            }\n");
      out.write("            .product-dtl .form-control {\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("            .product-dtl label {\n");
      out.write("                line-height: 16px;\n");
      out.write("                font-size: 15px;\n");
      out.write("            }\n");
      out.write("            .form-control:focus {\n");
      out.write("                outline: none;\n");
      out.write("                box-shadow: none;\n");
      out.write("            }\n");
      out.write("            .product-count {\n");
      out.write("                margin-top: 15px; \n");
      out.write("            }\n");
      out.write("            .product-count .qtyminus,\n");
      out.write("            .product-count .qtyplus {\n");
      out.write("                width: 34px;\n");
      out.write("                height: 34px;\n");
      out.write("                background: #212529;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 19px;\n");
      out.write("                line-height: 36px;\n");
      out.write("                color: #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .product-count .qtyminus {\n");
      out.write("                border-radius: 3px 0 0 3px; \n");
      out.write("            }\n");
      out.write("            .product-count .qtyplus {\n");
      out.write("                border-radius: 0 3px 3px 0; \n");
      out.write("            }\n");
      out.write("            .product-count .qty {\n");
      out.write("                width: 60px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .round-black-btn {\n");
      out.write("                border-radius: 4px;\n");
      out.write("                background: #212529;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 7px 45px;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                border: solid 2px #212529; \n");
      out.write("                transition: all 0.5s ease-in-out 0s;\n");
      out.write("            }\n");
      out.write("            .round-black-btn:hover,\n");
      out.write("            .round-black-btn:focus {\n");
      out.write("                background: transparent;\n");
      out.write("                color: #212529;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .product-info-tabs {\n");
      out.write("                margin-top: 25px; \n");
      out.write("            }\n");
      out.write("            .product-info-tabs .nav-tabs {\n");
      out.write("                border-bottom: 2px solid #d8d8d8;\n");
      out.write("            }\n");
      out.write("            .product-info-tabs .nav-tabs .nav-item {\n");
      out.write("                margin-bottom: 0;\n");
      out.write("            }\n");
      out.write("            .product-info-tabs .nav-tabs .nav-link {\n");
      out.write("                border: none; \n");
      out.write("                border-bottom: 2px solid transparent;\n");
      out.write("                color: #323232;\n");
      out.write("            }\n");
      out.write("            .product-info-tabs .nav-tabs .nav-item .nav-link:hover {\n");
      out.write("                border: none; \n");
      out.write("            }\n");
      out.write("            .product-info-tabs .nav-tabs .nav-item.show .nav-link, \n");
      out.write("            .product-info-tabs .nav-tabs .nav-link.active, \n");
      out.write("            .product-info-tabs .nav-tabs .nav-link.active:hover {\n");
      out.write("                border: none; \n");
      out.write("                border-bottom: 2px solid #d8d8d8;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .product-info-tabs .tab-content .tab-pane {\n");
      out.write("                padding: 30px 20px;\n");
      out.write("                font-size: 15px;\n");
      out.write("                line-height: 24px;\n");
      out.write("                color: #7a7a7a;\n");
      out.write("            }\n");
      out.write("            .review-form .form-group {\n");
      out.write("                clear: both;\n");
      out.write("            }\n");
      out.write("            .mb-20 {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .review-form .rate {\n");
      out.write("                float: none;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            .review-heading {\n");
      out.write("                font-size: 24px;\n");
      out.write("                font-weight: 600;\n");
      out.write("                line-height: 24px;\n");
      out.write("                margin-bottom: 6px;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                color: #000;\n");
      out.write("            }\n");
      out.write("            .review-form .form-control {\n");
      out.write("                font-size: 14px;\n");
      out.write("            }\n");
      out.write("            .review-form input.form-control {\n");
      out.write("                height: 40px;\n");
      out.write("            }\n");
      out.write("            .review-form textarea.form-control {\n");
      out.write("                resize: none;\n");
      out.write("            }\n");
      out.write("            .review-form .round-black-btn {\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"pd-wrap\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"heading-section\">\n");
      out.write("                    <h2>Product Details</h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div id=\"slider\" class=\"owl-carousel product-slider\">\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"thumb\" class=\"owl-carousel product-thumb\">\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg\" />\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw\" />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"product-dtl\">\n");
      out.write("                            <div class=\"product-info\">\n");
      out.write("                                <div class=\"product-name\">Variable Product</div>\n");
      out.write("                                <div class=\"reviews-counter\">\n");
      out.write("                                    <div class=\"rate\">\n");
      out.write("                                        <input type=\"radio\" id=\"star5\" name=\"rate\" value=\"5\" checked />\n");
      out.write("                                        <label for=\"star5\" title=\"text\">5 stars</label>\n");
      out.write("                                        <input type=\"radio\" id=\"star4\" name=\"rate\" value=\"4\" checked />\n");
      out.write("                                        <label for=\"star4\" title=\"text\">4 stars</label>\n");
      out.write("                                        <input type=\"radio\" id=\"star3\" name=\"rate\" value=\"3\" checked />\n");
      out.write("                                        <label for=\"star3\" title=\"text\">3 stars</label>\n");
      out.write("                                        <input type=\"radio\" id=\"star2\" name=\"rate\" value=\"2\" />\n");
      out.write("                                        <label for=\"star2\" title=\"text\">2 stars</label>\n");
      out.write("                                        <input type=\"radio\" id=\"star1\" name=\"rate\" value=\"1\" />\n");
      out.write("                                        <label for=\"star1\" title=\"text\">1 star</label>\n");
      out.write("                                    </div>\n");
      out.write("                                    <span>3 Reviews</span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"product-price-discount\"><span>$39.00</span><span class=\"line-through\">$29.00</span></div>\n");
      out.write("                            </div>\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <label for=\"size\">Size</label>\n");
      out.write("                                    <select id=\"size\" name=\"size\" class=\"form-control\">\n");
      out.write("                                        <option>S</option>\n");
      out.write("                                        <option>M</option>\n");
      out.write("                                        <option>L</option>\n");
      out.write("                                        <option>XL</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("                                    <label for=\"color\">Color</label>\n");
      out.write("                                    <select id=\"color\" name=\"color\" class=\"form-control\">\n");
      out.write("                                        <option>Blue</option>\n");
      out.write("                                        <option>Green</option>\n");
      out.write("                                        <option>Red</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"product-count\">\n");
      out.write("                                <label for=\"size\">Quantity</label>\n");
      out.write("                                <form action=\"#\" class=\"display-flex\">\n");
      out.write("                                    <div class=\"qtyminus\">-</div>\n");
      out.write("                                    <input type=\"text\" name=\"quantity\" value=\"1\" class=\"qty\">\n");
      out.write("                                    <div class=\"qtyplus\">+</div>\n");
      out.write("                                </form>\n");
      out.write("                                <a href=\"#\" class=\"round-black-btn\">Add to Cart</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"product-info-tabs\">\n");
      out.write("                    <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" id=\"description-tab\" data-toggle=\"tab\" href=\"#description\" role=\"tab\" aria-controls=\"description\" aria-selected=\"true\">Description</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" id=\"review-tab\" data-toggle=\"tab\" href=\"#review\" role=\"tab\" aria-controls=\"review\" aria-selected=\"false\">Reviews (0)</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                        <div class=\"tab-pane fade show active\" id=\"description\" role=\"tabpanel\" aria-labelledby=\"description-tab\">\n");
      out.write("                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"review\" role=\"tabpanel\" aria-labelledby=\"review-tab\">\n");
      out.write("                            <div class=\"review-heading\">REVIEWS</div>\n");
      out.write("                            <p class=\"mb-20\">There are no reviews yet.</p>\n");
      out.write("                            <form class=\"review-form\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Your rating</label>\n");
      out.write("                                    <div class=\"reviews-counter\">\n");
      out.write("                                        <div class=\"rate\">\n");
      out.write("                                            <input type=\"radio\" id=\"star5\" name=\"rate\" value=\"5\" />\n");
      out.write("                                            <label for=\"star5\" title=\"text\">5 stars</label>\n");
      out.write("                                            <input type=\"radio\" id=\"star4\" name=\"rate\" value=\"4\" />\n");
      out.write("                                            <label for=\"star4\" title=\"text\">4 stars</label>\n");
      out.write("                                            <input type=\"radio\" id=\"star3\" name=\"rate\" value=\"3\" />\n");
      out.write("                                            <label for=\"star3\" title=\"text\">3 stars</label>\n");
      out.write("                                            <input type=\"radio\" id=\"star2\" name=\"rate\" value=\"2\" />\n");
      out.write("                                            <label for=\"star2\" title=\"text\">2 stars</label>\n");
      out.write("                                            <input type=\"radio\" id=\"star1\" name=\"rate\" value=\"1\" />\n");
      out.write("                                            <label for=\"star1\" title=\"text\">1 star</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Your message</label>\n");
      out.write("                                    <textarea class=\"form-control\" rows=\"10\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input type=\"text\" name=\"\" class=\"form-control\" placeholder=\"Name*\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input type=\"text\" name=\"\" class=\"form-control\" placeholder=\"Email Id*\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"round-black-btn\">Submit Review</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div style=\"text-align:center;font-size:14px;padding-bottom:20px;\">Get free icon packs for your next project at <a href=\"http://iiicons.in/\" target=\"_blank\" style=\"color:#ff5e63;font-weight:bold;\">www.iiicons.in</a></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
