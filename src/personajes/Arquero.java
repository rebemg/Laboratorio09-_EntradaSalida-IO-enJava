package personajes;

import exception.PersonajeDerrotadoException;
import exception.RecursoInsuficienteException;
import exception.RpgException;

public class Arquero extends Personaje {
    private int flechasDisponibles;
    private int precision;
    private String tipoArco;
    private int alcance;

    public Arquero(String nombre, int flechasDisponibles, int precision) {
        this(nombre, 1, flechasDisponibles, "Arco Común", precision, 50);
    }

    public Arquero(String nombre, int nivel, int flechasDisponibles, String tipoArco, int precision, int alcance) {
        super(nombre, nivel);
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
        this.tipoArco = tipoArco;
        this.alcance = alcance;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public int getPrecision() {
        return precision;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public int getAlcance() {
        return alcance;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. " +
                           "Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public String defender() {
        return getNombre() + " esquiva y se repliega.";
    }

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    @Override
    public String toString() {
        return super.toString() + ", Flechas Disponibles: " + flechasDisponibles + ", Precisión: " + precision + ", Tipo de Arco: " + tipoArco + ", Alcance: " + alcance;
    }
}
