/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IRecomendacion;
import Logica.Recomendacion;
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
public class RecomendacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_recomedaciones(request, response);
    }

    private void mostrar_recomedaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRecomendacion recomendacion = new Recomendacion();
        List<Recomendacion> lista_recomendacion = recomendacion.consultar_recomendacion();
        request.setAttribute("datos_recomendacion", lista_recomendacion);
        request.getRequestDispatcher("RecomendacionPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
