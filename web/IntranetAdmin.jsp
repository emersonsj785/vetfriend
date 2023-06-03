<%@page import="dao.impl.DaoServiciosImpl"%>
<%@page import="dto.Servicios"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jq/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/servicios.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/Dashboard.css" rel="stylesheet" type="text/css"/>
        <title>Administrador</title>
    </head>
    <body style="background: url(img/bannerI.jpg)"> 
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
                <h1>Servicios</h1>
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
                        <th class="text-center">Estado</th>
                        <th>
                            <a href="#" onclick="serviciosUpd();">
                                <center>Actualizar</center>                            
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
        </div>
    </body>
</html>
