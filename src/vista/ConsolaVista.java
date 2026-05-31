package vista;

import modelo.ContenidoAudiovisual;
import modelo.Pelicula;
import modelo.SerieDeTV;
import modelo.Documental;
import modelo.Actor;
import modelo.Investigador;
import modelo.Temporada;

import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner;
    
 // Vista MVC. Interacción con usuario en consola.
    
    public ConsolaVista() {
        scanner = new Scanner(System.in);
    }

    // Método para mostrar cualquier contenido usando POLIMORFISMO
    public void mostrarContenido(ContenidoAudiovisual contenido) {
        System.out.println("=======================================");
        System.out.println("ID: " + contenido.getId());
        System.out.println("Título: " + contenido.getTitulo());
        System.out.println("Duración: " + contenido.getDuracionEnMinutos() + " min");
        System.out.println("Género: " + contenido.getGenero());

        if (contenido instanceof Pelicula) {
            Pelicula p = (Pelicula) contenido;
            System.out.println("Estudio: " + p.getEstudio());
            System.out.print("Actores: ");
            for (Actor a : p.getActores()) { System.out.print(a.getNombre() + ", "); }
            System.out.println();
        } else if (contenido instanceof SerieDeTV) {
            SerieDeTV s = (SerieDeTV) contenido;
            System.out.println("Temporadas previstas: " + s.getTemporadas());
            System.out.print("Detalles temporadas: ");
            for (Temporada t : s.getListaTemporadas()) { System.out.print("T" + t.getNumero() + "(" + t.getEpisodios() + "ep), "); }
            System.out.println();
        } else if (contenido instanceof Documental) {
            Documental d = (Documental) contenido;
            System.out.println("Tema: " + d.getTema());
            System.out.print("Investigadores: ");
            for (Investigador i : d.getInvestigadores()) { System.out.print(i.getNombre() + ", "); }
            System.out.println();
        }
        System.out.println("=======================================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ SISTEMA AUDIOVISUAL ---");
        System.out.println("1. Cargar datos desde archivo CSV");
        System.out.println("2. Mostrar todos los contenidos");
        System.out.println("3. Ejecutar inserción de prueba y persistencia CSV"); // <- AQUÍ EL CAMBIO
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public String pedirOpcion() {
        return scanner.nextLine();
    }
}