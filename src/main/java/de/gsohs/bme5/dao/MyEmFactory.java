package de.gsohs.bme5.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEmFactory {
    private static MyEmFactory _instance;
    private final EntityManagerFactory emf;
    private MyEmFactory() {emf = Persistence.createEntityManagerFactory("podlike");}

    public static MyEmFactory getInstance() {
        if(_instance == null) {
            _instance = new MyEmFactory();
        }
        return _instance;
    }
    public EntityManager getEntityManager() {return emf.createEntityManager();}
}
