package aed;

import org.example.components.Model;
import org.example.service.ModelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelServiceTest {

    private ModelService modelService;

    @BeforeEach
    public void setUp() {
        modelService = new ModelService();
    }

    @Test
    public void testRegisterModelSuccess() {
        Model model = new Model(1, "Model1", "Type1", "Params1");
        assertTrue(modelService.registerModel(model));

        Model found = modelService.searchModel(1);
        assertNotNull(found);
        assertEquals("Model1", found.getName());
    }

    @Test
    public void testRegisterModelNull() {
        assertFalse(modelService.registerModel(null));
    }

    @Test
    public void testRegisterModelDuplicateId() {
        Model model1 = new Model(1, "Model1", "Type1", "Params1");
        Model model2 = new Model(1, "Model2", "Type2", "Params2");

        assertTrue(modelService.registerModel(model1));
        assertFalse(modelService.registerModel(model2));
    }

    @Test
    public void testRemoveModelSuccess() {
        Model model = new Model(1, "Model1", "Type1", "Params1");
        modelService.registerModel(model);

        assertTrue(modelService.removeModel(1));
        assertNull(modelService.searchModel(1));
    }

    @Test
    public void testRemoveModelNotFound() {
        assertFalse(modelService.removeModel(99));
    }
}
