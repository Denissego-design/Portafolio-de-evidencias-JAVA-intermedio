import java.util.concurrent.*;
import java.text.DecimalFormat;

public class MovilidadApp {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    private final DecimalFormat formatoTarifa = new DecimalFormat("#0.00");

    public CompletableFuture<String> calcularRuta(String origen, String destino) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (origen == null || destino == null || origen.isBlank() || destino.isBlank()) {
                    throw new IllegalArgumentException("Origen y destino deben ser válidos.");
                }
                TimeUnit.SECONDS.sleep(3);
                return origen + " -> " + destino;
            } catch (InterruptedException e) {
                throw new RuntimeException("Ruta interrumpida", e);
            }
        }, executor);
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3); // Simula latencia
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Estimación interrumpida", e);
            }
        }, executor);
    }

    public void procesarViaje(String origen, String destino) {
        calcularRuta(origen, destino)
                .thenCombine(estimarTarifa(), (ruta, tarifa) ->
                        "Ruta calculada: " + ruta + " | Tarifa estimada: $" + formatoTarifa.format(tarifa)
                )
                .exceptionally(ex ->
                        "Error en la aplicación: " + ex.getMessage()
                )
                .thenAccept(resultado -> {
                    System.out.println(resultado);
                    executor.shutdown(); // Importante para liberar los hilos del pool
                });
    }

}