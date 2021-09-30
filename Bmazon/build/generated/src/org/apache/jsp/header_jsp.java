package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Gallery;
import entity.User;
import model.DBConnection;
import model.GalleryDAO;
import entity.Product;
import java.util.ArrayList;
import model.CategoryDAO;
import entity.Category;
import entity.Genre;
import model.GenreDAO;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

    DBConnection dbCon = new DBConnection();
    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ArrayList<Category> cateList = daoCate.getTrueCategories();
    ArrayList<Genre> gerneList = genDAO.getTrueGenres();


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if IE 9 ]> <html lang=\"vi\" class=\"ie9 loading-site no-js\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8 ]> <html lang=\"vi\" class=\"ie8 loading-site no-js\"> <![endif]-->\r\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!--><html lang=\"vi\" class=\"loading-site no-js\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script>(function (html) {\r\n");
      out.write("                html.className = html.className.replace(/\\bno-js\\b/, 'js')\r\n");
      out.write("            })(document.documentElement);</script>\r\n");
      out.write("        <title>BMAZON</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/1.css\">\r\n");
      out.write("        <link rel='stylesheet' id='contact-form-7-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.9.1' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='menu-image-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/menu-image/menu-image.css?ver=1.1' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/css/front.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='chosen-drop-down-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/chosen/chosen.min.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof_by_text_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/by_text/css/by_text.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof_color_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/color/css/html_types/color.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof_label_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/label/css/html_types/label.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof_select_hierarchy_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_hierarchy/css/html_types/select_hierarchy.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='woof_select_radio_check_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_radio_check/css/html_types/select_radio_check.css?ver=4.8.14' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='flatsome-icons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/fl-icons.css?ver=3.3' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='easy-social-share-buttons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/assets/css/default-retina/easy-social-share-buttons.css?ver=3.7.3' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='essb-cct-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/lib/modules/click-to-tweet/assets/css/styles.css?ver=3.7.3' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='flatsome-main-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome.css?ver=3.4.0' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='flatsome-shop-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome-shop.css?ver=3.4.0' type='text/css' media='all' />\r\n");
      out.write("        <link rel='stylesheet' id='flatsome-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome-child/style.css?ver=3.4.0' type='text/css' media='all' />\r\n");
      out.write("        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>\r\n");
      out.write("        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>\r\n");
      out.write("        <link rel='https://api.w.org/' href='http://mauweb.monamedia.net/lazada/wp-json/' />\r\n");
      out.write("        <link rel='stylesheet' href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/home.css\"  type='text/css'>\r\n");
      out.write("        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel=\"stylesheet\" type=\"text/css\" href=\"http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css\"><script src=\"//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js\"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src=\"http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js\"></script><![endif]--> \r\n");
      out.write("        <script src=\"js/1.js\"></script>\r\n");
      out.write("        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>\r\n");
      out.write("        <link rel='stylesheet' href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/2.css\"  type='text/css'>\r\n");
      out.write("        <link rel='stylesheet' href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/3.css\"  type='text/css'> \r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js.home.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow\" >\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <header id=\"header\" class=\"header has-sticky sticky-jump\">\r\n");
      out.write("                <div class=\"header-wrapper\">\r\n");
      out.write("                    <div id=\"top-bar\" class=\"header-top hide-for-sticky nav-dark\" >\r\n");
      out.write("                        <div class=\"flex-row container\" >\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-left\">\r\n");
      out.write("                                <ul class=\"nav nav-left medium-nav-center nav-small  nav-\">\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div><!-- flex-col left -->\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-center\">\r\n");
      out.write("                                <ul class=\"nav nav-center nav-small  nav-\">\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div><!-- center -->\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-right\">\r\n");
      out.write("                                <ul class=\"nav top-bar-nav nav-right nav-small  nav-\">\r\n");
      out.write("                                    <li class=\"html custom html_topbar_right\"><p class=\"topbarlink\"><a href=\"\" style=\"color:#37cfdd\">Be one of us</a></p></li>\r\n");
      out.write("                                    <li class=\"html custom html_top_right_text\"><p class=\"topbarlink\"><a href=\"#\">Customer Service</a></p></li>\r\n");
      out.write("                                    <li class=\"html custom html_nav_position_text_top\"><p class=\"topbarlink\"><a href=\"#\">Check Order</a></p></li>\r\n");
      out.write("                                        ");
