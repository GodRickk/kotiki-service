package ru.itmo.service;

import ru.itmo.dao.IOwnerDao;
import ru.itmo.dao.OwnerDao;
import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;

import java.util.List;

public class OwnerService {
    private final IOwnerDao iOwnerDao;

    public OwnerService(IOwnerDao ownerDao) {
        this.iOwnerDao = ownerDao;
    }

    Owner get(int id) {
        return iOwnerDao.get(id);
    }

    List<Owner> getAll() {
        return iOwnerDao.getAll();
    }

    public List<Cat> getOwnerCatList(int owner_id) {
        return iOwnerDao.getOwnerCatList(owner_id);
    }


    public void save(Owner owner) {
        iOwnerDao.save(owner);
    }

    public void update(Owner owner) {
        iOwnerDao.update(owner);
    }

    public void delete(Owner owner) {
        iOwnerDao.delete(owner);
    }
}
