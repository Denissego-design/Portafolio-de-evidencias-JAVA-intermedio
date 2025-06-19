import java.util.List;

abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();
}

class Video extends MaterialCurso {
    private int duracionEnMinutos;

    public Video(String titulo, String autor, int duracionEnMinutos) {
        super(titulo, autor);
        this.duracionEnMinutos = duracionEnMinutos;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracionEnMinutos + " minutos");
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }
}

class Articulo extends MaterialCurso {
    private int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Artículo: " + titulo + " - Autor: " + autor + " - Palabras: " + palabras);
    }
}

class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }

    public void marcarComoRevisado() {
        revisado = true;
    }
}