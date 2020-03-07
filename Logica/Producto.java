package Logica;

import Interface.IProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian_Tisoy
 */
public class Producto implements IProducto {

    public int id_producto;
    public String nombre_producto;
    public String parte_analizada;
    private int fk_id_administrador;

    public Producto(int id_producto, String nombre_producto, String parte_analizada, int fk_id_administrador) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.parte_analizada = parte_analizada;
        this.fk_id_administrador = fk_id_administrador;
    }

    public Producto() {
    }

    @Override
    public boolean agregar_producto() {
        String Query = "insert into producto(nombre_producto,parte_analizada,fk_id_administrador) values(?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();

        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_producto);
            conector_bd.sql.setString(2, this.parte_analizada);
            conector_bd.sql.setInt(3, this.fk_id_administrador);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            
            
            
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;

    }
    
    @Override
    public Producto consulta_producto_por_id(int id_key) {
        ConexionMysql conector_bd;

        Producto producto = null;
        String Query = "select * from producto where id_producto=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, id_key);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                producto = new Producto(
                        consulta_bd.getInt("id_producto"),
                        consulta_bd.getString("nombre_producto"),
                        consulta_bd.getString("parte_analizada"),
                        consulta_bd.getInt("fk_id_administrador")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return producto;

    }
    
    @Override
    public boolean modificar_producto() {
        String Query = " update producto set nombre_producto=?, parte_analizada=? where id_producto=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_producto);
            conector_bd.sql.setString(2, this.parte_analizada);
            conector_bd.sql.setInt(3, this.id_producto);

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
    public boolean agregarNutrientes() {
        String query = "call agregarNutrientes();";
        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();
        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(query);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error PROCEDIMIENTO BD! -> " + e);
        }
        return false;
    }

    @Override
    public int id_ultimo_registro() {
        ConexionMysql conector_bd;
        String Query = "select max(id_producto) as max_id from producto;";
        int id_aux = 0;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                id_aux = consulta_bd.getInt("max_id");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return id_aux;

    }

    @Override
    public List<Producto> consultar_productos() {
        ConexionMysql conector_bd;

        String Query = "select * from producto;";

        List<Producto> lista_producto = new ArrayList<>();

        conector_bd = new ConexionMysql();

        Statement stament;
        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_producto = resultado.getInt("id_producto");
                this.nombre_producto = resultado.getString("nombre_producto");
                this.parte_analizada = resultado.getString("parte_analizada");
                this.fk_id_administrador = resultado.getInt("fk_id_administrador");

                Producto producto = new Producto(id_producto, nombre_producto, parte_analizada, fk_id_administrador);

                lista_producto.add(producto);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_producto;

    }

    @Override
    public boolean producto_repetido(String nombre_producto,String parte_analizada) {
        ConexionMysql conector_bd;
        String Query = "select * from producto where nombre_producto like '%"+nombre_producto+"%';";
        String query = "select * from producto where parte_analizada like '%"+parte_analizada+"%';";
        
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                // buscar la segunda parte
                conector_bd.sql = conector_bd.conexion.prepareStatement(query);
                consulta_bd = conector_bd.sql.executeQuery();
                if (consulta_bd.next()) {
                return true;
                }
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error: producto DUPLICADO!! " + e);
        }
        return false;
    
    }
}
