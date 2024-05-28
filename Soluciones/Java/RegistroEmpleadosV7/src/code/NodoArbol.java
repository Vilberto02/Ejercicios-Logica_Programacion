
package code;


public class NodoArbol {
    public int codigo;
    public String nombre;
    public String apellidos;
    public String sexo;
    public float sueldo;
    public NodoArbol hijoIzquierdo;
    public NodoArbol hijoDerecho;
    
     public NodoArbol(int cod, String nom, String ape, String sex, float suel){
        codigo = cod;
        nombre = nom;
        apellidos = ape;
        sexo = sex;
        sueldo = suel;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
}
