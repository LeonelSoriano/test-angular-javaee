package com.sample.ws.dao;

import com.sample.ws.model.UserModel;
import org.eclipse.persistence.sessions.Login;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * dao para obtener el logn
 */
@Singleton
public class UserDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist-unit");


    public UserModel login(Login login) {
        EntityManager em = emf.createEntityManager();

        UserModel entity = null;

        try {
            Query query = em.createQuery("Select sm from UserModel sm where sm.name=:arg1 and sm.password=:arg2");
            query.setParameter("arg1", login.getUserName());
            query.setParameter("arg1", login.getPassword());

            entity = (UserModel) query.getSingleResult();

        } finally {
            em.close();
        }

        return entity;
    }



}
