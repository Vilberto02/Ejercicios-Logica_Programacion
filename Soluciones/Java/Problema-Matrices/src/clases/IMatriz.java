/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public interface IMatriz {
    public void startMatrix();
    public void show();
    public void traspuesta();
    public Matriz plus(Matriz sumando);
    public Matriz minus(Matriz sustraendo);
    public boolean equal(Matriz otherMatrix);
    public int getFilas();
    public int traza();
    public void setFilas(int filas);
    public int getColumnas();
    public void setColumnas(int columnas);
    public int[][] getMatriz();
    public void setMatriz(int[][] matriz);
}
