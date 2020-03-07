package Servlets;

import Interface.IDietaBalanceada;
import Logica.DietaBalanceada;
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
public class ConsultarDietaBalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IDietaBalanceada dieta_bal = new DietaBalanceada();

        List<DietaBalanceada> lista_dieta_bal = dieta_bal.consultar_dietaBalanceada();

        request.setAttribute("lista_vit", lista_dieta_bal);

        request.getRequestDispatcher("ConsultarDietaBalPage.jsp").forward(request, response);
        
    }
    
    
    
    
    

    
    
    
}
