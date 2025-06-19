package Producto.Repository.bedu.Bedu.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private ProductoRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) {
		repo.save(new Producto("Laptop Lenovo", "Alta gama", 12500.00));
		repo.save(new Producto("Mouse Logitech", "Ergonómico", 350.00));
		repo.save(new Producto("Teclado Mecánico", "RGB y compacto", 950.00));
		repo.save(new Producto("Monitor", "Full HD", 3200.00));

		System.out.println("📦 Productos con precio mayor a 500:");
		repo.findByPrecioGreaterThan(500).forEach(System.out::println);

		System.out.println("\n🔍 Productos que contienen 'lap':");
		repo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

		System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
		repo.findByPrecioBetween(400, 1000).forEach(System.out::println);

		System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
		repo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
	}
}