/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Grasa;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IGrasa {

    public boolean agregar_grasa();

    public Grasa consultar_por_id_grasas(int key_id);

    public boolean modificar_grasa();

    public List<Grasa> consultar_grasas();

}
