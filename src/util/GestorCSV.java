package util;

import modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//SRP: Maneja exclusivamente persistencia en CSV.

public class GestorCSV {

    // Método para LEER el CSV y convertirlo en objetos
    public List<ContenidoAudiovisual> leerContenidos(String rutaArchivo) {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        // Validación defensiva: Si el archivo no existe, retorna la lista vacía limpiamente
        if (!archivo.exists()) {
            System.out.println("Advertencia: El archivo " + rutaArchivo + " no existe. Se iniciará con una lista vacía.");
            return contenidos;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; 
                
                String[] datos = linea.split(",");
                String tipo = datos[0].trim();

                switch (tipo) {
                    case "PELICULA":
                        Pelicula pelicula = new Pelicula(datos[1].trim(), Integer.parseInt(datos[2].trim()), datos[3].trim(), datos[4].trim());
                        if (datos.length > 5) {
                            pelicula.agregarActor(new Actor(datos[5].trim()));
                        }
                        contenidos.add(pelicula);
                        break;
                    
                    case "SERIE":
                        SerieDeTV serie = new SerieDeTV(datos[1].trim(), Integer.parseInt(datos[2].trim()), datos[3].trim(), Integer.parseInt(datos[4].trim()));
                        if (datos.length > 5) { 
                        	// Vista MVC. Interacción con usuario en consola
                            String[] datosTemp = datos[5].trim().split("-");
                            if (datosTemp.length == 2) {
                                serie.agregarTemporada(new Temporada(Integer.parseInt(datosTemp[0].trim()), Integer.parseInt(datosTemp[1].trim())));
                            }
                        }
                        contenidos.add(serie);
                        break;

                    case "DOCUMENTAL":
                        Documental documental = new Documental(datos[1].trim(), Integer.parseInt(datos[2].trim()), datos[3].trim(), datos[4].trim());
                        if (datos.length > 5) {
                            documental.agregarInvestigador(new Investigador(datos[5].trim()));
                        }
                        contenidos.add(documental);
                        break;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al procesar el archivo CSV: " + e.getMessage());
        }
        
        return contenidos;
    }

    // Método para ESCRIBIR los objetos al CSV
    public void guardarContenidos(String rutaArchivo, List<ContenidoAudiovisual> contenidos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                String lineaCSV = "";

                if (contenido instanceof Pelicula) {
                    Pelicula p = (Pelicula) contenido;
                    lineaCSV = "PELICULA," + p.getTitulo() + "," + p.getDuracionEnMinutos() + "," + p.getGenero() + "," + p.getEstudio();
                    if (!p.getActores().isEmpty()) {
                        lineaCSV += "," + p.getActores().get(0).getNombre();
                    }
                } else if (contenido instanceof SerieDeTV) {
                    SerieDeTV s = (SerieDeTV) contenido;
                    lineaCSV = "SERIE," + s.getTitulo() + "," + s.getDuracionEnMinutos() + "," + s.getGenero() + "," + s.getTemporadas();
                    if (!s.getListaTemporadas().isEmpty()) {
                        Temporada t = s.getListaTemporadas().get(0);
                        lineaCSV += "," + t.getNumero() + "-" + t.getEpisodios();
                    }
                } else if (contenido instanceof Documental) {
                    Documental d = (Documental) contenido;
                    lineaCSV = "DOCUMENTAL," + d.getTitulo() + "," + d.getDuracionEnMinutos() + "," + d.getGenero() + "," + d.getTema();
                    if (!d.getInvestigadores().isEmpty()) {
                        lineaCSV += "," + d.getInvestigadores().get(0).getNombre();
                    }
                }
                
                bw.write(lineaCSV);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}