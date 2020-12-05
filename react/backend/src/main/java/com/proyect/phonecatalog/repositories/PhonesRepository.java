package com.proyect.phonecatalog.repositories;

import java.util.List;
import java.util.Optional;

import com.proyect.phonecatalog.models.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, Long> {

    List<Phone> findAll();

    Optional<Phone> findPhoneById(Long id_phone);
}