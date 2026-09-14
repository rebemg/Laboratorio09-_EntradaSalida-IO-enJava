import personajes.Arquero;
import personajes.Bardo;
import personajes.Druida;
import personajes.Guerrero;
import personajes.Hechicero;
import personajes.Mago;
import personajes.Nigromante;
import personajes.Personaje;
import personajes.Sanador;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");

        System.out.println("-- Error esperado --");
        System.out.println("Personaje invalido = new Personaje(\"Error\");");
        System.out.println("Error: Personaje is abstract; cannot be instantiated");

        Druida druida = new Druida("Sylva", 7, 180, 120, "Bosque");
        Nigromante nigromante = new Nigromante("Malachar", 6, 220, 6, 4);
        Bardo bardo = new Bardo("Finnian", 5, "Laúd", 30);

        Guerrero guerrero = new Guerrero("Ragnar", 4, 180, 90, "Armadura de hierro");
        Mago mago = new Mago("Gandalf", 5, 120, 140, "Fuego");
        Arquero arquero = new Arquero("Legolas", 4, 160, "Arco largo", 35, 85);

        System.out.println("\n-- Ataques y daño --");
        Personaje[] equipo = { druida, nigromante, bardo };
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }
        for (Personaje p : new Personaje[] { guerrero, mago, arquero }) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        nigromante.recibirDanio(300);
        System.out.println("Malachar recibe 300 de daño. Vida: " + nigromante.getPuntovida());

        Personaje[] aliados = { druida, nigromante, bardo, guerrero, mago, arquero };
        for (Personaje p : aliados) {
            if (p instanceof Sanador s && p != nigromante) {
                s.curarAliado(nigromante);
            }
        }

        System.out.println("\n-- Integración con clases originales --");
        Personaje[] equipoOriginal = { guerrero, mago, arquero };
        for (Personaje p : equipoOriginal) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Estado final --");
        System.out.println("Nombre: " + druida.getNombre() + "    | Nivel: " + druida.getNivel() + " | Vida: " + druida.getPuntovida() + " | Vivo: " + (druida.isEstaVivo() ? "Sí" : "No"));
        System.out.println("Nombre: " + nigromante.getNombre() + " | Nivel: " + nigromante.getNivel() + " | Vida: " + nigromante.getPuntovida() + " | Vivo: " + (nigromante.isEstaVivo() ? "Sí" : "No"));
        System.out.println("Nombre: " + bardo.getNombre() + "  | Nivel: " + bardo.getNivel() + " | Vida: " + bardo.getPuntovida() + " | Vivo: " + (bardo.isEstaVivo() ? "Sí" : "No"));
        System.out.println("Nombre: " + guerrero.getNombre() + " | Nivel: " + guerrero.getNivel() + " | Vida: " + guerrero.getPuntovida() + " | Vivo: " + (guerrero.isEstaVivo() ? "Sí" : "No"));
        System.out.println("Nombre: " + mago.getNombre() + "    | Nivel: " + mago.getNivel() + " | Vida: " + mago.getPuntovida() + " | Vivo: " + (mago.isEstaVivo() ? "Sí" : "No"));
        System.out.println("Nombre: " + arquero.getNombre() + "  | Nivel: " + arquero.getNivel() + " | Vida: " + arquero.getPuntovida() + " | Vivo: " + (arquero.isEstaVivo() ? "Sí" : "No"));
    }
}