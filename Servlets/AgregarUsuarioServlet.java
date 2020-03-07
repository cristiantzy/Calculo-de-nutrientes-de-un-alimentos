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
public class AgregarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{ 
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("txt_nombre");
        String last_name = request.getParameter("txt_apellidos");
        String user_name = request.getParameter("txt_username");

        String verificar = "";
        if (request.getParameter("btn_agregar") != null) {

            IUsuario nuevo_user = new Usuario(0, user_name, user_name, "A", "A");

            // registrar usuario
            if (nuevo_user.registrarUsuario()) {
                int id = 0;
                id = nuevo_user.consultar_id_usuario(user_name);
                IAdministrador nuevo_admin = new Administrador(0, name, last_name, "A", id);
                if (nuevo_admin.registrarAdministrador()) {
                    verificar = "si";
                } else {
                    verificar = "no";

                }
                request.setAttribute("activador", verificar);
                request.getRequestDispatcher("AgregarUsuarioPage.jsp").forward(request, response);
            }

        }

    }

}
