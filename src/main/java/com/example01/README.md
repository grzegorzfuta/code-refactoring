# example01

## Wprowadzenie

* użytkownik korzysta z aplikacji webowej, w której przetwarzane są dokumenty - klasa `Document`
* do każdego dokumentu może być dołączony jeden lub więcej załączników - `Attachment` - plików przesyłanych przez użytkownika
* plik - `File` - to informacje o pliku, nazwa, typ MIME, zawartość
* niektóre z załączników wymagają podania dodatkowego typu - `AttachmentType`
* obiektem odpowiedzialnym za tworzenie załączników jest `DocumentComponent`
* `DocumentComponent` reaguje na zdarzenie `Event` zawierające informacje o obiekcie `InputElement` reprezentującym okno wyboru pliku
* jeżeli użytkownik wybierze plik, to lista plików z `InputElement` nie jest pusta 

## Problem

W niektórych przypadkach nie jest możliwe automatyczne rozpoznanie typu MIME pliku - załącznika. W takiej sytuacji typ MIME jest ustawiany na `""` (łańcuch pusty). Powodowało to niestety problemy (wyjątki oraz kod 500 w odpowiedzi) na backendowej usłudze udostępniającej załączniki.

## Naprawa

Jeżeli podczas wczytywania pliku nie udało się automatycznie ustawić typu MIME, to należy ustawić typ `application/octet-stream`

## Stan początkowy

Dwie metody do tworzenia załączników, bardzo podobne

## Dodatkowe info

Lista wybranych plików może być pusta. Nazwa wybranego pliku nigdy nie będzie `null`