
package Servlets;

import Interface.IMacronutriente;
import Logica.Macronutriente;
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
public class ModificarMacronutrienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        mostrar_macronutriente(request, response);
    }

    private void mostrar_macronutriente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IMacronutriente macronutriente= new Macronutriente();

        List<Macronutriente> lista_macronutriente = macronutriente.consultar_macronutriente();

        request.setAttribute("listado_macro1", lista_macronutriente);
        request.setAttribute("lista_macro3", lista_macronutriente);

        request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_macronutriente = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {

            IMacronutriente macronutriente = new Macronutriente();
            Macronutriente macronutriente_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_macronutriente")) >= 1) {
                id_macronutriente = Integer.parseInt(request.getParameter("listado_macronutriente"));

                macronutriente_aux = macronutriente.consultar_por_id_macronutriente(id_macronutriente);

                request.setAttribute("lista_macro2", macronutriente_aux);
                mostrar_macronutriente(request, response);
                request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_macronutriente(request, response);
                request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_macronutriente = Integer.parseInt(request.getParameter("txt_id"));
            String nombre_administrador = request.getParameter("txt_nombre_mod");
            String u_medidad = request.getParameter("txt_unidad_mod");

            if (!nombre_administrador.equalsIgnoreCase("")) {

                IMacronutriente macronutriente = new Macronutriente(id_macronutriente, nombre_administrador, u_medidad, "A");

                if (macronutriente.modificar_macronutriente()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_macronutriente(request, response);
                    request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);
                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_macronutriente(request, response);
                    request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_macronutriente(request, response);
                request.getRequestDispatcher("ModificarMacronutrientePage.jsp").forward(request, response);

            }

        }

        
    }

   
}
