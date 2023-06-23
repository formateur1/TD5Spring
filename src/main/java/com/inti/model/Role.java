package com.inti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, length = 50, nullable = false)
	@NonNull
	private String nom;
	
	@Exclude
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
				joinColumns = @JoinColumn(name = "id_role"),
				inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
	List<Utilisateur> listeUtilisateurs;


	
	
}
