package Logica;

import Interface.IProducto_Vitamina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Producto_Vitamina implements IProducto_Vitamina {

    public int fk_id_producto;
    public int fk_id_vitamina;
    public double cantidad_vitamina;
    public String estado_vitamina;

    public Producto_Vitamina(int fk_id_producto, int fk_id_vitamina, double cantidad_vitamina, String estado_vitamina) {
        this.fk_id_producto = fk_id_producto;
        this.fk_id_vitamina = fk_id_vitamina;
        this.cantidad_vitamina = cantidad_vitamina;
        this.estado_vitamina = estado_vitamina;
    }

    public Producto_Vitamina() {
    }

    @Override
    public boolean agregar_productoVitamina() {
        if (modificar_productoVitamina()) {
            return true;
        }
        return false;
    }

    @Override
    public List<Producto_Vitamina> consultar_por_id_productoVitamina(int key_id) {

        ConexionMysql conector_bd;

        String Query = "select cantidad_vitamina from producto inner join producto_vitamina on id_producto=fk_id_producto "
                + "inner join vitamina on fk_id_vitamina=id_vitamina where id_producto='" + key_id + "';";

        List<Producto_Vitamina> lista_proVit = new ArrayList<Producto_Vitamina>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.cantidad_vitamina = resultado.getDouble("cantidad_vitamina");

                Producto_Vitamina nuevo_proMin = new Producto_Vitamina(1, 2, this.cantidad_vitamina, "");
                lista_proVit.add(nuevo_proMin);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_proVit;

    }

    @Override
    public boolean modificar_productoVitamina() {
        String Query = "update producto_vitamina set cantidad_vitamina=? where (fk_id_producto=? and fk_id_vitamina=?);";
        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setDouble(1, this.cantidad_vitamina);
            conector_bd.sql.setInt(2, this.fk_id_producto);
            conector_bd.sql.setInt(3, this.fk_id_vitamina);

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
