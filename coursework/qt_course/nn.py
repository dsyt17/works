import numpy as np
import keras
import cv2

import os
os.environ["CUDA_VISIBLE_DEVICES"] = "-1"

model = keras.models.load_model(r'models/pneumo_model1.h5')

# загрузка изображений
def predict(path):

    pred_img = []
    img = cv2.imread(path)
    img = cv2.resize(img, (224, 224))
    if img.shape[2] == 1:
        img = np.dstack([img, img, img])
    else:
        img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    img = img.astype(np.float32) / 255.
    pred_img.append(img)

    images = np.array(pred_img)

    result = []

    for img in images:
        predictions_single = model.predict(images)

        h = predictions_single[0][0]
        s = predictions_single[0][1]
        result.append(h)
        result.append(s)

        return result


