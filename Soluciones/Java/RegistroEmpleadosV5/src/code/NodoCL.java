
package code;


public class NodoCL {
    public String codigo;
    public String nombre;
    public String apellidos;
    public String sexo;
    public float sueldo;
    public NodoCL sig;
    
     public NodoCL(String cod, String nom, String ape, String sex, float suel){
        codigo = cod;
        nombre = nom;
        apellidos = ape;
        sexo = sex;
        sueldo = suel;
        sig=null;
    }
}
