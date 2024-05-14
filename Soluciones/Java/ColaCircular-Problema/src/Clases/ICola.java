/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public interface ICola {
    public void insertar(String elemento);
    public String quitar();
    public boolean estaVacia();
    public boolean estaLlena();
    public int tamanio();
    public String frente();
    public void mostrarElementos();
}
