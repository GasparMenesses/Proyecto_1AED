package aed;

import org.example.model.Dataset;
import org.example.service.DatasetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatasetServiceTest {

    private DatasetService datasetService;

    @BeforeEach
    public void setUp() {
        datasetService = new DatasetService();
    }

    @Test
    public void testRegisterDatasetSuccess() {
        Dataset dataset = new Dataset(1, "Data1", 100, "Class");
        assertTrue(datasetService.registerDataset(dataset));
        
        Dataset found = datasetService.searchDataset(1);
        assertNotNull(found);
        assertEquals("Data1", found.getName());
    }

    @Test
    public void testRegisterDatasetNull() {
        assertFalse(datasetService.registerDataset(null));
    }

    @Test
    public void testRegisterDatasetDuplicateId() {
        Dataset dataset1 = new Dataset(1, "Data1", 100, "Class");
        Dataset dataset2 = new Dataset(1, "Data2", 200, "Reg");
        
        assertTrue(datasetService.registerDataset(dataset1));
        assertFalse(datasetService.registerDataset(dataset2)); // Same ID
    }

    @Test
    public void testRemoveDatasetSuccess() {
        Dataset dataset = new Dataset(1, "Data1", 100, "Class");
        datasetService.registerDataset(dataset);
        
        assertTrue(datasetService.removeDataset(1));
        assertNull(datasetService.searchDataset(1));
    }

    @Test
    public void testRemoveDatasetNotFound() {
        assertFalse(datasetService.removeDataset(99));
    }
}
