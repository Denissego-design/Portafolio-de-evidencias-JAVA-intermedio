import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<String>> sistemas = new ArrayList<>();

        sistemas.add(executor.submit(new SistemaDeNavegacion()));
        sistemas.add(executor.submit(new SistemaSoporteVital()));
        sistemas.add(executor.submit(new SistemaControlTermico()));
        sistemas.add(executor.submit(new SistemaComunicaciones()));

        System.out.println("Todos los sistemas reportan un buen estado operativo");

        for (Future<String> sistema : sistemas) {
            System.out.println(sistema.get());
        }

        executor.shutdown();
    }
}
