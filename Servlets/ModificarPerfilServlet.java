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

/**
 *
 * @author Cristian_Tisoy
 */
public class ModificarPerfilServlet extends HttpServlet {

    int idSession = 3;
    String userSession = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAdministrador admin = new Administrador();
        IUsuario user = new Usuario();

        admin = admin.consultarAdministrador(userSession);
        user = user.consultarUsuario(userSession);

        request.setAttribute("date_admin", admin);
        request.setAttribute("date_user", user);

        request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String verificar = "no";
        IUsuario usuario;

        // capturar el cambio de contraseña
        if (request.getParameter("btn_actualizar_password") != null) {

            String password = request.getParameter("txt_password");
            String new_password = request.getParameter("txt_new_password");
            String confir_password = request.getParameter("txt_confir_password");

            if (new_password.equals(confir_password)) {

                usuario = new Usuario(idSession, "admin", new_password, "", "");

                if (usuario.modificarUsuario()) {
                    verificar = "full_p";
                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);
                } else {

                    verificar = "error_p";
                    request.setAttribute("estado_password", verificar);
                    request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);
                }

            } else {
                verificar = "error_p";
                request.setAttribute("estado_password", verificar);
                request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);

            }

        }

        String nombre = request.getParameter("txt_nombre");
        String apellido = request.getParameter("txt_apellido");
        String user = request.getParameter("txt_usuario");
        IAdministrador administrador;

        if (request.getParameter("btn_modificar") != null) {

            administrador = new Administrador(0, nombre, apellido, user, idSession);

            if (administrador.modificarAdministrador()) {
                verificar = "si";
                request.setAttribute("estado_password", verificar);
                request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);

            } else {
                verificar = "no";
                request.setAttribute("estado_password", verificar);
                request.getRequestDispatcher("ModificarPerfilPage.jsp").forward(request, response);

            }

        }

    }

}
