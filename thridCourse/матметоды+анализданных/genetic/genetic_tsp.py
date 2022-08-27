import random as rnd
import itertools as it

population = 20 #число особей (N=20), оно же число генов для ЗК
num_selected = 2 #оставить столько особей (ДВА МАРШРУТА ЗК)


# создаем матрицу расстояний (особей) из файла by29 урезанного до 20 вершин
with open('by29(n=20).csv', 'r') as file:
        data = file.readlines()
distance_matrix = []
for r in data: # построчно считываем в список
        row = [int(item) for item in r.strip().split() if item.isdigit()]
        distance_matrix.append(row)


print("Число особей (городов): ", len(distance_matrix))


# подсчет генов(суммы расстояний от выбранного города до других)
distance_fit = [sum(distance_matrix[i]) for i  in range(population)]
print("Сумма генов особей (расстояний): ", distance_fit)


# выбираем случайные пары
crossing = [rnd.sample(distance_matrix, 2) for i in range(0, 5)]
print("Выбрано пар для скрещивания: ", len(crossing))


# одноточечное скрещивание (не нашел достаточно информации про GSX, но кажется похоже)
for pair in crossing:
    l = rnd.randint(1, 29)
    distance_matrix.extend([pair[0][:l]+pair[1][l:], pair[1][:l]+pair[0][l:]])
print("Число особей после скрещивания (одноточечное скрещивание): ", len(distance_matrix))


# функция дле генерации двух случайных индексов генов для замены при мутации
def rand_genes():
    result = []
    m1, m2 = rnd.randint(0, 19), rnd.randint(0, 19)
    while m2 == m1: # добиваемся различия сгенерированных чисел
        m2 = rnd.randint(0, 19)
    result.extend([m1, m2])
    return result


# вероятность мутации
p_mutation = rnd.uniform(0.1, 0.3)
print("Вероятность мутации: {:.2f}".format(p_mutation))


# мутация обменом
count_m = 0
for p in range(20, 30):
    rand_p = rnd.random()
    if p_mutation > rand_p:
        genes_to_swap = rand_genes()
        temp_g1, temp_g2 = distance_matrix[p][genes_to_swap[0]], distance_matrix[p][genes_to_swap[1]]

        while temp_g2 == temp_g1: # добиваемся замены разных генов (по значению)
            genes_to_swap = rand_genes()
            temp_g1, temp_g2 = distance_matrix[p][genes_to_swap[0]], distance_matrix[p][genes_to_swap[1]]

        print("Для особи №{} меняем гены {} и {}: ".format(p, genes_to_swap[0], genes_to_swap[1]))
        print("Было:  ", distance_matrix[p])
        distance_matrix[p][genes_to_swap[0]], distance_matrix[p][genes_to_swap[1]] = temp_g2 ,temp_g1
        print("Стало: ", distance_matrix[p], "\n")
        count_m += 1
print("Мутировала {} особь(ей)".format(count_m), "\n")


# новый подсчет генов
distance_fit = [sum(distance_matrix[i]) for i  in range(len(distance_matrix))]
distance_fit.sort(reverse=True)
print("Сортированная сумма генов новых особей: ", distance_fit)
print(len(distance_fit))


# задаем список рангов для отбора
ranks = []
for i in range(1, (len(distance_fit)+1)):
    ranks.append(i)


# меняем знак фитнесс функций, чтобы самые маленькие значения стали самыми большими, 
# так как они предпочтительнее при отборе
for elem in range(len(distance_fit)):
    distance_fit[elem] = -distance_fit[elem]
distance_fit.sort()


# ранжированный отбор
doli = [i/sum(ranks) for i in range(1, (len(distance_fit))+1)] # доли рангов
selected = []
acc = list(it.accumulate(doli)) # накопленные доли
for j in range(num_selected): # num_selected = 2 (столько особей оставляем)
    rand = rnd.random()
    for i in range(len(acc)):
        if rand<=acc[i]:
            selected.append(i)
            #acc.remove(acc[i])            
            acc[i] = 0
            break

selected.sort()
print("Выбранна(ны) {} особь(ей), их индексы {}".format(len(selected), selected))