import java.util.Optional;

public class Pedido {
    private static int contador = 1;
    private final int numeroPedido;
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.numeroPedido = contador++;
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }

    @Override
    public String toString() {
        return "Pedido #" + numeroPedido + " - Cliente: " + cliente + ", Entrega: " + tipoEntrega;
    }
}