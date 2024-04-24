/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class NumerosComplejos implements NumComplejo{
    
    protected float real;
    protected float imaginario;
    
    public NumerosComplejos(float r, float i){
        real = r;
        imaginario = i;
    }

    @Override
    public float getReal() {
        return real;
    }

    @Override
    public float getImg() {
        return imaginario;
    }

    @Override
    public void setReal(float x) {
        real = x;
    }

    @Override
    public void setImag(float x) {
        imaginario = x;
    }

    @Override
    public NumComplejo suma(NumComplejo obj) {
        NumComplejo resultado = new NumerosComplejos(real + obj.getReal(), imaginario + obj.getImg());
        return resultado;
    }

    @Override
    public NumComplejo resta(NumComplejo obj) {
        NumComplejo resultado = new NumerosComplejos(real - obj.getReal(), imaginario - obj.getImg());
        return resultado;
    }

    @Override
    public NumComplejo multiplicacion(NumComplejo obj) {
        NumComplejo resultado = new NumerosComplejos(real * obj.getReal() - imaginario * obj.getImg(), real * obj.getReal() + imaginario * obj.getImg());
        return resultado;
    }

    @Override
    public float modulo() {
        return (float) Math.sqrt(real * real+ imaginario * imaginario);
    }

    @Override
    public boolean esIgual(NumComplejo obj) {
        return (real == obj.getReal() && imaginario == obj.getImg());
    }
    
}
