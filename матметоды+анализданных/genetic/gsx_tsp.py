import random

def generate_parents(n_parents, n_genes):
    parents_list = []
    for i in range (n_parents):
        p = [i+1 for i in range (n_genes)] 
        random.shuffle(p)
        parents_list.append(p)
    return parents_list

def gsx_crossover(num_genes: int, num_parents: int) -> list:
    "Число генов, число родителей (желательно 20 и 2)"

    counter = 1
    gsx = [] # результаты скрещивания

    parent = generate_parents(num_parents, num_genes) # генерируем родителей
    print("Сгенерированны {} родителя c {} генами:".format(num_parents, num_genes))

    for i in range(num_parents): # печатаем родителей
        print("{}.".format(i+1), parent[i])

    n = random.randint (1,20)   # число для начала скрещивания
    gsx.insert(0,n)             # добавляем его с список для скрещивания

    # находим индексы этого числа в родителях
    index0 = 0
    index1 = 0
    for i in range(num_genes):
        if parent[0][i] == n: 
            index0 = i
        if parent[1][i] == n: 
            index1 = i

    print("Случайное число для скрещивания:", n)
    print("Его позиции в списках: {} и {} соответственно\n".format(index0,index1))
    print("Начинаем скрещивание GSX:")

    f1 = 0 # f1 и f2 нужны для храниния состояний
    f2 = 0

    # добавляем в список gsx результат скрещивания пока не закончится список или не найдется одинаковое число
    while f1 !=1 or f2 !=1:
        
        # проверка индекса
        if index0 - counter >= 0:
            # проверка на одинаковое число из списка gsx
            for i in range (len(gsx)):
                if parent[0][index0 - counter] == gsx[i]: 
                    f1 = 1
            if f1 != 1: # если f1 !=1, тогда в начало листа перезаписывается число из первого листа
                gsx.insert(0,parent[0][index0 - counter])
                print(gsx)
        else: f1 = 1

        if index1 + counter < 20:
            # проверка на одинаковое число из списка gsx
            for i in range (len(gsx)):
                if parent[1][index1 + counter] == gsx[i]:
                    f2 = 1
            if f2 != 1: # если f2 !=1, тогда в конец листа записывается число из второго листа
                gsx.append(parent[1][index1 + counter]) 
                print(gsx)
        else: f2 = 1
        counter +=1

    # добавляем оставшиеся числа в конец списка
    for i in range(num_genes):
        f1 = 0
        for j in range (len(gsx)):
            if parent[0][i] == gsx[j]:
                f1 = 1
        if f1 == 0:
            gsx.append(parent[0][i])
    print("\nРезультат после добавления оставшихся чисел:")
    print(gsx)
    return gsx

if __name__ == '__main__':
    gsx_crossover(20, 2)