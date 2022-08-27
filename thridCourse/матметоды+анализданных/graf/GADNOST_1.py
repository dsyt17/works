n_graph = 4
graph = [[0,5,6,8],[5,0,7,10],[6,7,0,3],[8,10,3,0]]
print('граф    ',graph)
def min_scan (v, l_v):
    min = 100000
    for j in l_v:
        if graph[v][j]< min:
            min_n = j
            min = graph[v][j]
    return min_n

for i in range(0,4):
    vert = [vу for vу in range(0,4)]
    v_current = i
    path = [v_current]
    len_path = 0
    
    for j in range(0,3):
        vert.remove(v_current)
        s = min_scan(v_current,vert)
        path += [s]
        len_path += graph[v_current][s]
        v_current = s
         
    path += [i]
    len_path = len_path + graph[v_current][i]
    print('*',' path ',path, len_path) 


