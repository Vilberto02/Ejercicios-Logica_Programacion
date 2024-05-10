package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanf_
 */
public class Empleado {

    public double getComision() {
        setComision();
        return comision;
    }

    public void setComision() {
        comision = ventas/20;
    }

    public double getSeguro() {
        setSeguro();
        return seguro;
    }

    public void setSeguro() {
        if(estadoCivil == 's'){
            seguro = 100.0;
        }else{
            if(hijos > 0){
                seguro = 50 + 70*hijos;
            }else{
                seguro = 120.0;
            }
        }
    }

    public double getDescImp() {
        setDescImp();
        return descImp;
    }

    public void setDescImp() {
        double TA = sueldoBase + comision;
        if(comision >= 0&&comision <= 1500){
            descImp = 0*TA;
        }else if(comision > 1500&&comision <= 2300){
            descImp = 3*TA/100;
        }else if(comision > 2300&&comision <= 3000){
            descImp = 4*TA/100;
        }else{
            descImp = 6*TA/100;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto() {
        sueldoNeto = sueldoBase + getComision() - getDescImp() -getSeguro();
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public Empleado getAnterior() {
        return anterior;
    }

    public void setAnterior(Empleado siguiente) {
        this.anterior = siguiente;
    }
    private String nombre,apellidoP,apellidoM;
    private double sueldoBase,sueldoNeto,comision,seguro,descImp;
    private char estadoCivil;
    private int ventas,hijos;
    private Empleado anterior;

    public Empleado(String nombre, String apellidoP, String apellidoM,
           double sueldoBase, char estadoCivil, int ventas, int hijos, Empleado anterior){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.sueldoBase = sueldoBase;
        this.estadoCivil = estadoCivil;
        this.ventas = ventas;
        this.hijos = hijos;
        this.anterior = anterior;
        setSueldoNeto();
    }
    
    @Override
    public String toString(){
        String info = "";
        info += "Nombre                 : "+nombre+"\n";
        info += "Apellido paterno       : "+apellidoP+"\n";
        info += "Apellido materno       : "+apellidoM+"\n";
        info += "Estado civil           : "+estadoCivil+"\n";
        info += "Numero de hijos        : "+hijos+"\n";
        info += "Ventas realizadas      : "+ventas+"\n";
        info += "Sueldo base            : "+sueldoBase+"\n";
        info += "Comision por ventas    : "+comision +"\n";
        info += "Descuento por impuesto : "+descImp+"\n";
        info += "Descuento por Seguro   : "+seguro+"\n";
        info += "Sueldo neto            : "+sueldoNeto+"\n";
        return info;
    }
    
}
