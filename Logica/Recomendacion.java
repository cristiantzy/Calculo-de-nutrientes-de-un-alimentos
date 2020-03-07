package Logica;

import Interface.IRecomendacion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian_Tisoy
 */
public class Recomendacion implements IRecomendacion {

    public int id_recomendacion;
    public String nombre_recomendacion;
    public String descrip_recomendacion;
    public String img_recomendacion;
    public int fk_id_administrador;

    public Recomendacion(int id_recomendacion, String nombre_recomendacion, String descrip_recomendacion, String img_recomendacion, int fk_id_administrador) {
        this.id_recomendacion = id_recomendacion;
        this.nombre_recomendacion = nombre_recomendacion;
        this.descrip_recomendacion = descrip_recomendacion;
        this.img_recomendacion = img_recomendacion;
        this.fk_id_administrador = fk_id_administrador;
    }

    public Recomendacion() {
    }

    @Override
    public boolean agregar_recomendacion() {
        String Query = "insert into recomendacion(nombre_recomendacion,descrip_recomendacion,img_recomendacion,fk_id_administrador) "
                + "values(?,?,?,?);";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_recomendacion);
            conector_bd.sql.setString(2, this.descrip_recomendacion);
            conector_bd.sql.setString(3, this.img_recomendacion);
            conector_bd.sql.setInt(4, this.fk_id_administrador);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;

    }

    @Override
    public Recomendacion consultar_por_id_recomendacion(int key_id) {
        ConexionMysql conector_bd;

        Recomendacion recomendacion = null;
        String Query = "select id_recomendacion,nombre_recomendacion,descrip_recomendacion,img_recomendacion from recomendacion where id_recomendacion=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                recomendacion = new Recomendacion(
                        consulta_bd.getInt("id_recomendacion"),
                        consulta_bd.getString("nombre_recomendacion"),
                        consulta_bd.getString("descrip_recomendacion"),
                        consulta_bd.getString("img_recomendacion"),
                        0
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return recomendacion;
    }

    @Override
    public boolean modificar_recomendacion() {
        String Query = "update recomendacion set nombre_recomendacion=?,descrip_recomendacion=? where  id_recomendacion=?;";

        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_recomendacion);
            conector_bd.sql.setString(2, this.descrip_recomendacion);
            conector_bd.sql.setInt(3, this.id_recomendacion);

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
    public List<Recomendacion> consultar_recomendacion() {

        ConexionMysql conector_bd;

        String Query = "select id_recomendacion,nombre_recomendacion,descrip_recomendacion,img_recomendacion from recomendacion;";

        List<Recomendacion> lista_recomendacion = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_recomendacion = resultado.getInt("id_recomendacion");
                this.nombre_recomendacion = resultado.getString("nombre_recomendacion");
                this.descrip_recomendacion = resultado.getString("descrip_recomendacion");
                this.img_recomendacion = resultado.getString("img_recomendacion");

                Recomendacion recomendacion = new Recomendacion(id_recomendacion, nombre_recomendacion, descrip_recomendacion, img_recomendacion, 0);

                lista_recomendacion.add(recomendacion);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_recomendacion;

    }

    @Override
    public boolean actualizar_foto() {
        ConexionMysql conector_bd;
        String Query = "update recomendacion set img_recomendacion=? where id_recomendacion=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.img_recomendacion);
            conector_bd.sql.setInt(2, this.id_recomendacion);

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
    public boolean guardar_img_directory(Part archivo_img, String nombre_img) {
        try {
            InputStream leer_dato = archivo_img.getInputStream();
            // ruta

            File ruta = new File("D:/ProyectosJava/InformacionNutricional/web/img/img_bd/" + nombre_img);

            FileOutputStream guardar_foto = new FileOutputStream(ruta);

            int dato = leer_dato.read();
            while (dato != -1) {
                guardar_foto.write(dato);
                dato = leer_dato.read();
            }

            guardar_foto.close();
            leer_dato.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error AL GUARDAR Directorio IMG " + e);
        }

        return false;

    }

    @Override
    public boolean eliminar_img_directory() {

        // resivir ID de la imagen actual
        ConexionMysql conector_bd;
        String nombre_img = "";

        String Query = "select img_recomendacion from recomendacion where id_recomendacion='" + id_recomendacion + "';";
        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            if (resultado.next()) {
                nombre_img = resultado.getString("img_recomendacion");
            }
            resultado.close();

            File imagen = new File("D:/ProyectosJava/InformacionNutricional/web/img/img_bd/" + nombre_img);

            boolean estado = imagen.delete();
            if (estado) {
                return true;

            }

        } catch (SQLException e) {
            System.out.println("Erro al boorrar IMG DIRECTORIO " + e);
        }
        return false;

    }

    @Override
    public List<Recomendacion> consultar_aletoria() {

        ConexionMysql conector_bd;

        String Query = "SELECT * FROM recomendacion ORDER BY RAND() LIMIT 5;";

        List<Recomendacion> lista_recomendacion = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_recomendacion = resultado.getInt("id_recomendacion");
                this.nombre_recomendacion = resultado.getString("nombre_recomendacion");
                this.descrip_recomendacion = resultado.getString("descrip_recomendacion");
                this.img_recomendacion = resultado.getString("img_recomendacion");

                Recomendacion recomendacion = new Recomendacion(id_recomendacion, nombre_recomendacion, descrip_recomendacion, img_recomendacion, 0);

                lista_recomendacion.add(recomendacion);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }
        return lista_recomendacion;
    }

}
