package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DocumentalTest {

    @Test
    void testAgregarInvestigador() {
        // 1. Preparar
        Documental doc = new Documental("El Universo", 60, "Ciencia", "Astronomía");
        Investigador inv = new Investigador("Dr. Jane Doe");
        
        // 2. Actuar
        doc.agregarInvestigador(inv);
        
        // 3. Verificar
        assertEquals(1, doc.getInvestigadores().size(), "Debería tener 1 investigador");
        assertEquals("Dr. Jane Doe", doc.getInvestigadores().get(0).getNombre(), "El nombre del investigador debería ser Dr. Jane Doe");
    }
    
    @Test
    void testConstructorDocumental() {
        Documental doc = new Documental("Planeta Tierra", 90, "Naturaleza", "Ecosistemas");
        
        assertEquals("Planeta Tierra", doc.getTitulo());
        assertEquals("Ecosistemas", doc.getTema());
        assertTrue(doc.getInvestigadores().isEmpty(), "La lista de investigadores debería estar vacía al inicio");
    }
}