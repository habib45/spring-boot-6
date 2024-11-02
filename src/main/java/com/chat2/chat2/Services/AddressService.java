package com.chat2.chat2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat2.chat2.Models.Address;
import com.chat2.chat2.Models.User;
import com.chat2.chat2.Repositories.AddressRepository;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.exception.DataNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository address;    

    public AddressService(AddressRepository address) {
            this.address = address;
        }

    @SuppressWarnings("unchecked")
    public List<Address> findAll(Long userId) {
        return (List<Address>) this.address.findByUserId(userId);
    }

    public Address saveAddress(Address requestAddress){
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
