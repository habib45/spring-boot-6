package com.chat2.chat2.Services;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chat2.chat2.Models.Address;
import com.chat2.chat2.Repositories.AddressRepository;
import jakarta.transaction.Transactional;

@Service
public class AddressService {

    private static final Logger logger = Logger.getLogger(AddressService.class.getName());
    @Autowired
    private AddressRepository address;

    public AddressService(AddressRepository address) {
        this.address = address;
    }

    public List<Address> findAll(Long userId) {
        return this.address.findAllByUserId(userId);
    }

    public List<Address> searchAddress(Address request) {
        if (request.getUserId() != null) {
            request.setUserId(request.getUserId());
        } else {
            request.setUserId(1);
        }
        // logger.log(Level.INFO, "info log"+ request.getUserId());

        return this.address.searchAddress(request.getUserId(), request.getAddress(), request.getPostalCode());
    }

    public Address saveAddress(Address requestAddress) {
        return this.address.save(requestAddress);
    }

    @Transactional
    public Address updateAddress(Long id, Address updateRequest) {
        return address.save(updateRequest);
    }

    public void deleteById(Long id) {
        this.address.deleteById(id);
    }

}
