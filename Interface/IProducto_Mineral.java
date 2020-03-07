
package Interface;

import Logica.Producto_Mineral;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IProducto_Mineral {
     boolean agregar_productoMineral();

     List<Producto_Mineral> consultar_por_id_productoMineral(int key_id);
    
     boolean modificar_productoMineral();

    
   

    
}
