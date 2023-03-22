package com.abdo.springsecurityauthjwt.controllers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.abdo.springsecurityauthjwt.models.Realisation;
import com.abdo.springsecurityauthjwt.models.User;
import com.abdo.springsecurityauthjwt.services.RealisationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RealisationController {

	private RealisationService realisationService;

	public RealisationController(RealisationService realisationService) {
		super();
		this.realisationService = realisationService;
	}
	
	@PostMapping("/realisations")
	public ResponseEntity<Realisation> saveRealisation(@RequestBody Realisation realisation){
		return new ResponseEntity<Realisation>(realisationService.saveRealisation(realisation),HttpStatus.CREATED);
	}
	
	@GetMapping("/realisations")
	public List<Realisation> getAllRealisation(){
		return realisationService.getAllRealisations();
	}
	
	@GetMapping("/users/{id}")
	public List<Realisation> getAlluserRealisation(@PathVariable Long id){
		List<Realisation> list=new ArrayList<>();
		List<Realisation> list1=realisationService.getAllRealisations();
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getUser().getId()==id) list.add(list1.get(i));
			
		}
		return list;
	}
	/*@GetMapping("/users/a")
	public List<Realisation> getAlluserRealisation(@RequestBody User user){
		return realisationService.getRealisationbyuser(user.getId());
	}
	/*
	@GetMapping("/realisations/{id}")
	public Realisation getRealisation(@PathVariable Long id) {
		return realisationService.getRealisation(id);
	}
	*/
	@GetMapping("/categories")
	public List<String> getCategories(){
		List<String> list=new ArrayList<>();
		List<Realisation> list1=realisationService.getAllRealisations();
		for(int i=0;i<list1.size();i++) {
			if(!list.contains(list1.get(i).getCategory())) list.add(list1.get(i).getCategory());
			
		}
		return list;
	}
	
	@GetMapping("/categories/{categorie}")
	public List<Realisation> getRealisationsCategorie(@PathVariable String categorie){
		List<Realisation> list=new ArrayList<>();
		List<Realisation> list1=realisationService.getAllRealisations();
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getCategory().equals(categorie)) list.add(list1.get(i));
			
		}
		return list;
	}
	
	@GetMapping("/categories/categorie")
	public List<String> getCategoriesByresearch(@RequestParam(value = "research") String research){
		List<String> list=new ArrayList<>();
		List<Realisation> list1=realisationService.getAllRealisations();
		for(int i=0;i<list1.size();i++) {
			String[] list2=list1.get(i).getDescription().split(" ");
			if(list1.get(i).getCategory().equals(research)) list.add(list1.get(i).getCategory());
			else {
				for (String a : list2) {
					String[] list3=research.split(" ");
					if(list3.length==1) {
						if(a.equals(research)) list.add(list1.get(i).getCategory());	
					}
					else {
						for (String b : list3) {
							if(b.equals(a)) {
								list.add(list1.get(i).getCategory());
								;}
						}
					}
				}	
					
			}}	
		Set<String> set=new LinkedHashSet<String>(list);
		list=new ArrayList<>(set);
		return list;
		}
	
	@GetMapping("/realisations/{research}")
	public List<Realisation> getRealisationsByresearch(@PathVariable String research,@RequestParam(value = "categorie") String categorie){
		List<Realisation> list=new ArrayList<>();
		List<Realisation> list1=this.getRealisationsCategorie(categorie);
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getCategory().equals(research)) list.add(list1.get(i));
			else {
				String[] list2=list1.get(i).getDescription().split(" ");
				for (String a : list2) {
					String[] list3=research.split(" ");
					if(list3.length==1) {
						if(a.equals(research)) list.add(list1.get(i));
					}
					else {
						for (String b : list3) {
							if(b.equals(a)) {
								list.add(list1.get(i));
								;}
						}
					}
					
			}}}
		Set<Realisation> set=new LinkedHashSet<>(list);
		list=new ArrayList<>(set);
		return list;
	}
	
	

}
