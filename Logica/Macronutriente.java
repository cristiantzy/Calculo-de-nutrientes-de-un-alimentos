package Logica;

import Interface.IMacronutriente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Macronutriente implements IMacronutriente {

    public int idmacronutriente;
    public String nombre_macro_nut;
    public String unid_medida_macro_nut;
    public String estado_macro;

    public Macronutriente(int idmacronutriente, String nombre_macro_nut, String unid_medida_macro_nut, String estado_macro) {
        this.idmacronutriente = idmacronutriente;
        this.nombre_macro_nut = nombre_macro_nut;
        this.unid_medida_macro_nut = unid_medida_macro_nut;
        this.estado_macro = estado_macro;
    }

    public Macronutriente() {
    }

    @Override
    public boolean agregar_macronutriente() {

        String Query = "insert into macronutriente(nombre_macro_nut,unid_medida_macro_nut,estado_macro)"
                + " values(?,?,?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_macro_nut);
            conector_bd.sql.setString(2, this.unid_medida_macro_nut);
            conector_bd.sql.setString(3, this.estado_macro);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;

    }

    @Override
    public Macronutriente consultar_por_id_macronutriente(int key_id) {

        ConexionMysql conector_bd;

        Macronutriente macronutriente = null;
        String Query = "select * from macronutriente where id_macronutriente=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                macronutriente = new Macronutriente(
                        consulta_bd.getInt("id_macronutriente"),
                        consulta_bd.getString("nombre_macro_nut"),
                        consulta_bd.getString("unid_medida_macro_nut"),
                        consulta_bd.getString("estado_macro")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return macronutriente;

    }

    @Override
    public boolean modificar_macronutriente() {
        String Query = "update macronutriente set nombre_macro_nut=?,unid_medida_macro_nut=?,estado_macro=? where id_macronutriente=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_macro_nut);
            conector_bd.sql.setString(2, this.unid_medida_macro_nut);
            conector_bd.sql.setString(3, this.estado_macro);
            conector_bd.sql.setInt(4, this.idmacronutriente);

            conector_bd.sql.executeUpdate();

            conector_bd.sql.close();
            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error Update BD! -> " + e);
        }

        return false;

    }

    @Override
    public List<Macronutriente> consultar_macronutriente() {

        ConexionMysql conector_bd;

        String Query = "select * from macronutriente;";

        List<Macronutriente> lista_macronutriente = new ArrayList<Macronutriente>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.idmacronutriente = resultado.getInt("id_macronutriente");
                this.nombre_macro_nut = resultado.getString("nombre_macro_nut");
                this.unid_medida_macro_nut = resultado.getString("unid_medida_macro_nut");
                this.estado_macro = resultado.getString("estado_macro");

                Macronutriente macronutriente = new Macronutriente(idmacronutriente, nombre_macro_nut, unid_medida_macro_nut, estado_macro);

                lista_macronutriente.add(macronutriente);

            }

            conector_bd.desconectar();

        } catch (Exception e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_macronutriente;

    }
}
