package skills;

import java.util.ArrayList;
import personajes.Personaje;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla() {
        this.historial = new ArrayList<>();
    }

    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        String evento = "[BATALLA] " + atacante.getNombre() + " ataca solo → daño: " + danio;
        historial.add(atacante.getNombre() + " atacó solo (daño: " + danio + ")");
        System.out.println(evento);
    }

    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        System.out.println(defensor.defender());

        String evento = "[BATALLA] " + atacante.getNombre() + " ataca a " + defensor.getNombre() + " → daño: " + danio;
        String descripcion = atacante.getNombre() + " atacó a " + defensor.getNombre() + " (daño: " + danio + ")";
        if (defensor.getPuntovida() <= 0) {
            descripcion += " - " + defensor.getNombre() + " derrotado";
        }
        historial.add(descripcion);
        System.out.println(evento);
    }

    public void ejecutarAtaque(Personaje[] equipo) {
        String nombres = "";
        for (int i = 0; i < equipo.length; i++) {
            if (equipo[i] != null) {
                if (i > 0) {
                    nombres += ", ";
                }
                nombres += equipo[i].getNombre();
            }
        }

        System.out.println("[BATALLA] Equipo completo ataca → " + equipo.length + " personajes");
        historial.add("Ataque en equipo: " + nombres);
        for (Personaje atacante : equipo) {
            if (atacante != null) {
                atacante.atacar();
            }
        }
    }

    public void mostrarHistorial() {
        System.out.println("-- Historial --");
        if (historial.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}
