package com.example02.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity that represents information about data printed in the document {@see com.example02.entity.Document}.
 *
 * Empty 'mocked' class for demo purpose.
 */

@Entity
@Table(name = "WYDRUK")
public class Wydruk {

    private String nazwaSzablonuDocx;
    private String nazwaPlikuWynikowegoDocx;
    private Dokument dokument;

    public String getNazwaSzablonuDocx() {
        return nazwaSzablonuDocx;
    }

    public void setNazwaSzablonuDocx(String nazwaSzablonuDocx) {
        this.nazwaSzablonuDocx = nazwaSzablonuDocx;
    }

    public String getNazwaPlikuWynikowegoDocx() {
        return nazwaPlikuWynikowegoDocx;
    }

    public void setNazwaPlikuWynikowegoDocx(String nazwaPlikuWynikowegoDocx) {
        this.nazwaPlikuWynikowegoDocx = nazwaPlikuWynikowegoDocx;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }

    public void dodajZmienna(String nazwa, Object wartosc) {

    }
}
