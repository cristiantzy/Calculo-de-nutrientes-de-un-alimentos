/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interface.IDietaBalanceada;
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
public class DietaBalanceada implements IDietaBalanceada {

    public int id_dietabalanceada;
    public String nombre_dieta_bal;
    public String descrip_dieta_bal;
    public String img_dieta_bal;
    public int fk_id_administrator;

    public DietaBalanceada(int id_dietabalanceada, String nombre_dieta_bal, String descrip_dieta_bal, String img_dieta_bal, int fk_id_administrator) {
        this.id_dietabalanceada = id_dietabalanceada;
        this.nombre_dieta_bal = nombre_dieta_bal;
        this.descrip_dieta_bal = descrip_dieta_bal;
        this.img_dieta_bal = img_dieta_bal;
        this.fk_id_administrator = fk_id_administrator;
    }

    public DietaBalanceada() {
    }

    @Override
    public boolean agregar_dietaBalanceada() {
        String Query = "insert into dietabalanceada(nombre_dieta_bal,descrip_dieta_bal,img_dieta_bal,fk_id_administrador)"
                + " values(?,?,?,?);";

        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_dieta_bal);
            conector_bd.sql.setString(2, this.descrip_dieta_bal);
            conector_bd.sql.setString(3, this.img_dieta_bal);
            conector_bd.sql.setInt(4, this.fk_id_administrator);

            conector_bd.sql.executeUpdate();

            conector_bd.desconectar();
            return true;

        } catch (SQLException e) {
            System.out.println("Error INSERT BD! -> " + e);
        }

        return false;
    }

    @Override
    public boolean modificar_dietaBalanceada() {
        String Query = "update dietabalanceada set nombre_dieta_bal=?,descrip_dieta_bal=? where id_dietaBalanceada=?;";

        ConexionMysql conector_bd;
        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.nombre_dieta_bal);
            conector_bd.sql.setString(2, this.descrip_dieta_bal);
            conector_bd.sql.setInt(3, this.id_dietabalanceada);

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
    public DietaBalanceada consultar_por_id_dietaBalanceada(int key_id) {
        ConexionMysql conector_bd;
        DietaBalanceada dieta_bal = null;
        String Query = "select id_dietaBalanceada,nombre_dieta_bal,descrip_dieta_bal,img_dieta_bal from dietabalanceada where id_dietaBalanceada=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, key_id);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                dieta_bal = new DietaBalanceada(
                        consulta_bd.getInt("id_dietaBalanceada"),
                        consulta_bd.getString("nombre_dieta_bal"),
                        consulta_bd.getString("descrip_dieta_bal"),
                        consulta_bd.getString("img_dieta_bal"),
                        0
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return dieta_bal;

    }

    @Override
    public List<DietaBalanceada> consultar_dietaBalanceada() {
        ConexionMysql conector_bd;

        String Query = "select id_dietaBalanceada,nombre_dieta_bal,descrip_dieta_bal,img_dieta_bal from dietabalanceada;";

        List<DietaBalanceada> lista_dieta_bal = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_dietabalanceada = resultado.getInt("id_dietaBalanceada");
                this.nombre_dieta_bal = resultado.getString("nombre_dieta_bal");
                this.descrip_dieta_bal = resultado.getString("descrip_dieta_bal");
                this.img_dieta_bal = resultado.getString("img_dieta_bal");

                DietaBalanceada dieta_balanceada = new DietaBalanceada(id_dietabalanceada, nombre_dieta_bal, descrip_dieta_bal, img_dieta_bal, 0);

                lista_dieta_bal.add(dieta_balanceada);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_dieta_bal;

    }

    @Override
    public boolean actualizar_foto() {
        ConexionMysql conector_bd;
        String Query = "update dietabalanceada set img_dieta_bal=? where id_dietaBalanceada=?;";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            conector_bd.sql.setString(1, this.img_dieta_bal);
            conector_bd.sql.setInt(2, this.id_dietabalanceada);

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

        String Query = "select img_dieta_bal from dietabalanceada where id_dietaBalanceada='" + id_dietabalanceada + "';";
        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            if (resultado.next()) {
                nombre_img = resultado.getString("img_dieta_bal");
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
    public List<DietaBalanceada> consultar_aletoria() {

        ConexionMysql conector_bd;

        String Query = "SELECT * FROM dietabalanceada ORDER BY RAND() LIMIT 5;";

        List<DietaBalanceada> lista_dieta_bal = new ArrayList<>();

        conector_bd = new ConexionMysql();
        Statement stament;

        try {
            stament = conector_bd.getConnection().createStatement();
            ResultSet resultado = stament.executeQuery(Query);

            while (resultado.next()) {

                this.id_dietabalanceada = resultado.getInt("id_dietaBalanceada");
                this.nombre_dieta_bal = resultado.getString("nombre_dieta_bal");
                this.descrip_dieta_bal = resultado.getString("descrip_dieta_bal");
                this.img_dieta_bal = resultado.getString("img_dieta_bal");

                DietaBalanceada dieta_balanceada = new DietaBalanceada(id_dietabalanceada, nombre_dieta_bal, descrip_dieta_bal, img_dieta_bal, 0);

                lista_dieta_bal.add(dieta_balanceada);

            }

            conector_bd.desconectar();

        } catch (SQLException e) {
            System.out.println("Error al consultar BD " + e);
        }

        return lista_dieta_bal;
    }

}
