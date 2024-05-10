package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sanf_
 */
import java.util.*;

public class Principal {

 
    public static void main(String[] args) {
       
        Registro registro = new Registro();
        boolean fin = false;
        System.out.println("Bienvenido");
        Scanner sc = new Scanner(System.in);
        int opt;
        boolean act = false;
        while(!fin){
            if(!act){
                try{
                    System.out.println("----------------");
                    System.out.println("1.- Agregar nuevo empleado");
                    System.out.println("2.- Buscar empleado");
                    System.out.println("3.- Mostrar informacion registro");
                    System.out.println("4.- Salir");
                    opt = Integer.parseInt(sc.nextLine());
                    switch(opt){
                        case 1:
                            registro.crearNuevoEmpleado();
                        break;
                        case 2:
                            String nombre,apP,apM;
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el apellido paterno: ");
                            apP = sc.nextLine();
                            System.out.print("Ingrese el apellido materno: ");
                            apM = sc.nextLine();
                            Empleado emp = registro.encontrarEmpleado(nombre, apP, apM);
                            if(emp != null){
                                act = true;
                            }
                        break;
                        case 3:
                            registro.imprimirInformacion();
                        break;
                        case 4:
                            fin = true;
                            System.out.println("Saliendo...");
                        break;
                        case 5:
                            System.out.println(registro.obtenerCabeza().toString());
                        break;
                    }
                }catch(NumberFormatException e){
                    System.out.println("Ingrese correctamente los datos");
                }
            }else{
                try{
                    System.out.println("----------------");
                    System.out.println("1.- Agregar nuevo empleado");
                    System.out.println("2.- Buscar empleado");
                    System.out.println("3.- Mostrar informacion registro");
                    System.out.println("4.- Actualizar datos");
                    System.out.println("5.- Mostrar informacion empleado");
                    System.out.println("6.- Eliminar empleado");
                    System.out.println("7.- Salir");
                    opt = Integer.parseInt(sc.nextLine());
                    switch(opt){
                        case 1:
                            registro.crearNuevoEmpleado();
                            act = false;
                        break;
                        case 2:
                            String nombre,apP,apM;
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el apellido paterno: ");
                            apP = sc.nextLine();
                            System.out.print("Ingrese el apellido materno: ");
                            apM = sc.nextLine();
                            Empleado emp = registro.encontrarEmpleado(nombre, apP, apM);
                            if(emp != null){
                                act = true;
                            }
                        break;
                        case 3:
                            registro.imprimirInformacion();
                        break;
                        case 4:
                            registro.actualizarEmpleado();
                        break;
                        case 5:
                            String nombre5,apP5,apM5;
                            System.out.print("Ingrese el nombre: ");
                            nombre5 = sc.nextLine();
                            System.out.print("Ingrese el apellido paterno: ");
                            apP5 = sc.nextLine();
                            System.out.print("Ingrese el apellido materno: ");
                            apM5 = sc.nextLine();
                            Empleado emp5 = registro.encontrarEmpleado(nombre5, apP5, apM5);
                            System.out.println(emp5.toString());
                        break;
                        case 6:
                            registro.eliminarCabeza();
                            act = false;
                        break;
                        case 7:
                            fin = true;
                            System.out.println("Saliendo...");
                        break;
                    }
                }catch(NumberFormatException e){
                    System.out.println("Ingrese correctamente los datos");
                }
            }
        }
    }
    
}
