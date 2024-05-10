/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import ListaSimple.ListaSimple;
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
        Scanner entrada = new Scanner(System.in);
        int opc, elemento;
        System.out.println("Estructura de datos - Cola con memoria dinamica");
        Cola<Integer> cola = new Cola<>();
        System.out.println("Pilas\n"+
                            "0. Salir\n"+
                            "1. Verificar si la cola esta vacia\n"+
                            "2. Insertar elemento (push)\n"+
                            "3. Eliminar elemento (pop)\n"+
                            "4. Vaciar cola\n"+
                            "5. Mostrar ultimo elemento\n"+
                            "6. Mostrar elementos\n"+
                            "7. Tamanio de la cola");
        do {            
            System.out.print("\nIngrese una opcion: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("La cola no esta vacia");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese un elemento: ");
                    elemento = entrada.nextInt();
                    cola.insertar(elemento);
                    break;
                case 3:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("Elemento eliminado: "+cola.eliminar());
                    }
                    break;
                case 4:
                    cola.vaciarCola();
                    break;
                case 5:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("Ultimo elemento: "+cola.ultimoElementoCola());
                    }
                    break;
                case 6:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("Elementos de la cola");
                        cola.mostrarCola();
                    }
                    break;
                case 7:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("Tamanio de la cola: "+cola.tamanio());
                    }
                    break;
            }
        } while (opc != 0);
    }
    
}
