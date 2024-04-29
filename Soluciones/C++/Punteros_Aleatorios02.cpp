/*
Generar dos numeros aleatorios entre 10 y 20 y calcular el el mayor. Todo utilizando punteros
*/
#include <iostream>
#include <time.h>
#define MAX 20
#define MIN 10
using namespace std;
int main (){
    //Declaracion de variables
    int numero1, numero2;
    int *ptr1, *ptr2;
    //Inicializacion
    srand(time(NULL));
    //Asignacion de direcciones de memoria a los punteros
    ptr1 = &numero1;
    ptr2 = &numero2;
    //Asignacion de numeros aleatorios a los punteros
    *ptr1 = rand()%(MAX-MIN+1)+MIN;
    *ptr2 = rand()%(MAX-MIN+1)+MIN;
    //Imprimir en pantalla los resultados
    cout<<"\tNUMEROS ALEATORIOS\n";
    cout<<"-> "<<(*ptr1)<<endl;
    cout<<"-> "<<(*ptr2)<<endl;
    //Direcciones de memoria de los numeros aleatorios
    cout<<"\tDIRECCIONES DE MEMORIA\n";
    cout<<"-> "<<ptr1<<endl;
    cout<<"-> "<<ptr2<<endl;
    cout<<endl;
    //Comparacion de punteros
    if ((*ptr1)>(*ptr2)){
        cout<<(*ptr1)<<" es mayor que "<<(*ptr2)<<endl;
    } else{
        if ((*ptr1)<(*ptr2)){
            cout<<(*ptr2)<<" es mayor que "<<(*ptr1)<<endl;
        } else {
            cout<<"Ambos numeros son iguales"<<endl;
        }
    }
    cout<<endl;
    return 0;
}