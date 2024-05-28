/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    Integer dato;
    String nombre;
    NodoArbol hijoizquierdo;
    NodoArbol hijoderecho;
    
    public NodoArbol(Integer elemento, String nom){
        this.nombre = nom;
        this.dato = elemento;
        this.hijoizquierdo = null;
        this.hijoderecho = null;
    }
    
    @Override
    public String toString(){
        return nombre + " su dato es "+dato;
    }
}
