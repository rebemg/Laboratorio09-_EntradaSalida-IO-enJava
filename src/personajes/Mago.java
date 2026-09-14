package personajes;

public class Mago extends Personaje {
    private int mana;
    private int nivelMagia;
    private String elemento;

    public Mago(String nombre, int mana, int nivelMagia) {
        this(nombre, 1, mana, nivelMagia, "Arcano");
    }

    public Mago(String nombre, int nivel, int mana, int nivelMagia, String elemento) {
        super(nombre, nivel);
        this.mana = mana;
        this.nivelMagia = nivelMagia;
        this.elemento = elemento;
    }

    public int getMana() {
        return mana;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public String getElemento() {
        return elemento;
    }

    @Override
    public void atacar() {
        System.out.println("[" + getNombre() + "] ataca con un golpe básico.");
        System.out.println("¡" + getNombre() + " lanza una bola de fuego causando " + calcularDanio() + " de daño mágico!");
    }

    @Override
    public String defender() {
        return getNombre() + " crea un escudo mágico.";
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: " + mana + ", Nivel de Magia: " + nivelMagia + ", Elemento: " + elemento;
    }
}
