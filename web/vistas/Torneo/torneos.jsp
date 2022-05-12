<%-- 
    Document   : alumnos
    Created on : 10/08/2019, 03:25:59 PM
    Author     : MARCOS
--%>
<%@page import="beans.Torneo"%>
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
        <h1>Listar Torneo</h1> 
        <br>
        <hr />
        Estatus Proceso: <%=request.getAttribute("error")%>
        <hr />
        <a class="add-link" href="NTorneo" title="agregar">
             <button class="btn btn-danger" type="button" id="btn-add" data-toggle="tooltip" data-placement="bottom" title="incluir"> <i class="fa fa-user"></i> Nuevo</button>
        </a>
       <hr />
         <table cellspacing="0"  id="permisos" class="table table-bordered" > 
          <thead>
          <th>ID</th> 
          <th>Nombre</th> 
          <th>Empleado</th> 
          <th>Lugar</th> 
          <th>Fecha Inicio</th> 
          <th>Fecha Final</th> 
          <th>Editar</th> 
          <th>Eliminar</th> 
          </thead>
          <tbody>
        <%ArrayList<Torneo> std = (ArrayList<Torneo>)request.getAttribute("data"); 
        for(Torneo s:std){%> 
            <tr> 
                <td><%=s.getIdTorneo()%></td> 
                <td><%=s.getNombre()%></td> 
                <td><%=s.getEmpleado()%></td> 
                <td><%=s.getLugar()%></td> 
                <td><%=s.getFechaInicio()%></td> 
                <td><%=s.getFechaFin()%></td> 
                <td> 
        <form method='post' id='emp-AddForm' action='ETorneo'>
            <input type="hidden" name="ida" value="<%=s.getIdTorneo()%>">
                               <button class="btn btn-danger" type="submit" id="btn-add" data-toggle="tooltip" data-placement="bottom" title="incluir"> <i class="fa fa-edit"></i> Editar</button>
			</button>
                        </form>  </td>
                <td> 
        <form method='post' id='emp-AddForm' action='RETorneo'>
            <input type="hidden" name="id" value="<%=s.getIdTorneo()%>">
                               <button class="btn btn-danger" type="submit" id="btn-add" data-toggle="tooltip" data-placement="bottom" title="incluir"> <i class="fa fa-eraser"></i> Remover</button>
			</button>
                        </form>  </td>
            </tr> 
            <%}%> 
          </tbody>
          </table> 
          </div>
    </body>
</html>
