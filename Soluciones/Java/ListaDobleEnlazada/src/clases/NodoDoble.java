/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class NodoDoble {
    public int dato;
    NodoDoble sucesor, predecesor;
    
    public NodoDoble(int elemento){
        this(elemento,null,null);
    }
    
    public NodoDoble(int elemento, NodoDoble siguiente, NodoDoble anterior){
        dato=elemento;
        sucesor = siguiente;
        predecesor = anterior;
    }
}
