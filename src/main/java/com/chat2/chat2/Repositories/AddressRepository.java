package com.chat2.chat2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chat2.chat2.Models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findById(long id);

    List<Address> findAllByUserId(@Param("userId") Long userId);

    Address findByIdAndUserId(Long id, Long userId);

    List<Address> findByUserIdAndAddressAndPostalCode(Integer userId, String address, String postalCode);

    @Query("SELECT p FROM Address p WHERE "+
    "p.userId=:userId AND "+
    "( LOWER(p.address) LIKE LOWER(CONCAT('%', :address,'%')) OR "+
    "LOWER(p.postalCode) LIKE LOWER(CONCAT('%', :postalCode,'%')) )"
    )
    List<Address> searchAddress(@Param("userId") Integer userId, String address, String postalCode);

}
