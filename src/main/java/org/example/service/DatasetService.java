package org.example.service;

import org.example.model.Dataset;
import org.example.utils.Lista;

public class DatasetService {

    Lista<Dataset> datasets = new Lista<>();

    // reciveDataset para agregar a la lista de datasets
    public void reciveDataset(Dataset dataset) {
        datasets.agregar(dataset);
    }

    // registrarDataset para agregar un dataset a la lista de datasets, pero solo si no existe un dataset con el mismo id
    public boolean registrarDataset(Dataset dataset) {
        if (dataset == null) {
            return false;
        }
        if (buscarDataset(dataset.getId()) != null) {
            return false;
        }
        datasets.agregar(dataset);
        return true;
    }

    // buscarDataset para buscar un dataset en la lista de datasets por su id, y devolverlo si se encuentra, o null si no se encuentra
    public Dataset buscarDataset(int id) {
        for (int i = 0; i < datasets.tamaño(); i++) {
            if (datasets.obtener(i).getId() == id) {
                return datasets.obtener(i);
            }
        }
        return null;
    }

    // listarDatasets para imprimir los datasets en la lista de datasets
    public void listarDatasets() {
        for (int i = 0; i < datasets.tamaño(); i++) {
            System.out.println(datasets.obtener(i));
        }
    }

    //eliminar Dataset para eliminar un dataset de la lista de datasets por su id, y devolver true si se eliminó, o false si no se encontró
    public boolean eliminarDataset(int id) {
        for (int i = 0; i < datasets.tamaño(); i++) {
            if (datasets.obtener(i).getId() == id) {
                datasets.remover(i);
                return true;
            }
        }
        return false;
    }

}
