import itertools
graph = [[0,0],[0,1],[1,1],[1,0]]
n_graph = 4
print(graph)
dist_min = 100000
path_min = []
def dist(x1, y1,x2, y2):     
        dist = ((x1-x2)**2 + (y1-y2)**2)**0.5
        return dist

points = [i for i in range(n_graph)]
for i in itertools.permutations(points):
    print(i)
    s = 0.0
    ls = list(i)
    ls += [ls[0]]
    for v in range(0,n_graph):
        s += dist(graph[ls[v]][0],graph[ls[v]][1],graph[ls[v+1]][0],graph[ls[v+1]][1])
    print(s)
    if s < dist_min:
        dist_min = s
        path_min = ls
print(dist_min, '    ', path_min)


