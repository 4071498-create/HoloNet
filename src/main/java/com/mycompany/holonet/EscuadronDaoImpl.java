/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holonet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author aleja
 */
public class EscuadronDaoImpl implements EscuadronDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/escuadrones_imperiales";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    @Override
    public List<EscuadronDTO> obtenertodos() {
        //Creamos un array de escuadronesdto 
        List<EscuadronDTO> escuadron = new ArrayList<>();
        //secuencia de sql
        String sql = "SELECT id, nombre, sector, numIntegrantes FROM escuadrones_combate";
        //intentamos la conexion
        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            //los añadimos a la lista para poder mostrarlos luego despues
            while (rs.next()) {
                escuadron.add(new EscuadronDTO(
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getString("sector"),
                    rs.getInt("numIntegrantes")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return escuadron;
    }

    @Override
    public Optional<EscuadronDTO> obtenerid(String id) {
        //Creamos un array de escuadronesdto 
        List<EscuadronDTO> escuadron = new ArrayList<>();
        //secuencia de sql
        String sql = "SELECT id, nombre, sector, numIntegrantes FROM escuadrones_combate WHERE id = ?";
        //intentamos la conexion
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //lo añadimos a la lista despues de encontrar el que buscamos para poder mostrarlos luego despues
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new EscuadronDTO(
                    rs.getString("id"),
                    rs.getString("nombre"),
                    rs.getString("sector"),
                    rs.getInt("numIntegrantes")
                ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void insertar(EscuadronDTO escuadron) {
        //secuencia de sql
       String sql = "INSERT INTO escuadrones_combate (id, nombre, sector, numIntegrantes) VALUES (?, ?, ?, ?)";
        //intentamos la conexion
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //insertamos los parametros para poder usarlos en la secuencia de sql
            pstmt.setString(1, escuadron.getId());
            pstmt.setString(2, escuadron.getNombre());
            pstmt.setString(3, escuadron.getSector());
            pstmt.setInt(4, escuadron.getNumIntegrantes());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(EscuadronDTO escuadron) {
        String sql = "UPDATE escuadrones_combate SET nombre = ?, sector = ?, numIntegrantes = ? WHERE id = ?";
        //intentamos la conexion
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //actualizamos los parametros tras buscarlo por su id
            pstmt.setString(1, escuadron.getNombre());
            pstmt.setString(2, escuadron.getSector());
            pstmt.setInt(3, escuadron.getNumIntegrantes());
            pstmt.setString(4, escuadron.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        //secuencia de sql
        String sql = "DELETE FROM escuadrones_combate WHERE id = ?";
        //intentamos la conexion
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //actualizamos la tabla para eliminarlo con el parametro de id
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   
