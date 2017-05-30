package controller;

import java.sql.SQLException;
import ClientServeur.PersonnelServant;
import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;
import swing.FormEventEnseignat;

public class Controller {

	PersonnelServant personnelServant ;

	
	public Controller(){
		personnelServant = new PersonnelServant();
	}
	
	public Enseignant[] getProfesseurs(){
		try {
			return personnelServant.AfficherEnseigants();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void addEnseignant(FormEventEnseignat ev) throws SQLException {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();

		long phone = ev.getPhone();
		long poste = ev.getPoste();

		
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
