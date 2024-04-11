
package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Comparacion {
    private Scanner in1;
    private Scanner in2;
    
    public Comparacion() {
        try {
            in1 = new Scanner(new File("test1.txt"));
            in2 = new Scanner(new File("test2.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado");
            // Puedes manejar la excepción de otra manera, como lanzándola a un nivel superior o registrándola en un archivo de registro.
        }
    }
    
    // Método para comparar los archivos, procesar líneas, etc.
    
    public void closeScanners() {
        if (in1 != null) {
            in1.close();
        }
        if (in2 != null) {
            in2.close();
        }
    }
}
