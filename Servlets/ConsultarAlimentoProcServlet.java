
package Servlets;

import Interface.IAlimentoProcesado;
import Logica.AlimentoProcesado;
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
public class ConsultarAlimentoProcServlet extends HttpServlet {

  
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         IAlimentoProcesado alimento_proc = new AlimentoProcesado();

        List<AlimentoProcesado> lista_alimento_proc = alimento_proc.consultar_alimentoProcesado();

        request.setAttribute("lista_vit", lista_alimento_proc);

        request.getRequestDispatcher("ConsultarAlimentoProcPage.jsp").forward(request, response);

    }

    
    
  

}
