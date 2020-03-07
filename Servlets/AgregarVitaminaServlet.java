package Servlets;

import Logica.Vitamina;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IVitamina;

/**
 *
 * @author Cristian_Tisoy
 */
public class AgregarVitaminaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IVitamina vitamina;

        String nombre_vitamina = request.getParameter("txt_nombreV");
        String unid_medida_vitamina = request.getParameter("txt_unidadM");
        Double catidad_vitamina = 0.0;
     
        String estado_vitamina = "A";

        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {

            vitamina = new Vitamina(0, nombre_vitamina, unid_medida_vitamina, estado_vitamina);

            if (vitamina.agregar_vitaminas()) {
                verificar = "si";

            } else {
                verificar = "no";
            }
            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarVitaminaPage.jsp").forward(request, response);
        }

    }

}
