package com.inti.service;

import com.inti.model.Utilisateur;

public interface IUtilisateurService {
	
	Utilisateur findByUsernameOrEmail(String usernameOrEmail);
	void saveUtilisateur(Utilisateur u);

}
