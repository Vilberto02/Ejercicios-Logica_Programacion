
package clases;

public class Nodo {
    String dato;
    Nodo ap_siguiente;
    
    //Para agregar un nodo al final de la lista
    public Nodo(String d){
        this.dato = d;
        this.ap_siguiente = null;
    }
    
    //Para agregar un nodo al inicio de la lista
    public Nodo(String d, Nodo s){
        this.dato = d;
        this.ap_siguiente = s;
    }
}
