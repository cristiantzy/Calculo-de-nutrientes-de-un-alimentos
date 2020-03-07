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
public class AgregarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_nutrientes(request, response);
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

        request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);
    }

    private boolean validar_formulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // campos vacios
        // repetidos en la base de datos

        IProducto producto = new Producto();

        String nombre = request.getParameter("txt_nombre");
        String parte_analizada = request.getParameter("txt_parte_analizada");

        if (nombre.equalsIgnoreCase("")) {
            return false;
        } else {
            if (producto.producto_repetido(nombre, parte_analizada)) {
                // esta repetido
                return false;
            }

        }

        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("txt_nombre");
        String parte_analizada = request.getParameter("txt_parte_analizada");

        String verificar = "";
        String estado_txt = "";
        String estado_btn = "";

        // AGREGAR PRODUCTO
        if (request.getParameter("btn_agregar") != null) {

            IProducto producto = new Producto(0, nombre, parte_analizada, 1);

            if (producto.producto_repetido(nombre, parte_analizada)) {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_nutrientes(request, response);
                request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);
            } else {
                // no repetido
                if (producto.agregar_producto()) {

                    verificar = "si";
                    request.setAttribute("activador", verificar);
                    estado_txt = "readonly";
                    estado_btn = "disabled";

                    request.setAttribute("estado_input", estado_txt);

                    estado_btn = "disabled";
                    request.setAttribute("estado_btn", estado_btn);

                    cargar_datos_agregados(request, response);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                } else {
                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                }
            }

        }

        // AGREGAR NUEVO PRODUCTO
        if (request.getParameter("btn_nuevo") != null) {
            estado_txt = "readonlydf";
            request.setAttribute("estado_input", estado_txt);
            request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

        }

        // AGREGAR NUTRIENTES
        int id_dinamico = 0;
        // AGREGAR MINERALES
        if (request.getParameter("btn_agregar_mineral") != null) {

            double cantidad = Double.valueOf(request.getParameter("txt_cantidad_min"));

            if (Integer.parseInt(request.getParameter("listado_min")) >= 1) {

                id_dinamico = Integer.parseInt(request.getParameter("listado_min"));

                IProducto nuevo_producto = new Producto();

                /// consultar el id del nombre
                int nuevo_id_pro = 0;

                nuevo_id_pro = nuevo_producto.id_ultimo_registro();

                IProducto_Mineral nuevo_proMin = new Producto_Mineral(nuevo_id_pro, id_dinamico, cantidad, "A");

                if (nuevo_proMin.agregar_productoMineral()) {
                    // mostrar mensaje de creacion

                    verificar = "si_minerales";
                    estado_txt = "readonly";
                    request.setAttribute("activador", verificar);
                    request.setAttribute("estado_input", estado_txt);

                    cargar_datos_agregados(request, response);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                } else {
                    // mostrar emnsaje de no creado

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                }

            }

        }

        // AGREGAR VITAMINAS
        if (request.getParameter("btn_agregar_vitamina") != null) {

            double cantidad = Double.valueOf(request.getParameter("txt_cantidad_vit"));

            if (Integer.parseInt(request.getParameter("listado_vit")) >= 1) {

                id_dinamico = Integer.parseInt(request.getParameter("listado_vit"));

                IProducto nuevo_producto = new Producto();

                int nuevo_id_pro = 0;

                nuevo_id_pro = nuevo_producto.id_ultimo_registro();

                IProducto_Vitamina nuevo_proVit = new Producto_Vitamina(nuevo_id_pro, id_dinamico, cantidad, "A");

                if (nuevo_proVit.agregar_productoVitamina()) {
                    // mostrar mensaje de creacion

                    verificar = "si_vitamina";
                    request.setAttribute("activador", verificar);
                    estado_txt = "readonly";
                    request.setAttribute("estado_input", estado_txt);
                    cargar_datos_agregados(request, response);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                } else {
                    // mostrar emnsaje de no creado

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                }

            }

        }

        // AGREGAR GRASAS
        if (request.getParameter("btn_agregar_grasa") != null) {

            double cantidad = Double.valueOf(request.getParameter("txt_cantidad_gr"));

            if (Integer.parseInt(request.getParameter("listado_gr")) >= 1) {

                id_dinamico = Integer.parseInt(request.getParameter("listado_gr"));

                IProducto nuevo_producto = new Producto();

                int nuevo_id_pro = 0;

                nuevo_id_pro = nuevo_producto.id_ultimo_registro();

                IProducto_Grasa nuevo_proGra = new Producto_Grasa(nuevo_id_pro, id_dinamico, cantidad, "A");

                if (nuevo_proGra.agregar_productoGrasa()) {
                    // mostrar mensaje de creacion

                    verificar = "si_grasa";
                    request.setAttribute("activador", verificar);
                    estado_txt = "readonly";
                    request.setAttribute("estado_input", estado_txt);
                    cargar_datos_agregados(request, response);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                } else {
                    // mostrar emnsaje de no creado

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                }

            }

        }

        // AGREGAR MACRONUTRIENTES
        if (request.getParameter("btn_agregar_macro") != null) {

            double cantidad = Double.valueOf(request.getParameter("txt_cantidad_mac"));

            if (Integer.parseInt(request.getParameter("listado_macro")) >= 1) {

                id_dinamico = Integer.parseInt(request.getParameter("listado_macro"));

                IProducto nuevo_producto = new Producto();

                int nuevo_id_pro = 0;

                nuevo_id_pro = nuevo_producto.id_ultimo_registro();

                IProducto_Macronutriente nuevo_proMacro = new Producto_Macronutriente(nuevo_id_pro, id_dinamico, cantidad, "A");

                if (nuevo_proMacro.agregar_productoMacronutriente()) {
                    // mostrar mensaje de creacion

                    verificar = "si_macro";
                    request.setAttribute("activador", verificar);
                    estado_txt = "readonly";
                    request.setAttribute("estado_input", estado_txt);
                    cargar_datos_agregados(request, response);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                } else {
                    // mostrar emnsaje de no creado

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_nutrientes(request, response);
                    request.getRequestDispatcher("AgregarProductoPage.jsp").forward(request, response);

                }

            }

        }
    }

    private void cargar_datos_agregados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("txt_nombre");
        String parte_analizada = request.getParameter("txt_parte_analizada");

        request.setAttribute("name_reg", nombre);
        request.setAttribute("part_reg", parte_analizada);
        request.setAttribute("product_reg", nombre);

    }

}
