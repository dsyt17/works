import csv
import string

with open('irisy.csv') as data:
    for row in data.readlines():
        row.replace(',', '.')
    data = [list(map(int, row.split())) for row in data.readlines()]

print(data)