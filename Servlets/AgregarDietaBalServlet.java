/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IDietaBalanceada;
import Logica.DietaBalanceada;
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
@WebServlet(name = "AgregarDietaBalServlet", urlPatterns = {"/AgregarDietaBalServlet"})
@MultipartConfig
public class AgregarDietaBalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {
            
            
            IDietaBalanceada dieta_bal = new DietaBalanceada();
            
            
            
            
            // Guardar la img en la ruta del proyecto
            String nombre_foto = request.getParameter("nombre");
            Part archivo_foto = request.getPart("txt_img");

            if (dieta_bal.guardar_img_directory(archivo_foto, nombre_foto)) {

                String nombre = request.getParameter("txt_nombre");
                String descripcion = request.getParameter("txt_descrip");

                dieta_bal = new DietaBalanceada(0, nombre, descripcion, nombre_foto, 1);

                if (dieta_bal.agregar_dietaBalanceada()) {
                    verificar = "si";
                } else {
                    verificar = "no";
                }

            } else {
                verificar = "no";

            }

            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarDietaBalPage.jsp").forward(request, response);

        }

    }

}
