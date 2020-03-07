
package Servlets;

import Logica.Mineral;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IMineral;

/**
 *
 * @author Cristian_Tisoy
 */


public class ModificarMineralesServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_minerales(request, response);
    }

        private void mostrar_minerales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IMineral mineral = new Mineral(0, "", "","");

        List<Mineral> lista_vitamina = mineral.consultar_minerales();

        request.setAttribute("listado_mineral1", lista_vitamina);
        request.setAttribute("lista_mineral3", lista_vitamina);

        request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);

    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_mineral = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {

            IMineral mineral = new Mineral(0, "", "","");
            Mineral mineral_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_mineral")) >= 1) {
                id_mineral = Integer.parseInt(request.getParameter("listado_mineral"));

                mineral_aux = mineral.consultar_por_id_minerales(id_mineral);

                request.setAttribute("lista_mineral2", mineral_aux);
                mostrar_minerales(request, response);
                request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_minerales(request, response);
                request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_mineral = Integer.parseInt(request.getParameter("txt_id"));
            String nombre = request.getParameter("txt_nombre_mod");
            String u_medidad = request.getParameter("txt_unidad_mod");

            if (!nombre.equalsIgnoreCase("")) {

                IMineral mineral = new Mineral(id_mineral, nombre, u_medidad,"A");

                if (mineral.modificar_minerales()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_minerales(request, response);
                    request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);
                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_minerales(request, response);
                    request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_minerales(request, response);
                request.getRequestDispatcher("ModificarMineralesPage.jsp").forward(request, response);

            }

        }

        
    }

 
}
