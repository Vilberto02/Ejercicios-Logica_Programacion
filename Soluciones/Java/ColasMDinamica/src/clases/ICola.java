/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public interface ICola {
    public void insertar(int elemento);
    public Integer eliminar();
    public boolean colaVacia();
    public Integer frente();
    public int tamanio();
    public void vaciarCola();
    public void mostrarCola();
    public Integer primerElementoCola();
    public Integer ultimoElementoCola();
}
