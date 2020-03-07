package Servlets;

import Interface.IAlimentoProcesado;
import Logica.AlimentoProcesado;
import java.io.IOException;
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
@WebServlet(name = "AgregarAlimentoProcServlet", urlPatterns = {"/AgregarAlimentoProcServlet"})
@MultipartConfig
public class AgregarAlimentoProcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String verificar = "";

        if (request.getParameter("btn_agregar") != null) {
            IAlimentoProcesado alimento = new AlimentoProcesado();

            // Guardar la img en la ruta del proyecto
            String nombre_foto = request.getParameter("nombre");
            Part archivo_foto = request.getPart("txt_img");

            if (alimento.guardar_img_directory(archivo_foto, nombre_foto)) {

                String nombre = request.getParameter("txt_nombre");
                String descripcion = request.getParameter("txt_descrip");
               
                alimento = new AlimentoProcesado(0, nombre, descripcion, nombre_foto);

                if (alimento.agregar_alimentoProcesado()) {
                    verificar = "si";
                } else {
                    verificar = "no";
                }

            } else {
                verificar = "no";

            }

            request.setAttribute("activador", verificar);
            request.getRequestDispatcher("AgregarAlimentoProcPage.jsp").forward(request, response);

        }

    }

}
