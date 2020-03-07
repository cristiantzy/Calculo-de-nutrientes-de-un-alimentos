<%-- 
    Document   : AdminPage
    Created on : 6/10/2019, 01:13:41 AM
    Author     : Cristian_Tisoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="MasterPageHead.jsp" flush="true" />

    <title>Inicio | Soft Nutricional</title>

    <form method="POST" name="form_admin" action="AdminServlet">


        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-12 d-flex no-block align-items-center">
                    <h4 class="page-title">Inicio</h4>
                    <div class="ml-auto text-right">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item active"><a href="#"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>

                            </ol> 
                        </nav>
                    </div>
                </div>
            </div>
        </div>




        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">

                    <div class="col-md-12">

                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">

                                    <img src="img/banner3.jpg" alt="foto1" width="1200" height="330"/>
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>Actualice lo datos de Nutricion</h5>
                                        <p>usted podra actulizar los diferentes 
                                            campos de del soft-nutricional
                                        </p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="img/banner2.jpg" alt="" width="1200" height="330"/>
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>Agregue Nuevo Nutrientes</h5>
                                        <p>Atravez de la interfaz alimentos, agregue las 
                                            los diferentes nutrientes
                                        </p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="img/banner1.jpg" alt="" width="1200" height="330"/>
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>Muestre las Mejores Dietas</h5>
                                        <p>Usted puede mostrar las diferetes dietas, mas
                                            consultadas
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Anterior</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Siguiente</span>
                            </a>
                        </div>

                    </div>


                    <div id="ver" style="margin-top: 363px;">
                    </div>        
                    <div class="col-md-6 col-lg-2 col-xlg-3">
                        <div class="card card-hover">
                            <div class="box bg-cyan text-center">
                                <h1 class="font-light text-white"><i class="mdi mdi-view-dashboard"></i></h1>
                                <h6 class="text-white"><a href="AdminPage.jsp" style="color: white !important;" class="sidebar-link">Inicio</a></h6>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-4 col-xlg-3">
                        <div class="card card-hover">
                            <div class="box bg-success text-center">
                                <h1 class="font-light text-white"><i class="mdi mdi-chart-areaspline"></i></h1>
                                <h6 class="text-white"><a href="ConsultarProductoServlet" style="color: white !important;" class="sidebar-link">Productos</a></h6>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <div class="col-md-6 col-lg-2 col-xlg-3">
                        <div class="card card-hover">
                            <div class="box bg-warning text-center">
                                <h1 class="font-light text-white"><i class="mdi mdi-collage"></i></h1>
                                <h6 class="text-white"><a href="ConsultarVitaminaServlet" style="color: white !important;" class="sidebar-link">Vitaminas</a></h6>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <div class="col-md-6 col-lg-2 col-xlg-3">
                        <div class="card card-hover">
                            <div class="box bg-danger text-center">
                                <h1 class="font-light text-white"><i class="mdi mdi-border-outside"></i></h1>
                                <h6 class="text-white"><a href="ConsultarMineralesServlet" style="color: white !important;" class="sidebar-link">Minerales</a></h6>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <div class="col-md-6 col-lg-2 col-xlg-3">
                        <div class="card card-hover">
                            <div class="box bg-info text-center">
                                <h1 class="font-light text-white"><i class="mdi mdi-arrow-all"></i></h1>
                                <h6 class="text-white"><a href="ConsultarGrasasServlet" style="color: white !important;" class="sidebar-link">Grasas</a></h6>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>


    </form>        

    <jsp:include page="MasterPageFooter.jsp" flush="true" />

</html>
