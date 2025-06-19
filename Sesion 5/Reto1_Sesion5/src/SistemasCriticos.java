import reactor
import reactor.core.scheduler.Schedulers;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class SistemasCriticos {

    private final AtomicInteger alertasCriticas = new AtomicInteger();

    public Flux<Void> iniciarSistemas() {
        Flux<Integer> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> ThreadLocalRandom.current().nextInt(101))
                .onBackpressureBuffer()
                .doOnNext(val -> {
                    if (val > 70) {
                        System.out.println("🚗 Congestión crítica: " + val + "%");
                        alertasCriticas.incrementAndGet();
                    }
                });

        Flux<Double> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> ThreadLocalRandom.current().nextDouble(0, 100))
                .doOnNext(pm -> {
                    if (pm > 50) {
                        System.out.printf("🌫️ Contaminación crítica: %.2f ug/m3%n", pm);
                        alertasCriticas.incrementAndGet();
                    }
                });

        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] niveles = {"Baja", "Media", "Alta"};
                    return niveles[ThreadLocalRandom.current().nextInt(3)];
                })
                .doOnNext(prioridad -> {
                    if ("Alta".equals(prioridad)) {
                        System.out.println("🚑 Accidente grave detectado (Prioridad: Alta)");
                        alertasCriticas.incrementAndGet();
                    }
                });

        Flux<Integer> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> ThreadLocalRandom.current().nextInt(11))
                .delayElements(Duration.ofMillis(100)) // Simula contrapresión
                .doOnNext(min -> {
                    if (min > 5) {
                        System.out.println("🚝 Retraso de tren maglev: " + min + " min");
                        alertasCriticas.incrementAndGet();
                    }
                });

        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    return estados[ThreadLocalRandom.current().nextInt(estados.length)];
                })
                .scan(new Object() {
                    int consecutivos = 0;
                    String anterior = "";

                    String actualizar(String estado) {
                        consecutivos = estado.equals("Rojo") && anterior.equals("Rojo") ? consecutivos + 1 :
                                estado.equals("Rojo") ? 1 : 0;
                        anterior = estado;
                        return estado + "|" + consecutivos;
                    }
                }, (acum, estado) -> {
                    acum.actualizar(estado);
                    return acum;
                })
                .skip(1)
                .map(ac -> ac.anterior + "|" + ac.consecutivos)
                .doOnNext(result -> {
                    String[] partes = result.split("\\|");
                    int rojos = Integer.parseInt(partes[1]);
                    if (rojos >= 3) {
                        System.out.println("🚦 Semáforo rojo repetido 3 veces seguidas");
                        alertasCriticas.incrementAndGet();
                    }
                });

        // Alerta global por múltiples eventos críticos simultáneos
        Flux<Void> monitoreo = Flux.interval(Duration.ofSeconds(1))
                .doOnNext(i -> {
                    if (alertasCriticas.getAndSet(0) >= 3) {
                        System.out.println("🔴 ALERTA GLOBAL: múltiples eventos críticos simultáneos");
                    }
                })
                .thenMany(Flux.never()); // Mantiene vivo el flujo

        return Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos, monitoreo)
                .thenMany(Flux.never()); // Se ejecutan en paralelo y siguen corriendo
    }
}