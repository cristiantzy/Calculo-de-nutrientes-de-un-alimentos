<%-- 
    Document   : LoginPage
    Created on : 16/10/2019, 05:09:20 PM
    Author     : Cristian_Tisoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">


        <!-- Favicon icon -->

        <link rel="icon" type="image/png" sizes="16x16" href="img/core-img/ico1.png">

        <title>LOGIN</title>

        <link rel="icon" href="img/core-img/ico1.png">
     

        <link href="dist/css/style.min.css" rel="stylesheet" type="text/css"/>


        <script src="package/dist/sweetalert2.min.js" type="text/javascript"></script>
        <link href="package/dist/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

        



    </head>


    <body>
<% String control_registro = (String) request.getAttribute("activador");%>

        <% if (control_registro != null) {%>

        <% if (control_registro == "password") {%>
        <script>
            Swal.fire({
                type: 'error',
                title: 'Datos Incorrectos',
                text: 'La contraseña/usuario Incorrecta!'
            })


        </script>
        <%}%>

        <% if (control_registro == "registro") {%>
        <script>
            Swal.fire({
                type: 'error',
                title: 'No Registrado',
                text: 'Usuario NO Registrado!'
            })

        </script>
        <%}%>

        <%}%>
        <div class="main-wrapper">

            <div class="preloader">
                <div class="lds-ripple">
                    <div class="lds-pos"></div>
                    <div class="lds-pos"></div>
                </div>
            </div>

            <div class="auth-wrapper d-flex no-block justify-content-center align-items-center bg-dark">
                <div class="auth-box bg-dark border-top border-secondary">
                    <div id="loginform">
                        <div class="text-center p-t-20 p-b-20">
                         
                            <span class="db"><img src="img/core-img/log_ic1.png" alt="logo" /></span>
                           
                        </div>
                        <!-- Form -->
                        <form name="form1" class="form-horizontal m-t-20" method="POST" id="loginform" action="LoginServlet">
                            <div class="row p-b-30">
                                <div class="col-12">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text bg-success text-white" id="basic-addon1"><i class="ti-user"></i></span>
                                        </div>
                                        <input type="text" name="txt_usuario" class="form-control form-control-lg" placeholder="Usuario" aria-label="Username" aria-describedby="basic-addon1" required="">
                                    </div>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text bg-warning text-white" id="basic-addon2"><i class="ti-pencil"></i></span>
                                        </div>
                                        <input type="password" name="txt_password" class="form-control form-control-lg" placeholder="Contraseña" aria-label="Password" aria-describedby="basic-addon1" required="">
                                    </div>
                                </div>
                            </div>
                            <div class="row border-top border-secondary">
                                <div class="col-12">
                                    <div class="form-group">
                                        <div class="p-t-20">
                                            <button class="btn btn-info" id="to-recover" type="button"><i class="fa fa-lock m-r-5"></i>Olvido su contraseña?</button>
                                            <button class="btn btn-success float-right" name="btn_iniciar" type="submit">Iniciar Sesión</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="recoverform">
                        <div class="text-center">
                            <span class="text-white">Ingrese su dirección de correo electrónico a continuación y le enviaremos instrucciones sobre cómo recuperar una contraseña.</span>
                        </div>
                        <div class="row m-t-20">
                            <!-- Form -->
                            <form name="form2" class="col-12" action="LoginServlet">
                                <!-- email -->
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-danger text-white" id="basic-addon1"><i class="ti-email"></i></span>
                                    </div>
                                    <input type="text" class="form-control form-control-lg" placeholder="Email Address" aria-label="Username" aria-describedby="basic-addon1">
                                </div>
                                <!-- pwd -->
                                <div class="row m-t-20 p-t-20 border-top border-secondary">
                                    <div class="col-12">
                                        <a class="btn btn-success" href="#" id="to-login" name="action">Regresar al Login</a>
                                        <button class="btn btn-info float-right" type="button" name="action">Recuperar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="assets/libs/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="assets/libs/popper.js/dist/umd/popper.min.js"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
      



        <script>

            $('[data-toggle="tooltip"]').tooltip();
            $(".preloader").fadeOut();
            // ============================================================== 
            // Login and Recover Password 
            // ============================================================== 
            $('#to-recover').on("click", function () {
                $("#loginform").slideUp();
                $("#recoverform").fadeIn();
            });
            $('#to-login').click(function () {

                $("#recoverform").hide();
                $("#loginform").fadeIn();
            });
        </script>




    </body>
</html>
