package org.example.service;

import org.example.model.Model;
import org.example.utils.Lista;

public class ModelService {

    Lista<Model> modelos = new Lista<>();

    //registrar Model para agregar un modelo a la lista de modelos, pero solo si no existe un modelo con el mismo id
    public boolean registerModel(Model model) {
        if (model == null) {
            return false;
        }
        if (buscarModel(model.getId()) != null) {
            return false;
        }
        modelos.agregar(model);
        return true;
    }
    // PrintModels para imprimir los modelos en la lista de modelos

    public void PrintModels() {
        for (int i = 0; i < modelos.tamaño(); i++) {
            System.out.println(modelos.obtener(i).getName());
        }
    }

    // eliminarModel para eliminar un modelo de la lista de modelos por su id, y devolver true si se eliminó, o false si no se encontró
    public boolean eliminarModel(int id) {
        for (int i = 0; i < modelos.tamaño(); i++) {
            if (modelos.obtener(i).getId() == id) {
                modelos.remover(i);
                return true;
            }
        }
        return false;
    }

    // buscarModel para buscar un modelo en la lista de modelos por su id, y devolverlo si se encuentra, o null si no se encuentra
    public Model buscarModel(int id) {
        for (int i = 0; i < modelos.tamaño(); i++) {
            if (modelos.obtener(i).getId() == id) {
                return modelos.obtener(i);
            }
        }
        return null;
    }

    // listarModels para imprimir los modelos en la lista de modelos
    public void listarModels() {
        for (int i = 0; i < modelos.tamaño(); i++) {
            System.out.println(modelos.obtener(i));
        }
    }

}
