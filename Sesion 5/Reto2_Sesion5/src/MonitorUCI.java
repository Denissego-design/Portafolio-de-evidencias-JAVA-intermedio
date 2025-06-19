import reactor.core.publisher.Flux;
import java.time.Duration;

public class MonitorUCI {

    public static Flux<String> flujoPaciente(int id) {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> new EventoPaciente(id))
                .flatMap(evento -> {
                    Flux<String> alertas = Flux.empty();

                    if (evento.frecuenciaCardiaca < 50 || evento.frecuenciaCardiaca > 120) {
                        alertas = alertas.concatWith(Flux.just("⚠️ Paciente " + evento.idPaciente +
                                " - FC crítica: " + evento.frecuenciaCardiaca + " bpm"));
                    }

                    if (evento.sistolica < 90 || evento.sistolica > 140 ||
                            evento.diastolica < 60 || evento.diastolica > 90) {
                        alertas = alertas.concatWith(Flux.just("⚠️ Paciente " + evento.idPaciente +
                                " - PA crítica: " + evento.sistolica + "/" + evento.diastolica + " mmHg"));
                    }

                    if (evento.spo2 < 90) {
                        alertas = alertas.concatWith(Flux.just("⚠️ Paciente " + evento.idPaciente +
                                " - SpO₂ baja: " + evento.spo2 + "%"));
                    }

                    return alertas
                            .sort((a, b) -> b.contains("FC") ? 1 : a.contains("FC") ? -1 : 0)
                            .delayElements(Duration.ofSeconds(1));
                });
    }
}