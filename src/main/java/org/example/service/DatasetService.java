package org.example.service;

import org.example.components.Dataset;
import org.example.utils.Lista;

public class DatasetService {

    Lista<Dataset> datasets = new Lista<>();

    // registrarDataset para agregar un dataset a la lista de datasets, pero solo si no existe un dataset con el mismo id
    public boolean registerDataset(Dataset dataset) {
        if (dataset == null) {
            return false;
        }
        if (searchDataset(dataset.getId()) != null) {
            return false;
        }
        datasets.agregar(dataset);
        return true;
    }

    // PrintDatasets para imprimir los datasets en la lista de datasets
    public void PrintDatasets() {
        for (int i = 0; i < datasets.tamaño(); i++) {
            System.out.println("Dataset: " + datasets.obtener(i).getName() + " / Tipo: " + datasets.obtener(i).getProblemType() + " / Tamaño: " + datasets.obtener(i).getSize());
        }
    }

    // searchDataset para buscar un dataset en la lista de datasets por su id, y devolverlo si se encuentra, o null si no se encuentra
    public Dataset searchDataset(int id) {
        for (int i = 0; i < datasets.tamaño(); i++) {
            if (datasets.obtener(i).getId() == id) {
                return datasets.obtener(i);
            }
        }
        return null;
    }

    // listarDatasets para imprimir los datasets en la lista de datasets
    public void listDatasets() {
        for (int i = 0; i < datasets.tamaño(); i++) {
            System.out.println(datasets.obtener(i));
        }
    }

    //eliminar Dataset para eliminar un dataset de la lista de datasets por su id, y devolver true si se eliminó, o false si no se encontró
    public boolean removeDataset(int id) {
        for (int i = 0; i < datasets.tamaño(); i++) {
            if (datasets.obtener(i).getId() == id) {
                datasets.remover(i);
                return true;
            }
        }
        return false;
    }

}
