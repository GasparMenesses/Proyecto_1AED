package org.example.tda;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Cola<T> implements TDACola<T>{
    private Nodo<T> primero;

    @Override
    public void agregar(T elem) {
        this.poneEnCola(elem);
    }

    @Override
    public void agregar(int index, T elem) {
        if (index == 0){
            this.poneEnCola(elem);
        }
        else{
        throw new UnsupportedOperationException("No se puede insertar por indice");
        }
    }

    @Override
    public T obtener(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Las colas no tienen indice");
    }

    @Override
    public T remover(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public boolean remover(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public boolean contiene(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contiene'");
    }

    @Override
    public int indiceDe(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indiceDe'");
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenar'");
    }

    @Override
    public int tamaño() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamaño'");
    }

    @Override
    public boolean esVacio() {
        return this.primero == null;
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

    @Override
    public T frente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frente'");
    }

    @Override
    public boolean poneEnCola(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
       if (this.primero == null){
        this.primero = nuevoNodo;
       }
        Nodo<T> aux = primero;
        while(aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
            aux.setSiguiente(nuevoNodo);
       }
    }

    @Override
    public T quitaDeCola() {
    if (this.esVacio()){
        throw new NoSuchElementException("La cola está vacia");
    }
    T dato = primero.getDato(); //guardamos el primero
    this.primero = this.primero.getSiguiente(); //movemos el puntero, al siguiente nodo (si no hay, primero queda en null)
    return dato; //retornamos el dato
    }
}
