package ru.itmo.dao;

import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;

import java.util.List;

public interface IOwnerDao {
    Owner get(int id);

    List<Owner> getAll();

    List<Cat> getOwnerCatList(int ownerId);

    void save(Owner owner);

    void update(Owner owner);

    void delete(Owner owner);
}
