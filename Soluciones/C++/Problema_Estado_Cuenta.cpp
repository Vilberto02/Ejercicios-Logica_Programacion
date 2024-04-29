/*Problema de la PC2 del curso de Algoritmica I*/

#include <iostream>
#include <string>
#include <stdlib.h>
using namespace std;
int main (){
    float retiro, deposito, saldoInicial, saldoFinal;
    char cuentaH[200];
    int opc, movimiento;
    cout<<"Ingresa el nombre de la cuenta habiente: "; cin>>cuentaH;
    cout<<"Ingrese el saldo inicial: "; cin>>saldoInicial;
    do {
        cout<<endl<<"\tMENU"<<endl;
        cout<<"0. Salir"<<endl;
        cout<<"1. Deposito"<<endl;
        cout<<"2. Retiro"<<endl;
        cout<<endl<<"Ingrese una opcion: "; cin>>opc;
        switch(opc){
            case 0: break;
            case 1: movimiento = 1;
            {
                cout<<endl<<"Ingrese la cantidad a depositar: "; cin>>deposito;
                saldoFinal = saldoInicial + deposito;
                break;
            }
            case 2: movimiento = 2; 
            {
                cout<<endl<<"Ingrese la cantidad a retirar: "; cin>>retiro;
                if (retiro<=saldoInicial){
                    saldoFinal = saldoInicial - retiro;
                } else {
                    cout<<"Saldo insuficiente";
                }
                break;
            }
            default: cout<<"ERROR! Vuelva a ingresar los datos."<<endl; break;
        }
    }while (opc!=0);
    system("cls");
    cout<<"Nombre de cuentahabiente: "<<cuentaH<<endl;
    cout<<"Saldo inicial: "<<saldoInicial<<endl;
    cout<<"\tEstado de cuenta"<<endl;
    cout<<"Movimiento: "<<movimiento<<endl;
    if (movimiento == 1){
        cout<<"Deposito: "<<deposito<<endl;
    } else{
        cout<<"Retiro: "<<retiro<<endl;
    }
    cout<<"Saldo: "<<saldoFinal<<endl;
    return 0;
}

/*retiro = float()
deposito = float()
cuentaH = "tuString"
cuentaH = input("Ingresa el nombre de la cuenta habiente: ")
saldoInicial = float(input("Ingresa el saldo inicial: "))
print("\tMENU")
print("0. Salir\n1. Deposito\n2. Retiro")
opc = int(input("Ingrese una opcion: "))
if opc==0:
    print("Termino el programa")
elif opc==1:
    deposito = float(input("Ingrese la cantidad a depositar: "))
    saldoFinal = saldoInicial + deposito
elif opc==2:
    retiro = float(input("Ingrese la cantidad a retirar: "))
    saldoFinal = saldoInicial + retiro

print("\t\tESTADO DE CUENTA")
print("\tCUENTA HABIENTE: ", cuentaH, "\n\tSALDO INICIAL: ", saldoInicial, "\n")
print("\tMovimiento\tDeposito \tRetiro\tSaldo")
print(f"\t1\t\t{deposito}\t\t{retiro}\t{saldoFinal}")
print("\n")*/