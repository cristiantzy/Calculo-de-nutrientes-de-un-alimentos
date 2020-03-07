/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSDL;

import Logica.DietaBalanceada;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Cristian_Tisoy
 */
@WebService(serviceName = "Dieta_BalanceadaWebService")
public class Dieta_BalanceadaWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
//    @WebMethod(operationName = "ver_dieta_balanceada")
//    public List<DietaBalanceada> ver_dieta_balanceada() {
//
//        DietaBalanceada nueva_dieta = new DietaBalanceada();
//
//        List<DietaBalanceada> listado_dietas = new ArrayList<>();
//
//        listado_dietas = nueva_dieta.consultar_dietaBalanceada();
//
//        return listado_dietas;
//    }
//    

}
