import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    List<Pedido> pedidos = Arrays.asList(
            new Pedido("Aurelio", "domicilio", "555-1234"),
            new Pedido("Gerardo", "local", "555-1236"),
            new Pedido("Diana", "domicilio", null),
            new Pedido("Delia", "domicilio", "555-5678"),
            new Pedido("Katy", "local", "555-0000")
    );

    pedidos.stream()
            .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
            .map(Pedido::getTelefono)
            .flatMap(Optional::stream)
            .map(tel -> "\uD83D\uDCDE Confirmación enviada al número: " + tel)
            .forEach(System.out::println);
}
