package Servlets;

import Interface.IAlimentoProcesado;
import Interface.IDietaBalanceada;
import Interface.IRecomendacion;
import Logica.AlimentoProcesado;
import Logica.DietaBalanceada;
import Logica.Recomendacion;
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
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_dieta_bal(request, response);

    }

    
    
    // mostrar listado, cada que el JSP haga un envio a la BD
    private void mostrar_dieta_bal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IDietaBalanceada dieta_bal = new DietaBalanceada();
        IRecomendacion recomendacion = new Recomendacion();
        IAlimentoProcesado alim_procesado = new AlimentoProcesado();
        
        List<Recomendacion> lista_recomendacion = recomendacion.consultar_aletoria();
        
        List<DietaBalanceada> lista_dieta_bal = dieta_bal.consultar_aletoria();
        
        List<AlimentoProcesado> lista_proce = alim_procesado.consultar_aletoria();
        
        request.setAttribute("datos_aliment_proc", lista_proce);
        request.setAttribute("lista_datos_tabla", lista_dieta_bal);
        request.setAttribute("datos_recomendacion", lista_recomendacion);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    
    
    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
