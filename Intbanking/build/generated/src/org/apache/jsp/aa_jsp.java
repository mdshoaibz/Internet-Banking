package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\"/>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"/>\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/png\" href=\"/icon.png\"/>\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,500,600&display=swap\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"transactions.css\"/>\n");
      out.write("    <title>Bankist</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- TOP NAVIGATION -->\n");
      out.write("<nav>\n");
      out.write("    <p class=\"welcome\">Log in to get started</p>\n");
      out.write("    <img src=\"logo.png\" alt=\"Logo\" class=\"logo\"/>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<main class=\"app\">\n");
      out.write("    <!-- BALANCE -->\n");
      out.write("    <!-- BALANCE -->\n");
      out.write("<div class=\"balance\">\n");
      out.write("    <div>\n");
      out.write("        <p class=\"balance__label\">Current</p>\n");
      out.write("        <p class=\"balance__date\">\n");
      out.write("            As of <span class=\"date\">05/03/2037</span>\n");
      out.write("        </p>\n");
      out.write("    </div>\n");
      out.write("  <form action=\"tran\" method=\"get\">\n");
      out.write("    <label for=\"cid\">Enter CID:</label>\n");
      out.write("    <input type=\"text\" id=\"cid\" name=\"cid\" required>\n");
      out.write("    <button type=\"submit\" name=\"action\" value=\"fetchBalance\">Get Balance</button>\n");
      out.write("</form>\n");
      out.write("    <form action=\"tran\" method=\"get\">\n");
      out.write("    <label for=\"senderCID\">Sender CID:</label>\n");
      out.write("    <input type=\"text\" id=\"senderCID\" name=\"senderCID\" required>\n");
      out.write("    <label for=\"receiverCID\">Receiver CID:</label>\n");
      out.write("    <input type=\"text\" id=\"receiverCID\" name=\"receiverCID\" required>\n");
      out.write("    <label for=\"amount\">Amount:</label>\n");
      out.write("    <input type=\"number\" id=\"amount\" name=\"amount\" required>\n");
      out.write("    <button type=\"submit\" name=\"action\" value=\"transferMoney\">Transfer Money</button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write(" <p class=\"balance__value\">");
      out.print( request.getAttribute("balance") );
      out.write(" INR</p>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- MOVEMENTS -->\n");
      out.write("    <div class=\"movements\">\n");
      out.write("        <div class=\"movements__row\">\n");
      out.write("            <div class=\"movements__type movements__type--deposit\"></div>\n");
      out.write("            <div class=\"movements__date\"></div>\n");
      out.write("            <div class=\"movements__value\"></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"movements__row\">\n");
      out.write("            <div class=\"movements__type movements__type--withdrawal\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"movements__date\"></div>\n");
      out.write("            <div class=\"movements__value\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- SUMMARY -->\n");
      out.write("   \n");
      out.write("\n");
      out.write("    <!-- OPERATION: TRANSFERS -->\n");
      out.write("    <div class=\"operation operation--transfer\">\n");
      out.write("        <h2>Transfer money</h2>\n");
      out.write("        <form class=\"form form--transfer\">\n");
      out.write("            <input type=\"text\" class=\"form__input form__input--to\"/>\n");
      out.write("            <input type=\"number\" class=\"form__input form__input--amount\"/>\n");
      out.write("            <button class=\"form__btn form__btn--transfer\">&rarr;</button>\n");
      out.write("            <label class=\"form__label\">Transfer to</label>\n");
      out.write("            <label class=\"form__label\">Amount</label>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- OPERATION: LOAN -->\n");
      out.write("    <div class=\"operation operation--loan\">\n");
      out.write("        <h2>Request loan</h2>\n");
      out.write("        <form class=\"form form--loan\">\n");
      out.write("            <input type=\"number\" class=\"form__input form__input--loan-amount\"/>\n");
      out.write("            <button class=\"form__btn form__btn--loan\">&rarr;</button>\n");
      out.write("            <label class=\"form__label form__label--loan\">Amount</label>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- OPERATION: CLOSE -->\n");
      out.write("    <div class=\"operation operation--close\">\n");
      out.write("        <h2>Close account</h2>\n");
      out.write("        <form class=\"form form--close\">\n");
      out.write("            <input type=\"text\" class=\"form__input form__input--user\"/>\n");
      out.write("            <input\n");
      out.write("                    type=\"password\"\n");
      out.write("                    maxlength=\"6\"\n");
      out.write("                    class=\"form__input form__input--pin\"\n");
      out.write("            />\n");
      out.write("            <button class=\"form__btn form__btn--close\">&rarr;</button>\n");
      out.write("            <label class=\"form__label\">Confirm user</label>\n");
      out.write("            <label class=\"form__label\">Confirm PIN</label>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- LOGOUT TIMER -->\n");
      out.write("    <p class=\"logout-timer\">\n");
      out.write("        You will be logged out in <span class=\"timer\">05:00</span>\n");
      out.write("    </p>\n");
      out.write("</main>\n");
      out.write("\n");
      out.write("<!-- <footer>\n");
      out.write("  &copy; by Jonas Schmedtmann. Don't claim as your own :)\n");
      out.write("</footer> -->\n");
      out.write("\n");
      out.write("<!--<script src=\"transactions.js\"></script>-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
