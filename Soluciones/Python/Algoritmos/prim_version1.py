

# n: numero de vertices
# s: vertice inicial
# w: peso de una arista si existe una arista entre (i,j)
def algoritmo_prim(w,n,s):
    v = [] # vertice
    while (len(v) != n):
        v.append(0)
    v[s] = 1
    E = [] # conjunto de aristas
    suma = 0
    for i in range(0, n-1):
        minimo = 9 # Infinito
        for j in range(0,n):
            if v[j] == 1:
                for k in range(0,n):
                    if v[k] == 0 and w[j][k] < minimo:
                        agregar_vertice = k
                        e = [j,k]
                        minimo = w[j][k]
        suma += w[e[0]][e[1]]
        v[agregar_vertice] = 1
        E.append(e)
    return [E,suma]

n = 6
s = 0 # 1 - 1 = 0
w = [#1,2,3,4,5,6
    [9,4,2,9,3,9], #1
    [4,9,9,5,9,9], #2
    [2,9,9,1,6,3], #3
    [9,5,1,9,9,6], #4
    [3,9,6,9,9,2], #5
    [9,9,3,6,2,9], #6
]
# 9 == infinito (no existe)
    

print(algoritmo_prim(w,n,s))