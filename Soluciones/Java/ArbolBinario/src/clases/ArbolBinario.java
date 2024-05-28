/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class ArbolBinario implements IArbolBinario{
    
    NodoArbol raiz;
    
    public ArbolBinario(){
        raiz = null;
    }
    
    // Método Insertar Nodo no recursivo.
    @Override
    public void insertarNodo(Integer elemento, String nombre) {
        NodoArbol nuevo = new NodoArbol(elemento, nombre);
        if(estaVacio()){
            raiz = nuevo;
        }else{
            NodoArbol temporal = raiz;
            NodoArbol padre;
            while(true){
                padre = temporal;
                if(elemento < temporal.dato){
                    temporal = temporal.hijoIzquierdo; // Actualizar temporal
                    if(temporal == null){ // Verificar que sea una hoja
                        padre.hijoIzquierdo = nuevo; // Enlazo el puntero izquierdo al nuevo nodo.
                        return;
                    }
                }else{
                    temporal = temporal.hijoDerecho; // Actualizar temporal
                    if(temporal == null){ // Verificar que sea una hoja
                        padre.hijoDerecho = nuevo; // Enlazo el puntero derecho al nuevo nodo.
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void borrarNodo() {
        // FALTA
    }

    @Override
    public boolean estaVacio() {
        return raiz == null;
    }

    @Override
    public Integer obtenerRaiz() {
        if(!estaVacio()){
            return raiz.dato;
        }
        return null;
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
                if(nodoActual.hijoIzquierdo != null){ // Verifica si el nodo actual contiene hijos
                    colaNodo.add(nodoActual.hijoIzquierdo);
                }
                
                if(nodoActual.hijoDerecho != null){ // Verifica si el nodo actual contiene hijos
                    colaNodo.add(nodoActual.hijoDerecho);
                }
            }
        }
        
        return altura;
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
            if (nodoActual.hijoIzquierdo != null) {
                cola.add(nodoActual.hijoIzquierdo);
            }
            if (nodoActual.hijoDerecho != null) {
                cola.add(nodoActual.hijoDerecho);
            }
        }

        return contador;
    }

    @Override
    public void postOrden(NodoArbol r) {
        if(r != null){
            //Izquierda-Derecha-Raiz
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.println(r.dato);
        }
    }
    
    @Override
    public void preOrden(NodoArbol r) {
        if(r != null){
            //Raiz-Izquierda-Derecha
            System.out.println(r.dato);
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }
    
    @Override
    public void inOrden(NodoArbol r) {
        if(r != null){
            //Izquierda-Raiz-Derecha
            inOrden(r.hijoIzquierdo);
            System.out.println(r.dato);
            inOrden(r.hijoDerecho);
        }
    }
    
}
