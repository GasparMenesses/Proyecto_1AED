package aed;

import org.example.utils.Cola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ColaTest {

    private Cola<Integer> cola;

    @BeforeEach
    public void setUp() {
        cola = new Cola<>();
    }

    @Test
    public void testColaVaciaInicialmente() {
        assertTrue(cola.esVacio());
    }

    @Test
    public void testAgregarYQuitar() {
        cola.agregar(10);
        cola.agregar(20);
        cola.agregar(30);

        assertFalse(cola.esVacio());
        
        assertEquals(10, cola.quitaDeCola());
        assertEquals(20, cola.quitaDeCola());
        assertEquals(30, cola.quitaDeCola());
        
        assertTrue(cola.esVacio());
    }

    @Test
    public void testQuitarDeColaVaciaLanzaExcepcion() {
        assertThrows(NoSuchElementException.class, () -> {
            cola.quitaDeCola();
        });
    }

    @Test
    public void testAgregarEnIndiceCeroEquivaleAAgregarAlFinalSiEstaVacia() {
        cola.agregar(0, 100);
        assertEquals(100, cola.quitaDeCola());
    }

    @Test
    public void testAgregarEnIndiceDistintoDeCeroLanzaExcepcion() {
        assertThrows(UnsupportedOperationException.class, () -> {
            cola.agregar(1, 50);
        });
    }
}
