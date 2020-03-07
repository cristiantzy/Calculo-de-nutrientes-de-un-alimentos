/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IDietaBalanceada;
import Logica.DietaBalanceada;
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
public class DietaBalanceadaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_dieta_bal(request, response);

    }

    private void mostrar_dieta_bal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IDietaBalanceada dieta_bal = new DietaBalanceada();
        List<DietaBalanceada> lista_dieta_bal = dieta_bal.consultar_dietaBalanceada();
        request.setAttribute("listado_dietas", lista_dieta_bal);
        request.getRequestDispatcher("DietaBalanceadaPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
