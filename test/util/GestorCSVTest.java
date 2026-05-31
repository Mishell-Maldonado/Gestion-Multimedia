package util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import modelo.ContenidoAudiovisual;
import java.util.List;

class GestorCSVTest {

    @Test
    void testLeerContenidos() {
        // 1. Preparar
        GestorCSV gestor = new GestorCSV();
        String rutaCSV = "contenidos.csv"; // El archivo que ya creaste en tu proyecto
        
        // 2. Actuar
        List<ContenidoAudiovisual> contenidos = gestor.leerContenidos(rutaCSV);
        
        // 3. Verificar
        assertFalse(contenidos.isEmpty(), "La lista de contenidos no debería estar vacía si el CSV tiene datos");
        assertEquals(3, contenidos.size(), "Debería haber leído exactamente 3 contenidos del CSV");
        
        // Verificamos que el primero sea una Película (como está en el CSV)
        assertEquals("Oppenheimer", contenidos.get(0).getTitulo(), "El primer contenido debería ser Oppenheimer");
    }
}