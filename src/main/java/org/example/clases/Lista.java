package org.example.tda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lista<T> implements TDALista<T> {
    private Nodo<T> primero;
    private int tamaño;

    public Lista() {
        this.primero = null;
        this.tamaño = 0;
    }

    @Override
    public void agregar(T elem) {
        Nodo<T> nuevo = new Nodo<>(elem);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> nodo = primero;
            while (nodo.getSiguiente() != null) {
                nodo = nodo.getSiguiente();
            }
            nodo.setSiguiente(nuevo);
        }
        tamaño++;
    }

    @Override
    public void agregar(int index, T elem) {
        if (index < 0 || index > tamaño) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> nuevo = new Nodo<>(elem);       
        if (index == 0) {               
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            Nodo<T> aux = primero;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        tamaño++;
    }

    @Override
    public T obtener(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> aux = primero;
        for (int i = 0; i < index; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }

    @Override
    public T remover(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException();
        }
        T borrado;
        if (index == 0) {
            borrado = primero.getDato();
            primero = primero.getSiguiente();
        } else {
            Nodo<T> aux = primero;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getSiguiente();
            }
            borrado = aux.getSiguiente().getDato();
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        tamaño--;
        return borrado;
    }

    @Override
    public boolean remover(T elem) {
        if (primero == null) return false;
        if (primero.getDato().equals(elem)) {
            primero = primero.getSiguiente();
            tamaño--;
            return true;
        }
        Nodo<T> aux = primero;
        while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(elem)) {
            aux = aux.getSiguiente();
        }
        if (aux.getSiguiente() != null) {
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            tamaño--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contiene(T elem) {
        Nodo<T> aux = primero;
        while (aux != null) {
            if (aux.getDato().equals(elem)) return true;
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        Nodo<T> aux = primero;
        for (int i = 0; i < tamaño; i++) {
            if (aux.getDato().equals(elem)) return i;
            aux = aux.getSiguiente();
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> aux = primero;
        while (aux != null) {
            if (criterio.test(aux.getDato())) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public boolean esVacio() {
        return primero == null;
    }

    @Override
    public void vaciar() {
        primero = null;
        tamaño = 0;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        throw new UnsupportedOperationException("k");
    }
}
