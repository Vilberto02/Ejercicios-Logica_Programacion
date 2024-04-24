
package clases;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--- LISTA ENLAZADA SIMPLE ---");
        ListaEnlazada lista = new ListaEnlazada();
        Scanner entrada = new Scanner(System.in);
        
        imprimirLista();
        int control;
        do {
            System.out.print("Ingrese una opcion: ");
            control = entrada.nextInt();
            entrada.nextLine();
            
            switch (control) {
                case 0:
                    break;
                case 1:
                    System.out.print("Ingrese un elemento: ");
                    String elementoIn = entrada.nextLine();
                    lista.agregarAlInicio(elementoIn);
                    break;
                case 2:
                    System.out.print("Ingrese un elemento: ");
                    String elementoFin = entrada.nextLine();
                    lista.agregarAlFinal(elementoFin);
                    break;
                case 3:
                    System.out.print("Ingrese un elemento: ");
                    String elementoIns = entrada.nextLine();
                    System.out.print("Ingrese un indice: ");
                    int indice = entrada.nextInt();
                    lista.insertarEn(indice, elementoIns);
                    break;
                case 4:
                    System.out.println("Esta vacia?: "+lista.estaVacia());
                    break;
                case 5:
                    System.out.print("Ingresa un elemento: ");
                    String elementoB = entrada.nextLine();
                    System.out.println("El elemento se encuentra en la lista? "+lista.contiene(elementoB));
                    break;
                case 6:
                    System.out.println("Tamanio de la lista: "+lista.Tamanio());
                    break;
                case 7:
                    System.out.print("Ingrese el elemento para buscar su indice: ");
                    String elementoI = entrada.nextLine();
                    System.out.println("Indice: "+lista.obtenerIndice(elementoI));
                    break;
                case 8:
                    System.out.println("Primer elemento de la lista: "+lista.obtenerAlPrimero());
                    break;
                case 9:
                    System.out.println("Ultimo elemento de la lista: "+lista.obtenerElUltimo());
                    break;
                case 10:
                    System.out.print("Ingrese un indice para encontrar un elemento: ");
                    int index = entrada.nextInt();
                    System.out.println("Elemento en el indice {"+index+"]: "+lista.obtenerElemento(index));
                    break;
                case 11:
                    System.out.println("Elementos de la lista: "+lista.convertirCadena());
                    break;
                case 12:
                    lista.eliminarElPrimero();
                    System.out.println("Elemento inicial eliminado");
                    break;
                case 13:
                    lista.eliminarElUltimo();
                    System.out.println("Elemento final elementado");
                    break;
                case 14:
                    System.out.print("Ingrese un elemento: ");
                    String elementoE = entrada.nextLine();
                    lista.eliminarElemento(elementoE);
                    System.out.println("Elemento eliminado");
                    break;
                case 15:
                    System.out.print("Ingrese un indice para eliminar ese elemento: ");
                    int ind = entrada.nextInt();
                    lista.eliminarConIndice(ind);
                    break;
                case 16:
                    System.out.println("Lista enlazada:");
                    lista.mostrarLista();
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (control != 0);
    }
    
    public static void imprimirLista() {
        System.out.println(
            "0. Salir\n"
            + "1. Agregar elemento al inicio\n"
            + "2. Agregar elemento al final\n"
            + "3. Insertar un elemento en una posicion determinada\n"
            + "4. Verificar si la lista esta vacia\n"
            + "5. El elemento esta en la lista?\n"
            + "6. Tamanio de la lista\n"
            + "7. Obtener indice de un elemento\n"
            + "8. Obtener el primer elemento de la lista\n"
            + "9. Obtener el ultimo elemento de la lista\n"
            + "10. Obtener elemento mediante un indice determinado\n"
            + "11. Convertir en cadena a todos los elementos de la lista\n"
            + "12. Eliminar el primer elemento de la lista\n"
            + "13. Eliminar el ultimo elemento de la lista\n"
            + "14. Eliminar un elemento\n"
            + "15. Eliminar elemento mediante un indice determinado\n"
            + "16. Mostrar los elementos de la lista"
        );
    }
    
}

/*
public void agregarAlInicio(String elemento);
public void agregarAlFinal(String elemento);
public void insertarEn(int indice, String elemento);
public boolean estaVacia();
public boolean contiene(String elemento);
public int Tamanio();
public int obtenerIndice(String elemento);
public String obtenerAlPrimero();
public String obtenerElUltimo();
public String obtenerElemento(int indice);
public String convertirCadena();
public void eliminarElPrimero();
public void eliminarElUltimo();
public void eliminarElemento(String elemento);
public void eliminarConIndice(int indice);
public void mostrarLista();
*/