/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IRecomendacion;
import Logica.Recomendacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
@WebServlet(name = "AgregarRecomendacionesServlet", urlPatterns = {"/AgregarRecomendacionesServlet"})
@MultipartConfig

public class AgregarRecomendacionesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String verificar = "";
        if (request.getParameter("btn_agregar") != null) {
            IRecomendacion recomendacion = new Recomendacion();

            // Guardar la img en la ruta del proyecto
            String nombre_foto = request.getParameter("nombre");
            Part archivo_foto = request.getPart("txt_img");

            if (recomendacion.guardar_img_directory(archivo_foto, nombre_foto)) {
                
                String nombre = request.getParameter("txt_nombre");
                String descripcion = request.getParameter("txt_descrip");

                recomendacion = new Recomendacion(0, nombre, descripcion, nombre_foto, 1);

                if (recomendacion.agregar_recomendacion()) {
                    verificar = "si";
                } else {
                    verificar = "no";
                }
            } else {
                verificar = "no";

            }

            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarRecomendacionesPage.jsp").forward(request, response);

        }

    }

}
