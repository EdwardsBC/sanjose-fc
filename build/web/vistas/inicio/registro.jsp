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
     <h4 class="form-signin-heading">Nuevo Usuario</h4>
     <hr>
        <br>
        <br>
	</div>
    <form method='post' id='emp-AddForm' action='nuevousuario'> 
    <table class='table table-bordered'>
         <tr>
            <td>Usuario</td>
            <td><input type='text' id='usuario' name='usuario' class='form-control'></td>
        </tr>
        <tr>
            <td>Clave</td>
            <td><input type='password' id='pass' name='pass' class='form-control'></td>
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
