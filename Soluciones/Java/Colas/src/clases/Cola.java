/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Cola implements ICola{
    
    //FIFO: Se insertan elementos por el final (posterior) y se eliminan elementos por el inicio (frente o anterior).
    /*
    TIPOS DE COLA
    Cola simple: Los elementos salen en el mismo orden en el que llegan.
    Cola de prioridades: Los elementos se insertan en cualquier posicion de la cola y se remueven solamente por el frente.
    Cola Doble: Los elementos se pueden añadir o quitar por cualquier extremo de la cola.
    */
    public Cola(){
        
    }
    
    //Encolar, añadir, entrar, push, enqueue.
    @Override
    public void insertar(String elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Desencolar, eliminar, salir, pop. dequeue.
    @Override
    public String quitar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean colaVacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean colaLlena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    //Consultar, front
    @Override
    public String frente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int tamanio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
