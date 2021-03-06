/*
 * distribue les methodes CRUD etudiant dans l'ORB de CORBA
 */
package controller;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;
import PersonnelAPP.Personnel;
import PersonnelAPP.PersonnelHelper;
import swing.FormEventEtudiant;

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
			personnelImpl.AfficherEtudiants();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Erreur de connexion avec le serveur. Nous nous excusons!",
					"Inane error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
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
		
		if(!personnelImpl.chercherEtudiant(nom, prenom).p.nom.equals("")){
			JOptionPane.showMessageDialog(new JFrame(), "Erreur! Cette etudiant existe d�ja!",
					"Inane warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		Etudiant etudiant = new Etudiant(new PersonInfo(nom,prenom,courriel,domaine),matricule) ;
		personnelImpl.creerEtudiant(etudiant);
		return true;
	}

	public void removeEtudiant(Etudiant selectedEtudiant) {
		personnelImpl.supprimerEtudiant(selectedEtudiant);
	}

	public void shutDown(){
		personnelImpl.shutdown();
	}

	public boolean updateEtudiant(FormEventEtudiant ev, Etudiant old) {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		String matricule = ev.getMatricule();
		Etudiant newEtudiant = new Etudiant(new PersonInfo(nom,prenom,courriel,domaine),matricule) ;

		if(!personnelImpl.chercherEtudiant(nom, prenom).p.nom.equals("")& 
				!((nom.equals(old.p.nom)& prenom.equals(old.p.prenom)))){
			JOptionPane.showMessageDialog(new JFrame(), "Erreur! Cette etudiant existe d�ja!",
					"Inane warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		personnelImpl.modifierEtudiant(old, newEtudiant);
		return true;
	}

	public Etudiant[] getStudentsByDomain(String domain) {
		return personnelImpl.chercherEtudiantByDomain(domain);
	}

	public Etudiant getStudentsByNomPrenom(String nom,String prenom) {
		return personnelImpl.chercherEtudiant(nom, prenom);
	}
}