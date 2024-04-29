/*
Generar dos numeros aleatorios entre 10 y 20 y calcular el el mayor. Todo utilizando punteros
*/
#include <iostream>
#include <ctime>
using namespace std;
int main(){
	srand(time(NULL));
	// Variables por cada dato a procesar
	int num1;
	int num2;
	// Un puntero por cada variables a procesar
	int* ptr1;
	int* ptr2;
	// Asignas a cada punteros, la direccion de memoria de la variable que le corresponde
	ptr1 = &num1;
	ptr2 = &num2;
	
	// Operar con punteros (*ptr)-> acceso al valor
	
	int min = 10, max = 20;
	*ptr1 = rand()%(max-min+1)+min;
	*ptr2 = rand()%(max-min+1)+min;
	
	cout << "Valor 1: " << *ptr1 << endl;
	cout << "Valor 2: " << *ptr2 << endl;
	
	if(*ptr1 > *ptr2){
		cout << *ptr1 << " es el valor mayor" << endl;
	}else if(*ptr1 < *ptr2){
		cout << *ptr2 << " es el valor mayor" << endl;
	}else{
		cout << "Ambos son iguales" << endl;
	}
	
	return 0;
}
