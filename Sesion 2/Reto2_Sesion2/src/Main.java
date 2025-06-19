import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


    public static void main(String[] args) {
        RecursoMedico recurso = new RecursoMedico("Sala de cirugía");

        Runnable tarea1 = () -> recurso.usar("Dra. Sánchez");
        Runnable tarea2 = () -> recurso.usar("Enfermera Labastida");
        Runnable tarea3 = () -> recurso.usar("Enfermero Saldívar");
        Runnable tarea4 = () -> {
            recurso.usar("Dr. Ramírez");
        };
        Runnable tarea5 = () -> recurso.usar("Dra. Morales");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(tarea1);
        executor.submit(tarea2);
        executor.submit(tarea3);
        executor.submit(tarea4);
        executor.submit(tarea5);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
