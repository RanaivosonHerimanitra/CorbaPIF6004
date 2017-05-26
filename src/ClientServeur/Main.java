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
		
		// TODO Auto-generated method stub
		//PersonnelServant perso=new PersonnelServant();
		//Etudiant e= new Etudiant(new PersonInfo("moudache","salim","m@s","info"),45);
		//perso.creerEtudiant(e); OK
		//perso.chercherEtudiant("moudache");
		
	}

}
