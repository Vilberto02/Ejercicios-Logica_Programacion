
package clases;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
//Clase para almacenar las preferencias del votante.
public class Votacion implements Comparable<Votacion>{
    
    
    private ArrayList<String> preferencias;
    
    public Votacion(String[] nombres){
        preferencias = new ArrayList<>();
        for(String siguiente: nombres){
            preferencias.add(siguiente);
        }
    }
    
    //Devuelve la primera opción actual para esta votación
    public String getCandidato(){
        return preferencias.get(0);
        //Se puede mejorar considerando que el votante no registre sus votos.
    }
    
    //Elimina al candidato dado
    public void eliminar(String nombre){
        preferencias.remove(nombre);
    }
    
    //Compara las votaciones alfabeticamente por candidato de la primera elección
    @Override
    public int compareTo(Votacion o) {
        return getCandidato().compareTo(o.getCandidato());
    }
}
