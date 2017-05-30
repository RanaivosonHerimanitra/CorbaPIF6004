package controller;

import java.sql.SQLException;

import swing.FormEventEtudiant;
import ClientServeur.PersonnelServant;
import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;

public class ControllerEtudiant {
PersonnelServant personnelServant ;

	
	public ControllerEtudiant(){
		personnelServant = new PersonnelServant();
	}
	
	public Etudiant[] getEtudiants(){
		return personnelServant.AfficherEtudiants();
		
	}
	public void addEtudiant(FormEventEtudiant ev) throws SQLException {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		String matricule = ev.getMatricule();
		
		Etudiant etudiant = new Etudiant(new PersonInfo(nom,prenom,courriel,domaine),matricule) ;
		
	
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(courriel);
		System.out.println(domaine);
		
		personnelServant.creerEtudiant(etudiant);
		//db.addEnseignant(enseignant);
	}
}
