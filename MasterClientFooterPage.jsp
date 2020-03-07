<%-- 
    Document   : MasterClientFooterPage
    Created on : 31/10/2019, 08:29:44 AM
    Author     : Cristian_Tisoy
--%>

<%@page import="Logica.AlimentoProcesado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <form method="POST" name="form_admin" action="MasterClientFooterServlet">

        <div class="follow-us-instagram">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="section-heading">
                            <h2>Comidas Chatarra</h2>
                            <span>Tomar buenas decisiones con la comida, son buenas inversiones. -Bethenny Frankel.</span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <div class="instagram-slides owl-carousel">
                            <!-- Single Instagram Slide -->

                            <% List<AlimentoProcesado> lista_alim_proces = (List<AlimentoProcesado>) request.getAttribute("datos_aliment_proc");%>

                            <% if (lista_alim_proces != null) {%>
                            <% int i = 0;%>
                            <c:forEach items="<%=lista_alim_proces%>">
                                <% String ruta_foto = "img/img_bd/" + lista_alim_proces.get(i).img_alimento_proc;%>
                                <div class="single-instagram-slide">
                                    <img src="<%=ruta_foto%>" alt="">
                                    <a href="#"><i class="fa fa-search"></i>Consultar Mas</a>
                                </div>

                                <% i = i + 1;%>

                            </c:forEach>
                            <%}%>

                        </div>
                    </div>
                </div>
            </div>
        </div>







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
