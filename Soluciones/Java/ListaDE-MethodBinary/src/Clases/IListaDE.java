/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public interface IListaDE {
    /*--- Métodos de la lista doblemente enlazada ---*/
    public boolean estaVacia();
    public void agregarAlInicio(Integer elemento);
    public void agregarAlFinal(Integer elemento);
    public void mostrarListaInicioFin();
    public void mostrarListaFinInicio();
    public void insertarEn(int indice,Integer elemento);
    public boolean contiene(Integer elemento);
    public int tamanio();
    public int obtenerIndice(Integer elemento);
    public Integer obtenerAlPrimero();
    public Integer obtenerElUltimo();
    public Integer obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(Integer elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
    /*--- Nuevo método: isBinary() ---*/
    public boolean isBinary();
}
