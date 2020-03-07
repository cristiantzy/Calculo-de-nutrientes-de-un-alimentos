package Logica;

import Interface.IAlimentoProcesado;
import java.io.File;
import java.io.FileOutputStream;
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
public class AlimentoProcesado implements IAlimentoProcesado {

    public int id_alimentoProcesado;
    public String nombre_alimento_proc;
    public String descripcion_alimento_proc;
    public String img_alimento_proc;

    public AlimentoProcesado(int id_alimentoProcesado, String nombre_alimento_proc, String descripcion_alimento_proc, String img_alimento_proc) {
        this.id_alimentoProcesado = id_alimentoProcesado;
        this.nombre_alimento_proc = nombre_alimento_proc;
        this.descripcion_alimento_proc = descripcion_alimento_proc;
        this.img_alimento_proc = img_alimento_proc;
    }

    public AlimentoProcesado() {

    }

    @Override
    public boolean agregar_alimentoProcesado() {
        String Query = "insert into alimentoprocesado(nombre_alimento_proc,descripcion_alimento_proc,img_alimento_proc)"
                + " values(?,?,?);";
        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_alimento_proc);
            conector_bd.sql.setString(2, this.descripcion_alimento_proc);
            conector_bd.sql.setString(3, this.img_alimento_proc);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;

    }

    @Override
    public AlimentoProcesado consultar_por_id_alimentoProcesado(int key_id) {
        ConexionMysql conector_bd;

        AlimentoProcesado alimento_proc = null;
        String Query = "select * from alimentoprocesado where id_alimentoprocesado=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                alimento_proc = new AlimentoProcesado(
                        consulta_bd.getInt("id_alimentoProcesado"),
                        consulta_bd.getString("nombre_alimento_proc"),
                        consulta_bd.getString("descripcion_alimento_proc"),
                        consulta_bd.getString("img_alimento_proc")
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return alimento_proc;
    }

    @Override
    public boolean modificar_alimentoProcesado() {
        String Query = "update alimentoprocesado set nombre_alimento_proc=?,descripcion_alimento_proc=? where id_alimentoProcesado=?;";
        ConexionMysql conector_bd;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_alimento_proc);
            conector_bd.sql.setString(2, this.descripcion_alimento_proc);
            conector_bd.sql.setInt(3, this.id_alimentoProcesado);

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
    public List<AlimentoProcesado> consultar_alimentoProcesado() {

        ConexionMysql conector_bd;

        String Query = "select * from alimentoprocesado;";

        List<AlimentoProcesado> lista_alimento_pro = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_alimentoProcesado = resultado.getInt("id_alimentoProcesado");
                this.nombre_alimento_proc = resultado.getString("nombre_alimento_proc");
                this.descripcion_alimento_proc = resultado.getString("descripcion_alimento_proc");
                this.img_alimento_proc = resultado.getString("img_alimento_proc");

                AlimentoProcesado alimento_pro = new AlimentoProcesado(id_alimentoProcesado, nombre_alimento_proc, descripcion_alimento_proc, img_alimento_proc);

                lista_alimento_pro.add(alimento_pro);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_alimento_pro;

    }

    @Override
    public boolean actualizar_foto() {
        ConexionMysql conector_bd;
        String Query = "update alimentoprocesado set img_alimento_proc=? where id_alimentoProcesado=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.img_alimento_proc);
            conector_bd.sql.setInt(2, this.id_alimentoProcesado);

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

        } catch (Exception e) {
            System.out.println("Error AL GUARDAR Directorio IMG " + e);
        }

        return false;

    }

    @Override
    public boolean eliminar_img_directory() {

        // resivir ID de la imagen actual
        ConexionMysql conector_bd;
        String nombre_img = "";

        String Query = "select img_alimento_proc from alimentoprocesado where id_alimentoProcesado='" + id_alimentoProcesado + "';";
        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            if (resultado.next()) {
                nombre_img = resultado.getString("img_alimento_proc");
            }
            resultado.close();

            File imagen = new File("D:/ProyectosJava/InformacionNutricional/web/img/img_bd/" + nombre_img);

            boolean estado = imagen.delete();
            if (estado) {
                return true;

            }

        } catch (Exception e) {
            System.out.println("Erro al boorrar IMG DIRECTORIO " + e);
        }
        return false;

    }

    @Override
    public List<AlimentoProcesado> consultar_aletoria() {

        ConexionMysql conector_bd;

        String Query = "SELECT * FROM alimentoprocesado ORDER BY RAND() LIMIT 6;";

        List<AlimentoProcesado> lista_aliment_proc = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_alimentoProcesado = resultado.getInt("id_alimentoProcesado");
                this.nombre_alimento_proc = resultado.getString("nombre_alimento_proc");
                this.descripcion_alimento_proc = resultado.getString("descripcion_alimento_proc");
                this.img_alimento_proc = resultado.getString("img_alimento_proc");

                AlimentoProcesado alimento_pro = new AlimentoProcesado(id_alimentoProcesado, nombre_alimento_proc, descripcion_alimento_proc, img_alimento_proc);

                lista_aliment_proc.add(alimento_pro);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }
        return lista_aliment_proc;
    }

}
