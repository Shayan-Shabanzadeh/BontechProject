package com.example.ui.controller;

import com.example.io.entity.Address;
import com.example.io.entity.User;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping(path = "/{addressId}}", produces = MediaType.APPLICATION_JSON_VALUE)
    Address getAddressById(@PathVariable long addressId) {
        return addressService.getAddress(addressId);
    }

    @DeleteMapping(path = "/{addressId}}")
    void removeAddressById(@PathVariable long addressId) {
        addressService.deleteAddress(addressId);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Address insertAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Address updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
        return address;
    }
}
