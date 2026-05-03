package aed;

import org.example.components.Dataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatasetTest {

    @Test
    public void testDatasetCreation() {
        Dataset dataset = new Dataset(1, "Test Dataset", 100, "Classification");

        assertEquals(1, dataset.getId());
        assertEquals("Test Dataset", dataset.getName());
        assertEquals(100, dataset.getSize());
        assertEquals("Classification", dataset.getProblemType());
    }
}
