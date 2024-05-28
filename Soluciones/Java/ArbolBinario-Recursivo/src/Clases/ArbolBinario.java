/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        if(estaVacio()){
            return 0;
        }
        
        Queue<NodoArbol> colaNodo = new LinkedList<>();
        colaNodo.add(raiz);
        int altura = 0;
        
        
        while(!colaNodo.isEmpty()){
            int tamanio = colaNodo.size();
            altura++;
            /*Recorro*/
            for (int i = 0; i < tamanio; i++) {
                NodoArbol nodoActual = colaNodo.poll();
                if(nodoActual.hijoizquierdo != null){
                    colaNodo.add(nodoActual.hijoizquierdo);
                }
                
                if(nodoActual.hijoderecho != null){
                    colaNodo.add(nodoActual.hijoderecho);
                }
            }
        }
        
        return altura;
    }
    
    @Override
    public boolean eliminar(Integer d) {
        NodoArbol auxiliar=raiz;
        NodoArbol padre=raiz;
        boolean esHijoIzq=true;
        while(auxiliar.dato != d){
            padre=auxiliar;
            if(d<auxiliar.dato){
                esHijoIzq=true;
                auxiliar=auxiliar.hijoizquierdo;
            }else{
                esHijoIzq=false;
                auxiliar=auxiliar.hijoderecho;
            }
            if(auxiliar==null){
                return false;
            }
        }//Fin del while
        if(auxiliar.hijoizquierdo==null && auxiliar.hijoderecho==null){
            if(auxiliar==raiz){
                raiz=null;
            }else if(esHijoIzq){
                padre.hijoizquierdo=null;
            }else{
                padre.hijoderecho=null;
            }
        }else if(auxiliar.hijoderecho==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoizquierdo;
            }else if(esHijoIzq){
                padre.hijoizquierdo=auxiliar.hijoizquierdo;
            }else{
                padre.hijoderecho=auxiliar.hijoizquierdo;
            }
        }else if(auxiliar.hijoizquierdo==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoderecho;
            }else if(esHijoIzq){
                padre.hijoizquierdo=auxiliar.hijoderecho;
            }else{
                padre.hijoderecho=auxiliar.hijoizquierdo;
            }
        }else{
            NodoArbol reemplazo=obtenerNodoReemplazo(auxiliar);
            if(auxiliar==raiz){
                raiz=reemplazo;
            }else if(esHijoIzq){
                padre.hijoizquierdo=reemplazo;
            }else{
                padre.hijoderecho=reemplazo;
            }
            reemplazo.hijoizquierdo=auxiliar.hijoizquierdo;
        }
        return true;
    }
    
    @Override
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp){
        NodoArbol reemplazarPadre=nodoReemp;
        NodoArbol reemplazo=nodoReemp;
        NodoArbol auxiliar=nodoReemp.hijoderecho;
        while(auxiliar!=null){
            reemplazarPadre=reemplazo;
            reemplazo=auxiliar;
            auxiliar=auxiliar.hijoizquierdo;
        }
        if(reemplazo!=nodoReemp.hijoderecho){
            reemplazarPadre.hijoizquierdo=reemplazo.hijoderecho;
            reemplazo.hijoderecho=nodoReemp.hijoderecho;
        }
        System.out.println("El nodo reemplazo es "+ reemplazo);
        return reemplazo;
    }


    @Override
    public int numeroElementos() {
        if (raiz == null) {
            return 0;
        }

        Queue<NodoArbol> cola = new LinkedList<>();
        cola.add(raiz);
        int contador = 0;

        while (!cola.isEmpty()) {
            NodoArbol nodoActual = cola.poll();
            contador++;

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
        /*Izquierda-Derecha-Raiz*/
        if(r != null){
            postOrden(r.hijoizquierdo);
            postOrden(r.hijoderecho);
            System.out.print(r.dato + " ");
        }
    }
    
    @Override
    public void preOrden(NodoArbol r){
        if(r != null){
            System.out.print(r.dato + " ");
            preOrden(r.hijoizquierdo);
            preOrden(r.hijoderecho);
        }
    }
    
    @Override
    public void entreOrden(NodoArbol r){
        if(r != null){
            entreOrden(r.hijoizquierdo);
            System.out.print(r.dato + " ");
            entreOrden(r.hijoderecho);
        }
    }
}
