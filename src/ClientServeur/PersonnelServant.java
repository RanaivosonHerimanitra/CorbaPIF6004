package ClientServeur;
import java.sql.SQLException;
import java.util.List;

import PersonnelAPP.*;         

import org.omg.CORBA.*;     
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*; 
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class PersonnelServant extends PersonnelPOA {
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
	public void creerEnseignant(Enseignant e) {
		System.out.println("Servant: "+e.p.nom);
		try {
			enseignantController.insertion(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	public Enseignant chercherEnseignant(String nom, String prenom) {
		try {
			return enseignantController.selectEnseignant(nom, prenom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Etudiant chercherEtudiant(String nom , String prenom) {
		try {
			return etudiantController.getStudent(nom, prenom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Enseignant[] AfficherEnseigants() {
		List<Enseignant> ListEnseignant;
		try {
			ListEnseignant = enseignantController.getEnseignant();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		Enseignant[] tabEnseignant = new Enseignant[ListEnseignant.size()];
		tabEnseignant = ListEnseignant.toArray(tabEnseignant);

		for(Enseignant s : tabEnseignant)
			System.out.println(s.p.nom);
		return tabEnseignant;
	}

	@Override
	public Etudiant[] AfficherEtudiants() {
		List<Etudiant> ListEtudiants = null;
		Etudiant[] tabEtudiants = null;

		try {
			ListEtudiants = etudiantController.getStudents();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (ListEtudiants!=null){
			tabEtudiants = new Etudiant[ListEtudiants.size()];
			ListEtudiants.toArray(tabEtudiants);

			for(Etudiant e : tabEtudiants)
				System.out.println(e.p.nom);
		}

		return tabEtudiants;
	}

	@Override
	public void supprimerEtudiant(Etudiant e) {
		try {
			etudiantController.delete(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerEnseigant(Enseignant e) {
		try {
			enseignantController.delete(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void modifierEnseignant(Enseignant e, Enseignant newEnseignant) {
		try {
			enseignantController.update(e, newEnseignant);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void modifierEtudiant(Etudiant e, Etudiant newEtudiant) {
		try {
			etudiantController.update(e, newEtudiant);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

}
