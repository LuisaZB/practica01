
package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Tipo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol; 
    private String nombre;
    private String descripcion;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    public Tipo() {
    }

    public Tipo(String nombre, String descripcion, int existencias, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
    }
    
    
    
}
