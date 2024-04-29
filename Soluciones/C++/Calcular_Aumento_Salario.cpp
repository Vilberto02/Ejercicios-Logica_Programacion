/*
En una empresa de computadoras, los salarios de los empleados
se van a aumentar segun su contraro actual.
Contrato        | Aumento
0 - 9000            20%
9001 - 15 000       10%
15 001 - 20 000     5%
+20 000             0%
Escribir un programa que solicite el salario actual del empleado
y calcule y visualice el nuevo salario.
*/
//Accion CalcularAumentoSalario.
#include <iostream>
using namespace std;
int main (){
    double salarioActual, numeroEmpleados; //Entrada
    double aumento; //Proceso
    double salarioFinal; //Salida
    cout<<"Ingrese la cantidad de empleados: "; cin>>numeroEmpleados;
    for (int i = 1; i<=numeroEmpleados; i++){
        cout<<"\n\tEmpleado "<<i<<endl;
        cout<<"Digite su salario actual: "; cin>>salarioActual;
        if (salarioActual>0 && salarioActual<=9000){
            aumento = 20*salarioActual/100.0;
        } else if (salarioActual>=9001 && salarioActual<=15000){
            aumento = 10*salarioActual/100.0;
        } else if (salarioActual>=15001 && salarioActual<=20000){
            aumento = 5*salarioActual/100.0;
        } else {
            aumento = 0;
        }
        salarioFinal = salarioActual + aumento;
        cout<<"-> Nuevo salario: "<<salarioFinal<<" soles."<<endl;
    }
    return 0;
}
