import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}