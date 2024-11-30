package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Home</title>\n");
      out.write("        \n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js\" integrity=\"sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Bem-vindo ao iCabueta</h1>\n");
      out.write("            \n");
      out.write("            <div class=\"list-group\">\n");
      out.write("                <h3>Métodos de Fila</h3>\n");
      out.write("                <a href=\"cadastroMetodoFila.jsp\" class=\"list-group-item list-group-item-action\">Cadastrar Método Fila</a>\n");
      out.write("                <a href=\"mostrarMetodosFila.jsp\" class=\"list-group-item list-group-item-action\">Mostrar Métodos Fila</a>\n");
      out.write("\n");
      out.write("                <h3>Estudante</h3>\n");
      out.write("                <a href=\"cadastroEstudante.jsp\" class=\"list-group-item list-group-item-action\">Cadastrar Estudante</a>\n");
      out.write("                <a href=\"mostrarEstudantes.jsp\" class=\"list-group-item list-group-item-action\">Mostrar Estudantes</a>\n");
      out.write("                \n");
      out.write("                <h3>Professor</h3>\n");
      out.write("                <a href=\"cadastroProfessor.jsp\" class=\"list-group-item list-group-item-action\">Cadastrar Professor</a>\n");
      out.write("                <a href=\"mostrarProfessores.jsp\" class=\"list-group-item list-group-item-action\">Mostrar Professores</a>\n");
      out.write("                \n");
      out.write("                <h3>Cadeira</h3>\n");
      out.write("                <a href=\"cadastroCadeira.jsp\" class=\"list-group-item list-group-item-action\">Cadastrar Cadeira</a>\n");
      out.write("                <a href=\"mostrarCadeiras.jsp\" class=\"list-group-item list-group-item-action\">Mostrar Cadeiras</a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
