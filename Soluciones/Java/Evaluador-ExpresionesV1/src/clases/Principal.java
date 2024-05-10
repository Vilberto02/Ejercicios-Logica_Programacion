/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.util.Scanner;

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
        Scanner entrada = new Scanner(System.in);
        System.out.println("--- Evaluador de expresiones ---");
        System.out.println("Este programa evalua expresiones prefijas complejas que contenga operadores como +, -, *, / y %");
        System.out.print("Expresion: ");
        double valor = evaluate(entrada);
        System.out.println("Valor: "+valor);
    }
    
    
    // PRE: La entrada contiene una expresion prefija legal.
    // POS: Se consume la expresion y se devuelve el resultado.
    public static double evaluate(Scanner input){
        if(input.hasNextDouble()){
            // CASO BASE: Cuando el siguiente token es un numero, entonces se devuelve el numero.
            return input.nextDouble();
        }else{
            // Cuando el siguiente token es un operador y dos operandos.
            String operator = input.next();
            double operando1 = evaluate(input);
            double operando2 = evaluate(input);
            return apply(operator, operando1, operando2);
        }
    }
    
    // PRE: El operador puede ser +, -, *, / y %
    // POS: Devuelve el resultado despues de aplicar el operador al dato de operando1 y operando2
    public static double apply(String operator, double operando1, double operando2){
        if(operator.equals("+")){
            return operando1 + operando2;
        }else if(operator.equals("-")){
            return operando1 - operando2;
        }else if(operator.equals("*")){
            return operando1 * operando2;
        } else if(operator.equals("/")){
            return operando1 / operando2;
        } else if(operator.equals("%")){
            return operando1 % operando2;
        }else{
            throw new IllegalArgumentException("Operador incorrecto: "+operator);
        }
    }
}
