package Servlets;

import Interface.IMacronutriente;
import Logica.Macronutriente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
public class AgregarMacronutrienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IMacronutriente macronutriente;

        String name = request.getParameter("txt_nombre");
        String medidad = request.getParameter("txt_unidad");
        String estado = "A";

        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {

           macronutriente = new Macronutriente(0, name, medidad, estado);

            if (macronutriente.agregar_macronutriente()) {
                verificar = "si";

            } else {
                verificar = "no";
            }
            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarMacronutrientePage.jsp").forward(request, response);
        }

    }

}
