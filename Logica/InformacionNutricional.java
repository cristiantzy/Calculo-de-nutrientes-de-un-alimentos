/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interface.IInformacionNutricional;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cristian_Tisoy
 */
public class InformacionNutricional implements IInformacionNutricional {

    public int id_informacion_nut;
    // Sacados de cada producto/alimento
    public double proteina;
    public double fibra_dietaria;
    public double carbohidratos;
    public double vitamina_c;
    public double vitamina_a;
    public double calcio;
    public double hierro;
    public double sodio;
    public double colesterol;
    public double omega_3;
    public double omega_6;
    public double omega_9;
    public double grasa_saturada;

    // faltan por CALCULAR
    public double tam_porcion;
    public double porcion;
    public double calorias;
    public double grasa_total;
    public double azucares_add;
    public double grasa_saturada1;
    public double colesterol1;
    public double carbohidratos1;
    public double fibra_dietaria1;
    public int fk_id_producto;

    public InformacionNutricional(int id_informacion_nut, double proteina, double fibra_dietaria, double carbohidratos, double vitamina_c, double vitamina_a, double calcio, double hierro, double sodio, double colesterol, double omega_3, double omega_6, double omega_9, double grasa_saturada, double tam_porcion, double porcion, double calorias, double grasa_total, double azucares_add, double grasa_saturada1, double colesterol1, double carbohidratos1, double fibra_dietaria1, int fk_id_producto) {
        this.id_informacion_nut = id_informacion_nut;
        this.proteina = proteina;
        this.fibra_dietaria = fibra_dietaria;
        this.carbohidratos = carbohidratos;
        this.vitamina_c = vitamina_c;
        this.vitamina_a = vitamina_a;
        this.calcio = calcio;
        this.hierro = hierro;
        this.sodio = sodio;
        this.colesterol = colesterol;
        this.omega_3 = omega_3;
        this.omega_6 = omega_6;
        this.omega_9 = omega_9;
        this.grasa_saturada = grasa_saturada;
        this.tam_porcion = tam_porcion;
        this.porcion = porcion;
        this.calorias = calorias;
        this.grasa_total = grasa_total;
        this.azucares_add = azucares_add;
        this.grasa_saturada1 = grasa_saturada1;
        this.colesterol1 = colesterol1;
        this.carbohidratos1 = carbohidratos1;
        this.fibra_dietaria1 = fibra_dietaria1;
        this.fk_id_producto = fk_id_producto;
    }

    public InformacionNutricional() {
    }

    @Override
    public InformacionNutricional calcular_nutrientes(int id_producto) {

        ConexionMysql conector_bd;

        InformacionNutricional contenido_nutricional = null;
        String Query = "call nutrientes_producto(?);";

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);
            conector_bd.sql.setInt(1, id_producto);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                contenido_nutricional = new InformacionNutricional(
                        0,
                        formatearDecimales(consulta_bd.getFloat("proteina_p"),3),
                        formatearDecimales(consulta_bd.getFloat("fibra_dietaria_p"),3),
                        formatearDecimales(consulta_bd.getFloat("carbohidratos_p"),3),
                        formatearDecimales(consulta_bd.getFloat("vitamina_c_p"),3),
                        formatearDecimales(consulta_bd.getFloat("vitamina_a_p"),3),
                        formatearDecimales(consulta_bd.getFloat("calcio_p"),3),
                        formatearDecimales(consulta_bd.getFloat("hierro_p"),3),
                        formatearDecimales(consulta_bd.getFloat("sodio_p"),3),
                        formatearDecimales(consulta_bd.getFloat("colesterol_p"),3),
                        formatearDecimales(consulta_bd.getFloat("omega_3_p"),3),
                        formatearDecimales(consulta_bd.getFloat("omega_6_p"),3),
                        formatearDecimales(consulta_bd.getFloat("omega_9_p"),3),
                        formatearDecimales(consulta_bd.getFloat("grasa_saturada_p"),3),
                        // falta por CALCULAR
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0
                );
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }

        return contenido_nutricional;

    }

    public Double formatearDecimales(double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

    @Override
    public Double total_calorias(int id_producto) {
        
        ConexionMysql conector_bd;
        String Query = "select ROUND(total_calorias('"+id_producto+"'), 1) as total_calorias;";
        double total_calorias = 0;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                total_calorias = consulta_bd.getDouble("total_calorias");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return total_calorias;
    
    }

    @Override
    public Double total_carbohidratos(int id_producto) {
       ConexionMysql conector_bd;
        String Query = "select ROUND(total_carbohidratos('"+id_producto+"'), 1) as total_carbohidratos;";
        double total_carbohidrato = 0;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                total_carbohidrato = consulta_bd.getDouble("total_carbohidratos");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return total_carbohidrato;
    
    }

    @Override
    public Double total_grasas(int id_producto) {
        ConexionMysql conector_bd;
        String Query = "select ROUND(total_grasas('"+id_producto+"'), 1) as total_grasas;";
        double total_grasas = 0;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                total_grasas = consulta_bd.getDouble("total_grasas");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return total_grasas;
    
    }

    @Override
    public Double total_proteina(int id_producto) {
       ConexionMysql conector_bd;
        String Query = "select ROUND(total_proteinas('"+id_producto+"'), 1) as total_proteinas;";
        double total_proteinas = 0;

        conector_bd = new ConexionMysql();
        conector_bd.conexion = conector_bd.getConnection();

        try {
            conector_bd.sql = conector_bd.conexion.prepareStatement(Query);

            ResultSet consulta_bd = conector_bd.sql.executeQuery();

            if (consulta_bd.next()) {
                total_proteinas = consulta_bd.getDouble("total_proteinas");
            }
            consulta_bd.close();

            conector_bd.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al consultar BD Registro Unico " + e);
        }
        return total_proteinas;
    
    }
    
    

}
