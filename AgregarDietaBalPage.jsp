<%-- 
    Document   : AgregarDietaBalPage
    Created on : 24/10/2019, 11:03:53 AM
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
                'Dieta registrada!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>
    <% if (control_registro == "no") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'No registrada',
            text: 'Vuelva a completar el formalario!'
        })

    </script>
    <%}%>
    <%}%>

    <title>Agregar Dieta Balanceada | Soft Nutricional</title>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Agregar Dieta Balanceada</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Diet. Balanceada</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Agregar Diet. Balanceada </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>

    <form name="form1"  method="POST" action="AgregarDietaBalServlet"  enctype="multipart/form-data">
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-group row">
                                    <label for="inputvitamina1" class="col-sm-2 col-form-label">Nombre</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="txt_nombre" required="" class="form-control" id="inputvitamina1" placeholder="Name" style="border-color: #4a5560;">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="cono1" class="col-sm-2 col-form-label">Descripcion</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" name="txt_descrip" style="border-color: #4a5560;" placeholder="Description"></textarea>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-md-2">Subir Imagen</label>
                                    <div class="col-md-5">
                                        <input type="file" name="txt_img" onchange="cargarArchivo(this)" class="form-control-file" style="border-color: #4a5560;" accept="image/*">
                                    </div>
                                </div>
                                <div class="border-top">
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label for="label1" class="col-sm-2 col-form-label"></label>
                                            <div class="col-sm-10">
                                                <input type="submit" name="btn_agregar" class="btn btn-primary" value="Agregar Dieta Balanceada">
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
        <input type="hidden" name="nombre" value="">
    </form>        
    <jsp:include page="MasterPageFooter.jsp" flush="true" />
    
    <script>
        function cargarArchivo(elemento) {
            var file = elemento.files[0];
            var objHidden = document.form1.nombre;
            objHidden.value = file.name;
             return;
        }
    </script>

</html>
