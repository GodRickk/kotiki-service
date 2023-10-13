package ru.itmo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itmo.entity.Cat;
import ru.itmo.entity.Owner;
import ru.itmo.entity.CatFriends;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Cat.class);
                configuration.addAnnotatedClass(Owner.class);
                configuration.addAnnotatedClass(CatFriends.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable exeption) {
                System.err.println("Creation SessionFactory failed" + exeption);
            }
        }
        return sessionFactory;
    }





}
