/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pila;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class Pila<T> implements IPila<T>{
    LinkedList<T> lista;
    int cima;
    
    public Pila(){
        this.lista = new LinkedList<>();
        this.cima = -1;
    }

    @Override
    public Integer tamanio() {
        return lista.size();
    }

    @Override
    public void apilar(T dato) {
        cima++;
        lista.addLast(dato);
    }

    @Override
    public T desapilar() {
        if(estaVacia()){
            throw new IllegalStateException("La pila esta vacia, no se puede desapilar");
        }
        T fuera = lista.getLast();
        lista.removeLast();
        cima--;
        return fuera;
    }

    @Override
    public T cima() {
        return lista.getLast();
    }

    @Override
    public boolean estaVacia() {
        return cima == -1;
    }

    @Override
    public T primerElemento() {
        return lista.getFirst();
    }
    
    @Override
    public void mostrarElementos(){
        System.out.println("Elementos de la pila: ");
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }
    
}
