
package code;

import com.formdev.flatlaf.FlatLightLaf;
import views.GestorEmpleado;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        FlatLightLaf.setup();
        GestorEmpleado gestor = new GestorEmpleado();
        gestor.setVisible(true);
    }
    
}
