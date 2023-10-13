package ru.itmo.dao;

import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;

import java.util.List;

public interface ICatDao {
    Cat get(int id);

    List<Cat> getAll();

    List<Cat> getAllFriends(int id);

    void save(Cat cat);

    void update(Cat cat);

    void delete(Cat cat);
    
    //Owner getOwnerByCatId();
}
