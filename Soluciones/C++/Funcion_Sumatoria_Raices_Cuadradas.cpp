#include <iostream>
#include <math.h>
using namespace std;
double sumatoriaRC (int a);

int main () {
    int i;
    cout<<"\tSumatoria de las raices cuadradas de los numeros pares del 2 al 1500\n";
    cout<<"-> Sumatoria: "<<sumatoriaRC(i);
    return 0;
}

double sumatoriaRC (int a){
    double sumatoria = 0;
    for (a=1; a<=1500; a++){
        if (a%2==0){
            sumatoria = sumatoria + sqrt(a);
        }
    }
    return (sumatoria);
}