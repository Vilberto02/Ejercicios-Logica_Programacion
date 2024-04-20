
package clases;

/**
 *
 * @author Usuario
 */
public class NodoLC {
    int dato;
    NodoLC sucesor;
    
    public NodoLC(int elemento){
        dato = elemento;
        sucesor = this;
    }
}
