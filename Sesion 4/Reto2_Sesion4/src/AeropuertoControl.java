import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class AeropuertoControl {

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            return generarCondicion(0.8, "Disponibilidad de pista");
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            return generarCondicion(0.95, "Condiciones climáticas");
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            return generarCondicion(0.10, "Tráfico aéreo");
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            return generarCondicion(0.32, "Personal en tierra");
        });
    }

    private void simularLatencia() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
        } catch (InterruptedException e) {
            throw new RuntimeException("Simulación interrumpida");
        }
    }

    private boolean generarCondicion(double probabilidadExito, String nombreServicio) {
        boolean exito = Math.random() < probabilidadExito;
        System.out.println("[" + nombreServicio + "] Resultado: " + (exito ? "Favorable" : "Desfavorable"));
        return exito;
    }
}
