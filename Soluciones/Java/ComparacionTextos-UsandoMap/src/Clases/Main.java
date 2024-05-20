
package Clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner console = new Scanner(System.in);
        darIntro();
        //Ruta del archivo
        Scanner in1 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02-(Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextos-UsandoMap\\src\\texto\\test1.txt"));
        Scanner in2 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02-(Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextos-UsandoMap\\src\\texto\\test2.txt"));
        Map<String, Integer> map1 = getPalabras(in1);
        Map<String, Integer> map2 = getPalabras(in2);
        Map<String, Integer> comun  = getCoincidencias(map1, map2);
        
        reportarResultados(map1,map2,comun);
    }
    
    //post: lee palabras del Scanner, las convierte en minúsculas y devuelve un Map de palabras únicas
    public static Map<String, Integer> getPalabras(Scanner input){
        //Ignora todos los caracteres excepto los alfabéticos y apóstrofes haciendo uso de expresiones regulares.
        input.useDelimiter("[^a-zA-Z']+");
        //Lee todas las palabras y se almacena las palabras en un conjunto o Set, un conjunto no permite elementos duplicados.
        Map<String, Integer> palabras = new HashMap<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            palabras.put(next, palabras.getOrDefault(next, 0) + 1);
        }
        return palabras;
    }
    
    //pre: set1 y set2 no tienen palabras duplicadas, es decir, contienen palabras unicas.
    //post: construye y devuelve un Set que contiene las palabras en común entre set1 y set2
    public static Map<String, Integer> getCoincidencias(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> coincidencia = new HashMap<>();
        for (String elemento: map1.keySet()){ //Se itera en cada uno de los elementos del conjunto set1
            if(map2.containsKey(elemento)){ //Se verifica si el elemento del conjunto set1 se encuentra en el conjunto set2 a través del metodo contains.
                coincidencia.put(elemento, Math.min(map1.get(elemento), map2.get(elemento))); //Se agrega el elemento en comun en el conjunto coincidencia.
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
    
    //pre: comun contiene las coincidencias entre set1 y set2
    //post: informa estadísticas sobre los Set o conjuntos y sus coincidencias
    public static void reportarResultados(Map<String, Integer> map1, Map<String, Integer> map2, Map<String, Integer> comun){
        System.out.println("Archivo #1 palabras: "+map1.size());
        System.out.println("Archivo #2 palabras: "+map2.size());
        System.out.println("-> Palabras en comun: "+comun.size());
        
        double porcentaje1 = 100.0*comun.size()/map1.size();
        double porcentaje2 = 100.0*comun.size()/map2.size();
        
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
