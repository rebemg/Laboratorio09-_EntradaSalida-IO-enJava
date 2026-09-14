package personajes;

public class Guerrero extends Personaje {
    private int fuerza;
    private int resistencia;
    private String tipoArma;

    public Guerrero(String nombre, int fuerza, int resistencia) {
        this(nombre, 1, fuerza, resistencia, "Sin arma");
    }

    public Guerrero(String nombre, int fuerza, int resistencia, String tipoArma) {
        this(nombre, 1, fuerza, resistencia, tipoArma);
    }

    public Guerrero(String nombre, int nivel, int fuerza, int resistencia, String tipoArma) {
        super(nombre, nivel);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.tipoArma = tipoArma;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    @Override
    public void atacar() {
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + calcularDanio() + " de daño!");
    }

    @Override
    public String defender() {
        return getNombre() + " se protege con un escudo.";
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel();
    }

    public void entrenar() {
        entrenar(1, false);
    }

    public void entrenar(int sesiones) {
        entrenar(sesiones, false);
    }

    public void entrenar(int sesiones, boolean intensivo) {
        int aumento = 5 * sesiones;
        if (intensivo) {
            aumento *= 2;
        }
        this.fuerza += aumento;
        System.out.println(getNombre() + " entrena y aumenta su fuerza en " + aumento + ". Fuerza actual: " + fuerza);
    }
}
