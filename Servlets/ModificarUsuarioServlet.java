/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IAdministrador;
import Interface.IUsuario;
import Logica.Administrador;
import Logica.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian_Tisoy
 */
public class ModificarUsuarioServlet extends HttpServlet {

    int idSession = 1;
    String userSession = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // usuario de la sesion
        HttpSession sesion = request.getSession();
        String usuario_global = (String) sesion.getAttribute("user");

        IAdministrador admin = new Administrador();
        IUsuario user = new Usuario();

        // validar que el usuario, haya iniciado sesion
        if (usuario_global != null) {
            userSession = usuario_global;
            idSession = user.consultar_id_usuario(usuario_global);
        }

        admin = admin.consultarAdministrador(userSession);
        user = user.consultarUsuario(userSession);

        request.setAttribute("date_admin", admin);
        request.setAttribute("date_user", user);

        //response.sendRedirect("ModificarUsuarioPage.jsp");
        request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String verificar = "no";
        IUsuario usuario;

        HttpSession sesion = request.getSession();
        String usuario_global = (String) sesion.getAttribute("user");

        IUsuario user_actual = new Usuario();

        // validar que el usuario, haya iniciado sesion
        if (usuario_global != null) {
            userSession = usuario_global;
            idSession = user_actual.consultar_id_usuario(usuario_global);
        }

        // capturar el cambio de contraseña
        if (request.getParameter("btn_actualizar_password") != null) {

            String password = request.getParameter("txt_password");
            String new_password = request.getParameter("txt_new_password");
            String confir_password = request.getParameter("txt_confir_password");

            // guardar los datos del usuario, por que al recargar la pagina se píerden
            String aux_nombre = "", aux_apellido = "", aux_user = "", aux_password = "";

            aux_nombre = request.getParameter("txt_nombre");
            aux_apellido = request.getParameter("txt_apellido");
            aux_user = request.getParameter("txt_usuario");
            aux_password = request.getParameter("txt_password");

            IAdministrador admin = new Administrador(0, aux_nombre, aux_apellido, "", 0);
            IUsuario user = new Usuario(0, aux_user, aux_password, "", "");

            if (new_password.equals(confir_password)) {

                usuario = new Usuario(idSession, userSession, new_password, "", "");

                if (usuario.modificarUsuario()) {
                    verificar = "full_p";

                    request.setAttribute("date_admin", admin);
                    request.setAttribute("date_user", user);
                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);
                } else {

                    verificar = "error_p";
                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);
                }

            } else {
                verificar = "error_p";
                request.setAttribute("estado_password", verificar);
                request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);

            }

        }

        String nombre = request.getParameter("txt_nombre");
        String apellido = request.getParameter("txt_apellido");
        String user = request.getParameter("txt_usuario");
        String aux_password = request.getParameter("txt_password");
        IAdministrador administrador;

        if (request.getParameter("btn_modificar") != null) {

            // validaciones 
            if (nombre.equalsIgnoreCase("") && apellido.equalsIgnoreCase("") && user.equalsIgnoreCase("")) {

                // campos vacios
            } else {
                // guardar los datos del usuario, por que al recargar la pagina se píerden

                IAdministrador admin = new Administrador(0, nombre, apellido, "", 0);
                IUsuario user_n = new Usuario(0, user, aux_password, "", "");

                administrador = new Administrador(0, nombre, apellido, user, idSession);

                if (administrador.modificarAdministrador()) {
                    verificar = "si";

                    request.setAttribute("date_admin", admin);
                    request.setAttribute("date_user", user_n);

                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);

                } else {
                    verificar = "no";
                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarUsuarioPage.jsp").forward(request, response);

                }

            }

        }

    }

}
