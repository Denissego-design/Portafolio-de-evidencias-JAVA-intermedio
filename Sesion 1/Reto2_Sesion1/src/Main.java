import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        // Materiales
        Video video1 = new Video("Seis de Copas - Mi relación con papá", "Priscila", 200);
        Video video2 = new Video("Seis de Copas - Amistades", "María Bolio", 120);
        Articulo articulo1 = new Articulo("Importancia de las mujeres en la economía mexicana", "Red de mujeres", 5000);
        Articulo articulo2 = new Articulo("Las mujeres en la era digital", "ONU Mujeres", 2000);;
        Ejercicio ejercicio1 = new Ejercicio("Ejercicios de vocalización para hacer un podcast", "Diana Wong");
        Ejercicio ejercicio2 = new Ejercicio("Cómo hacer una escaleta para un podcast", "Mónica Makako ");

        // Listas
        materiales.add(video1);
        materiales.add(video2);
        materiales.add(articulo1);
        materiales.add(articulo2);
        materiales.add(ejercicio1);
        materiales.add(ejercicio2);

        videos.add(video1);
        videos.add(video2);

        ejercicios.add(ejercicio1);
        ejercicios.add(ejercicio2);

        // Probando los métodos
        System.out.println("Lista de Materiales:");
        AplicacionMaterial.mostrarMateriales(materiales);

        System.out.println("\nDuración total de videos:");
        AplicacionMaterial.contarDuracionVideos(videos);

        System.out.println("\nMarcando ejercicios como revisados:");
        AplicacionMaterial.marcarEjerciciosRevisados(ejercicios);

        System.out.println("\nLista de Ejercicios después de ser revisados:");
        AplicacionMaterial.mostrarMateriales(ejercicios);
    }
}
