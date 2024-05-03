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
    public void insertar(String elemento);
    public String eliminar();
    public boolean colaVacia();
    public boolean colaLlena();
    public String frente();
    public int tamanio();
    public void vaciarCola();
    public void mostrarCola();
    public String primerElementoCola();
}
