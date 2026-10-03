package personajes;

import exception.RpgException;

public interface Sanador {
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();
}
