package com.abdo.springsecurityauthjwt.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdo.springsecurityauthjwt.exceptions.RessourceNotFoundException;
import com.abdo.springsecurityauthjwt.models.User;
import com.abdo.springsecurityauthjwt.repositories.ProfileRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/technician")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProfileController {

	    @Autowired
	    private ProfileRepository profileRepository;
	    //technician
	    @PostMapping("")
		public User addTechnicien(@Valid @RequestBody User technicien) {
			return this.profileRepository.save(technicien);
		}
	//get technicians
		@GetMapping("/")
		public List<User> getAllRealisation(){
			return this.profileRepository.findAll();
		}
		//get profile by id
		@GetMapping("/{id}")
		public ResponseEntity<User> getTechnicianById(@PathVariable(value= "id") Long profileId)
			throws RessourceNotFoundException {
			User technician = profileRepository.findById(profileId)
						.orElseThrow(() -> new RessourceNotFoundException("profile", "id", profileId));
			return ResponseEntity.ok().body(technician);
		}

}



