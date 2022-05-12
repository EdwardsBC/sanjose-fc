/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.ControlAlumno;
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
public class ModificarAlumno extends HttpServlet {

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
            ControlAlumno ca = new ControlAlumno();
            ControlTorneo tr = new ControlTorneo();
              try (PrintWriter out = response.getWriter()) {
                  
        
         int id =  Integer.parseInt(request.getParameter("id"));  
         int dni =  Integer.parseInt(request.getParameter("dni"));
         String nombre = request.getParameter("nombre");
         String apellido = request.getParameter("apellido");
         String direccion = request.getParameter("direccion");
         String fechaN = request.getParameter("fechaN");
         int vigencia =  1;
         int vigenciT =  1;
         String clave = request.getParameter("clave");
         int torneo =  Integer.parseInt(request.getParameter("torneo"));
        
        /* out.print("DNI="+dni);
         out.print("nombre="+nombre);
         out.print("apellido="+apellido);
         out.print("direccion="+direccion);
         out.print("vigencia="+vigencia);
         out.print("vigenciaT="+vigenciT);
         out.print("clave="+clave);
         out.print("torneo="+torneo);
         out.print("fechaN="+fechaN);
         boolean e = ca.ModificarAlumnos(torneo, nombre, apellido, direccion, fechaN, dni,vigencia,vigenciT, clave, id);
         out.print("registro= "+ca.getError());*/
         
         if(ca.ModificarAlumnos(torneo, 
                            nombre,
                            apellido,
                            direccion,
                            fechaN,
                            dni,
                            vigencia,
                            vigenciT,
                            clave,
                            id)){
             
             RequestDispatcher rd = request.getRequestDispatcher("Alumnos"); 
             rd.forward(request, response); 
          
          }else{
             
             RequestDispatcher rd = request.getRequestDispatcher("Alumnos"); 
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
