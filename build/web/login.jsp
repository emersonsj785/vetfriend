<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="WEB-INF/jspf/browser.jspf" %>
<%session.invalidate();%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/login.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>       
    </head>
    <body  style="background: url(img/fondoLogin.jpg); background-size: cover;
    background-position: center; background-repeat: no-repeat; height: 100vh">
        <h1></h1>
        <br>
        <br>
        <div class="container">
            <div class="col-lg-6"></div>>
            <center><h1 class="loginClase">INICIO DE SESIÓN</h1></center>
            <form method="post" action="Usuarios"
                  style="margin: 0 auto; width: 300px; 
                  padding: 10px;">
                <div class="form-group">
                    <label for="txtCorreo" class="flotante">Usuario</label><br/>
                    <input type="email" name="txtCorreo" value="${user.correo}"
                           id="txtCorreo" required>            
                </div>
                <div class="form-group">
                    <label for="txtClave" class="flotante">Clave</label><br/>
                    <input type="password" name="txtClave" 
                           id="txtClave" required>
                </div><br/>
                <button type="submit" class="btn btn-primary">
                    Ingresar
                </button>
                <a class="btn btn-warning" href="index.html">
                    Regresar
                </a>
                <a class="btn btn-primary" href="registrarse.jsp">
                    Registrar
                </a>
            </form>   
            <c:if test="${mensaje != null}">
                <p>${mensaje}</p>
            </c:if>
        </div>
    </body>
</html>