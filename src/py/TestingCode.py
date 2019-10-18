import os, sys
from datetime import date

pat='news'

now = date.today()

print(now.strftime("%d/%m/%y %"))
if not os.path.exists(pat):
    os.mkdirs(pat)
else:
    print(pat)
        

