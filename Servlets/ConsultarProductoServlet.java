package Servlets;

import Interface.IProducto;
import Interface.IProducto_Grasa;
import Interface.IProducto_Macronutriente;
import Interface.IProducto_Mineral;
import Interface.IProducto_Vitamina;
import Logica.Producto;
import Logica.Producto_Grasa;
import Logica.Producto_Macronutriente;
import Logica.Producto_Mineral;
import Logica.Producto_Vitamina;
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
public class ConsultarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_productos(request, response);

    }

    private void mostrar_productos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IProducto producto = new Producto();

        List<Producto> lista_producto = producto.consultar_productos();

        request.setAttribute("listado_product", lista_producto);

        request.getRequestDispatcher("ConsultarProductoPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // traer los datos de la base de datos
        String verificar = "";

        if (request.getParameter("btn_consultar") != null) {

            IProducto_Mineral proMin = new Producto_Mineral();
            List<Producto_Mineral> lista_productMin;

            IProducto_Vitamina proVit = new Producto_Vitamina();
            List<Producto_Vitamina> lista_productVit;

            IProducto_Grasa proGra = new Producto_Grasa();
            List<Producto_Grasa> lista_productGra;

            IProducto_Macronutriente proMacro = new Producto_Macronutriente();
            List<Producto_Macronutriente> lista_productMacro;

            Producto nuevo_pro = new Producto();

            int id_producto = 0;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_prod")) >= 1) {
                id_producto = Integer.parseInt(request.getParameter("listado_prod"));

                nuevo_pro = nuevo_pro.consulta_producto_por_id(id_producto);
                request.setAttribute("dato_produc", nuevo_pro);

                lista_productMin = proMin.consultar_por_id_productoMineral(id_producto);
                request.setAttribute("lista_min34", lista_productMin);

                lista_productVit = proVit.consultar_por_id_productoVitamina(id_producto);
                request.setAttribute("lista_vit", lista_productVit);

                lista_productGra = proGra.consultar_por_id_productoGrasas(id_producto);
                request.setAttribute("lista_gra", lista_productGra);

                lista_productMacro = proMacro.consultar_por_id_productoMacronutriente(id_producto);
                request.setAttribute("lista_mac", lista_productMacro);

                mostrar_productos(request, response);
                request.getRequestDispatcher("ConsultarProductoPage.jsp").forward(request, response);
            } else {
                // no seleeciono nada. mostrar mensaje
                mostrar_productos(request, response);
                request.getRequestDispatcher("ConsultarProductoPage.jsp").forward(request, response);
            }

        }
    }

}
