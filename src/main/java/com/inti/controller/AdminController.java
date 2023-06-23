package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Acteur;
import com.inti.repository.ActeurRepository;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	ActeurRepository ar;
	
	@GetMapping("creerActeur")
	public String creerActeur()
	{
		return "creerActeur";
	}
	
	@PostMapping("creerActeur")
	public String creerActeur(@ModelAttribute("acteur") Acteur a)
	{
		ar.save(a);
		
		return "creerActeur";
	}

}
