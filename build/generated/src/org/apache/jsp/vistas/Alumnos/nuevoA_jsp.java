package org.apache.jsp.vistas.Alumnos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nuevoA_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"../../js/nuevoA.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("         <div id=\"dis\">\n");
      out.write("     <hr>\n");
      out.write("     <h4 class=\"form-signin-heading\">Nuevo Alumno</h4>\n");
      out.write("     <hr>\n");
      out.write("\t</div>\n");
      out.write("    <form method='post' id='emp-AddForm' action='NAlumno' onsubmit=\"return valida(this)\"> \n");
      out.write("    <table class='table table-bordered'>\n");
      out.write("         <tr>\n");
      out.write("            <td>DNI</td>\n");
      out.write("            <td><input type='text' id='dni' name='dni' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Nombre</td>\n");
      out.write("            <td><input type='text' id='nombre' name='nombre' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Apellido</td>\n");
      out.write("            <td><input type='text' id='apellido' name='apellido' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Direccion</td>\n");
      out.write("            <td><textarea id=\"direccion\" name=\"direccion\"  class=\"form-control\" rows=\"3\"></textarea></td>\n");
      out.write("          </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Fecha Nacimiento</td>\n");
      out.write("            <td><div class=\"input-group\">\n");
      out.write("                     <div class=\"input-group-addon\">\n");
      out.write("                      <i class=\"fa fa-calendar\">\n");
      out.write("                      </i>\n");
      out.write("                     </div>\n");
      out.write("                     <input class=\"form-control\" id=\"fechaN\" name=\"fechaN\" placeholder=\"DD/MM/YYYY\" type=\"text\" onchange=\"diferencia()\"/>\n");
      out.write("                    </div></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Vigencia</td>\n");
      out.write("            <td><input type='text' id='vigencia' name='vigencia' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Vigencia Torneo</td>\n");
      out.write("            <td><input type='text' id='vigenciT' name='vigenciT' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Password</td>\n");
      out.write("            <td><input type='text' id='clave' name='clave' class='form-control'></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td colspan=\"2\">\n");
      out.write("            <button type=\"submit\" class=\"btn btn-danger\" name=\"btn-update\" id=\"btn-update\">\n");
      out.write("    \t\t<span class=\"glyphicon glyphicon-plus\"></span> Guardar \n");
      out.write("\t\t\t</button>\n");
      out.write("            </td>\n");
      out.write("        </tr> \n");
      out.write("    </table>\n");
      out.write(" </form>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("                $('#fechaN').datetimepicker();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("   </div>\n");
      out.write("</div>\n");
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
