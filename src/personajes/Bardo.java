package personajes;

public class Bardo extends Personaje implements Sanador {
    private String instrumento;
    private int carisma;

    public Bardo(String nombre) {
        this(nombre, 1, "Lira", 12);
    }

    public Bardo(String nombre, int nivel, String instrumento, int carisma) {
        super(nombre, nivel);
        this.instrumento = instrumento;
        this.carisma = carisma;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] aturde con su laúd.");
    }

    @Override
    public int calcularDanio() {
        return nivel * 5 + carisma * 2;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (aliado == null) {
            System.out.println(nombre + " no puede curar a un aliado nulo.");
            return;
        }

        int cura = carisma * 2;
        aliado.puntovida += cura;
        aliado.estaVivo = aliado.puntovida > 0;
        System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre() + " +" + cura + ". Vida: " + aliado.puntovida);
    }

    @Override
    public int getPoderCuracion() {
        return carisma * 2;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getCarisma() {
        return carisma;
    }
}
