import itertools
graph = [[0,5,6,8],[5,0,7,10],[6,7,0,3],[8,10,3,0]]
n_graph = 4
print(graph)
dist_min = 100000
path_min = []

points = [i for i in range(n_graph)]
for i in itertools.permutations(points):
    print(i)
    s = 0.0
    ls = list(i)
    ls += [ls[0]]
    for v in range(0,n_graph):
        s += graph[ls[v]][ls[v+1]]
    print(s)
    if s < dist_min:
        dist_min = s
        path_min = ls
print(dist_min, '    ', path_min)


