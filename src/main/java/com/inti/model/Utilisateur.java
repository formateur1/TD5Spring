package com.inti.model;

import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String nom;
	@Column(length = 50)
	private String prenom;
	@Column(unique = true, length = 50, nullable = false)
	@NonNull
	private String username;
	@Column(nullable = false)
	@NonNull
	private String mdp;
	@Column(unique = true, length = 50, nullable = false)
	@NonNull
	private String email;
	@Column(length = 20)
	private String tel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	
	@Exclude
	@ManyToMany
	@JoinTable(name = "utilisateur_role",
				joinColumns = @JoinColumn(name = "id_utilisateur"),
				inverseJoinColumns = @JoinColumn(name = "id_role"))
	List<Role> listRoles;

	
	
}
