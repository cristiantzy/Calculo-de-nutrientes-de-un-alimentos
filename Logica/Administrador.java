/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interface.IAdministrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Administrador implements IAdministrador {

    public int id_administrador;
    public String nombre_admin;
    public String apellido_admin;
    public String estado_admin;
    public int fkIdUsuario;

    public Administrador(int id_administrador, String nombre_admin, String apellido_admin, String estado_admin, int fkIdUsuario) {
        this.id_administrador = id_administrador;
        this.nombre_admin = nombre_admin;
        this.apellido_admin = apellido_admin;
        this.estado_admin = estado_admin;
        this.fkIdUsuario = fkIdUsuario;
    }

    public Administrador() {
    }

    @Override
    public boolean registrarAdministrador() {
        String Query = "insert into administrador(nombre_admin,apellido_admin,estado_admin,fk_idUsuario) values(?,?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_admin);
            conector_bd.sql.setString(2, this.apellido_admin);
            conector_bd.sql.setString(3, this.estado_admin);
            conector_bd.sql.setInt(4, this.fkIdUsuario);

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
    public Administrador consultarAdministrador(String user) {
        ConexionMysql conector_bd;

        Administrador administrador = null;
        String Query = "select nombre_admin, apellido_admin from administrador inner join usuario on fk_idUsuario=idUsuario where user_u=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setString(1, user);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                administrador = new Administrador(0,
                        consulta_bd.getString("nombre_admin"),
                        consulta_bd.getString("apellido_admin"),
                        "",
                        0
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return administrador;
    }

    @Override
    public boolean modificarAdministrador() {

        String Query = " update administrador inner join usuario on fk_idUsuario=idUsuario set nombre_admin=?, apellido_admin=?,user_u=? where fk_idUsuario=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_admin);
            conector_bd.sql.setString(2, this.apellido_admin);
            conector_bd.sql.setString(3, this.estado_admin);
            conector_bd.sql.setInt(4, this.fkIdUsuario);

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
    public List<Administrador> consultaAdminUser() {
        String Query = "select * from administrador inner join usuario on fk_idUsuario=idUsuario;";
        ConexionMysql conector_bd;

        List<Administrador> lista_admin = new ArrayList<Administrador>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_administrador = resultado.getInt("id_administrador");
                this.nombre_admin = resultado.getString("nombre_admin");
                this.apellido_admin = resultado.getString("apellido_admin");

                Administrador administrador = new Administrador(id_administrador, nombre_admin, apellido_admin, "", 0);

                lista_admin.add(administrador);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_admin;

    }

}
