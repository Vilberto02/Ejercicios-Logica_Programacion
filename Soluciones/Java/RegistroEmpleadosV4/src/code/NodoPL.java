
package code;


public class NodoPL {
    public String codigo;
    public String nombre;
    public String apellidos;
    public String sexo;
    public float sueldo;
    public NodoPL sig;
    
     public NodoPL(String cod, String nom, String ape, String sex, float suel){
        codigo = cod;
        nombre = nom;
        apellidos = ape;
        sexo = sex;
        sueldo = suel;
        sig=null;
    }
}
