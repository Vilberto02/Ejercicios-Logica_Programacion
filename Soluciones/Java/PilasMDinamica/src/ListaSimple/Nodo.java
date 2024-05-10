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
public class Nodo<T> {
    T dato;
    Nodo siguiente;
    
    //Constructor para agregar al final
    public Nodo(T elemento){
        this.dato = elemento;
        this.siguiente = null;
    }
    
    //Constructor para agregar al inicio
    public Nodo(T elemento, Nodo siguiente){
        this.dato = elemento;
        this.siguiente = siguiente;
    }
}
