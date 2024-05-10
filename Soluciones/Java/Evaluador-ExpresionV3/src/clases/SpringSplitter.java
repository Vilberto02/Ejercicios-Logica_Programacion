/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class SpringSplitter {
    public Queue<Character> caracteres; // Cola
    public String token;
    public static final String SPECIAL_CHARACTERS = "()+-*/^"; // Constante
    
    public SpringSplitter(String entrada){
        caracteres = new LinkedList<>();
        for (int i = 0; i < entrada.length(); i++) {
            caracteres.add(entrada.charAt(i));
        }
        findNextToken();
    }
    
    // Comprueba si hay mas tokens disponibles
    // POST: Devuelve True si tiene otro token
    public boolean hasNext(){
        return token != null;
    }
    
    // Obtiene el siguiente token
    // PRE: Hay otro token para devolver (lanza NoSuchElementException si no es así)
    // POST: Devuelve y consume el siguiente token
    public String next(){
        checkToken();
        String result = token;
        findNextToken();
        return result;
    }
    // PRE: Hay otro token para deolver (lanza NoSuchElementException si no es así)
    // POST: Devuelve el siguiente token sin consumirlo
    public String peek(){
        checkToken();
        return token; // Retorna el token actual.
    }
    
    
    // POST: Encuentra el siguiente token, si lo hay.
    private void findNextToken(){
        
        // Elimina los espacios en blanco
        while(!caracteres.isEmpty() && Character.isWhitespace(caracteres.peek())){
            caracteres.remove();
        }
        
        // Verifica si la cola esta vacía.
        if(caracteres.isEmpty()){
            token = null;
        }else{
            token = "" + caracteres.remove(); // Convierte al caracter en una cadena.
            if(!SPECIAL_CHARACTERS.contains(token)){
                boolean done = false;
                while(!caracteres.isEmpty() && !done){
                    char ch = caracteres.peek();
                    if(Character.isWhitespace(ch) || SPECIAL_CHARACTERS.indexOf(ch) >= 0){
                        done = true;
                    }else{
                        token = token + caracteres.remove();
                    }
                }
            }
        }
    }
    
    /*
    SPECIAL_CHARACTERS.indexOf(ch) >= 0
    Este método comprueba si el carácter "ch" está en la cadena SPECIAL_CHARACTERS.
    Devuelve un índice no negativo si ch está en SPECIAL_CHARACTERS y -1 en caso contrario.
    */
    
    // Verifica si existe un token disponible.
    // POST: Devuelve un excepcion si no queda ningún token
    private void checkToken(){
        if(!hasNext()){
            throw new NoSuchElementException(); //SI no existe un token disponible.
        }
    }
}
