# Igor Goncharov, 131-PIo, SGU
# 0.1.0

from PyQt5 import QtCore, QtGui, QtWidgets
import nn

version = '0.1.0'

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(422, 529)
        font = QtGui.QFont()
        font.setFamily("Segoe UI")
        MainWindow.setFont(font)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        #self.centralwidget.setStyleSheet('background: #E5E5E5;')
        self.file_name = QtWidgets.QLabel(self.centralwidget)
        self.file_name.setGeometry(QtCore.QRect(10, 10, 370, 21))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.file_name.setFont(font)
        self.file_name.setObjectName("file_name")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(10, 430, 81, 20))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(10, 460, 81, 16))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.label_2.setFont(font)
        self.label_2.setObjectName("label_2")
        self.p_healthy = QtWidgets.QLabel(self.centralwidget)
        self.p_healthy.setGeometry(QtCore.QRect(100, 430, 61, 16))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.p_healthy.setFont(font)
        self.p_healthy.setObjectName("p_healthy")
        self.p_sick = QtWidgets.QLabel(self.centralwidget)
        self.p_sick.setGeometry(QtCore.QRect(100, 460, 61, 16))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.p_sick.setFont(font)
        self.p_sick.setObjectName("p_sick")
        self.choseButton = QtWidgets.QPushButton(self.centralwidget)
        self.choseButton.setGeometry(QtCore.QRect(10, 490, 401, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        self.choseButton.setFont(font)
        self.choseButton.setObjectName("choseButton")
        self.choseButton.setStyleSheet('position: absolute; background: rgba(154, 154, 154, 0.34); box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 20px;')
        self.image = QtWidgets.QLabel(self.centralwidget)
        self.image.setGeometry(QtCore.QRect(10, 40, 401, 371))
        font = QtGui.QFont()
        font.setPointSize(24)
        font.setBold(True)
        font.setItalic(False)
        font.setWeight(75)
        self.image.setFont(font)
        self.image.setScaledContents(True)
        self.image.setAlignment(QtCore.Qt.AlignCenter)
        self.image.setObjectName("image")
        MainWindow.setCentralWidget(self.centralwidget)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

        self.main_func()

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "Анализ рентгенограммы "+version))
        self.file_name.setText(_translate("MainWindow", "file_name"))
        self.label.setText(_translate("MainWindow", "Здоровый:"))
        self.label_2.setText(_translate("MainWindow", "Больной:"))
        self.p_healthy.setText(_translate("MainWindow", "0"))
        self.p_sick.setText(_translate("MainWindow", "0"))
        self.choseButton.setText(_translate("MainWindow", "Выбрать файл"))
        self.image.setText(_translate("MainWindow", "Выберите изображение"))

    def main_func(self):
        self.choseButton.clicked.connect(self.get_image)

    def get_image(self):
        path = QtWidgets.QFileDialog.getOpenFileName()
        result = nn.predict(path[0])
        self.p_healthy.setText("{:.2f}".format(result[0]))
        self.p_sick.setText("{:.2f}".format(result[1]))
        self.file_name.setText(str(path[0]))
        self.image.setPixmap(QtGui.QPixmap(path[0]))


if __name__ == "__main__":
    import sys

    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    MainWindow.setFixedSize(422, 529)
    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())
