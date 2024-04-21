//Este programa lee un archivo de datos y cuenta los votos de los candidatos.
package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ConteoVoto {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        Scanner entrada = new Scanner(new File("vote.txt"));
        ArrayList<Votacion> votaciones = leerArchivo(entrada);
        int ronda = 1;
        boolean hecho = false;
        while(!hecho){
            System.out.println("Ronda #1"+ ronda);
            Collections.sort(votaciones);
            hecho = unaRonda(votaciones);
            System.out.println("------------------------------");
            ronda++;
        }
        
    }
    
    //Lee un archivo de datos de las preferencias de los votantes y devuelve una lista de las papeletas resultantes.
    //Se enumeran los nombres de los candidatos por orden de preferencia con pestaña que separan las opciones.
    public static ArrayList<Votacion> leerArchivo(Scanner entrada){
        ArrayList<Votacion> resultado = new ArrayList<>(); //Crea un ArrayList que va contener objetos de la clase Votacion
        while(entrada.hasNext()){ //Recorre el archivo linea por linea
            String texto = entrada.nextLine(); //Lee el proximo token de entrada como una cadena de caracteres hasta que encuentra un salto de linea (\n) o llega al final de la linea actual.
            resultado.add(new Votacion(texto.split("\t"))); //Agrega el objeto a un ArrayList con el nombre de cada candidato separado por una tabulación.
        }
        return resultado;
    }
    
    //Cuenta e informa los votos de cada candidato. Asume que la lista esta ordenada por nombre del candidato.
    public static boolean unaRonda(ArrayList<Votacion> votaciones){
        String superior = "";
        String inferior = "";
        int maximo = 0;
        int minimo = votaciones.size() + 1;
        int indice = 0;
        while(indice < votaciones.size()){
            String siguiente = votaciones.get(indice).getCandidato();
            int contador = procesarVotos(siguiente, indice, votaciones);
            
            if(contador>maximo){
                maximo = contador;
                superior = siguiente;
            }
            if(contador < minimo){
                minimo = contador;
                inferior = siguiente;
            }
            indice += contador;
        }
        if(maximo == minimo){
            System.out.println("La eleccion no tiene ganador(a)");
            return true;
        }else if(maximo > votaciones.size()/2.0){
            System.out.println("El ganador es: "+ superior);
            return true;
        }else{
            System.out.println("No hay ganador, eliminando a " + inferior);
            eliminate(inferior, votaciones);
            return false;
        }
    }
    
    //Cuenta y reporta los votos para el proximo candidato comenzando en el indice dado en la lista de votos.
    public static int procesarVotos(String nombre, int indice, ArrayList<Votacion> votaciones){
        int contador = 0;
        while (indice < votaciones.size() && votaciones.get(indice).getCandidato().equals(nombre)){
            indice++;
            contador++;
        }
        double porcentaje = 100.0 * contador / votaciones.size();
        System.out.printf("%d votos para %s (%4.1f%%)\n",contador, nombre, porcentaje);
        return contador;
    }
    
    public static void eliminate(String nombre, ArrayList<Votacion> votaciones){
        
    }
}
