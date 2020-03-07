package Logica;

import Interface.IProducto_Macronutriente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Producto_Macronutriente implements IProducto_Macronutriente {

    public int fk_id_producto;
    public int fk_id_macronutriente;
    public double cantidad_macro;
    public String estado_macro;

    public Producto_Macronutriente(int fk_id_producto, int fk_id_macronutriente, double cantidad_macro, String estado_macro) {
        this.fk_id_producto = fk_id_producto;
        this.fk_id_macronutriente = fk_id_macronutriente;
        this.cantidad_macro = cantidad_macro;
        this.estado_macro = estado_macro;
    }

    public Producto_Macronutriente() {
    }

    @Override
    public boolean agregar_productoMacronutriente() {
        if (modificar_productoMacronutriente()) {
            return true;
        }

        return false;
    }

    @Override
    public List<Producto_Macronutriente> consultar_por_id_productoMacronutriente(int key_id) {

        ConexionMysql conector_bd;

        String Query = "select cantidad_macro from producto inner join producto_macronutriente on id_producto=fk_id_producto "
                + "inner join macronutriente on fk_id_macronutriente=id_macronutriente where id_producto='" + key_id + "';";

        List<Producto_Macronutriente> lista_proMacro = new ArrayList<Producto_Macronutriente>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.cantidad_macro = resultado.getDouble("cantidad_macro");

                Producto_Macronutriente nuevo_proMacro = new Producto_Macronutriente(1, 2, this.cantidad_macro, "");

                lista_proMacro.add(nuevo_proMacro);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_proMacro;
    }

    @Override
    public boolean modificar_productoMacronutriente() {
        String Query = "update producto_macronutriente set cantidad_macro=? where (fk_id_producto=? and fk_id_macronutriente=?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setDouble(1, this.cantidad_macro);
            conector_bd.sql.setInt(2, this.fk_id_producto);
            conector_bd.sql.setInt(3, this.fk_id_macronutriente);

            conector_bd.sql.executeUpdate();

            conector_bd.sql.close();
            conector_bd.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println("Error UPDATE BD! -> " + e);
        }

        return false;
    }

}
