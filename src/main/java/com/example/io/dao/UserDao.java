package com.example.io.dao;


import com.example.io.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ArrayList<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        return (ArrayList<User>) session.createQuery("from User").getResultList();
    }
    public User getUser(long id){
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class , id);
        return user;
    }
    public User addUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }
    public void updateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
    public void deleteUser(long id){
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class , id);
        if(user != null){
            session.delete(user);
        }
    }
}
