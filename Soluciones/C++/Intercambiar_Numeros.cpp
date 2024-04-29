/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

/*
Problema 3
Elaborar un programa que permita leer dos números de tipo real en el módulo principal; que en un
módulo los intercambie vía parámetros por referencia, y los imprima en el módulo principal.
*/
#include <iostream>
using namespace std;
//Prototipo de la funcion
void intercambiarNum(float &num1, float &num2);
//Programa principal
int main (){
    float num1, num2;
    cout<<"\t Intercambio de numeros"<<endl;
    cout<<"Ingrese el 1er numero: "; cin>>num1;
    cout<<"Ingrese el 2do numero: "; cin>>num2;
    intercambiarNum(num1, num2);
    cout<<endl<<"-> 1er numero: "<<num1;
    cout<<endl<<"-> 2do numero: "<<num2;
}
//Funcion para intercambiar numeros
void intercambiarNum(float &num1, float &num2){
    float temp;
    temp = num1;
    num1 = num2;
    num2 = temp;
}
