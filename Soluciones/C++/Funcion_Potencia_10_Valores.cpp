/*
10 valores para Y
10 valores para x
10 resultados para z
z =  y^x
*/
#include <iostream>
#include <math.h>
using namespace std;
void funcionZ (double &a, double &b, double &z);
int main (){
    double x = 0, y = 0, z = 0;
    for (int i = 1; i<=10; i++){
        cout<<"\tFUNCION CON ENTRADA DE 10 VALORES\n";
        cout<<"Ingrese un valor de X["<<i<<"]: "; cin>>x;
        cout<<"Ingrese un valor de Y["<<i<<"]: "; cin>>y;
        funcionZ(x, y, z);
        cout<<"-> Valor de Z["<<i<<"]: "<<z<<endl;
        cout<<endl;
    }
}
void funcionZ (double &a, double &b, double &z){
    z = pow(b, a);
}