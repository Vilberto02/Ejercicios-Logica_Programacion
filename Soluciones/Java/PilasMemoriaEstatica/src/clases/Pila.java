/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Pila {
    int vectorPila[];
    int cima;
    
    public Pila(int tamanio){
        vectorPila = new int[tamanio];
        cima  = -1; //Para determinar si la pila esta vacia
    }
    
    //Metodo PUSH: Empuja los elementos en la pila
    public void push(int dato){
        cima++;
        vectorPila[cima] = dato;
    }
    
    //Metodo POP: Extraer un elemento de la pila
    public int pop(){
        int fuera = vectorPila[cima];
        cima--;
        return fuera;
    }
    
    //Metodo para saber si la pila esta vacia
    public boolean estaVacia(){
        return cima == -1;
    }
    
    //Metodo para saber si la pila esta llena
    public boolean estaLlena(){
        return vectorPila.length-1 == cima;
    }
    
    //Metodo para saber que elemento se encuentra en la cima
    public int cimaPila(){
        return vectorPila[cima];
    }
    
    //Metodo para saber el tamanio de la pila
}
