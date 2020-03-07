
package Servlets;

import Interface.IMacronutriente;
import Logica.Macronutriente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian_Tisoy
 */
public class ConsultarMacronutienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         IMacronutriente macronutriente = new Macronutriente();

        List<Macronutriente> lista_macronutriente = macronutriente.consultar_macronutriente();

        request.setAttribute("lista_vit", lista_macronutriente);

        request.getRequestDispatcher("ConsultarMacronutrientePage.jsp").forward(request, response);

        
        
        
    }

    
   

   
}
