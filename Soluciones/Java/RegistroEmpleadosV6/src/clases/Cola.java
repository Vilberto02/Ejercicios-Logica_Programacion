package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author sanf_
 */
public interface Cola<T> {
    public void agregarNodo(T nodo);
    public void eliminarCabeza();
    public T obtenerCabeza();
    public int longitudCola();
    public boolean esColaVacia();
}
