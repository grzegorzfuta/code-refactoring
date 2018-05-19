package com.example02.service;

import com.example02.annotations.DomainArea;
import com.example02.entity.Dokument;
import com.example02.entity.Sprawa;
import com.example02.entity.Wydruk;
import com.example02.utils.DateUtils;
import com.example02.utils.StringUtils;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;

@DomainArea(DomainArea.AREA_B)
public class PowiadomienieORozprawieGospodarczejService implements IPowiadomienieORozprawie, Serializable {

    @Inject
    private WydrukiCommonsService wydrukiCommonsService;

    @Override
    public Wydruk generujDokument(Sprawa aSprawa) {
        Dokument pDokument = new Dokument();
        Wydruk pWydruk = new Wydruk();
        pWydruk.setDokument(pDokument);
        pDokument.setWydruk(pWydruk);

        Date pDateNow = new Date();

        final Long aKodJednOrgLong = aSprawa.getKodJednostkiOddzialu();
        final String pKodJednOrgString = (aKodJednOrgLong != null) ? StringUtils.padWithZeroes(aKodJednOrgLong, WYMAGANA_DLUGOSC_KODU_JO) : null;

        wydrukiCommonsService.wypelnijDaneKontaktoweStronyPozywajacej(aSprawa, pWydruk);
        wydrukiCommonsService.wypelnijDaneUrzedu(aSprawa.getKodJednostkiOddzialu(), pWydruk);

        pDokument.setTypDokumentu(Dokument.Typ.POWIADOMIENIE_O_ROZPRAWIE);
        pDokument.setSprawaGlowna(aSprawa);
        pDokument.getSprawy().add(aSprawa);
        pDokument.setKodJednostkiOddzialu(aSprawa.getKodJednostkiOddzialu());

        pWydruk.setNazwaSzablonuDocx(SZABLON_DOKUMENTU_POWIADOMIENIE_O_ROZPRAWIE);
        pWydruk.setNazwaPlikuWynikowegoDocx(NAZWA_PLIKU_WYNIKOWEGO_WYDRUKU);

        pWydruk.dodajZmienna("WEZ_DAT_WYDANIA", DateUtils.formatDate(new Date(), SHORT_DATE_FORMAT));

        uzupelnijDaneSzczegoloweDokumentu(aSprawa, pWydruk);

        wydrukiCommonsService.rejestracjaDokumentuWKancelarii(pKodJednOrgString, aSprawa, pWydruk.getDokument());

        return pWydruk;
    }

    private void uzupelnijDaneSzczegoloweDokumentu(Sprawa aSprawa, Wydruk aWydruk) {

    }
}
