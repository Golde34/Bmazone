package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import entity.*;

public final class usermanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    User curUser = (User) request.getSession().getAttribute("currUser");
    ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Admin Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css\">\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/admin.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/usermanagement.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <input type=\"checkbox\" id=\"nav-toggle\">\r\n");
      out.write("        <div class=\"sidebar\">\r\n");
      out.write("            <div class=\"sidebar-brand\">\r\n");
      out.write("                <h1><span class=\"lab la-amazon\"></span><span>Bmazon</span></h1>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"sidebar-menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"AdminControllerMap\"><span class=\"las la-igloo\"></span>\r\n");
      out.write("                            <span>Dashboard</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"AdminControllerMap?service=usermanagement\" class=\"active\">\r\n");
      out.write("                            <span class=\"las la-igloo\"></span>\r\n");
      out.write("                            <span>User Management</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\"><span class=\"las la-igloo\"></span>\r\n");
      out.write("                            <span>Dashboard</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"\"><span class=\"las la-igloo\"></span>\r\n");
      out.write("                            <span>Dashboard</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_header.jsp", out, false);
      out.write("\r\n");
      out.write("                <main>\r\n");
      out.write("                    <div class=\"recent-grids\">\r\n");
      out.write("                        <div class=\"customers\">\r\n");
      out.write("                            <div class=\"card\">\r\n");
      out.write("                                <div class=\"card-header\">\r\n");
      out.write("                                    <h3>User</h3>\r\n");
      out.write("                                    <a href=\"AdminControllerMap?service=adddetail\">\r\n");
      out.write("                                        <button>Add new user</button></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <table width=\"100%\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td>User name</td>\r\n");
      out.write("                                                <td>Password</td>\r\n");
      out.write("                                                <td>Email</td>\r\n");
      out.write("                                                <td>Phone</td>\r\n");
      out.write("                                                <td>Address</td>\r\n");
      out.write("                                                <td></td>\r\n");
      out.write("                                                <td></td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                        ");
for (User user : listUser) {
      out.write("\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(user.getUsername());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(user.getPassword());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(user.getEmail());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(user.getPhoneNumber());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(user.getAddress());
      out.write("</td>\r\n");
      out.write("                                            <td>\r\n");
      out.write("                                                <a href=\"AdminControllerMap?service=updatedetail&userid=");
      out.print(user.getUserId());
      out.write("\"><span class=\"las la-edit\"></span></a>\r\n");
      out.write("                                            </td>\r\n");
      out.write("                                            <td><a href=\"AdminControllerMap?service=deleteuser&userid=");
      out.print(user.getUserId());
      out.write("\" onclick=\"return confirm('Are you sure you want to Remove?');\"><span class=\"las la-trash\"></span></a></td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");
}
      out.write("\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </main>\r\n");
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
}
