package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PeliculaTest {

    @Test
    void testAgregarActor() {
        // 1. Preparar
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner");
        Actor actor = new Actor("Leonardo DiCaprio");
        
        // 2. Actuar
        pelicula.agregarActor(actor);
        
        // 3. Verificar
        assertEquals(1, pelicula.getActores().size(), "La película debería tener 1 actor");
        assertEquals("Leonardo DiCaprio", pelicula.getActores().get(0).getNombre(), "El nombre del actor debería ser Leonardo DiCaprio");
    }
    
    @Test
    void testConstructorPelicula() {
        Pelicula pelicula = new Pelicula("Matrix", 136, "Acción", "Warner");
        
        assertEquals("Matrix", pelicula.getTitulo());
        assertEquals(136, pelicula.getDuracionEnMinutos());
        assertEquals("Warner", pelicula.getEstudio());
        assertTrue(pelicula.getActores().isEmpty(), "La lista de actores debería estar vacía al inicio");
    }
}