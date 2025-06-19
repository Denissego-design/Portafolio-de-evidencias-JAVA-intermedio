import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Main { //
    public static void main(String[] args) {
        Sucursal sucursalCentro = new Sucursal("Centro", Arrays.asList(
                new Encuesta("Ana", "Esperó mucho tiempo", 2),
                new Encuesta("Luis", null, 4),
                new Encuesta("Sofía", "Faltó información", 3)
        ));

        Sucursal sucursalNorte = new Sucursal("Norte", Arrays.asList(
                new Encuesta("Carlos", null, 2),
                new Encuesta("Elena", "Atención muy impersonal", 1)
        ));

        List<Sucursal> sucursales = Arrays.asList(sucursalCentro, sucursalNorte);

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(encuesta -> encuesta.getCalificacion() <= 3)
                                .flatMap(encuesta ->
                                        encuesta.getComentario()
                                                .map(comentario ->
                                                        Stream.of("Sucursal [" + sucursal.getNombre() + "]: Seguimiento a paciente con comentario: \"" + comentario + "\"")
                                                )
                                                .orElseGet(Stream::empty)
                                )
                )
                .forEach(System.out::println);
    }
}