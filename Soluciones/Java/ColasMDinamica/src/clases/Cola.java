/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import ListaSimple.ListaSimple;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class Cola<T> implements ICola<T>{
    
    //FIFO: Se insertan elementos por el final (posterior) y se eliminan elementos por el inicio (frente o anterior).
    /*
    TIPOS DE COLA
    Cola simple: Los elementos salen en el mismo orden en el que llegan.
    Cola de prioridades: Los elementos se insertan en cualquier posicion de la cola y se remueven solamente por el frente.
    Cola Doble: Los elementos se pueden añadir o quitar por cualquier extremo de la cola.
    */
    ListaSimple<T> lista;
    int fin;
    
    public Cola(){
        lista = new ListaSimple();
        fin = -1;
    }
    
    //Encolar, añadir, entrar, push, enqueue.
    @Override
    public void insertar(T elemento) {
        lista.agregarAlFinal(elemento);
        fin++;
    }
    
    //Desencolar, eliminar, salir, pop. dequeue.
    @Override
    public T eliminar() {
        T fuera = (T) lista.obtenerAlPrimero();
        lista.eliminarElPrimero();
        fin--;
        return fuera;
    }
    
    @Override
    public boolean colaVacia() {
        if(fin == -1){
            return true;
        }
        return false;
    }
    
    
    //Consultar, front
    @Override
    public T frente() {
        if(fin != -1){
            return (T) lista.obtenerAlPrimero();
        }
        return null;
    }

    @Override
    public int tamanio() {
        if(fin != -1){
            return lista.Tamanio();
        }
        return 0;
    }

    @Override
    public void vaciarCola() {
        fin = -1;
        lista.eliminarLista();
    }

    @Override
    public void mostrarCola() {
        if(fin != -1){
            System.out.println(lista.convertirCadena());
        }else{
            System.out.println("Cola vacia");
        }
    }

    @Override
    public T primerElementoCola() {
        if(fin != -1){
            return (T) lista.obtenerAlPrimero();
        }
        return null;
    }
    
    @Override
    public T ultimoElementoCola(){
        if (fin != -1) {
            return (T) lista.obtenerElUltimo();
        }
        return null;
    }
}
