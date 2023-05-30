:re
set /P fold="V papku:  "
set /P file="Tip faila:"
 
IF NOT EXIST %fold% (
mkdir %fold%
)
 
if %file% EQU helpme (
echo MNOGO TEXTA
goto re
)
 
:try
IF %file% NEQ all (
echo ERROR! Nepravilno zadaniy tip faila 
goto re
) 
 
 
pause