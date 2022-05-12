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
        <h1>Editar Alumnos</h1> 
        <br>      
       <%ArrayList<Alumno> std = (ArrayList<Alumno>)request.getAttribute("data"); 
        for(Alumno s:std){%> 
          <hr />
        Estatus Proceso = <%=request.getAttribute("error")%>
        <br>Modificando ID = <%=s.getIdAlumno()%>
        <hr />
        <form method='post' id='emp-AddForm' action='RegistrarAlumno'> 
    <table class='table table-bordered'>
         <tr>
            <td>DNI</td>
            <td><input type='text' id='dni' name='dni' class='form-control'  value="<%=s.getDni()%>"></td>
        </tr>
        <tr>
            <td>Nombre</td>
            <td><input type='text' id='nombre' name='nombre' class='form-control' value="<%=s.getNombreAlumno()%>"></td>
        </tr>
         <tr>
            <td>Apellido</td>
            <td><input type='text' id='apellido' name='apellido' class='form-control' value="<%=s.getApellidoAlumno()%>"></td>
        </tr>
         <tr>
            <td>Direccion</td>
            <td><textarea id="direccion" name="direccion"  class="form-control" rows="3"><%=s.getDireccion()%></textarea></td>
          </tr>
        <tr>
            <td>Fecha Nacimiento</td>
            <td><input class="form-control" id="fechaN" name="fechaN" placeholder="YYYY-MM-DD" type="text" value="<%=s.getFechaNacimiento()%>"/>
                    </td>
        </tr>
        <tr>
            <td>Vigencia</td>
            <td><input type='checkbox' id='vigencia' name='vigencia' ></td>
        </tr>
        <tr>
            <td>Vigencia Torneo</td>
            <td><input type='checkbox' id='vigenciT' name='vigenciT'></td>
        </tr>
        <tr>
            <td>Torneo</td>
            <td><input type='text' id='torneo' name='torneo' class='form-control' value="<%=s.getIdTorneo()%>">
                <select id='torneo' name='torneo' class="form-control">
                    <option value="1">Torneo 1</option>
                    <option value="2">Torneo 2</option>
                    <option value="3">Torneo 3</option>
                    <option value="4">Torneo 4</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type='password' id='clave' name='clave' class='form-control' value="<%=s.getPasswordAlumno()%>"></td>
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
