
package clases;

/**
 *
 * @author Usuario
 */
public class ListaCircularEnlazada implements ListaCE{
    NodoLC ultimo;
    public ListaCircularEnlazada(){
        ultimo = null;
    }

    @Override
    public boolean estaVacia() {
        return ultimo == null;
    }
    
    //Son el mismo codigo debido a que una lista circular enlazada no tiene inicio ni fin
    @Override
    public void agregarAlInicio(int elemento) {
        NodoLC nuevoNodo = new NodoLC(elemento);
        if(!estaVacia()){
            nuevoNodo.sucesor = ultimo.sucesor;
            ultimo.sucesor = nuevoNodo;
        }else{
            ultimo = nuevoNodo;
        }
    }

    //Son el mismo codigo debido a que una lista circular enlazada no tiene inicio ni fin
    @Override
    public void agregarAlFinal(int elemento) {
        NodoLC nuevoNodo = new NodoLC(elemento);
        if(!estaVacia()){
            nuevoNodo.sucesor = ultimo.sucesor;
            ultimo.sucesor = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            ultimo = nuevoNodo;
        }
    }

    @Override
    public void eliminarDelInicio() {
        if(!estaVacia()){
            NodoLC nuevoNodo = ultimo.sucesor;
            ultimo.sucesor = nuevoNodo.sucesor;
        }else{
            ultimo = null;
        }
    }
    
    @Override
    public void eliminarDelFinal() {
        if(!estaVacia()){
            NodoLC nuevoNodo = ultimo.sucesor;
            while(nuevoNodo != ultimo){
                nuevoNodo = nuevoNodo.sucesor;
            }
            nuevoNodo.sucesor = ultimo.sucesor;
            ultimo = nuevoNodo;
        }else{
            ultimo = null;
        }
    }

    @Override
    public void insertarEn(int indice, int elemento) {
        NodoLC nuevoNodo = new NodoLC(elemento);
        int i = 1;
        if (indice == 0){
            nuevoNodo.sucesor = ultimo.sucesor;
            ultimo.sucesor = nuevoNodo;
        }else{
            NodoLC anterior = ultimo.sucesor;
            NodoLC temporal = anterior.sucesor;
            while(temporal != ultimo && i < indice){
                anterior = anterior.sucesor;
                temporal = temporal.sucesor;
                i++;
            }
            if(temporal == ultimo){ //Cuando se quiere insertar al final o no se encuentra el indice.
                nuevoNodo.sucesor = ultimo.sucesor;
                ultimo.sucesor = nuevoNodo;
                ultimo = nuevoNodo;
            }
            anterior.sucesor = nuevoNodo;
            nuevoNodo.sucesor = temporal;
        }
    }

    @Override
    public boolean contiene(int elemento) {
        if(!estaVacia()){
            if(elemento == ultimo.dato){
                return true;
            }else if(ultimo.sucesor.dato == elemento){
                return true;
            }else{
                NodoLC temporal = ultimo.sucesor.sucesor;
                while(temporal != ultimo){
                    if(temporal.dato == elemento){
                        return true;
                    }
                }
                return false;
            }
        }else{
            return false;
        }
    }
    
    // COMPROBAR
    @Override
    public int Tamanio() {
        int indice = 0;
        NodoLC temporal = ultimo.sucesor;
        while(temporal != ultimo){
            temporal = temporal.sucesor;
            indice++;
        }
        if(indice == 0){
            return indice;
        }
        return indice + 1; //Dado que no va a tener en cuenta al ultimo nodo, le sumamos 1 para simular el ultimo nodo.
    }
    
    // COMPROBAR
    @Override
    public int obtenerIndice(int elemento) {
        int indice = 0;
        if(!estaVacia()){
            NodoLC temporal = ultimo.sucesor;
            while(temporal != ultimo){
                if (elemento == temporal.dato){
                    return indice;
                }
                temporal = temporal.sucesor;
                indice++;
            }
            if(temporal == ultimo && temporal.dato == elemento){
                return indice+1; //Simulamos
            }else{
                return 0; //VERIFICAR
            }
        }else{
            return indice;
        }
    }

    @Override
    public Integer obtenerAlPrimero() {
        if(!estaVacia()){
            return ultimo.sucesor.dato;
        }else{
            return null;
        }
    }

    @Override
    public Integer obtenerElUltimo() {
        if(!estaVacia()){
            return ultimo.dato;
        }else{
            return null;
        }
    }

    @Override
    public Integer obtenerElemento(int indice) {
        int i=0;
        if(!estaVacia()){
            NodoLC temporal = ultimo.sucesor;
            while(temporal != ultimo){
                if (indice == i){
                    return temporal.dato;
                }
                temporal = temporal.sucesor;
                indice++;
            }
            if(temporal == ultimo){
                return ultimo.dato; 
            }else{
                return null; //VERIFICAR
            }
        }else{
            return null;
        }
    }

    @Override
    public String convertirCadena() {
        String cadena = "";
        NodoLC temporal = ultimo.sucesor;
        while(temporal != ultimo){
            cadena = cadena + "-->["+temporal.dato+"]";
            temporal = temporal.sucesor;
        }
        if (temporal == ultimo){
            cadena = cadena + "-->["+ultimo.dato+"]";
        }
        return cadena;
    }

    @Override
    public void eliminarElPrimero() {
        if(!estaVacia()){
            NodoLC temporal = ultimo.sucesor;
            if(temporal == ultimo){
                ultimo = null;
            }else{
                ultimo.sucesor = temporal.sucesor;
                temporal.sucesor = null;
            }
        }else{
            ultimo = null;
        }
    }

    @Override
    public void eliminarElUltimo() {
        if(!estaVacia()){
            NodoLC temporal = ultimo.sucesor;
            NodoLC anterior = ultimo;
            if(temporal == ultimo){
                ultimo = null;
            }else{
                while(temporal != ultimo){
                    anterior = anterior.sucesor;
                    temporal = temporal.sucesor;
                }
                anterior.sucesor = ultimo.sucesor;
                temporal.sucesor = null;
                ultimo = anterior;
            }
        }else{
            ultimo = null;
        }
    }

    @Override
    public void eliminarElemento(int elemento) {
        if(!estaVacia()){
            NodoLC temporal = ultimo.sucesor;
            NodoLC anterior = ultimo;
            while(temporal != ultimo && temporal.dato != elemento){
                anterior = anterior.sucesor;
                temporal = temporal.sucesor;
            }
            if(temporal == ultimo){
                eliminarElUltimo();
            }else{
                anterior.sucesor = temporal.sucesor;
                temporal.sucesor = null;
            }
        }else{
            ultimo = null;
        }
    }

    @Override
    public void eliminarConIndice(int indice) {
        if(indice == 0){
            eliminarElPrimero();
        }else{
            Integer elemento = obtenerElemento(indice);
            if (elemento != null){
                eliminarElemento(elemento);
            }
        }
        
    }

    @Override
    public void mostrarLista() {
        System.out.println(convertirCadena());
    }
}
