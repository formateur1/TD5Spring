package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "select r.* from role r, utilisateur u, utilisateur_role ur\r\n"
			+ "where u.id = ur.id_utilisateur and r.id = ur.id_role and u.id =:id", nativeQuery = true)
	List<Role> findAllByIdUtilisateur(@Param("id") int idUtilisateur);
}
