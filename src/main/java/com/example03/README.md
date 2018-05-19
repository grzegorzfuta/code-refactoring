# example03

## Wprowadzenie

* do kolejki przekazującej dane pomiędzy mikroserwisami wstawiane są wiadomości
* jednym z atrybutów wiadomości jest opis - `String description`
* opis powstaje ze złączenia dwóch innych opisów i ma ustaloną maksymalną długość, np. 10 znaków, `'AAA' + 'BBB' = 'AAABBB'`, `'AAABBB' + 'CCC' = 'AAABBBCCC`, `'AAABBB' + 'CCCDDD' = 'AAABBBCCCD'` (obcięte `'DD'`)

## Problem

Do kolejki nie są wstawiane wszystkie wiadomości. W logach widać wyjątki `java.lang.NullPointerException` oraz `java.lang.StringIndexOutOfBoundsException`

## Naprawa

Napisać poprawną wersję metody łączącej łańcuchy z ewentualnym obcięciem do maksymalnej długości

## Stan początkowy

Skomplikowana metoda łącząca łańcuchy - anty-KISS

## Dodatkowe info

"Ciekawe" wykorzystanie `try-catch