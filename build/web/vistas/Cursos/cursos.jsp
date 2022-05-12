<%-- 
    Document   : alumnos
    Created on : 10/08/2019, 03:25:59 PM
    Author     : MARCOS
--%>
<%@page import="beans.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
           <script type="text/javascript" src="js/datatables.min.js"></script>
           <script type="text/javascript" charset="utf-8">
            $(document).ready(function() {
                    $('#permisos').DataTable();

                    $('#permisos')
                    .removeClass( 'display' )
                    .addClass('table table-bordered');
            });
            </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content-loader">
        <h1>Cursos</h1> 
        <table>
            <tr>
                <td>Docente:<br>
                    Marcos Colchado
                </td>
                <td>Evaluacion:<br>
                    Marcos Colchado
                </td>
                <td>Rendimiento Academico<br>
                    Marcos Colchado
                </td>
            </tr>
              <tr>
                <td>Horarios: <br>
                    Marcos Colchado
                </td>
                   <td>Formula <br>
                    Marcos Colchado
                </td>
            </tr>
                <tr>
                <td>Creditos <br>
                    Marcos Colchado
                </td>
                   <td>Promedio <br>
                    Marcos Colchado
                </td>
            </tr>
            <tr>
                <td>Nro Vez <br>
                    Marcos Colchado
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
