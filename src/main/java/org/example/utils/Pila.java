package org.example.utils;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.example.tda.TDALista;
import org.example.tda.TDAPila;

public class Pila<T> implements TDAPila<T> {
    private Nodo<T> primero;
    private int tamano;

    public Pila() {
        this.primero = null;
        this.tamano = 0;
    }

    @Override
    public void agregar(T elem) {
        this.mete(elem);
    }

    @Override
    public void agregar(int index, T elem) {    
        this.mete(elem);
    }

    @Override
    public T obtener(int index) {
        if (index == 0) return this.tope();
        
        Nodo<T> aux = primero;
        for (int i = 0; i < index && aux != null; i++) {
            aux = aux.getSiguiente();
        }
        if (aux == null) throw new IndexOutOfBoundsException();
        return aux.getDato();
    }

    @Override
    public T remover(int index) {
        if (index == 0) return this.saca();
        throw new UnsupportedOperationException("Solo se puede remover el tope de la pila");
    }

    @Override
    public boolean remover(T elem) {
        if (!esVacio() && tope().equals(elem)) {
            this.saca();
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
        int i = 0;
        while (aux != null) {
            if (aux.getDato().equals(elem)) return i;
            aux = aux.getSiguiente();
            i++;
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> aux = primero;
        while (aux != null) {
            if (criterio.test(aux.getDato())) return aux.getDato();
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("No se puede ordernar una pila");
    }

    @Override
    public int tamaño() {
        return tamano;
    }

    @Override
    public boolean esVacio() {
        return primero == null;
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

    @Override
    public T tope() {
        if (esVacio()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
       return primero.getDato();
    }

        public T saca() {
        if (esVacio()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        T datoRecuperado = primero.getDato();
        // El primero ahora es el siguiente en la fila
        this.primero = primero.getSiguiente();
        this.tamano--;
        return datoRecuperado;
    }

    @Override
    public void mete(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        // El nuevo nodo apunta al que antes era el primero
        nuevoNodo.setSiguiente(primero);
        // El nuevo nodo pasa a ser el tope (primero)
        this.primero = nuevoNodo;
        this.tamano++;
    }   
    
}
