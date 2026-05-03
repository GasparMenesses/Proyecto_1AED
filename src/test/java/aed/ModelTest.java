package aed;

import org.example.model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {

    @Test
    public void testModelCreation() {
        Model model = new Model(1, "Test Model", "Neural Network", "epochs=50");

        assertEquals(1, model.getId());
        assertEquals("Test Model", model.getName());
        assertEquals("Neural Network", model.getType());
        assertEquals("epochs=50", model.getParameters());
    }
}
