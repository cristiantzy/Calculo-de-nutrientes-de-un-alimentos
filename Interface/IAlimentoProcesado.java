/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.AlimentoProcesado;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IAlimentoProcesado {

    public boolean agregar_alimentoProcesado();

    public AlimentoProcesado consultar_por_id_alimentoProcesado(int key_id);

    public boolean modificar_alimentoProcesado();

    public List<AlimentoProcesado> consultar_alimentoProcesado();

    public List<AlimentoProcesado> consultar_aletoria(); // para mostrarle los alimentos al cliente

    public boolean actualizar_foto();

    public boolean guardar_img_directory(Part archivo_img, String nombre_img);

    public boolean eliminar_img_directory();

}
