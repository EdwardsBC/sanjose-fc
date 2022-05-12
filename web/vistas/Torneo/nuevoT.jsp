<%-- 
    Document   : nuevoA
    Created on : 12/08/2019, 12:47:52 PM
    Author     : MARCOS
--%>

<%@page import="beans.Torneo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
     <body>
        <div class="container">
         <div id="dis">
     <hr>
     <h4 class="form-signin-heading">Nuevo Torneo</h4>
     <hr>
        Estatus Proceso: <%=request.getAttribute("error")%>
        <br>
        <br>
	</div>
    <form method='post' id='emp-AddForm' action='RTorneo'> 
    <table class='table table-bordered'>
         <tr>
            <td>Nombre</td>
            <td><input type='text' id='nombre' name='nombre' class='form-control'></td>
        </tr>
        <tr>
            <td>Empleado</td>
            <td><input type='text' id='empleado' name='empleado' class='form-control'></td>
        </tr>
         <tr>
            <td>Lugar</td>
            <td><input type='text' id='lugar' name='lugar' class='form-control'></td>
        </tr>
         <tr>
            <td>Fecha Inicio</td>
            <td><input class="form-control" id='fechaI' name="fechaI" placeholder="YYYY-MM-DD" type="text"/></td>
        </tr>
        <tr>
            <td>Fecha Final</td>
            <td><input class="form-control" id='fechaF' name="fechaF" placeholder="YYYY-MM-DD" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
            <button type="submit" class="btn btn-danger" name="btn-update" id="btn-update">
    		<span class="glyphicon glyphicon-plus"></span> Guardar 
			</button>
            </td>
        </tr> 
    </table>
 </form>
   </div>
</div>
    </body>
</html>
