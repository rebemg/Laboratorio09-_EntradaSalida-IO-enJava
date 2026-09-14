package personajes;

public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas;
    private int nivelOscuridad;

    public Nigromante(String nombre) {
        this(nombre, 1, 40, 0, 1);
    }

    public Nigromante(String nombre, int nivel, int mana, int almasAbsorbidas, int nivelOscuridad) {
        super(nombre, nivel);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.nivelOscuridad = nivelOscuridad;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] drena la esencia vital.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + mana / 2 + almasAbsorbidas * 20 + nivelOscuridad * 10;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Maldición de decadencia! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public int getNivelOscuridad() {
        return nivelOscuridad;
    }
}
