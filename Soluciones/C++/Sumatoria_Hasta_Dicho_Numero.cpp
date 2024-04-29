#include<iostream>
using namespace std;
float suma (int x);
int main(){
    int num;
    cout<<"Ingresa un numero: ";
    cin>>num;
    cout<<endl;
    cout<<"Resultado: "<<suma(num);
    return 0;
}

float suma (int x){
    float suma = 0;
    for (int i=0; i<=x; i++){
        suma = suma + i;
    }
    return(suma);
}

/*
Sintaxis para crear una nueva terminal:
Primero: g++ nombre_archivo.cpp -o nuevo_nombre
Segundo: ./nuevo_nombre.exe
*/