
package clases;


public class Nodo {
    public String codigo;
    public String nombre;
    public String apellidos;
    public String sexo;
    public float sueldo;
    public Nodo sig;
    public Nodo ant;
    public Nodo(String cod, String nom, String ape, String sex, float suel){
        codigo = cod;
        nombre = nom;
        apellidos = ape;
        sexo = sex;
        sueldo = suel;
        sig = ant = null;
    }
}
