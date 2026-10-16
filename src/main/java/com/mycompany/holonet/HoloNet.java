/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.holonet;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pablo Miguel Martínez, Alejandro Parra Carrilero y Jorge Ortigosa Alcántara
 */
public class HoloNet {

    public static void main(String[] args) {
        //iniciamos la interfaz
        EscuadronDao escuadronDAO = new EscuadronDaoImpl();
        InicializarTabla.main(args);
        
        System.out.println(" INSERTAR UN NUEVO ESCUADRON");
        //creamos un nuevo escuadron
        EscuadronDTO nuevoEscuadron = new EscuadronDTO("ESC-001", "Alfa Centauri", "Sector 4", 12);
        escuadronDAO.insertar(nuevoEscuadron);
        System.out.println("Escuadrón insertado correctamente.\n");
        
        //los listamos mediante un list
        List<EscuadronDTO> lista = escuadronDAO.obtenertodos();
        for (EscuadronDTO e : lista) {
            System.out.println("ID: " + e.getId() + " | Nombre: " + e.getNombre() + " | Sector: " + e.getSector() + " | Integrantes: " + e.getNumIntegrantes());
        }
        
        System.out.println("BUSCAR ESCUADRON POR ID");
        //le pasamos la id y lo guardamos en un optional
        String idBuscado = "ESC-001";
        Optional<EscuadronDTO> encontrado = escuadronDAO.obtenerid(idBuscado);
        //lo buscamos y lo mostramos por pantalla si no le decimos que no lo hemos encontrado
        if (encontrado.isPresent()) {
            EscuadronDTO e = encontrado.get();
            System.out.println("¡Encontrado! -> " + e.getNombre() + " del " + e.getSector());
        } else {
            System.out.println("No se encontró ningún escuadrón con el ID: " + idBuscado);
        }
        System.out.println();

        System.out.println("ACTUALIZAR UN ESCUADRON");
        if (encontrado.isPresent()) {
            EscuadronDTO escuadronAModificar = encontrado.get();
            // Modificamos el numero de integrantes a 15
            escuadronAModificar.setNumIntegrantes(15);
            escuadronDAO.actualizar(escuadronAModificar);
            System.out.println("Escuadrón actualizado con éxito.\n");
        }
        
        //comentamos las lineas pero funcionan
        /*
        System.out.println("ELIMINAR UN ESCUADRON");
         escuadronDAO.eliminar("ESC-001");
         System.out.println("Escuadrón eliminado.");
        */     
        
        
    }
}
