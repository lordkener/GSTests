package com.proyect.phonecatalog.service;

import java.util.List;

import com.proyect.phonecatalog.models.Phone;
import com.proyect.phonecatalog.repositories.PhonesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PhoneService{

    @Autowired
    private PhonesRepository phonesRepository;
    
    public List<Phone> getAllPhones(int page, int size){
        List<Phone> phones = null;
        phones = phonesRepository.findAllPageablePhones(PageRequest.of(page, size)).getContent();
        return phones;
    }

    public Phone getPhone(Long id_phone){
        return phonesRepository.findById(id_phone).get();
    }

}