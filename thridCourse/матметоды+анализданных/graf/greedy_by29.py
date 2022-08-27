import csv

with open('by29.csv') as matrix:
    matrix = [list(map(int, row.split())) for row in matrix.readlines()]

def min_scan (v, l_v):
    min = 100000
    for j in l_v:
        if matrix[v][j]< min:
            min_n = j
            min = matrix[v][j]
    return min_n

pathId = 1   
minLen = 100000  

for i in range(0,29):
    vert = [vу for vу in range(0,29)]
    v_current = i
    path = [v_current]
    len_path = 0
    
    for j in range(0,28):
        vert.remove(v_current)
        s = min_scan(v_current,vert)
        path += [s]
        len_path += matrix[v_current][s]
        v_current = s
  
    path += [i]
    len_path = len_path + matrix[v_current][i]

    if (minLen > len_path):
        minLen = len_path
        minPath = pathId

    print(pathId,' path ',path, len_path) 
    pathId +=1

print("Минимальная длина: ", minLen, " у пути №", minPath)