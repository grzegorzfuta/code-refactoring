# Zmiany wykonane przy refactoringu example02

1. Zmiana nazwy metody `generujDokument()` na `generujWydruk()`. Metoda *de facto* generuje `Wydruk` a nie `Dokument`, który jest inną klasą w  rozpatrywanej domenie.

2. Uporządkowanie (i tak już skróconej) istniejącej implementacji metody. Podział metody i wyekstrachowanie metod prywatnych poprawiających czytelność kodu.

3. Zmiana kontraktu w `WydrukiCommonsService.rejestracjaDokumentuWKancelarii()`. Jeżeli kod jednostki w domenie w `Sprawie` jest typu `Long` pozostawmy go takim. Zwłaszcza, że i tak w przypadku wartości `null` przekazujemy `null`. Poza tym, kod jednostki organizacyjnej w formie liczby poprzedzonej zerami obowązuje w zakresie rejestracji dokumentu w *kancelarii*. Przenosimy tam (bliżej tego obszaru) zatem `WYMAGANA_DLUGOSC_KODU_JO` oraz konwersję `Long` na `String`.

   Na razie tyle - w następnym *commit* (a już to widać), posprzątamy jeszcze bardziej. 

4. Dopiero teraz patrząc na kod widzimy, że nie musimy podawać kodu jednostki organizacyjnej w celu zarejestrowania dokumentu w kancelarii. Kod ten jest zawarty w `Sprawie`. :) Lecimy z refactorem dalej...

5. Zmienimy kolejność instrukcji oraz nazwę metody z `uzupelnijDaneSzczegoloweDokumentu(...)` na `uzupelnijDaneWydruku(..)`.


