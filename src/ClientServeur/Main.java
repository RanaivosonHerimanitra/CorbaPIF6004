package ClientServeur;

import java.sql.SQLException;

import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;

public class Main {

	public static void main(String[] args) throws SQLException {
		EnseignantController ec = new EnseignantController();
		Enseignant e1 = new Enseignant(new PersonInfo("Jean yves","Beliveau","jyvesbeliveau@uqtr.ca","developpement web"), 81952815,2101);
	
		//Test de l insertion enseignant ok 26mai
		ec.insertion(e1);
		
		// Test de la suppression enseigant
		
		// Test de la selection enseignant
		
		
		
	}

}
