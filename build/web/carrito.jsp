
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.Servicios"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("usuario") != null) {
        String ID_Cliente = "";
        String Nombre = "";
        HttpSession sesionOk = request.getSession();
        ID_Cliente = sesionOk.getAttribute("ID_Cliente").toString();
        Nombre = (String) sesionOk.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
        <style>
            @media print{
                .card-footer, .accion, .main-header, .main-nav, .eli {
                    display: none;
                }
            }
        </style>
        
        <script src="jq/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="css/icons.css"/>
        <link href="css/estiloscat.css" rel="stylesheet"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
    </head>
    <body style="background: url(img/bannerI.jpg)">
        <header class="main-header" style="background: url(img/banner2.jpg)">
            <div class="container container--flex">
                <div class="logo-container column column--50">
                    <div class="logo"><a href="index.jsp"><img style="width:120px; height:75px;" src="img/log.png"/></a></div>
                </div>
                <div class="main-header__contactInfo column column--50">
                    <p class="main-header__contactInfo__phone">
                        <span class="icon-whatsapp">949875183</span>
                    </p>
                    <p class="main-header__contactInfo__address">
                        <span class="icon-map">Jr. Los Alpistes 245 Urb. Los Girasoles</span>
                    </p>
                </div>
            </div>
        </header>
        <nav class="main-nav">
            <div class="container container--flex">
                <span class="icon-menu" id="btnmenu"></span>
                <ul class="menu" id="menu">
                    <li class="menu__item"><a href="index.jsp" class="menu__link menu__link--select">Inicio</a></li>
                    <li class="menu__item"><a href="nosotros.html" class="menu__link">Nosotros</a></li>
                    <li class="menu__item"><a href="catalogo.jsp" class="menu__link">Catalogo</a></li>
                    <li class="menu__item"><a href="catalogo.jsp" class="menu__link">Seguir comprando</a></li>
                    <li class="menu__item"><a href="actualizar.jsp" class="menu__link">Intranet</a></li>
                    <li class="menu__item"><a href="${pageContext.request.contextPath}/Logout" class="menu__link">Salir</a></li>
                </ul>
                <div class="social-icon">
                    <a href="https://www.facebook.com/search/top/?q=eventos" target="_blank" class="social-icon__link"><span class="icon-facebook"></span></a>
                    <a href="https://twitter.com/Rubiu5" target="_blank" class="social-icon__link"><span class="icon-twitter"></span></a>
                    <a href="" class="social-icon__link"><span class="icon-mail"></span></a>
                </div>
            </div> 
        </nav>
        <div class="container mt-4">
            <h3>MyM Computer S.A.C</h3>
            <h3>Carrito de <%=Nombre%></h3>
            <input type="hidden" value="<%=ID_Cliente%>" name="ID_Cliente">
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Imagen</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Subtotal</th>
                                <th class="accion">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getCod()}</td>
                                    <td>${car.getNom()}</td>
                                    <td><img src="img/${car.getImagen()}" width="100" height="100"/></td>
                                    <td>${car.getPre()}</td>
                                    <td>
                                        <input type="hidden" id="idprod" value="${car.getCod()}">
                                        <input type="number" id="Cantidad" value="${car.getCan()}" class="form-control text-center" min="1">
                                    </td>
                                    <td>${car.getSubtotal()}</td>
                                    <td>
                                        <input type="hidden" id="idp" value="${car.getCod()}">
                                        <a href="#" class="eli" id="btnDelete">Eliminar</a>
                                    </td>
                                </tr>  
                            </c:forEach>

                        </tbody>
                    </table>

                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal (Soles):</label>
                            <input type="text" value="${totalpagar}" readonly="" class="form-control">
                            <label>Descuento (Soles):</label>
                            <input type="text" value="0.00" readonly="" class="form-control">
                            <label>Total (Soles):</label>
                            <input type="text" value="${totalpagar}" readonly="" class="form-control" name="total">
                        </div>
                        <div class="card-footer">
                            <a href="CestaServlet?op=Pagar" class="btn btn-info">Realizar Pago</a>
                            <a href="CestaServlet?op=GenerarCompra&ID_Cliente=<%=ID_Cliente%>" 
                               onclick="print()" class="btn btn-danger">Generar Compra</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
