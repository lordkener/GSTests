package com.proyect.phonecatalog.repositories;

import java.util.Optional;

import com.proyect.phonecatalog.models.Phone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, Long> {

    @Query("SELECT p FROM Phone p")
    Page<Phone> findAllPageablePhones(Pageable page);

    Optional<Phone> findPhoneById(Long id_phone);
}