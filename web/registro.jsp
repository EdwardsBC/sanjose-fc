<%-- 
    Document   : newjsp
    Created on : 26/07/2019, 03:15:56 PM
    Author     : MARCOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academia de Futbol San Jose F.C</title>      
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">   
        <link rel="stylesheet" href="css/login.css"> 
        <script src="js/bootstrap.min.js"></script>    
    </head>
    <body>
        <div class="Contenedor">
                <div class="Icon">
                    <span class="glyphicon glyphicon-user"></span>
                </div>
               <br>
        <form action="nuevousuario" method="post" role="form" data-toggle="validator">
             <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
            <div class="input-group input-group-lg">
		  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
		  <input type="text" class="form-control" name="usuario" placeholder="usuario" id="usuario" aria-describedby="sizing-addon1" required>
	    </div>
            <br>
             <div class="input-group input-group-lg">
                  <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
  		  <input type="password" name="pass" class="form-control" placeholder="******" aria-describedby="sizing-addon1" required>
	    </div>
                <br>
          <button class="btn btn-lg btn-light btn-block btn-signin" id="IngresoLog" type="submit">Guardar</button> 
        </form>
        </div>
    </body>
</html>