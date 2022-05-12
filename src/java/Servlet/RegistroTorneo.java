/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControlTorneo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MARCOS
 */
public class RegistroTorneo extends HttpServlet {

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
          ControlTorneo tr = new ControlTorneo();
        try (PrintWriter out = response.getWriter()) {
          
         String nombre = request.getParameter("nombre");
         String empleado = request.getParameter("empleado");
         String lugar = request.getParameter("lugar");
         String fechaI = request.getParameter("fechaI");
         String fechaF = request.getParameter("fechaF");
         
       /*  out.print("nombre="+nombre);
         out.print("empleado="+empleado);
         out.print("lugar="+lugar);
         out.print("fechaI="+fechaI);
         out.print("fechaF="+fechaF);         
         boolean e = tr.NuevoTorneo(nombre, empleado,  lugar, fechaI,  fechaF);
         out.print("registro= "+tr.getError());*/
         
             if(tr.NuevoTorneo(nombre, 
                            empleado,
                            lugar,
                            fechaI,
                            fechaF)){
             
             request.setAttribute("error", tr.getError()); 
             request.setAttribute("paginaActual", "Torneo/nuevoT");
             RequestDispatcher rd = request.getRequestDispatcher("vistas/menu.jsp"); 
             rd.forward(request, response); 
          
          }else{
             
             request.setAttribute("error", tr.getError()); 
             request.setAttribute("paginaActual", "Torneo/nuevoT");
             RequestDispatcher rd = request.getRequestDispatcher("vistas/menu.jsp"); 
             rd.forward(request, response); 
          
         }
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
