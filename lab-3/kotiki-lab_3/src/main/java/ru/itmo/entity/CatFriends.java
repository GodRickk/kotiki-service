package ru.itmo.entity;

import javax.persistence.*;

@Entity
@Table(name = "cat_friends", schema = "public", catalog = "postgres")
public class CatFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "cat_id1")
    private Integer cat_id1;
    @Column(name = "cat_id2")
    private Integer cat_id2;

    public CatFriends() {
    }

    public CatFriends(Integer cat_id1, Integer cat_id2) {
        this.cat_id1 = cat_id1;
        this.cat_id2 = cat_id2;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCat_id1() {
        return cat_id1;
    }

    public Integer getCat_id2() {
        return cat_id2;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}