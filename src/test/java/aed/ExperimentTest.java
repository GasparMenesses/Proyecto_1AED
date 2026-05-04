package aed;

import org.example.components.Dataset;
import org.example.components.Experiment;
import org.example.components.ExperimentState;
import org.example.components.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExperimentTest {

    @Test
    public void testExperimentCreation() {
        Model model = new Model(1, "Linear Regression", "Regression", "alpha=0.1");
        Dataset dataset = new Dataset(1, "Housing Data", 1000, "Regression");
        Experiment experiment = new Experiment(100, model, dataset, ExperimentState.PENDIENTE, 0.0, 0.0);

        assertEquals(100, experiment.getId());
        assertEquals(model, experiment.getModel());
        assertEquals(dataset, experiment.getDataset());
        assertEquals(ExperimentState.PENDIENTE, experiment.getState());
        assertEquals(0.0, experiment.getAccuracy());
        assertEquals(0.0, experiment.getPrecision());
    }

    @Test
    public void testExperimentSetters() {
        Model model = new Model(2, "Random Forest", "Classification", "trees=100");
        Dataset dataset = new Dataset(2, "Iris Data", 150, "Classification");
        Experiment experiment = new Experiment(101, model, dataset, ExperimentState.PENDIENTE, 0.0, 0.0);

        experiment.setState(ExperimentState.EJECUTADO);
        experiment.setResult(0.95, 0.90);

        assertEquals(ExperimentState.EJECUTADO, experiment.getState());
        assertEquals(0.95, experiment.getAccuracy());
        assertEquals(0.90, experiment.getPrecision());
    }
}
