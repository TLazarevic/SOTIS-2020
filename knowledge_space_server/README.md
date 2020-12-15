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

```
