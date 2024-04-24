/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public interface NumComplejo {
    public float getReal();
    public float getImg();
    public void setReal(float x);
    public void setImag(float x);
    public NumComplejo suma(NumComplejo obj);
    public NumComplejo resta(NumComplejo obj);
    public NumComplejo multiplicacion(NumComplejo obj);
    public float modulo();
    public boolean esIgual(NumComplejo obj);
}
