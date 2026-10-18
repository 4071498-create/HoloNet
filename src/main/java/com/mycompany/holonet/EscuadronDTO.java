/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holonet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pablo Miguel Martínez, Alejandro Parra Carrilero y Jorge Ortigosa Alcántara
 */
public class EscuadronDTO {
    //Hacemos un javaBean como cualquier otro
    private String id;
    private String nombre;
    private String sector;
    private int numIntegrantes;

    public EscuadronDTO(String id, String nombre, String sector, int numIntegrantes) {
        this.id = id;
        this.nombre = nombre;
        this.sector = sector;
        this.numIntegrantes = numIntegrantes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getNumIntegrantes() {
        return numIntegrantes;
    }

    public void setNumIntegrantes(int numIntegrantes) {
        this.numIntegrantes = numIntegrantes;
    }

    
    @Override
    public String toString() {
        return "🛸 [Escuadron de Combate del Imperio Galáctico] Identificador: " + id + " | Nombre: " + nombre 
             + " | Sector: " + sector + " | Numero de integrantes: " + numIntegrantes;
    }
}
