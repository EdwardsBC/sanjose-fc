<%-- 
    Document   : menu
    Created on : 30/07/2019, 01:39:23 PM
    Author     : MARCOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia de Futbol San Jose F.C</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
    </head>
    <body>     
    <div class="wrapper">
         
        <nav id="sidebar">
            <div class="container-fluid">
                 <div class="Icon">
                     <center><img src="img/logo.jpg"  width="80" height="80" style="border-radius:150px;"></center>
                </div>
                <br>
                usuario: <%=request.getAttribute("usuario")%>
            
            </div>
            <hr>
            <ul class="list-unstyled components">
                 <li>
                    <a href="Iniciar">Inicio</a>
                </li>
                <li>
                   <a href="#confSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"> <span class="fa fa-cog"></span>  Configuracion</a>
                    <ul class="collapse list-unstyled" id="confSubmenu">
                        <li>
                            <a href="Matriculas">Matriculas</a>
                        </li>
                        <li>
                           <a href="Empleado">Empleados</a>
                        </li>
                        <li>
                            <a href="Alumnos">Alumnos</a>
                        </li>
                        <li>
                            <a href="Categorias">Categorias</a>
                        </li>
                        <li>
                            <a href="Cargos">Cargos</a>
                        </li>
                         <li>
                            <a href="nuevousuario">Registro</a>
                        </li>
                         <li>
                            <a href="#">Accesos</a>
                        </li>
                    </ul>
                </li>
               <li>
                    <a href="#asistSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><span class="fa fa-edit"></span>  Asistencia</a>
                    <ul class="collapse list-unstyled" id="asistSubmenu">
                        <li>
                            <a href="Asistencia">Alumnos</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#perfSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><span class="fa fa-signal"></span> Performance</a>
                    <ul class="collapse list-unstyled" id="perfSubmenu">
                        <li>
                            <a href="Performance">Alumnos</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#torSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><span class="fa fa-trophy"></span>  Torneos</a>
                    <ul class="collapse list-unstyled" id="torSubmenu">
                        <li>
                            <a href="Torneos">Torneo</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="Acerca">Acerca de</a>
                </li>
            </ul>
        </nav>  

    <div id="content">
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-danger">
                        <i class="fas fa-align-left"></i>
                        <span>Menu</span>
                    </button>                    
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="Iniciar">Cerrar Session</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
       <% String p = (String)request.getAttribute("paginaActual"); 
   String pagePath = ""+p+".jsp";
%>

<jsp:include page="<%= pagePath %>" ></jsp:include>
        </div>
        </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
    </body>
</html>
