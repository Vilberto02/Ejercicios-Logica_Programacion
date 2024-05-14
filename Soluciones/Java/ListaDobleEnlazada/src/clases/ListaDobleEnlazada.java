
package clases;

/**
 *
 * @author Usuario
 * @param <T>
 */
public class ListaDobleEnlazada<T> implements ListaDE<T> {
    
    private NodoDoble inicio, fin;
    
    public ListaDobleEnlazada(){
        inicio = fin = null;
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }

    @Override
    public void agregarAlInicio(T elemento) {
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(inicio == null){
            inicio = fin = nuevoNodo;
        }else{
            nuevoNodo.sucesor = inicio;
            inicio.predecesor = nuevoNodo;
            inicio = nuevoNodo;
        }
    }

    @Override
    public void agregarAlFinal(T elemento) {
        if(!estaVacia()){
            NodoDoble nuevoNodo = new NodoDoble(elemento, null, fin);
            fin.sucesor = nuevoNodo;
            fin = nuevoNodo;
        }else{
            fin = inicio = new NodoDoble(elemento, null, null);
        }
    }

    @Override
    public void eliminarDelInicio() {
        if (inicio ==  fin){
            inicio = fin = null;
        }else{
            inicio = inicio.sucesor;
            inicio.predecesor = null;
        }
    }

    @Override
    public void eliminarDelFinal() {
        if(fin == inicio){
            fin = inicio = null;
        } else{
            NodoDoble temporal = inicio; //Recordemos que temporal solo es un puntero que se utiliza para recorrer la lista.
            while(temporal.sucesor != fin){
                temporal = temporal.sucesor;
            }
            fin = temporal;
            fin.sucesor = null;
        }
    }

    @Override
    public void mostrarListaInicioFin() {
        System.out.println(convertirCadena());
    }

    @Override
    public void mostrarListaFinInicio() {
        String lista = "";
        NodoDoble recorrer = fin;
        System.out.println();
        while (recorrer != null) {
            lista = lista + "<---[" + recorrer.dato + "]--->";
            recorrer = recorrer.predecesor;
        }
        System.out.println(lista);
    }

    @Override
    public void insertarEn(int indice, T elemento) {
        if(indice == 0){
            agregarAlInicio(elemento);
        }else{
            int i=1;
            NodoDoble auxiliar, temporal;
            auxiliar = inicio;
            temporal = inicio.sucesor;
            while(temporal != null && i<indice){
                auxiliar = auxiliar.sucesor;
                temporal = temporal.sucesor;
                i++;
            }
            if(temporal != null){
                NodoDoble nuevoNodo = new NodoDoble(elemento);
                nuevoNodo.sucesor = temporal;
                nuevoNodo.predecesor = auxiliar;
                auxiliar.sucesor = nuevoNodo;
                temporal.predecesor = nuevoNodo;
            } else{
                agregarAlFinal(elemento);
            }
        }
    }

    @Override
    public boolean contiene(T elemento) {
        NodoDoble temporal = inicio;
        while(temporal != null){
            if(temporal.dato == elemento){
                return true;
            }
            temporal = temporal.sucesor;
        }
        return false;
    }

    @Override
    public int tamanio() {
        if (!estaVacia()){
            int indice = 0;
            NodoDoble temporal = inicio;
            while(temporal != null){
                temporal = temporal.sucesor;
                indice++;
            }
            return indice;
        } else{
            return 0; //La lista esta vacia
        }
    }

    @Override
    public int obtenerIndice(T elemento) {
        if (!estaVacia()){
            int indice = 0;
            NodoDoble temporal = inicio;
            while(temporal != null && temporal.dato != elemento){
                temporal = temporal.sucesor;
                indice++;
            }                  
            return indice;
        } else{
            return -1; //No se encuentra el indice
        }
    }

    @Override
    public T obtenerAlPrimero() {
        if (inicio != null){
            return (T) inicio.dato;
        }
        return null; //null
    }

    @Override
    public T obtenerElUltimo() {
        if (fin != null){
            return (T) fin.dato;
        }
        return null; //null
    }

    @Override
    public T obtenerElemento(int indice) {
        int i=0;
        if (indice == 0){
            return (T) inicio.dato;
        }else{
            NodoDoble temporal = inicio;
            while(temporal != null && i<indice){
                temporal = temporal.sucesor;
                i++;
            }
            if (temporal != null){
                return (T) temporal.dato;
            }
            return null; //-1
        }
    }

    @Override
    public String convertirCadena() {
        String lista = "";
        NodoDoble recorrer = inicio;
        System.out.println();
        while (recorrer != null) {
            lista = lista + "<---[" + recorrer.dato + "]--->";
            recorrer = recorrer.sucesor;
        }
        return lista;
    }

    @Override
    public void eliminarElPrimero() {
        if (inicio == fin){
            inicio = fin = null;
        }else{
            inicio = inicio.sucesor;
            inicio.predecesor = null;
        }
    }

    @Override
    public void eliminarElUltimo() {
        if (fin == inicio){
            fin = inicio = null;
        }else{
            NodoDoble temporal = inicio;
            while (temporal.sucesor != fin){
                temporal = temporal.sucesor;
            }
            fin = temporal;
            fin.sucesor = null;
        }
    }

    @Override
    public void eliminarElemento(T elemento) {
        if(!estaVacia()){
           if(inicio == fin && elemento == inicio.dato){ //Caso cuando se tiene un solo nodo.
               inicio = fin = null;
           }else if(elemento == inicio.dato){ //Caso cuando el elemento a eliminar es el primer nodo
               inicio = inicio.sucesor;
               inicio.predecesor = null;
           } else{ //Caso cuando el elemento no se encuentra en el primer nodo.
               NodoDoble auxiliar, temporal;
               auxiliar = inicio;
               temporal = inicio.sucesor;
               while(temporal != null && temporal.dato != elemento){
                   auxiliar = auxiliar.sucesor;
                   temporal = temporal.sucesor;
               }
               if(temporal != null){
                   auxiliar.sucesor = temporal.sucesor;
                   if(temporal.sucesor != null){
                       temporal.sucesor.predecesor = auxiliar;
                   }
                   if (temporal == fin){ //Caso si el elemento a eliminar es el ultimo nodo.
                       fin = auxiliar;
                   }
               }
           }
        }
    }

    @Override
    public void eliminarConIndice(int indice) {
        T elemento = obtenerElemento(indice);
        if (elemento != null){
            eliminarElemento(elemento);
            System.out.println("Elemento eliminado");
        } else{
            System.out.println("El elemento no se encuentra");
        }
    }

    @Override
    public void mostrarLista() {
        System.out.println(convertirCadena());
    }
    
}
