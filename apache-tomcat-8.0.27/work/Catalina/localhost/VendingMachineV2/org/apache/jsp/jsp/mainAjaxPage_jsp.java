/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.27
 * Generated at: 2015-10-30 15:36:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainAjaxPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/VendingMachineV2/target/spring-mvc-webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/VendingMachineV2/target/spring-mvc-webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153403082000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1444940840000L));
    _jspx_dependants.put("jar:file:/home/apprentice/FlooringMastery/VendingMachineV2/target/spring-mvc-webapp/WEB-INF/lib/spring-webmvc-4.0.3.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1395886044000L));
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Vending Machine</title>\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <!--<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/starter-template.css\" rel=\"stylesheet\">-->\n");
      out.write("\n");
      out.write("        <!-- SWC Icon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/icon.png\">\n");
      out.write("        <style>\n");
      out.write("            #items {\n");
      out.write("                background-color: #b4b4b4;\n");
      out.write("            }\n");
      out.write("            img {\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            #inputMoney {\n");
      out.write("                padding: 0px 15px 0px 15px;\n");
      out.write("            }\n");
      out.write("            #inputCode {\n");
      out.write("                padding: 20px 15px 0px 15px;\n");
      out.write("            }\n");
      out.write("            #vendButton {\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("            }\n");
      out.write("            .container {\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!--            <h1>Vending Machine</h1>\n");
      out.write("                        <hr/>-->\n");
      out.write("            <div class=\"navbar\">\n");
      out.write("                <ul class=\"nav nav-tabs\">   \n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/home\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\" class=\"active\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/mainAjaxPage\">VendingMachine</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/create\">Create</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li role=\"presentation\">\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/j_spring_security_logout\">Log\n");
      out.write("                            Out</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-offset-2 col-md-6\">\n");
      out.write("                    <img src=\"img/pepsi2.jpg\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\" id=\"items\">\n");
      out.write("                    <h3>Item List</h3>\n");
      out.write("                    <table id=\"vending-id\" class=\"table table-hover\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th width=\"50%\">Item Name</th>\n");
      out.write("                            <th width=\"20%\">Quantity</th>\n");
      out.write("                            <th width=\"20%\">Price</th>\n");
      out.write("                            <th width=\"10%\">Code</th>\n");
      out.write("                        </tr>\n");
      out.write("                        <tbody id=\"contentRows\"></tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                        <div class=\"form-group\" id=\"inputCode\">\n");
      out.write("                            <select id=\"vend-code\">\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <!--                            <input type=\"text\"\n");
      out.write("                                                               class=\"form-control\"\n");
      out.write("                                                               id=\"vend-code\"\n");
      out.write("                                                               placeholder=\"Item Code\"/>-->\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\" id=\"inputMoney\">\n");
      out.write("                            <input type=\"text\"\n");
      out.write("                                   class=\"form-control\"\n");
      out.write("                                   id=\"vend-money\"\n");
      out.write("                                   placeholder=\"Enter money amount here\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" id=\"vendButton\">\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <button type=\"submit\"\n");
      out.write("                                        id=\"vend-button\"\n");
      out.write("                                        class=\"btn btn-default\">\n");
      out.write("                                    Vend\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <table id=\"money-id\" class=\"table table-hover\">\n");
      out.write("                            <tbody id=\"moneyRows\"></tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                    <form>\n");
      out.write("                        <table id=\"money-id\" class=\"table table-hover\">\n");
      out.write("                            <tbody id=\"changeRows\"></tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <div class=\"form-group\" id=\"changeButton\">\n");
      out.write("                            <button type=\"submit\"\n");
      out.write("                                    id=\"change-button\"\n");
      out.write("                                    class=\"btn btn-default\">\n");
      out.write("                                Return Change\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\" col-md-offset-8 col-md-4\" id=\"inputs\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/vending.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
