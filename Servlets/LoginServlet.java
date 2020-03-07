/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IUsuario;
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
public class LoginServlet extends HttpServlet {

  
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario_u = request.getParameter("txt_usuario");
        String password_u = request.getParameter("txt_password");

        String verificar = "";

        IUsuario usuario = new Usuario(0, usuario_u, password_u, "A", "A");

        if (request.getParameter("btn_iniciar") != null) {
            // verificar  registro
            if (usuario.verificar_registroBD()) {

                if (usuario.verificar_credenciales()) {
                    // guardar id del usuario ingresado
                    HttpSession session = request.getSession();
                    session.setAttribute("user",usuario_u); // primero el nombre, tipo de variable
                    
                    
                    response.sendRedirect("AdminPage.jsp");
                    
                } else {
                    // mostrar mensaje de usuario o contraseña incorrecta
                    verificar = "password";
                    request.setAttribute("activador", verificar);
                    request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
                }

            } else {
                // mostrar mensaje de usuario no registrado en la base de datos
                verificar = "registro";
                request.setAttribute("activador", verificar);
                request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
