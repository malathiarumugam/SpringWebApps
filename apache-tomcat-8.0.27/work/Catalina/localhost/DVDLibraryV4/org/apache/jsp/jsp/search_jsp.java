/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.27
 * Generated at: 2015-10-30 14:20:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/DVDLibraryV4/target/spring-mvc-webapp/WEB-INF/lib/spring-webmvc-4.0.3.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1395886044000L));
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/DVDLibraryV4/target/spring-mvc-webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/DVDLibraryV4/target/spring-mvc-webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1444940840000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.0.3.RELEASE.jar", Long.valueOf(1444940838000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Boostrap core CSS -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- SWC Icon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/icon.png\"> \n");
      out.write("        <title>DVD Library</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Search for a DVD</h1>\n");
      out.write("            <hr/>\n");
      out.write("            <div class=\"navbar\">\n");
      out.write("                <ul class=\"nav nav-tabs\">   \n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/home\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Add\">Add</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\" class=\"active\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/search\">Search</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/mainAjaxPage\">Contact List\n");
      out.write("                            (Ajax)</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">  \n");
      out.write("                <div class=\"col-md-offset-1 col-md-10\">\n");
      out.write("                    <h3>Search by title</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-10\">\n");
      out.write("                    <hr>\n");
      out.write("                    <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-title\" class=\"col-md-2 control-label\">\n");
      out.write("                                Title:\n");
      out.write("                            </label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-title\"\n");
      out.write("                                       placeholder=\"A catchy title\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-release\" class=\"col-md-2 control-label\">\n");
      out.write("                                Release Date:\n");
      out.write("                            </label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-release\"\n");
      out.write("                                       placeholder=\"When did this thing come out?\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-rating\" class=\"col-md-2 control-label\">\n");
      out.write("                                MPAA Rating:\n");
      out.write("                            </label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-rating\"\n");
      out.write("                                       placeholder=\"PG-13, R where we at?\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-director\" class=\"col-md-2 control-label\">Director:</label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-director\"\n");
      out.write("                                       placeholder=\"Who directed this?\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-studio\" class=\"col-md-2 control-label\">Studio:</label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-studio\"\n");
      out.write("                                       placeholder=\"Who made this?\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"add-note\" class=\"col-md-2 control-label\">Notes:</label>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <input type=\"text\"\n");
      out.write("                                       class=\"form-control\"\n");
      out.write("                                       id=\"search-note\"\n");
      out.write("                                       placeholder=\"Any notes?\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"col-md-offset-2 col-md-8\">\n");
      out.write("                                <button type=\"submit\"\n");
      out.write("                                        id=\"search-button\"\n");
      out.write("                                        class=\"btn btn-default\">\n");
      out.write("                                    Search Library\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <h2>Search Results</h2>\n");
      out.write("                    <table id=\"total1\" class=\"table table-hover\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Number of movies found</th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tbody id=\"searchRows\"></tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <table id=\"DVD-id\" class=\"table table-hover\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th width=\"30%\">Title</th>\n");
      out.write("                            <th width=\"10%\">Release Date</th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tbody id=\"contentRows\"></tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"detailsModal\" tabindex=\"-1\" role=\"dialog\"\n");
      out.write("             aria-labelledby=\"detailsModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            <span class=\"sr-only\">Close</span>\n");
      out.write("                        </button>\n");
      out.write("                        <h4 class=\"modal-title\" id=\"detailsModalLabel\">The chosen one.</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <h3 id=\"dvd-id\"></h3>\n");
      out.write("                        <table id=\"movieTable\" class=\"table table-hover\">\n");
      out.write("                            <tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Title:</th>\n");
      out.write("                                <td id=\"add-title\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Release Date:</th>\n");
      out.write("                                <td id=\"add-release\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>MPAA Rating:</th>\n");
      out.write("                                <td id=\"add-rating\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Director:</th>\n");
      out.write("                                <td id=\"add-director\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Studio:</th>\n");
      out.write("                                <td id=\"add-studio\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Note:</th>\n");
      out.write("                                <td id=\"add-note\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("        <div class=\"modal fade\" id=\"editModal\" tabindex=\"-1\" role=\"dialog\"\n");
      out.write("             aria-labelledby=\"detailsModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            <span class=\"sr-only\">Close</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" id=\"detailsModalLabel\">Edit Entry</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <h3 id=\"dvd-id\"></h3>\n");
      out.write("                        <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-title\" class=\"col-md-4 control-label\">\n");
      out.write("                                    Title:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-title\" placeholder=\"Blank Title\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-release\" class=\"col-md-4 control-label\">\n");
      out.write("                                    Release Date:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-release\" placeholder=\"When did it come out?\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-rating\" class=\"col-md-4 control-label\">\n");
      out.write("                                    MPAA Rating:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-rating\" placeholder=\"Rated R?\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-director\" class=\"col-md-4 control-label\">\n");
      out.write("                                    Director:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-director\" placeholder=\"Who was the Director?\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-studio\" class=\"col-md-4 control-label\">\n");
      out.write("                                    Studio:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-studio\" placeholder=\"Who paid a bunch to make it?\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>    \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edit-note\" class=\"col-md-4 control-label\">\n");
      out.write("                                    Note:\n");
      out.write("                                </label>\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"edit-note\" placeholder=\"Any notes?\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>    \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"col-md-offset-4 col-md-8\">\n");
      out.write("                                    <button type=\"submit\" id=\"edit-button\" class=\"btn btn-default\" data-dismiss=\"modal\">\n");
      out.write("                                        Edit Movie\n");
      out.write("                                    </button>\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">\n");
      out.write("                                        Cancel\n");
      out.write("                                    </button>\n");
      out.write("                                    <input type=\"hidden\" id=\"edit-DVD-id\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>   \n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>      \n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/dvdlibrary.js\"></script>  \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
