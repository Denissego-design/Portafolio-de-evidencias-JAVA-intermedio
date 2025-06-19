//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    MovilidadApp app = new MovilidadApp();
    app.procesarViaje("Centro", "Norte");

    // Espera opcional para que las tareas asíncronas finalicen antes de que termine el main
    try { Thread.sleep(4000); } catch (InterruptedException ignored) {}
}