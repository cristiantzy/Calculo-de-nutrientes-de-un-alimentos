/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Producto_Grasa;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IProducto_Grasa {

    boolean agregar_productoGrasa();

    List<Producto_Grasa> consultar_por_id_productoGrasas(int key_id);

    boolean modificar_productoGrasa();

}
