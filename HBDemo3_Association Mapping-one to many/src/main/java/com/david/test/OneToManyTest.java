package com.david.test;

import com.david.dao.HBDemo3DAO;
import com.david.dao.HBDemo3DAOFactory;
import com.david.util.HibernateUtil;

public class OneToManyTest {
    public static void main(String[] args) {
        //Get DAO
        HBDemo3DAO dao = null;
        dao = HBDemo3DAOFactory.getInstance();
        //Save Object.
        //dao.saveData();
        System.out.println(dao.getData(102));

        //Close session Objects.
        HibernateUtil.closeSession();
        HibernateUtil.closeSessionFactory();
    }


}
