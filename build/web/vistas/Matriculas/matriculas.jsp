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
        <title>JSP Page</title>
    </head>
    <body> 
  
              <div class="content-loader">
        <h1>Matricula</h1> 
    <br>
   
     <form method='post' id='emp-AddForm' action='AMatricula'>  
        <table class='table table-bordered'>
            <tr>
            <td colspan="2">Nombre Alumno</td>
            <td colspan="2"><input type="text" id="nombrealumno" name="nombrealumno" class='form-control' value="<%=request.getAttribute("nombre")%>" ></td>
         </tr>
         <tr>
            <td colspan="2">Apellido Alumno</td>
            <td colspan="2"><input type="text" id="apellidoalumno" name="apellidoalumno" class='form-control' value="<%=request.getAttribute("apellido")%>"></td>
         </tr>
         <tr>
             <td colspan="2">Dni</td>
            <td colspan="2"><input type="text" id="dni" name="dni" class='form-control' value="<%=request.getAttribute("dni")%>"></td>
         </tr>
            <td colspan="3">
            <center><button type="submit" class="btn btn-danger" name="btn-update" id="btn-update">
    		<span class="glyphicon glyphicon-plus"></span> Registrar 
			</button></center>
            </td>
         </form>
    </table>
    </body>
</html>
