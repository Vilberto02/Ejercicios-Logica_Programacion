/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Pila implements PilaME{
    int vectorPila[];
    int cima;
    
    public Pila(int tamanio){
        vectorPila = new int[tamanio];
        cima = -1;
    }

    @Override
    public Integer tamanio() {
        return vectorPila.length;
    }

    @Override
    public void apilar(int dato) {
        cima++;
        vectorPila[cima] = dato;
    }

    @Override
    public int desapilar() {
        int fuera = vectorPila[cima];
        cima--;
        return fuera;
    }

    @Override
    public int cima() {
        return vectorPila[cima];
    }

    @Override
    public boolean estaVacia() {
        return cima  == -1;
    }
    
    @Override
    public boolean estaLlena(){
        return vectorPila.length-1 == cima;
    }
    
}
