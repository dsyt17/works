import csv

f_out = open('c:\\pr==py\\prob1.txt', 'w')
s = [[1,2,3,'a'],[2,3,4,'b'],[3,4,5,'c'],[3,4,5,'d']]
iris = csv.writer(f_out,lineterminator='\n')
iris.writerows(s)
f_out.close()

s = []
#  из файла
with open('c:\\pr==py\\prob1.txt', 'r') as f_in:
    cin = csv.reader(f_in) #итерируемый объект
    for line in cin: #каждый элемент этого объекта -- список строк
       print(type(line),line)
