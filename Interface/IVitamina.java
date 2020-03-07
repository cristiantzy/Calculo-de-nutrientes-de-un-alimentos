/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Vitamina;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IVitamina {

    public boolean agregar_vitaminas();

    public boolean modificar_vitaminas();

    public List<Vitamina> consultar_vitaminas();

    public Vitamina consultar_por_id_vitaminas(int key_id);

}
