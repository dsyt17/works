A = []
with open('страны=города=295.txt') as f:
    A = f.read().splitlines()

counter = {}

for elem in A:
    counter[elem] = counter.get(elem, 0) + 1

doubles = {element: count for element, count in counter.items() if count > 1}

print(doubles)