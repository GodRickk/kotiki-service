package ru.itmo.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.itmo.entity.Cat;
import ru.itmo.entity.CatFriends;
import ru.itmo.utils.HibernateSessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class CatDao implements ICatDao {
    @Override
    public Cat get(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Cat.class, id);
    }

    @Override
    public List<Cat> getAll() {
        List<Cat> catList = (List<Cat>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Cat", Cat.class).list();
        return catList;
    }

    @Override
    public List<Cat> getAllFriends(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        String str = "Select kot.cat_id2 From CatFriends kot Where kot.cat_id1=:id";
        Query query = (Query) session.createQuery(str, Integer.class);
        query.setParameter("id", id);
        List<Integer> catFriendsId = query.getResultList();
        str = "Select kot.cat_id1 From CatFriends kot Where kot.cat_id2=:id";
        query = (Query) session.createQuery(str, Integer.class);
        query.setParameter("id", id);
        catFriendsId.addAll(query.getResultList());
        List<Cat> catList = new ArrayList<>();
        for(Integer cat_id : catFriendsId) {
            catList.add(get(cat_id));
        }
        return catList;

    }

    @Override
    public void save(Cat cat) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(cat);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Cat cat) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(cat);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Cat cat) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(cat);
        tx1.commit();
        session.close();
    }
}
