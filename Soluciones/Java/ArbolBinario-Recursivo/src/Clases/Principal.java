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
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertarNodo(4,"A");
        arbol.insertarNodo(3,"B");
        arbol.insertarNodo(7,"C");
        arbol.insertarNodo(6,"D");
        arbol.insertarNodo(9,"E");
        arbol.insertarNodo(8,"F");
        
        System.out.println("Recorrer el arbol en forma de postOrden");
        arbol.postOrden(arbol.raiz);
        
        System.out.println("\nAltura del arbol");
        System.out.println("Altura: "+arbol.obtenerAltura());
        System.out.println("Numero de elementos");
        System.out.println("Elementos: "+arbol.numeroElementos());
    }
    
}
