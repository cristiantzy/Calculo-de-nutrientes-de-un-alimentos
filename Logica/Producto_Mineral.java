package Logica;

import Interface.IProducto_Mineral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Producto_Mineral implements IProducto_Mineral {

    public int fk_id_producto;
    public int fk_id_mineral;
    public double cantidad_mineral;
    public String estado_mineral;

    public Producto_Mineral(int fk_id_producto, int fk_id_mineral, double cantidad_mineral, String estado_mineral) {
        this.fk_id_producto = fk_id_producto;
        this.fk_id_mineral = fk_id_mineral;
        this.cantidad_mineral = cantidad_mineral;
        this.estado_mineral = estado_mineral;
    }

    public Producto_Mineral() {
    }

    @Override
    public boolean agregar_productoMineral() {

        if (modificar_productoMineral()) {
            return true;
        }

        return false;
    }

    @Override
    public List<Producto_Mineral> consultar_por_id_productoMineral(int key_id) {

        ConexionMysql conector_bd;

        String Query = "select cantidad_mineral from producto inner join producto_mineral on id_producto=fk_id_producto "
                + "inner join mineral on fk_id_mineral=id_mineral where id_producto='" + key_id + "';";

        List<Producto_Mineral> lista_proMin = new ArrayList<Producto_Mineral>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.cantidad_mineral = resultado.getDouble("cantidad_mineral");

                Producto_Mineral nuevo_proMin = new Producto_Mineral(1, 2, this.cantidad_mineral, "");

                lista_proMin.add(nuevo_proMin);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_proMin;
    }

    @Override
    public boolean modificar_productoMineral() {
        String Query = "update producto_mineral set cantidad_mineral=? where (fk_id_producto=? and fk_id_mineral=?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setDouble(1, this.cantidad_mineral);
            conector_bd.sql.setInt(2, this.fk_id_producto);
            conector_bd.sql.setInt(3, this.fk_id_mineral);

            conector_bd.sql.executeUpdate();

            conector_bd.sql.close();
            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error UPDATE BD! -> " + e);
        }

        return false;

    }

}
