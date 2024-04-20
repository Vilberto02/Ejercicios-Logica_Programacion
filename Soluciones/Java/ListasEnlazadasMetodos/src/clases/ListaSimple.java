
package clases;

/**
 *
 * @author Usuario
 */
public interface ListaSimple {
    public void agregarAlInicio(String elemento);
    public void agregarAlFinal(String elemento);
    public void insertarEn(int indice, String elemento);
    public boolean estaVacia();
    public boolean contiene(String elemento);
    public int Tamanio();
    public int obtenerIndice(String elemento);
    public String obtenerAlPrimero();
    public String obtenerElUltimo();
    public String obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(String elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
}
