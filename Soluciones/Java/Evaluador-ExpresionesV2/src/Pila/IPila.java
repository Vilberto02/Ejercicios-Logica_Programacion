/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Pila;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface IPila<T> {
    public Integer tamanio();
    public void apilar(T dato);
    public T desapilar();
    public T cima();
    public boolean estaVacia();
    public T primerElemento();
    public void mostrarElementos();
}
