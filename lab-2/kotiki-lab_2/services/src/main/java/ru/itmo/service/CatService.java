package ru.itmo.service;

import ru.itmo.dao.CatDao;
import ru.itmo.dao.ICatDao;
import ru.itmo.entity.Cat;

import java.util.List;

public class CatService {
    private final ICatDao iCatDao;

    public CatService(ICatDao catDao) {
        this.iCatDao = catDao;
    }

    public Cat getCat(int id) {
        return iCatDao.get(id);
    }

    public List<Cat> getAll(){
        return iCatDao.getAll();
    }

    public List<Cat> getAllFriends(int id) {
        return iCatDao.getAllFriends(id);
    }

    public void save(Cat cat) {
        iCatDao.save(cat);
    }

    public void update(Cat cat) {
        iCatDao.update(cat);
    }

    public void delete(Cat cat) {
        iCatDao.delete(cat);
    }
}
