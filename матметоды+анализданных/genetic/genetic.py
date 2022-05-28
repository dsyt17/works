# 20 хромосом(особей) по 30 бит, редуцировать до 10 потомков
import random

individual = 20 #хромосомы(особи)
count = 30 #число генов
individuals = [[random.randint(0,1) for i in range(count)] for j in range(individual)] #популяция

#фитнес функция (сумма генов)
def fitness(ind,cnt):
    f = 0
    for i in range(cnt):
        f+=ind[i]
    return f


F = [] #суммы генов по особям
sum = 0 # общая сумма генов

for i in individuals:
    result = fitness(i,count)
    sum+=result
    F.append(result)

dolya = [ind/sum for ind in F] #доля генов каждой особи от общего числа генов

acc_dolya = [dolya[0]] #накопленная доля

#ее заполнение
for i in range(individual-1):
    acc_dolya.append(acc_dolya[i]+dolya[i+1])

roulette = random.random() #случайное число 0-1
print(roulette)

saved_pos = 0 #
for i in range(individual-1):
    if(roulette>acc_dolya[i] and roulette<acc_dolya[i+1]):
        saved_pos = i
        break
print(roulette, saved_pos)
