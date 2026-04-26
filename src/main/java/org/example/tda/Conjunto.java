package org.example.tda;
import java.util.Comparator;
import java.util.function.Predicate;

public class Conjunto<T extends Comparable<T>> implements TDAConjunto<T> {

    private TDALista<T> elementos;

    public Conjunto(TDALista<T> lista) {
        this.elementos = lista;
    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        TDALista<T> listaResultado = crearNuevaLista(); 
        
        int posicionA = 0;
        int posicionB = 0;
        int cantidadA = this.tamaño();
        int cantidadB = otro.tamaño();

        while (posicionA < cantidadA && posicionB < cantidadB) {
            T elementoA = this.obtener(posicionA);
            T elementoB = otro.obtener(posicionB);

            int comparacion = elementoA.compareTo(elementoB);

            if (comparacion < 0) {
                listaResultado.agregar(elementoA);
                posicionA++;
            } else if (comparacion > 0) {
                listaResultado.agregar(elementoB);
                posicionB++;
            } else { // Son iguales
                listaResultado.agregar(elementoA);
                posicionA++;
                posicionB++;
            }
        }

        while (posicionA < cantidadA) {
            listaResultado.agregar(this.obtener(posicionA));
            posicionA++;
        }

        while (posicionB < cantidadB) {
            listaResultado.agregar(otro.obtener(posicionB));
            posicionB++;
        }

        return new Conjunto<>(listaResultado);
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        TDALista<T> listaResultado = crearNuevaLista();
        
        int posicionA = 0;
        int posicionB = 0;
        int cantidadA = this.tamaño();
        int cantidadB = otro.tamaño();

        while (posicionA < cantidadA && posicionB < cantidadB) {
            T elementoA = this.obtener(posicionA);
            T elementoB = otro.obtener(posicionB);

            int comparacion = elementoA.compareTo(elementoB);

            if (comparacion == 0) {
                listaResultado.agregar(elementoA);
                posicionA++;
                posicionB++;
            } else if (comparacion < 0) {
                posicionA++;
            } else {
                posicionB++;
            }
        }

        return new Conjunto<>(listaResultado);
    }

    // --- Métodos delegados de TDALista ---

    @Override
    public int tamaño() { return elementos.tamaño(); }

    @Override
    public T obtener(int index) { return elementos.obtener(index); }

    @Override
    public void agregar(T elem) { elementos.agregar(elem); }

    @Override
    public void agregar(int index, T elem) { elementos.agregar(index, elem); }

    @Override
    public T remover(int index) { return elementos.remover(index); }

    @Override
    public boolean remover(T elem) { return elementos.remover(elem); }

    @Override
    public boolean contiene(T elem) { return elementos.contiene(elem); }

    @Override
    public int indiceDe(T elem) { return elementos.indiceDe(elem); }

    @Override
    public T buscar(Predicate<T> criterio) { return elementos.buscar(criterio); }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) { return elementos.ordenar(comparator); }

    @Override
    public boolean esVacio() { return elementos.esVacio(); }

    @Override
    public void vaciar() { elementos.vaciar(); }

 @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        TDALista<T> listaResultado = crearNuevaLista();
        int posA = 0, posB = 0;
        int cantA = this.tamaño(), cantB = otro.tamaño();

        while (posA < cantA && posB < cantB) {
            T elemA = this.obtener(posA);
            T elemB = otro.obtener(posB);
            int comp = elemA.compareTo(elemB);

            if (comp < 0) {
                listaResultado.agregar(elemA);
                posA++;
            } else if (comp == 0) {
                posA++;
                posB++;
            } else {
                posB++;
            }
        }
        // Agregar lo que sobre de A (que por definición no está en B)
        while (posA < cantA) {
            listaResultado.agregar(this.obtener(posA++));
        }
        return new Conjunto<>(listaResultado);
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        if (this.tamaño() > otro.tamaño()) return false;
        
        int posA = 0, posB = 0;
        int cantA = this.tamaño(), cantB = otro.tamaño();

        while (posA < cantA && posB < cantB) {
            T elemA = this.obtener(posA);
            T elemB = otro.obtener(posB);
            int comp = elemA.compareTo(elemB);

            if (comp == 0) {
                posA++;
                posB++;
            } else if (comp > 0) {
                posB++; // B es más chico, sigo buscando el de A más adelante en B
            } else {
                return false; // El elemento de A es menor al de B, y como está ordenado, ya no aparecerá
            }
        }
        return posA == cantA; // Es subconjunto si recorrimos todo A
    }

    private TDALista<T> crearNuevaLista() {
        return new Lista<T>(); 
    }
}