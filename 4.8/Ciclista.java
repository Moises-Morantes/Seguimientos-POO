package CarreraCiclística;

public abstract class Ciclista {
    private int identificador;
    private String nombre;
    private int tiempoAcumulado = 0;

    public Ciclista(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    abstract String imprimirTipo();

    protected int getIdentificador() {
        return identificador;
    }

    protected void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
