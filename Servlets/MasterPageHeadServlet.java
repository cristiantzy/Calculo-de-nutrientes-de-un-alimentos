/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
public class MasterPageHeadServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int r = 3;
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String usuario_global = (String)request.getSession().getAttribute("user"); // usuario

        Administrador administrador = new Administrador();

        administrador = administrador.consultarAdministrador(usuario_global);

        String nombres_user = administrador.nombre_admin;
        String apellidos_user = administrador.apellido_admin;

        String datos_user = "";

        datos_user = nombres_user + " " + apellidos_user;
        request.setAttribute("date_user", datos_user);
        
        request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
    }

   
}
