
package clases;

public class Nodo {
    int dato;
    Nodo ap_siguiente;
    
    public Nodo(int d){
        this.dato = d;
        ap_siguiente = null;
    }
    
    public Nodo(int d, Nodo s){
        dato = d;
        ap_siguiente = s;
    }
}
