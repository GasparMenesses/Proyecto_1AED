package aed;

import org.example.components.Dataset;
import org.example.components.Experiment;
import org.example.components.ExperimentState;
import org.example.components.Model;
import org.example.service.DatasetService;
import org.example.service.LabFlowManager;
import org.example.service.ModelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LabFlowManagerTest {

    private DatasetService datasetService;
    private ModelService modelService;
    private LabFlowManager manager;

    @BeforeEach
    public void setUp() {
        datasetService = new DatasetService();
        modelService = new ModelService();
        manager = new LabFlowManager(datasetService, modelService);

        // Poblar datos base para los tests
        datasetService.registerDataset(new Dataset(1, "Dataset A", 100, "Type 1"));
        datasetService.registerDataset(new Dataset(2, "Dataset B", 200, "Type 2"));
        
        modelService.registerModel(new Model(1, "Model A", "Type X", "Params"));
        modelService.registerModel(new Model(2, "Model B", "Type Y", "Params"));
    }

    @Test
    public void testCreateExperimentSuccess() {
        boolean created = manager.createExperiment(100, 1, 1);
        assertTrue(created, "El experimento debería crearse correctamente con IDs válidos");

        Experiment exp = manager.searchExperiment(100);
        assertNotNull(exp);
        assertEquals(100, exp.getId());
        assertEquals(1, exp.getDataset().getId());
        assertEquals(1, exp.getModel().getId());
        assertEquals(ExperimentState.PENDIENTE, exp.getState());
    }

    @Test
    public void testCreateExperimentInvalidDatasetOrModel() {
        boolean createdInvalidDataset = manager.createExperiment(101, 999, 1);
        assertFalse(createdInvalidDataset, "No debería crearse con un dataset inexistente");

        boolean createdInvalidModel = manager.createExperiment(102, 1, 999);
        assertFalse(createdInvalidModel, "No debería crearse con un modelo inexistente");
    }

    @Test
    public void testCreateExperimentDuplicateId() {
        manager.createExperiment(103, 1, 1);
        boolean createdDuplicate = manager.createExperiment(103, 2, 2);
        assertFalse(createdDuplicate, "No debería permitir crear dos experimentos con el mismo ID");
    }

    @Test
    public void testExecuteAllExperiments() {
        manager.createExperiment(201, 1, 1);
        manager.createExperiment(202, 2, 2);

        Experiment exp1 = manager.searchExperiment(201);
        Experiment exp2 = manager.searchExperiment(202);

        assertEquals(ExperimentState.PENDIENTE, exp1.getState());
        assertEquals(ExperimentState.PENDIENTE, exp2.getState());

        manager.executeAllExperiments();

        assertEquals(ExperimentState.EJECUTADO, exp1.getState());
        assertEquals(ExperimentState.EJECUTADO, exp2.getState());
        
        assertTrue(exp1.getAccuracy() >= 0.0 && exp1.getAccuracy() <= 1.0);
        assertTrue(exp2.getPrecision() >= 0.0 && exp2.getPrecision() <= 1.0);
    }
}
