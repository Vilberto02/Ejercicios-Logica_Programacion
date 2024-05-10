
package clases;

public interface ListaDE<T> {
    public boolean estaVacia();
    public void agregarAlInicio(T elemento);
    public void agregarAlFinal(T elemento);
    public void eliminarDelInicio();
    public void eliminarDelFinal();
    public void mostrarListaInicioFin();
    public void mostrarListaFinInicio();
    public void insertarEn(int indice,T elemento);
    public boolean contiene(T elemento);
    public int tamanio();
    public int obtenerIndice(T elemento);
    public T obtenerAlPrimero();
    public T obtenerElUltimo();
    public T obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(T elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
}
