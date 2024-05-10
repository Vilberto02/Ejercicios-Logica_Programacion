/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface IListaSimple<T> {
    public void agregarAlInicio(T elemento);
    public void agregarAlFinal(T elemento);
    public void insertarEn(int indice, T elemento);
    public boolean estaVacia();
    public boolean contiene(T elemento);
    public int Tamanio();
    public int obtenerIndice(T elemento);
    public T obtenerAlPrimero();
    public T obtenerElUltimo();
    public T obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(T elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
    public void eliminarLista();
}
