//Calcula la suma de factorial de un numero n.
//Entrada: n;
//Salida: 1! + 2! +...+ (n-1)! + n!
#include <iostream>
using namespace std;
int main (){
	int n; //Entrada
	int factorial = 1; //Proceso
	double sumaFactorial = 0; //Salida
	cout<<"Digite el valor de n: "; cin>>n;
	if (n<0){
		cout<<"No existe factorial de un numero negativo\n";
	} else{
		if (n == 0){
			factorial = 1;
			sumaFactorial = 1;
		} else {
			for (int i=1; i<=n; i++){
				factorial = factorial*i;
				sumaFactorial = sumaFactorial + factorial;
			}
		}
		cout<<"-> Factorial de "<<n<<": "<<factorial<<endl;
		cout<<"-> Suma factorial: "<<sumaFactorial;
	}
	return 0;
}
/*
Prueba de escritorio:
Si n=4 -> 1! + 2! + 3! + 4! = 1 + 2 + 6 + 24 = 33
*/
