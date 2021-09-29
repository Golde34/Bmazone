package org.apache.jsp.loginAndSecurity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login Page</title>\r\n");
      out.write("        <link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/login.css\"type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String mess = (String) request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
            Object checkLogin = request.getAttribute("checkLogin");
            Object checkRegis = request.getAttribute("checkRegis");
            if (checkLogin == null) {
                checkLogin = "checked";
            }
        
      out.write("\r\n");
      out.write("        <div class=\"login-wrap\">\r\n");
      out.write("            <div class=\"login-html\" >\r\n");
      out.write("                <input id=\"tab-1\" type=\"radio\" name=\"tab\" class=\"sign-in\" ");
      out.print( checkLogin );
      out.write(" ><label for=\"tab-1\" class=\"tab\">Sign In</label>\r\n");
      out.write("                <input id=\"tab-2\" type=\"radio\" name=\"tab\" class=\"sign-up\" ");
      out.print( checkRegis );
      out.write(" ><label for=\"tab-2\" class=\"tab\">Sign Up</label> \r\n");
      out.write("                <div class=\"login-form\">\r\n");
      out.write("                    <!--Sign in Service-->\r\n");
      out.write("                    <div class=\"sign-in-htm\">\r\n");
      out.write("                        <form action=\"/Bmazon/UserControllerMap\" method=\"POST\">\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"user\" class=\"label\" >Username</label>\r\n");
      out.write("                                <input id=\"user\" type=\"text\" name=\"username\" placeholder=\"Username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" required autofocus=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Password</label>\r\n");
      out.write("                                <input id=\"pass\" type=\"password\" name=\"password\" placeholder=\"Password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userPass}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" data-type=\"password\" required autofocus=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <h6 style=\"color: yellow\" style=\"font-size: small\" >");
      out.print( mess);
      out.write("</h6>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"service\" value=\"login\">\r\n");
      out.write("                                <input type=\"submit\" class=\"button\" value=\"Sign In\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <a style=\"color: yellow\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/loginAndSecurity/forgot.jsp\" >\r\n");
      out.write("                            <i class=\"fas fa-angle-left\"></i> Forgot Password\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class=\"hr\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--Sign up Service-->\r\n");
      out.write("                    <div class=\"sign-up-htm\">\r\n");
      out.write("                        <form action=\"/Bmazon/UserControllerMap\" method=\"get\">\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"user\" class=\"label\">Username</label>\r\n");
      out.write("                                <input id=\"user\" type=\"text\" name=\"signupusername\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Username\"  class=\"input\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Password</label>\r\n");
      out.write("                                <input id=\"password\" type=\"password\" name=\"signuppass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" placeholder=\"Password\" data-type=\"password\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Repeat Password</label>\r\n");
      out.write("                                <input id=\"repassword\" oninput=\"check(this)\" type=\"password\" name=\"resignuppass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Repassword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" placeholder=\"Repeat Password\" data-type=\"password\"required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Full Name</label>\r\n");
      out.write("                                <input id=\"name\" type=\"text\" name=\"fname\" class=\"input\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"NguyenVanA\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Email</label>\r\n");
      out.write("                                <input id=\"email\" type=\"text\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" placeholder=\"abc@xyz.com\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Phone</label>\r\n");
      out.write("                                <input id=\"phone\" type=\"text\" pattern=\"([\\+84|84|0]+(2|3|5|7|8|9)+([0-9]{8})\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input\" placeholder=\"0987654321\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <h6 style=\"color: yellow;\" style=\"font-size: small\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h6>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <input type=\"submit\" class=\"button\" value=\"Sign Up\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"service\" value=\"register\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <div class=\"hr\"></div>\r\n");
      out.write("                        <div class=\"foot-lnk\">\r\n");
      out.write("                            <label for=\"tab-1\">Already Member?</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("    <script language='javascript' type='text/javascript'>\r\n");
      out.write("    function check(input) {\r\n");
      out.write("        if (input.value != document.getElementById('password').value) {\r\n");
      out.write("            input.setCustomValidity('Password Must be Matching.');\r\n");
      out.write("        } else {\r\n");
      out.write("            // input is valid -- reset the error message\r\n");
      out.write("            input.setCustomValidity('');\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
