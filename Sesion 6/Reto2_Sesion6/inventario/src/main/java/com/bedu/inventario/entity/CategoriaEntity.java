package com.bedu.inventario.entity;

import jakarta.persistence.*;

@Entity

public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    protected CategoriaEntity() {}

    public void Categoria (String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}

