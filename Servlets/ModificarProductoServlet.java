package Servlets;

import Interface.IGrasa;
import Interface.IMacronutriente;
import Interface.IProducto;
import Interface.IProducto_Grasa;
import Interface.IProducto_Macronutriente;
import Interface.IProducto_Mineral;
import Interface.IProducto_Vitamina;
import Logica.Grasa;
import Logica.Macronutriente;
import Logica.Mineral;
import Logica.Producto;
import Logica.Producto_Grasa;
import Logica.Producto_Macronutriente;
import Logica.Producto_Mineral;
import Logica.Producto_Vitamina;
import Logica.Vitamina;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interface.IVitamina;
import Interface.IMineral;

/**
 *
 * @author Cristian_Tisoy
 */
public class ModificarProductoServlet extends HttpServlet {

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
        request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

    }

    private void mostrar_nutrientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IMineral minerales = new Mineral();
        IVitamina vitaminas = new Vitamina();
        IGrasa grasas = new Grasa();
        IMacronutriente macronutriente = new Macronutriente();

        List<Mineral> lista_minerales = minerales.consultar_minerales();
        List<Vitamina> lista_vitaminas = vitaminas.consultar_vitaminas();
        List<Grasa> lista_grasas = grasas.consultar_grasas();
        List<Macronutriente> lista_macro = macronutriente.consultar_macronutriente();

        request.setAttribute("listado_mineral1", lista_minerales);
        request.setAttribute("listado_vitamina1", lista_vitaminas);
        request.setAttribute("listado_grasa1", lista_grasas);
        request.setAttribute("listado_macro1", lista_macro);

        request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Traer los productos desde la bd
        if (request.getParameter("btn_modificar") != null) {
            int id_producto = 0;
            String estado_cbx_nut = "";
            String estado_cbx = "";

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_prod")) >= 1) {
                id_producto = Integer.parseInt(request.getParameter("listado_prod"));

                IProducto producto = new Producto();

                producto = producto.consulta_producto_por_id(id_producto);
                request.setAttribute("dato_produc", producto);

                // cargar nutrientes
                mostrar_nutrientes(request, response);

                // Habilitar los comboBox de los nutrientes
                estado_cbx_nut = "disabledr";
                request.setAttribute("estado_cbx", estado_cbx_nut);

                //deshabilitar el cbx del los productos
                estado_cbx = "disabled";
                request.setAttribute("estado", estado_cbx);
                request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);
            }
        }

        // Guardar cambios del producto
        String verificar = "";
        if (request.getParameter("btn_guardar_cambios") != null) {
            int id_prod = Integer.parseInt(request.getParameter("txt_codigo"));
            String nombre_producto = request.getParameter("txt_nombre");
            String parte_analizada = request.getParameter("txt_parte_analizada");

            if (nombre_producto != "") {
                IProducto nuevo_producto = new Producto(id_prod, nombre_producto, parte_analizada, 0);
                if (nuevo_producto.modificar_producto()) {

                    verificar = "si";
                    request.setAttribute("activador", verificar);
                    mostrar_productos(request, response);
                    request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);
                }

            } else {
                // mostrar un mensaje de completar formulario
                verificar = "no";
                request.setAttribute("activador", verificar);
                request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);
            }

        }

        // Modificar otro producto
        if (request.getParameter("btn_nuevo_prod") != null) {
            mostrar_productos(request, response);
            request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);
        }

        // Actualizar Mineral
        int id_dinamico = 0;
        String estado_cbx = "";
        if (request.getParameter("btn_modificar_mineral") != null) {

            if (Integer.parseInt(request.getParameter("listado_min")) >= 1) {

                double cantidad = Double.valueOf(request.getParameter("txt_cantidad_min"));
                int id_prod = Integer.parseInt(request.getParameter("txt_codigo"));
                id_dinamico = Integer.parseInt(request.getParameter("listado_min"));

                IProducto_Mineral proMin = new Producto_Mineral(id_prod, id_dinamico, cantidad, "");

                if (proMin.modificar_productoMineral()) {

                    // mantener los datos iniciales del producto
                    IProducto producto = new Producto();
                    producto = producto.consulta_producto_por_id(id_prod);
                    request.setAttribute("dato_produc", producto);

                    //Mantener el combox de producto deshabilitados
                    estado_cbx = "disabled";
                    request.setAttribute("estado", estado_cbx);

                    verificar = "si_minerales";
                    request.setAttribute("activador", verificar);
                    request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

                } else {

                }

            }

        }

        // Actualizar Vitamina
        if (request.getParameter("btn_modificar_vitamina") != null) {
            
            if (Integer.parseInt(request.getParameter("listado_vit")) >= 1) {

                double cantidad = Double.valueOf(request.getParameter("txt_cantidad_vit"));
                
                int id_prod = Integer.parseInt(request.getParameter("txt_codigo"));
                
                id_dinamico = Integer.parseInt(request.getParameter("listado_vit"));

                IProducto_Vitamina proVit = new Producto_Vitamina(id_prod, id_dinamico, cantidad, "");

                if (proVit.modificar_productoVitamina()) {

                    // mantener los datos iniciales del producto
                    IProducto producto = new Producto();
                    producto = producto.consulta_producto_por_id(id_prod);
                    request.setAttribute("dato_produc", producto);

                    //Mantener el combox de producto deshabilitados
                    estado_cbx = "disabled";
                    request.setAttribute("estado", estado_cbx);

                    verificar = "si_vitamina";
                    request.setAttribute("activador", verificar);
                    request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

                } else {

                }

            }
            
            
        }

        // Actualizar Grasas
        if (request.getParameter("btn_modificar_grasa") != null) {
            
            if (Integer.parseInt(request.getParameter("listado_gr")) >= 1) {

                double cantidad = Double.valueOf(request.getParameter("txt_cantidad_gr"));
                
                int id_prod = Integer.parseInt(request.getParameter("txt_codigo"));
                
                id_dinamico = Integer.parseInt(request.getParameter("listado_gr"));

                IProducto_Grasa proGra = new Producto_Grasa(id_prod, id_dinamico, cantidad, "");

                if (proGra.modificar_productoGrasa()) {

                    // mantener los datos iniciales del producto
                    IProducto producto = new Producto();
                    producto = producto.consulta_producto_por_id(id_prod);
                    request.setAttribute("dato_produc", producto);

                    //Mantener el combox de producto deshabilitados
                    estado_cbx = "disabled";
                    request.setAttribute("estado", estado_cbx);

                    verificar = "si_grasa";
                    request.setAttribute("activador", verificar);
                    request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

                } else {

                }

            }
            
        }

        // Actualizar Macronutriente
        if (request.getParameter("btn_modificar_macro") != null) {
            
            if (Integer.parseInt(request.getParameter("listado_macro")) >= 1) {

                double cantidad = Double.valueOf(request.getParameter("txt_cantidad_mac"));
                
                int id_prod = Integer.parseInt(request.getParameter("txt_codigo"));
                
                id_dinamico = Integer.parseInt(request.getParameter("listado_macro"));

                IProducto_Macronutriente proMacro = new Producto_Macronutriente(id_prod, id_dinamico, cantidad, "");

                if (proMacro.modificar_productoMacronutriente()) {

                    // mantener los datos iniciales del producto
                    IProducto producto = new Producto();
                    producto = producto.consulta_producto_por_id(id_prod);
                    request.setAttribute("dato_produc", producto);

                    //Mantener el combox de producto deshabilitados
                    estado_cbx = "disabled";
                    request.setAttribute("estado", estado_cbx);

                    verificar = "si_macro";
                    request.setAttribute("activador", verificar);
                    request.getRequestDispatcher("ModificarProductoPage.jsp").forward(request, response);

                } else {

                }

            }
            
            
        }

    }

}
