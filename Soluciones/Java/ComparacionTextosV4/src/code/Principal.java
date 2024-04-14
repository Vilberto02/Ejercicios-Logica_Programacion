
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner console = new Scanner(System.in);
        darIntro();
        Scanner in1 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV4\\src\\texto\\test1.txt"));
        Scanner in2 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV4\\src\\texto\\test2.txt"));
        Set<String> set1 = getPalabras(in1);
        Set<String> set2 = getPalabras(in2);
        Set<String> comun  = getCoincidencias(set1, set2);
        
        reportarResultados(set1,set2,comun);
    }
    
    //post: lee palabras del Scanner, las convierte en minúsculas y devuelve un Set o conjunto de palabras únicas
    public static Set<String> getPalabras(Scanner input){
        //Ignora todos los caracteres excepto los alfabéticos y apóstrofes haciendo uso de expresiones regulares.
        input.useDelimiter("[^a-zA-Z']+");
        //Lee todas las palabras y se almacena las palabras en un conjunto o Set, un conjunto no permite elementos duplicados.
        Set<String> palabras = new HashSet<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            palabras.add(next);
        }
        
        //Se elimina el siguiente bloque de codigo porque los Sets o conjuntos no permiten elementos duplicados y estos se eliminan automaticamente.
        /*
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
        */
        return palabras;
    }
    
    //pre: set1 y set2 no tienen palabras duplicadas, es decir, contienen palabras unicas.
    //post: construye y devuelve un Set que contiene las palabras en común entre set1 y set2
    public static Set<String> getCoincidencias(Set<String> set1, Set<String> set2){
        Set<String> coincidencia = new HashSet<>();
        for (String elemento: set1){ //Se itera en cada uno de los elementos del conjunto set1
            if(set2.contains(elemento)){ //Se verifica si el elemento del conjunto set1 se encuentra en el conjunto set2 a través del metodo contains.
                coincidencia.add(elemento); //Se agrega el elemento en comun en el conjunto coincidencia.
            }
        }
        
        //Se elimina el siguiente bloque de codigo porque los Set o conjuntos son mas eficientes en busqueda a comparacion de un ArrayList.
        /*
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
        */
        
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
    public static void reportarResultados(Set<String> set1, Set<String> set2, Set<String> comun){
        System.out.println("Archivo #1 palabras: "+set1.size());
        System.out.println("Archivo #2 palabras: "+set2.size());
        System.out.println("-> Palabras en comun: "+comun.size());
        
        double porcentaje1 = 100.0*comun.size()/set1.size();
        double porcentaje2 = 100.0*comun.size()/set2.size();
        
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
