/*
&nombre: extrae la direccion de memoria de la variable nombre.
int media = 4;
int *puntero: Permite almacenar la dirección de memoria de una variable de tipo entero.
puntero = &media : contiene la direccion de  memoria de la variable memoria.
*puntero = 6 : Accede al contenido de la dirección de memoria de la variable apuntada. Modifica 
el contenido de la direccion de memoria de la variable media.
*/ 
#include <iostream>
#include <math.h>
using namespace std;
void sumatoriaRC (int num, double &sumatoria);
int main (){
    double sumatoria = 0;
    int numero;
    cout<<"\tSumatoria de las raices cuadradas"<<endl;
    cout<<"Ingrese un numero: "; cin>>numero;
    sumatoriaRC(numero, sumatoria);
    cout<<"-> Sumatoria: "<<sumatoria;
    return 0;
}
void sumatoriaRC (int num, double &sumatoria){
    int i;
    for (i = 1; i<=num; i++ ){
        sumatoria = sumatoria + sqrt(i);
    }
}
