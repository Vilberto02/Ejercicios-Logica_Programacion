#include <iostream>
using namespace std;
int main(){
	int n = 5;
	
	
	for (int i = 0; i<n; i++){
		for (int j=n-1; j>i; j--){
			cout<<"  "; //Los espacios de cada fila en el triangulo
		}
		for (int p=0; p<i; p++){
			cout<<"* "; //Imprime 5 asteriscos(lado izquierdo)
		}
		cout<<"* "; //Imprime el primer asterisco.
		for (int j=0; j<i; j++){
			cout<<"* "; //Imprime 5 asteriscos (lado izquierdo)
		}
		cout<<endl;
	}
	/*for (int i=n-1; i>0; i--){
		for (int j=1; j<n; j++){
			cout<<"  ";
		}
		for (int k=n-1;k>0;k--){
			cout<<"* ";
		}
		cout<<"* ";
		cout<<endl;
	}*/
	return 0;
}
