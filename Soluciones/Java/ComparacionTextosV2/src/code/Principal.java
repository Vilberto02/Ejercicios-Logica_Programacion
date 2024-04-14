
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in1 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV2\\src\\texto\\test1.txt"));
        Scanner in2 = new Scanner(new File("C:\\Users\\Usuario\\Desktop\\Vilberto02 (Git)\\Ejercicios-Logica_Programacion\\Soluciones\\Java\\ComparacionTextosV2\\src\\texto\\test2.txt"));
        ArrayList<String> lista1 = getPalabras(in1);
        ArrayList<String> lista2 = getPalabras(in2);
        ArrayList<String> comun  = getCoincidencias(lista1, lista2);
        System.out.println("Lista 01: "+lista1);
        System.out.println("Lista 02: "+lista2);
        System.out.println("Coincidencias: "+comun);
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
    
    public static ArrayList<String> getCoincidencias(ArrayList<String> lista1, ArrayList<String> lista2){
        ArrayList<String> coincidencia = new ArrayList<String>();
        int il1 = 0, il2 = 0;
        while(il1<lista1.size() && il2 < lista2.size()){
            int num = lista1.get(il1).compareTo(lista2.get(il2));
            if(num == 0){
                coincidencia.add(lista1.get(il1));
                il1++;
                il2++;
            } else if(num < 0){
                il1++;
            } else{
                il2++;
            }
        }
        return coincidencia;
    }
}
