import heapq
import networkx as nx

# Función para implementar el algoritmo de Prim
def prim_max(graph, start_node):
    mst = []  # Lista para almacenar los bordes del MST
    visited = set([start_node])  # Conjunto para rastrear los nodos visitados
    edges = [(-weight, start_node, to) for to, weight in graph[start_node].items()]
    heapq.heapify(edges)  # Convertir la lista de bordes en un montón de prioridad
    max_sum = 0
    while edges:
        weight, frm, to = heapq.heappop(edges)
        weight = -weight
        if to not in visited:
            visited.add(to)
            mst.append((frm, to, weight))
            max_sum += weight
            for next_to, next_weight in graph[to].items():
                if next_to not in visited:
                    heapq.heappush(edges, (-next_weight, to, next_to))

    return mst, max_sum

def prim_min(graph, start_node):
    mst = []  # Lista para almacenar los bordes del MST
    visited = set([start_node])  # Conjunto para rastrear los nodos visitados
    edges = [(weight, start_node, to) for to, weight in graph[start_node].items()]
    heapq.heapify(edges)  # Convertir la lista de bordes en un montón de prioridad
    min_sum = 0
    while edges:
        weight, frm, to = heapq.heappop(edges)
        if to not in visited:
            visited.add(to)
            mst.append((frm, to, weight))
            min_sum += weight
            for next_to, next_weight in graph[to].items():
                if next_to not in visited:
                    heapq.heappush(edges, (next_weight, to, next_to))

    return mst, min_sum

# Crear un grafo utilizando networkx
G = nx.Graph()
G.add_weighted_edges_from([
    ('A', 'B', 10),
    ('A', 'C', 39),
    ('B', 'C', 11),
    ('B', 'D', 45),
    ('C', 'D', 28),
    ('D', 'E', 22),
    ('C', 'E', 51)
])

# Convertir el grafo de networkx a un diccionario de listas de adyacencia con pesos
graph = {node: {neighbor: G[node][neighbor]['weight'] for neighbor in G[node]} for node in G.nodes()}

# Nodo de inicio para el algoritmo de Prim
start_node = 'A'

# Encontrar el MST utilizando el algoritmo de Prim
mst,max_sum = prim_max(graph, start_node)
#mst,min_sum = prim_min(graph, start_node)

#print("Minimum Spanning Tree:", mst)
#print("Suma minima:", min_sum)

print("Arbol de expansion maxima:", mst)
print("Suma maxima:", max_sum)

