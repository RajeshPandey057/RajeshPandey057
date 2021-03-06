parent = dict()
rank = dict()

def make_set(vertice):
    parent[vertice] = vertice
    rank[vertice] = 0

def find(vertice):
    if parent[vertice] != vertice:
        parent[vertice] = find(parent[vertice])
    return parent[vertice]

def union(vertice1, vertice2):
    root1 = find(vertice1)
    root2 = find(vertice2)
    if root1 != root2:
        if rank[root1] > rank[root2]:
            parent[root2] = root1
        else:
            parent[root1] = root2
    if rank[root1] == rank[root2]: rank[root2] += 1

def kruskal(graph):
    global edges, minimum_spanning_tree
    for vertice in graph['vertices']:
        make_set(vertice)
        minimum_spanning_tree = set()
        edges = list(graph['edges'])
        edges.sort()#print edges
    for edge in edges:
        weight, vertice1, vertice2 = edge
        if find(vertice1) != find(vertice2):
            union(vertice1, vertice2)
            minimum_spanning_tree.add(edge)
	    
    return sorted(minimum_spanning_tree)

graph = {
'vertices': ['A', 'B', 'C'],
'edges': {(7, 'A', 'B'), (7, 'B', 'A'), (8, 'B', 'C'), (8, 'C', 'B')}
}

print(kruskal(graph))
