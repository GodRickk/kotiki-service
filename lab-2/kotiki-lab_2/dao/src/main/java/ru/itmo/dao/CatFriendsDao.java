package ru.itmo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.utils.HibernateSessionFactory;

import java.util.List;

public class CatFriendsDao implements ICatFriends{
    @Override
    public CatFriends get(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(CatFriends.class, id);
    }

    @Override
    public List<CatFriends> getAll() {
        List<CatFriends> catPairs = (List<CatFriends>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM CatFriends").list();
        return catPairs;
    }

    @Override
    public void save(CatFriends pair) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(pair);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(CatFriends pair) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(pair);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(CatFriends pair) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(pair);
        tx1.commit();
        session.close();
    }
}
