import random

random.seed(1)

input_set = []
for i in range(100):
    input_set.append([random.random(), random.random()])
    
output_set = []
for i in range(100):
    output_set.append((input_set[i][0] + input_set[i][1])/2)

weights = [random.uniform(0, 1), random.uniform(0, 1)]
print('Weights: ',weights)

for iteration in range(4):
    for i in range(100):
        output = weights[0]*input_set[i][0] + input_set[i][1]*weights[1]
        weights[0] = weights[0] + weights[0]*(output_set[i]-output)*input_set[i][0]
        weights[1] = weights[1] + weights[1]*(output_set[i]-output)*input_set[i][1]
    #print(output,weights) 

test = [100, 50]
test[0]=test[0]*weights[0]
test[1]=test[1]*weights[1]
print('result: ', test[0]+test[1])

