import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();

        CompletableFuture<Boolean> pista = control.verificarPista();
        CompletableFuture<Boolean> clima = control.verificarClima();
        CompletableFuture<Boolean> trafico = control.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = control.verificarPersonalTierra();

        CompletableFuture<Void> resultado = CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenRun(() -> {
                    try {
                        boolean condicionesOptimas =
                                pista.get() && clima.get() && trafico.get() && personal.get();

                        if (condicionesOptimas) {
                            System.out.println("Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al evaluar condiciones: " + e.getMessage());
                    }
                }).exceptionally(ex -> {
                    System.out.println("Error en proceso asincrónico: " + ex.getMessage());
                    return null;
                });

        resultado.join();
    }
}