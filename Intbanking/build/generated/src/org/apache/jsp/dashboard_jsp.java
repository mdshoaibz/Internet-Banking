package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Dashboard</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"dashboard.css\" />\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f0f5ff; /* Light Blue */\n");
      out.write("            color: #1a1a1a; /* Dark Gray */\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color: #0056b3; /* Dark Blue */\n");
      out.write("            color: #ffffff; /* White */\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main-section {\n");
      out.write("            margin: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .customer-box {\n");
      out.write("            background-color: #ffffff; /* White */\n");
      out.write("            border: 1px solid #dcdcdc; /* Light Gray */\n");
      out.write("            padding: 15px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .footer {\n");
      out.write("            background-color: #0056b3; /* Dark Blue */\n");
      out.write("            color: #ffffff; /* White */\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: center;\n");
      out.write("            position: fixed;\n");
      out.write("            bottom: 0;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header class=\"header-section\">\n");
      out.write("        <!-- Add your header content here -->\n");
      out.write("        <nav class=\"nav-section\">\n");
      out.write("            <a href=\"#\" class=\"nav-link\">Home</a>\n");
      out.write("            <a href=\"#\" class=\"nav-link\">About Us</a>\n");
      out.write("            <a href=\"#\" class=\"nav-link\">Contact</a>\n");
      out.write("            <!-- Add more navigation links as needed -->\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("    \n");
      out.write("    <section>\n");
      out.write("        <h2>Customer Details</h2>\n");
      out.write("\n");
      out.write("        <c:forEach var=\"customer\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customers}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <div>\n");
      out.write("                <h2>ID: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                <p>Name: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <p>Email: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[2]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <p>Password: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[3]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <p>Mobile Number: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[4]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <p>Balance: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer[5]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <!-- Add more details as needed -->\n");
      out.write("\n");
      out.write("                <!-- Add your delete form here -->\n");
      out.write("            </div>\n");
      out.write("        </c:forEach>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section class=\"footer\">\n");
      out.write("        <!-- Add your footer content here -->\n");
      out.write("        <nav class=\"nav--footer\">\n");
      out.write("            <a href=\"#\" class=\"nav-link\">About Us</a>\n");
      out.write("            <a href=\"#\" class=\"nav-link\">Contact Us</a>\n");
      out.write("            <a href=\"#\" class=\"nav-link\">Privacy Policy</a>\n");
      out.write("            <!-- Add more footer links as needed -->\n");
      out.write("        </nav>\n");
      out.write("        <p>&copy; 2023 Your Bank Name. All rights reserved.</p>\n");
      out.write("    </section>\n");
      out.write("</body>\n");
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
