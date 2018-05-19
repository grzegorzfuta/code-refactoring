package com.example02.service;

import com.example02.entity.Sprawa;
import com.example02.entity.Wydruk;

/**
 * Interfejs dla usługi generacji powiadomienia o rozprawie
 */
public interface IPowiadomienieORozprawie {

    /**
     * Nazwa pliku szablonu dokumentu
     */
    String SZABLON_DOKUMENTU_POWIADOMIENIE_O_ROZPRAWIE = "powiadomienia/DOC-123-PowiadomienieORozprawie";

    /**
     * Nazwa pliku wynikowego dokumentu
     */
    String NAZWA_PLIKU_WYNIKOWEGO_WYDRUKU = "Powiadomienie o rozprawie.docx";

    String SHORT_DATE_FORMAT = "dd-MM-yyyy";

    Wydruk generujWydruk(Sprawa aSprawa);
}

