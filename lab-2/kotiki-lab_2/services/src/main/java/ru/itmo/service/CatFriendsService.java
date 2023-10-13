package ru.itmo.service;

import ru.itmo.dao.CatDao;
import ru.itmo.dao.CatFriendsDao;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;

import java.util.List;

public class CatFriendsService {
    private CatFriendsDao catFriendsDao;

    public CatFriendsService(CatFriendsDao catFriendsDao) {
        this.catFriendsDao = catFriendsDao;
    }

    public CatFriends get(int id) {
        return catFriendsDao.get(id);
    }

    public List<CatFriends> getAll() {
        return catFriendsDao.getAll();
    }
    public void save(CatFriends catFriends) {
        catFriendsDao.save(catFriends);
    }

    public void update(CatFriends catFriends) {
        catFriendsDao.update(catFriends);
    }

    public void delete(CatFriends catFriends) {
        catFriendsDao.delete(catFriends);
    }

}
