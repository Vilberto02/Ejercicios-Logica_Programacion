/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class ListaSimple<T> implements IListaSimple<T>{
    Nodo inicio, fin;
    T dato;
    
    public ListaSimple(){
        inicio = fin = null;
    }

    @Override
    public void agregarAlInicio(T elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(inicio != null){
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }else{
            nuevoNodo.siguiente = null;
            inicio = fin = nuevoNodo;
        }
    }

    @Override
    public void agregarAlFinal(T elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(fin != null){
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }else{
            nuevoNodo.siguiente = null;
            fin = inicio = nuevoNodo;
        }
    }

    @Override
    public void insertarEn(int indice, T elemento) {
        int i = 1;
        if(estaVacia()){
            agregarAlFinal(elemento);
        }else{
            if(indice == 0){
                agregarAlInicio(elemento);
            }else{
                Nodo anterior = inicio;
                Nodo temporal = anterior.siguiente;
                while(temporal != null && i<indice){
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                    i++;
                }
                if(temporal != null){
                    Nodo nuevoNodo = new Nodo(elemento);
                    anterior.siguiente = nuevoNodo;
                    nuevoNodo.siguiente = temporal;
                }else{
                    agregarAlFinal(elemento);
                }
            }
        }
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }

    @Override
    public boolean contiene(T elemento) {
        Nodo temporal;
        temporal = inicio;
        while(temporal != null){
            if(temporal.dato == elemento){
                return true;
            }
            temporal = temporal.siguiente;
        }
        return false;
    }

    @Override
    public int Tamanio() {
        int tam = 0;
        Nodo temporal = inicio;
        while(temporal != null){
            temporal = temporal.siguiente;
            tam++;
        }
        return tam;
    }

    @Override
    public int obtenerIndice(T elemento) {
        if(estaVacia()){
            return -1;
        }else{
            if(inicio.dato == elemento){
                return 0;
            }else{
                int indice = 0;
                Nodo temporal;
                temporal = inicio;
                while(temporal != null && temporal.dato != elemento){
                    temporal = temporal.siguiente;
                    indice++;
                }
                return indice;
            }
        }
    }

    @Override
    public T obtenerAlPrimero() {
        if(inicio != null){
            return (T) inicio.dato;
        }
        return null;
    }

    @Override
    public T obtenerElUltimo() {
        if(estaVacia()){
            return null;
        }else{
            return (T) fin.dato;
        }
    }

    @Override
    public T obtenerElemento(int indice) {
         int i = 1;
         if(indice == 0){
             return (T) inicio.dato;
         }else{
             Nodo temporal = inicio;
             while(temporal != null){
                 if(i == indice){
                     return (T) temporal.dato;
                 }
                 temporal = temporal.siguiente;
                 i++;
             }
         }
         return null;
    }

    @Override
    public String convertirCadena() {
        String cadena = "";
        Nodo temporal = inicio;
        while (temporal != null) {            
            cadena = cadena + "["+temporal.dato+"]\t";
            temporal = temporal.siguiente;
        }
        return cadena;
    }

    @Override
    public void eliminarElPrimero() {
        if (!estaVacia()){
            inicio = inicio.siguiente;
        }else{
            inicio = fin = null;
        }
    }

    @Override
    public void eliminarElUltimo() {
        if(estaVacia()){
            fin = inicio = null;
        }else{
            Nodo temporal = inicio;
            while(temporal.siguiente != fin){
                temporal = temporal.siguiente;
            }
            temporal.siguiente = null;
            fin = temporal;
        }
    }

    @Override
    public void eliminarElemento(T elemento) {
        if(estaVacia()){
            inicio = fin = null;
        }else{
            if(inicio.dato == elemento && inicio == fin){
                inicio = fin = null;
            }else if(inicio.dato == elemento){
                inicio = inicio.siguiente;
            }else{
                Nodo anterior = inicio;
                Nodo temporal = anterior.siguiente;
                while(temporal != null && temporal.dato != elemento){
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                if(temporal != null){
                    if(temporal == fin){
                        anterior.siguiente = null;
                        fin = anterior;
                    }else{
                        anterior.siguiente = temporal.siguiente;
                    }
                }
            }
        }
    }

    @Override
    public void eliminarConIndice(int indice) {
        T elemento = obtenerElemento(indice);
        eliminarElemento(elemento);
    }

    @Override
    public void mostrarLista() {
        convertirCadena();
    }
    
    @Override
    public void eliminarLista(){
        inicio = fin = null;
    }
    
}
