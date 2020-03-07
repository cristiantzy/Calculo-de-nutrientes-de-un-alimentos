
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
public class ConsultarMineralesServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                IMineral mineral = new Mineral();

        List<Mineral> lista_mineral = mineral.consultar_minerales();

        request.setAttribute("lista_vit", lista_mineral);

        request.getRequestDispatcher("ConsultarMineralesPage.jsp").forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
