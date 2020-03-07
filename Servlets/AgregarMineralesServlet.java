
package Servlets;

import Logica.Mineral;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IMineral;

/**
 *
 * @author Cristian_Tisoy
 */
public class AgregarMineralesServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IMineral mineral;

        String nombre = request.getParameter("txt_nombre");
        String unid_medida = request.getParameter("txt_unidad");
     
        String estado = "A";

        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {

            mineral = new Mineral(0, nombre, unid_medida, estado);

            if (mineral.agregar_minerales()) {
                verificar = "si";

            } else {
                verificar = "no";
            }
            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarMineralesPage.jsp").forward(request, response);
        }
    }

    
}
