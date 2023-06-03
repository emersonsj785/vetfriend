

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Compu-Tic</title>
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
                    <li class="menu__item"><a href="/" class="menu__link menu__link--select">Inicio</a></li>
                    <li class="menu__item"><a href="nosotros.html" class="menu__link ">Nosotros</a></li>
                    <li class="menu__item"><a href="catalogo.jsp" class="menu__link">Catalogo</a></li>
                    <li class="menu__item"><a href="${pageContext.request.contextPath}/Logout" class="menu__link">Salir</a></li> 
                </ul>
                <div class="social-icon">
                    <a href="https://www.facebook.com/search/top/?q=eventos" target="_blank" class="social-icon__link"><span class="icon-facebook"></span></a>
                    <a href="https://twitter.com/Rubiu5" target="_blank" class="social-icon__link"><span class="icon-twitter"></span></a>
                    <a href="" class="social-icon__link"><span class="icon-mail"></span></a>
                </div>
            </div> 
        </nav>

        <section class="banner">
            <img src="img/banner1.png" alt="banner" class="banner__img">
            <div class="banner__content">Los mejores accesorios <br/>para tu pc gamer 
                <div class="parrafo"><br/>CON MÁS DE 10 AÑOS ATENDIENDO A LOS GAMER DEL PERÚ</div></div>

        </section>

       

        <main class="main">
            <section class="group group--color">
                <div class="container">
                    <h2 class="main__title">¿Por qué Compu-Tic?</h2>
                    <p class="main__txt">Venta de computadoras y accesorios</p>
                </div>
            </section>

            <section class="main__about__description">
                <div class="container container--flex">
                    <div class="column column--50">
                        <img src="img/im1.jpg" alt="">
                    </div>
                    <div class="column column--50">
                        <h3 class="column__title">Responsabilidad</h3>
                        <p class="column__txt">¡Todos tus productos hasta la puerta de tu casa, con los debidos protocolos que manda el Ministerio de Salud.</p>

                    </div>
                </div>
            </section>
            <section class="main__about__description">
                <div class="container container--flex">
                    <div class="column column--50">
                        <img src="img/im2.jpg" alt="">
                    </div>
                    <div class="column column--50">
                        <h3 class="column__title">Competitividad</h3>
                        <p class="column__txt">Manejamos los mejores precios del mercado debido a nuestra importación a gran escala que nos permite brindar los mejores descuentos y regalos para ti.</p>

                    </div>

                </div>
            </section>
            <section class="main__about__description">
                <div class="container container--flex">
                    <div class="column column--50">
                        <img src="img/im3.jpg" alt="">
                    </div>
                    <div class="column column--50">
                        <h3 class="column__title">Tecnología</h3>
                        <p class="column__txt">Contamos con stock de las mejoras marcas a nivel mundial, garantizamos computadores, laptos y accesorios de calidad y garantía extendida.</p>

                    </div>
                </div>
            </section>

            <section class="group today-special">
                <h2 class="group__title"><strong class="negrita">Nuestros</strong> Representantes</h2>
                <div class="container container--flex">
                    <div class="column column--50-25">
                        <img src="img/pj1.jpg" alt="" class="today-special__img">
                        <div class="today-special__title">Paolo Dibala<br/><div class="cursiva">Gerente de ventas</div></div>
                        <a href="" class="btn btn--ver" onclick="alert('Nuestros servicios estaran disponibles las 24 horas')">Telf: 936397927</a>
                    </div>
                    <div class="column column--50-25">
                        <img src="img/pj2.jpg" alt="" class="today-special__img">
                        <div class="today-special__title">Cristian Perez<br/><div class="cursiva">Distribuidor</div></div>
                        <a href="" class="btn btn--ver" onclick="alert('Nuestros servicios estaran disponibles las 24 horas')">Telf: 977152703</a>
                    </div>
                    <div class="column column--50-25">
                        <img src="img/pj3.jpg" alt="" class="today-special__img">
                        <div class="today-special__title">Susana Chavez<br/><div class="cursiva">Asesora de ventas</div></div>
                        <a href="" class="btn btn--ver" onclick="alert('Nuestros servicios estaran disponibles las 24 horas')">Telf: 976566403</a>
                    </div>
                    <div class="column column--50-25">
                        <img src="img/pj4.jpg" alt="" class="today-special__img">
                        <div class="today-special__title">Diana Macalopu<br/><div class="cursiva">Asesora de ventas</div></div>
                        <a href="" class="btn btn--ver" onclick="alert('Nuestros servicios estaran disponibles las 24 horas')">Telf: 968756321</a>
                    </div>
                </div> 
            </section>


       
            
        </main>   
        <!--Footer-->    
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

        <script src="js/menu.js"></script>
        
    </body>
</html>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>