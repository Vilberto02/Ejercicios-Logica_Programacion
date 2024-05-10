/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class ColeccionPostres {
    private ArrayList<LinkedList<Postre>> postres;

    public ColeccionPostres(){
        postres = new ArrayList<LinkedList<Postre>>();
        for(char i = 'a'; i <= 'z'; i++){
            postres.add(new LinkedList<Postre>());
        }
    }

    public void anadirPostre(Postre postre){
        String nombre = postre.getNombre();
        (this.postres.get((nombre.charAt(0)) - 'a')).add(postre);
    }

    public void anadirPostre(Postre[] postre){
        String nombre;
         for(int i = 0;i<postre.length;i++){
             nombre = postre[i].getNombre();
             (this.postres.get((nombre.charAt(0)) - 'a')).add(postre[i]);
         }
    }

    public void eliminarPostre(Postre postre){
        String nombre = postre.getNombre();
        (this.postres.get((nombre.charAt(0)) - 'a')).remove(postre);
    }

    public void eliminarPostre(Postre[] postre){
         String nombre;
         for(int i = 0;i<postre.length;i++){
             nombre = postre[i].getNombre();
             (this.postres.get((nombre.charAt(0)) - 'a')).remove(postre[i]);
         }
    }

    public Postre obtenerPostre(String nombre){
        LinkedList<Postre> listaPostres = this.postres.get((nombre.charAt(0)) - 'a');
        for(Iterator i = listaPostres.iterator();i.hasNext();){
            Postre postre = (Postre) i.next();
            if(postre.getNombre().equals(nombre)){
                return postre;
            }
        }
        System.out.println("Nombre de postre no registrado");
        return null;
    }

    public String imprimirListaPostre(String nombre){
        Postre postre = obtenerPostre(nombre);
        if(postre != null){
            return postre.obtenerIngredientes();
        }else{
            return "";
        }
    }

    public void anadirListaPostre(String ing, String nombre){
        Postre postre = obtenerPostre(nombre);
        if(postre != null){
            postre.anadirIngredientes(ing);
            System.out.println("Ingrediente anadido");
        }
    }

    public void anadirListaPostre(String[] ing, String nombre){
        Postre postre = obtenerPostre(nombre);
        if(postre != null){
            postre.anadirIngredientes(ing);
            System.out.println("Ingredientes anadido");
        }
    }

    public void eliminarListaPostre(String ing, String nombre){
        Postre postre = obtenerPostre(nombre);
        if(postre != null){
            postre.eliminarIngredientes(ing);
            System.out.println("Ingredientes eliminado");
        }
    }

    public void eliminarListaPostre(String[] ing, String nombre){
        Postre postre = obtenerPostre(nombre);
        if(postre != null){
            postre.eliminarIngredientes(ing);
            System.out.println("Ingredientes eliminado");
        }
    }   
       
}
