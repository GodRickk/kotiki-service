package ru.itmo.entity;

import ru.itmo.enums.Color;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat", schema = "public", catalog = "kotiki-java")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private int id;
    private String name;
    private Color color;
    private String breed;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Cat() {
    }

    public Cat(String name, Color color, String breed, Date birthDate, Owner owner) {
        this.name = name;
        this.color = color;
        this.breed = breed;
        this.birthDate = birthDate;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
