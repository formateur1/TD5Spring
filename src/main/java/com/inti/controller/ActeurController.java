package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.repository.ActeurRepository;

@Controller
@RequestMapping("acteur")
public class ActeurController {
	
	@Autowired
	ActeurRepository ar;

//	@Secured("ROLE_CLIENT")
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	@GetMapping("listeActeur")
	public String listeActeur(Model m, Authentication auth)
	{
		boolean isAdmin = auth.getAuthorities().toString().contains("ROLE_ADMIN");
		m.addAttribute("isAdmin", isAdmin);
		m.addAttribute("listeA", ar.findAll());
		
		return "listeActeur";
	}
}
