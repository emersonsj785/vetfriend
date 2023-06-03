
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Insertar Servicio</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
        <h1>Agregar Servicio</h1>
        <form action="Servicios?accion=INS" method="post" style="margin: auto; display: table"> 
            <fieldset>
                <legend>Agregar datos</legend>
                <br/>
                
                <label>Ingrese La categoria</label><br>
                <select name="categorias" class="form-control" style="width: 400px" value="${servicio.getIdcategoria()}">
                                <option value="1">Laboratorio</option>
                                <option value="2">Hospitalización</option>
                                <option value="3">Emergencia</option>
                                <option value="4">Teleconsulta</option>
                                <option value="5">Baño y Peluqueria</option>
                        </select>
                <br/> 
                <label>Ingrese el Nombre</label><br>
                <input class="form-control" type="text" name="txtNombre" style="width: 400px"
                       placeholder="Ingrese el nombre" value="${servicio.getNombre()}"/>
                <br/>  
                <label>Ingrese el Nombre de la Imagen</label><br>
                <input class="form-control" type="text" name="Imagen" style="width: 400px"
                       placeholder="Ingrese La foto" value="${servicio.getImagen()}"/>
                <br/>  
                
                <label>Ingrese el precio</label> 
                <input class="form-control" type="number" name="txtprecio" style="width: 400px"
                       value="${servicio.getPrecio()}"/>
                <br/>
                
                <textarea class="form-control" placeholder="Ingrese descripcion" 
                          name="txtDescripcion">${servicio.getDescripcion()}</textarea>
                <br/>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-primary" href="servicios.jsp">Regresar</a><br/>
        <c:if test="${mensaje != null}">
            <div>${mensaje}</div>
        </c:if>         
            </fieldset>
        </form>
        
            </div>
        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>