<%-- 
    Document   : AgregarProductoPage
    Created on : 27/10/2019, 10:18:49 AM
    Author     : Cristian_Tisoy
--%>

<%@page import="Logica.Macronutriente"%>
<%@page import="Logica.Grasa"%>
<%@page import="Logica.Vitamina"%>
<%@page import="Logica.Mineral"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>


    <jsp:include page="MasterPageHead.jsp" flush="true" />

    <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
    <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" type="text/css" href="assets/libs/select2/dist/css/select2.min.css">


    <% String control_registro = (String) request.getAttribute("activador");%>


    <% if (control_registro != null) {%>

    <% if (control_registro == "si") {%>
    <script>
        Swal.fire(
                'Producto registrado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_minerales") {%>
    <script>
        Swal.fire(
                'Mineral registrado!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_vitamina") {%>
    <script>
        Swal.fire(
                'Vitamina registrada!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_grasa") {%>
    <script>
        Swal.fire(
                'Grasa registrada!',
                'todo esta bien!',
                'success'
                )
    </script>
    <%}%>

    <% if (control_registro == "si_macro") {%>
    <script>
        Swal.fire(
                'Macronutriente registrado!',
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






    <title>Agregar Producto | Soft Nutricional</title>
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Agregar Producto</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="AdminPage.jsp"><span class="mdi mdi-home"></span>&nbsp;Inicio</a></li>
                            <li class="breadcrumb-item"><a href="#">Gestionar Producto</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Agregar Producto </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>



    <form name="Form1" action="AgregarProductoServlet" method="POST">
        <div class="container-fluid">
            <div class="row">


                <div class="col-md-6">
                    <div class="card">
                       
                       
                        <% String nombre_reg ="";%>
                        <% String estado_btn_agregar_producto ="false";%>
                        <% String parte_reg = "";%>
                        <% String producto_reg = "";%>
                        <% String estado = "readonlyj";%>
                        
                        <% nombre_reg = (String) request.getAttribute("name_reg");%>
                        
                         <% if (nombre_reg != null) {%>
                         <% estado_btn_agregar_producto =(String) request.getAttribute("estado_btn");%>
                         <% nombre_reg = (String) request.getAttribute("name_reg");%>
                         <%  parte_reg = (String) request.getAttribute("part_reg");%>
                        <% producto_reg = (String) request.getAttribute("product_reg");%>
                         <%  estado = (String) request.getAttribute("estado_input");%>
                         
                         
                        <%}else{%>
                        <%nombre_reg="";%>
                        <%}%>
                        
                        
                        <div class="form-horizontal">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Nombre <small class="text-muted">Naranja, cruda</small></label>
                                    <input <%=estado%> style="border-color: #4a5560;" value="<%=nombre_reg%>"  type="text" name="txt_nombre" class="form-control date-inputmask" id="date-mask" placeholder="Enter Name">
                                </div>
                                <div class="form-group">
                                    <label>Parte Analizada <small class="text-muted">Pulpa sin semilla</small></label>
                                    <input <%=estado%> style="border-color: #4a5560;" value="<%=parte_reg%>"  type="text" name="txt_parte_analizada" class="form-control phone-inputmask" id="phone-mask" placeholder="Enter Part Analyzed">
                                </div>
                            </div>
                            <div class="border-top">
                                <div class="card-body">

                                    <button type="submit" name="btn_agregar" <%=estado_btn_agregar_producto%> class="btn btn-primary">Agregar Producto</button>
                                    <button type="submit" name="btn_nuevo" class="btn btn-success">Nuevo Producto</button>

                                </div>
                            </div>
                            <hr>
                            <div class="card-body">


                                <div class="row">
                                    <div class="col">
                                        <h3>Producto registrado: </h3>
                                    </div>
                                    <div class="col">
                                        <h3><%=producto_reg%></h3>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>


                <div class="col-md-6">
                    <div class="card" style="height: 110px;">
                        <div class="card-body">
                            <h5 class="card-title"><ceter>Minerales</ceter></h5>
                            <div class="form-group row">
                                <div class="col-md-6">

                                    <% List<Mineral> lista_mienrales1 = (List<Mineral>) request.getAttribute("listado_mineral1");%>

                                    <select name="listado_min" class="select2 form-control custom-select"
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
                                    <button type="submit" name="btn_agregar_mineral" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="card" style="height: 110px;">
                        <div class="card-body">
                            <h5 class="card-title"><ceter>Vitaminas</ceter></h5>
                            <div class="form-group row">
                                <div class="col-md-6">

                                    <% List<Vitamina> lista_vitamina1 = (List<Vitamina>) request.getAttribute("listado_vitamina1");%>

                                    <select name="listado_vit" class="select2 form-control custom-select"
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
                                    <button type="submit" name="btn_agregar_vitamina" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card" style="height: 110px;">
                        <div class="card-body">
                            <h5 class="card-title"><ceter>Grasas</ceter></h5>
                            <div class="form-group row">
                                <div class="col-md-6">

                                    <% List<Grasa> lista_grasa1 = (List<Grasa>) request.getAttribute("listado_grasa1");%>

                                    <select name="listado_gr" class="select2 form-control custom-select"
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
                                    <button type="submit" name="btn_agregar_grasa" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card" style="height: 110px;">
                        <div class="card-body">
                            <h5 class="card-title"><ceter>Macronutrientes</ceter></h5>
                            <div class="form-group row">
                                <div class="col-md-6">
                                    <% List<Macronutriente> lista_macro1 = (List<Macronutriente>) request.getAttribute("listado_macro1");%>

                                    <select name="listado_macro" class="select2 form-control custom-select"
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
                                    <button type="submit" name="btn_agregar_macro" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </form>        


    <jsp:include page="MasterPageFooter.jsp" flush="true" />


    <!-- This Page JS -->
    <script src="assets/libs/select2/dist/js/select2.min.js"></script>


    <script>
        $(".select2").select2();
    </script>




</html>
