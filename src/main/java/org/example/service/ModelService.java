package org.example.service;

import org.example.components.Model;
import org.example.utils.Lista;

public class ModelService {

    Lista<Model> modelos = new Lista<>();

    //registrar Model para agregar un modelo a la lista de modelos, pero solo si no existe un modelo con el mismo id
    public boolean registerModel(Model model) {
        if (model == null) {
            return false;
        }
        if (searchModel(model.getId()) != null) {
            return false;
        }
        modelos.agregar(model);
        return true;
    }
    // PrintModels para imprimir los modelos en la lista de modelos

    public void PrintModels() {
        for (int i = 0; i < modelos.tamaño(); i++) {
            System.out.println(
                 "ID: " + modelos.obtener(i).getId() + " - Modelo: " + modelos.obtener(i).getName() + " - Tipo: " + modelos.obtener(i).getType() + " - Parámetros: " + modelos.obtener(i).getParameters());
        }
    }

    // eliminarModel para eliminar un modelo de la lista de modelos por su id, y devolver true si se eliminó, o false si no se encontró
    public boolean removeModel(int id) {
        for (int i = 0; i < modelos.tamaño(); i++) {
            if (modelos.obtener(i).getId() == id) {
                modelos.remover(i);
                return true;
            }
        }
        return false;
    }

    // searchModel para buscar un modelo en la lista de modelos por su id, y devolverlo si se encuentra, o null si no se encuentra
    public Model searchModel(int id) {
        for (int i = 0; i < modelos.tamaño(); i++) {
            if (modelos.obtener(i).getId() == id) {
                return modelos.obtener(i);
            }
        }
        return null;
    }

    // listModels para imprimir los modelos en la lista de modelos
    public void listModels() {
        for (int i = 0; i < modelos.tamaño(); i++) {
            System.out.println(modelos.obtener(i));
        }
    }

}
