/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Matriz implements IMatriz {
    @Override
    public int getFilas() {
        return filas;
    }

    @Override
    public void setFilas(int filas) {
        this.filas = filas;
    }

    @Override
    public int getColumnas() {
        return columnas;
    }

    @Override
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public int[][] getMatriz() {
        return matriz;
    }

    @Override
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    private int filas;
    
    private int columnas;
    
    private int[][] matriz;
    
    public Matriz(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
        
    }
    
    @Override
    public void startMatrix(){
        Random rand = new Random();
        for(int i = 0;i<filas;i++){
            for(int j = 0;j<columnas;j++){
                matriz[i][j] = rand.nextInt(11);
            }
        }
    }
    
    @Override
    public void show(){
      for(int i = 0;i<filas;i++){
            for(int j = 0;j<columnas;j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
       }  
        System.out.println("\n");
    }
    
    @Override
    public void traspuesta(){
        int aux;
        for(int i = 0;i<filas;i++){
            for(int j = i + 1;j<columnas;j++){
                aux = matriz[i][j];
                matriz[i][j] = matriz[j][i];
                matriz[j][i] = aux;
            }
       }  
    }
    
    @Override
    public int traza(){
        if(filas == columnas){
            int t = 0;
            for(int i = 0;i<=filas;i++){
                t += matriz[i][i];
            }
            return t;
        }
        System.out.println("No es una matriz cuadrada");
        return -1;
    }
    
    
    @Override
    public Matriz plus(Matriz sumando){
        if(filas == sumando.getFilas() && columnas == sumando.getColumnas()){
            Matriz suma = new Matriz(filas, columnas);
            for(int i = 0;i<filas;i++){
                for(int j = 0;j<columnas;j++){
                    suma.getMatriz()[i][j] = matriz[i][j] + sumando.getMatriz()[i][j];
                }
            }
            return suma;
        }else{
            System.out.println("No es posible sumar estas matrices\n");
            return null;
        }
    }
    
    @Override
    public Matriz minus(Matriz sustraendo){
        if(filas == sustraendo.getFilas() && columnas == sustraendo.getColumnas()){
            Matriz resta = new Matriz(filas, columnas);
            for(int i = 0;i<filas;i++){
                for(int j = 0;j<columnas;j++){
                    resta.getMatriz()[i][j] = matriz[i][j] - sustraendo.getMatriz()[i][j];
                }
            }
            return resta;
        }else{
            System.out.println("No es posible restar estas matrices\n");
            return null;
        }
    }
    
    @Override
    public boolean equal(Matriz otherMatrix){
        if(filas == otherMatrix.getFilas() && columnas == otherMatrix.getColumnas()){
            for(int i = 0;i<filas;i++){
                for(int j = 0;j<columnas;j++){
                    if(matriz[i][j] != otherMatrix.getMatriz()[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public static Matriz identidad(int n){
        Matriz matrizIdentidad = new Matriz(n,n);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrizIdentidad.getMatriz()[i][j] = 1;
            }
        }
        return matrizIdentidad;
    }
}
