/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package code;

import com.formdev.flatlaf.FlatLightLaf;
import views.RegistroEmpleadosV4;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlatLightLaf.setup();
        RegistroEmpleadosV4 login = new RegistroEmpleadosV4();
        login.setVisible(true);
    }
    
}
