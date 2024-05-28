/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    Integer dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    
    public NodoArbol(Integer elemento, String nom){
        dato = elemento;
        nombre = nom;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
}
