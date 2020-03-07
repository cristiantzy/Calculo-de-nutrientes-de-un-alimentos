package Interface;

import Logica.Recomendacion;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IRecomendacion {

    public boolean agregar_recomendacion();

    public Recomendacion consultar_por_id_recomendacion(int key_id);

    public boolean modificar_recomendacion();

    public List<Recomendacion> consultar_recomendacion();

    public List<Recomendacion> consultar_aletoria();

    public boolean actualizar_foto();

    public boolean guardar_img_directory(Part archivo_img, String nombre_img);

    public boolean eliminar_img_directory();

}
