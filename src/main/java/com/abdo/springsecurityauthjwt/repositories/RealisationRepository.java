package com.abdo.springsecurityauthjwt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abdo.springsecurityauthjwt.models.Realisation;


@Repository
public interface RealisationRepository extends JpaRepository<Realisation, Long> {
	
	 @Query(value = "SELECT * FROM realisations WHERE user_id=?",nativeQuery = true)
     public List<Realisation> findByUserid(Long user_id);

}
