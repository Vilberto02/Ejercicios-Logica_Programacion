/*
Problema 5
Elaborar un programa que permita leer la base y el exponente, que llame a una función que eleve el
número a la potencia, al regresar al módulo principal que imprima el resultado.
*/
#include <iostream>
#include <math.h>
using namespace std;
void entrada(int &base, int &exponente);
int potencia(int x, int y);
void salida(int m); 
int main (){
    int base, exponente, resultado;
    entrada(base, exponente);
    resultado = potencia(base, exponente);
    salida(resultado);
    return 0;
}
void entrada(int &base, int &exponente){
    cout<<"Ingrese la base: "; cin>>base;
    cout<<"Ingrese el exponente: "; cin>>exponente;
}
int potencia(int x, int y){
    int potencia;
    potencia = pow(x, y);
    return potencia;
}
void salida(int m){
    cout<<endl<<"-> Resultado: "<<m<<endl;
}
