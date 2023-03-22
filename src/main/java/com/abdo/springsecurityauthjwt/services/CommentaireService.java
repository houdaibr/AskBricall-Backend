package com.abdo.springsecurityauthjwt.services;

import java.util.List;

import com.abdo.springsecurityauthjwt.models.Commentaire;

public interface CommentaireService {
	List<Commentaire> getAllComments();
	Commentaire saveComment(Commentaire commentaire);
	
}
