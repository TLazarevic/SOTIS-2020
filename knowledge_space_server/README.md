## Inicijalizovanje

Mora da se ima kreirano novo okruzenje sa 3.6 verzijom python-a.
```
mkvirtualenv kst
ili
conda create -n myenv python=3.6
```
Nakon kreiranja i aktiviranja novog okruzenja, pokrenuti requirements.txt, ako je sve u redu bice instalirano bez problema.
Izbacivace greske ako postoje prethodno instalirane verzije nekih od biblioteka ili ako nije python 3.6
```
pip install -r requirements.txt
```

Koriscenje
```
import pandas as pd
import numpy as np
import sys

import matplotlib.pyplot as plt

sys.path.append('learning_spaces/')
from learning_spaces.kst import iita

'''
    matrica tacnosti odgovora ucenika na pitanja. 
    Ucenik a je na prva dva pitanja je odg tacno, na trece netacno i tako dalje
       0 1 2
    a  1 0 1 
    b  0 1 0
    b  0 1 1
'''
odgovori_ucenika_df = pd.DataFrame({'a': [1, 0, 1], 'b': [0, 1, 0], 'c': [0, 1, 1]})

'''
    Poziv funkcije:
        response = iita(odgovori_ucenika_df, v=1), itta algoritam verzije 1
        
    Kao odgovor funkcije ita dobijamo implikacije izmedju pitanja:
    
    dict_values([array([0.18518519, 0.16666667, 0.21296296]), [(0, 1), (0, 2), (2, 0), (2, 1)], 0.5, 1, 1])
    
    [(0, 1), (0, 2), (2, 0), (2, 1)]
    
    0 prethodi 1 
    0 prethodi 2 => 2 i 0 su ekvivalentni
    2 prethodi 0
    2 prethodi 1
    
    **Ostali parametri za sada nisu relevantni
    
    ** https://www.python-course.eu/graphs_python.php za crtanje grafa u pythonu, nece trebati jer ga radimo na frontu

    ** tests/test_blim.py generise odgovore ucenika na neki test
'''
response = iita(odgovori_ucenika_df, v=1)
print(response.values())


