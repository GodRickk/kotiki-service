package ru.itmo.dto;

import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;

import java.sql.Date;
import java.util.List;

public class OwnerDto {
    private String name;

    //private Date birthDate;

    private String birthDate;

    private List<Cat> catList;

    private Integer id;

    /*public OwnerDto(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }*/

    public OwnerDto(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public OwnerDto(Owner owner) {
        name = owner.getName();
        birthDate = owner.getBirthDate();
        catList = owner.getCatList();
        id = owner.getOwnerId();
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }*/

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public String getName() {
        return name;
    }


}