<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <script src="jq/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/servicios.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Administrador</title>
    </head>
    <body  style="background: url(img/bannerI.jpg)">
        <h1 style = "color: #ffffff"></h1>
        <div class="container">
            <h1>Mantenimiento de Servicios</h1>
            <a class="btn btn-success" href="serviciosIns.jsp">Nuevo Servicio</a>
            <br>
            <br>
            <table class="table table-bordered">
                <tr>

                    <th class="text-center">ID Servicio</th>
                    <th class="text-center">ID Categoria</th>
                    <th class="text-center">Nombre Servicio</th>
                    <th class="text-center">Foto</th>
                    <th class="text-center">Precio</th>
                    <th class="text-center">Descripcion</th>
                    <th class="text-center">Estadoooo</th>
                    <th>
                        <a href="" onclick="serviciosUpd();">
                            <center>Actualizarrrr</center>                            
                        </a>
                    </th>
                    <th>
                        <a href="#" onclick="estadoUpd();">
                            <center>Estado</center>                            
                        </a>
                    </th>
                </tr>
                <c:forEach var="p" items="${arreglo}">
                    <tr>
                        <td class="text-center">${p.getIdServicio()}</td>
                        <td class="text-center">${p.getIdcategoria()}</td>
                        <td class="text-center">${p.getNombre()}</td>
                        <td class="text-center"><img src="img/${p.getImagen()}" style="width: 20%"></td>
                        <td class="text-center">${p.getPrecio()}</td>
                        <td class="text-center">${p.getDescripcion()}</td>
                        <td class="text-center">${p.getEstado()}</td>
                        <td style="text-align:center;">
                            <input  type="radio" name="idservicio_upd" value="${p.getIdServicio()}"/>
                        </td>
                        <td style="text-align:center;">
                            <input  type="radio" name="estado_upd" value="${p.getIdServicio()}"/>
                        </td>
                        
                    </tr>
                </c:forEach>            
            </table>
            <a class="btn btn-primary" href="intranet.jsp">Regresar</a><br/>
        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
