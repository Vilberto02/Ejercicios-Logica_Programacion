/*
Dado un valor n, utilizar ciclos para calcular el valor de la expresión.
 sumatoria_desde_i=1_hasta_n(multiplicacion_desde_J=1_hasta_i(j^2))
*/
#include<iostream>
#include<cmath>
using namespace std;
int main(){
	int n;
	int sumatoria = 0, producto = 1;
	cout<<"Ingrese el valor de n (n>1): "; cin>>n;
	if (n>1){
		for(int i=1; i<=n; i++){
			for (int j=1; j<=i;j++){
				producto = producto*pow(j,2);
			}
			sumatoria = sumatoria + 3*producto;
			producto = 1; //Vuelve a inicializar el producto.
		}
		cout<<"\n-> Resultado: "<<sumatoria<<endl;
	} else{
		cout<<"-> ERROR, el valor de n debe de ser mayor a 1."<<endl;
	}
	return 0;
}
