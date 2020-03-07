
package Servlets;

import Logica.Vitamina;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IVitamina;

/**
 *
 * @author Cristian_Tisoy
 */
public class ModificarVitaminaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_vitaminas(request, response);
    }

    private void mostrar_vitaminas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IVitamina vitamina = new Vitamina();

        List<Vitamina> lista_vitamina = vitamina.consultar_vitaminas();

        request.setAttribute("listado_vitamina1", lista_vitamina);
        request.setAttribute("lista_vitamina3", lista_vitamina);

        request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_vitamina = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {

            IVitamina vitamina = new Vitamina();
            Vitamina vitamina_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_vitaminas")) >= 1) {
                id_vitamina = Integer.parseInt(request.getParameter("listado_vitaminas"));

                vitamina_aux = vitamina.consultar_por_id_vitaminas(id_vitamina);

                request.setAttribute("lista_vitamina2", vitamina_aux);
                mostrar_vitaminas(request, response);
                request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_vitaminas(request, response);
                request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_vitamina = Integer.parseInt(request.getParameter("txt_id"));
            String nombre_vitamina = request.getParameter("txt_nombre_mod");
            String u_medidad = request.getParameter("txt_unidad_mod");

            if (!nombre_vitamina.equalsIgnoreCase("")) {

                IVitamina vitamina = new Vitamina(id_vitamina, nombre_vitamina, u_medidad,"A");

                if (vitamina.modificar_vitaminas()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_vitaminas(request, response);
                    request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);
                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_vitaminas(request, response);
                    request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_vitaminas(request, response);
                request.getRequestDispatcher("ModificarVitaminaPage.jsp").forward(request, response);

            }

        }

    }

}
