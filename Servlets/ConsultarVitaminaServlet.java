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
public class ConsultarVitaminaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        
        IVitamina vitamina = new Vitamina();

        List<Vitamina> lista_vitamina = vitamina.consultar_vitaminas();

        request.setAttribute("lista_vit", lista_vitamina);

        request.getRequestDispatcher("ConsultarVitaminaPage.jsp").forward(request, response);

    }

}
