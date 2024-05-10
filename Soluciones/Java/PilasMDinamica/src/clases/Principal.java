
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
        int opc, elemento;
        System.out.println("Estructura de datos - Pila con memoria dinamica");
        Pila<Integer> pila = new Pila();
        System.out.println("Pilas\n"+
                            "0. Salir\n"+
                            "1. Verificar si la pila esta vacia\n"+
                            "2. Insertar elemento (push)\n"+
                            "3. Eliminar elemento (pop)\n"+
                            "4. Mostrar ultimo elemento (top)\n"+
                            "5. Mostrar primer elemento\n"+
                            "6. Mostrar elementos\n"+
                            "7. Tamanio de la pila");
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
                    System.out.print("Ingrese un elemento: ");
                    elemento = entrada.nextInt();
                    pila.apilar(elemento);
                    break;
                case 3:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Elemento eliminado: "+pila.desapilar());
                    }
                    break;
                case 4:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Ultimo elemento: "+pila.cima());
                    }
                    break;
                case 5:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Primer elemento: "+pila.primerElemento());
                    }
                    break;
                case 6:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Elementos de la pila");
                        pila.mostrarElementos();
                    }
                    break;
                case 7:
                    if(pila.estaVacia()){
                        System.out.println("La pila esta vacia");
                    }else{
                        System.out.println("Tamanio de la pila: "+pila.tamanio());
                    }
                    break;
            }
        } while (opc != 0);
    }
    
}


