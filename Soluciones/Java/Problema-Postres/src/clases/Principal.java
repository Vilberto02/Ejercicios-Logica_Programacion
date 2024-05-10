/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Postre miPostre = new Postre("dummy" ,new String[]{"ing3","ing2","ing1"});
        Postre miPostre2 = new Postre("a" ,new String[]{"ing5","ing6","ing8"});
        Postre miPostre3 = new Postre("aaa" ,new String[]{"ing7","ing0","ing11"});
        ColeccionPostres lista = new ColeccionPostres();
        lista.anadirPostre(miPostre);
        lista.anadirPostre(miPostre2);
        lista.anadirPostre(miPostre3);
        System.out.println(lista.imprimirListaPostre("asdasdas"));
        lista.anadirListaPostre("ing4", "dummy2");
        lista.anadirListaPostre("ing4", "a");
        System.out.println(lista.imprimirListaPostre("a"));
        lista.eliminarListaPostre("ing6", "a");
        System.out.println(lista.imprimirListaPostre("a"));
        lista.eliminarPostre(miPostre);
        System.out.println(lista.imprimirListaPostre("a"));
    }
    
}
