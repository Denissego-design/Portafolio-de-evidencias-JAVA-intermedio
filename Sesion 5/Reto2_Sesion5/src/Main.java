//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> flujo1 = MonitorUCI.flujoPaciente(1);
        Flux<String> flujo2 = MonitorUCI.flujoPaciente(2);
        Flux<String> flujo3 = MonitorUCI.flujoPaciente(3);

        Flux.merge(flujo1, flujo2, flujo3)
                .subscribe(System.out::println);

        Thread.sleep(20000); // Deja correr por 20 segundos
    }
}