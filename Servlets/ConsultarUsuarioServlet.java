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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
public class ConsultarUsuarioServlet extends HttpServlet {

   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        IAdministrador administrador = new Administrador();
        IUsuario usuario = new Usuario();

        List<Administrador> lista_administrador = administrador.consultaAdminUser();
        List<Usuario> lista_usuarios = usuario.consultaAdminUser();
        
        
        
        

        request.setAttribute("lista_admin", lista_administrador);
        request.setAttribute("lista_user", lista_usuarios);

        request.getRequestDispatcher("ConsultarUsuarioPage.jsp").forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

 
}
