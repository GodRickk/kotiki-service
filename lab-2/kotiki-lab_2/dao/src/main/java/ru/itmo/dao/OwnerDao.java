package ru.itmo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;
import ru.itmo.utils.HibernateSessionFactory;

import java.util.List;

public class OwnerDao implements IOwnerDao {
    @Override
    public Owner get(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Owner.class, id);
    }

    @Override
    public List<Owner> getAll() {
        List<Owner> ownerList = (List<Owner>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Owner").list();
        return ownerList;
    }

    @Override
    public List<Cat> getOwnerCatList(int ownerId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        String q = "Select Cat From Cat cat Where cat.owner.id=:owner_id";
        Query<Cat> query = session.createQuery(q, Cat.class);
        query.setParameter("owner_id", ownerId);
        List<Cat> ownerCatList = query.getResultList();
        return ownerCatList;
    }

    @Override
    public void save(Owner owner) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Owner owner) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Owner owner) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(owner);
        tx1.commit();
        session.close();
    }
}
