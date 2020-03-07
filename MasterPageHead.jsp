<%-- 
    Document   : MasterPageHead
    Created on : 11/10/2019, 05:31:51 PM
    Author     : Cristian_Tisoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">



        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="img/core-img/ico1.png">



        <!-- Custom CSS -->
        <link href="assets/libs/flot/css/float-chart.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="dist/css/style.min.css" rel="stylesheet">




    </head>
    <body>
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <div id="main-wrapper">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
           

                <header class="topbar" data-navbarbg="skin5">
                    <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                        <div class="navbar-header" data-logobg="skin5">
                            <!-- This is for the sidebar toggle which is visible on mobile only -->
                            <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                            <!-- ============================================================== -->
                            <!-- Logo -->
                            <!-- ============================================================== -->
                            <a class="navbar-brand" href="AdminPage.jsp">
                                <!-- Logo icon -->
                                <b class="logo-icon p-l-10">
                                    <img src="img/core-img/logo-icon.png" alt="Soft - " class="light-logo" />

                                </b>
                                <span class="logo-text">
                                    <!-- dark Logo text -->
                                    <img src="img/core-img/icon_txt1.png" alt="Nutricional" class="light-logo" />
                                </span>
                                <!-- Logo icon -->

                            </a>
                            <!-- ============================================================== -->
                            <a class="topbartoggler d-block d-md-none waves-effect waves-light" href="javascript:void(0)" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i class="ti-more"></i></a>
                        </div>
                        <!-- ============================================================== -->
                        <!-- End Logo -->
                        <!-- ============================================================== -->
                        <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                            <ul class="navbar-nav float-left mr-auto">
                                <li class="nav-item d-none d-md-block">

                                    <a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar">
                                        <i class="mdi mdi-menu font-24"></i></a></li>

                            </ul>


                            <ul class="navbar-nav float-right">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="ti-user m-r-5 m-l-5"></i>  Administrador</a>
                                    <div class="dropdown-menu dropdown-menu-right user-dd animated">

                                        <div class="dropdown-divider" style="border-top: 1px solid #8b9299;"></div>
                                        <a class="dropdown-item" href="IndexServlet"><i class="fa fa-power-off m-r-5 m-l-5"></i>  Cerrar Sesión</a>
                                        <div class="dropdown-divider" style="border-top: 1px solid #8b9299;"></div>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </nav>
                </header>

           


            <aside class="left-sidebar" data-sidebarbg="skin5">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav" class="p-t-30">
                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-account-settings-variant"></i><span class="hide-menu">Gestionar Usuario</span></a>
                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li class="sidebar-item"><a href="AgregarUsuarioPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Usuario</span></a></li>
                                    <li class="sidebar-item"><a href="ModificarUsuarioServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Usuario</span></a></li>
                                    <li class="sidebar-item"><a href="ConsultarUsuarioServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Usuario</span></a></li>
                                </ul>
                            </li>
                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-chart-bubble"></i><span class="hide-menu">Gestionar Producto</span></a>
                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li class="sidebar-item"><a href="AgregarProductoServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Producto</span></a></li>
                                    <li class="sidebar-item"><a href="ConsultarProductoServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Producto</span></a></li>
                                    <li class="sidebar-item"><a href="ModificarProductoServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Producto</span></a></li>
                                </ul>
                            </li>



                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span class="hide-menu">Gestionar Diet. Balanceada</span></a>
                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li class="sidebar-item"><a href="AgregarDietaBalPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Diet. Balanceada</span></a></li>
                                    <li class="sidebar-item"><a href="ConsultarDietaBalServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Diet. Balanceada</span></a></li>
                                    <li class="sidebar-item"><a href="ModificarDietaBalServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Diet. Balanceada</span></a></li>
                                </ul>
                            </li>



                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-shape-square-plus"></i><span class="hide-menu">Alimentos Procesados</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li class="sidebar-item"><a href="AgregarAlimentoProcPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar </span></a></li>
                                    <li class="sidebar-item"><a href="ConsultarAlimentoProcServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar</span></a></li>
                                    <li class="sidebar-item"><a href="ModificarAlimentoProcServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar</span></a></li>
                                </ul>
                            </li>
                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-thumb-down-outline"></i><span class="hide-menu">Gest. Recomendaciones</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li class="sidebar-item"><a href="AgregarRecomendacionesPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Recomendación </span></a></li>
                                    <li class="sidebar-item"><a href="ConsultarRecomendacionesServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Recomendaciones</span></a></li>
                                    <li class="sidebar-item"><a href="ModificarRecomendacionesServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Recomendación</span></a></li>
                                </ul>
                            </li>

                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-tag-text-outline"></i><span class="hide-menu">Gestionar Vitaminas</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li  class="sidebar-item"><a href="AgregarVitaminaPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Vitaminas</span></a></li>
                                    <li  class="sidebar-item"><a href="ConsultarVitaminaServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Vitaminas</span></a></li>
                                    <li  class="sidebar-item"><a href="ModificarVitaminaServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Vitaminas</span></a></li>
                                </ul>
                            </li>

                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-bug"></i><span class="hide-menu">Gestionar Macronutriente</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li  class="sidebar-item"><a href="AgregarMacronutrientePage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Macronutriente</span></a></li>
                                    <li  class="sidebar-item"><a href="ConsultarMacronutienteServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Macronutriente</span></a></li>
                                    <li  class="sidebar-item"><a href="ModificarMacronutrienteServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Macronutriente</span></a></li>
                                </ul>
                            </li>
                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-clipboard-flow"></i><span class="hide-menu">Gestionar Minerales</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li  class="sidebar-item"><a href="AgregarMineralesPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Minerales</span></a></li>
                                    <li  class="sidebar-item"><a href="ConsultarMineralesServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Minerales</span></a></li>
                                    <li  class="sidebar-item"><a href="ModificarMineralesServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Minerales</span></a></li>
                                </ul>
                            </li>

                            <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-cow"></i><span class="hide-menu">Gestionar Grasas</span></a>

                                <ul aria-expanded="false" class="collapse  first-level">
                                    <li  class="sidebar-item"><a href="AgregarGrasasPage.jsp" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Agregar Grasas</span></a></li>
                                    <li  class="sidebar-item"><a href="ConsultarGrasasServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Consultar Grasas</span></a></li>
                                    <li  class="sidebar-item"><a href="ModificarGrasasServlet" class="sidebar-link"><i class="mdi mdi-check-all"></i><span class="hide-menu">Modificar Grasas</span></a></li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </aside>
            <!-- ============================================================== -->
            <!-- End Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page wrapper  -->
            <!-- ============================================================== -->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->



                </html>
