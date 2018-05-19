# example07

## Wprowadzenie

* jednym z elementów aplikacji jest edytor graficzny, który umozliwia wykonywanie różnego rodzaju operacji na wyświetlanych obiektach: rysowanie, modyfikowanie, dodawanie, usuwanie, łączenie, wycinanie
* w każdym z trybów wykonywana jest pewna operacja - `Action` - na przychodzącym `EditorEvent` zawierającym informacje o dwóch obiektach `EditorObject`
* każdy przychodzący `EditorEvent` jest dodatkowo zapamiętywany w historii 

## Problem

Edytor należy uzupełnić o kolejny typ operacji - duplikowanie obiektów. Dodatkowo okazało się, że nie zawsze trzeba zapamiętywać historię operacji - powinna istnieć opcja włączenia/wyłączenia zapisu historii

## Naprawa

Dodanie nowego typu operacji. Dodanie opcji włączania/wyłączania historii

## Stan początkowy

Stan edytora ustalany na podstawie wielu zmiennych logicznych