package com.abdo.springsecurityauthjwt.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="time")
	private String time;
	@Column(name="commentaire")	
	private String commentaire;
	@ManyToOne()
	@JoinColumn(name = "realisation_id")
	private Realisation realisation;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
}
