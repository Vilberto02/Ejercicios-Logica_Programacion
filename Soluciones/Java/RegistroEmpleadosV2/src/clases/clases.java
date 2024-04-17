/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.text.DecimalFormat;

/**
 *
 * @author Usuario
 */
public class clases {
    
    /*public void VerDatos(int ind){
        //Variable para recorrer la lista
        String cod, nom, ape, se, su;
        float s;
        switch (ind) {
            case 1: //Recorrido hacia delante
                {
                    vaciar_tabla();
                    Nodo aux=ini;
                    num = 0;
                    while(aux!=null){
                        cod = aux.codigo;
                        nom = aux.nombre;
                        ape = aux.apellidos;
                        se = aux.sexo;
                        //Dando formato al sueldo
                        DecimalFormat df2 = new DecimalFormat("####.00");
                        su = df2.format(aux.sueldo);
                        num++;
                        Object[] fila = {num, cod, nom, ape, se, su};
                        miModelo.addRow(fila);
                        aux=aux.sig;
                    }
                }
                break;
            case 2: //Recorrido hacia atras
                {
                    vaciar_tabla();
                    Nodo aux=fin;
                    num = 0;
                    while(aux!=null){
                        cod = aux.codigo;
                        nom = aux.nombre;
                        ape = aux.apellidos;
                        se = aux.sexo;
                        //Dando formato al sueldo
                        DecimalFormat df2 = new DecimalFormat("####.00");
                        su = df2.format(aux.sueldo);
                        num++;
                        Object[] fila = {num, cod, nom, ape, se, su};
                        miModelo.addRow(fila);
                        aux=aux.ant;
                    }
                }
                break;
        }
    }
    
    Nodo Buscar (Nodo inicio, String cod){
        Nodo pos = inicio;
        //Recorriendo la lista para encontrar la informacion
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo)){
            pos = pos.sig;
        }
        return pos;
    }
    
    Nodo InsertarFinal(Nodo inicio, String cod, String nom, String ape, String sex, float suel){
        Nodo nuevo = new Nodo(cod, nom, ape, sex, suel);
        //Realizando los enlaces correspondientes
        nuevo.sig = inicio;
        if(inicio == null){
            fin=nuevo;
            fin.sig=null;
        }
        if(inicio!=null){
            inicio.ant = nuevo;
        }
        inicio = nuevo;
        return inicio;
    }
    
    void Adelante_atras(){
        VerDatos(1);
    }
    
    void Atras_adelante(){
        VerDatos(2);
    }
    */
    
}
