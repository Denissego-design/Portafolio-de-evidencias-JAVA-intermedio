import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();

        // Agregando órdenes de producción en masa
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        // Agregando órdenes personalizadas
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        // Agregando órdenes prototipo
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        System.out.println("📋 Órdenes registradas:");
        for (OrdenPersonalizada orden : ordenesPersonalizadas) {
            orden.mostrarResumen();
        }

        System.out.println("\n📋 Órdenes Personalizadas:");
        for (OrdenPrototipo orden : ordenesPrototipo) {
            orden.mostrarResumen();
        }

        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (OrdenPersonalizada orden : ordenesPersonalizadas) {
            System.out.println("✅ Orden " + orden.codigo + " ajustada con costo adicional de $200");

            // Mostrar resumen

            System.out.println("Resumen total de órdenes");
            System.out.println("🔧 Producción en masa: " + ordenesMasa.size());
            System.out.println("🛠️ Personalizadas: " + ordenesPersonalizadas.size());
            System.out.println("🧪 Prototipos: " + ordenesPrototipo.size());

        }
    }
}
