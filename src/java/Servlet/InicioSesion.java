/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import controlador.Consultas;
import controlador.ControlAlumno;
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
public class InicioSesion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        

        
          String usuario = request.getParameter("usuario");
          String pass = request.getParameter("pass");
          
          Consultas co = new Consultas();
          ControlAlumno ca = new ControlAlumno();
          
          if(co.autenticacion(usuario, pass)){
              if(ca.BuscaAlumno(usuario)){
                  
                   request.setAttribute("usuario", usuario);  
                   request.setAttribute("paginaActual", "principal");  
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("vistas/menua.jsp");
                   requestDispatcher.forward(request, response);
                  
              }else{
                 
                   request.setAttribute("usuario", usuario);  
                   request.setAttribute("paginaActual", "principal");  
                   RequestDispatcher requestDispatcher = request.getRequestDispatcher("vistas/menu.jsp");
                   requestDispatcher.forward(request, response);
              
              }
             
          }else{
              RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
              requestDispatcher.forward(request, response);
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
