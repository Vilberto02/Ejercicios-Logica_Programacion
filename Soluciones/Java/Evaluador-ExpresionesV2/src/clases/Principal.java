/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import Pila.Pila;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    // Para almacenar los operadores y sus valores tanto dentro como fuera de la pila.
    private static Map<String, Integer>operadorFueraPila = new HashMap<>();
    private static Map<String, Integer>operadorDentroPila = new HashMap<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Valor de los operadores fuera de la pila
        operadorFueraPila.put("+", 1);
        operadorFueraPila.put("-", 1);
        operadorFueraPila.put("*", 2);
        operadorFueraPila.put("/", 2);
        operadorFueraPila.put("^", 4);
        operadorFueraPila.put("(", 5);
        
        // Valor de los operadores dentro de la pila
        operadorDentroPila.put("+", 1);
        operadorDentroPila.put("-", 1);
        operadorDentroPila.put("*", 2);
        operadorDentroPila.put("/", 2);
        operadorDentroPila.put("^", 3);
        operadorDentroPila.put("(", 0);
        
        // Solicitamos la expresión al usuario
        Scanner entrada = new Scanner(System.in);
        System.out.println("--- Evaluador de expresiones ---");
        System.out.println("Este programa evalua expresiones prefijas complejas que contenga operadores como +, -, *, ^, / y ()");
        System.out.print("Expresion: ");
        
        // Eliminamos todas las ocurrencias de "//" en el texto que ingrese el usuario.
        String line = (entrada.nextLine()).replaceAll("//", "");
        
        //Recorremos la expresion ingresada por el usuario.
        while (!line.isEmpty()) {
            Pila<String> infija = obtenerInfija(line);
            if (infija != null && validarInfija(infija)) {
                System.out.print("Infija: ");
                imprimirPila(infija);
                infija = invertirPila(infija); // Invierte la infija
                Pila<String> preOrder = obtenerPostfija(infija); // Obtiene la postfija de la infija
                preOrder = invertirPila(preOrder); // Obtiene la prefija inviertiendo la postfija
                System.out.print("Prefija: ");
                imprimirPila(preOrder);
                infija = invertirPila(infija); // Vuelve a invertir la infija
                Pila<String> postOrder = obtenerPostfija(infija); // Obtiene la postfija de la infija original
                System.out.print("Postfija: ");
                imprimirPila(postOrder);
                resolverPostfija(postOrder); // Resuelve la expresion usando la postfija
            } else {
                System.out.println("Expresi1on ilegal"); // Si se tiene una expresion ilegal
            }
            System.out.print("Ingrese la expresion: ");
            line = (entrada.nextLine()).replaceAll("\\s", "");
        }
        
        
    }
    
    
    public static Pila<String> obtenerInfija(String cadena){
        Pila<String> infija = new Pila<>();
        Pila<String> infijaOrdenado = new Pila<>();
        int ascii;
        infija.apilar("(");
        for(int i = 0;i<cadena.length();i++){
            // Convierte el caracter de la cadena (expresion) en la posicion i en código ASCII
            ascii = (int) cadena.charAt(i);
            
            // Verifica que el indice del caracter este entre [40, 57] menos el indice del caracter 44 (,) o que contenga el caracter 94 (^)
            // [40, 57] comprende los operadores (, ), +, -, *, -, ., /, 0, 1,..., 9
            if((ascii >= 40 && ascii <= 57 && ascii != 44) || ascii == 94){
                
                // Verifica que los caracteres no sean numeros, es decir, que sean operadores. Tampoco acepta al punto decimal (.)
                if(!((ascii >= 48 && ascii <= 57) || ascii == 46)){
                    infija.apilar("" + cadena.charAt(i)); // Apila en la pila infija, convirtiendo el numero del caracter (operador) en String.
                }else{                    
                    infija.apilar("");
                    int point = 0;
                    // Verifica que los caracteres sean numeros o contenga punto decimal (.)
                    // Forma una cadena que va estar por formada por el operador y el numero, es decir, una expresion infija.
                    while(i<cadena.length() && (((int) cadena.charAt(i) >= 48 && (int) cadena.charAt(i) <= 57) || (int) cadena.charAt(i) == 46)){
                        String top = infija.desapilar();
                        top = top + cadena.charAt(i); // Concatena el operador con e numero
                        if(cadena.charAt(i) == '.'){
                            point++; // Suma +1 si el caracter es un punto decimal
                        }
                        infija.apilar(top); // Apila la cadena concatenada
                        i++;
                    }
                    
                    // Si la expresion contiene mas de dos puntos decimales, se retorna nulo porque seria una expresion invalida
                    if(point >= 2){
                        return null;
                    }
                    
                    // Si el caracter de la cima es un punto decimal (.), este se saca y se concatena con un 0
                    if(infija.cima().charAt(0) == '.'){
                        String top = infija.desapilar();
                        top = "0" + top;
                        infija.apilar(top);
                    }
                    // Se resta 1 al iterador del for porque fue cambiando en el while
                    i--;       
                }
            }else{
                return null; // Retorna nulo si no es un operador o numero
            }
        }
        infija.apilar(")"); // Apila el parentesis de cierre de la expresion general.
        while(!infija.estaVacia()){
            infijaOrdenado.apilar(infija.desapilar()); // Ordena la infija
        }
        return infijaOrdenado;
    }
    
    public static boolean validarInfija(Pila<String> infija){
        Pila<Integer> analizador = new Pila<>();
        Pila<String> auxiliar = new Pila<>();
        while(!infija.estaVacia()){
            if(infija.cima().charAt(0) == ')'){ // Si la cima de la pila es el parentesis de cierre
                boolean correct = false; // Para indicar si se encontro un par de parentesis correspondientes
                int actual = 2; // Se inicia con un parentesis de cierre 
                while(!analizador.estaVacia()){
                    int curr = analizador.desapilar();
                    if(curr == actual){ // Si se encuentra un parentesis de apertura, es decir, encuentra a su correspondiente
                        actual *= -1; // Se multiplica actual para iniciar con el parentesis de apertura.
                    }else if(curr== 1){ // Significa que se encontro un parentesis de inicio que no tiene un parentesis de cierre
                        analizador.apilar(2); // Se apila 2 para indicar que se ha encontrado un parentesis de cierre que no tiene a su parentesis correspondiente
                        correct = true; 
                        break; // Sale del bucle
                    }else{
                        break; // Se encontro un parentesis diferente al de cierre e inicio y se sale del bucle
                    }
                }
                if((actual == 2) || !correct){ // Verifica si actual presenta el mismo valor o si correct es falso
                    return false; // Indica que la expresion infija no es valida
                }  
            }else if(infija.cima().charAt(0) == '('){
                analizador.apilar(1);
            }else if(infija.cima().charAt(0) >= 48 && infija.cima().charAt(0) <= 57){ // Si los caracteres son numeros
                analizador.apilar(2);
            }else{
                analizador.apilar(-2); // Si los caracteres son operadores
            }
            auxiliar.apilar(infija.desapilar()); // Permite que la pila de elementos vaya disminuyendo en la pila INFIJA y aumentando en la pila AUXILIAR
        }
        while(!auxiliar.estaVacia()){
            infija.apilar(auxiliar.desapilar()); // Se trasladan los elementos de la pila AUXILIAR a la pila INFIJA
        }
        return analizador.estaVacia() || (analizador.tamanio()== 1 && analizador.cima() == 2); // Verifica si la pila ANALIZADOR esta vacia o si la pila ANALIZADOR solo contiene el numero 2
    }
    
    public static void imprimirPila(Pila<String> pila){
        Pila<String> auxiliar = new Pila<>();
        
        // Recorre la pila PILA que recibe como parametro para imprimir sus elementos.
        // Luego, se desapila cada elemento para que depués sea apilado en la pila AUXILIAR
        while(!pila.estaVacia()){
            System.out.print(pila.cima() + " -> ");
            auxiliar.apilar(pila.desapilar());
        }
        
        // Apilar los elementos de la pila AUXILIAR en la pila PILA que se recibe como parametro.
        while(!auxiliar.estaVacia()){
            pila.apilar(auxiliar.desapilar());
        }
        System.out.println("");
    }
    
    public static Pila<String> obtenerPostfija(Pila<String> infija){
        Pila<String> postFija = new Pila<>();
        Pila<String> operadores = new Pila<>();
        Pila<String> auxiliar = new Pila<>();
        Pila<String> guardarPila = new Pila<>();
        int ascii;
        while(!infija.estaVacia()){
            ascii = (int) infija.cima().charAt(0); // Se obtiene el codigo ASCII de la cima
            // Se verifica si es un numero
            if(ascii >= 48 && ascii <= 57){
                String save = infija.desapilar();
                guardarPila.apilar(save);
                postFija.apilar(save);
            }else{   
                if(ascii==41){ // Verficia si es un parentesis de cierre
                    if("(".equals(operadores.cima())){ // Si la cima es el parentesis de apertura
                        // Se cierra los parentesis correspondientes
                        operadores.desapilar(); // se desapila el paréntesis de apertura de la pila operadores
                        guardarPila.apilar(infija.desapilar()); // se apila el operando que se encuentra debajo del paréntesis de cierre actual en la pila guardarPila.
                        continue; // Se pasa a la siguiente iteracion del bucle
                    }
                    postFija.apilar(operadores.desapilar()); // Se desapila el operador en la cima de operadores y se apila en la pila postFija.
                    if("(".equals(operadores.cima())){ // Si se encuentra un parentesis de apertura en la cima.
                        operadores.desapilar(); // se desapila el paréntesis de apertura de la pila operadores
                        guardarPila.apilar(infija.desapilar()); // se apila el operando que se encuentra debajo del paréntesis de cierre actual en la pila guardarPila.
                    }
                }else{
                    if(operadores.estaVacia()){
                        String save = infija.desapilar(); // Se desapila el operador de la pila infija
                        // Se apila el operador en guardarpila y operadores
                        guardarPila.apilar(save); 
                        operadores.apilar(save);
                    }else{
                        if(operadorFueraPila.get(infija.cima()) > operadorDentroPila.get(operadores.cima())){ // Se compara la precedencia de operadores
                            String save = infija.desapilar(); // Se desapila el operador de la pila infija
                            // Se apila el operador en guardarpila y operadores
                            guardarPila.apilar(save);
                            operadores.apilar(save);
                        }else{ // Si la precedencia del operador de la cima de la pila infija es menor a la cima de la pila operadores
                            postFija.apilar(operadores.desapilar()); // Se desapila el operador de la pila de operadores y se apila en la pila de postfija
                        }
                    }
                }
            }
        }
        while(!operadores.estaVacia()){ // Vacia la pila de operadores en la pila de postfija
            postFija.apilar(operadores.desapilar());
        }
        while(!postFija.estaVacia()){ // Vacia la pila de postfija en la pila auxiliar
            auxiliar.apilar(postFija.desapilar());
        }
        while(!guardarPila.estaVacia()){ // Vacia la pila de guardarpila en la pila infija
            infija.apilar(guardarPila.desapilar());
        }
        return auxiliar; // Devuelve la pila auxiliar, que contiene la expresion postfija en el orden adecuado
    }
    
    public static Pila<String> invertirPila(Pila<String> pila){
        Pila<String> aux = new Pila<>();
        while(!pila.estaVacia()){
            // Verifica si el parentesis de cierre se encuentra en la cima para cambiar por su parentesis de opuesto y luego apilar
            if(")".equals(pila.cima())){
                pila.desapilar();
                aux.apilar("(");
            }else if("(".equals(pila.cima())){ // Verifica si el parentesis de inicio se encuentra en la cima para cambiar por su parentesis de opuesto y luego apilarlo en la pila AUXILIAR
                pila.desapilar();
                aux.apilar(")");
            }else{ // Si no hay un parentesis, es decir, son numeros y operadores. Entonces se despila y luego apila en la pila AUXILIAR
                aux.apilar(pila.desapilar());
            }
        }
        return aux; //Retorna la pila invertida
    }
    
    
    public static void resolverPostfija(Pila<String> postfija){
        int ascii;
        double val1,val2;
        Pila<String> accionActual = new Pila<>();
        accionActual.apilar(null); //   Se apila null para manejar de manera correcta el primer operador desapilado
        while(!postfija.estaVacia()){
            ascii = postfija.cima().charAt(0); // Obtener el caracter de la cima en la posicion 0
            if(!(ascii >= 48 && ascii <= 57)){ // Verifica si los caracteres no son numeros en el codigo ascii, es decir, son operadores
                val1 = Double.parseDouble(accionActual.desapilar()); // Desapila la cima y convierte los caracteres en double
                val2 = Double.parseDouble(accionActual.desapilar()); // Desapila el elemento que le sigue a la cima y lo convierte los caracteres en double
                switch(postfija.desapilar()){ // Se esapila los operadores para luego evaluarlos
                    case "+":         
                        accionActual.apilar(String.valueOf(val1+val2));
                    break;
                    case "-":
                        accionActual.apilar(String.valueOf(val2-val1));
                    break;
                    case "*":
                        accionActual.apilar(String.valueOf(val1*val2));
                    break;
                    case "/":
                        accionActual.apilar(String.valueOf((double) (val2/val1)));
                    break;
                    case "^":
                        accionActual.apilar(String.valueOf( (double) Math.pow(val2, val1)));
                    break;
                }
            }else{ // Si el caracter es un numero, se apila en la pila accionActual
                accionActual.apilar(postfija.desapilar());
            }
        }
        System.out.println(accionActual.desapilar()); // Se desapila el unico elemento en la pila y luego se imprime en pantalla
    }
    
    
}
