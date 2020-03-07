<%-- 
    Document   : ModificarUsuarioPage
    Created on : 19/02/2020, 10:11:16 AM
    Author     : Cristian_Tisoy
--%>


<%@page import="Logica.Usuario"%>
<%@page import="Logica.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="MasterPageHead.jsp" flush="true" />
 <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
    <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>



    <% String control_update = (String) request.getAttribute("estado_password");%>


    <% if (control_update != null) {%>

    <% if (control_update == "si") {%>
    <script>
        Swal.fire(
                'Datos Actualizados!',
                'todo esta bien!',
                'success'
                )


    </script>
    <%}%>

    <% if (control_update == "full_p") {%>
    <script>
        Swal.fire(
                'Contraseña Actualizada!',
                'todo esta bien!',
                'success'
                )


    </script>
    <%}%>

    <% if (control_update == "no") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'Datos NO guardados',
            text: 'Vuelva a completar el formalario!'
        })

    </script>
    <%}%>
    <% if (control_update == "error_p") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'Error en Contraseñas',
            text: 'Las contraseñas NO son Iguales!'
        })

    </script>
    <%}%>

    <%}%>



    <title>Modificar Usuario | Soft Nutricional</title>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Modificar Usuario</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Usuario</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Modificar Usuario </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>


    <form name="Form1" method="POST" action="ModificarUsuarioServlet" >
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">

                                <% String nombre = "";%>
                                <% String apellidos = "";%>
                                <% String usuario = "Usuario";%>
                                <% String passw = "holamundo";%>
                                <% Administrador datos_admin = (Administrador) request.getAttribute("date_admin") ;%>
                                <% Usuario datos_usuario = (Usuario) request.getAttribute("date_user") ;%>
                                <% if (datos_admin != null) {%>
                                <%  nombre = datos_admin.nombre_admin;%>
                                <%  apellidos = datos_admin.apellido_admin;%>
                                <% usuario = datos_usuario.user_u;%>
                                <%  passw = datos_usuario.password_u;%>
                                <%}%>
                                
                                
                                
                                
                                
                                <div class="form-group row">
                                    <label for="inputadmin1" class="col-sm-2 col-form-label">Nombre</label>
                                    <div class="col-sm-10">
                                        <input type="text" placeholder="Name" name="txt_nombre" value="<%=nombre%>" required class="form-control"  id="inputadmin1"  style="border-color: #4a5560;">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputadmin2" class="col-sm-2 col-form-label">Apellidos</label>
                                    <div class="col-sm-10">

                                        <input type="text" required placeholder="Last Name" name="txt_apellido" value="<%=apellidos%>" required="" class="form-control"  id="inputadmin2"  style="border-color: #4a5560;">

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputadmin3" class="col-sm-2 col-form-label">Usuario</label>
                                    <div class="col-sm-10">

                                        <input type="text" name="txt_usuario" required placeholder="User" value="<%=usuario%>" class="form-control" id="inputadmin3"  style="border-color: #4a5560;">

                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputadmin4" class="col-sm-2 col-form-label">Contraseña</label>
                                    <div class="col-sm-8">

                                        <input type="password" name="txt_password" value="<%=passw%>" class="form-control" readonly="true" id="inputadmin4"  style="border-color: #4a5560;">

                                    </div>

                                    <div class="col-md-2">
                                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">Cambiar</button>
                                    </div>
                                </div>







                                <div class="border-top">
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label for="label1" class="col-sm-2 col-form-label"></label>
                                            <div class="col-sm-10">

                                                <input type="submit" name="btn_modificar" class="btn btn-primary" value="Guardar Cambios">
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

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Actualizar Contraseña</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">




                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-4 col-form-label">Contraseña Actual</label>
                            <div class="col-sm-8">
                                <label class="sr-only"  for="inlineFormInputGroup">Username</label>
                                <div class="input-group mb-8">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                    </div>
                                    <input type="password" name="txt_password" class="form-control" style="border-color: #4a5560;" id="inlineFormInputGroup" placeholder="Password">
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-4 col-form-label">Nueva Contraseña</label>
                            <div class="col-sm-8">
                                <label class="sr-only"  for="inlineFormInputGroup">Username</label>
                                <div class="input-group mb-8">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                    </div>
                                    <input type="password" name="txt_new_password" class="form-control" style="border-color: #4a5560;" id="inlineFormInputGroup" placeholder="New Password">
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-4 col-form-label">Confirmar Contraseña</label>
                            <div class="col-sm-8">
                                <label class="sr-only"  for="inlineFormInputGroup">Username</label>
                                <div class="input-group mb-8">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                    </div>
                                    <input type="password" name="txt_confir_password" class="form-control" style="border-color: #4a5560;" id="inlineFormInputGroup" placeholder="Confirm Password">
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="submit" name="btn_actualizar_password" class="btn btn-primary">Actualizar Contraseña</button>
                    </div>
                </div>
            </div>
        </div>            



    </form>        









    <jsp:include page="MasterPageFooter.jsp" flush="true" /> 
</html>
