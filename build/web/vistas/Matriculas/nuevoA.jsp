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
     <h4 class="form-signin-heading">Nuevo Alumno</h4>
     <hr>
       Estatus Proceso: <%=request.getAttribute("error")%>
        <br>
        <br>
	</div>
    <form method='post' id='emp-AddForm' action='MRegistrarAlumno'> 
    <table class='table table-bordered'>
         <tr>
            <td>DNI</td>
            <td><input type='text' id='dni' name='dni' class='form-control' value="<%=request.getAttribute("dni")%>"></td>
        </tr>
        <tr>
            <td>Nombre</td>
            <td><input type='text' id='nombre' name='nombre' class='form-control' value="<%=request.getAttribute("nombre")%>"></td>
        </tr>
         <tr>
            <td>Apellido</td>
            <td><input type='text' id='apellido' name='apellido' class='form-control' value="<%=request.getAttribute("apellido")%>"></td>
        </tr>
         <tr>
            <td>Direccion</td>
            <td><textarea id="direccion" name="direccion"  class="form-control" rows="3"></textarea></td>
          </tr>
        <tr>
            <td>Fecha Nacimiento</td>
            <td><input class="form-control" id='fechaN' name="fechaN" placeholder="YYYY-MM-DD" type="text"/></td>
        </tr>
        <tr>
            <td>Vigencia</td>
            <td><input type='checkbox' id='vigencia' name='vigencia' value="1"></td>
        </tr>
        <tr>
            <td>Vigencia Torneo</td>
            <td><input type='checkbox' id='vigenciT' name='vigenciT' value="1"></td>
        </tr>
        <tr>
            <td>Torneo</td>
            <td><select id='torneo' name='torneo' class="form-control">
            <%ArrayList<Torneo> std = (ArrayList<Torneo>)request.getAttribute("trs"); 
             for(Torneo t:std){%> 
                    <option value="<%=t.getIdTorneo()%>"><%=t.getNombre()%></option>
              <%}%>
                </select>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type='password' id='clave' name='clave' class='form-control'></td>
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
