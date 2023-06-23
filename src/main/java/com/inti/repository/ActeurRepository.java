package com.inti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Acteur;

@Repository
@Transactional
public interface ActeurRepository extends JpaRepository<Acteur, Integer>
{
	@Query(value = "select * FROM acteur a WHERE a.nom =:nom", nativeQuery = true)
	Acteur findByNom(@Param("nom") String nom);
	
//	Acteur findByNom(String nom);
	
	Acteur findByNomAndPrenom(String nom, String prenom);
	
	@Modifying // pour les requêtes de type update
	@Query(value = "UPDATE Acteur a set a.nom=:nom WHERE a.id=:id", nativeQuery = true)
	void updateNomActeurById(@Param("id") int id, @Param("nom") String nom);
	
}
