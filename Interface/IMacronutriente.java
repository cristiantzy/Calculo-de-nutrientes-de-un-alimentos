package Interface;

import Logica.Macronutriente;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IMacronutriente {

    public boolean agregar_macronutriente();

    public Macronutriente consultar_por_id_macronutriente(int key_id);

    public boolean modificar_macronutriente();

    public List<Macronutriente> consultar_macronutriente();

}
