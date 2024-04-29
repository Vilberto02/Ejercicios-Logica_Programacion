/*
Imprima la siguiente piramide usando estructuras repetitivas.
1        
232      
34543    
4567654
567898765
67890109876
7890123210987
890123454321098
90123456765432109
0123456789876543210
*/
#include <iostream>
using namespace std;

int main (){
    int numero;
    cout<<"Ingrese el valor de n: "; cin>>numero;
    for (int i = 1; i<=numero; i++){
        // 2*i-1: permite imprimir o da como resultado el centro de cada fila.
        for (int j = i; j<2*i-1; j++){ //Imprime los numeros antes del centro de cada fila (2*i-1)
            cout<<j%10; //Permite imprimir cifras de 0-9
        }
        for (int j=2*i-1; j>=i; j--){ //Imprime los numeros despues del centro de cada fila.
            cout<<j%10; //Permite imprimir cifras de 0-9
        }
        cout<<endl;
    }

    return 0;
}


/*
INPUT:
Ingrese el valor de n: 

OUTPUT:
Primer for anidado: Imprime los numeros antes del centro de cada fila.
2        
34       
456      
5678     
67890    
789012   
8901234  
90123456 
012345678

Segundo for anidado: Imprime los numeros despues del centro de cada fila, incluye al numero central.
1      
32
543
7654
98765
109876
3210987
54321098
765432109
9876543210
*/



/*
#include <iostream>
using namespace std;
int main(){
	int longitud;
	cout << "Longitud: "; cin >> longitud;
	for(int i=1; i<=longitud; i++){
		for(int j=i; j<2*i-1; j++){
			printf("%d", j%10);
			//cout << j%10;
		}
		for(int j=2*i-1; j>=i; j--){
			printf("%d", j%10);
			//cout << j%10;
		}
		cout << endl;
	}
	return 0;
}
*/