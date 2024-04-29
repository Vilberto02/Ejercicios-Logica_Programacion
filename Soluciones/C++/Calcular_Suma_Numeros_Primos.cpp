//Accion CalcularSumaNumerosPrimos
#include <iostream>
using namespace std;
int main (){
	//Declaracion de variables
	int a, b; //Entrada
	int contador; //Proceso
	int suma = 0; //Salida
	cout<<"Ingrese el valor de a y b (a<b): "; cin>>a>>b;
	if (a>0 && b>0){
		for (int i = a; i<=b; i++){
			contador = 0;
			for (int j = 1; j<=i; j++){
				if (i%j == 0){
					contador = contador + 1;
				}
			}
			if (contador == 2){
				suma = suma + i;
			}
		}
		cout<<"\n-> Sumatoria: "<<suma<<endl;
	} else {
		cout<<"\n-> Error! No existe numeros primos de numeros negativos\n";
	}
	return 0;
}
