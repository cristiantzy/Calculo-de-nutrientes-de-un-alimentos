<%-- 
    Document   : AgregarMineralesPage
    Created on : 24/10/2019, 02:11:38 PM
    Author     : Cristian_Tisoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <jsp:include page="MasterPageHead.jsp" flush="true" />

    <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
    <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>


    <% String control_registro = (String) request.getAttribute("activador");%>


    <% if (control_registro != null) {%>

    <% if (control_registro == "si") {%>
    <script>
        Swal.fire(
                'Mineral registrado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "no") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'No registrado',
            text: 'Vuelva a completar el formalario!'
        })

    </script>
    <%}%>


    <%}%>

<title>Agregar Minerales | Soft Nutricional</title>
<div class="page-breadcrumb">
    <div class="row">
        <div class="col-12 d-flex no-block align-items-center">
            <h4 class="page-title">Agregar Minerales</h4>
            <div class="ml-auto text-right">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                        <li class="breadcrumb-item"><a href="#">Gestionar Minerales</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Agregar Minerales </li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</div>



<form name="Form1" action="AgregarMineralesServlet" method="POST">
    <div class="container-fluid">
        <div class="col-lg-12">
            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">



                            <div class="form-group row">
                                <label for="inputmineral1" class="col-sm-2 col-form-label">Nombre del Mineral</label>
                                <div class="col-sm-10">
                                    <input type="text" name="txt_nombre" required="" class="form-control" id="inputmineral1" placeholder="nombre.." style="border-color: #4a5560;">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="inputmineral2" class="col-sm-2 col-form-label">Unidad de Medida</label>
                                <div class="col-sm-10">

                                    <input type="text" name="txt_unidad" required="" class="form-control" id="inputmineral2" placeholder="unidad..." style="border-color: #4a5560;">

                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputmineral3" class="col-sm-2 col-form-label">Cantidad Mineral</label>
                                <div class="col-sm-10">

                                    <input type="text" name="txt_cantidad" class="form-control" readonly="true" id="inputmineral3" placeholder="0.0" style="border-color: #4a5560;">

                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputmineral4" class="col-sm-2 col-form-label">Tipo de registro</label>
                                <div class="col-sm-10">

                                    <input type="text" name="txt_base" class="form-control" readonly="true" id="inputmineral4" placeholder="Elemento Base" style="border-color: #4a5560;">

                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="inputmineral5" class="col-sm-2 col-form-label">Estado de registro</label>
                                <div class="col-sm-10">

                                    <input type="text" name="txt_Estado" class="form-control" readonly="true" id="inputmineral5" placeholder="Activo" style="border-color: #4a5560;">

                                </div>
                            </div>

                                <div class="border-top">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="label1" class="col-sm-2 col-form-label"></label>
                                        <div class="col-sm-10">
                                            
                                            <input type="submit" name="btn_agregar" class="btn btn-primary" value="Agregar Mineral">
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>

                </div>
            </div>



        </div>




    </div>


</form>        


<jsp:include page="MasterPageFooter.jsp" flush="true" />
    
    
    
</html>
