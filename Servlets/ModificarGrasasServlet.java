
package Servlets;

import Interface.IGrasa;
import Logica.Grasa;
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
public class ModificarGrasasServlet extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            mostrar_grasas(request, response);
    }

   
    private void mostrar_grasas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IGrasa grasa = new Grasa(0, "", "", "");

        List<Grasa> lista_grasa = grasa.consultar_grasas();

        request.setAttribute("listado_grasa1", lista_grasa);
        request.setAttribute("lista_grasa3", lista_grasa);

        request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);

    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_grasa = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {

            IGrasa grasa = new Grasa(0, "", "", "");
            Grasa grasa_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_grasas")) >= 1) {
                id_grasa = Integer.parseInt(request.getParameter("listado_grasas"));

                grasa_aux = grasa.consultar_por_id_grasas(id_grasa);

                request.setAttribute("lista_grasa2", grasa_aux);
                mostrar_grasas(request, response);
                request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_grasas(request, response);
                request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_grasa = Integer.parseInt(request.getParameter("txt_id"));
            String nombre = request.getParameter("txt_nombre_mod");
            String u_medidad = request.getParameter("txt_unidad_mod");

            if (!nombre.equalsIgnoreCase("")) {

                IGrasa grasa = new Grasa(id_grasa, nombre, u_medidad,"A");

                if (grasa.modificar_grasa()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_grasas(request, response);
                    request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);
                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_grasas(request, response);
                    request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_grasas(request, response);
                request.getRequestDispatcher("ModificarGrasasPage.jsp").forward(request, response);

            }

        }
        
        
        
    }

  
}
