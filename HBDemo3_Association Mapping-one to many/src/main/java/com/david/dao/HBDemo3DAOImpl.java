package com.david.dao;

import com.david.domain.PhoneNo;
import com.david.domain.User;
import com.david.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Set;

public class HBDemo3DAOImpl implements HBDemo3DAO{
    @Override
    public int saveData() {
        User user = null;
        EntityManager session = null;
        PhoneNo phone1 = null;
        PhoneNo phone2 = null;
        Set<PhoneNo> phone = null;
        EntityTransaction tx =  null;

        user = new User();
        user.setId(102);
        user.setName("David Poul");
        user.setAddress("Pusapadu, near church");

        //prepare child objects.
        phone1 = new PhoneNo();
        phone1.setId(new BigDecimal("9966547703"));
        phone1.setProvider("airtel");

        phone2 = new PhoneNo();
        phone2.setId(new BigDecimal("8919787663"));
        phone2.setProvider("JIO");

        //Add child objects to set Collection.
        phone = user.getPhoneNos();
        Collections.addAll(phone, phone1, phone2);
        user.setPhoneNos(phone);

        //Save the object in DB.
        try{
            session = HibernateUtil.getSession();
            tx = session.getTransaction();
            tx.begin();
            session.persist(user);
            tx.commit();
            System.out.println("Objects are saved");
        }
        catch(Exception e){
            if(tx != null && tx.isActive())   tx.rollback();
            System.out.println("Object is not saved"+ " " + e);
        }
        finally {
            if(session != null){
                session.close();
            }
        }

        return 0;
    }

    public User getData(int id){
        EntityManager entityManager = HibernateUtil.getSession();
        User user = (User)entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }
}
