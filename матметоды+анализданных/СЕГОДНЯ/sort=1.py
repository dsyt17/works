#import operator
from random import randint 
from operator import itemgetter, attrgetter, methodcaller
s = [[randint(1,100) for j in range(3)] for i in range(4)]
for i in range(4):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*30)

s1 = s
s1.sort(key = lambda st: st[0])
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')
s1 = s
s1.sort(key = lambda st: st[1])
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')
s1 = s
s1.sort(key = lambda st: st[2])
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')

print('='*30)
s1 = s
s1.sort(key = itemgetter(0))
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')
s1 = s
s1.sort(key = itemgetter(1))
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')
s1 = s
s1.sort(key = itemgetter(2))
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')

def st(vvs):
    return vvs[1]
print(st([1,2,3]))
s1 = s
s1.sort(key = st)
for i in range(4):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-------------------------------')














