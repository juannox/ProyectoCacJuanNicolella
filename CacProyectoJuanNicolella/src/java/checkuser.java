/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns = {"/checkuser"})
public class checkuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            
            String imgUrl = request.getContextPath() + "/images/tecnicosLogo.png";
            String bootUrl = request.getContextPath() + "/css/bootstrap.min.css";
            String cssUrl = request.getContextPath() + "/css/servlet.css";
            
            String homeUrl = request.getContextPath() + "/index.html";
            String nosotrosUrl = request.getContextPath() + "/PaginasSecundarias/nosotros.html";
            String pedidosUrl = request.getContextPath() + "/PaginasSecundarias/pedidos.html";
            String contactoUrl = request.getContextPath() + "/PaginasSecundarias/contacto.html";
            String formUrl = request.getContextPath() + "/PaginasSecundarias/formularioPedido.html";
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <link href=\" " +bootUrl+ " \" rel=\"stylesheet\" type=\"text/css\">" + 
"    <link href=\" " +cssUrl+ " \" rel=\"stylesheet\" type=\"text/css\">" +
"    <title>Técnicos a Domicilio</title>");    

            out.println("</head>");
            out.println("<body>");
            out.println("<div>\n" +
"        <ul id=\"barraDeNavegacion\">\n" +
"            <!--Logo a la izquierda-->\n" +
"            <li><a id=\"tecnicosLogoA\" class=\"container-fluid\" href=\"../index.html\"><img id=\"tecnicosLogo\" src=\" " + imgUrl + " \" alt=\"Logo\"></a></li>\n" +
"            <!--Barra de navegación a la derecha-->\n" +
"            <div id=\"navDer\">\n" +
"                <li id=\"paginas\"><a href=\" "+homeUrl+" \">Home</a></li>\n" +
"                <li id=\"paginas\"><a href=\" "+nosotrosUrl+" \">Nosotros</a></li>\n" +
"                <li id=\"paginas\"><a href=\" "+pedidosUrl+" \">Pedidos</a></li>\n" +
"                <li id=\"paginas\"><a href=\" "+contactoUrl+" \">Contacto</a></li>\n" +
"            </div>\n" +
"        </ul>\n" +
"        <hr id=\"barra\">\n" +
"    </div>");
            
            
            //************************************************************************************
            
            Persistencia base = new Persistencia();
            java.sql.ResultSet rs = (java.sql.ResultSet) base.consultaSQL("select * from usuarios where usuario = "
                    + "'" + request.getParameter("inputEmail") + "'" + "and clave = " 
            + "'" + request.getParameter("inputPassword") + "'");
            
            out.println("<div class=\"container-fluid d-flex flex-column mt-2\">");
            
            if(rs.first()==false){
                
                out.println("<div class=\"container-fluid justify-content-center mb-3\">");
                out.println("No hay usuarios que coincidan con la búsqueda");
                out.println("</div>");
                
            } else {
                
                out.println("<div  class=\"d-flex flex-column justify-content-center mb-3\">");
                out.println("Usuario: " + rs.getString("usuario"));
                //out.println(rs.getString("clave"));
                out.println("<br>");
                out.println("Nombre y Apellido: " + rs.getString("nombreYApellido")+"<BR>");
                out.println("</div>");
            
                out.println("<div  class=\"d-flex flex-column justify-content-center mb-3\">");
                out.println("<h3>Servlet checkuser at " + request.getContextPath() + "</h3>");
                out.println("<h3>El usuario es: " + request.getParameter("inputEmail") + "</h3>");
                out.println("</div>");
                
                out.println("<div id=\"contenedor\" class=\"d-flex flex-column justify-content-center mb-3\">");
                out.println("<h1 class=\"mx-5\">Ya puede realizar su pedido</h1>");
                out.println("<a href=\" "+formUrl+" \" class=\"btn m-auto mt-3\">Realizar pedido</a>");
                out.println("</div>");
            }
            //******************************************************************************************
            
            out.println("</div>");
            
            
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
            
            
           
            } catch (SQLException ex) {
                Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        
        
        
    
        
            
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
