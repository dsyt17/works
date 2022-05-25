from random import randint 
from operator import itemgetter, attrgetter, methodcaller
s = [['green', 100, 200],['red',150,300],
     ['red',120,210],['yellow',230,320],['green',110,300],
     ['black',170,200],['black',120,210],['black',170,300]]
for i in range(8):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*40)

print('='*40)
s1 = s
s1.sort(key = itemgetter(0,2))
for i in range(8):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('-'*40)
s1 = s
s1.sort(key = itemgetter(2,0))
for i in range(8):
    [print (f"{s1[i][j]:8}",end='') for j in range(3)]
    print()
print('*'*40)

s = [['green1', 100, 200],['red1',150,300],
     ['red2',120,210],['yellow',230,320],['green2',110,300],
     ['black1',170,200],['black2',120,210],['black3',170,300]]

for i in range(8):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*40)
s.sort(key = itemgetter(2,1,0))
for i in range(8):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*40)

print('='*40)
s.sort(key = lambda p: p[2] + p[1])
for i in range(8):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*40)


print('='*40)
s.sort(key = lambda p: (p[2] + p[1])/2)
for i in range(8):
    [print (f"{s[i][j]:8}",end='') for j in range(3)]
    print()
print('='*40)

print(sum([1,2,3]))
w = 0.2
w1 = 1/5
print (f"{w:25.32f}",f"{w1:25.32f}")












