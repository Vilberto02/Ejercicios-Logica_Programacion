/*
Problema 4
Elaborar un programa que permita leer tres números de tipo entero; e imprima el mayor; utilizando un
módulo para leer los números, una función para obtener y devolver el mayor y un módulo para imprimir el
mayor. Utilizando parámetros.
*/

#include <iostream>
using namespace std;
void entrada(int &num1, int &num2, int &num3);
int mayorNum(int x, int y, int m);
void salida(int m);
int main(){
    int mayor, num1, num2, num3, m;
    entrada(num1, num2, num3);
    mayor = mayorNum(num1, num2, num3);
    salida(mayor);
    return 0;
}
void entrada(int &num1, int &num2, int &num3){
    cout<<"Ingrese un numero: "; cin>>num1;
    cout<<"Ingrese un numero: "; cin>>num2;
    cout<<"Ingrese un numero: "; cin>>num3;
}
int mayorNum(int x, int y, int m){
    int mayor;
    if (x >= y && x >= m) {
        mayor = x;
    } else if (y >= x && y >= m) {
        mayor = y;
    } else {
        mayor = m;
    }
    return (mayor);
}
void salida(int m){
    cout<<"El mayor numero es: "<<m<<endl;
}