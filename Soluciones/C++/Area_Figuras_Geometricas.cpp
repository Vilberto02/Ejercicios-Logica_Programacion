/*Problema 02
Elaborar un programa que ofrezca un menú de opciones, mediante el cual se pueda escoger calcular el
área de las figuras geométricas: triángulo, cuadrado, rectángulo y círculo. Una vez seleccionada la
opción, que llame al módulo que permita solicitar, leer los datos necesarios, hacer el cálculo
correspondiente e imprimirlo.
*/
#include <iostream>
#include <math.h>
#define PI 3.1416 //constante
using namespace std;
//Prototipos de las funciones
void areaTri();
void areaCua();
void areaRect();
void areaCir();
//Funcion princial
int main()
{
    int opc; //Entrada
    //Menú
    cout<<"\tArea de figuras geometricas\n";
    cout<<"0. Salir."<<endl;
    cout<<"1. Triangulo"<<endl;
    cout<<"2. Cuadrado"<<endl;
    cout<<"3. Rectangulo"<<endl;
    cout<<"4. Circulo"<<endl;
    cout<<endl<<"Ingresa una opcion: "; cin>>opc;
    switch (opc){
        case 0: break;
        case 1: areaTri(); break;
        case 2: areaCua(); break;
        case 3: areaRect(); break;
        case 4: areaCir(); break;
        default: cout<<"ERROR!"; break;
    }

    return 0;
}
//Funcion que calcula el area de un triangulo
void areaTri(){
    float base, altura, areaT;
    cout<<endl<<"Ingrese los siguientes datos para calcular el area de un triangulo"<<endl;
    cout<<"Base: "; cin>>base;
    cout<<"Altura: "; cin>>altura;
    areaT = base*altura/2.0;
    cout<<endl<<"-> Area: "<<areaT<<" m2";
}
//Funcion que calcula el area de un cuadrado
void areaCua(){
    float lado, areaCu;
    cout<<endl<<"Ingrese los siguientes datos para calcular el area de un cuadrado"<<endl;
    cout<<"Lado: "; cin>>lado;
    areaCu = pow(lado, 2);
    cout<<endl<<"-> Area: "<<areaCu<<" m2";
}
//Funcion que calcula el area de un rectangulo
void areaRect(){
    float ancho, largo, areaR;
    cout<<endl<<"Ingrese los siguientes datos para calcular el area de un rectangulo"<<endl;
    cout<<"Ancho: "; cin>>ancho;
    cout<<"Largo: "; cin>>largo;
    areaR = ancho*largo;
    cout<<endl<<"-> Area: "<<areaR<<" m2";
}
//Funcion que calcula el area de un circulo
void areaCir(){
    float radio, areaC;
    cout<<endl<<"Ingrese los siguientes datos para calcular el area de un circulo"<<endl;
    cout<<"Radio: "; cin>>radio;
    areaC = PI*pow(radio, 2);
    cout<<endl<<"-> Area: "<<areaC<<" m2";
}


