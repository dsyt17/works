import csv

with open('by29.csv') as matrix:
    matrix = [list(map(int, row.split())) for row in matrix.readlines()]

print(matrix)