package skills;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import personajes.Personaje;

public class PersistenciaGremio {

    private static final String CARPETA = "datos_gremio";

    public PersistenciaGremio() {
        crearCarpetaSiNoExiste();
    }

    private void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("[IO] Carpeta '" + CARPETA + "' creada.");
        }
    }

    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : roster) {
                writer.write(p.getNombre() + "," +
                             p.getNivel() + "," +
                             p.getPuntovida());
                writer.newLine();
            }
        }

        System.out.println("[IO] Roster guardado: " +
                           roster.size() + " personajes.");
    }

    public ArrayList<String> cargarRoster() throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");
        ArrayList<String> lineas = new ArrayList<>();

        if (!archivo.exists()) {
            System.out.println("[IO] roster.txt no encontrado.");
            return lineas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        }

        System.out.println("[IO] Roster cargado: " +
                           lineas.size() + " registros.");
        return lineas;
    }

    public void agregarEntradaBitacora(String entrada) throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(archivo, true))) {
            writer.write(entrada);
            writer.newLine();
        }
    }

    public void mostrarBitacora() throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");

        if (!archivo.exists()) {
            System.out.println("[IO] La bitácora está vacía.");
            return;
        }

        System.out.println("\n=== Bitácora de Batallas ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numero = 1;

            while ((linea = reader.readLine()) != null) {
                System.out.println(numero++ + ". " + linea);
            }
        }
    }

    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> item : inventario.entrySet()) {
                writer.write(item.getKey() + "," + item.getValue());
                writer.newLine();
            }
        }

        System.out.println("[IO] Inventario guardado: " +
                           inventario.size() + " items.");
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");
        HashMap<String, Integer> inventario = new HashMap<>();

        if (!archivo.exists()) {
            return inventario;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String item = partes[0];
                int cantidad = Integer.parseInt(partes[1]);
                inventario.put(item, cantidad);
            }
        }

        return inventario;
    }
}
