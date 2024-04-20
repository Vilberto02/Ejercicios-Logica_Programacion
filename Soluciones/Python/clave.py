import numpy as np

digitos = [0,1,2,3,4,5,6,7,8,9]

clave = np.random.choice(digitos, size = (4,))
cadena_concatenada = "".join([str(numero) for numero in clave])
print(clave)
print(cadena_concatenada)
control = True
contador = 3
print("Adivina la clave del candado: Solo tienes 3 intentos")
while(control):
    clave_usuario = int(input("Ingrese la clave: "))
    if clave_usuario == int(cadena_concatenada):
        print(f"-> El candado esta abierto. Se demoro {contador} veces en encontrar la clave.")
        control = False
    else:
        control = True
        contador -= 1
        if (contador == 0):
            print("-> Completaste tus 3 intentos.")
            control = False
        else:
            print(f"Clave incorrecta. Solo tienes {contador}")
