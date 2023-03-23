package com.abdo.springsecurityauthjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdo.springsecurityauthjwt.models.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	
}
