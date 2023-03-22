package com.abdo.springsecurityauthjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdo.springsecurityauthjwt.models.Commentaire;
import com.abdo.springsecurityauthjwt.models.Realisation;
import com.abdo.springsecurityauthjwt.services.CommentaireService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentaireController {
	
	private CommentaireService commentaireservice;

	public CommentaireController(CommentaireService commentaireservice) {
		super();
		this.commentaireservice = commentaireservice;
	}
	
	@PostMapping("/comments")
	public ResponseEntity<Commentaire> saveComment(@RequestBody Commentaire commentaire){
		return new ResponseEntity<Commentaire>(commentaireservice.saveComment(commentaire), HttpStatus.CREATED);
	}
	
	@GetMapping("/comments")
	public List<Commentaire> getAllCommments(){
		return commentaireservice.getAllComments();
	}
	
	@GetMapping("/comments/{id}")
	public List<Commentaire> getRealisationCommments(@PathVariable Long id){
		List<Commentaire> list= commentaireservice.getAllComments();
		List<Commentaire> list1=new ArrayList<>();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getRealisation().getId()==id) list1.add(list.get(i));
		}
		return list1;
	}
	

}
