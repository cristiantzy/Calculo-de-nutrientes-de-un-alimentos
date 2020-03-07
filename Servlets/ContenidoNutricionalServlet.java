/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IAlimentoProcesado;
import Interface.IProducto;
import Logica.AlimentoProcesado;
import Logica.InformacionNutricional;
import Logica.Producto;
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
public class ContenidoNutricionalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_productos(request, response);
    }

    private void mostrar_productos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IProducto producto = new Producto();

        List<Producto> lista_producto = producto.consultar_productos();
        IAlimentoProcesado alim_procesado = new AlimentoProcesado();

        List<AlimentoProcesado> lista_dieta_bal = alim_procesado.consultar_aletoria();

        request.setAttribute("datos_aliment_proc", lista_dieta_bal);

       
        
        request.setAttribute("listado_product", lista_producto);
        request.getRequestDispatcher("ContenidoNutricionalPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // HACER CLIC EN CALCULAR NUTRIENTES
        if (request.getParameter("btn_consultar") != null) {
            String aux_total_calorias="0",aux_total_carbohidratos="0",aux_total_grasas="0",aux_total_proteinas="0";
            
            // verificar que no este vacio el selec
             if (Integer.parseInt(request.getParameter("listado_prod")) >= 1) {
             // Capturar el id del alimento seleccionado
             int id_producto = Integer.parseInt(request.getParameter("listado_prod"));
             
             InformacionNutricional contenido_nutricional = new InformacionNutricional();
             
             contenido_nutricional = contenido_nutricional.calcular_nutrientes(id_producto);
             
             
             
             aux_total_calorias =""+contenido_nutricional.total_calorias(id_producto);
             
             aux_total_carbohidratos = ""+contenido_nutricional.total_carbohidratos(id_producto);
             aux_total_grasas =" "+contenido_nutricional.total_grasas(id_producto);
             aux_total_proteinas=""+contenido_nutricional.total_proteina(id_producto);
             
             
             
             request.setAttribute("total_calorias", aux_total_calorias);
             request.setAttribute("total_carbohidratos", aux_total_carbohidratos);
             request.setAttribute("total_grasa", aux_total_proteinas);
             request.setAttribute("total_proteina", aux_total_calorias);
             request.setAttribute("lista_nutrientes", contenido_nutricional);
              mostrar_productos(request, response);
             //request.getRequestDispatcher("ContenidoNutricionalPage.jsp").forward(request, response);
             
             
             }
        }

    }

}
