"# EvenNumbersAlgorithm" 
Mama chce wypłacić Bajtkowi i Bajtolinie kieszonkowe. Chce przeznaczyć na ten cel część banknotów ze swojego portfela, w taki sposób by dzieci były w stanie podzielić się po równo, w razie potrzeby dzieci same rozmienią otrzymane banknoty w kiosku.

Minimalnym dostępnym nominałem jest 1 bajtar.

Wobec tego kwotę bajtarów można rozdzielić po równo między dwie osoby dokładnie wtedy, gdy jest parzysta.

Wejście
Pierwsza linia wejścia zawiera liczbę całkowitą N (1 <= N <= 1 000 000) oznaczająca liczbę banknotów.
Drugi wiersz zawiera n liczb całkowitych a1, a2, a3 ... aN (1 <= ai <= 1000) - nominały banknotów

Wyjście
Na wyjście należy wypisać
- w pierwszym wierszu maksymalną wartość kieszonkowego dla każdego z dzieci.

- w drugim listę banknotów które mama przeznaczy na wypłatę kieszonkowego.

Jeśli nie da się wybrać równo podzielić pieniędzy z portfela. Należy wypisać słowo:
NIESTETY.

Przykład
Dla danych wejściowych:
5
6 2 5 5 5

poprawnym wynikiem jest:
18

6 2 5 5


natomiast dla danych wejściowych:
1
7

poprawnym wynikiem jest:
NIESTETY
