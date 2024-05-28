/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public interface IArbolBinario {
    public void insertarNodo(Integer elemento, String nombre);
    public void borrarNodo();
    public boolean estaVacio();
    public Integer obtenerRaiz();
    public int obtenerAltura();
    public int numeroElementos();
    public void postOrden(NodoArbol r);
    public void preOrden(NodoArbol r);
    public void inOrden(NodoArbol r);
}
