/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola colaC = new Cola(6);
        agregandoElementos("AA", colaC);
        agregandoElementos("BB", colaC);
        agregandoElementos("CC", colaC);
        eliminandoElementos(colaC);
        agregandoElementos("DD", colaC);
        agregandoElementos("EE", colaC);
        agregandoElementos("FF", colaC);
        agregandoElementos("GG", colaC);
        agregandoElementos("HH", colaC);
        eliminandoElementos(colaC);
        eliminandoElementos(colaC);
    }
    
    public static void agregandoElementos(String elemento, Cola cola){
        if(cola.estaLlena()){
            System.out.println("No se pudo agregar el elemento. La cola esta llena.\n");
        }else{
            cola.insertar(elemento);
            System.out.println("Insertando el elemento: "+elemento+"\n");
            cola.mostrarElementos();
            System.out.println();
        }
    }
    
    public static void eliminandoElementos(Cola cola){
        String elemento = cola.quitar();
        System.out.println("Elemento eliminado: "+elemento+"\n");
        cola.mostrarElementos();
        System.out.println();
    }
    
}
