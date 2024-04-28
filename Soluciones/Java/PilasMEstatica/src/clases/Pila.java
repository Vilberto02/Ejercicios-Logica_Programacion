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
    final int MAX;
    int vectorPila[];
    int cima;
    
    public Pila(int tamanio){
        this.MAX = tamanio-1;
        this.vectorPila = new int[tamanio];
        this.cima = -1;
    }

    @Override
    public Integer tamanio() {
        return vectorPila.length;
    }

    @Override
    public void apilar(int dato) {
        if(cima == MAX){
            System.out.println("La pila esta llena. No se puede insertar elementos.");
        }else{
            cima++;
            vectorPila[cima] = dato;
        }
    }

    @Override
    public int desapilar() {
        if(cima == -1){
            System.out.println("Pila vacia. No hay elementos");
            return 0;
        }else{
            int fuera = vectorPila[cima];
            cima--;
            return fuera;
        }
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
        return MAX == cima;
    }
    
    @Override
    public void vaciarPila(){
        cima = -1;
    }
    
    @Override
    public void mostrarPila(){
        if(!estaVacia()){
            String cadena = "";
            for (int i=0; i<=cima; i++){
                cadena = cadena + "\n"+vectorPila[i];
            }
            System.out.println("Datos de la pila:\n"+cadena);
        }else{
            System.out.println("Pila vacia. No hay elementos");
        }
    }
    
    @Override
    public int ultimoPila(){
        if(!estaVacia()){
            System.out.println("Ultimo elemento: "+vectorPila[cima]);
            return vectorPila[cima];
        }else{
            System.out.println("Pila vacia");
            return 0;
        }
    }
    
}
