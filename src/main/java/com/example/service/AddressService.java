package com.example.service;

import com.example.io.dao.AddressDao;
import com.example.io.dao.UserDao;
import com.example.io.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class AddressService {
    private AddressDao addressDao;

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Transactional
    public ArrayList<Address> getAllAddress(){
        return addressDao.getAllAddress();
    }
    @Transactional
    public Address getAddress(long id){
        return addressDao.getAddress(id);
    }
    @Transactional
    public Address addAddress(Address address){
        return addressDao.addAddress(address);
    }
    @Transactional
    public void updateAddress(Address address){
        addressDao.updateAddress(address);
    }
    @Transactional
    public void deleteAddress(long id){
        addressDao.deleteAddress(id);
    }
}
