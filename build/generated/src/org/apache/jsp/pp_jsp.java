package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.InputStream;
import java.io.OutputStream;

public final class pp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write(" \n");
      out.write(" \n");

    String login = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/dbcarritocompras";
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    int nBytes = 0;

      out.write(" \n");
      out.write("<html><style type=\"text/css\"> \n");
      out.write("        <!-- \n");
      out.write("        body { \n");
      out.write("            background-color: #F5f5f5; \n");
      out.write("        } \n");
      out.write("        --> \n");
      out.write("    </style><body> \n");
      out.write("        <h1>Imagen desde MySQL</h1>\n");
      out.write("        <table>\n");
      out.write("            <tr><td>\n");
      out.write("                    ");

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        conn = DriverManager.getConnection(url, login, password);
                        statement = conn.createStatement();
                        rs = statement.executeQuery("SELECT foto FROM producto where id='1'");
                        try {
                            if (rs.next()) {
                                response.setContentType("image/jpeg");
                                InputStream is = rs.getBinaryStream(1);
                                OutputStream aux = response.getOutputStream();
                                out.println("jajaja");

                                byte[] buffer = new byte[4096];
                                for (;;) {
                                    nBytes = is.read(buffer);
                                    if (nBytes == -1) {
                                        break;
                                    }

                                    aux.write(buffer, 0, nBytes);

                                }

                                is.close();
                                aux.flush();
                                aux.close();

                            } else {

                                throw new SQLException("image not found");
                            }
                            rs.close();
                        } catch (SQLException e) {
                            out.println("Imagen no encontrada");
                        }

                        out.println("no se muestra");
                    
      out.write(" \n");
      out.write("                </td></tr></table>\n");
      out.write("\n");
      out.write("        <p> Imagen</p> \n");
      out.write("        <a href=\"index.html\">PRINCIPAL</a>\n");
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
