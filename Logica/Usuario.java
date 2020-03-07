/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interface.IUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Usuario implements IUsuario {

    public int id_usuario;
    public String user_u;
    public String password_u;
    public String privilegio_u;
    public String estado_u;

    ConexionMysql conectarMysql;

    public Usuario(int id_usuario, String user_u, String password_u, String privilegio_u, String estado_u) {
        this.id_usuario = id_usuario;
        this.user_u = user_u;
        this.password_u = password_u;
        this.privilegio_u = privilegio_u;
        this.estado_u = estado_u;
    }

    public Usuario() {
    }

    @Override
    public boolean registrarUsuario() {

        String Query = "insert into usuario(user_u,password_u,privilegio_u) values(?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.user_u);
            conector_bd.sql.setString(2, this.password_u);
            conector_bd.sql.setString(3, this.privilegio_u);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        try {
            conector_bd.desconectar();
        } catch (SQLException e) {
        }

        return false;

    }

    @Override
    public int consultar_id_usuario(String username) {
        ConexionMysql conector_bd;

        int id_usuario_aux = 666;

        String Query = "select * from usuario where user_u=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setString(1, username);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {

                id_usuario_aux = consulta_bd.getInt("idUsuario");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consulta idUsario " + e);
        }

        return id_usuario_aux;

    }

    @Override
    public Usuario consultarUsuario(String user) {
        ConexionMysql conector_bd;

        Usuario usuario = null;
        String Query = "select user_u, password_u from usuario where user_u =?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setString(1, user);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                usuario = new Usuario(0,
                        consulta_bd.getString("user_u"),
                        consulta_bd.getString("password_u"),
                        "",
                        ""
                );
            }

            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return usuario;

    }

    @Override
    public boolean modificarUsuario() {
        String Query = "update usuario set password_u=? where idUsuario=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.password_u);
            conector_bd.sql.setInt(2, this.id_usuario);

            conector_bd.sql.executeUpdate();

            conector_bd.sql.close();
            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error UPDATE BD! -> " + e);
        }

        return false;
    }

    @Override
    public boolean verificar_registroBD() {
        boolean verificar = false;

        String Query_u = "select user_u from usuario where user_u='" + this.user_u + "';";

        String Query_p = "select password_u from usuario where password_u='" + this.password_u + "';";

        this.conectarMysql = new ConexionMysql();

        this.conectarMysql.conexion = conectarMysql.getConnection();

        try {

            //verificar el usuario
            this.conectarMysql.sql = this.conectarMysql.conexion.prepareStatement(Query_u);

            this.conectarMysql.consulta = this.conectarMysql.sql.executeQuery();
            if (this.conectarMysql.consulta.next()) {
                verificar = true;
            }

            // verificar la password
            this.conectarMysql.sql = this.conectarMysql.conexion.prepareStatement(Query_p);

            this.conectarMysql.consulta = this.conectarMysql.sql.executeQuery();
            if (this.conectarMysql.consulta.next()) {
                verificar = true;
            }

            conectarMysql.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta " + e);
        }

        return verificar;
    }

    @Override
    public boolean verificar_credenciales() {

        String Query_u = "select user_u,password_u from usuario where user_u='" + this.user_u + "';";

        String aux_user = "";
        String aux_pass = "";

        this.conectarMysql = new ConexionMysql();
        this.conectarMysql.conexion = conectarMysql.getConnection();

        try {
            this.conectarMysql.sql = this.conectarMysql.conexion.prepareStatement(Query_u);

            this.conectarMysql.consulta = this.conectarMysql.sql.executeQuery();

            if (this.conectarMysql.consulta.next()) {
                aux_user = this.conectarMysql.consulta.getString("user_u");
                aux_pass = this.conectarMysql.consulta.getString("password_u");

                if (this.user_u.equalsIgnoreCase(aux_user) && this.password_u.equalsIgnoreCase(aux_pass)) {
                    return true;
                }
            }

        
        } catch (SQLException e) {

            System.out.println("Error en la verificacion de credenciales " + e);
        }
        
        try {
            conectarMysql.desconectar();
        } catch (SQLException e) {
        }

        return false;
    }

    @Override
    public List<Usuario> consultaAdminUser() {
        String Query = "select * from administrador inner join usuario on fk_idUsuario=idUsuario;";
        ConexionMysql conector_bd;

        List<Usuario> lista_user = new ArrayList<Usuario>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.user_u = resultado.getString("user_u");
                this.password_u = resultado.getString("password_u");

                Usuario usuario = new Usuario(0, user_u, password_u, "", "");

                lista_user.add(usuario);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_user;

    }

}
