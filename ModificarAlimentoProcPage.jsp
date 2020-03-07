<%-- 
    Document   : ModificarAlimentoProcPage
    Created on : 24/10/2019, 11:20:03 AM
    Author     : Cristian_Tisoy
--%>

<%@page import="Logica.AlimentoProcesado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>


    <jsp:include page="MasterPageHead.jsp" flush="true" />


    <link href="assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
    <link href="assets/libs/select2/dist/css/select2.min.css" rel="stylesheet" type="text/css"/>

    <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
    <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

    <title>Modificar | Soft Nutricional</title>

    <% String control_registro = (String) request.getAttribute("activador");%>


    <% if (control_registro != null) {%>

    <% if (control_registro == "si") {%>
    <script>
        Swal.fire(
                'Alimento Proc. Actualizado!',
                'todo esta bien!',
                'success'
                )


    </script>
    <%}%>
    <% if (control_registro == "foto_update") {%>
    <script>
        Swal.fire(
                'Foto Actualizada!',
                'todo esta bien!',
                'success'
                )


    </script>
    <%}%>





    <% if (control_registro == "no") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'Algo esta mal',
            text: 'Vuelva a realizar la peticion!'
        })

    </script>
    <%}%>

    <% if (control_registro == "no_foto_update") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'Foto NO Actualizada!',
            text: 'Vuelva a realizar la peticion!'
        })
    </script>
    <%}%>

    <%}%>


    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Modificar</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Alimentos Procesados</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Modificar </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>


    <form name="form1" method="POST" action="ModificarAlimentoProcServlet" enctype="multipart/form-data"  >
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Lista Alimentos Procesados</h5>
                                <div class="form-group row">
                                    <div class="col-md-10">
                                        <% List<AlimentoProcesado> lista_alimentoProc1 = (List<AlimentoProcesado>) request.getAttribute("lista_combox");%>
                                        <select  name="listado_alimento_proc" class="select2 form-control custom-select" style="width: 100%; height:36px;">
                                            <option value="0"> -- Selecccione -- </option>
                                            <% if (lista_alimentoProc1 != null) {%>
                                            <% int i = 0;%>
                                            <c:forEach items="<%=lista_alimentoProc1%>" var="alim_procesado" >
                                                <option value="<%=lista_alimentoProc1.get(i).id_alimentoProcesado%>"><%=lista_alimentoProc1.get(i).nombre_alimento_proc%></option>
                                                <% i = i + 1;%>
                                            </c:forEach>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="col-md-2">
                                        <button type="submit" name="btn_consultar"  class="btn btn-info btn-sm">Modificar</button>
                                    </div>
                                </div>


                                <% AlimentoProcesado aux_alimento_proc = (AlimentoProcesado) request.getAttribute("datos_dieta");%>

                                <% int aux_codigo = 0; %>
                                <% String aux_nom = ""; %>
                                <% String aux_descrip = ""; %>
                                
                                <% if (aux_alimento_proc != null) {%>
                                <% aux_codigo = aux_alimento_proc.id_alimentoProcesado;  %>
                                <% aux_nom = aux_alimento_proc.nombre_alimento_proc; %>
                                <% aux_descrip = aux_alimento_proc.descripcion_alimento_proc; %>
                                <%}%>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Codigo</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input  type="text" value="<%=aux_codigo%>" name="txt_id" readonly="true" style="border-color: #4a5560;"  class="form-control" id="inlineFormInputGroupUsername2" placeholder="Codigo">
                                        </div>
                                    </div>


                                    <div class="form-group col-md-6">
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Nombre</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input type="text" value="<%=aux_nom%>" name="txt_nombre_mod" class="form-control" style="border-color: #4a5560;" id="inlineFormInputGroupUsername2" placeholder="Nombre">
                                        </div>
                                    </div>

                                </div>


                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Descripcion</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <textarea class="form-control" rows="9"   name="txt_descrip" style="border-color: #4a5560;" placeholder="Description"><%=aux_descrip%></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group col-md-6">

                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Foto</label>
                                        <div class="input-group mb-2 mr-sm-2">

                                            <% if (aux_alimento_proc != null) {%>
                                            
                                            <% String ruta_foto = "img/img_bd/" + aux_alimento_proc.img_alimento_proc;%>
                                            <img src="<%=ruta_foto%>" alt="Sin Foto..." class="img-fluid" width="550" style="height: 220px !important;">

                                            <%}%>
                                            <% if (aux_alimento_proc == null) {%>
                                            <img src="..." alt="Sin Foto..." width="550" style="height: 220px !important"/>
                                            <%}%>
                                        </div>
                                        <button type="button" name="btn_modificar_foto" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">Cambiar Foto</button>

                                    </div>

                                </div>

                                <div class="form-row">

                                </div>
                                <div class="modal-footer">
                                    <button type="submit" name="btn_modificar" class="btn btn-info">Guardar Cambios</button>
                                </div>

                                <hr>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th style="text-align:center; width: 10px !important;"><strong>Codigo</strong></th>
                                                <th style="text-align:center;"><strong>Nombre</strong></th>
                                                <th style="text-align:center;"><strong>Descripcion</strong></th>
                                                <th style="text-align:center;  width: 28px !important; "><strong>Imagen</strong></th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <% List<AlimentoProcesado> lista_alimento_pro = (List<AlimentoProcesado>) request.getAttribute("lista_datos_tabla");%>
                                            <% if (lista_alimento_pro != null) {%>
                                            <% String nombre_page = "alimento_proc"; %>

                                            <% int i = 0;%>
                                            <c:forEach items="<%=lista_alimento_pro%>" var="alimento_pro" >
                                                <tr>
                                                    <td style="text-align:center;"><c:out value="<%=lista_alimento_pro.get(i).id_alimentoProcesado%>"/></td>
                                                    <td><c:out value="<%=lista_alimento_pro.get(i).nombre_alimento_proc%>"/></td>
                                                    <td style="text-align:center;"><c:out value="<%=lista_alimento_pro.get(i).descripcion_alimento_proc%>"/></td>
                                                    <% String ruta_foto = "img/img_bd/" + lista_alimento_pro.get(i).img_alimento_proc;%>
                                                    <td style="text-align:center;"><img src="<%=ruta_foto%>" alt="" width="100" height="100" /></td>

                                                </tr>
                                                <% i = i + 1;%>
                                            </c:forEach>
                                            <%}%>


                                        </tbody>

                                    </table>
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
                        <h5 class="modal-title" id="exampleModalLabel">Actualizar Foto</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label" style="margin-top: -5px;">Nueva Foto</label>
                            <div class="col-sm-8">
                                <label class="sr-only"  for="inlineFormInputGroup">NuevaFoto</label>
                                <div class="input-group mb-9">

                                    <input type="file" name="txt_img" onchange="cargarArchivo(this)" class="form-control-file" style="border-color: #4a5560;" accept="image/*">

                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="submit" name="btn_actualizar_foto" class="btn btn-primary">Actualizar Foto</button>
                    </div>
                </div>
            </div>
        </div>            
        <input type="hidden" name="nombre" value="">
    </form>        

    <jsp:include page="MasterPageFooter.jsp" flush="true" /> 

    <script src="assets/extra-libs/DataTables/datatables.min.js" type="text/javascript"></script>

    <script src="assets/libs/select2/dist/js/select2.min.js" type="text/javascript"></script>


    <script>
          $('#zero_config').DataTable();
    </script>


    <script>
        $(".select2").select2();

    </script>

    <script>
        function cargarArchivo(elemento) {
            var file = elemento.files[0];
            var objHidden = document.form1.nombre;
            objHidden.value = file.name;
            return;
        }
    </script>


</html>
