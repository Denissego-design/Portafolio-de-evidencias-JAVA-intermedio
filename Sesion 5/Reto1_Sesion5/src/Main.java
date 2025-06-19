import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SistemasCriticos sistema = new SistemasCriticos();
        sistema.iniciarSistemas().subscribe();

        // Mantiene el sistema funcionando durante 15 segundos
        Thread.sleep(15000);
    }
}