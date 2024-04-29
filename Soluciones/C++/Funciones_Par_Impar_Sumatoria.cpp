/*
Dado un numero entero positivo n, imprimir los siguientes resultados:
- Indicar si n es par o impar (OK)
- Sumar los enteros positivos menores e iguales que n (OK)
- Duplicar el valor de n utilizando una funcion con paso de parametros por referencia (OK)
- Calcular el factorial de n (tradicional y recursiva) (OK)
*/
#include <iostream>
using namespace std;
bool analizar_paridad(int n){
	if(n%2 == 0){
		return true;
	}else{
		return false;
	}
}
int sumar_enteros(int n){
	int acum = 0;
	for(int i=1; i<=n; i++){
		acum += i;
	}
	return acum;
}
void duplicar_numero(int &n){
	n = 2*n;
}
int calcular_factorial(int n){
	int prod = 1;
	if(n>0){
		for(int i=1; i<=n; i++){
			prod = prod*i; // prod *= i;
		}
		return prod;
	}else if(n==0){
		return 1;
	}
}
int calcular_factorial_rec(int n){
	if(n == 0){
		return 1;
	}else if(n == 1){
		return 1;
	}else{
		return n*calcular_factorial_rec(n-1);
	}
}
int main(){
	int n; n=2;
	// Analisis de paridad
	if(analizar_paridad(n) == true) printf("El numero %d es PAR\n", n);
	else printf("El numero %d es IMPAR\n", n);
	// Calculo de la suma de los n primeros numeros enteros positivos
	printf("La suma del 1 hasta %d es: %d\n", n , sumar_enteros(n));
	// Duplicado el valor de n utilizando una funcion con paso de parametros por referencia
	printf("n: %d\n", n);
	duplicar_numero(n);
	printf("n: %d\n", n);
	// Calculo del factorial
	printf("%d!: %d\n", n, calcular_factorial(n));
	printf("%d!: %d\n", n, calcular_factorial_rec(n));
	return 0;
}
