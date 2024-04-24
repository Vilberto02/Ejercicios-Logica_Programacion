/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package code;

import com.formdev.flatlaf.FlatLightLaf;
import views.RegistroEmpleadosV3;

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
        RegistroEmpleadosV3 login = new RegistroEmpleadosV3();
        login.setVisible(true);
    }
    
}
