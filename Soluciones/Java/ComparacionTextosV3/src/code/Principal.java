/*
Este programa lee dos archivos de texto y compara el 
vocabulario utilizado en cada uno.
*/

package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner console = new Scanner(System.in);
        darIntro();
        Scanner in1 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV3\\src\\texto\\test1.txt"));
        Scanner in2 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV3\\src\\texto\\test2.txt"));
        ArrayList<String> lista1 = getPalabras(in1);
        ArrayList<String> lista2 = getPalabras(in2);
        ArrayList<String> comun  = getCoincidencias(lista1, lista2);
        
        reportarResultados(lista1,lista2,comun);
    }
    
    //post: lee palabras del Scanner, las convierte en minúsculas y devuelve una lista ordenada de palabras únicas
    public static ArrayList<String> getPalabras(Scanner input){
        //Ignora todos los caracteres excepto los alfabéticos y apóstrofes haciendo uso de expresiones regulares.
        input.useDelimiter("[^a-zA-Z']+");
        //Lee todas las palabras y los ordena
        ArrayList<String> palabras = new ArrayList<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            palabras.add(next);
        }
        Collections.sort(palabras);
        //Agrega palabras únicas a la nueva lista y las devuelve.
        ArrayList<String> resultado = new ArrayList<String>();
        if(palabras.size() > 0){
            resultado.add(palabras.get(0));
            for (int i=1; i<palabras.size(); i++){
                if(!palabras.get(i).equals(palabras.get(i-1))){
                    resultado.add(palabras.get(i));
                }
            }
        }
        return resultado;
    }
    
    //pre: lista1 y lista2 están ordenados y no tienen palabras duplicadas.
    //post: construye y devuelve una ArrayList que contiene las palabras en común entre lista1 y lista2
    public static ArrayList<String> getCoincidencias(ArrayList<String> lista1, ArrayList<String> lista2){
        ArrayList<String> coincidencia = new ArrayList<String>();
        int il1 = 0, il2 = 0;
        while(il1<lista1.size() && il2 < lista2.size()){
            int num = lista1.get(il1).compareTo(lista2.get(il2)); 
            //El metodo compareTo de la interfaz Comparable de la clase String devuelve un entero y compara palabras alfabeticamente.
            if(num == 0){ //Primera condicion: Cuando las palabras de ambas listas son iguales, se agrega la palabra en la lista comun y se incrementa ambas listas
                coincidencia.add(lista1.get(il1));
                il1++;
                il2++;
            } else if(num < 0){ //Segunda condicion: Cuando la palabra de la lista1 es menor que la palabra de la lista2, se omite e incrementa la lista1.
                il1++;
            } else{ //Tercera condicion: Cuando la palabra de la lista1 es mayor que la palabra de la lista2, se omite e incrementa la lista2.
                il2++;
            }
        }
        return coincidencia;
    }
    
    //post: explica el programa al usuario.
    public static void darIntro(){
        System.out.println("--- Comparacion de textos y busqueda de coincidencias ---");
        System.out.println("Este programa compara dos archivos de texto e informa el numero de palabras en comun y el porcentaje de coincidencias");
        System.out.println();
    }
    
    //pre: comun contiene las coincidencias entre lista1 y lista2
    //post: informa estadísticas sobre las listas y sus coincidencias
    public static void reportarResultados(ArrayList<String> lista1, ArrayList<String> lista2, ArrayList<String> comun){
        System.out.println("Archivo #1 palabras: "+lista1.size());
        System.out.println("Archivo #2 palabras: "+lista2.size());
        System.out.println("-> Palabras en comun: "+comun.size());
        
        double porcentaje1 = 100.0*comun.size()/lista1.size();
        double porcentaje2 = 100.0*comun.size()/lista2.size();
        
        //Usamos DecimalFormat para definir el patrón adecuado de cifras decimales de los porcentaje.
        DecimalFormat df = new DecimalFormat("#.###");
        
        //Formateamos los porcentajes usando DecimalFormat
        String porcentaje1Formateado = df.format(porcentaje1);
        String porcentaje2Formateado = df.format(porcentaje2);
        
        System.out.println("-> Porcentaje (%) del archivo 1 en superposicion = "+porcentaje1);
        System.out.println("-> Porcentaje (%) del archivo 2 en superposicion = "+porcentaje2+" %");
        System.out.println("-> Porcentaje (%) del archivo 1 aproximado: "+porcentaje1Formateado+" %");
        System.out.println("-> Porcentaje (%) del archivo 2 aproximado: "+porcentaje2Formateado+" %");
    }
}
