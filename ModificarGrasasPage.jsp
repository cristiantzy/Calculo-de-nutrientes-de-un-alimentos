<%-- 
    Document   : ModificarGrasasPage
    Created on : 24/10/2019, 02:27:35 PM
    Author     : Cristian_Tisoy
--%>

<%@page import="Logica.Grasa"%>
<%@page import="Logica.Grasa"%>
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

    <title>Modificar Vitaminas | Soft Nutricional</title>

    <% String control_registro = (String) request.getAttribute("activador");%>


    <% if (control_registro != null) {%>

    <% if (control_registro == "si") {%>
    <script>
        Swal.fire(
                'Grasa Actualizada!',
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

    <%}%>

    
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Modificar Grasas</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Grasas</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Modificar Grasas </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>


    <form name="Form1" method="POST" action="ModificarGrasasServlet" >


        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">

                                <h5 class="card-title">Lista Grasas</h5>
                                
                                <div class="form-group row">
                                    
                                    
                                    <div class="col-md-10">

                                        <% List<Grasa> lista_grasa1 = (List<Grasa>) request.getAttribute("listado_grasa1");%>



                                        <select  name="listado_grasas" class="select2 form-control custom-select" style="width: 100%; height:36px;">
                                            <option value="0"> -- Selecccione -- </option>
                                            <% if (lista_grasa1 != null) {%>
                                            <% int i = 0;%>

                                            <c:forEach items="<%=lista_grasa1%>" var="vitamina" >

                                                <option value="<%=lista_grasa1.get(i).id_grasa%>"><%=lista_grasa1.get(i).nombre_grasa%></option>


                                                <% i = i + 1;%>
                                            </c:forEach>
                                            <%}%>


                                        </select>

                                    </div>
                                    <div class="col-md-2">
                                        <button type="submit" name="btn_consultar"  class="btn btn-info btn-sm">Modificar</button>
                                    </div>
                                </div>


                                <% Grasa aux_grasa = (Grasa) request.getAttribute("lista_grasa2");%>

                                <% int aux_codigo = 0; %>
                                <% String aux_nom = ""; %>
                                <% String aux_unidad = ""; %>

                                <% if (aux_grasa != null) {%>
                                <% aux_codigo = aux_grasa.id_grasa;  %>
                                <% aux_nom = aux_grasa.nombre_grasa; %>
                                <% aux_unidad = aux_grasa.unid_medida_grasa; %>
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
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Unidad de medida</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input type="text" value="<%=aux_unidad%>" name="txt_unidad_mod" style="border-color: #4a5560;" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Unidad de medidad">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Cantidad</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input type="text" value="0.0" readonly="true" style="border-color: #4a5560;" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Cantidad">
                                        </div>
                                    </div>

                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Registro base</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input type="text" class="form-control"  style="border-color: #4a5560;" value="B" readonly="true" id="inlineFormInputGroupUsername2" placeholder="Registro base">
                                        </div>


                                    </div>
                                    <div class="form-group col-md-6">

                                        <label class="sr-only" for="inlineFormInputGroupUsername2">Estado</label>
                                        <div class="input-group mb-2 mr-sm-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text" style="border-color: #4a5560;">@</div>
                                            </div>
                                            <input type="text" class="form-control" style="border-color: #4a5560;" value="A" readonly="true" id="inlineFormInputGroupUsername2" placeholder="Estado">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" name="btn_modificar" class="btn btn-info">Guardar Cambios</button>
                                </div>

                                <hr>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th style="text-align:center;"><strong>Codigo</strong></th>
                                                <th style="text-align:center;"><strong>Tipo</strong></th>
                                                <th style="text-align:center;"><strong>Unidad de Medida</strong></th>
                                                <th style="text-align:center;"><strong>Estado</strong></th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <% List<Grasa> lista_grasa = (List<Grasa>) request.getAttribute("lista_grasa3");%>
                                            <% if (lista_grasa != null) {%>
                                            <% int i = 0;%>
                                            <c:forEach items="<%=lista_grasa%>" var="grasaas" >
                                                <tr>
                                                    <td style="text-align:center;"><c:out value="<%=lista_grasa.get(i).id_grasa%>"/></td>
                                                    <td><c:out value="<%=lista_grasa.get(i).nombre_grasa%>"/></td>
                                                    <td style="text-align:center;"><c:out value="<%=lista_grasa.get(i).unid_medida_grasa%>"/></td>
                                                    <td style="text-align:center;"><c:out value="<%=lista_grasa.get(i).estado_grasa%>"/></td>



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
    
    
</html>
