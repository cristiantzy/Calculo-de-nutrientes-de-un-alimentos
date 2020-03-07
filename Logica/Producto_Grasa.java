package Logica;

import Interface.IProducto_Grasa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Producto_Grasa implements IProducto_Grasa {

    public int fk_id_producto;
    public int fk_id_grasa;
    public double cantidad_grasa;
    public String estado_grasa;

    public Producto_Grasa(int fk_id_producto, int fk_id_grasa, double cantidad_grasa, String estado_grasa) {
        this.fk_id_producto = fk_id_producto;
        this.fk_id_grasa = fk_id_grasa;
        this.cantidad_grasa = cantidad_grasa;
        this.estado_grasa = estado_grasa;
    }

    public Producto_Grasa() {
    }

    @Override
    public boolean agregar_productoGrasa() {
        if (modificar_productoGrasa()) {
            return true;
        }
        return false;
    }

    @Override
    public List<Producto_Grasa> consultar_por_id_productoGrasas(int key_id) {
        ConexionMysql conector_bd;

        String Query = "select cantidad_grasa from producto inner join producto_grasa on id_producto=fk_id_producto "
                + "inner join grasa on fk_id_grasa=id_grasa where id_producto='" + key_id + "';";

        List<Producto_Grasa> lista_proGra = new ArrayList<Producto_Grasa>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.cantidad_grasa = resultado.getDouble("cantidad_grasa");

                Producto_Grasa nuevo_proGra = new Producto_Grasa(1, 2, this.cantidad_grasa, "");

                lista_proGra.add(nuevo_proGra);
            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }
        return lista_proGra;

    }

    @Override
    public boolean modificar_productoGrasa() {
        String Query = "update producto_grasa set cantidad_grasa=? where (fk_id_producto=? and fk_id_grasa=?);";

        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setDouble(1, this.cantidad_grasa);
            conector_bd.sql.setInt(2, this.fk_id_producto);
            conector_bd.sql.setInt(3, this.fk_id_grasa);

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
