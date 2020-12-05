package com.proyect.phonecatalog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.proyect.phonecatalog.models.Phone;
import com.proyect.phonecatalog.models.Phone.MainInfo;
import com.proyect.phonecatalog.models.Phone.PhoneDetails;
import com.proyect.phonecatalog.service.PhoneService;

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
	
	@GetMapping(value = "/phones/{id_phone}/image", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getPhoneImage(@PathVariable Long id_phone) throws IOException {
		Phone phone = phoneService.getPhone(id_phone);
		if(phone.getMainImage().length > 0){
			byte[] image = phone.getMainImage();
			return new ResponseEntity<>(image, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

}