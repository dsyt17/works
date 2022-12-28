import numpy as np

# для теста данные и веса из файла крокодайлы
data = np.array([[130, 94],
[51, 74],
[640, 147],
[28, 58],
[80, 86],
[110, 94],
[33, 63],
[90, 86],
[36, 69],
[38, 72],
[366, 128],
[84, 85],
[80, 82],
[83, 86],
[70, 88],
[61, 72],
[54, 74],
[44, 61],
[106, 90],
[84, 89],
[39, 68],
[42, 76],
[197, 114],
[102, 90],
[57, 78]])
test_weights = np.array([[0.05, 0.06, 0.07], [0.08, 0.09, 0.04]])

# векторная длина крокодила
def get_length(croko):
    return (croko[0]**2+croko[1]**2)**0.5

# нормированные показатели длины и веса
def get_normalized_croko(croko):
    croko_length = get_length(croko)
    return np.array([croko[0]/croko_length, croko[1]/croko_length])

# получаем слечайные веса
def get_weights():
    # можно менять максимальное и минимальное значение
    return np.random.uniform(low=0.01, high=0.09, size=(2, 3))

# векторная длина весов
def get_weights_lengths(weights):
    lenghts = np.array([])
    for i in range(3):
        lenghts = np.append(lenghts, (weights[0][i]**2 + weights[1][i]**2)**0.5)
    return lenghts

# нормируем полученные веса
def get_weights_normalized(weights):
    lenghts = get_weights_lengths(weights)
    n_w1, n_w2 = np.array([]), np.array([])
    for i in range(3):
        n_w1 = np.append(n_w1, weights[0][i]/lenghts[i])
        n_w2 = np.append(n_w2, weights[1][i]/lenghts[i])
    return np.vstack((n_w1, n_w2))

def activation(croko):
    predicts = np.array([])
    for i in range(3):
        # все как в примере из экселя
        predicts = np.append(predicts, 
        croko[0]*weights_normalized[0][i]+
        croko[1]*weights_normalized[1][i]
        )

    # максимальное значение из полученных трех - нужный кластер
    cluster_index = np.where(predicts == (np.max(predicts)))[0][0]

    # обновляем веса в зависимости от полученного кластера
    weights_normalized[0][cluster_index] = weights_normalized[0][cluster_index] + 0.5*(croko[0]-weights_normalized[0][cluster_index])
    weights_normalized[1][cluster_index] = weights_normalized[1][cluster_index] + 0.5*(croko[1]-weights_normalized[1][cluster_index])

    print(cluster_index+1)
    return cluster_index


weights = get_weights()
weights_normalized = get_weights_normalized(test_weights) # для примера взяты тестовые

for i in range(len(data)):
    croko = get_normalized_croko(data[i])
    activation(croko)
