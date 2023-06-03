<%@page import="dao.impl.DaoServiciosImpl"%>
<%@page import="dto.Servicios"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <script src="jq/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/servicio.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="css/icons.css"/>
        <link href="css/estiloscat.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <title>Catálogo</title>
    </head>
    <body  style="background: url(img/bannerI.jpg)">
        <header class="main-header" style="background: url(img/banner2.jpg)">
            <div class="container container--flex">
                <div class="logo-container column column--50">
                    <div class="logo"><a href="index.jsp"><img style="width:120px; height:75px;" src="img/logo.jpg.png"/></a></div>
                </div>
                <div class="main-header__contactInfo column column--50">
                    <p class="main-header__contactInfo__phone">
                        <span class="icon-whatsapp">(+51)919512731</span>
                    </p>
                    <p class="main-header__contactInfo__address">
                        <span class="icon-map">Jr. San Damian 15575 - Los Olivos</span>
                    </p>
                </div>
            </div>
        </header>
        <nav class="main-nav">
            <div class="container container--flex">
                <span class="icon-menu" id="btnmenu"></span>
                <ul class="menu" id="menu">
                    <li class="menu__item"><a href="index.jsp" class="menu__link ">Inicio</a></li>
                    <li class="menu__item"><a href="nosotros.html" class="menu__link">Nosotros</a></li>
                    <li class="menu__item"><a href="catalogo.jsp" class="menu__link menu__link--select">Catalogo</a></li>
                    <%-- <li class="menu__item"><a href="cliente.jsp" class="menu__link">Intranet</a></li> --%>
                    <li class="menu__item"><a href="${pageContext.request.contextPath}/Logout" class="menu__link">Salir</a></li>
                    <li class="menu__item"><a href="CestaServlet?op=Carrito" class="menu__link"><i class="fas fa-cart-plus"><label style="color:red ">${contador}</label></i>Carrito</a></li>
                </ul>
                <div class="social-icon">
                    <a href="https://www.facebook.com/search/top/?q=eventos" target="_blank" class="social-icon__link"><span class="icon-facebook"></span></a>
                    <a href="https://twitter.com/Rubiu5" target="_blank" class="social-icon__link"><span class="icon-twitter"></span></a>
                    <a href="" class="social-icon__link"><span class="icon-mail"></span></a>
                </div>
                <div >
                    <form action="Servicios?accion=BSQ" method="post" class="d-flex">
                        <input type="search" class="form-control me-2" placeholder="Ingrese un Servicio..." name="busqueda">
                        <button type="submit" value="Buscar" class="btn btn-info">Buscar</button>
                    </form> 
                </div>
            </div> 
        </nav>
        <h1 style = "color: #ffffff"></h1>
        <br>
        <br>
        <div class="container">
            <h2 style="text-align: center">Catálogo de Servicios</h2>
            <hr>
            <div class="catalogoN">
                <c:forEach var="c" items="${catalogo}">
                    <div class="celda">
                        <img src="img/${c.getImagen()}">
                        <p>${c.getNombre()}</p>
                        <p>${c.getPrecio()}</p>
                        <a href="CestaServlet?op=AgregarCarrito&cod=${c.getIdServicio()}"class="btn btn-primary">Agregar a Carrito</a><br/>
                        <a href="CestaServlet?op=Comprar&cod=${c.getIdServicio()}"class="btn btn-primary">Comprar</a><br/>
                    </div>
                </c:forEach>
            </div>
            <div class="catalogoN">
                <c:forEach var="pe" items="${prodenc}">
                    <div class="celda">
                        <img src="img/${pe.getImagen()}">
                        <p>${pe.getNombre()}</p>
                        <p>${pe.getPrecio()}</p>
                        <a href="CestaServlet?op=AgregarCarrito&cod=${pe.getIdServicio()}"class="btn btn-primary">Agregar a Carrito</a><br/>
                        <a href="CestaServlet?op=Comprar&cod=${pe.getIdServicio()}"class="btn btn-primary">Comprar</a><br/>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br><br><br>
    </body>
</html>
