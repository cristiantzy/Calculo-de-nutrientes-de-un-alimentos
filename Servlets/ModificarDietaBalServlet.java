package Servlets;

import Interface.IDietaBalanceada;
import Logica.DietaBalanceada;
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
 *
 * @author Cristian_Tisoy
 */
@WebServlet(name = "ModificarDietaBalServlet", urlPatterns = {"/ModificarDietaBalServlet"})
@MultipartConfig
public class ModificarDietaBalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_dieta_bal(request, response);
    }

    // mostrar listado, cada que el JSP haga un envio a la BD
    private void mostrar_dieta_bal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IDietaBalanceada dieta_bal = new DietaBalanceada(0, "", "", null, 0);
        List<DietaBalanceada> lista_dieta_bal = dieta_bal.consultar_dietaBalanceada();
        request.setAttribute("lista_combox", lista_dieta_bal);
        request.setAttribute("lista_datos_tabla", lista_dieta_bal);
        request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_dieta_bal = 0;
        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {
            IDietaBalanceada dieta_bal = new DietaBalanceada(0, "", "", null, 0);
            DietaBalanceada dieta_bal_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_dieta_bal")) >= 1) {
                id_dieta_bal = Integer.parseInt(request.getParameter("listado_dieta_bal"));

                dieta_bal_aux = dieta_bal.consultar_por_id_dietaBalanceada(id_dieta_bal);

                request.setAttribute("datos_dieta", dieta_bal_aux);
                mostrar_dieta_bal(request, response);
                // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_dieta_bal(request, response);
                // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_dieta_bal = Integer.parseInt(request.getParameter("txt_id"));
            String nombre = request.getParameter("txt_nombre_mod");
            String descrip = request.getParameter("txt_descrip");

            if (!nombre.equalsIgnoreCase("")) {

                IDietaBalanceada dieta_bal = new DietaBalanceada(id_dieta_bal, nombre, descrip, null, 0);

                if (dieta_bal.modificar_dietaBalanceada()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_dieta_bal(request, response);
                    // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

                } else {

                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_dieta_bal(request, response);
                    // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_dieta_bal(request, response);
                // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

            }

        }

        // actualizar foto
        if (request.getParameter("btn_actualizar_foto") != null) {
            // 1). eliminar la foto actual
            IDietaBalanceada dieta_bal;

            id_dieta_bal = Integer.parseInt(request.getParameter("txt_id"));

            Part archivo_img = request.getPart("txt_img");

            String nombre_img = request.getParameter("nombre");

            dieta_bal = new DietaBalanceada(id_dieta_bal, "", "", nombre_img, 0);

            if (dieta_bal.eliminar_img_directory()) {

                if (dieta_bal.guardar_img_directory(archivo_img, nombre_img)) {

                    DietaBalanceada dieta_bal_aux = null;
                    if (dieta_bal.actualizar_foto()) {
                        
                        //mostrar todo en el mismo campo
                        dieta_bal_aux = dieta_bal.consultar_por_id_dietaBalanceada(id_dieta_bal);
                        request.setAttribute("datos_dieta", dieta_bal_aux);

                        verificar = "foto_update";
                        request.setAttribute("activador", verificar);
                        // retornar desde aqui para mostrar la foto actualizada
                        mostrar_dieta_bal(request, response);

                        //  request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);
                    } else {

                        verificar = "no_foto_update";
                        request.setAttribute("activador", verificar);
                        mostrar_dieta_bal(request, response);
                        // request.getRequestDispatcher("ModificarDietaBalPage.jsp").forward(request, response);

                    }
                } else {
                    verificar = "no_foto_update";
                    request.setAttribute("activador", verificar);
                    mostrar_dieta_bal(request, response);

                }

            } else {
                verificar = "no_foto_update";
                request.setAttribute("activador", verificar);
                mostrar_dieta_bal(request, response);
            }

        }

    }

}
