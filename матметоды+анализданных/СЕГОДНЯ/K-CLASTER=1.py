import csv
from random import randint 
s = [] # в этот список списков считываются данные из файла
k = 3 # количество кластеров
def ltol(a): # переводит в списке а первые 4 элемента в числовой формат
    return [float(a[ii]) for ii in range(4)]

def distance(s1,s2): # вычисляет квадрат расстояния
    d = 0
    for si,sj in zip(s1,s2):
        d += (si-sj)**2
    return d

# формируем список s из файла, переводя в числовой формат
with open("IRIS.DATA", 'r') as fin:
    cin = list(csv.reader(fin))
    for line in cin[:-1]:
        s.append(ltol(line)+[line[4]]+[0])
# перемешиваем данные, отсортировав список s по 2 столбцу
s.sort(key = lambda st: st[1])

# случайный выбор центров
p = [randint(50*i,50*(i+1)-1) for i in range(k)]
cl_center = [s[p[i]][:-2] for i in range(k)]
print('=========================================')
print('начинается цикл')

while True:
    # находим номер кластера до которого расстояние минимально от текущего цветка
    # и записываем его в список s[i] последним элементом
    print('centers')
    for i in range(k):
        [print(f"{cl_center[i][j]:8.4f}",end=' ') for j in range(4)]
        print()
    for i in range(150):
        dd = [distance(s[i][:-2],cl_center[j]) for j in range(k)]
        minimum = min(list(enumerate(dd, 0)), key=lambda i : i[1])
        s[i][-1] = minimum[0] # записываем номер кластера в последний элемент s
    sum = [[0 for t in range(4)] for i in range(k)]
    sum_n = [0 for i in range(k)]
    for i in range(150): # по очереди рассматриваем каждый цветок
    #  s[i][-1] - номер кластера
        sum_n[s[i][-1]] +=1 # количество цветков в каждом кластере
        for j in range(4): 
            sum[s[i][-1]][j] += s[i][j]
    for i in range(k):
        if sum_n[i] != 0:
            for j in range(4):
                sum[i][j] = sum[i][j]/sum_n[i]
    print(sum_n)
    eps = [[abs(sum[i][j]-cl_center[i][j]) for j in range(4)] for i in range(k)]
    print('eps')
    for i in range(k):
        [print(f"{eps[i][j]:8.4f}",end=' ') for j in range(4)]
        print()
    if all([eps[i][j] < 0.001 for i in range(k) for j in range(4)]):
        break
# назначаем новые центры
    cl_center = sum
# -------------------

# отсортировав список s по 6 столбцу -- по номерам кластеров
s.sort(key = lambda st: st[5])
[print(s[i]) for i in range(150)]
# записываем результаты кластеризации в файл
fout = open('iris1.txt', 'w')
iris = csv.writer(fout,lineterminator='\n')
iris.writerows(s)
fout.close()








