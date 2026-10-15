/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holonet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author Pablo Miguel Martínez, Alejandro Parra Carrilero y Jorge Ortigosa Alcántara
 */
public class InicializarTabla {
    private static final String URL = "jdbc:postgresql://localhost:5432/escuadrones_imperiales";
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    
    public static void main(String[] args) {
        // Sentencia de descripción de datos (DDL) con verificación segura
        String sql = "CREATE TABLE IF NOT EXISTS escuadrones_combate ("
                   + "id VARCHAR(10) PRIMARY KEY, "
                   + "nombre VARCHAR(100) NOT NULL, "
                   + "sector VARCHAR(50) NOT NULL, "
                   + "numIntegrantes INT NOT NULL"
                   + ");";

        System.out.println("⏳ Estableciendo canal seguro con el terminal del SGBD...");
        
        // El bloque try-with-resources cierra la conexión y el statement de manera automática
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {
            
            stmt.execute(sql);
            System.out.println("✔ Infraestructura DDL completada: Tabla 'escuadrones_combate' verificada en el sector.");
            
        } catch (SQLException e) {
            System.err.println("❌ Error en la red de holocomunicaciones DDL: " + e.getMessage());
        }
    }
}
