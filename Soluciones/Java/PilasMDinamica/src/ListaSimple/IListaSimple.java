/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Usuario
 */
public interface IListaSimple {
    public void agregarAlInicio(int elemento);
    public void agregarAlFinal(int elemento);
    public void insertarEn(int indice, int elemento);
    public boolean estaVacia();
    public boolean contiene(int elemento);
    public int Tamanio();
    public int obtenerIndice(int elemento);
    public Integer obtenerAlPrimero();
    public Integer obtenerElUltimo();
    public Integer obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(int elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
}
