package com.chat2.chat2.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat2.chat2.Models.Address;
import com.chat2.chat2.Models.User;
import com.chat2.chat2.Requests.UserUpdateRequest;
import com.chat2.chat2.Services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService address;

    public AddressController(AddressService address) {
        this.address = address;
    }
    
    @GetMapping
    public ResponseEntity<List<Address>> getAddress(@PathVariable Long userId){
        return ResponseEntity.ok(this.address.findAll(userId));

    }
    @PostMapping
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address requestAddress ){
        return ResponseEntity.ok(this.address.saveAddress(requestAddress));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateUser(@PathVariable Long id,@Valid @RequestBody Address updateRequest) {
        return ResponseEntity.ok(this.address.updateAddress(id, updateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        this.address.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
