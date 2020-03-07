<%-- 
    Document   : MasterClientHeadPage
    Created on : 31/10/2019, 08:29:02 AM
    Author     : Cristian_Tisoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>

        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Title -->
      
        <!-- Favicon -->
        <link rel="icon" href="img/core-img/ico1.png">
        <!-- Core Stylesheet -->
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>


    <body>
        <!-- ##### Preloader ##### -->
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="circle-preloader">
                <img src="img/core-img/logo1.png" alt="">
                <div  class="foode-preloader">
                    <span></span>
                </div>
            </div>
        </div>


        <!-- ##### Header Area Start ##### -->
        <header class="header-area">

            <!-- Top Header Area -->
            <div class="top-header">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="top-header-content d-flex align-items-center justify-content-between">
                                <!-- Search Form -->
                                <div class="search-form">
                                    <form action="#" method="get">
                                        <input type="search" name="search" class="form-control" placeholder="Buscar...">
                                        <button type="submit"><i class="fa fa-search"></i></button>
                                    </form>
                                </div>

                                <!-- Social Button -->
                                <div class="top-social-info">
                                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a>
                                    <a href="LoginPage.jsp"><i class="" aria-hidden="true"></i>Iniciar Sesion</a>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Logo Area -->
            <div class="logo-area text-center">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <!-- Nav brand -->
                            <a href="index.jsp" class="nav-brand"><img src="img/core-img/logo1.png" alt=""></a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Navbar Area -->
            <div  class="foode-main-menu">
                <div class="classy-nav-container breakpoint-off">
                    <div class="container">
                        <!-- Menu -->
                        <nav class="classy-navbar" id="foodeNav" style="margin-left: -45px;width: 1250px;">

                            <!-- Nav brand -->
                            <a href="index.jsp" class="nav-brand"><img src="img/core-img/logo1.png" alt=""></a>

                            <!-- Navbar Toggler -->
                            <div class="classy-navbar-toggler">
                                <span class="navbarToggler"><span></span><span></span><span></span></span>
                            </div>

                            <!-- Menu -->
                            <div class="classy-menu">

                                <!-- close btn -->
                                <div class="classycloseIcon">
                                    <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                                </div>

                                <!-- Nav Start -->
                                <div class="classynav">
                                    <ul>
                                        <li><a href="IndexServlet">Inicio</a></li>
                                        <li><a href="ContenidoNutricionalServlet">Contenido Nutricional</a></li>
                                        <li><a href="DietaBalanceadaServlet">Dietas Balanceadas</a></li>
                                        <li><a href="RecomendacionServlet">Recomendaciones</a></li>
                                        <li><a href="AlimentoProcesadoServlet">Alimentos Procesados</a></li>
                                    </ul>

                                </div>
                                <!-- Nav End -->
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        
        
        
        
        
    </body>
</html>
