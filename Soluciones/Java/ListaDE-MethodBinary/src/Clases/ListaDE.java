/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class ListaDE implements IListaDE{
    NodoDoble inicio;
    NodoDoble fin;
    int tamanio=0;
    
    public ListaDE(){
        inicio = fin = null;
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }
    
    /*--- Metodo Agregar al inicio ---*/
    //PRE: Recibe un elemento de tipo Integer.
    //POS: No retorna nada pero agrega el elemento al inicio de la lista.
    @Override
    public void agregarAlInicio(Integer elemento) {
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(estaVacia()){
            inicio = fin = nuevoNodo;
        }else{
            nuevoNodo.sucesor = inicio;
            inicio.predecesor = nuevoNodo;
            inicio = nuevoNodo;
        }
    }
    
    /*--- Metodo Agregar al final ---*/
    //PRE: Recibe un elemento de tipo Integer.
    //POS: No retorna nada pero agrega el elemento al final de la lista.
    @Override
    public void agregarAlFinal(Integer elemento) {
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(estaVacia()){
            fin = inicio = nuevoNodo;
        }else{
            fin.sucesor = nuevoNodo;
            nuevoNodo.predecesor = fin;
            fin = nuevoNodo;
        }
    }
    
    /*--- Metodo para mostrar los elementos de la lista desde el inicio hasta el final ---*/
    //PRE: No recibe ningun parametro.
    //POS: No retorna ningun valor pero muestra los elementos de la lista desde el inicio hasta final.
    @Override
    public void mostrarListaInicioFin() {
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            String lista = "";
            NodoDoble temporal = inicio;
            while(temporal != null){
                lista = lista + " ["+temporal.dato+"] ";
                temporal = temporal.sucesor;
            }
            System.out.println(lista);
        }
    }
    
    /*--- Metodo para mostrar los elementos de la lista desde el final hasta el inicio ---*/
    //PRE: No recibe ningun parametro.
    //POS: No retorna ningun valor pero muestra los elementos de la lista desde el final hasta inicio.
    @Override
    public void mostrarListaFinInicio() {
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            String lista = "";
            NodoDoble temporal = fin;
            while(temporal != null){
                lista = lista + " ["+temporal.dato+"] ";
                temporal = temporal.predecesor;
            }
            System.out.println(lista);
        }
    }
    
    /*--- Metodo para insertar un elemento en una posicion indicada ---*/
    //PRE: Recibe como parametro al elemento y el indice en la que debe de estar ese elemento.
    //POS: No retorna ningun valor pero insertar el elemento en la indice indicado.
    @Override
    public void insertarEn(int indice, Integer elemento) {
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(estaVacia()){
            inicio = fin = nuevoNodo;
        }else{
            if(indice == 0){
                nuevoNodo.sucesor = inicio;
                inicio.predecesor = nuevoNodo;
                inicio = nuevoNodo;
            }else{
                int i = 1;
                NodoDoble anterior = inicio;
                NodoDoble temporal = inicio.sucesor;
                while (temporal != null && i<indice) {                
                    i++;
                    anterior = anterior.sucesor;
                    temporal = temporal.sucesor;
                }
                if(temporal != null){
                    nuevoNodo.sucesor = temporal;
                    nuevoNodo.predecesor = anterior;
                    anterior.sucesor = nuevoNodo;
                    temporal.predecesor = nuevoNodo;
                }else{
                    agregarAlFinal(elemento);
                }
            }
        }
    }
    
    /*--- Metodo para conocer si un elemento esta dentro de la lista ---*/
    //PRE: Recibe como parametro al elemento a buscar.
    //POS: Retorna el valor de verdadero si encuentra al elemento dentro de la lista y falso si no lo encuentra.
    @Override
    public boolean contiene(Integer elemento) {
        if(estaVacia()){
            return false;
        }else{
            NodoDoble temporal = inicio;
            while (temporal != null) {                
                if(Objects.equals(temporal.dato, elemento)){
                    return true;
                }
                temporal = temporal.sucesor;
            }
            return false;
        }
    }
    
    /*--- Metodo para conocer el tamaño de la lista ---*/
    //PRE: No recibe ningun parametro.
    //POS: Retorna el tamanio de la lista.
    @Override
    public int tamanio() {
        tamanio = 0;
        NodoDoble temporal = inicio;
        while(temporal != null){
            tamanio++;
            temporal = temporal.sucesor;
        }
        return tamanio;
    }

    /*--- Metodo para obtener el indice de un elemento en la lista ---*/
    //PRE: Recibe como parametro al elemento.
    //POS: Retorna el indice del elemento.
    @Override
    public int obtenerIndice(Integer elemento) {
        if(estaVacia()){
            return -1;
        }else{
            int indice=0; 
            NodoDoble temporal = inicio;
            while(temporal != null && !Objects.equals(temporal.dato, elemento)){
                temporal = temporal.sucesor;
                indice++;
            }
            if(temporal != null){
                return indice;
            }
            return -1;
        }
    }

    /*--- Metodo para obtener el primer elemento de la lista ---*/
    //PRE: No recibe ningun parametro.
    //POS: Retorna al primer elemento de la lista.
    @Override
    public Integer obtenerAlPrimero() {
        if(estaVacia()){
            return null;
        }else{
            return inicio.dato;
        }
    }

    /*--- Metodo para obtener el primer elemento de la lista ---*/
    //PRE: No recibe ningun parametro.
    //POS: Retorna al ultimo elemento de la lista.
    @Override
    public Integer obtenerElUltimo() {
        if(estaVacia()){
            return null;
        }else{
            return fin.dato;
        }
    }

    /*--- Metodo para obtener a un elemento de la lista segun su indice ---*/
    //PRE: Recibe como parametro el indice del elemento a obtener.
    //POS: Retorna el elemento en dicho indice.
    @Override
    public Integer obtenerElemento(int indice) {
        if(estaVacia()){
            return null;
        }else{
            if(indice == 0){
                return inicio.dato;
            }else{
                int i=1;
                NodoDoble temporal = inicio;
                while(temporal != null && i<indice){
                    temporal = temporal.sucesor;
                    i++;
                }
                if(temporal != null){
                    return temporal.dato;
                }
                return null;
            }
        }
    }

    /*--- Metodo para convertir en cadena los elementos de la lista ---*/
    //PRE: No recibe parametros.
    //POS: Retorna una cadena que contiene a los elementos de la lista.
    @Override
    public String convertirCadena() {
        if(estaVacia()){
            return null;
        }else{
            String message = " ";
            NodoDoble temporal = inicio;
            while(temporal != null){
                message = message + "[" + temporal.dato + "] ";
                temporal = temporal.sucesor;
            }
            return message;
        }
    }

    /*--- Metodo para eliminar el primer elemento de la lista ---*/
    //PRE: No recibe parametros.
    //POS: No retorna ningun valor pero elimina el primer elemento de la lista.
    @Override
    public void eliminarElPrimero() {
        if(estaVacia()){
            inicio = fin = null;
        }else{
            NodoDoble temporal = inicio.sucesor;
            temporal.predecesor = null;
            inicio.sucesor = null;
            inicio = temporal;
        }
    }

    /*--- Metodo para eliminar el ultimo elemento de la lista ---*/
    //PRE: No recibe parametros.
    //POS: No retorna ningun valor pero elimina el ultimo elemento de la lista.
    @Override
    public void eliminarElUltimo() {
        if(estaVacia()){
            fin = inicio = null;
        }else{
            NodoDoble temporal = fin.predecesor;
            temporal.sucesor = null;
            fin.predecesor = null;
            fin = temporal;
        }
    }
    
    /*--- Metodo para eliminar un elemento de la lista ---*/
    //PRE: Recibe como parametro el elemento a eliminar.
    //POS: No retorna ningun valor pero elimina el elemento de la lista.
    @Override
    public void eliminarElemento(Integer elemento) {
        if(!estaVacia()){
            if(Objects.equals(inicio.dato, elemento) && inicio == fin){ //Cuando se tiene un solo nodo
                inicio = fin = null;
            }else if(Objects.equals(elemento, inicio.dato)){ //Cuando el elemento se encuentra al inicio de la lista
                inicio = inicio.sucesor;
                inicio.predecesor = null;
            }else{ //Cuando el elemento no se encuentra en el primer nodo
                NodoDoble anterior = inicio;
                NodoDoble temporal = inicio.sucesor;
                while(temporal != null && !Objects.equals(temporal.dato, elemento)){
                    anterior = anterior.sucesor;
                    temporal = temporal.sucesor;
                }
                if(temporal != null){
                    anterior.sucesor = temporal.sucesor;
                    if(temporal.sucesor != null){
                        temporal.sucesor.predecesor = anterior;
                    }
                    if(temporal == fin){
                        fin = anterior;
                    }
                }
            }
        }
    }

    /*--- Metodo para eliminar un elemento de la lista con un indice ---*/
    //PRE: Recibe como parametro el indice en el que se encuentra el elemento a eliminar.
    //POS: No retorna ningun valor pero elimina el elemento en dicho indice de la lista.
    @Override
    public void eliminarConIndice(int indice) {
        Integer elemento = obtenerElemento(indice);
        eliminarElemento(elemento);
        
    }

    /*--- Metodo para mostrar lista ---*/
    //PRE: No recibe ningun parametro.
    //POS: No retorna ningun valor pero muestra los elementos de la lista en pantalla.
    @Override
    public void mostrarLista() {
        if(estaVacia()){
            System.out.println("La lista esta vacía");
        }else{
            System.out.println(convertirCadena());
        }
    }

    /*--- Metodo para saber si la lista solo contiene 1 y 0 ---*/
    //PRE: No recibe ningun parametro.
    //POS: Retorna un valor de verdadero si la lista solo contiene 1 y 0 y falso cuando contiene diferentes numeros.
    @Override
    public boolean isBinary() {
        if(estaVacia()){
            return false;
        }else{
            boolean encontrado = true;
            NodoDoble temporal = inicio;
            while(temporal != null && encontrado){
                encontrado = (Objects.equals(temporal.dato, 0) || Objects.equals(temporal.dato, 1));
                temporal = temporal.sucesor;
            }
            return encontrado;
        }
    }
    
}
