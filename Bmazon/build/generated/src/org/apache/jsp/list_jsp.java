package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Collections;
import java.util.Collection;
import java.util.List;
import entity.Gallery;
import entity.User;
import model.DBConnection;
import model.GalleryDAO;
import entity.Product;
import model.ProductDAO;
import java.util.ArrayList;
import model.CategoryDAO;
import entity.Category;
import entity.Genre;
import model.GenreDAO;
import model.ProductTypeDAO;
import entity.ProductType;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 DecimalFormat nf = new DecimalFormat("###,###,###");
      out.write('\n');

    List<Product> ListSuggest = (List<Product>) request.getAttribute("listP");
    CategoryDAO daoCate = new CategoryDAO();
    GenreDAO genDAO = new GenreDAO();
    ProductDAO proDAO = new ProductDAO();
    GalleryDAO gallDAO = new GalleryDAO();
    ProductTypeDAO ptDAO = new ProductTypeDAO();



      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if IE 9 ]> <html lang=\"vi\" class=\"ie9 loading-site no-js\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]> <html lang=\"vi\" class=\"ie8 loading-site no-js\"> <![endif]-->\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!--><html lang=\"vi\" class=\"loading-site no-js\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script>(function (html) {\n");
      out.write("                html.className = html.className.replace(/\\bno-js\\b/, 'js')\n");
      out.write("            })(document.documentElement);</script>\n");
      out.write("        <title>BMAZON</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/1.css\">\n");
      out.write("        <link rel='stylesheet' id='contact-form-7-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.9.1' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='menu-image-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/menu-image/menu-image.css?ver=1.1' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/css/front.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='chosen-drop-down-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/js/chosen/chosen.min.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof_by_text_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/by_text/css/by_text.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof_color_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/color/css/html_types/color.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof_label_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/label/css/html_types/label.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof_select_hierarchy_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_hierarchy/css/html_types/select_hierarchy.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='woof_select_radio_check_html_items-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/woocommerce-products-filter/ext/select_radio_check/css/html_types/select_radio_check.css?ver=4.8.14' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='flatsome-icons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/fl-icons.css?ver=3.3' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='easy-social-share-buttons-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/assets/css/default-retina/easy-social-share-buttons.css?ver=3.7.3' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='essb-cct-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/plugins/easy-social-share-buttons3/lib/modules/click-to-tweet/assets/css/styles.css?ver=3.7.3' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='flatsome-main-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome.css?ver=3.4.0' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='flatsome-shop-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/flatsome-shop.css?ver=3.4.0' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' id='flatsome-style-css'  href='http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome-child/style.css?ver=3.4.0' type='text/css' media='all' />\n");
      out.write("        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>\n");
      out.write("        <script type='text/javascript' src='http://mauweb.monamedia.net/lazada/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>\n");
      out.write("        <link rel='https://api.w.org/' href='http://mauweb.monamedia.net/lazada/wp-json/' />\n");
      out.write("        <link rel='stylesheet' href=\"css/home.css\"  type='text/css'>\n");
      out.write("        <style>.bg{opacity: 0; transition: opacity 1s; -webkit-transition: opacity 1s;} .bg-loaded{opacity: 1;}</style><!--[if IE]><link rel=\"stylesheet\" type=\"text/css\" href=\"http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/css/ie-fallback.css\"><script src=\"//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js\"></script><script>var head = document.getElementsByTagName('head')[0],style = document.createElement('style');style.type = 'text/css';style.styleSheet.cssText = ':before,:after{content:none !important';head.appendChild(style);setTimeout(function(){head.removeChild(style);}, 0);</script><script src=\"http://mauweb.monamedia.net/lazada/wp-content/themes/flatsome/assets/libs/ie-flexibility.js\"></script><![endif]--> \n");
      out.write("        <script src=\"js/1.js\"></script>\n");
      out.write("        <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>\n");
      out.write("        <link rel='stylesheet' href=\"css/2.css\"  type='text/css'>\n");
      out.write("        <link rel='stylesheet' href=\"css/3.css\"  type='text/css'> \n");
      out.write("        <link rel='stylesheet' href=\"css/slide.css\"  type='text/css'> \n");
      out.write("\n");
      out.write("        <script src=\"js/2.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js.home.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"home page-template page-template-page-blank page-template-page-blank-php page page-id-16 page-parent lightbox nav-dropdown-has-arrow\" >\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <main id=\"main\" class=\"\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col large-12\">\n");
      out.write("                    <div class=\"shop-container\">\n");
      out.write("                        <div class=\"products row row-small large-columns-5 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1\">\n");
      out.write("                            ");
 for (Product pa : ListSuggest) {
                                    String str3 = "images/" + gallDAO.getSampleOfProduct(pa.getProductID());
                                    String price = ptDAO.getProductPrice(pa.getProductID());

                            
      out.write("\n");
      out.write("                            <div class=\"product-small col has-hover post-1178 product type-product status-publish has-post-thumbnail product_cat-bach-hoa-online product_cat-do-hop-dong-goi first instock shipping-taxable purchasable product-type-simple\">\n");
      out.write("                                <div class=\"col-inner\">\n");
      out.write("\n");
      out.write("                                    <div class=\"badge-container absolute left top z-1\">\n");
      out.write("                                        <div class=\"callout badge badge-square\"><div class=\"badge-inner secondary on-sale\"><span class=\"onsale\">-50%</span></div></div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product-small box has-hover box-normal box-text-bottom\">\n");
      out.write("                                        <div class=\"box-image\" style=\"width:150px; height:150px \">\n");
      out.write("                                            <div class=\"\" >\n");
      out.write("                                                <a href=\"ProductDetailControllerMap?service=getProductDetail&pid=");
      out.print(pa.getProductID());
      out.write("\">\n");
      out.write("\n");
      out.write("                                                    <img src=\"");
      out.print(str3);
      out.write("\"></a>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"image-tools z-top top right show-on-hover\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"image-tools grid-tools text-center hide-for-small bottom hover-slide-in show-on-hover\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div><!-- box-image -->\n");
      out.write("\n");
      out.write("                                        <div class=\"box-text text-center\" style=\"background-color:rgb(255, 255, 255);\">\n");
      out.write("                                            <div class=\"title-wrapper\" >\t\t\n");
      out.write("                                                <p class=\"category uppercase is-smaller no-text-overflow product-cat op-7\">   </p> ");
      out.write("\n");
      out.write("                                                <p class=\"name product-title\"><a href=\"ProductDetailControllerMap?service=getProductDetail&pid=");
      out.print(pa.getProductID());
      out.write("\"> ");
      out.print(pa.getProductName());
      out.write(" </a></p>\n");
      out.write("                                            </div> \n");
      out.write("                                            <div class=\"price-wrapper\" \n");
      out.write("                                                 <span class=\"price\"><del><span class=\"woocommerce-Price-amount amount\">290,000&nbsp;<span class=\"woocommerce-Price-currencySymbol\">&#8363;</span></span></del> \n");
      out.write("                                                    <ins><span class=\"woocommerce-Price-amount amount\"> ");
      out.print(price);
      out.write(" <span class=\"woocommerce-Price-currencySymbol\">&#8363;</span></span></ins></span>\n");
      out.write("                                            </div>\t\n");
      out.write("                                        </div><!-- box-text -->\n");
      out.write("                                    </div><!-- box -->\n");
      out.write("                                </div><!-- .col-inner -->\n");
      out.write("                            </div><!-- col -->\n");
      out.write("                            ");
    }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                          <div class=\"container\">\n");
      out.write("                                <nav class=\"woocommerce-pagination\">\n");
      out.write("                                    <ul class=\"page-numbers nav-pagination links text-center\">\n");
      out.write("                                        <li><span class='page-number current'>1</span></li>\n");
      out.write("                                        <li><a class='page-number' href='http://mauweb.monamedia.net/lazada/page/2/?s=i&#038;post_type=product'>2</a></li>\n");
      out.write("                                        <li><a class=\"next page-number\" href=\"http://mauweb.monamedia.net/lazada/page/2/?s=i&#038;post_type=product\"><i class=\"icon-angle-right\"></i></a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </main><!-- #main -->\n");
      out.write("        </div>\n");
      out.write("        =\n");
      out.write("\n");
      out.write("\n");
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
