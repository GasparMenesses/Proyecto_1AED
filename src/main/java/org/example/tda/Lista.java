package org.example.tda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lista<T> implements TDALista<T> {
    private final List<T> elements;

    public Lista() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void agregar(T elem) {
        elements.add(elem);
    }

    @Override
    public void agregar(int index, T elem) {
        elements.add(index, elem);
    }

    @Override
    public T obtener(int index) {
        return elements.get(index);
    }

    @Override
    public T remover(int index) {
        return elements.remove(index);
    }

    @Override
    public boolean remover(T elem) {
        return elements.remove(elem);
    }

    @Override
    public boolean contiene(T elem) {
        return elements.contains(elem);
    }

    @Override
    public int indiceDe(T elem) {
        return elements.indexOf(elem);
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        for (T elem : elements) {
            if (criterio.test(elem)) {
                return elem;
            }
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        Lista<T> sorted = new Lista<>();
        elements.stream().sorted(comparator).forEach(sorted::agregar);
        return sorted;
    }

    @Override
    public int tamaño() {
        return elements.size();
    }

    @Override
    public boolean esVacio() {
        return elements.isEmpty();
    }

    @Override
    public void vaciar() {
        elements.clear();
    }
}
