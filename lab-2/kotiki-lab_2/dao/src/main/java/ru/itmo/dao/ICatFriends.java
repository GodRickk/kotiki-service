package ru.itmo.dao;

import ru.itmo.entity.CatFriends;
import ru.itmo.entity.Owner;

import java.util.List;

public interface ICatFriends {
    CatFriends get(int id);

    List<CatFriends> getAll();

    void save(CatFriends pair);

    void update(CatFriends pair);

    void delete(CatFriends pair);
}
