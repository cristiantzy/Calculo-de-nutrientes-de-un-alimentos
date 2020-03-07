/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Usuario;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public interface IUsuario {

    public boolean registrarUsuario();

    public int consultar_id_usuario(String username);

    public Usuario consultarUsuario(String user);

    public boolean modificarUsuario();

    public boolean verificar_registroBD();

    public boolean verificar_credenciales();

    public List<Usuario> consultaAdminUser();
    
   

}
