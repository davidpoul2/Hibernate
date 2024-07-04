package com.david.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManager getSession(){
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeSession(){
        entityManager.close();
    }

    public static void closeSessionFactory(){
        entityManagerFactory.close();
    }
}
