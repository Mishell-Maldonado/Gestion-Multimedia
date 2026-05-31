package controlador;

import java.util.ArrayList;

//Controlador MVC. Orquesta Vista y Modelo. Aplica DIP.


import java.util.List;
import modelo.Actor;
import modelo.ContenidoAudiovisual;
import modelo.Pelicula;
import util.GestorCSV;
import vista.ConsolaVista;

public class ContenidoController {
    private ConsolaVista vista;
    private GestorCSV gestorArchivos;
    private List<ContenidoAudiovisual> contenidos; 
    private static final String RUTA_CSV = "contenidos.csv"; 

    public ContenidoController(ConsolaVista vista) {
        this.vista = vista;
        this.gestorArchivos = new GestorCSV();
        this.contenidos = new ArrayList<>(); // Inicializamos la lista vacía
    }

    public void iniciar() {
        vista.mostrarMensaje("--- INICIANDO SISTEMA DE CONTENIDO AUDIOVISUAL ---");
        
        boolean salir = false;
        
        while (!salir) {
            vista.mostrarMenu();
            String opcion = vista.pedirOpcion();
            
            switch (opcion) {
                case "1":
                    // Etapa 1: Lectura de CSV
                    contenidos = gestorArchivos.leerContenidos(RUTA_CSV);
                    vista.mostrarMensaje(">> Datos cargados. Se encontraron " + contenidos.size() + " contenidos.");
                    break;
                    
                case "2":
                    // Muestrar los datos en memoria
                    if (contenidos.isEmpty()) {
                        vista.mostrarMensaje(">> No hay contenidos. Cargue los datos primero (Opción 1).");
                    } else {
                        vista.mostrarMensaje(">> Listado de contenidos:");
                        for (ContenidoAudiovisual contenido : contenidos) {
                            vista.mostrarContenido(contenido);
                        }
                    }
                    break;
                    
                case "3":
                    // Etapa 1: Escritura en CSV
                    // Aplicando KISS: Se crea un objeto por código para probar la escritura
                    Pelicula nuevaPeli = new Pelicula("Interestelar", 169, "Ciencia Ficción", "Warner");
                    nuevaPeli.agregarActor(new Actor("Matthew McConaughey"));
                    contenidos.add(nuevaPeli);
                    
                    gestorArchivos.guardarContenidos(RUTA_CSV, contenidos);
                    vista.mostrarMensaje(">> Película de ejemplo agregada y guardada en CSV exitosamente.");
                    break;
                    
                case "4":
                    salir = true;
                    vista.mostrarMensaje(">> Saliendo del sistema...");
                    break;
                    
                default:
                    vista.mostrarMensaje(">> Opción no válida. Intente de nuevo.");
            }
        }
    }
}