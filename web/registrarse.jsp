<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Insertar datos</title>
    </head>
    <body  style="background: url(img/bannerI.jpg)">
        <h1 style = "color: #ffffff"></h1>
        <div class="container"></div>
        <div class="col-lg-6"></div>
        <h1>Agregar usuario</h1>
        <form action="srvUsuario?accion=registrar" method="post" style="margin: auto; display: table"> 
            <fieldset>
                <legend>Agregar datos</legend>
                <br/>
                <label>Ingrese el Correo</label><br>
                <input class="form-control" type="email" name="txtemail" style="width: 400px"
                       placeholder="Ingrese el correo"/>
                <br/>  
                <label>Ingrese la contraseña</label><br>
                <input class="form-control" type="password" placeholder="Ingrese la contraseña" 
                       name="txtcontra"/>                
                <br/>
                <label>Ingrese el Nombre</label> 
                <input class="form-control" type="text" name="txtnombre" style="width: 400px"/>
                <br/>
                <label>Ingrese el Apellido</label> 
                <input class="form-control" type="text" name="txtapellido" style="width: 400px"/>
                <br/>
                <label>Ingrese el DNI</label> 
                <input class="form-control" type="text" name="txtdni" style="width: 400px"/>
                <br/>
                <label>Ingrese la Direccion</label> 
                <input class="form-control" type="text" name="txtdireccion" style="width: 400px"/>
                <br/>
                <br/>
                <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                <a class="btn btn-primary" href="login.jsp">Regresar</a><br/>
                <c:if test="${mensaje != null}">
                    <div>${mensaje}</div>
                </c:if>

            </fieldset>
        </form>
</html>
