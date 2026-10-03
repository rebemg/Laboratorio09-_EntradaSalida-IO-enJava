package personajes;

import exception.AccionInvalidaException;
import exception.RpgException;
import skills.Combatiente;

public abstract class Personaje implements Combatiente {
    protected String nombre;
    protected int nivel;
    protected int puntovida;
    protected boolean estaVivo;

    public Personaje(String nombre) {
        this(nombre, 1);
    }

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntovida = 100;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntovida() {
        return puntovida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    @Override
    public abstract void atacar() throws RpgException;

    @Override
    public String defender() {
        return nombre + " se defiende con un escudo básico.";
    }

    public abstract int calcularDanio();

    public void recibirDanio(int danio) throws AccionInvalidaException {
        if (danio < 0) {
            throw new AccionInvalidaException(
                "recibirDanio",
                "El daño no puede ser negativo: " + danio
            );
        }
        puntovida -= danio;
        if (puntovida <= 0) {
            puntovida = 0;
            estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio +
                           " de daño. Vida: " + puntovida);
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public void mostrarEstado() {
        System.out.println("[Estado] " + nombre + " | Nivel: " + nivel + " | Vida: " + puntovida + " | Vivo: " + estaVivo);
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println("[Estado Detallado] " + nombre + " | Nivel: " + nivel + " | Vida: " + puntovida + " | Vivo: " + estaVivo + " | Daño base: " + calcularDanio());
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String formato) {
        System.out.println(formato + " " + nombre + " | Nivel: " + nivel + " | Vida: " + puntovida + " | Estado: " + (estaVivo ? "Activo" : "Derrotado"));
    }

    @Override
    public String toString() {
        String vivo = estaVivo ? "Sí" : "No";
        return "Nombre: " + nombre + " | Nivel: " + nivel +
               " | Vida: " + puntovida + " | Vivo: " + vivo;
    }
}
