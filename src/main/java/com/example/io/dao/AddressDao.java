package com.example.io.dao;

import com.example.io.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AddressDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ArrayList<Address> getAllAddress(){
        Session session = sessionFactory.getCurrentSession();
        return (ArrayList<Address>) session.createQuery("from Address").getResultList();
    }
    public Address getAddress(long id){
        Session session = sessionFactory.getCurrentSession();
        Address address = session.load(Address.class , id);
        return address;
    }
    public Address addAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.persist(address);
        return address;
    }
    public void updateAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.update(address);
    }
    public void deleteAddress(long id){
        Session session = sessionFactory.getCurrentSession();
        Address address = session.load(Address.class , id);
        if(address != null){
            session.delete(address);
        }
    }
}
