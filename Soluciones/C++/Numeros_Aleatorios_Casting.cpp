/*
Generar dos numeros enteros aleatorios que esten entre 10 y 20, ambos inclusive
y mostrar los siguientes resultados
- Mostrar los numeros (OK)
- Mostrar el numero que resultaria si concateramos el primer numero con el segundo (OK)
- Duplicar el valor numerico de un string. Dicho string tiene un dato decimal (OK)
*/
#include <iostream>
#include <string>
#include <time.h>
using namespace std;
void generar_dos_enteros_random(int &n1, int &n2, int min, int max){
	n1 = rand()%(max-min+1) + min;
	n2 = rand()%(max-min+1) + min;
}
int concatenar_numeros(int n1, int n2){
	string salida_str;
	int salida;
	salida_str = to_string(n1)+to_string(n2);
	salida = stoi(salida_str);
	return salida;
}
float duplicar_numero(string valor_str){
	float valor;
	valor = stod(valor_str);
	return 2*valor;
}
int main(){
	srand(time(NULL));
	int min, max; min=10, max=20;
	int n1, n2;
	// Generacion de los enteros aleatorios
	generar_dos_enteros_random(n1, n2, min, max);
	printf("n1: %d\n", n1);
	printf("n2: %d\n", n2);
	// Concatenado de numeros usando casnting de datos
	printf("Resultado del concatenado: %d\n", concatenar_numeros(n1, n2));	
	// Duplicado de un decimal ingresado como texto
	string cad = "3.14";
	printf("Valor a procesar: ");
	cout << cad << endl;
	printf("Duplicado del valor: %.2f\n", duplicar_numero(cad));
	return 0;
}
