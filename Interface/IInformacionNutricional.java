/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.InformacionNutricional;



/**
 *
 * @author Cristian_Tisoy
 */
public interface IInformacionNutricional {
   // llenar lista con los metodos desde BD 
   public InformacionNutricional calcular_nutrientes(int id_producto);    

 
    public Double formatearDecimales(double numero, Integer numeroDecimales);
    
    public Double total_calorias(int id_producto);
    
    // calorias por gramo
    public Double total_carbohidratos(int id_producto);
    public Double total_grasas(int id_producto);
    public Double total_proteina(int id_producto);
    
}
