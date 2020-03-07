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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
@WebServlet(name = "ConsultarPerfilServlet", urlPatterns = {"/ConsultarPerfilServlet"})
public class ConsultarPerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAdministrador administrador = new Administrador();
        IUsuario usuario = new Usuario();
        
        Administrador datos_administrador = administrador.consultarAdministrador("admin");
        Usuario datos_usuario = usuario.consultarUsuario("admin");
        
        
        request.setAttribute("datos_admin", datos_administrador);
        request.setAttribute("datos_user", datos_usuario);

        request.getRequestDispatcher("ConsultarPerfilPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
