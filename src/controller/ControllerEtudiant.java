package controller;

import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import swing.FormEventEtudiant;
import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;
import PersonnelAPP.Personnel;
import PersonnelAPP.PersonnelHelper;

public class ControllerEtudiant {
	private static Personnel  personnelImpl ;

	public ControllerEtudiant(){
		try{
			// create and initialize the ORB
			Properties props = new Properties();
			props.put("org.omg.CORBA.ORBInitialPort", "1000");
			props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.187");
			String[] args = null;
			ORB orb = ORB.init(args, props);
			// get the root naming context
			org.omg.CORBA.Object objRef = 
					orb.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is 
			// part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// resolve the Object Reference in Naming
			String name = "Personnel";
			personnelImpl = PersonnelHelper.narrow(ncRef.resolve_str(name));

			System.out.println("Obtained a handle on server object: " + personnelImpl);
			//personnelImpl.shutdown();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Erreur de connexion avec le serveur. Nous nous excusons!",
					"Inane error",JOptionPane.ERROR_MESSAGE);
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}

	public Etudiant[] getEtudiants(){
		return personnelImpl.AfficherEtudiants();

	}

	public boolean addEtudiant(FormEventEtudiant ev) throws SQLException {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		String matricule = ev.getMatricule();
		//*
		if(!personnelImpl.chercherEtudiant(nom, prenom).p.nom.equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Erreur! Cette etudiant existe déja!",
					"Inane warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		//*/
		Etudiant etudiant = new Etudiant(new PersonInfo(nom,prenom,courriel,domaine),matricule) ;
		personnelImpl.creerEtudiant(etudiant);
		return true;
	}

	public void removeEtudiant(Etudiant selectedEtudiant) {
		System.out.println(selectedEtudiant.p.prenom);
		personnelImpl.supprimerEtudiant(selectedEtudiant);
	}
	
	public void shutDown(){
		personnelImpl.shutdown();
	}
}