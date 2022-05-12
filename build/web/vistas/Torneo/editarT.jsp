<%-- 
    Document   : alumnos
    Created on : 10/08/2019, 03:25:59 PM
    Author     : MARCOS
--%>
<%@page import="beans.Torneo"%>
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
        <h1>Editar Torneo</h1> 
        <br>      
       <%ArrayList<Torneo> std = (ArrayList<Torneo>)request.getAttribute("data"); 
        for(Torneo s:std){%> 
          <hr />
        Estatus Proceso = <%=request.getAttribute("error")%>
        <br>Modificando ID = <%=s.getIdTorneo()%>
        <hr />
        <form method='post' id='emp-AddForm' action='MTorneo'> 
   <table class='table table-bordered'>
         <tr>
            <td>Nombre</td>
            <td><input type='text' id='id' name='id' class='form-control' value="<%=s.getIdTorneo()%>">
                <input type='text' id='nombre' name='nombre' class='form-control' value="<%=s.getNombre()%>"></td>
        </tr>
        <tr>
            <td>Empleado</td>
            <td><input type='text' id='empleado' name='empleado' class='form-control' value="<%=s.getEmpleado() %>"></td>
        </tr>
         <tr>
            <td>Lugar</td>
            <td><input type='text' id='lugar' name='lugar' class='form-control' value="<%=s.getLugar() %>"></td>
        </tr>
         <tr>
            <td>Fecha Inicio</td>
            <td><input class="form-control" id='fechaI' name="fechaI" placeholder="YYYY-MM-DD" type="text" value="<%=s.getFechaInicio() %>" /></td>
        </tr>
        <tr>
            <td>Fecha Final</td>
            <td><input class="form-control" id='fechaF' name="fechaF" placeholder="YYYY-MM-DD" type="text" value="<%=s.getFechaFin() %>" /></td>
        </tr>
        <tr>
            <td colspan="2">
            <button type="submit" class="btn btn-danger" name="btn-update" id="btn-update">
    		<span class="glyphicon glyphicon-plus"></span> Modificar 
			</button>
            </td>
        </tr> 
    </table>
 </form>
        
           <%}%>
          </div>
    </body>
</html>
