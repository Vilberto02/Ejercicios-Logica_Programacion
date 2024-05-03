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
        int tamanio, opc;
        String elemento;
        System.out.println("Estructura de datos - Cola con memoria estatica");
        System.out.print("Inserte el tamanio de la cola: ");
        tamanio = entrada.nextInt();
        ColaFrenteMovible cola = new ColaFrenteMovible(tamanio);
        System.out.println("Colas\n"+
                            "0. Salir\n"+
                            "1. Verificar si la cola esta vacia\n"+
                            "2. Verificar si la cola esta llena\n"+
                            "3. Insertar elementos\n"+
                            "4. Eliminar elementos\n"+
                            "5. Mostrar elementos\n"+
                            "6. Vaciar cola\n"+
                            "7. Mostrar el frente de la cola\n"+
                            "8. Mostrar Primer elemento\n");
        do {            
            System.out.print("\nIngrese una opcion: ");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("La cola no esta vacia");
                    }
                    break;
                case 2:
                    if(cola.colaLlena()){
                        System.out.println("La cola esta llena");
                    }else{
                        System.out.println("La cola no esta llena");
                    }
                    break;
                case 3:
                    if(cola.colaLlena()){
                        System.out.println("La cola esta llena");
                    }else{
                        System.out.print("Ingrese un elemento: ");
                        elemento = entrada.nextLine();
                        cola.insertar(elemento);
                    }
                    break;
                case 4:
                    if(cola.colaVacia()){
                        System.out.println("La cola esta vacia");
                    }else{
                        System.out.println("Elemento eliminado: "+cola.eliminar());
                    }
                    break;
                case 5:
                    cola.mostrarCola();
                    break;
                case 6:
                    cola.vaciarCola();
                    break;
                case 7:
                    if(cola.colaVacia()){
                        System.out.println("Cola vacia");
                    }else{
                        System.out.println("Frente de la cola: "+cola.frente());
                    }
                    break;
                case 8:
                    if(cola.colaVacia()){
                        System.out.println("Cola vacia");
                    }else{
                        System.out.println("Primer elemento de la cola: "+cola.primerElementoCola());
                    }
                    break;
            }
        } while (opc != 0);
    }
    
}
