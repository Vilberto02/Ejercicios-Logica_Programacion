/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Cola implements ICola{
    NodoCola inicio, fin;
    int tamanio, indice = 0;
    
    public Cola(int size){
        inicio = fin = null;
        tamanio = size;
    }

    @Override
    public void insertar(String elemento) {
        if(estaLlena()){
            System.out.println("La cola esta llena");
        }else{
            NodoCola nuevoNodo = new NodoCola(elemento);
            if(estaVacia()){
                inicio = nuevoNodo;
            }else{
                fin.siguiente = nuevoNodo;
            }
            fin = nuevoNodo;
            fin.siguiente = inicio;
            indice++;
        }
    }

    @Override
    public String quitar() {
        if(estaVacia()){
            return null;
        }else{
            String fuera = inicio.dato;
            if(inicio == fin){
                inicio = fin = null;
            }else{
                inicio = inicio.siguiente;
                fin.siguiente = inicio;
            }
            indice--;
            return fuera;
        }
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }

    @Override
    public boolean estaLlena() {
        return tamanio == indice;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public String frente() {
        if(estaVacia()){
            return null;
        }else{
            return inicio.dato;
        }
    }
    
    @Override
    public void mostrarElementos(){
        if (estaVacia()) {
            System.out.println("La cola esta vacia");
        }else{
            NodoCola temporal = fin.siguiente;
            String message = "";
            do{
                message = message + " [" + temporal.dato + "] ";
                temporal = temporal.siguiente;
            }while(temporal != fin.siguiente);
            System.out.println(message);
        }
    }
}
