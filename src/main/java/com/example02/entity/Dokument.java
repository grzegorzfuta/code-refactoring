package com.example02.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.*;

/**
 * Entity that represents information of real document, e.g. business type, case related to the document.
 *
 * The values presented on the real document and physical formatting information are placed in {@see com.example02.entity.Wydruk} entity.
 *
 */
@Entity
@Table(name = "DOKUMENTY", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "NUMER_DOKUMENTU",  name=Dokument.UNIKALNY_NR_DOKUMENTU)
})
public class Dokument {

    public static final String UNIKALNY_NR_DOKUMENTU = "UNIKALNY_NR_DOKUMENTU";

    Wydruk wydruk;

    private long typDokumentu;

    private Sprawa sprawaGlowna;

    private Set<Sprawa> sprawy;

    private Long kodJednostkiOddzialu;

    public static abstract class Typ {

        private Typ() {
        }

        public static final long POWIADOMIENIE_O_ROZPRAWIE = 123L;

        public static final long DOKUMENT_TYP_A = 123L;

        public static final long DOKUMENT_TYP_B = 124L;

        public static final long DOKUMENT_TYP_C = 234L;

        public static final long DOKUMENT_TYP_D = 345L;

        public static final long DOKUMENT_TYP_E = 456L;


        private static final List<Long> TYPY_DOKUMENTOW_PRZEKAZYWANYCH = Arrays.asList(
                DOKUMENT_TYP_A,
                DOKUMENT_TYP_B,
                DOKUMENT_TYP_C,
                DOKUMENT_TYP_D
        );

        public static boolean czyJestPrzekazywany(long aTypDokumentu) {
            return TYPY_DOKUMENTOW_PRZEKAZYWANYCH.contains(aTypDokumentu);
        }
    }

    public Wydruk getWydruk() {
        return wydruk;
    }

    public void setWydruk(Wydruk wydruk) {
        this.wydruk = wydruk;
    }

    public long getTypDokumentu() {
        return typDokumentu;
    }

    public void setTypDokumentu(long typDokumentu) {
        this.typDokumentu = typDokumentu;
    }

    public Sprawa getSprawaGlowna() {
        return sprawaGlowna;
    }

    public void setSprawaGlowna(Sprawa sprawaGlowna) {
        this.sprawaGlowna = sprawaGlowna;
    }

    public Set<Sprawa> getSprawy() {
        return sprawy;
    }

    public void setSprawy(Set<Sprawa> sprawy) {
        this.sprawy = sprawy;
    }

    public Long getKodJednostkiOddzialu() {
        return kodJednostkiOddzialu;
    }

    public void setKodJednostkiOddzialu(Long kodJednostkiOddzialu) {
        this.kodJednostkiOddzialu = kodJednostkiOddzialu;
    }
}
