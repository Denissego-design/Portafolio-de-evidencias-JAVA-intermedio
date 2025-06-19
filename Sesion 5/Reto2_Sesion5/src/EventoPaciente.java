public class EventoPaciente {
    public final int idPaciente;
    public final int frecuenciaCardiaca;
    public final int sistolica;
    public final int diastolica;
    public final int spo2;

    public EventoPaciente(int id) {
        this.idPaciente = id;
        this.frecuenciaCardiaca = random(30, 150);
        this.sistolica = random(80, 160);
        this.diastolica = random(50, 100);
        this.spo2 = random(85, 100);
    }

    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}