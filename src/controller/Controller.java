package controller;

import java.util.List;

import model.Database;
import PersonnelAPP.Enseignant;
import swing.FormEvent;

public class Controller {
	Database db =new Database();
	public List<Enseignant> getProfesseur(){
		return db.getProfesseur();
		
	}
	public void addEnseignant(FormEvent ev){
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		String phone = ev.getPhone();
		String poste = ev.getPoste();
		
		Enseignant enseignant = new Enseignant();
		db.addEnseignant(enseignant);
	}
}
