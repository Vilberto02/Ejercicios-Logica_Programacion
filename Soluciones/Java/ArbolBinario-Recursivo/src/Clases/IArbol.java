/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public interface IArbol {
    public void insertarNodo(Integer elemento, String nombre);
    public boolean eliminar(Integer d);
    public boolean estaVacio();
    public Integer obtenerRaiz();
    public int obtenerAltura();
    public int numeroElementos();
    public void postOrden(NodoArbol r);
    public void preOrden(NodoArbol r);
    public void entreOrden(NodoArbol r);
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp);
}
