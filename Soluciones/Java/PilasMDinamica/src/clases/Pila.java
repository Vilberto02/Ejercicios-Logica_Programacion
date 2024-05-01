/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import ListaSimple.ListaSimple;

/**
 *
 * @author Usuario
 */
public class Pila implements PilaMD{
    ListaSimple lista;
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
    public void apilar(int dato) {
        cima++;
        lista.agregarAlFinal(dato);
    }

    @Override
    public int desapilar() {
        int fuera = lista.obtenerElUltimo();
        lista.eliminarElUltimo();
        cima--;
        return fuera;
    }

    @Override
    public int cima() {
        return lista.obtenerElUltimo();
    }

    @Override
    public boolean estaVacia() {
        return cima == -1;
    }
    
    @Override
    public int primerElemento(){
        return lista.obtenerAlPrimero();
    }
    
    @Override
    public void mostrarElementos(){
        System.out.println(lista.convertirCadena());
    }
    
}
