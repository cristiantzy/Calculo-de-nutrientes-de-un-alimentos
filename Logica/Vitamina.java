package Logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Interface.IVitamina;

/**
 *
 * @author Cristian_Tisoy
 */
public class Vitamina implements IVitamina {

    public int id_vitaminas;
    public String nombre_vitamina;
    public String unid_medida_vitamina;
    public String estado_vitamina;

    public Vitamina(int id_vitaminas, String nombre_vitamina, String unid_medida_vitamina, String estado_vitamina) {
        this.id_vitaminas = id_vitaminas;
        this.nombre_vitamina = nombre_vitamina;
        this.unid_medida_vitamina = unid_medida_vitamina;
        this.estado_vitamina = estado_vitamina;
    }

    public Vitamina() {
    }

    @Override
    public boolean agregar_vitaminas() {
        String Query = "insert into vitamina(nombre_vitamina,unid_medida_vitamina,"
                + "estado_vitamina) values(?,?,?);";
        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setString(1, this.nombre_vitamina);
            conector_bd.sql.setString(2, this.unid_medida_vitamina);
            conector_bd.sql.setString(3, this.estado_vitamina);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;
    }

    @Override
    public Vitamina consultar_por_id_vitaminas(int id_v) {

        ConexionMysql conector_bd;

        Vitamina vitaminas = null;
        String Query = " select * from vitamina where id_vitamina=?;";
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, id_v);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                vitaminas = new Vitamina(
                        consulta_bd.getInt("id_vitamina"),
                        consulta_bd.getString("nombre_vitamina"),
                        consulta_bd.getString("unid_medida_vitamina"),
                        consulta_bd.getString("estado_vitamina")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return vitaminas;
    }

    @Override
    public boolean modificar_vitaminas() {
        String Query = "UPDATE vitamina SET nombre_vitamina=?,unid_medida_vitamina=?,estado_vitamina=? WHERE id_vitamina=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_vitamina);
            conector_bd.sql.setString(2, this.unid_medida_vitamina);
            conector_bd.sql.setString(3, this.estado_vitamina);
            conector_bd.sql.setInt(4, this.id_vitaminas);

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
    public List<Vitamina> consultar_vitaminas() {
        ConexionMysql conector_bd;

        String Query = " select * from vitamina;";

        List<Vitamina> lista_vitamina = new ArrayList<Vitamina>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_vitaminas = resultado.getInt("id_vitamina");
                this.nombre_vitamina = resultado.getString("nombre_vitamina");
                this.unid_medida_vitamina = resultado.getString("unid_medida_vitamina");
                this.estado_vitamina = resultado.getString("estado_vitamina");

                Vitamina vitamina = new Vitamina(id_vitaminas, nombre_vitamina, unid_medida_vitamina, estado_vitamina);

                lista_vitamina.add(vitamina);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_vitamina;
    }

}
