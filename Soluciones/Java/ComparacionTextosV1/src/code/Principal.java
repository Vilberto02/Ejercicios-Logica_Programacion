
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in1 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV1\\src\\texto\\test1.txt"));
        Scanner in2 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV1\\src\\texto\\test2.txt"));
        ArrayList<String> lista1 = getPalabras(in1);
        ArrayList<String> lista2 = getPalabras(in2);
        System.out.println("Lista 01: "+lista1);
        System.out.println("Lista 02: "+lista2);
    
    }
    
    public static ArrayList<String> getPalabras(Scanner input){
        ArrayList<String> palabras = new ArrayList<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            palabras.add(next);
        }
        Collections.sort(palabras);
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
    
}
