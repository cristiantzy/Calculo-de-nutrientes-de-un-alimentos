<%-- 
    Document   : AgregarGrasasPage
    Created on : 24/10/2019, 02:17:17 PM
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
                'Grasa registrada!',
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

    <title>Agregar Grasas | Soft Nutricional</title>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Agregar Grasas</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Grasas</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Agregar Grasas </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>



    <form name="Form1" action="AgregarrGrasasServlet" method="POST">
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">



                                <div class="form-group row">
                                    <label for="inputgrasa1" class="col-sm-2 col-form-label">Tipo de Vitamina</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="txt_nombre" required="" class="form-control" id="inputgrasa1" placeholder="nombre.." style="border-color: #4a5560;">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputgrasa2" class="col-sm-2 col-form-label">Unidad de Medida</label>
                                    <div class="col-sm-10">

                                        <input type="text" name="txt_unidad" required="" class="form-control" id="inputgrasa2" placeholder="unidad..." style="border-color: #4a5560;">

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputgrasa3" class="col-sm-2 col-form-label">Cantidad Vitamina</label>
                                    <div class="col-sm-10">

                                        <input type="text" name="txt_cantidad" class="form-control" readonly="true" id="inputgrasa3" placeholder="0.0" style="border-color: #4a5560;">

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputgrasa4" class="col-sm-2 col-form-label">Tipo de registro</label>
                                    <div class="col-sm-10">

                                        <input type="text" name="txt_base" class="form-control" readonly="true" id="inputgrasa4" placeholder="Elemento Base" style="border-color: #4a5560;">

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputgrasa5" class="col-sm-2 col-form-label">Estado de registro</label>
                                    <div class="col-sm-10">

                                        <input type="text" name="txt_Estado" class="form-control" readonly="true" id="inputgrasa5" placeholder="Activo" style="border-color: #4a5560;">

                                    </div>
                                </div>

                                <div class="border-top">
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label for="label1" class="col-sm-2 col-form-label"></label>
                                            <div class="col-sm-10">

                                                <input type="submit" name="btn_agregar" class="btn btn-primary" value="Agregar Grasa">
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
