<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cliente = "";
    String ID_Cliente = "";
    HttpSession sesionOk = request.getSession();
    ID_Cliente = sesionOk.getAttribute("ID_Cliente").toString();
    cliente = (String) sesionOk.getAttribute("cliente");
    if (session.getAttribute("usuario") != null) {
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="css/Dashboard.css" rel="stylesheet" type="text/css"/>
        <title>Intranet cliente</title>
    </head>
    <body style="background: url(img/bannerI.jpg)">
        <input type="hidden" value="<%=ID_Cliente%>" name="ID_Cliente" >
        <div class="d-flex">
            <div id="sidebar-container" class="color-fondo">
                <div class="logo">
                    <h4 class="text-light text-dark color-text1">VETFRIEND</h4>
                    <p>Cliente <%=cliente%></p>
                </div>
                <div class="menu">

                    <ul class="navbar-nav">
                        <li><a href="actualizar.jsp" class="d-block  p-3 color-text"><i class='bx bx-user'></i> Actualizar mis datos</a>
                        </li>
                        <li><a href="CompraServlet?accion=Historial&ID_Cliente=<%=ID_Cliente%>" class="d-block  p-3 color-text"><i class='bx bx-spreadsheet'></i> Historial de Servicios</a>
                        </li>
                        <li><a href="catalogo.jsp" class="d-block  p-3 color-text"><i class='bx bx-cart'></i> Ir al Catálogo</a></li>
                        <li><a href="index.html" class="d-block p-3 color-text"> <i class='bx bx-exit'></i> Salir</a></li>
                    </ul>
                </div>
            </div>
            <div class="container">
                <div class="contenido">
                    <div class="col-lg-6"></div>
                    <h1>Actualizar mis Datos de Usuario</h1>
                    <form action="srvUsuario?accion=actualizar" method="post" style="margin: auto; display: table">           
                        <input type="hidden" name="txtDni" value="${usuario.dni}"/>
                        <div class="form-group">
                            <label>DNI</label><br/>
                            <input class="form-control" type="text" name="txtdni" style="width: 100%"
                                   value="${usuario.dni}" placeholder="Ingrese el DNI" readonly=""/>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label><br/>
                            <input class="form-control" type="text" name="txtnombre" style="width: 100%"
                                   value="${usuario.nombre}" placeholder="Ingrese el nombre"/>
                        </div>
                        <div class="form-group">
                            <label>Apellido</label><br/>
                            <input class="form-control" type="text" name="txtapellido" style="width: 100%"
                                   value="${usuario.apellido}" placeholder="Ingrese el apellido"/>
                        </div>
                        <div class="form-group">
                            <label>Direccion</label><br/>
                            <textarea class="form-control" placeholder="Ingrese la direccion" style="width: 100%"
                                      name="txtdireccion">${usuario.direccion}</textarea>                
                        </div>
                        <div class="form-group">
                            <label>Correo</label><br/>
                            <input class="form-control" type="email" name="txtcorreo" style="width: 100%"
                                   value="${usuario.correo}" placeholder="Ingrese el correo"/>
                        </div>
                        <br/><p style="text-align: center;">
                            <br/>
                            <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                            <a class="btn btn-primary" href="login.jsp">Regresar</a><br/>
                            <c:if test="${mensaje != null}">
                            <div>${mensaje}</div>
                        </c:if>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
