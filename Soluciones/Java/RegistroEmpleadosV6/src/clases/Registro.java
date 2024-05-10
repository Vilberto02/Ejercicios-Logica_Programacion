package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanf_
 */
import java.util.*;

public class Registro implements Cola<Empleado>{
    
    private Empleado cabeza,atras;
    private int longitud;
    private double montoTotalSueldos;
    private double montoTotalSeguros;
    private double montoTotalComision;
    private double montoTotalDescuentos;
    public Registro(){
        cabeza = null;
        atras = null;
        longitud = 0;
        montoTotalSueldos = 0;
        montoTotalSeguros = 0;
        montoTotalComision = 0;
        montoTotalDescuentos = 0;
    }
    
    public void imprimirInformacion(){
        String info = "";
        info += "montoTotalSueldos: " + montoTotalSueldos +"\n";
        info += "montoTotalSeguros: " + montoTotalSeguros +"\n";
        info += "montoTotalComision: " + montoTotalComision +"\n";
        info += "montoTotalDescuentos: " + montoTotalDescuentos +"\n";
        System.out.print(info);
    }
    
    public Empleado encontrarEmpleado(String nombre, String apellidoP, String apellidoM){
        boolean encontrado = false;
        Empleado empleado = null;
        Empleado empleadoActual = null;
        int busquedas = 0;
        while(busquedas < longitud){
            empleadoActual = obtenerCabeza();
            if(nombre.equals(empleadoActual.getNombre()) 
                    && apellidoP.equals(empleadoActual.getApellidoP())
                        && apellidoM.equals(empleadoActual.getApellidoM())){
                empleado = empleadoActual;
                encontrado = true;
                break;
            }else{
                eliminarCabeza();
                agregarNodo(empleadoActual);
                busquedas++;
            }
        }
        if(encontrado){
            System.out.println("Empleado encontrado");
        }else{
            System.out.println("Empleado no encontrado");
        }
        return empleado;
    }
    
    
    public void crearNuevoEmpleado(){
        boolean creado = false;
        Scanner sc = new Scanner(System.in);
        Empleado nuevoEmpleado;
        String nombre = "",apellidoP="",apellidoM="";
        char estadoCivil='s';
        int ventas=0,hijos=0;
        double sueldoBase=0;
        while(!creado){
            try{
                System.out.println("Ingrese los datos del empleado");
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido paterno: ");
                apellidoP = sc.nextLine();
                System.out.print("Apellido materno: ");
                apellidoM = sc.nextLine();
                System.out.print("Estado civil: ");
                estadoCivil = sc.nextLine().charAt(0);
                System.out.print("Numero de hijos: ");
                hijos = Integer.parseInt(sc.nextLine());
                System.out.print("Ventas: ");
                ventas = Integer.parseInt(sc.nextLine());
                System.out.print("Sueldo base: ");
                sueldoBase = Double.parseDouble(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Ingrese correctamente los datos"); 
            }
            creado = true;
        }
        nuevoEmpleado = new Empleado(nombre,apellidoP,apellidoM,sueldoBase,estadoCivil,ventas,hijos,null);
        System.out.println("Empleado agregado");
        agregarNodo(nuevoEmpleado);
    }
    
    public void actualizarEmpleado(){
        boolean creado = false;
        Scanner sc = new Scanner(System.in);
        Empleado nuevoEmpleado;
        String nombre = "",apellidoP="",apellidoM="";
        char estadoCivil='s';
        int ventas=0,hijos=0;
        double sueldoBase=0;
        while(!creado){
            try{
                System.out.println("Ingrese los datos del empleado");
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido paterno: ");
                apellidoP = sc.nextLine();
                System.out.print("Apellido materno: ");
                apellidoM = sc.nextLine();
                System.out.print("Estado civil: ");
                estadoCivil = sc.nextLine().charAt(0);
                System.out.print("Numero de hijos: ");
                hijos = Integer.parseInt(sc.nextLine());
                System.out.print("Ventas: ");
                ventas = Integer.parseInt(sc.nextLine());
                System.out.print("Sueldo base: ");
                sueldoBase = Double.parseDouble(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Ingrese correctamente los datos"); 
            }
            creado = true;
        }
        nuevoEmpleado = new Empleado(nombre,apellidoP,apellidoM,sueldoBase,estadoCivil,ventas,hijos,cabeza.getAnterior());
        cabeza = nuevoEmpleado;
        System.out.println("Empleado actualizado");
    }
    
    @Override
    public void agregarNodo(Empleado nodo){
        montoTotalSueldos += nodo.getSueldoNeto();
        montoTotalSeguros += nodo.getSeguro();
        montoTotalComision += nodo.getComision();
        montoTotalDescuentos += nodo.getDescImp();
        if(longitud == 0){
            cabeza = nodo;
            atras = nodo;
        }else{
            atras.setAnterior(nodo);
            atras = nodo;
        }
        longitud++;
    }
    
    @Override
    public Empleado obtenerCabeza(){
        return cabeza;
    }
    
    @Override
    public void eliminarCabeza(){
        if(longitud == 1){
            montoTotalSueldos -= cabeza.getSueldoNeto();
            montoTotalSeguros -= cabeza.getSeguro();
            montoTotalComision -= cabeza.getComision();
            montoTotalDescuentos -= cabeza.getDescImp();
            longitud--;
            cabeza = null;
            atras = null;
            System.out.println("Empleado eliminado");
        }else if(longitud == 0){
            System.out.println("Registro vacio");
        }else{
            montoTotalSueldos -= cabeza.getSueldoNeto();
            montoTotalSeguros -= cabeza.getSeguro();
            montoTotalComision -= cabeza.getComision();
            montoTotalDescuentos -= cabeza.getDescImp();
            longitud--;
            cabeza = cabeza.getAnterior();
            System.out.println("Empleado eliminado");
        }
    }
    
    @Override
    public int longitudCola(){
        System.out.println("Cantidad de empleado: "+longitud);
        return longitud;
    }
    
    @Override
    public boolean esColaVacia(){
        if(longitud == 0){
            System.out.println("Registro vacio");
        }else{
            System.out.println("Registro no vacio");
        }
        return longitud == 0;
    }
    
}
