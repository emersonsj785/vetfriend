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
        <script src="js/clientes.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/Dashboard.css" rel="stylesheet" type="text/css"/>
        <title>Administrador</title>
    </head>
    <body  style="background: url(img/bannerI.jpg)">
        <div class="d-flex">
        <div id="sidebar-container" class="color-fondo">
            <div class="logo">
                <h4 class="text-light text-dark color-text1">VETFRIEND</h4>
                <p>Administrador</p>
            </div>
            <div class="menu">

                <ul class="navbar-nav">
                    <li><a href="Servicios?accion=SEL" class="d-block  p-3 color-text"><i class='bx bx-cog'></i> Mantenimiento de Servicios</a>
                    </li>
                    <li><a href="Intranet?accion=listar" class="d-block  p-3 color-text"><i class='bx bx-spreadsheet' ></i> Cartera de clientes</a>
                    </li>
                    <li><a href="ComprasSrvt?accion=SEL" class="d-block  p-3 color-text"><i class='bx bx-cart'></i> Gestion de compras</a></li>
                    <li><a href="index.html" class="d-block p-3 color-text"> <i class='bx bx-exit'></i> Salir</a></li>
                </ul>
            </div>
        </div>
        <div class="container">
            <h1>Cartera de clientes</h1>
            <br>
            <br>
            <table class="table table-bordered">
                <tr>

                    <th class="text-center">ID Cliente</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">DNI</th>
                    <th class="text-center">Correo</th>
                    <th class="text-center">Dirección</th>
                    <th>
                        <a href="#" onclick="clienteDel();">
                            <center>Eliminar</center>                            
                        </a>
                    </th>
                </tr>
                <c:forEach var="c" items="${cartera}">
                    <tr>
                        <td class="text-center">${c.getId()}</td>
                        <td class="text-center">${c.getNombre()}</td>
                        <td class="text-center">${c.getApellido()}</td>
                        <td class="text-center">${c.getDni()}</td>
                        <td class="text-center">${c.getCorreo()}</td>
                        <td class="text-center">${c.getDireccion()}</td>
                        <th style="text-align:center;">
                            <input  type="radio" name="clientes_Del" value="${c.getId()}"/>
                        </th>
                    </tr>
                </c:forEach>            
            </table>
            <a class="btn btn-primary" href="intranet.jsp">Regresar</a><br/>
        </div>
    </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
