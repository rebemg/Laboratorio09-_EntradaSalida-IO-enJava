import personajes.Arquero;
import personajes.Druida;
import personajes.Guerrero;
import personajes.Nigromante;
import personajes.Personaje;
import skills.GestorGremio;

public class Main {
    public static void main(String[] args) {
        GestorGremio gremio = new GestorGremio();

        System.out.println("=== Bloque 1: Roster con ArrayList ===");
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, "Bosque"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 4));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80, "Hacha"));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        System.out.println("\n=== Bloque 2: Cola de espera con LinkedList ===");
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();
        gremio.mostrarCola();

        System.out.println("\n=== Bloque 3: Inventario con HashMap ===");
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        System.out.println("\n=== Bloque 4: Habilidades únicas con HashSet ===");
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();

        System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

        System.out.println("\n=== Bloque 5: Resumen del gremio ===");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}