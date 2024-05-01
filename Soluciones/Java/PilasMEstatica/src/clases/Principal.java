/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

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
        int tamanio, opc, elemento;
        System.out.println("Estructura de datos - Pila con memoria estatica");
        System.out.print("Inserte el tamanio de la pila: ");
        tamanio = entrada.nextInt();
        Pila pila = new Pila(tamanio);
        System.out.println("Pilas\n"+
                            "0. Salir\n"+
                            "1. Verificar si la pila esta vacia\n"+
                            "2. Verificar si la pila esta llena\n"+
                            "3. Insertar elementos\n"+
                            "4. Eliminar elementos\n"+
                            "5. Mostrar elementos\n"+
                            "6. Vaciar pila\n"+
                            "7. Mostrar ultimo elemento\n"+
                            "8. Mostrar Primer elemento\n");
        do {            
            System.out.print("\nIngrese una opcion: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("La pila no esta vacia");
                    }
                    break;
                case 2:
                    if(pila.estaLlena()){
                        System.out.println("La pila esta llena");
                    }else{
                        System.out.println("La pila no esta llena");
                    }
                    break;
                case 3:
                    if(pila.estaLlena()){
                        System.out.println("La pila esta llena");
                    }else{
                        System.out.print("Ingrese un elemento: ");
                        elemento = entrada.nextInt();
                        pila.apilar(elemento);
                    }
                    break;
                case 4:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Elemento eliminado: "+pila.desapilar());
                    }
                    break;
                case 5:
                    pila.mostrarPila();
                    break;
                case 6:
                    pila.vaciarPila();
                    break;
                case 7:
                    pila.ultimoPila();
                    break;
                case 8:
                    pila.primerElemento();
                    break;
            }
        } while (opc != 0);
    }
    
}
