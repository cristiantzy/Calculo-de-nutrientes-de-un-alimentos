/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Producto_Macronutriente;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IProducto_Macronutriente {

    boolean agregar_productoMacronutriente();

    List<Producto_Macronutriente> consultar_por_id_productoMacronutriente(int key_id);

    boolean modificar_productoMacronutriente();

}
