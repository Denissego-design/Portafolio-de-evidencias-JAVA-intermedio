package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo) {
		return (args) -> {
			// Crear y guardar categorías
			Categoria apple = new Categoria("Apple");
			Categoria samsung = new Categoria("Samsung");

			categoriaRepo.save(apple);
			categoriaRepo.save(samsung);

			// Crear y guardar productos
			productoRepo.save(new Producto("iPhone 15", "Smartphone de gama alta", 22000.00, apple));
			productoRepo.save(new Producto("iPad Pro", "Tablet profesional", 28000.00, apple));
			productoRepo.save(new Producto("Galaxy S23", "Teléfono de Samsung", 21000.00, samsung));
			productoRepo.save(new Producto("Smart TV", "Televisión 4K", 15000.00, samsung));

			// Imprimir agrupados por categoría (marca)
			System.out.println("📚 Productos por marca:");
			productoRepo.findAll().stream()
					.collect(Collectors.groupingBy(p -> p.getCategoria().getNombre()))
					.forEach((marca, productos) -> {
						System.out.println("🏷️ " + marca + ":");
						productos.forEach(prod -> System.out.println("   - " + prod.getNombre()));
					});
		};
	}
}