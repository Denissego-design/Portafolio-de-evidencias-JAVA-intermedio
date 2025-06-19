import java.util.List;

class AplicacionMaterial {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int duracionTotal = lista.stream().mapToInt(Video::getDuracionEnMinutos).sum();
        System.out.println("Duración total de los videos: " + duracionTotal + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.marcarComoRevisado();
                System.out.println("Ejercicio marcado como revisado: " + ejercicio.titulo);
            }
        }
    }
}