package Logica;

import Interface.IGrasa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Grasa implements IGrasa {

    public int id_grasa;
    public String nombre_grasa;
    public String unid_medida_grasa;
    public String estado_grasa;

    public Grasa(int id_grasa, String nombre_grasa, String unid_medida_grasa, String estado_grasa) {
        this.id_grasa = id_grasa;
        this.nombre_grasa = nombre_grasa;
        this.unid_medida_grasa = unid_medida_grasa;
        this.estado_grasa = estado_grasa;
    }

    public Grasa() {
    }

    @Override
    public boolean agregar_grasa() {
        String Query = "insert into grasa(nombre_grasa,unid_medida_grasa,estado_grasa)"
                + " values(?,?,?);";
        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_grasa);
            conector_bd.sql.setString(2, this.unid_medida_grasa);
            conector_bd.sql.setString(3, this.estado_grasa);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;
    }

    @Override
    public Grasa consultar_por_id_grasas(int key_id) {

        ConexionMysql conector_bd;
        Grasa grasa = null;
        String Query = "select * from grasa where id_grasa=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                grasa = new Grasa(
                        consulta_bd.getInt("id_grasa"),
                        consulta_bd.getString("nombre_grasa"),
                        consulta_bd.getString("unid_medida_grasa"),
                        consulta_bd.getString("estado_grasa")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return grasa;

    }

    @Override
    public boolean modificar_grasa() {

        String Query = "update grasa set nombre_grasa=?, unid_medida_grasa=?,estado_grasa=? where id_grasa=?;";
        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_grasa);
            conector_bd.sql.setString(2, this.unid_medida_grasa);
            conector_bd.sql.setString(3, this.estado_grasa);
            conector_bd.sql.setInt(4, this.id_grasa);

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
    public List<Grasa> consultar_grasas() {
        ConexionMysql conector_bd;
        String Query = " select * from grasa;";
        List<Grasa> lista_grasas = new ArrayList<Grasa>();
        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_grasa = resultado.getInt("id_grasa");
                this.nombre_grasa = resultado.getString("nombre_grasa");
                this.unid_medida_grasa = resultado.getString("unid_medida_grasa");
                this.estado_grasa = resultado.getString("estado_grasa");

                Grasa grasa = new Grasa(id_grasa, nombre_grasa, unid_medida_grasa, estado_grasa);

                lista_grasas.add(grasa);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_grasas;

    }

}
