/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class ColaFrenteMovible implements ICola{
    
    //FIFO: Se insertan elementos por el final (posterior) y se eliminan elementos por el inicio (frente o anterior).
    /*
    TIPOS DE COLA
    Cola simple: Los elementos salen en el mismo orden en el que llegan.
    Cola de prioridades: Los elementos se insertan en cualquier posicion de la cola y se remueven solamente por el frente.
    Cola Doble: Los elementos se pueden añadir o quitar por cualquier extremo de la cola.
    */
    
    final int MAX;
    int frente;
    int fin;
    String[] vectorCola;
    
    /*--- COLA CON FRENTE MOVIBLE ---*/
    public ColaFrenteMovible(int tamanio){
        this.vectorCola = new String[tamanio];
        this.MAX = tamanio-1;
        this.frente = -1;
        this.fin = -1;
    }
    
    //Encolar, añadir, entrar, push, enqueue.
    @Override
    public void insertar(String elemento) {
        if(fin == MAX){
            System.out.println("La cola esta llena");
        }else{
            fin++;
            vectorCola[fin] = elemento;
            if(frente == -1){
                frente++;
            }
        }
    }
    
    //Desencolar, eliminar, salir, pop. dequeue.
    @Override
    public String eliminar() {
        if(frente == -1){
            System.out.println("Cola vacia");
            return "";
        }else{
            String fuera = vectorCola[frente];
            if(frente == fin){
                frente = -1;
                fin = -1;
            } else{
                frente++;
            }
            return fuera;
        }
    }
    
    @Override
    public boolean colaVacia() {
        return frente == -1;
    }

    @Override
    public boolean colaLlena() {
        return fin == MAX;
    }
    
    //Consultar, front
    @Override
    public String frente() {
        if(colaVacia()){
            System.out.println("Cola vacia. No hay elementos");
            return "";
        }else{
            return vectorCola[frente];
        }
    }

    @Override
    public int tamanio() {
        return vectorCola.length;
    }
    
    @Override
    public void vaciarCola(){
        frente = fin = -1;
    }
    
    @Override
    public void mostrarCola(){
        if(colaVacia()){
            System.out.println("Cola vacia. No hay elementos");
        }else{
            String cadena = "";
            for (int i=frente; i<=fin; i++){
                cadena = cadena + "\n"+vectorCola[i];
            }
            System.out.println("Datos de la cola:"+cadena);
        }
    }
    @Override
    public String primerElementoCola(){
        return vectorCola[frente];
    }
}
