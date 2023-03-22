package com.abdo.springsecurityauthjwt.services;

import java.util.List;

import com.abdo.springsecurityauthjwt.models.Realisation;

public interface RealisationService {
	Realisation saveRealisation(Realisation realisation);
	List<Realisation> getAllRealisations();
	Realisation getRealisation(Long id);
	List<Realisation> getRealisationbyuser(Long user_id);
	
;
}
