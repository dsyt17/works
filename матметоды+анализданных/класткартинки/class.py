#import matplotlib
import matplotlib.pyplot as plt
path_to_png_file = r"0102.png "
import matplotlib.image as mpimg
# оригинальный рисунок
img = mpimg.imread (path_to_png_file )
print(img.shape)
for i in range(img.shape[0]):
    for j in range(img.shape[1]):
        d = (img[i][j][0]+img[i][j][1]+img[i][j][2])/3
        img[i][j] =[d,d,d]
plt.imshow(img)
plt.axis('off')
plt.show( )
# в серых тонах
for i in range(img.shape[0]):
    for j in range(img.shape[1]):
        d = (img[i][j][0]+img[i][j][1]+img[i][j][2])/3
        img[i][j] =[d,d,d,1]
plt.imshow(img)
plt.axis('off')
plt.show( )
# негатив от серого
for i in range(img.shape[0]):
    for j in range(img.shape[1]):
        a = 1 - img[i][j][0]
        b = 1 - img[i][j][1]
        c = 1 - img[i][j][2]
        img[i][j] =[a,b,c, 1]
plt.imshow(img)
# plt.axis('off')
plt.show( )
