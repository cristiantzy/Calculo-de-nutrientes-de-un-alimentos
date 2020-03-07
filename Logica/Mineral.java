/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Interface.IMineral;

/**
 *
 * @author Cristian_Tisoy
 */
public class Mineral implements IMineral {

    public int id_minerales;
    public String nombre_minerales;
    public String unid_medida_minerales;
    public String estado_minerales;

    public Mineral(int id_minerales, String nombre_minerales, String unid_medida_minerales, String estado_minerales) {
        this.id_minerales = id_minerales;
        this.nombre_minerales = nombre_minerales;
        this.unid_medida_minerales = unid_medida_minerales;
        this.estado_minerales = estado_minerales;
    }

    public Mineral() {
    }

    @Override
    public boolean agregar_minerales() {
        String Query = "insert into mineral(nombre_mineral,unid_medida_mineral,estado_mineral)"
                + " values(?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_minerales);
            conector_bd.sql.setString(2, this.unid_medida_minerales);
            conector_bd.sql.setString(3, this.estado_minerales);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;
    }

    @Override
    public Mineral consultar_por_id_minerales(int key_id) {

        ConexionMysql conector_bd;
        Mineral mineral = null;
        String Query = "select * from mineral where id_mineral=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                mineral = new Mineral(
                        consulta_bd.getInt("id_mineral"),
                        consulta_bd.getString("nombre_mineral"),
                        consulta_bd.getString("unid_medida_mineral"),
                        consulta_bd.getString("estado_mineral")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return mineral;

    }

    @Override
    public boolean modificar_minerales() {
        String Query = "update mineral set nombre_mineral=?,unid_medida_mineral=?,estado_mineral=? where id_mineral=?;";

        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_minerales);
            conector_bd.sql.setString(2, this.unid_medida_minerales);
            conector_bd.sql.setString(3, this.estado_minerales);
            conector_bd.sql.setInt(4, this.id_minerales);

            conector_bd.sql.executeUpdate();

            conector_bd.sql.close();
            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;

    }

    @Override
    public List<Mineral> consultar_minerales() {
        ConexionMysql conector_bd;

        String Query = "select * from mineral;";

        List<Mineral> lista_mineral = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_minerales = resultado.getInt("id_mineral");
                this.nombre_minerales = resultado.getString("nombre_mineral");
                this.unid_medida_minerales = resultado.getString("unid_medida_mineral");
                this.estado_minerales = resultado.getString("estado_mineral");

                Mineral mineral = new Mineral(id_minerales, nombre_minerales, unid_medida_minerales, estado_minerales);

                lista_mineral.add(mineral);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_mineral;

    }

}
