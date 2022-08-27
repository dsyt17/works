import itertools as it

s = ['1', '2', '3', '4']
s1 = ['1', '2', '2', '4']
counter = 1

print('Перестановки:', s)
for i in it.permutations(s):
    print(str(counter)+'.', i, end=' \n')
    counter +=1
counter = 1

print('\nПерестановки без повторений(элементов): ', s1)
for i in set(it.permutations(s1)):
     print(str(counter)+'.', i, end=' \n')
     counter +=1
counter = 1

print('\nРазмещения без повторений: ', s)
for i in it.combinations(s, 2):
     print(str(counter)+'.', i, end=' \n')
     counter +=1
counter = 1

print('\nСочетания c повторениями: ', s)
for i in it.combinations_with_replacement(s, 2):
     print(str(counter)+'.', i, end=' \n')
     counter +=1