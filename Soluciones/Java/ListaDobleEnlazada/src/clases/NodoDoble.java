/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class NodoDoble<T> {
    public T dato;
    NodoDoble sucesor, predecesor;
    
    public NodoDoble(T elemento){
        this(elemento,null,null);
    }
    
    public NodoDoble(T elemento, NodoDoble siguiente, NodoDoble anterior){
        dato=elemento;
        sucesor = siguiente;
        predecesor = anterior;
    }
}
