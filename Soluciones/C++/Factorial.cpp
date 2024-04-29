#include<iostream>
int main (){
    int number;
    double fact = 1;
    printf("\tFACTORIAL DE UN NUMERO");
    printf("\nIngrese un numero entero: ");
    scanf("%d", &number);
    
    if (number<0){
        printf("Error! No existe factorial de un numero negativo\n");
    } else {
        if (number == 0 || number == 1){
            fact = 1;
        } else {
            for (int i = number; i>0; i--){
                fact = fact*i;
            }
        }
        printf("-> Factorial: %.2f", fact);
    }
}