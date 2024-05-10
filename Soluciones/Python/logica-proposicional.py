from itertools import product

# [(p and q) ifthen (r or not p)] and r

def ifthen(a, b)-> bool:
    return not a or b

def biconditional(a, b)-> bool:
    return ifthen(a, b) and ifthen(b, a)

def xor_logico(a, b)-> bool:
    return a != b

lista_valores = []
def evaluar(lista)-> str:
    verdadero = False
    falso = False
    for elemento in lista:
        if elemento:
            verdadero = True
        else:
            falso = True

    if verdadero and falso:
        return "Contingencia"
    elif verdadero:
        return "Tautología"
    elif falso:
        return "Contradicción"


for P, Q, R in product((True, False), repeat=3):
    lista_valores.append(ifthen((P and Q), (R or not P)) and R)
    print(f"[({str(P):<5} and {str(Q):<5}) -> ({str(R):<5} or not {str(P):<5})] and {str(R):<5} is {ifthen((P and Q), (R or not P)) and R}")

print(f"La proposicion es una {evaluar(lista_valores)}")
