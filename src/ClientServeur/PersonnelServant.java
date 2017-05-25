package ClientServeur;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.HashMap;

import PersonnelAPP.*;         

import org.omg.CORBA.*;     
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*; 
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

class PersonnelServant extends PersonnelPOA {
	EnseignantController enseignantController;
	EtudiantController etudiantController;
	
	public PersonnelServant() {
		enseignantController = new EnseignantController();
		etudiantController = new EtudiantController();
	}

	//Code ORB par défaut
	private ORB orb;

    public void setORB(ORB orb_val) {
    	orb = orb_val;
    }

    public void shutdown() {
    	orb.shutdown(false);
    }

	
	@Override
	public void creerEnseignant(Enseignant e) throws SQLException {
	    
		enseignantController.insertion(e);
	}

	@Override
	public void creerEtudiant(Etudiant e) {
		try {
			etudiantController.insertion(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public Enseignant chercherEnseignant(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant chercherEtudiant(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant[] AfficherEnseigants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant[] AfficherEtudiants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEnseigant(Enseignant e) throws SQLException {
		enseignantController.delete(e);
		
	}

	@Override
	public void modifierEnseignant(Enseignant e, Enseignant newEnseignant) throws SQLException {
		enseignantController.update(e, newEnseignant);
		
	}

	@Override
	public void modifierEtudiant(Etudiant e, Etudiant newEtudiant) {
		// TODO Auto-generated method stub
		
	}


   
	
}
