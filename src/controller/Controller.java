package controller;

import java.sql.SQLException;
import java.util.List;

import ClientServeur.EnseignantController;
import ClientServeur.EtudiantController;
import ClientServeur.PersonnelServant;
import model.Database;
import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;
import PersonnelAPP.Personnel;
import PersonnelAPP.PersonnelOperations;
import swing.FormEventEnseignat;

public class Controller {

	PersonnelServant personnelServant ;

	
	public Controller(){
		personnelServant = new PersonnelServant();
	}


	Database db =new Database();
	public List<Enseignant> getProfesseur(){
		return db.getProfesseur();
		
	}
	public void addEnseignant(FormEventEnseignat ev) throws SQLException {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		int phone = ev.getPhone();
		int poste = ev.getPoste();
		
		Enseignant enseignant = new Enseignant(new PersonInfo(nom,prenom,courriel,domaine),phone,poste) ;
		
	
	    
	    
	    
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(courriel);
		System.out.println(domaine);
		System.out.println(phone);
		
		System.out.println(poste);
		personnelServant.creerEnseignant(enseignant);
		//db.addEnseignant(enseignant);
	}
}
