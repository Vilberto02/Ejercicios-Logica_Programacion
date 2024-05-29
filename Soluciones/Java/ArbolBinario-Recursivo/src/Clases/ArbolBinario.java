
package Clases;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class ArbolBinario implements IArbol{
    NodoArbol raiz;
    
    public ArbolBinario(){
        raiz = null;
    }

    @Override
    public void insertarNodo(Integer elemento, String nombre) {
        NodoArbol nuevo = new NodoArbol(elemento, nombre); // Crea al nuevo nodo
        if(raiz == null){
            raiz = nuevo;
        }else{
            insertarNodoRecursivo(raiz, nuevo);
        }
    }
    
    public void insertarNodoRecursivo(NodoArbol actual, NodoArbol nuevo){
        if (nuevo.dato < actual.dato){
            if(actual.hijoizquierdo == null){
                actual.hijoizquierdo = nuevo;
            } else{
                insertarNodoRecursivo(actual.hijoizquierdo, nuevo);
            }
        } else{
            if(actual.hijoderecho == null){
                actual.hijoderecho = nuevo;
            }else{
                insertarNodoRecursivo(actual.hijoderecho, nuevo);
            }
        }
    }

    @Override
    public boolean estaVacio() {
        return raiz == null;
    }

    @Override
    public Integer obtenerRaiz() {
        if(estaVacio()){
            return null;
        }else{
            return raiz.dato;
        }
    }

    @Override
    public int obtenerAltura() {
        // Cuando esta vacio, su altura es 0.
        if(estaVacio()){
            return 0;
        }
        
        // Se usa una cola para poder evaluar el nodo que ingresa primero en cada iteración, en este caso será el hijo izquierdo (una vez que se haya eliminado la raiz)
        // luego el derecho.
        Queue<NodoArbol> colaNodo = new LinkedList<>();
        colaNodo.add(raiz);
        int altura = 0;
        
        while(!colaNodo.isEmpty()){ // Dado que se estan eliminando elementos de la cola, el bucle se cierra cuando la cola esta vacia.
            int tamanio = colaNodo.size(); // Tamaño de la cola. Varia de acuerdo a los nodos hijos que encuentra.
            altura++; // Aumenta en cada iteracion, debido a que se están encontrando nodos hijos.
            /*Recorre la cola, su tamaño va variando segun los nodos hijos que hayan del nodo padre*/
            for (int i = 0; i < tamanio; i++) {
                NodoArbol nodoActual = colaNodo.poll(); // Se eliminan el primer nodo de la cola, sucesivamente.
                if(nodoActual.hijoizquierdo != null){ // Verifica si el nodo actual contiene hijos
                    colaNodo.add(nodoActual.hijoizquierdo);
                }
                // Verifica si el nodo actual contiene hijos
                if(nodoActual.hijoderecho != null){ 
                    colaNodo.add(nodoActual.hijoderecho);
                }
            }
        }
        
        return altura;
    }
    
    @Override
    public NodoArbol eliminar(Integer clave) {
        raiz = eliminarNodoRecursivo(raiz, clave);
        return raiz;
    }
    
    public NodoArbol eliminarNodoRecursivo(NodoArbol raiz, Integer clave){
        if(raiz == null){
            return raiz;
        }
        
        if(clave < raiz.dato){
            raiz.hijoizquierdo = eliminarNodoRecursivo(raiz.hijoizquierdo, clave);
        } else if(clave > raiz.dato){
            raiz.hijoderecho = eliminarNodoRecursivo(raiz.hijoderecho, clave);
        }else{
            if(raiz.hijoizquierdo == null){
                return raiz.hijoderecho;
            }else if(raiz.hijoderecho == null){
                return raiz.hijoizquierdo;
            }
            
            raiz.dato = minimoValorNodo(raiz.hijoderecho).dato;
            raiz.hijoderecho = eliminarNodoRecursivo(raiz.hijoderecho, raiz.dato);
        }
        
        return raiz;
    }
    
    public NodoArbol minimoValorNodo(NodoArbol nodo){
        NodoArbol actual = nodo;
        while(actual.hijoizquierdo != null){
            actual = actual.hijoizquierdo;
        }
        
        return actual;
    }


    @Override
    public int numeroElementos() {
        // Si el arbol esta vacio retorna 0
        if (raiz == null) {
            return 0;
        }

        Queue<NodoArbol> cola = new LinkedList<>();
        cola.add(raiz); // Añade al primer elemento, en este caso es la raiz.
        int contador = 0;
        
        // Verifica cada nodo. Si tiene
        while (!cola.isEmpty()) {
            NodoArbol nodoActual = cola.poll(); // Elimina al primer elemento de la cola.
            contador++;
            
            // Verifica si el nodo actual tiene hijos.
            if (nodoActual.hijoizquierdo != null) {
                cola.add(nodoActual.hijoizquierdo);
            }
            if (nodoActual.hijoderecho != null) {
                cola.add(nodoActual.hijoderecho);
            }
        }

        return contador;
    }
    
    @Override
    public void postOrden(NodoArbol r){
        //Izquierda-Derecha-Raiz
        if(r != null){
            postOrden(r.hijoizquierdo);
            postOrden(r.hijoderecho);
            System.out.print(r.dato + " ");
        }
    }
    
    @Override
    public void preOrden(NodoArbol r){
        if(r != null){
            //Raiz-Izquierda-Derecha
            System.out.print(r.dato + " ");
            preOrden(r.hijoizquierdo);
            preOrden(r.hijoderecho);
        }
    }
    
    @Override
    public void entreOrden(NodoArbol r){
        if(r != null){
            //Izquierda-Raiz-Derecha
            entreOrden(r.hijoizquierdo);
            System.out.print(r.dato + " ");
            entreOrden(r.hijoderecho);
        }
    }
    
    @Override
    // Método recursivo para buscar un nodo en el árbol
    public NodoArbol buscarNodo(int d) {
        return buscarNodoRecursivo(raiz, d);
    }
    
    // Buscar nodo recursivo
    private NodoArbol buscarNodoRecursivo(NodoArbol actual, int d) {
        // Caso en el que el nodo actual es nulo o sea igual al elemento buscado.
        if (actual == null || actual.dato == d) {
            return actual;
        }
        
        // Caso en el que el dato buscado es menor que el nodo actual
        if (d < actual.dato) {
            return buscarNodoRecursivo(actual.hijoizquierdo, d);
        } else {
            return buscarNodoRecursivo(actual.hijoderecho, d);
        }
    }
}
