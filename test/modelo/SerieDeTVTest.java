package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SerieDeTVTest {

    @Test
    void testAgregarTemporada() {
        // 1. Preparar
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);
        Temporada temporada1 = new Temporada(1, 7);
        
        // 2. Actuar
        serie.agregarTemporada(temporada1);
        
        // 3. Verificar
        assertEquals(1, serie.getListaTemporadas().size(), "Debería tener 1 temporada");
        assertEquals(7, serie.getListaTemporadas().get(0).getEpisodios(), "La temporada 1 debería tener 7 episodios");
    }
    
    @Test
    void testConstructorSerie() {
        SerieDeTV serie = new SerieDeTV("Stranger Things", 50, "Ciencia Ficción", 4);
        
        assertEquals("Stranger Things", serie.getTitulo());
        assertEquals(4, serie.getTemporadas());
        assertTrue(serie.getListaTemporadas().isEmpty(), "La lista de temporadas debería estar vacía al inicio");
    }
}
