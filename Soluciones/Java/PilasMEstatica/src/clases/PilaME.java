/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public interface PilaME {
    public Integer tamanio();
    public void apilar(int dato);
    public int desapilar();
    public int cima();
    public boolean estaVacia();
    public boolean estaLlena();
    public void vaciarPila();
    public void mostrarPila();
    public int ultimoPila();
    public int primerElemento();
}
