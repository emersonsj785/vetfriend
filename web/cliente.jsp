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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Intranet Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta name="author" content="GrupoTF">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="language" content="spanish">
        <meta name="revisit" content="1 day">
        <meta name="robots" content="all">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="css/icons.css"/>
        <link rel="icon" href="img/log.png">

    </head>
    <body>
        <header class="main-header">
            <div class="container container--flex">
                <div class="logo-container column column--50">
                    <div class="logo"><a href="index.html"><img style="width:120px; height:75px;" src="img/log.png" alt="Logo Freevent"/></a></div>
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
                    <li class="menu__item"><a href="cliente.jsp" class="menu__link menu__link--select">Intranet</a></li>
                </ul>
                <div class="social-icon">
                    <a href="https://www.facebook.com/search/top/?q=eventos" target="_blank" class="social-icon__link"><span class="icon-facebook"></span></a>
                    <a href="https://twitter.com/Rubiu5" target="_blank" class="social-icon__link"><span class="icon-twitter"></span></a>
                    <a href="" class="social-icon__link"><span class="icon-mail"></span></a>
                </div>
            </div> 
        </nav>
        <section class="banner">
            <h1><img src="img/banner4.png" width="600" height="600" ></h1>
            <div class="banner__content">INTRANET <br/> 
                <div class="parrafo"><br/>Mantenimiento</div></div>
        </section>
        <main class="main">
            <section class="group group--color">
                <div class="container">
                    <h1>Hola cliente <%=cliente%></h1>
                    <form action="srvUsuario?accion=actualizar" method="post" style="margin: auto; display: table"> 
                        <fieldset>
                            <h2 class="column__title">Si desea actualizar datos presione el boton</h2>
                            <br/>
                            <a class="btn btn-warning" href="actualizar.jsp">
                                Actualizar sus datos
                            </a>
                            <a class="btn btn-warning" href="CestaServlet?op=Carrito">
                                Volver al carrito
                            </a>
                            <a class="btn btn-warning" href="CompraServlet?accion=Historial&ID_Cliente=<%=ID_Cliente%>">
                                Historial de Pedidos
                            </a>
                            <a class="btn btn-warning" href="index.html">
                                Regresar
                            </a>
                        </fieldset>
                    </form>
                    <br/>
                </div>
            </section>
        </main>   
        <footer class="main-footer">
            <div class="container container--flex">
                <div class="column column--33">
                    <h2 class="column__title">¿Por qué visitarnos?</h2>
                    <p class="column__txt">Atendemos a nivel nacional con los mejores precios competitivos del mercado.</p>
                </div>
                <div class="column column--33">
                    <h2 class="column__title">Contáctanos</h2>
                    <p class="column__txt">Jr. Los Alpistes 245 Urb. Los Girasoles</p>
                    <p class="column__txt">Teléfono: 949875183</p>
                    <p class="column__txt">compu-tic@yourwebsite.com</p>
                </div>
                <div class="column column--33">
                    <h2 class="column__title">Síguenos en nuestras redes sociales</h2>
                    <p class="column__txt"><a href="https://www.facebook.com/search/top/?q=eventos" target="_blank" class="icon-facebook">Facebook</a></p>
                    <p class="column__txt"><a href="https://twitter.com/Rubiu5" target="_blank" class="icon-twitter">Síguenos en Twitter</a></p>
                    <p class="column__txt"><a href="" target="_blank" class="icon-youtube">Visita nuestro canal</a></p>
                </div>
                <p class="copy">© 2021 Tecnología a tu alcance | Todos los derechos reservados</p>
            </div>

        </footer>
    </body>

</html>

<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>