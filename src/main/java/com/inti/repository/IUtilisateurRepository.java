package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Utilisateur;

@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	@Query(value = "select * from utilisateur where username=:ue or email=:ue", nativeQuery = true)
	Utilisateur findByUsernameOrEmail(@Param("ue") String usernameOrEmail);
	
//	Utilisateur findByUsernameOrEmail(String username, String email);

}
