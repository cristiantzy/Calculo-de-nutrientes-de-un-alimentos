<%-- 
    Document   : RecomendacionPage
    Created on : 10/11/2019, 11:11:30 PM
    Author     : Cristian_Tisoy
--%>
<%@page import="Logica.Recomendacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <title>Recomendaciones | Soft - Nutricional</title>
    <jsp:include page="MasterClientHeadPage.jsp" flush="true" />
    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <img src="img/core-img/breadcrumb-line.png" alt="">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.jsp"><i class="fa fa-home"></i> Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Recomendaciones</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Google Maps Start ##### -->
    <div class="map-area" style="margin-top: 55px;">
    </div>
    <!-- ##### Google Maps End ##### -->
    <form name="Form1" method="POST" action="RecomendacionServlet">
        <!-- ##### Contact Area Start ##### -->
        <section class="contact-area">
            <div class="container">
                <div class="row">
                    <div class="contact-content-area">
                        <!-- Contact Form Area -->
                        <div class="container" style="margin-top: -60px;">
                            <div class="row justify-content-center">
                                <div class="col-12 col-lg-10" style="height: 40px;">
                                    <div class="section-heading">
                                        <h2>Recomendaciones</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="card-deck">
                                    <div class="row">
                                        <% List<Recomendacion> lista_recomendacion = (List<Recomendacion>) request.getAttribute("datos_recomendacion");%>
                                        <% if (lista_recomendacion != null) {%>
                                        <% int i = 0;%>
                                        <c:forEach items="<%=lista_recomendacion%>">
                                            <% String ruta_foto = "img/img_bd/" + lista_recomendacion.get(i).img_recomendacion;%>
                                            <div class="col-12 col-md-6" style="margin-top: 11px;">
                                                <div class="card">
                                                    <img src="<%=ruta_foto%>" class="card-img-top" alt="...">
                                                    <div class="card-body">
                                                        <h5 class="card-title"><c:out value="<%=lista_recomendacion.get(i).nombre_recomendacion%>"/></h5>
                                                        <p class="card-text">
                                                        <c:out value="<%=lista_recomendacion.get(i).descrip_recomendacion%>"/>
                                                        </p>
                                                    </div>
                                                    <div class="card-footer">
                                                        <small class="text-muted">Última actualización hace 3 minutos</small>
                                                    </div>
                                                </div>
                                            </div>
                                            <% i = i + 1;%>
                                        </c:forEach>
                                        <%}%>
                                    </div>
                                </div>
                            </div>
                            <!-- Contact END Form Area -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer class="footer-area">
            <div class="container">
                <div class="row">
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="copywrite-text">
                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los derechos reservados | <a href="#" target="_blank">Cristian Tisoy Hurtado</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer> 
    </form>                                                      
    <!-- ##### All Javascript Script ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js" type="text/javascript"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js" type="text/javascript"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js" type="text/javascript"></script>
    <!-- Active js -->
    <script src="js/active.js" type="text/javascript"></script>
</body>
</html>
