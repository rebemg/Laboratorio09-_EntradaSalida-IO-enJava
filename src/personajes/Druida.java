package personajes;

public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String vinculoAnimal;

    public Druida(String nombre) {
        this(nombre, 1, 30, 15, "Águila");
    }

    public Druida(String nombre, int nivel, int mana, int poderCuracion, String vinculoAnimal) {
        super(nombre, nivel);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] invoca raíces del bosque.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 20 + mana / 2 + 10;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (aliado == null) {
            System.out.println(nombre + " no puede curar a un aliado nulo.");
            return;
        }

        aliado.puntovida += poderCuracion;
        aliado.estaVivo = aliado.puntovida > 0;
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.puntovida);
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

    public String getVinculoAnimal() {
        return vinculoAnimal;
    }
}
