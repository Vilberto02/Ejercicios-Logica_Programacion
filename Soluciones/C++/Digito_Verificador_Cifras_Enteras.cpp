/*
Leer un numero de tipo entero de cinco cifras.
Calcular e imprimir el codigo verificador (0 - 9).
Ejemplo:
7 4 6 2 1 -> 1x2 = 2, 2x3 = 6, 
*/
#include <iostream>
using namespace std;
int main (){
    int numero, cifras[4];
    int i = 0;
    cout<<"Ingrese un numero entero de 5 cifras: "; cin>>numero;
    while (numero>0){
        cifras[i] = numero%10;
        numero =  numero/10;
        i++;
    }
    for (int j = 0; j<=4; j++){
        cout<<cifras[j];
    }

}