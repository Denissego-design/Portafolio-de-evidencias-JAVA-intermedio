package com.bedu.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository {

    void save(Categoria tecnologia);

    public interface ProductoRepository extends JpaRepository<Producto, Long> {

        // Método personalizado que busca productos cuyo nombre contenga un texto específico (no sensible a mayúsculas)
        List<Producto> findByNombreContaining(String nombre);

        Iterable<Object> findByNombreContainingIgnoreCase(String lap);
    }

}
