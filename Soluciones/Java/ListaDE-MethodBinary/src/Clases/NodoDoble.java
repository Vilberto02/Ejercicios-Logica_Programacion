/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class NodoDoble {
    public NodoDoble sucesor, predecesor;
    public Integer dato;
    
    /*--- Constructor ---*/
    public NodoDoble(Integer elemento){
        this(elemento, null, null);
    }
    
    /*--- Constructor ---*/
    public NodoDoble(Integer elemento, NodoDoble anterior, NodoDoble siguiente){
        dato = elemento;
        sucesor = siguiente;
        predecesor = anterior;
    }
}
