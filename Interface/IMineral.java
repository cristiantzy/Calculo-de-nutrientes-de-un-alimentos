package Interface;

import Logica.Mineral;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IMineral {

    public boolean agregar_minerales();

    public Mineral consultar_por_id_minerales(int key_id);

    public boolean modificar_minerales();

    public List<Mineral> consultar_minerales();

}
