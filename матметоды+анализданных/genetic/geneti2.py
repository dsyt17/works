import random as rnd

genes = 30 #число генов
population = 20 #число особей

#создаем особей
s = [[rnd.randint(0,1) for i  in range(genes)] for j in range(population)]
print("Число особей: ", len(s))

#подсчет генов
s_fit = [sum(s[i]) for i  in range(population)]
print("Сумма генов особей: ",s_fit)

#вероятность мутации
p_mutation = rnd.uniform(0.1, 0.3)
print("Вероятность мутации: {:.2f}".format(p_mutation))

#выбираем случайные пары
selected = [rnd.sample(s, 2) for i in range(0, 5)]
print("Выбрано пар для скрещивания: ", len(selected))

#скрещивание
for pair in selected:
    l = rnd.randint(1, 29)
    s.append(pair[0][:l]+pair[1][l:])
    s.append(pair[1][:l]+pair[0][l:])
print("Число особей после скрещивания: ", len(s))

#функция дле генерации двух случайных индексов генов для замены
def rand_genes():
    result = []
    m1 = rnd.randint(0, 29)
    m2 = rnd.randint(0, 29)
    while m2 == m1:
        m2 = rnd.randint(0, 29)
    result.append(m1)
    result.append(m2)
    return result

p_m = 0.2

#мутация обменом
for p in range(20, 30):
    rand_p = rnd.random()
    if p_m > rand_p:
        genes_to_swap = rand_genes()
        temp_g1 = s[p][genes_to_swap[0]]
        temp_g2 = s[p][genes_to_swap[1]]

        while temp_g2 == temp_g1:
            genes_to_swap = rand_genes()
            temp_g1 = s[p][genes_to_swap[0]]
            temp_g2 = s[p][genes_to_swap[1]]

        print("Для особи №{} меняем гены: ".format(p), genes_to_swap[0], genes_to_swap[1])
        print("Было:  ", s[p])
        s[p][genes_to_swap[0]] = temp_g2
        s[p][genes_to_swap[1]] = temp_g1
        print("Стало: ", s[p], "\n")

#новый подсчет генов
s_fit = [sum(s[i]) for i  in range(len(s))]
print("Сумма генов особей: ", s_fit)

#ранжированный отбор
#for i in range(20):
    