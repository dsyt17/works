@echo off
cls
if (%1)==() goto :END
if (%2)==() goto :END
if (%3)==() goto :END
if (%4)==() goto :END
md Files_%4
for %%i in (%1\*.%4, %2\*.%4, %3\*.%4) do copy "%%i" Files_%4\
goto :OK
:END
echo Use syntax: sort.bat [dir1] [dir2] [dir3] [file type]
:OK
pause