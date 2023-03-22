package com.abdo.springsecurityauthjwt.services.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abdo.springsecurityauthjwt.models.Commentaire;
import com.abdo.springsecurityauthjwt.repositories.CommentaireRepository;
import com.abdo.springsecurityauthjwt.services.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService{
	
	private CommentaireRepository commentairerepository;
	
	

	public CommentaireServiceImpl(CommentaireRepository commentairerepository) {
		super();
		this.commentairerepository = commentairerepository;
	}

	@Override
	public List<Commentaire> getAllComments() {
		// TODO Auto-generated method stub
		return commentairerepository.findAll();
	}

	@Override
	public Commentaire saveComment(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return commentairerepository.save(commentaire);
	}
	
}
