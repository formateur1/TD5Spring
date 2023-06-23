package com.inti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class Acteur
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private @NonNull String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private String ville;
	
	public Acteur(@NonNull String nom, String prenom, String email, String ville)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.ville = ville;
	}
}
