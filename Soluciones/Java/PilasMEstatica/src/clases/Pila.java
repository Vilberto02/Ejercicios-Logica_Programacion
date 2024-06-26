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
    
    //METODO INSERTAR (PUSH)
    @Override
    public void apilar(int dato) {
        if(cima == MAX){
            System.out.println("La pila esta llena. No se puede insertar elementos.");
        }else{
            cima++;
            vectorPila[cima] = dato;
        }
    }
    
    //METODO ELIMINAR (POP)
    @Override
    public int desapilar() {
        if(cima == -1){
            System.out.println("La pila está vacia. No hay elementos");
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
        if(cima == -1){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean estaLlena(){
        if(cima == MAX){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void vaciarPila(){
        cima = -1;
    }
    
    @Override
    public void mostrarPila(){
        if(estaVacia()){
            System.out.println("Pila vacia. No hay elementos");
        }else{
            String cadena = "";
            for (int i=0; i<=cima; i++){
                cadena = cadena + "\n"+vectorPila[i];
            }
            System.out.println("Datos de la pila:"+cadena);
        }
    }
    
    @Override
    public int ultimoPila(){
        if(estaVacia()){
            System.out.println("Pila vacia");
            return 0;
        }else{
            System.out.println("Ultimo elemento: "+vectorPila[cima]);
            return vectorPila[cima];
        }
    }
    
    @Override
    public int primerElemento(){
       if(estaVacia()){
            System.out.println("Pila vacia");
            return 0;
        }else{
            System.out.println("Primer elemento: "+vectorPila[0]);
            return vectorPila[cima];
        } 
    }
    
}
