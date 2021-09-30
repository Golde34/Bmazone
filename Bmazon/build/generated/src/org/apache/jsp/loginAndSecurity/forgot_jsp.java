package org.apache.jsp.loginAndSecurity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forgot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Change Password</title>\r\n");
      out.write("        <link href=\"../css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/login.css\"type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            Object mess = request.getAttribute("mess");
            if (mess == null) {
                mess = "";
            }
        
      out.write("\r\n");
      out.write("        <!--<div class=\"container\">\r\n");
      out.write("            <form action=\"/Bmazon/UserControllerMap\" method=\"POST\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-5\">\r\n");
      out.write("                        <h2 class=\"text-center\">Change Password</h2>\r\n");
      out.write("\r\n");
      out.write("                        <label class=\"label control-label\">Name</label>\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"username\" \r\n");
      out.write("                                   placeholder=\"Your Name\" >\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <label class=\"label control-label\">Enter mail</label>\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-envelope\"></span></span>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"mail\" name=\"mail\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <label class=\"label control-label\">Enter phone</label>\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"phone\" name=\"phone\" required>                   \r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <label class=\"label control-label\">Confirm New Password</label>\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\">\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input id=\"confirm_password\" type=\"Password\" class=\"form-control\" name=\"confirm-password\" \r\n");
      out.write("                                   placeholder=\"Confirm your new password\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <button class=\"btn btn-default\" type=\"submit\">Change Password</button>\r\n");
      out.write("                            <button class=\"btn btn-default\" type=\"reset\">RESET</button>\r\n");
      out.write("                            <input type=\"hidden\" name=\"service\" value=\"forgotPass\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <label class=\"text-danger\" style=\"color: red;\">");
      out.print( mess.toString());
      out.write("</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>-->   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"login-wrap\">\r\n");
      out.write("            <div class=\"login-html\">\r\n");
      out.write("                <h2 style=\"color: yellow\" > Change PassWord</h2>\r\n");
      out.write("                <div class=\"login-form\">\r\n");
      out.write("                    <div class=\"sign-up-html\">\r\n");
      out.write("                        <form action=\"/Bmazon/UserControllerMap\" method=\"post\">\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"user\" class=\"label\">Username</label>\r\n");
      out.write("                                <input id=\"user\" type=\"text\" name=\"username\"  class=\"input\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Enter Email</label>\r\n");
      out.write("                                <input id=\"oldpass\" type=\"password\" name=\"oldpass\" class=\"input\" placeholder=\"Password\" data-type=\"password\" required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Enter Phone</label>\r\n");
      out.write("                                <input id=\"newpass\" oninput=\"checkDup(this)\" type=\"password\" name=\"newpass\" class=\"input\" placeholder=\"New password\" data-type=\"password\"required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <label for=\"pass\" class=\"label\">Confirm New Password</label>\r\n");
      out.write("                                <input id=\"repass\" oninput=\"check(this)\" type=\"password\" name=\"renewpass\" class=\"input\" placeholder=\"Re-New password\" data-type=\"password\"required autofocus=\"\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <h6 style=\"color: yellow\" style=\"font-size: small\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h6>\r\n");
      out.write("                            <div class=\"group\">\r\n");
      out.write("                                <input type=\"submit\" class=\"button\" value=\"Submit\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"service\" value=\"changepass\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <a style=\"color: yellow\" href=\"index.jsp\" id=\"cancel_signup\" ><i class=\"fas fa-angle-left\"></i> Back to homepage</a>\r\n");
      out.write("                        <div class=\"hr\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
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
