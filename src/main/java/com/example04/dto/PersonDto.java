package com.example04.dto;

import java.util.Date;
import java.util.Set;

public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private Set<PersonDto> children;
    private Set<ItemDto> items;

    public PersonDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PersonDto(String name, String surname, Date birthDate, Set<PersonDto> children) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<PersonDto> getChildren() {
        return children;
    }

    public void setChildren(Set<PersonDto> children) {
        this.children = children;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ItemDto> getItems() {
        return items;
    }

    public void setItems(Set<ItemDto> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
