package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.repository.IRoleRepository;
import com.inti.service.IUtilisateurService;

@Controller
public class MainController {
	
	@Autowired
	IUtilisateurService ius;
	
	@Autowired
	IRoleRepository irr;
	
	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("creerUtilisateur")
	public String creerUtilisateur()
	{
		return "creerUtilisateur";
	}
	
	@PostMapping("creerUtilisateur")
	public String creerUtilisateur(@ModelAttribute("utilisateur") Utilisateur u)
	{
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		u.setMdp(b.encode(u.getMdp()));
		
		List<Role> listeR = List.of(irr.getById(1));
		u.setListRoles(listeR);
		
		ius.saveUtilisateur(u);
		
		return "creerUtilisateur";
	}

}
