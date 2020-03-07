/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interface.IRecomendacion;
import Logica.Recomendacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
@WebServlet(name = "ModificarRecomendacionesServlet", urlPatterns = {"/ModificarRecomendacionesServlet"})
@MultipartConfig
public class ModificarRecomendacionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        mostrar_recomendacion(request, response);

    }

    private void mostrar_recomendacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRecomendacion recomendacion = new Recomendacion(0, "", "", null, 0);

        List<Recomendacion> lista_recomendacion = recomendacion.consultar_recomendacion();

        request.setAttribute("lista_combox", lista_recomendacion);
        request.setAttribute("lista_datos_tabla", lista_recomendacion);

        request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_recomendacion = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {

            IRecomendacion recomendacion = new Recomendacion(0, "", "", null, 0);
            Recomendacion recomendacion_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_recomendacion")) >= 1) {
                id_recomendacion = Integer.parseInt(request.getParameter("listado_recomendacion"));

                recomendacion_aux = recomendacion.consultar_por_id_recomendacion(id_recomendacion);

                request.setAttribute("datos_dieta", recomendacion_aux);
                mostrar_recomendacion(request, response);
                // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_recomendacion(request, response);
                // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_recomendacion = Integer.parseInt(request.getParameter("txt_id"));
            String nombre = request.getParameter("txt_nombre_mod");
            String descrip = request.getParameter("txt_descrip");

            if (!nombre.equalsIgnoreCase("")) {

                IRecomendacion recomendacion = new Recomendacion(id_recomendacion, nombre, descrip, null, 0);

                if (recomendacion.modificar_recomendacion()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_recomendacion(request, response);
                    // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_recomendacion(request, response);
                    // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_recomendacion(request, response);
                // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

            }

        }

        // actualizar foto
        if (request.getParameter("btn_actualizar_foto") != null) {
            IRecomendacion recomendacion;

            id_recomendacion = Integer.parseInt(request.getParameter("txt_id"));

            Part archivo_img = request.getPart("txt_img");

            String nombre_img = request.getParameter("nombre");

            recomendacion = new Recomendacion(id_recomendacion, "", "", nombre_img, 0);

            if (recomendacion.eliminar_img_directory()) {

                if (recomendacion.guardar_img_directory(archivo_img, nombre_img)) {

                    Recomendacion recomendacion_aux = null;

                    if (recomendacion.actualizar_foto()) {
                        //mostrar todo en el mismo campo
                        recomendacion_aux = recomendacion.consultar_por_id_recomendacion(id_recomendacion);

                        request.setAttribute("lista_recomendacion2", recomendacion_aux);

                        verificar = "foto_update";
                        request.setAttribute("activador", verificar);
                        mostrar_recomendacion(request, response);
                        //request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

                    } else {

                        verificar = "no_foto_update";
                        request.setAttribute("activador", verificar);
                        mostrar_recomendacion(request, response);
                        // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

                    }

                } else {
                    verificar = "no_foto_update";
                    request.setAttribute("activador", verificar);
                    mostrar_recomendacion(request, response);
                    // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no_foto_update";
                request.setAttribute("activador", verificar);
                mostrar_recomendacion(request, response);
                // request.getRequestDispatcher("ModificarRecomendacionesPage.jsp").forward(request, response);

            }

        }

    }

}
