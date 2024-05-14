/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.util.Scanner;
import java.util.Stack;

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
        System.out.println("Este programa evalúa completamente");
        System.out.println("expresiones entre paréntesis con");
        System.out.println("operadores +, -, *, /, and ^");
        System.out.println();
        Scanner console = new Scanner(System.in);
        System.out.print("expresión (enter para salir)? ");
        String line = console.nextLine().trim();
        while (line.length() > 0) {
            evaluate(line);
            System.out.print("expresión (enter para salir)? ");
            line = console.nextLine().trim();
        }
    }
    
    
    // PRE: La entrada contiene una expresion prefija legal.
    // POS: Se consume la expresion y se devuelve el resultado.
    public static void evaluate(String input){
        SpringSplitter data = new SpringSplitter(input);
        Stack<String> simbolos = new Stack<>();
        Stack<Double> numeros = new Stack<>();
        boolean error = false;
        while(!error && data.hasNext()){
            String next = data.next();
            if(next.equals(")")){
                if(simbolos.size() < 2 || simbolos.peek().equals("(")){
                    error = true;
                }else{
                    String operator = simbolos.pop();
                    if(!simbolos.peek().equals("(")){
                        error = true;
                    }else{
                        simbolos.pop(); // Para eliminar el "("
                        double op2 = numeros.pop();
                        double op1 = numeros.pop();
                        double valor = apply(operator, op1, op2);
                        numeros.push(valor);
                    }
                }
            } else if("(+-*/^".contains(next)){
                simbolos.push(next);
            }else{
                numeros.push(Double.valueOf(next));
            }
        }
        
        if(error || numeros.size() != 1 || !simbolos.isEmpty()){
            System.out.println("Expresion ilegal");
        }else{
            System.out.println(numeros.pop());
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
        } else if(operator.equals("^")){
            return Math.pow(operando1, operando2);
        }else{
            throw new IllegalArgumentException("Operador incorrecto: "+operator);
        }
    }
}
