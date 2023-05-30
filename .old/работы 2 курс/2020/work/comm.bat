@echo off
cls
start notepad
if not exist C:\Users\Игорь\Desktop\work\message.txt (GOTO :ERR) else 
rename C:\Users\Игорь\Desktop\work\message.txt message.bat
echo «All it really work»
color 0G
start C:\Users\Игорь\Desktop\work\message.bat
GOTO :END
:ERR
echo "File message.txt is missing"
color 0R
:END