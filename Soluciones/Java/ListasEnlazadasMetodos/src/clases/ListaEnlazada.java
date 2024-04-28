
package clases;

public class ListaEnlazada implements ListaSimple{
    protected Nodo inicio, fin;
    
    public ListaEnlazada(){
        inicio = null;
        fin = null;
    }
    
    //Ya está
    @Override
    public void agregarAlInicio(String elemento) {
        /*
        Pasos:
        1. Se crea un nuevo nodo (elemento de la lista).
        2. Ese nodo tiene como dato al elemento y apunta al nodo Inicio.
        3. Inicio se actualiza con el nodo creado, es decir, inicio apunta al nuevo nodo creado.
        */
        
        inicio = new Nodo(elemento, inicio); //Ahora inicio apunta al elemento.
        if (fin == null){
            fin = inicio; //Ahora fin apunta a inicio
        }
    }
    
    //Ya está
    @Override
    public void agregarAlFinal(String elemento) {
        /*
        Pasos:
        1. Si la lista no esta vacia, se crea un nuevo nodo con el dato de 'elemento'.
        2. Despues, el 'nuevo nodo' se asigna al nodo 'fin.ap_siguiente'.
        3. Luego, el nodo 'fin' apunta al 'nuevo nodo'.
        4. Si la lista esta vacia, se crea un 'nuevo nodo' con el dato elemento.
        5. Despues, 'inicio' y 'fin' apuntan al 'nuevo nodo'.
        */
        
        if(!estaVacia()){ //estaVacia: True -> !estaVacia: False (No esta vacia)
            fin.ap_siguiente = new Nodo(elemento);
            fin = fin.ap_siguiente;
        }else{
            inicio = fin = new Nodo(elemento); //inicio y fin apuntan al mismo elemento, dado que la lista esta vacia.
        }
    }
    
    
    @Override
    public void insertarEn(int indice, String elemento) {
        if(indice == 0){
            agregarAlInicio(elemento);
        }else{
            int i=1;
            Nodo auxiliar, temporal;
            auxiliar = inicio;
            temporal = inicio.ap_siguiente;
            while(temporal != null && i<indice){
                auxiliar = auxiliar.ap_siguiente;
                temporal = temporal.ap_siguiente;
                i++;
            }
            if(temporal != null){
                Nodo nuevoNodo = new Nodo(elemento);
                nuevoNodo.ap_siguiente = temporal;
                auxiliar.ap_siguiente = nuevoNodo;
            } else{
                agregarAlFinal(elemento);
            }
        }
    }
    
    //Ya está
    @Override
    public boolean estaVacia() {
        /*
        Pasos:
        1. Se verifica si inicio es igual a null
        2. Si inicio es igual a null, eso quiere decir que inicio aun no apunta a nodo, entonces se retorna verdadero, ya que la lista esta vacia.
        3. Si inicio es diferente a null, eso quiere decir que inicio apunta a un nodo, entonces se retorna falso, ya que la lista no esta vacia.
        */
        
        return inicio == null;
    }

    @Override
    public boolean contiene(String elemento) {
        Nodo temporal = inicio;
        while(temporal!=null && !temporal.dato.equals(elemento)){
            temporal=temporal.ap_siguiente;
        }
        return temporal!=null;
    }

    @Override
    public int Tamanio() {
        int indice = 0;
        Nodo auxiliar = inicio;
        while (auxiliar != null){
            auxiliar = auxiliar.ap_siguiente;
            indice++;
        }
        return -1;
    }

    @Override
    public int obtenerIndice(String elemento) {
        int index = 0;
        Nodo auxiliar = inicio;
        while(auxiliar != null){
            if(auxiliar.dato.equals(elemento)){
                return index;
            }
            auxiliar = auxiliar.ap_siguiente;
            index++;
        }
        return index;
    }

    @Override
    public String obtenerAlPrimero() {
        if(inicio != null){
            return inicio.dato;
        }
        return null;
    }

    @Override
    public String obtenerElUltimo() {
        if (fin != null){
            return fin.dato;
        }
        return null;
    }

    @Override
    public String obtenerElemento(int indice) {
        int i = 0;
        Nodo auxiliar = inicio;
        while(auxiliar != null){
            if(i == indice){
                return auxiliar.dato;
            }
            auxiliar = auxiliar.ap_siguiente;
            i++;
        }
        return null;
    }

    @Override
    public String convertirCadena() {
        String lista = "";
        Nodo recorrer = inicio;
        System.out.println();
        while (recorrer != null) {
            lista = lista + "[" + recorrer.dato + "]--->";
            recorrer = recorrer.ap_siguiente;
        }
        return lista;
    }

    @Override
    public void eliminarElPrimero() {
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.ap_siguiente;
        }
    }

    @Override
    public void eliminarElUltimo() {
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            Nodo temporal = inicio;
            while (temporal.ap_siguiente != fin) {
                temporal = temporal.ap_siguiente;
            }
            fin = temporal;
            fin.ap_siguiente = null;
        }
    }
    
    //Ya está
    @Override
    public void eliminarElemento(String elemento) {
        if(!estaVacia()){
            if (inicio == fin && elemento.equals(inicio.dato)){
                inicio = fin = null;
            } else if(elemento.equals(inicio.dato)){
                inicio = inicio.ap_siguiente;
            } else{
                Nodo anterior, temporal;
                anterior = inicio;
                temporal = inicio.ap_siguiente;
                while (temporal != null && !temporal.dato.equals(elemento)){
                    anterior = anterior.ap_siguiente;
                    temporal = temporal.ap_siguiente;
                }
                if (temporal != null){
                    anterior.ap_siguiente = temporal.ap_siguiente;
                    if(temporal == fin){
                        fin = anterior;
                    }
                }
            }
        }
    }

    @Override
    public void eliminarConIndice(int indice) {
        String elemento = obtenerElemento(indice);
        if ( elemento != null){
            eliminarElemento(elemento);
            System.out.println("Elemento eliminado");
        }else{
            System.out.println("El elemento no se encuentra en dicho indice");
        }
    }
    
    @Override
    public void mostrarLista(){
        System.out.println(convertirCadena());
    }
    
}
