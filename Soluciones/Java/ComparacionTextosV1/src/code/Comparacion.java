
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Comparacion {
    private Scanner in1;
    private Scanner in2;
    
    public Comparacion() throws FileNotFoundException{
        in1 = new Scanner(new File("test1.txt"));
        in2 = new Scanner(new File("test2.txt"));
        ArrayList<String> lista1 = getPalabras(in1);
        ArrayList<String> lista2 = getPalabras(in2);
        System.out.println("Lista N°01: "+lista1);
        System.out.println("Lista N°02: "+lista2);
    }
    
    public ArrayList<String> getPalabras(Scanner input){
        ArrayList<String> palabras = new ArrayList<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            palabras.add(next);
        }
        Collections.sort(palabras);
        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add(palabras.get(0));
        for (int i=1; i<palabras.size(); i++){
            if(!palabras.get(i).equals(palabras.get(i-1))){
                lista2.add(palabras.get(i));
            }
        }
        return palabras;
    }
}
