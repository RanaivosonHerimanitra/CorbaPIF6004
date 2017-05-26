package ClientServeur;

import java.sql.SQLException;

import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		PersonnelServant perso=new PersonnelServant();
		//Etudiant e= new Etudiant(new PersonInfo("moudache","salim","m@s","info"),45);
		//perso.creerEtudiant(e); OK
		perso.chercherEtudiant("moudache");
		
	}

}
