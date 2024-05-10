/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface ICola<T> {
    public void insertar(T elemento);
    public T eliminar();
    public boolean colaVacia();
    public T frente();
    public int tamanio();
    public void vaciarCola();
    public void mostrarCola();
    public T primerElementoCola();
    public T ultimoElementoCola();
}
