/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cristian_Tisoy
 */
public class ConexionMysql {

    private static Connection conect;
    private static final String driver = "com.mysql.jdbc.Driver";
    //private static final String url = "jdbc:mysql://localhost:3306/ambiente_bd";
    private static final String url = "jdbc:mysql://localhost:3306/bd_softnutricional?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    public Connection conexion;
    public PreparedStatement sql;
    public ResultSet consulta;

    public ConexionMysql() {
        conect = null;
        try {
            Class.forName(driver);
            conect = DriverManager.getConnection(url, user, password);
            if (conect != null) {
                // System.out.println(" ╔════════ Conexion Establecida ════════╗ " );

                System.out.println(" Conexion Establecida...");
            } else {
                System.out.println("Sin Conexion!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!! Conexion " + e);
        }

    }

    public Connection getConnection() {

        return conect;
    }

    public void desconectar() throws SQLException {

        try {
            conect.close();
            conect = null;
            if (conect == null) {
//            System.out.println(" ╚════════  Conexion Terminada  ════════╝ ");
                System.out.println(" Conexion Terminada...");
            }
        } catch (SQLException e) {
        }

    }
}
