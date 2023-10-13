package ru.itmo.entity;

import javax.persistence.*;

@Entity
@Table(name = "cat_friends", schema = "public", catalog = "kotiki-java")
public class CatFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "cat_id1")
    private int cat_id1;
    @Column(name = "cat_id2")
    private int cat_id2;

    public CatFriends() {
    }

    public CatFriends(int cat_id1, int cat_id2) {
        this.cat_id1 = cat_id1;
        this.cat_id2 = cat_id2;
    }

    public int getId() {
        return id;
    }

    public int getCat_id1() {
        return cat_id1;
    }

    public int getCat_id2() {
        return cat_id2;
    }

}
