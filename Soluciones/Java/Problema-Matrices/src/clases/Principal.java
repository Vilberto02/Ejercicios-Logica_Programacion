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
        Matriz a = new Matriz(5,5);
         System.out.println("Matriz nula inicializada");
        a.show();
        
        a.startMatrix();
        
        System.out.println("1era Matriz");
        a.show();
        
        System.out.println("Matriz Transpuesta");
        a.traspuesta();
        a.show();
        
        
        Matriz b = new Matriz(5,5);
        b.startMatrix();
        
        System.out.println("2da Matriz");
        b.show();
        
        
        Matriz c = a.plus(b);
        
        if(c != null){
            System.out.println("Matriz Suma");
            c.show();
            
        }
        
        
        
        c = Matriz.identidad(7);
        c.show();
                
         System.out.println(a.equal(b));
    }
    
}
