/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.holonet;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Pablo Miguel Martínez, Alejandro Parra Carrilero y Jorge Ortigosa Alcántara
 */
public interface EscuadronDao {
    List<EscuadronDTO> obtenertodos();
    Optional<EscuadronDTO> obtenerid(String id);
    void insertar(EscuadronDTO escuadron);
    void actualizar(EscuadronDTO escuadron);
    void eliminar(String id);
}
