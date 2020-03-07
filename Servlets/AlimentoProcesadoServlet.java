/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IAlimentoProcesado;
import Logica.AlimentoProcesado;
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
public class AlimentoProcesadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_alimetos_procesados(request, response);
    }

    private void mostrar_alimetos_procesados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAlimentoProcesado alim_procesado = new AlimentoProcesado();
        List<AlimentoProcesado> lista_proce = alim_procesado.consultar_alimentoProcesado();
        request.setAttribute("datos_aliment_proc", lista_proce);
        request.getRequestDispatcher("AlimentoProcesadoPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
