import random as rnd
from itertools import accumulate 
N = 5

dia1 = [i for i in range(0,N)]
dia2 = [i for i in range(0,N)]
wheel = [0.2,0.2,0.2,0.2,0.2]
wheel_s = list(accumulate(wheel))
print(wheel, wheel_s)
for sss in range (0,1000000):
    
    case1 = rnd.uniform(0.00001,0.99999)
    case2 = rnd.triangular()
    #print(case)
    for j in range(0,N):
        if case1 < wheel_s[j]:
            k = j
            dia1[k] += 1
            break
    for j in range(0,N):
        if case2 < wheel_s[j]:
            k = j
            dia2[k] += 1
            break

#print(k, dia[k])
[print("{0: >10}".format(dia1[i]),end='') for i in range(0,N)]
print()
[print("{0: >10}".format(dia2[i]),end='') for i in range(0,N)]


    
    

