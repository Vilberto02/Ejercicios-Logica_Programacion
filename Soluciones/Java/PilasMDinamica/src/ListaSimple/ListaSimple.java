/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Usuario
 */
public class ListaSimple implements IListaSimple{
    public Nodo inicio, fin;
    
    public ListaSimple(){
        inicio = null;
        fin = null;
    }

    @Override
    public void agregarAlInicio(int elemento) {
        inicio = new Nodo(elemento, inicio);
        if(fin == null){
           fin = inicio;
        }
    }

    @Override
    public void agregarAlFinal(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if(inicio == null){
            inicio = nuevoNodo;
            fin = nuevoNodo;
        }else{
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    @Override
    public void insertarEn(int indice, int elemento) {
        if(!estaVacia()){
            if(indice == 0){
                agregarAlInicio(elemento);
            }else{
                int i=1;
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
        }else{
            agregarAlFinal(elemento);
        }
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }

    @Override
    public boolean contiene(int elemento) {
        if(!estaVacia()){
            if (fin.dato == elemento){
                return true;
            }else{
                Nodo temporal = inicio;
                while(temporal != fin && temporal.dato != elemento){
                    temporal = temporal.siguiente;
                }
                return temporal != null;
            }
        }else{
            return false;
        }
        /*Nodo temporal = inicio;
        while(temporal != null && temporal.dato != elemento){
            temporal = temporal.siguiente;
        }
        return temporal != null;*/
    }

    @Override
    public int Tamanio() {
        int tamanio = 0;
        Nodo temporal = inicio;
        while(temporal != null){
            temporal = temporal.siguiente;
            tamanio++;
        }
        return tamanio;
    }

    @Override
    public int obtenerIndice(int elemento) {
        Nodo temporal = inicio;
        int indice = 0;
        while(temporal != null){
            if(temporal.dato == elemento){
                return indice;
            }
            temporal = temporal.siguiente;
            indice++;
        }
        return -1; //Por si no se encuentra el indice del elemento en la lista.
    }

    @Override
    public Integer obtenerAlPrimero() {
        if(inicio != null){
            return inicio.dato;
        }
        return null;
    }

    @Override
    public Integer obtenerElUltimo() {
        if(fin != null){
            return fin.dato;
        }
        return null;
    }

    @Override
    public Integer obtenerElemento(int indice) {
        Nodo temporal = inicio;
        int i = 0;
        while(temporal != null){
            if(indice == i){
                return temporal.dato;
            }
            temporal = temporal.siguiente;
            i++;
        }
        return null;
    }

    @Override
    public String convertirCadena() {
        String cadena = "";
        Nodo temporal = inicio;
        while(temporal != null){
            cadena = cadena + "["+temporal.dato+"]-->";
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
        if(!estaVacia()){
            if(inicio == fin){
                inicio = fin = null;
            }else{
                Nodo temporal = inicio;
                while(temporal.siguiente != fin){
                    temporal = temporal.siguiente;
                }
                fin = temporal;
                fin.siguiente = null;
            }
        }else{
            fin = inicio = null;
        }
    }

    @Override
    public void eliminarElemento(int elemento) {
        if(!estaVacia()){
            if(inicio == fin && inicio.dato == elemento){
                inicio = fin = null;
            }else if(inicio.dato == elemento){
                inicio = inicio.siguiente;
            }else{
                Nodo anterior = inicio;
                Nodo temporal = anterior.siguiente;
                while(temporal != null && temporal.dato != elemento){ //Cuando llega a ser null, la sentencia cambia anterior.siguiente = temporal.siguiente (temporal ya es null)
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
        }else{
            inicio = fin = null;
        }
    }

    @Override
    public void eliminarConIndice(int indice) {
        int elemento = obtenerElemento(indice);
        eliminarElemento(elemento);
    }

    @Override
    public void mostrarLista() {
        System.out.println("--- Lista enlazada simple ---");
        System.out.println(convertirCadena());
    }
    
}
