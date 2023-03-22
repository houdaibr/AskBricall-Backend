package com.abdo.springsecurityauthjwt.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "realisations")

public class Realisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Titre")
	private String Titre;
	@Column(name = "Description")
	private String Description;
	@Column(name = "category")
    private String category;
	@Column(name = "Image")
	private String Image;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	

}
