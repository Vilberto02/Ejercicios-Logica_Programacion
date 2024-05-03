/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Usuario
 */
public class Nodo {
    Nodo siguiente;
    int dato;
    
    //Constructor para agregar al final.
    public Nodo(int elemento){
        this.dato = elemento;
        this.siguiente = null;
    }
    
    
    //Constructor para agregar al inicio.
    public Nodo(int elemento, Nodo siguiente){
        this.dato = elemento;
        this.siguiente = siguiente;
    }
}
