package com.example02.service;

import com.example02.entity.Dokument;
import com.example02.entity.Sprawa;
import com.example02.entity.Wydruk;
import com.example02.utils.StringUtils;

/**
 * Common functionalities for printed documents
 */
public class WydrukiCommonsService {

    private int WYMAGANA_DLUGOSC_KODU_JO = 4;

    /**
     * Kancelaria to system zewnętrzny. (przenosimy do innego serwisu?)
     *
     * @param aSprawa sprawa, z którą związany jest dokument
     * @param aDokument rejestrowany dokument
     */
    public void rejestracjaDokumentuWKancelarii(final Sprawa aSprawa, final Dokument aDokument) {
        final String pKodJednOrgString = (aSprawa.getKodJednostkiOddzialu() != null)
                ? StringUtils.padWithZeroes(aSprawa.getKodJednostkiOddzialu(), WYMAGANA_DLUGOSC_KODU_JO) : null;
        // rest of implementation
    }

    public void wypelnijDaneKontaktoweStronyPozywajacej(Sprawa sprawa, Wydruk wydruk) {
        // implementation removed
    }

    public void wypelnijDaneUrzedu(Long aKOdJednoski, Wydruk aWydruk) {
        // implementation removed
    }
}
