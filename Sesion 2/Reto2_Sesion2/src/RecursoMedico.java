import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("🕓 " + profesional + " : " + nombre);
        lock.lock();
        try {
            System.out.println("\uD83D\uDCCC" + profesional + " ha entrado a cirugía " + nombre);
            Thread.sleep(2000); // Simula tiempo de uso
            System.out.println("\uD83D\uDCCD" + profesional + " ha salido de cirugía: " + nombre);
        } catch (InterruptedException e) {
            System.out.println("\uD83D\uDCE2" + profesional + " fue interrumpido.");
        } finally {
            lock.unlock();
        }
    }
}
