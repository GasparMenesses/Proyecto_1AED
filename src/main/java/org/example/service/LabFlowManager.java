package org.example.service;
import org.example.model.*;
import org.example.utils.Lista;

public class LabFlowManager {
    
    Lista<Model> modelos = new Lista<>();
    Lista<Dataset> datasets;


    public void reciveModel(Model model){
        modelos.agregar(model);
    }

    public void PrintModels(){
        for (int i = 0; i < modelos.tamaño(); i++) {
            System.out.println(modelos.obtener(i).getName());
        }
    }
}
