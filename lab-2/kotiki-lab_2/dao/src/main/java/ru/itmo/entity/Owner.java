package ru.itmo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "owner", schema = "public", catalog = "kotiki-java")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private int ownerId;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> catList;

    public Owner() {
    }

    public Owner(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.catList = new ArrayList<Cat>();
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void addCat (Cat cat) {
        catList.add(cat);
    }

    public void removeCat(Cat cat) {
        catList.remove(cat);
    }
}
