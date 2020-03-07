package Servlets;

import Interface.IAlimentoProcesado;
import Logica.AlimentoProcesado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
public class MasterClientFooterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_alimento_procesado(request, response);

    }

    private void mostrar_alimento_procesado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IAlimentoProcesado alim_procesado = new AlimentoProcesado();

        List<AlimentoProcesado> lista_dieta_bal = alim_procesado.consultar_aletoria();

        request.setAttribute("datos_aliment_proc", lista_dieta_bal);
        request.getRequestDispatcher("MasterClientFooterPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
