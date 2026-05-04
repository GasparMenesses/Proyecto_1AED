package aed;

import org.example.components.ExperimentState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExperimentStateTest {

    @Test
    public void testExperimentStateValues() {
        ExperimentState state1 = ExperimentState.PENDIENTE;
        ExperimentState state2 = ExperimentState.EJECUTADO;

        assertEquals("PENDIENTE", state1.name());
        assertEquals("EJECUTADO", state2.name());
        
        ExperimentState[] values = ExperimentState.values();
        assertEquals(2, values.length);
        assertEquals(ExperimentState.PENDIENTE, values[0]);
        assertEquals(ExperimentState.EJECUTADO, values[1]);
    }
}
