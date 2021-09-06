package com.example.service;


import com.example.io.dao.UserDao;
import com.example.io.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public ArrayList<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    @Transactional
    public User getUser(long id){
        return userDao.getUser(id);
    }
    @Transactional
    public User addUser(User user){
        return userDao.addUser(user);
    }
    @Transactional
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    @Transactional
    public void deleteUser(long id){
        userDao.deleteUser(id);
    }
}
