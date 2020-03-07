package Servlets;

import Interface.IAlimentoProcesado;
import Logica.AlimentoProcesado;
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
@WebServlet(name = "ModificarAlimentoProcServlet", urlPatterns = {"/ModificarAlimentoProcServlet"})
@MultipartConfig

public class ModificarAlimentoProcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mostrar_alimentos_proc(request, response);
    }

    private void mostrar_alimentos_proc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IAlimentoProcesado alimento_proc = new AlimentoProcesado(0, "", "", null);
        List<AlimentoProcesado> lista_alimento_proc = alimento_proc.consultar_alimentoProcesado();
        request.setAttribute("lista_combox", lista_alimento_proc);
        request.setAttribute("lista_datos_tabla", lista_alimento_proc);
        request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_alimento_proc = 0;

        String verificar = "";

        // traer los datos de la base de datos
        if (request.getParameter("btn_consultar") != null) {
            IAlimentoProcesado alimento_proc = new AlimentoProcesado(0, "", "", null);
            AlimentoProcesado alimento_proc_aux = null;

            // validar que haya seleccionado 1 items al menos
            if (Integer.parseInt(request.getParameter("listado_alimento_proc")) >= 1) {
                id_alimento_proc = Integer.parseInt(request.getParameter("listado_alimento_proc"));

                alimento_proc_aux = alimento_proc.consultar_por_id_alimentoProcesado(id_alimento_proc);
                request.setAttribute("datos_dieta", alimento_proc_aux);
                mostrar_alimentos_proc(request, response);
                //request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
            } else {
                // no seleeciono nada. mostrar mensaje
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_alimentos_proc(request, response);
               // request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
            }

        }

        // guardar los datos
        if (request.getParameter("btn_modificar") != null) {

            id_alimento_proc = Integer.parseInt(request.getParameter("txt_id"));
            String nombre = request.getParameter("txt_nombre_mod");
            String descrip = request.getParameter("txt_descrip");

            if (!nombre.equalsIgnoreCase("")) {
                IAlimentoProcesado alimento_proc = new AlimentoProcesado(id_alimento_proc, nombre, descrip, null);

                if (alimento_proc.modificar_alimentoProcesado()) {
                    verificar = "si";

                    request.setAttribute("activador", verificar);
                    mostrar_alimentos_proc(request, response);
                    //request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
                } else {
                    verificar = "no";
                    request.setAttribute("activador", verificar);
                    mostrar_alimentos_proc(request, response);
                   // request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
                }
            } else {
                verificar = "no";
                request.setAttribute("activador", verificar);
                mostrar_alimentos_proc(request, response);
               // request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
            }

        }

        // actualizar foto
        if (request.getParameter("btn_actualizar_foto") != null) {

            IAlimentoProcesado alimento;

            id_alimento_proc = Integer.parseInt(request.getParameter("txt_id"));

            Part archivo_img = request.getPart("txt_img");

            String nombre_img = request.getParameter("nombre");

            alimento = new AlimentoProcesado(id_alimento_proc, "", "", nombre_img);

            if (alimento.eliminar_img_directory()) {

                if (alimento.guardar_img_directory(archivo_img, nombre_img)) {
                    
                    AlimentoProcesado alimento_proc_aux = null;
                    if (alimento.actualizar_foto()) {
                        
                        
                        //mostrar todo en el mismo campo
                        alimento_proc_aux = alimento.consultar_por_id_alimentoProcesado(id_alimento_proc);
                        request.setAttribute("datos_dieta", alimento_proc_aux);

                        verificar = "foto_update";
                        request.setAttribute("activador", verificar);
                        
                        mostrar_alimentos_proc(request, response);
                       // request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);

                    } else {
                        verificar = "no_foto_update";
                        request.setAttribute("activador", verificar);
                        mostrar_alimentos_proc(request, response);
                      //  request.getRequestDispatcher("ModificarAlimentoProcPage.jsp").forward(request, response);
                    }
                    
                } else {
                    verificar = "no_foto_update";
                    request.setAttribute("activador", verificar);
                    mostrar_alimentos_proc(request, response);
                }

            } else {
                verificar = "no_foto_update";
                request.setAttribute("activador", verificar);
                mostrar_alimentos_proc(request, response);
            }

        }

    }

}
