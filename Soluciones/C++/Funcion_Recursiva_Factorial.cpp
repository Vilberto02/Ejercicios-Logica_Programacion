#include <iostream>
//Prototipo de funciones.
double factorial(int dato);
void entrada(int &number);
//Programa principal
int main (){
    int number;
    printf("\tFACTORIAL DE UN NUMERO\n");
    //Llamada a la funcion entrada para que el usuario ingrese los datos.
    entrada(number);
    //Verifica si el numero ingresado es mayor a cero.
    if (number>=0){
        printf("-> Factorial: %.2f", factorial(number));
    } else{
        printf("Error! No existe factorial de un numero negativo");
    }
    return 0;
}
//Declaracion de funciones
void entrada (int &number){
    //Solicita un numero al usuario.
    printf("Ingrese un numero entero: ");
    scanf("%d", &number);
}
//Funcion recursiva
double factorial (int dato){
    double fact = 1.00;
    //Halla el factorial de un numero utilizando la misma funcion. 
    if (dato == 0 || dato == 1){
        fact = 1.00;
    } else {
        fact = dato*factorial(dato - 1.00);
    }
    return fact;
}