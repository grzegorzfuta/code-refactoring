package com.example02.service;

import com.example02.annotations.DomainArea;
import com.example02.entity.Dokument;
import com.example02.entity.Sprawa;
import com.example02.entity.Wydruk;
import com.example02.utils.DateUtils;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;

@DomainArea(DomainArea.AREA_B)
public class PowiadomienieORozprawieGospodarczejService implements IPowiadomienieORozprawie, Serializable {

    @Inject
    private WydrukiCommonsService wydrukiCommonsService;

    @Override
    public Wydruk generujWydruk(Sprawa aSprawa) {
        Wydruk pWydruk = zainicjujWydruk();

        final Long aKodJednOrgLong = aSprawa.getKodJednostkiOddzialu();

        zainicjujDokument(aSprawa, pWydruk);

        wydrukiCommonsService.wypelnijDaneKontaktoweStronyPozywajacej(aSprawa, pWydruk);
        wydrukiCommonsService.wypelnijDaneUrzedu(aSprawa.getKodJednostkiOddzialu(), pWydruk);

        uzupelnijDaneSzczegoloweDokumentu(aSprawa, pWydruk);

        wydrukiCommonsService.rejestracjaDokumentuWKancelarii(aKodJednOrgLong, aSprawa, pWydruk.getDokument());

        return pWydruk;
    }

    private void zainicjujDokument(Sprawa aSprawa, Wydruk pWydruk) {
        pWydruk.getDokument().setTypDokumentu(Dokument.Typ.POWIADOMIENIE_O_ROZPRAWIE);
        pWydruk.getDokument().setSprawaGlowna(aSprawa);
        pWydruk.getDokument().getSprawy().add(aSprawa);
        pWydruk.getDokument().setKodJednostkiOddzialu(aSprawa.getKodJednostkiOddzialu());
    }

    private void uzupelnijDaneSzczegoloweDokumentu(Sprawa aSprawa, Wydruk aWydruk) {
        // tutaj dodanie "zmiennych" znajdujących się na wydruku
    }

    private Wydruk zainicjujWydruk() {
        Dokument pDokument = new Dokument();
        Wydruk pWydruk = new Wydruk();
        pWydruk.setDokument(pDokument);
        pDokument.setWydruk(pWydruk);

        pWydruk.setNazwaSzablonuDocx(SZABLON_DOKUMENTU_POWIADOMIENIE_O_ROZPRAWIE);
        pWydruk.setNazwaPlikuWynikowegoDocx(NAZWA_PLIKU_WYNIKOWEGO_WYDRUKU);

        pWydruk.dodajZmienna("WEZ_DAT_WYDANIA", DateUtils.formatDate(new Date(), SHORT_DATE_FORMAT));

        return pWydruk;
    }

}
