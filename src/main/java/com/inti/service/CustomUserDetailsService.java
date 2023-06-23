package com.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Utilisateur;
import com.inti.repository.IRoleRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUtilisateurService ius;
	
	@Autowired
	IRoleRepository irr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur u = ius.findByUsernameOrEmail(username);
		
		if(u == null)
		{
			throw new UsernameNotFoundException("Utilisateur " + username + " non enregistré en BDD !");
		}
		
		UserDetails userDetails = User.withUsername(u.getUsername()).password(u.getMdp())
				.roles(irr.findAllByIdUtilisateur(u.getId()).toString()).build();
		
		return userDetails;
	}

}