User x = (User) request.getSession().getAttribute("currUser");
      out.write("\r\n");
      out.write("                                        ");
if (x == null) {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <li class=\"account-item has-icon \">\r\n");
      out.write("\r\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/loginAndSecurity/login.jsp\"class=\"nav-top-link nav-top-not-logged-in \">\r\n");
      out.write("                                            <span>\r\n");
      out.write("                                                Login     / Register  </span>\r\n");
      out.write("                                        </a><!-- .account-login-link -->\r\n");
      out.write("\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    ");
} else {
      out.write("\r\n");
      out.write("                                    <li class=\" menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown\" style=\"cursor: pointer;\">\r\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserControllerMap?service=account\"><span> Hello ");
      out.print(x.getFullname());
      out.write("</span></a>\r\n");
      out.write("                                        <ul class='nav-dropdown nav-dropdown-simple'>\r\n");
      out.write("                                            ");
if (x.getSystemRole() == 1) {
      out.write("\r\n");
      out.write("                                            <li  ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AdminControllerMap\" class=\"menu-image-title-after\"><span >Admin Dashboard</span></a></li>\r\n");
      out.write("                                                ");
}
      out.write("\r\n");
      out.write("                                            <li  ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserControllerMap?service=account\" class=\"menu-image-title-after\"><span >Account</span></a></li>\r\n");
      out.write("                                            <li  ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserControllerMap?service=info\" class=\"menu-image-title-after\"><span >User profile</span></a></li>\r\n");
      out.write("                                            <li  ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserControllerMap?service=changepass\" class=\"menu-image-title-after\"><span >Change Password</span></a></li>\r\n");
      out.write("                                            <li  ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserControllerMap?service=logout\" class=\"menu-image-title-after\"><span >Logout</span></a></li>\r\n");
      out.write("\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div><!-- .flex-col right -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div><!-- .flex-row -->\r\n");
      out.write("                    </div><!-- #header-top -->\r\n");
      out.write("                    <div id=\"masthead\" class=\"header-main nav-dark\" style=\"background-color: black\">\r\n");
      out.write("                        <div class=\"header-inner flex-row container logo-left medium-logo-center\" role=\"navigation\">\r\n");
      out.write("\r\n");
      out.write("                            <!-- Logo -->\r\n");
      out.write("                            <div id=\"logo\" class=\"flex-col logo\">\r\n");
      out.write("                                <!-- Header logo -->\r\n");
      out.write("                                <a href=\"index.jsp\" title=\"BMAZON\" rel=\"home\">\r\n");
      out.write("\r\n");
      out.write("                                    <img  width=\"124\" height=\"75\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/fpt.png\" class=\"header-logo-dark\" /></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!-- Mobile Left Elements -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <!-- Left Elements -->\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-left\r\n");
      out.write("                                 flex-grow\" >\r\n");
      out.write("                                <ul class=\"header-nav header-nav-main nav nav-left  nav-uppercase\" >\r\n");
      out.write("                                    <li class=\"header-search-form search-form html relative has-icon\">\r\n");
      out.write("                                        <div class=\"header-search-form-wrapper\">\r\n");
      out.write("                                            <div class=\"searchform-wrapper ux-search-box relative form- is-normal\">\r\n");
      out.write("                                                <form method=\"POST\" class=\"searchform\" action=\"HomePageControllerMap?service=search\" role=\"search\">\r\n");
      out.write("                                                    <div class=\"flex-row relative\">\r\n");
      out.write("                                                        <div class=\"flex-col flex-grow\">\r\n");
      out.write("                                                            <input type=\"search\" class=\"search-field mb-0\" name=\"search\" value=\"\" placeholder=\"Find Product\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                        </div><!-- .flex-col -->\r\n");
      out.write("                                                        <div class=\"flex-col\">\r\n");
      out.write("                                                            <button type=\"submit\" class=\"ux-search-submit submit-button secondary button icon mb-0\">\r\n");
      out.write("                                                                <i class=\"fa fa-search\" ></i>\t\t\t\t</button>\r\n");
      out.write("                                                        </div><!-- .flex-col -->\r\n");
      out.write("                                                    </div><!-- .flex-row -->\r\n");
      out.write("                                                    <div class=\"live-search-results text-left z-top\"></div>\r\n");
      out.write("                                                </form>\r\n");
      out.write("                                            </div>\t</div>\r\n");
      out.write("                                    </li><li>\r\n");
      out.write("                                        <i>   <img src=\"images/car.png\" style=\"height: 10px; width: 10px\"></i>\r\n");
      out.write("\r\n");
      out.write("                                        <a href=\"\" title=\"Cart\" class=\"header-cart-link is-small\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <i class=\"fa fa-shopping-cart\"\r\n");
      out.write("                                               data-icon-label=\"0\">\r\n");
      out.write("                                            </i>\r\n");
      out.write("                                        </a>\r\n");
      out.write("\r\n");
      out.write("                                        <ul class=\"nav-dropdown nav-dropdown-simple\">\r\n");
      out.write("                                            <li class=\"html widget_shopping_cart\">\r\n");
      out.write("                                                <div class=\"widget_shopping_cart_content\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                    <p class=\"woocommerce-mini-cart__empty-message\">The cart is empty</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </li>\r\n");
      out.write("                                        </ul><!-- .nav-dropdown -->\r\n");
      out.write("\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!-- Right Elements -->\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-right\" style=\"background:black \">\r\n");
      out.write("                                <ul class=\"header-nav header-nav-main nav nav-right  nav-uppercase\">\r\n");
      out.write("                                    <li class=\"html custom html_nav_position_text\"><img class=\"header_promotion\" \r\n");
      out.write("                                                                                        src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/images/FPT.jpg\" alt=\"promotion\" style=\"height: 40px;width: 170px;\"></li>            </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!-- Mobile Right Elements -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div><!-- .header-inner -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Header divider -->\r\n");
      out.write("                        <div class=\"container\"><div class=\"top-divider full-width\"></div></div>\r\n");
      out.write("                    </div> <div id=\"wide-nav\" class=\"header-bottom wide-nav nav-dark flex-has-center hide-for-medium\" style=\"background-color: black\">\r\n");
      out.write("                        <div class=\"flex-row container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"flex-col hide-for-medium flex-center\">\r\n");
      out.write("\r\n");
      out.write("                                <ul class=\"nav header-nav header-bottom-nav nav-center  nav-line-bottom nav-spacing-xsmall nav-uppercase\">\r\n");
      out.write("                                    ");
 for (Category c : cateList) {
      out.write("\r\n");
      out.write("                                    <li  class=\"menu-item menu-item-type-taxonomy menu-item-object-product_cat menu-item-has-children has-dropdown\" style=\" margin-left: 70px\">\r\n");
      out.write("                                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/HomePageControllerMap?service=ByCate&cid=");
      out.print(c.getCategoryID());
      out.write("\" class=\"menu-image-title-after nav-top-link\">\r\n");
      out.write("                                            <span class=\"menu-image-title\">");
      out.print(c.getCategoryName());
      out.write("</span></a>\r\n");
      out.write("\r\n");
      out.write("                                        <ul class='nav-dropdown nav-dropdown-simple'>\r\n");
      out.write("                                            ");
 for (Genre g : gerneList) {
                                                    if (g.getCategoryID() == c.getCategoryID()) {

                                            
      out.write("\r\n");
      out.write("                                            <li class=\"menu-item menu-item-type-taxonomy menu-item-object-product_cat  \">\r\n");
      out.write("                                                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/HomePageControllerMap?service=ByGenre&gid=");
      out.print(g.getGenreID());
      out.write("\" class=\"menu-image-title-after\">\r\n");
      out.write("                                                    <span class=\"menu-image-title\">");
      out.print(g.getGenreName());
      out.write("</span></a></li>\r\n");
      out.write("                                                    ");
 } 
      out.write("\r\n");
      out.write("                                                    ");
 } 
      out.write("\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    ");
 }
      out.write("\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div><!-- flex-col -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div><!-- .flex-row -->\r\n");
      out.write("                    </div><!-- .header-bottom -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"header-bg-container fill\"><div class=\"header-bg-image fill\"></div><div class=\"header-bg-color fill\"></div></div><!-- .header-bg-container -->   </div><!-- header-wrapper-->\r\n");
      out.write("            </header>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("contextPath");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
