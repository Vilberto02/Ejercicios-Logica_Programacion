/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import java.util.Scanner;

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
        /*ArbolBinario arbol = new ArbolBinario();
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
        System.out.println("Elementos: "+arbol.numeroElementos());*/
        Scanner entrada = new Scanner(System.in);
        int opc;
        int elemento;
        String nombre;
        System.out.println("Estructura de datos - Pila con memoria dinamica");
        ArbolBinario arbol = new ArbolBinario();
        System.out.println("Pilas\n"+
                            "0. Salir\n"+
                            "1. Insertar nodo\n"+
                            "2. Buscar nodo\n"+
                            "3. Eliminar nodo\n"+
                            "4. Obtener altura del arbol\n"+
                            "5. Obtener raiz\n"+
                            "6. Obtener el numero de elementos del arbol\n"+
                            "7. Recorrer arbol por inorden\n"+
                            "8. Recorrer arbol por preorden\n"+
                            "9. Recorrer arbol por postorden\n");
        do {            
            System.out.print("\nIngrese una opcion: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Ingresa el valor: ");
                    elemento = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Ingresa el nombre: ");
                    nombre = entrada.nextLine();
                    arbol.insertarNodo(elemento, nombre);
                    break;
                case 2:
                    System.out.print("Ingresa el valor del nodo a buscar: ");
                    elemento = entrada.nextInt();
                    if(arbol.buscarNodo(elemento) == null){
                        System.out.println("Elemento no encontrado");
                    }else{
                        System.out.println("Nodo buscado: "+arbol.buscarNodo(elemento)+"\n");
                    }
                    break;
                case 3:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.print("Ingresa el valor del nodo a eliminar: ");
                        elemento = entrada.nextInt();
                        arbol.eliminar(elemento);
                        System.out.println("Recorrido del arbol en forma de inOrden");
                        arbol.entreOrden(arbol.raiz);
                        System.out.println("\nRecorrido del arbol en forma de preOrden");
                        arbol.preOrden(arbol.raiz);
                        System.out.println("\nRecorrido del arbol en forma de postOrden");
                        arbol.postOrden(arbol.raiz);
                    }
                    break;
                case 4:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Altura del arbol: "+arbol.obtenerAltura());
                    }
                    break;
                case 5:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Raiz del arbol: "+arbol.obtenerRaiz());
                    }
                    break;
                case 6:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Numero de elementos del arbol: "+arbol.numeroElementos());
                    }
                    break;
                case 7:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Recorrido del arbol en forma de inOrden");
                        arbol.entreOrden(arbol.raiz);
                    }
                    break;
                case 8:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Recorrido del arbol en forma de preOrden");
                        arbol.preOrden(arbol.raiz);
                    }
                    break;
                case 9:
                    if(arbol.estaVacio()){
                        System.out.println("El arbol esta vacio");
                    }else{
                        System.out.println("Recorrido del arbol en forma de postOrden");
                        arbol.postOrden(arbol.raiz);
                    }
                    break;
            }
        } while (opc != 0);
    }
    
}
