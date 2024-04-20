
package clases;

public interface ListaDE {
    public boolean estaVacia();
    public void agregarAlInicio(int elemento);
    public void agregarAlFinal(int elemento);
    public void eliminarDelInicio();
    public void eliminarDelFinal();
    public void mostrarListaInicioFin();
    public void mostrarListaFinInicio();
    public void insertarEn(int indice,int elemento);
    public boolean contiene(int elemento);
    public int Tamanio();
    public int obtenerIndice(int elemento);
    public Integer obtenerAlPrimero();
    public Integer obtenerElUltimo();
    public Integer obtenerElemento(int indice);
    public String convertirCadena();
    public void eliminarElPrimero();
    public void eliminarElUltimo();
    public void eliminarElemento(int elemento);
    public void eliminarConIndice(int indice);
    public void mostrarLista();
}
