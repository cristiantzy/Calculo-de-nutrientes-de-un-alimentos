package Interface;

import Logica.DietaBalanceada;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IDietaBalanceada {

    public boolean agregar_dietaBalanceada();

    public DietaBalanceada consultar_por_id_dietaBalanceada(int key_id);

    public boolean modificar_dietaBalanceada();

    // este metodo es para consultar, Administrador de Cliente.
    public List<DietaBalanceada> consultar_dietaBalanceada();

    public List<DietaBalanceada> consultar_aletoria();

    public boolean actualizar_foto();

    public boolean guardar_img_directory(Part archivo_img, String nombre_img);

    public boolean eliminar_img_directory();

}
