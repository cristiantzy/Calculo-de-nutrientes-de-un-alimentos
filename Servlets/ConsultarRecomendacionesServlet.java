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
public class ConsultarRecomendacionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IRecomendacion recomedacion = new Recomendacion();

        List<Recomendacion> lista_recomendacion = recomedacion.consultar_recomendacion();

        request.setAttribute("lista_vit", lista_recomendacion);

        request.getRequestDispatcher("ConsultarRecomendacionesPage.jsp").forward(request, response);

    }

}
