package aed;

import org.example.utils.Pila;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    private Pila<String> pila;

    @BeforeEach
    public void setUp() {
        pila = new Pila<>();
    }

    @Test
    public void testPilaVaciaInicialmente() {
        assertTrue(pila.esVacio());
        assertEquals(0, pila.tamaño());
    }

    @Test
    public void testMeterYSacar() {
        pila.agregar("A");
        pila.agregar("B");
        pila.agregar("C");

        assertFalse(pila.esVacio());
        assertEquals(3, pila.tamaño());
        assertEquals("C", pila.tope());
        
        assertEquals("C", pila.saca());
        assertEquals(2, pila.tamaño());
        
        assertEquals("B", pila.saca());
        assertEquals("A", pila.saca());
        
        assertTrue(pila.esVacio());
        assertEquals(0, pila.tamaño());
    }

    @Test
    public void testTopeYExtraerDePilaVaciaLanzaExcepcion() {
        assertThrows(NoSuchElementException.class, () -> {
            pila.tope();
        });

        assertThrows(NoSuchElementException.class, () -> {
            pila.saca();
        });
    }

    @Test
    public void testRemoverElementoEspecifico() {
        pila.agregar("X");
        pila.agregar("Y");
        
        assertTrue(pila.remover("Y")); // Está en el tope, se debería poder remover
        assertEquals("X", pila.tope());
        
        assertFalse(pila.remover("Z")); // No existe
    }

    @Test
    public void testContieneYBuscar() {
        pila.agregar("Test");
        pila.agregar("Hola");

        assertTrue(pila.contiene("Hola"));
        assertFalse(pila.contiene("Mundo"));

        assertEquals("Hola", pila.buscar(s -> s.startsWith("H")));
        assertNull(pila.buscar(s -> s.equals("Mundo")));
    }
}
