<%-- 
    Document   : ModificarProductoPage
    Created on : 30/10/2019, 10:09:24 PM
    Author     : Cristian_Tisoy
--%>

<%@page import="Logica.Macronutriente"%>
<%@page import="Logica.Grasa"%>
<%@page import="Logica.Vitamina"%>
<%@page import="Logica.Mineral"%>
<%@page import="Logica.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="MasterPageHead.jsp" flush="true" />

     <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
    <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
    
    <link href="assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
    <link href="assets/libs/select2/dist/css/select2.min.css" rel="stylesheet" type="text/css"/>

    
    <% String control_registro = (String) request.getAttribute("activador");%>


    <% if (control_registro != null) {%>

    <% if (control_registro == "si") {%>
    <script>
        Swal.fire(
                'Producto Actualizado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_minerales") {%>
    <script>
        Swal.fire(
                'Mineral Actualizado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_vitamina") {%>
    <script>
        Swal.fire(
                'Vitamina Actualizada!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_grasa") {%>
    <script>
        Swal.fire(
                'Grasa Actualizada!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_macro") {%>
    <script>
        Swal.fire(
                'Macronutriente Actualizado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>


    <% if (control_registro == "no") {%>
    <script>
        Swal.fire({
            type: 'error',
            title: 'Algo esta Mal!',
            text: 'Vuelva a completar el Formalario!'
        })

    </script>
    <%}%>


    <%}%>
    
    
    
    
    
    
    <title>Modificar Productos | Soft Nutricional</title>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Modificar Productos</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Productos</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Modificar Productos </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>

    <form name="Form1" method="POST" action="ModificarProductoServlet">

        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Lista de Productos</h5>

                                <div class="form-group row">
                                    <div class="col-md-10">
                                        <% List<Producto> lista_producto = (List<Producto>) request.getAttribute("listado_product");%>

                                        <% String estado = "disabledss";%>
                                        <% if (lista_producto != null) {%>
                                        

                                        <%} else {%>
                                        <%  estado = (String) request.getAttribute("estado");%>
                                        <%}%>

                                        <select  name="listado_prod" <%=estado%>  class="select2 form-control custom-select" style="width: 100%; height:36px;">
                                            <option value="0"> -- Selecccione -- </option>
                                            <% if (lista_producto != null) {%>
                                            <% int i = 0;%>

                                            <c:forEach items="<%=lista_producto%>" var="recomen" >

                                                <option value="<%=lista_producto.get(i).id_producto%>"><%=lista_producto.get(i).nombre_producto%></option>


                                                <% i = i + 1;%>
                                            </c:forEach>
                                            <%}%>


                                        </select>

                                    </div>
                                    <div class="col-md-2">
                                        <button type="submit" name="btn_modificar"  class="btn btn-success btn-sm">Modificar</button>
                                    </div>
                                </div>
                                <hr>

                                <div class="row">   

                                    <div class="col-md-6">
                                        <div class="card">

                                            <% int cod = 0;%>
                                            <% String nombre_reg = "";%>
                                            <% String parte_reg = "";%>



                                            <% Producto producto = (Producto) request.getAttribute("dato_produc"); %>

                                            <% if (producto != null) {%>
                                            <% cod = producto.id_producto;%>
                                            <% nombre_reg = producto.nombre_producto;%>
                                            <%  parte_reg = producto.parte_analizada;%>
                                            <%}%>



                                            <div class="form-horizontal">
                                                <div class="card-body">
                                                    <div class="form-group">
                                                        <label>Codigo <small class="text-muted">0000</small></label>
                                                        <input readonly="true" style="border-color: #4a5560;" value="<%=cod%>" required type="text" name="txt_codigo" class="form-control date-inputmask" id="date-mask" placeholder="Code">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Nombre <small class="text-muted">Naranja, cruda</small></label>
                                                        <input style="border-color: #4a5560;" value="<%=nombre_reg%>"  type="text" name="txt_nombre" class="form-control date-inputmask" id="date-mask" placeholder="Name">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Parte Analizada <small class="text-muted">Pulpa sin semilla</small></label>
                                                        <input style="border-color: #4a5560;" value="<%=parte_reg%>"  type="text"  name="txt_parte_analizada" class="form-control phone-inputmask" id="phone-mask" placeholder="Part Analyzed">
                                                    </div>
                                                </div>
                                                <div class="border-top">
                                                    <div class="card-body">

                                                        <button type="submit" name="btn_guardar_cambios" class="btn btn-primary">Guardar Cambios</button>
                                                        <button type="submit" name="btn_nuevo_prod" class="btn btn-success">Modificar Otro</button>


                                                    </div>
                                                </div>


                                            </div>

                                        </div>
                                    </div>



                                    <div class="col-md-6">
                                        <% String estado_cbx = "disabled";%>
                                        <% if (producto != null) {%>
                                        <%  estado_cbx = (String) request.getAttribute("estado_cbx");%>
                                        <%}%>

                                        <div class="card" style="height: 110px;">
                                            <div class="card-body">
                                                <h5 class="card-title"><ceter>Minerales</ceter></h5>
                                                <div class="form-group row">
                                                    <div class="col-md-6">

                                                        <% List<Mineral> lista_mienrales1 = (List<Mineral>) request.getAttribute("listado_mineral1");%>

                                                        <select <%=estado_cbx%> name="listado_min" class="select2 form-control custom-select"
                                                                                style="width: 100%; height:36px; ">
                                                            <option value="0"> -- Seleccione -- </option>

                                                            <% if (lista_mienrales1 != null) {%>
                                                            <% int i = 0;%>
                                                            <c:forEach items="<%=lista_mienrales1%>" var="mineral1" >

                                                                <option value="<%=lista_mienrales1.get(i).id_minerales%>"><%=lista_mienrales1.get(i).nombre_minerales%></option>

                                                                <% i = i + 1;%>
                                                            </c:forEach>
                                                            <%}%>


                                                        </select>
                                                    </div>


                                                    <div class="col-md-4">
                                                        <label class="sr-only" for="inlineFormInputGroup">Username</label>
                                                        <div class="input-group mb-2">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text" style="border-color: #4a5560;" >(g)</div>
                                                            </div>
                                                            <input type="text" name="txt_cantidad_min"  style="border-color: #4a5560;"  class="form-control" id="inlineFormInputGroup" placeholder="0.0">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <button type="submit" name="btn_modificar_mineral" class="btn btn-primary">Actualizar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="card" style="height: 110px;margin-top: -42px;">
                                            <div class="card-body">
                                                <h5 class="card-title"><ceter>Vitaminas</ceter></h5>
                                                <div class="form-group row">
                                                    <div class="col-md-6">

                                                        <% List<Vitamina> lista_vitamina1 = (List<Vitamina>) request.getAttribute("listado_vitamina1");%>

                                                        <select <%=estado_cbx%> name="listado_vit" class="select2 form-control custom-select"
                                                                                style="width: 100%; height:36px; ">
                                                            <option value="0"> -- Seleccione -- </option>

                                                            <% if (lista_vitamina1 != null) {%>
                                                            <% int i = 0;%>
                                                            <c:forEach items="<%=lista_vitamina1%>" var="vitamina1" >

                                                                <option value="<%=lista_vitamina1.get(i).id_vitaminas%>"><%=lista_vitamina1.get(i).nombre_vitamina%></option>

                                                                <% i = i + 1;%>
                                                            </c:forEach>
                                                            <%}%>



                                                        </select>
                                                    </div>

                                                    <div class="col-md-4">
                                                        <label class="sr-only" for="inlineFormInputGroup">Username</label>
                                                        <div class="input-group mb-2">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text" style="border-color: #4a5560;">(g)</div>
                                                            </div>
                                                            <input type="text" name="txt_cantidad_vit" style="border-color: #4a5560;" class="form-control" id="inlineFormInputGroup" placeholder="0.0">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <button type="submit" name="btn_modificar_vitamina" class="btn btn-primary">Actualizar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="card" style="height: 110px;margin-top: -42px;">
                                            <div class="card-body">
                                                <h5 class="card-title"><ceter>Grasas</ceter></h5>
                                                <div class="form-group row">
                                                    <div class="col-md-6">

                                                        <% List<Grasa> lista_grasa1 = (List<Grasa>) request.getAttribute("listado_grasa1");%>

                                                        <select <%=estado_cbx%> name="listado_gr" class="select2 form-control custom-select"
                                                                                style="width: 100%; height:36px; ">
                                                            <option value="0"> -- Seleccione -- </option>

                                                            <% if (lista_grasa1 != null) {%>
                                                            <% int i = 0;%>
                                                            <c:forEach items="<%=lista_grasa1%>" var="mineral1" >

                                                                <option value="<%=lista_grasa1.get(i).id_grasa%>"><%=lista_grasa1.get(i).nombre_grasa%></option>

                                                                <% i = i + 1;%>
                                                            </c:forEach>
                                                            <%}%>


                                                        </select>
                                                    </div>

                                                    <div class="col-md-4">
                                                        <label class="sr-only" for="inlineFormInputGroup">Username</label>
                                                        <div class="input-group mb-2">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text" style="border-color: #4a5560;">(g)</div>
                                                            </div>
                                                            <input type="text" name="txt_cantidad_gr" style="border-color: #4a5560;" class="form-control" id="inlineFormInputGroup" placeholder="0.0">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <button type="submit" name="btn_modificar_grasa" class="btn btn-primary">Actualizar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="card" style="height: 110px;margin-top: -42px;">
                                            <div class="card-body">
                                                <h5 class="card-title"><ceter>Macronutrientes</ceter></h5>
                                                <div class="form-group row">
                                                    <div class="col-md-6">
                                                        <% List<Macronutriente> lista_macro1 = (List<Macronutriente>) request.getAttribute("listado_macro1");%>

                                                        <select <%=estado_cbx%> name="listado_macro" class="select2 form-control custom-select"
                                                                                style="width: 100%; height:36px; ">
                                                            <option value="0"> -- Seleccione -- </option>

                                                            <% if (lista_macro1 != null) {%>
                                                            <% int i = 0;%>
                                                            <c:forEach items="<%=lista_macro1%>" var="mineral1" >

                                                                <option value="<%=lista_macro1.get(i).idmacronutriente%>"><%=lista_macro1.get(i).nombre_macro_nut%></option>

                                                                <% i = i + 1;%>
                                                            </c:forEach>
                                                            <%}%>

                                                        </select>
                                                    </div>

                                                    <div class="col-md-4">
                                                        <label class="sr-only" for="inlineFormInputGroup">Username</label>
                                                        <div class="input-group mb-2">
                                                            <div class="input-group-prepend">
                                                                <div class="input-group-text" style="border-color: #4a5560;">(g)</div>
                                                            </div>
                                                            <input type="text" name="txt_cantidad_mac" style="border-color: #4a5560;" class="form-control" id="inlineFormInputGroup" placeholder="0.0">
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <button type="submit" name="btn_modificar_macro" class="btn btn-primary">Actualizar</button>
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
