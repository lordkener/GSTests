package com.proyect.instarecipes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.proyect.instarecipes.models.Phone;
import com.proyect.instarecipes.models.Phone.MainInfo;
import com.proyect.instarecipes.models.Phone.PhoneDetails;
import com.proyect.instarecipes.service.PhoneService;

@RestController
@RequestMapping("/api")
public class IndexRestController {
	public interface Main extends MainInfo {}
	public interface Detail extends PhoneDetails {}

	@Autowired
	private PhoneService phoneService;

	// RECENT USERS PUBLICATIONS (AS ANNONYMOUS)
	@JsonView(IndexRestController.Main.class)
	@GetMapping("/")
	public ResponseEntity<List<Phone>> getPhoneCatalog() {
		List<Phone> phonesList = phoneService.getAllPhones();
		if (phonesList != null) {
			return new ResponseEntity<>(phonesList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(IndexRestController.Detail.class)
    @GetMapping("/phones/{id_phone}")
    public ResponseEntity<Phone> getPhone(@PathVariable Long id_phone){
        if (id_phone != null){
            return new ResponseEntity<>(phoneService.getPhone(id_phone), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}