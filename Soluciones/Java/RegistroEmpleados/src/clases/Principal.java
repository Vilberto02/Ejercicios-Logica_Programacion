
package clases;

import com.formdev.flatlaf.FlatLightLaf;
import interfaz.listas_simples;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        FlatLightLaf.setup();
        listas_simples login = new listas_simples();
        login.setVisible(true);
    }
    
}
