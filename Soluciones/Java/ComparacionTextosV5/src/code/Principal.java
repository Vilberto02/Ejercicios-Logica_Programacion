/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package code;

import com.formdev.flatlaf.FlatLightLaf;
import views.CompararTextos;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        CompararTextos frmComparar = new CompararTextos();
        frmComparar.setVisible(true);
    }
    
}
