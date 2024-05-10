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
public class Pila<T> implements PilaMD<T>{
    ListaSimple<T> lista;
    int cima;
    
    public Pila(){
        lista = new ListaSimple();
        cima = -1;
    }

    @Override
    public int tamanio() {
        return lista.Tamanio();
    }

    @Override
    public void apilar(T dato) {
        cima++;
        lista.agregarAlFinal(dato);
    }

    @Override
    public T desapilar() {
        T fuera = lista.obtenerElUltimo();
        lista.eliminarElUltimo();
        cima--;
        return fuera;
    }

    @Override
    public T cima() {
        return lista.obtenerElUltimo();
    }

    @Override
    public boolean estaVacia() {
        return cima == -1;
    }
    
    @Override
    public T primerElemento(){
        return lista.obtenerAlPrimero();
    }
    
    @Override
    public void mostrarElementos(){
        System.out.println(lista.convertirCadena());
    }
    
}
