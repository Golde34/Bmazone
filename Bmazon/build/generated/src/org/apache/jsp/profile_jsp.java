package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.UserDAO;
import model.DBConnection;
import entity.User;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Your public Profile</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <!--Body resources-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js\">\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("        <style>\r\n");
      out.write("            .profile-head {\r\n");
      out.write("                transform: translateY(5rem)\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .cover {\r\n");
      out.write("                background-image: url(https://images.unsplash.com/photo-1530305408560-82d13781b33a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80);\r\n");
      out.write("                background-size: cover;\r\n");
      out.write("                background-repeat: no-repeat;\r\n");
      out.write("                height: 230px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            body {\r\n");
      out.write("                background: #654ea3;\r\n");
      out.write("                background: linear-gradient(to right, #e96443, #904e95);\r\n");
      out.write("                min-height: 100vh;\r\n");
      out.write("                overflow-x: hidden\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        ");

            User x = (User) request.getSession().getAttribute("currUser");

            DBConnection dbCon = new DBConnection();
            UserDAO daoUser = new UserDAO();
//            DAOGalery daoGalery = new DAOGalery(dbCon);

        
      out.write("\r\n");
      out.write("        <div class=\"row py-5 px-4\">\r\n");
      out.write("            <div class=\"col-md-10 mx-auto\">\r\n");
      out.write("                <!-- Profile widget -->\r\n");
      out.write("                <div class=\"bg-white shadow rounded overflow-hidden\">\r\n");
      out.write("                    <div class=\"px-4 pt-0 pb-4 cover\">\r\n");
      out.write("                        <!--                        <div class=\"a-row desktop cover-photo-edit-icon\">\r\n");
      out.write("                                                    <img alt=\"\" src=\"//d1k8kvpjaf8geh.cloudfront.net/gp/profile/assets/camera-desktop-4aba2c5ff428bad7bee93a2e61a2ad5128cbdd58b770618a1fd108abca1e2f31.png\">\r\n");
      out.write("                                                    <span class=\"a-declarative\" data-action=\"a-popover\" data-a-popover=\"{&quot;name&quot;:&quot;cover-photo-edit-image-popover&quot;,&quot;dataStrategy&quot;:&quot;preload&quot;,&quot;position&quot;:&quot;triggerBottom&quot;,&quot;activate&quot;:&quot;onclick&quot;,&quot;closeButton&quot;:&quot;false&quot;,&quot;closeButtonLabel&quot;:&quot;cover-photo-upload-popover-close&quot;}\">\r\n");
      out.write("                                                        <div id=\"cover-photo-edit-popover-trigger\" class=\"a-section edit-popover-trigger\">\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </span>\r\n");
      out.write("                                                </div>-->\r\n");
      out.write("                        <div class=\"media align-items-end profile-head\">\r\n");
      out.write("                            <div class=\"profile mr-3\"><img src=\"images/defaultPicture.jpg\"\r\n");
      out.write("                                                           alt=\"...\" width=\"200\" class=\"rounded mb-2 img-thumbnail\">\r\n");
      out.write("                                <a href=\"#\" class=\"btn btn-outline-dark btn-sm btn-block\">Edit profile</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"media-body mb-5 text-white\">\r\n");
      out.write("                                <h4 class=\"mt-0 mb-0\" style=\"color: white; font-size:30px;\">");
      out.print(x.getFullname());
      out.write("</h4>\r\n");
      out.write("                                <p class=\"small mb-4\"> <i class=\"fas fa-map-marker-alt mr-2\"></i>New York</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"bg-light p-4 d-flex justify-content-end text-center\">\r\n");
      out.write("                        <ul class=\"list-inline mb-0\">\r\n");
      out.write("                            <li class=\"list-inline-item\">\r\n");
      out.write("                                <h5 class=\"font-weight-bold mb-0 d-block\">215</h5><small class=\"text-muted\"> <i class=\"fas fa-image mr-1\"></i>Photos</small>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"list-inline-item\">\r\n");
      out.write("                                <h5 class=\"font-weight-bold mb-0 d-block\">745</h5><small class=\"text-muted\"> <i class=\"fas fa-user mr-1\"></i>Followers</small>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"list-inline-item\">\r\n");
      out.write("                                <h5 class=\"font-weight-bold mb-0 d-block\">340</h5><small class=\"text-muted\"> <i class=\"fas fa-user mr-1\"></i>Following</small>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"px-4 py-3 col-md-4\">\r\n");
      out.write("                            <ul> \r\n");
      out.write("                                <li >\r\n");
      out.write("                                    <h5 class=\"mb-0\"><strong>About</strong></h5>\r\n");
      out.write("                                    <div class=\"p-4 rounded shadow-sm bg-light\" style=\"background-color: #F5F7F5\">\r\n");
      out.write("                                        <p class=\"font-italic mb-0\">Web Developer</p>\r\n");
      out.write("                                        <p class=\"font-italic mb-0\">Lives in New York</p>\r\n");
      out.write("                                        <p class=\"font-italic mb-0\">Photographer</p>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"px-4 py-3 col-md-8\">\r\n");
      out.write("\r\n");
      out.write("                            <h5 class=\"mb-0\"><strong>Your list and your wishlist</strong></h5>\r\n");
      out.write("                            <div class=\"p-4 rounded shadow-sm bg-light\" style=\"background-color: #F5F7F5\">\r\n");
      out.write("                                <p class=\"font-italic mb-0\">Web Developer</p>\r\n");
      out.write("                                <p class=\"font-italic mb-0\">Lives in New York</p>\r\n");
      out.write("                                <p class=\"font-italic mb-0\">Photographer</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!--                            <h5 class=\"mb-0\"><strong>Insights</strong></h5>\r\n");
      out.write("                                                        <div class=\"p-4 rounded bg-light\" style=\"background-color: #F5F7F5\">\r\n");
      out.write("                                                            <p class=\"font-italic mb-0\">Web Developer</p>\r\n");
      out.write("                                                            <p class=\"font-italic mb-0\">Lives in New York</p>\r\n");
      out.write("                                                            <p class=\"font-italic mb-0\">Photographer</p>\r\n");
      out.write("                                                        </div>-->\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"py-4 px-4\">\r\n");
      out.write("                        <div class=\"d-flex align-items-center justify-content-between mb-3\">\r\n");
      out.write("                            <h5 class=\"mb-0\">Recent photos</h5><a href=\"#\" class=\"btn btn-link text-muted\">Show all</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-lg-6 mb-2 pr-lg-1\"><img src=\"https://images.unsplash.com/photo-1469594292607-7bd90f8d3ba4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80\" alt=\"\" class=\"img-fluid rounded shadow-sm\"></div>\r\n");
      out.write("                            <div class=\"col-lg-6 mb-2 pl-lg-1\"><img src=\"https://images.unsplash.com/photo-1493571716545-b559a19edd14?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80\" alt=\"\" class=\"img-fluid rounded shadow-sm\"></div>\r\n");
      out.write("                            <div class=\"col-lg-6 pr-lg-1 mb-2\"><img src=\"https://images.unsplash.com/photo-1453791052107-5c843da62d97?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80\" alt=\"\" class=\"img-fluid rounded shadow-sm\"></div>\r\n");
      out.write("                            <div class=\"col-lg-6 pl-lg-1\"><img src=\"https://images.unsplash.com/photo-1475724017904-b712052c192a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80\" alt=\"\" class=\"img-fluid rounded shadow-sm\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
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
