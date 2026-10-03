package personajes;

import exception.PersonajeDerrotadoException;
import exception.AccionInvalidaException;
import exception.PersonajeNuloException;
import exception.RecursoInsuficienteException;
import exception.RpgException;

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
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }

        mana -= 10;
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
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }

        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException(
                "curarAliado",
                "No se puede curar a un personaje derrotado"
            );
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
