
package Servlets;

import Interface.IGrasa;
import Logica.Grasa;
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
public class AgregarrGrasasServlet extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        IGrasa grasa;

        String nombre = request.getParameter("txt_nombre");
        String unid_medida = request.getParameter("txt_unidad");
        String estado_vitamina = "A";

        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {

            grasa = new Grasa(0, nombre, unid_medida, estado_vitamina);

            if (grasa.agregar_grasa()) {
                verificar = "si";

            } else {
                verificar = "no";
            }
            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarGrasasPage.jsp").forward(request, response);
        }


        
    }


}
