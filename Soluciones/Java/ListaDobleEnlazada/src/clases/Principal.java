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
        int opc, elemento, indice;
        System.out.println("Estructura de datos - Pila con memoria dinamica");
        ListaDobleEnlazada<Integer> listaDE = new ListaDobleEnlazada();
        System.out.println("Lista doblemente enlazada - Metodos\n"+
                            "0. Salir\n"+
                            "1. Verificar si la pila esta vacia\n"+
                            "2. Agregar al inicio\n"+
                            "3. Agregar al final\n"+
                            "4. Mostrar lista inicio-fin (top)\n"+
                            "5. Mostrar lista fin-inicio\n"+
                            "6. Eliminar del inicio\n"+
                            "7. Eliminar del final\n"+
                            "8. Insertar elemento en\n"+
                            "9. La lista contiene al elemento?\n"+
                            "10. Tamanio de la lista\n"+
                            "11. Obtener indice\n"+
                            "12. Obtener al primer elemento\n"+
                            "13. Obtener al ultimo elemento\n"+
                            "14. Obtener un elemento\n"+
                            "15. Eliminar al primer elemento\n"+
                            "16. Eliminar al ultimo elemento\n"+
                            "17. Eliminar un elemento\n"+
                            "18. Eliminar un elemento con un indice\n"+
                            "19. Mostrar elementos\n");
        do {            
            System.out.print("\nIngrese una opcion: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        System.out.println("La lista no esta vacia");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese un elemento: ");
                    elemento = entrada.nextInt();
                    listaDE.agregarAlInicio(elemento);
                    break;
                case 3:
                    System.out.print("Ingrese un elemento: ");
                    elemento = entrada.nextInt();
                    listaDE.agregarAlFinal(elemento);
                    break;
                case 4:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.mostrarListaInicioFin();
                    }
                    break;
                case 5:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.mostrarListaFinInicio();
                    }
                    break;
                case 6:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.eliminarDelInicio();
                    }
                    break;
                case 7:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.eliminarDelFinal();
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el indice del elemento: ");
                    indice = entrada.nextInt();
                    System.out.print("Ingrese el elemento: ");
                    elemento = entrada.nextInt();
                    listaDE.insertarEn(indice, elemento);
                    break;
                case 9:
                    System.out.print("Ingrese el elemento a buscar: ");
                    elemento = entrada.nextInt();
                    if(listaDE.contiene(elemento)){
                        System.out.println("Elemento esta en la lista");
                    }else{
                        System.out.println("El elemento no se encuentra en la lista");
                    }
                    break;
                case 10:
                    System.out.println("Tamanio de la lista: "+listaDE.tamanio());
                    break;
                case 11:
                    System.out.print("Ingrese el elemento para encontrar su indice: ");
                    elemento = entrada.nextInt();
                    if(listaDE.obtenerIndice(elemento) == -1){
                        System.out.println("El elemento no se encuentra en la lista");
                    }else{
                        System.out.println("Indice del elemento "+elemento+": "+listaDE.obtenerIndice(elemento));
                    }
                    break;
                case 12:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        System.out.println("Primer elemento: "+listaDE.obtenerAlPrimero());
                    }
                    break;
                case 13:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        System.out.println("Ultimo elemento: "+listaDE.obtenerElUltimo());
                    }
                    break;
                case 14:
                    System.out.print("Ingrese el indice del elemento: ");
                    indice = entrada.nextInt();
                    System.out.println("Elemento: "+listaDE.obtenerElemento(indice));
                    break;
                case 15:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.eliminarDelInicio();
                    }
                    break;
                case 16:
                    if(listaDE.estaVacia()){
                        System.out.println("La lista esta vacia");
                    }else{
                        listaDE.eliminarDelFinal();
                    }
                    break;
                case 17:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    elemento = entrada.nextInt();
                    if (listaDE.estaVacia()) {
                        System.out.println("La lista esta vacia");
                    }else{
                        if(listaDE.contiene(elemento)){
                            listaDE.eliminarElemento(elemento);
                        }else{
                            System.out.println("El elemento no se encuentra en la lista");
                        }
                    }
                    break;
                case 18:
                    System.out.print("Ingrese el indice del elemento a eliminar: ");
                    indice = entrada.nextInt();
                    listaDE.eliminarConIndice(indice);
                    break;
                case 19:
                    if (listaDE.estaVacia()) {
                        System.out.println("La lista esta vacia");
                    } else {
                        listaDE.mostrarLista();
                    }
                    break;
            }
        } while (opc != 0);
    }
    
}
