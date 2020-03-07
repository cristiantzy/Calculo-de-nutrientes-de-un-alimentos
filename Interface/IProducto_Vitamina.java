package Interface;

import Logica.Producto_Vitamina;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IProducto_Vitamina {

    boolean agregar_productoVitamina();

    List<Producto_Vitamina> consultar_por_id_productoVitamina(int key_id);

    boolean modificar_productoVitamina();

}
