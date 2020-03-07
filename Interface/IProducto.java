package Interface;

import Logica.Producto;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IProducto {

    public boolean agregar_producto();

    public boolean modificar_producto();

    public List<Producto> consultar_productos();

    public Producto consulta_producto_por_id(int id_key);

    public boolean agregarNutrientes();

    public int id_ultimo_registro();

    public boolean producto_repetido(String nombre_producto, String parte_analizada);
}
