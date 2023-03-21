package com.abdo.springsecurityauthjwt.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdo.springsecurityauthjwt.exceptions.RessourceNotFoundException;
import com.abdo.springsecurityauthjwt.models.Realisation;
import com.abdo.springsecurityauthjwt.models.User;
import com.abdo.springsecurityauthjwt.repositories.RealisationRepository;
import com.abdo.springsecurityauthjwt.repositories.UserRepository;
import com.abdo.springsecurityauthjwt.services.RealisationService;

@Service
public class RealisationSerciceImpl implements RealisationService{
	   @Autowired

	private RealisationRepository realisationRepository;
	   @Autowired
private UserRepository userRepository;

	public RealisationSerciceImpl(RealisationRepository realisationRepository) {
		super();
		this.realisationRepository=realisationRepository;
	}

	@Override
	public Realisation saveRealisation(Realisation realisation) {
		
		return realisationRepository.save(realisation);
	}

	@Override
	public List<Realisation> getAllRealisations() {
		return realisationRepository.findAll();
	}

	@Override
	public List<Realisation> getRealisationbyuser(Long user_id) {
		return realisationRepository.findByUserid(user_id);
	}

	@Override
	public Realisation getRealisation(Long id) {
		Optional<Realisation> optional=realisationRepository.findById(id);
		return optional.orElseThrow(()-> new RessourceNotFoundException("realisation", "id", id));
	}
	
	
	@Override
	public Realisation addRealisation(Realisation realisation){
	    User user=userRepository.findById(realisation.getUser().getId()).get();
	    
	    Realisation NewRealisation=realisationRepository.save(realisation);
	    return NewRealisation;
	}
	

}
