package com.chat2.chat2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chat2.chat2.Models.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findById(long id);

    Address findByUserId(long userId);

    Address findByIdAndUserId(Long id, Long userId);

}
