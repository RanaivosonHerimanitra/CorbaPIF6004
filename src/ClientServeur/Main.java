package ClientServeur;
import java.sql.SQLException;
import java.util.ArrayList;

import PersonnelAPP.Enseignant;
import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		EnseignantController ec = new EnseignantController();
		Enseignant e1 = new Enseignant(new PersonInfo("Jean yves","Beliveau","jyvesbeliveau@uqtr.ca","developpement web"), 81952815,2101);
	
		//Test de l insertion enseignant ok 26mai
		//ec.insertion(e1);
		
		// Test de la suppression enseigant ok 26 mai
		//ec.delete(e1);
		
		// Test de la selection enseignant ok 26 mai
		ArrayList<Enseignant> ListEnseignant= ec.getEnseignant();
		 for ( Enseignant ens: ListEnseignant ) {
		 	System.out.println(ens.p.nom + ' ' + ens.p.prenom + ' ' + ens.p.domain + ' ' + ens.tel + ' ' + ens.post + ' ' + ens.p.mail);
		 }
		
		// Test de la selection d'enseigant par son nom: 26mai ok
		 //ec.selectEnseignant("boucif");
		

		//PersonnelServant perso=new PersonnelServant();
		//Etudiant e= new Etudiant(new PersonInfo("moudache","salim","m@s","info"),45);
		//perso.creerEtudiant(e); OK
		//perso.chercherEtudiant("moudache");

		
		//Tests Etudiant Conntroller
		//*/
		
		//*
		PersonnelServant perso=new PersonnelServant();
		
		//*	Tester l`ajout
			Etudiant e= new Etudiant(new PersonInfo("moudache","salim","m@s","info"),45);
			//perso.creerEtudiant(e); 
		//*/

		/* Chercher un etudiant
		perso.chercherEtudiant("moudache");
		//*/
		
		/* Afficher les etudiants
		perso.AfficherEtudiants();
		//*/
		
		/*Suppression d etudiant
		 perso.supprimerEtudiant(e);	 
		//*/

		
		//* Update Etudiant
			Etudiant newEtudiant= new Etudiant(new PersonInfo("moudache","salim","m@s","info"),50);
			perso.modifierEtudiant(e, newEtudiant);
		 
		//*/
		
		//*/
	}

}
