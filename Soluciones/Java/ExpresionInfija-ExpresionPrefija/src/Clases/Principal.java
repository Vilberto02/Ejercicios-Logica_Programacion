/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     */
    
    public static Map<String, Integer> operadorFueraPila = new HashMap<>();
    public static Map<String, Integer> operadorDentroPila = new HashMap<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        operadorFueraPila.put("+", 1);
        operadorFueraPila.put("-", 1);
        operadorFueraPila.put("*", 2);
        operadorFueraPila.put("/", 2);
        operadorFueraPila.put("^", 4);
        operadorFueraPila.put("(", 5);
        
        operadorDentroPila.put("+", 1);
        operadorDentroPila.put("-", 1);
        operadorDentroPila.put("*", 2);
        operadorDentroPila.put("/", 2);
        operadorDentroPila.put("^", 3);
        operadorDentroPila.put("(", 0);
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Convertidor de expresion infija a prefija");
        System.out.println("Ingrese la expresion: ");
        String linea = entrada.nextLine().replaceAll("//", "");
        while (!linea.isEmpty()) {
            Stack<String> infija = obtenerInfija(linea);
            if (infija != null && validarInfija(infija)) {
                System.out.print("Infija: ");
                imprimirPila(infija);
                infija = invertirPila(infija); // Invierte la infija
                Stack<String> preOrder = obtenerPostfija(infija); // Obtiene la postfija de la infija
                preOrder = invertirPila(preOrder); // Obtiene la prefija inviertiendo la postfija
                System.out.print("Prefija: ");
                imprimirPila(preOrder);
                infija = invertirPila(infija); // Vuelve a invertir la infija
                Stack<String> postOrder = obtenerPostfija(infija); // Obtiene la postfija de la infija original
                //System.out.print("Postfija: ");
                //imprimirPila(postOrder);
                resolverPostfija(postOrder); // Resuelve la expresion usando la postfija
            } else {
                System.out.println("Expresi1on ilegal"); // Si se tiene una expresion ilegal
            }
            System.out.print("Ingrese la expresion: ");
            linea = (entrada.nextLine()).replaceAll("\\s", "");
        }
        
    }
    
    public static Stack<String> obtenerInfija(String cadena){
        Stack<String> infija = new Stack<>();
        Stack<String> infijaOrdenado = new Stack<>();
        int ascii;
        infija.push("(");
        for(int i = 0;i<cadena.length();i++){
            // Convierte el caracter de la cadena (expresion) en la posicion i en código ASCII
            ascii = (int) cadena.charAt(i);
            
            // Verifica que el indice del caracter este entre [40, 57] menos el indice del caracter 44 (,) o que contenga el caracter 94 (^)
            // [40, 57] comprende los operadores (, ), +, -, *, -, ., /, 0, 1,..., 9
            if((ascii >= 40 && ascii <= 57 && ascii != 44) || ascii == 94){
                
                // Verifica que los caracteres no sean numeros, es decir, que sean operadores. Tampoco acepta al punto decimal (.)
                if(!((ascii >= 48 && ascii <= 57) || ascii == 46)){
                    infija.push("" + cadena.charAt(i)); // Apila en la pila infija, convirtiendo el numero del caracter (operador) en String.
                }else{                    
                    infija.push("");
                    int point = 0;
                    // Verifica que los caracteres sean numeros o contenga punto decimal (.)
                    // Forma una cadena que va estar por formada por el operador y el numero, es decir, una expresion infija.
                    while(i<cadena.length() && (((int) cadena.charAt(i) >= 48 && (int) cadena.charAt(i) <= 57) || (int) cadena.charAt(i) == 46)){
                        String top = infija.pop();
                        top = top + cadena.charAt(i); // Concatena el operador con e numero
                        if(cadena.charAt(i) == '.'){
                            point++; // Suma +1 si el caracter es un punto decimal
                        }
                        infija.push(top); // Apila la cadena concatenada
                        i++;
                    }
                    
                    // Si la expresion contiene mas de dos puntos decimales, se retorna nulo porque seria una expresion invalida
                    if(point >= 2){
                        return null;
                    }
                    
                    // Si el caracter de la cima es un punto decimal (.), este se saca y se concatena con un 0
                    if(infija.peek().charAt(0) == '.'){
                        String top = infija.pop();
                        top = "0" + top;
                        infija.push(top);
                    }
                    // Se resta 1 al iterador del for porque fue cambiando en el while
                    i--;       
                }
            }else{
                return null; // Retorna nulo si no es un operador o numero
            }
        }
        infija.push(")"); // Apila el parentesis de cierre de la expresion general.
        while(!infija.isEmpty()){
            infijaOrdenado.push(infija.pop()); // Ordena la infija
        }
        return infijaOrdenado;
    }
    
        public static boolean validarInfija(Stack<String> infija){
        Stack<Integer> analizador = new Stack<>();
        Stack<String> auxiliar = new Stack<>();
        while(!infija.isEmpty()){
            if(infija.peek().charAt(0) == ')'){ // Si la cima de la pila es el parentesis de cierre
                boolean correct = false; // Para indicar si se encontro un par de parentesis correspondientes
                int actual = 2; // Se inicia con un parentesis de cierre 
                while(!analizador.isEmpty()){
                    int curr = analizador.pop();
                    if(curr == actual){ // Si se encuentra un parentesis de apertura, es decir, encuentra a su correspondiente
                        actual *= -1; // Se multiplica actual para iniciar con el parentesis de apertura.
                    }else if(curr== 1){ // Significa que se encontro un parentesis de inicio que no tiene un parentesis de cierre
                        analizador.push(2); // Se apila 2 para indicar que se ha encontrado un parentesis de cierre que no tiene a su parentesis correspondiente
                        correct = true; 
                        break; // Sale del bucle
                    }else{
                        break; // Se encontro un parentesis diferente al de cierre e inicio y se sale del bucle
                    }
                }
                if((actual == 2) || !correct){ // Verifica si actual presenta el mismo valor o si correct es falso
                    return false; // Indica que la expresion infija no es valida
                }  
            }else if(infija.peek().charAt(0) == '('){
                analizador.push(1);
            }else if(infija.peek().charAt(0) >= 48 && infija.peek().charAt(0) <= 57){ // Si los caracteres son numeros
                analizador.push(2);
            }else{
                analizador.push(-2); // Si los caracteres son operadores
            }
            auxiliar.push(infija.pop()); // Permite que la pila de elementos vaya disminuyendo en la pila INFIJA y aumentando en la pila AUXILIAR
        }
        while(!auxiliar.isEmpty()){
            infija.push(auxiliar.pop()); // Se trasladan los elementos de la pila AUXILIAR a la pila INFIJA
        }
        // Verifica si la pila ANALIZADOR esta vacia o si la pila ANALIZADOR solo contiene el numero 2
        return analizador.isEmpty()|| (analizador.size()== 1 && analizador.peek() == 2); 
    }
    
    public static void imprimirPila(Stack<String> pila){
        Stack<String> auxiliar = new Stack<>();
        
        // Recorre la pila PILA que recibe como parametro para imprimir sus elementos.
        // Luego, se desapila cada elemento para que depués sea apilado en la pila AUXILIAR
        while(!pila.isEmpty()){
            System.out.print(pila.peek() + " -> ");
            auxiliar.push(pila.pop());
        }
        
        // Apilar los elementos de la pila AUXILIAR en la pila PILA que se recibe como parametro.
        while(!auxiliar.isEmpty()){
            pila.push(auxiliar.pop());
        }
        System.out.println("");
    }
    
    public static Stack<String> invertirPila(Stack<String> pila){
        Stack<String> aux = new Stack<>();
        while(!pila.isEmpty()){
            // Verifica si el parentesis de cierre se encuentra en la cima para cambiar por su parentesis de opuesto y luego apilar
            if(")".equals(pila.peek())){
                pila.pop();
                aux.push("(");
            }else if("(".equals(pila.peek())){ // Verifica si el parentesis de inicio se encuentra en la cima para cambiar por su parentesis de opuesto y luego apilarlo en la pila AUXILIAR
                pila.pop();
                aux.push(")");
            }else{ // Si no hay un parentesis, es decir, son numeros y operadores. Entonces se despila y luego apila en la pila AUXILIAR
                aux.push(pila.pop());
            }
        }
        return aux; //Retorna la pila invertida
    }
    
    public static Stack<String> obtenerPostfija(Stack<String> infija){
        Stack<String> postFija = new Stack<>();
        Stack<String> operadores = new Stack<>();
        Stack<String> auxiliar = new Stack<>();
        Stack<String> guardarPila = new Stack<>();
        int ascii;
        while(!infija.isEmpty()){
            ascii = (int) infija.peek().charAt(0); // Se obtiene el codigo ASCII de la cima
            // Se verifica si es un numero
            if(ascii >= 48 && ascii <= 57){
                String save = infija.pop();
                guardarPila.push(save);
                postFija.push(save);
            }else{   
                if(ascii==41){ // Verficia si es un parentesis de cierre
                    if("(".equals(operadores.peek())){ // Si la cima es el parentesis de apertura
                        // Se cierra los parentesis correspondientes
                        operadores.pop(); // se desapila el paréntesis de apertura de la pila operadores
                        guardarPila.push(infija.pop()); // se apila el operando que se encuentra debajo del paréntesis de cierre actual en la pila guardarPila.
                        continue; // Se pasa a la siguiente iteracion del bucle
                    }
                    postFija.push(operadores.pop()); // Se desapila el operador en la cima de operadores y se apila en la pila postFija.
                    if("(".equals(operadores.peek())){ // Si se encuentra un parentesis de apertura en la cima.
                        operadores.pop(); // se desapila el paréntesis de apertura de la pila operadores
                        guardarPila.push(infija.pop()); // se apila el operando que se encuentra debajo del paréntesis de cierre actual en la pila guardarPila.
                    }
                }else{
                    if(operadores.isEmpty()){
                        String save = infija.pop(); // Se desapila el operador de la pila infija
                        // Se apila el operador en guardarpila y operadores
                        guardarPila.push(save); 
                        operadores.push(save);
                    }else{
                        if(operadorFueraPila.get(infija.peek()) > operadorDentroPila.get(operadores.peek())){ // Se compara la precedencia de operadores
                            String save = infija.pop(); // Se desapila el operador de la pila infija
                            // Se apila el operador en guardarpila y operadores
                            guardarPila.push(save);
                            operadores.push(save);
                        }else{ // Si la precedencia del operador de la cima de la pila infija es menor a la cima de la pila operadores
                            postFija.push(operadores.pop()); // Se desapila el operador de la pila de operadores y se apila en la pila de postfija
                        }
                    }
                }
            }
        }
        while(!operadores.isEmpty()){ // Vacia la pila de operadores en la pila de postfija
            postFija.push(operadores.pop());
        }
        while(!postFija.isEmpty()){ // Vacia la pila de postfija en la pila auxiliar
            auxiliar.push(postFija.pop());
        }
        while(!guardarPila.isEmpty()){ // Vacia la pila de guardarpila en la pila infija
            infija.push(guardarPila.pop());
        }
        return auxiliar; // Devuelve la pila auxiliar, que contiene la expresion postfija en el orden adecuado
    }
    
    public static void resolverPostfija(Stack<String> postfija){
        int ascii;
        double val1,val2;
        Stack<String> accionActual = new Stack<>();
        accionActual.push(null); //   Se apila null para manejar de manera correcta el primer operador desapilado
        while(!postfija.isEmpty()){
            ascii = postfija.peek().charAt(0); // Obtener el caracter de la cima en la posicion 0
            if(!(ascii >= 48 && ascii <= 57)){ // Verifica si los caracteres no son numeros en el codigo ascii, es decir, son operadores
                val1 = Double.parseDouble(accionActual.pop()); // Desapila la cima y convierte los caracteres en double
                val2 = Double.parseDouble(accionActual.pop()); // Desapila el elemento que le sigue a la cima y lo convierte los caracteres en double
                switch(postfija.pop()){ // Se esapila los operadores para luego evaluarlos
                    case "+":         
                        accionActual.push(String.valueOf(val1+val2));
                    break;
                    case "-":
                        accionActual.push(String.valueOf(val2-val1));
                    break;
                    case "*":
                        accionActual.push(String.valueOf(val1*val2));
                    break;
                    case "/":
                        accionActual.push(String.valueOf((double) (val2/val1)));
                    break;
                    case "^":
                        accionActual.push(String.valueOf( (double) Math.pow(val2, val1)));
                    break;
                }
            }else{ // Si el caracter es un numero, se apila en la pila accionActual
                accionActual.push(postfija.pop());
            }
        }
        System.out.println("Resultado: "+accionActual.pop()); // Se desapila el unico elemento en la pila y luego se imprime en pantalla
    }
}
