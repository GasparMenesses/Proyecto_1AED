package org.example.service;

import org.example.components.Dataset;
import org.example.components.Model;
import org.example.components.Experiment;
import org.example.components.ExperimentState;
import org.example.utils.Lista;
import org.example.utils.Cola;

public class LabFlowManager {

    private DatasetService datasetService;
    private ModelService modelService;
    // pendientes (FIFO)
    private Cola<Experiment> pendingExperiments;
    // historial ejecutados
    private Lista<Experiment> executedHistory;

    public LabFlowManager(DatasetService datasetService, ModelService modelService) {
        this.datasetService = datasetService;
        this.modelService = modelService;
        this.pendingExperiments = new Cola<>();
        this.executedHistory = new Lista<>();
    }

    // --- CREAR / REGISTRAR ---
    public boolean createExperiment(int id, int datasetId, int modelId) {

        Dataset dataset = datasetService.searchDataset(datasetId);
        Model model = modelService.searchModel(modelId);

        if (dataset == null || model == null) {
            return false;
        }

        if (searchExperiment(id) != null) {
            return false;
        }

        Experiment experim = new Experiment(id, model, dataset, ExperimentState.PENDIENTE, 0.0, 0.0);
        boolean added = pendingExperiments.poneEnCola(experim);

        return true && added;
    }

    // --- BUSCAR (en pendientes + historial) ---
    public Experiment searchExperiment(int id) {

        // buscar en pendientes SIN romper la cola
        int size = pendingExperiments.tamaño();
        for (int i = 0; i < size; i++) {
            Experiment e = pendingExperiments.quitaDeCola();

            if (e.getId() == id) {
                pendingExperiments.poneEnCola(e); // lo vuelvo a poner
                return e;
            }

            pendingExperiments.poneEnCola(e); // lo vuelvo a poner
        }

        // buscar en historial
        for (int i = 0; i < executedHistory.tamaño(); i++) {
            Experiment e = executedHistory.obtener(i);
            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    // --- LISTADOS ---

    public void listExecutedExperiments() {
        for (int i = 0; i < executedHistory.tamaño(); i++) {
            System.out.println( "ID: " + executedHistory.obtener(i).getId() + " - Modelo: " + executedHistory.obtener(i).getModel().getName() + " - Dataset: " + executedHistory.obtener(i).getDataset().getName() + " - Estado: " + executedHistory.obtener(i).getState() + " - Accuracy: " + executedHistory.obtener(i).getAccuracy() + " - Precision: " + executedHistory.obtener(i).getPrecision());
        }
    }
    
    public void listExperimentsByDataset(int datasetId) {

        // pendientes
        int size = pendingExperiments.tamaño();
        for (int i = 0; i < size; i++) {
            Experiment e = pendingExperiments.quitaDeCola();

            if (e.getDataset().getId() == datasetId) {
                System.out.println( "ID: " + e.getId() + " - Modelo: " + e.getModel().getName() + " - Dataset: " + e.getDataset().getName() + " - Estado: " + e.getState() + " - Accuracy: " + e.getAccuracy() + " - Precision: " + e.getPrecision());
            }

            pendingExperiments.poneEnCola(e);
        }

        // historial
        for (int i = 0; i < executedHistory.tamaño(); i++) {
            Experiment e = executedHistory.obtener(i);
            if (e.getDataset().getId() == datasetId) {
                System.out.println( "ID: " + e.getId() + " - Modelo: " + e.getModel().getName() + " - Dataset: " + e.getDataset().getName() + " - Estado: " + e.getState() + " - Accuracy: " + e.getAccuracy() + " - Precision: " + e.getPrecision());
            }
        }
    }

    public void listExperimentsByModel(int modelId) {

        // pendientes
        int size = pendingExperiments.tamaño();
        for (int i = 0; i < size; i++) {
            Experiment e = pendingExperiments.quitaDeCola();

            if (e.getModel().getId() == modelId) {
                System.out.println( "ID: " + e.getId() + " - Modelo: " + e.getModel().getName() + " - Dataset: " + e.getDataset().getName() + " - Estado: " + e.getState() + " - Accuracy: " + e.getAccuracy() + " - Precision: " + e.getPrecision());
            }

            pendingExperiments.poneEnCola(e);
        }

        // historial
        for (int i = 0; i < executedHistory.tamaño(); i++) {
            Experiment e = executedHistory.obtener(i);
            if (e.getModel().getId() == modelId) {
                System.out.println( "ID: " + e.getId() + " - Modelo: " + e.getModel().getName() + " - Dataset: " + e.getDataset().getName() + " - Estado: " + e.getState() + " - Accuracy: " + e.getAccuracy() + " - Precision: " + e.getPrecision());
            }
        }
    }

    // --- EJECUCIÓN ---
    public void executeAllExperiments() {

        while (!pendingExperiments.esVacio()) {

            Experiment e = pendingExperiments.quitaDeCola();

            // métricas simuladas
            double accuracy = Math.random();
            double precision = Math.random();

            e.setResult(accuracy, precision);
            e.setState(ExperimentState.EJECUTADO);

            executedHistory.agregar(e);
        }
    }
}
