/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import java.util.Comparator;
import java.util.PriorityQueue;
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
        int tamanio = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Tamanio del arreglo: ");
        tamanio = entrada.nextInt();
        int[] arreglo = new int[tamanio];
        // Agregamos los elementos en el arreglo.
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Elemento: ");
            arreglo[i] = entrada.nextInt();
        }
        
        // Arreglo original
        System.out.println("\nArreglo original");
        imprimirArreglo(arreglo);
        
        // Ordenamos el arreglo usando Heapsort minimo, es decir, ordenamos de menor a mayor
        heapsortMin(arreglo);
        
        // Arreglo ordenado
        System.out.println("\nArreglo ordenado usando Heapsort minimo");
        imprimirArreglo(arreglo);
        
        // Ordenamos el arreglo usando Heapsort maximo, es decir, ordenamos de mayor a menor.
        heapsortMax(arreglo);
        
        // Arreglo ordenado
        System.out.println("\nArreglo ordenado usando Heapsort maximo");
        imprimirArreglo(arreglo);
    }
    
    public static void heapsortMin(int[] arreglo){
        // Se crea una cola prioritaria y dado que no pasamos un comparador, entonces, se crea por defecto una cola prioritaria de menor prioridad
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // Agregando los elementos del arreglo en la cola prioritaria
        for(int i = 0; i<arreglo.length; i++){
            heap.offer(arreglo[i]); // El metodo offter nos permite agregar elementos a la cola prioritaria.
        }
        
        // Actualizar el arreglo extrayendo los elementos ordenados de la cola prioritaria.
        for(int j = 0; j<arreglo.length; j++){
            arreglo[j] = heap.poll(); // El metodo poll nos permite extraer y eliminar el elemento de menor prioridad (Para este caso) de una cola prioritaria.
        }
    }
    
    public static void heapsortMax(int[] arreglo){
        // Creamos una cola prioritaria y usamos la clase Comparator y el metodo revereOrder para invertir el orden.
        // Es decir, se ordenan los elementos en orden decreciente, es decir, una cola prioridad de mayor prioridad.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Agregando los elementos del arreglo en la cola prioritaria
        for(int i = 0; i<arreglo.length; i++){
            heap.offer(arreglo[i]); // El metodo offter nos permite agregar elementos a la cola prioritaria.
        }
        
        // Actualizar el arreglo extrayendo los elementos ordenados de la cola prioritaria.
        for(int j = 0; j<arreglo.length; j++){
            arreglo[j] = heap.poll(); // El metodo poll nos permite extraer y eliminar el elemento de mayor prioridad (Para este caso) de una cola prioritaria.
        }
    }
    
    public static void imprimirArreglo(int[] arreglo){
        // Imprimir el arreglo
        for (int i=0; i<arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}
