package org.example.service;

import org.example.components.Dataset;
import org.example.components.Model;
import org.example.utils.Lista;

public class LabFlowManager {

    Lista<Model> modelos = new Lista<>();
    Lista<Dataset> datasets = new Lista<>();

    // reciveModel para agregar a la lista de modelos
    public void reciveModel(Model model) {
        modelos.agregar(model);
    }

    // reciveDataset para agregar a la lista de datasets
    public void reciveDataset(Dataset dataset) {
        datasets.agregar(dataset);
    }
    //Permitir registrar múltiples experimentos

}
