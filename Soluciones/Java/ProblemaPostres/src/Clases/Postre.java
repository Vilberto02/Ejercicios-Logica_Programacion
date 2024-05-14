/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Postre {
    
    private LinkedList<String> ingredientes; 
    private String nombre;
    
    public Postre(String nombre){
       this.nombre = nombre;
       ingredientes = new LinkedList<>();
    }
   
    public Postre(String nombre, String ingrediente){
        this.nombre = nombre;
        ingredientes = new LinkedList<>();
        this.agregarIngredientes(ingrediente);
    }
   
    public Postre(String nombre, String[] ingredientes){
        this.nombre = nombre;
        this.ingredientes = new LinkedList<>();
        this.agregarIngredientes(ingredientes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
   public void agregarIngredientes(String ingrediente){
       ingredientes.add(ingrediente.toLowerCase());
   }
   
   public void agregarIngredientes(String[] ingredientes){
       for(String ingrediente: ingredientes){
           this.ingredientes.add(ingrediente.toLowerCase());
       }
   }
   
   public void eliminarIngredientes(String ingrediente){
       ingredientes.remove(ingrediente.toLowerCase());
   }
   
    public void eliminarIngredientes(String[] ingredientes){
       for(String ingrediente: ingredientes){
           this.ingredientes.remove(ingrediente.toLowerCase());
       }
   }
   
   public String obtenerIngredientes(){
       String lista = "Ingredientes: \n";
       
       for(Iterator i = ingredientes.iterator(); i.hasNext();){
           lista += i.next() + "\t";
       }
       lista += '\n';
       return lista;
   }
   
}
