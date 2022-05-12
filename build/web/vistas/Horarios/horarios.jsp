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
        <h1>Horarios</h1> 
        </div>
    </body>
</html>
