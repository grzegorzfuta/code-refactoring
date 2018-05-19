package com.example02.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Empty 'mocked' class for demo purpose.
 */

@Entity
@Table(name = "SPRAWY")
public class Sprawa {
    private Long kodJednostkiOddzialu;

    public Long getKodJednostkiOddzialu() {
        return kodJednostkiOddzialu;
    }

    public void setKodJednostkiOddzialu(Long kodJednostkiOddzialu) {
        this.kodJednostkiOddzialu = kodJednostkiOddzialu;
    }
}
