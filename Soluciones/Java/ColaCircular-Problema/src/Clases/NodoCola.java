/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class NodoCola {
    String dato;
    NodoCola siguiente;
    
    public NodoCola(String elemento){
        this.dato = elemento;
        siguiente = null;
    }
}
