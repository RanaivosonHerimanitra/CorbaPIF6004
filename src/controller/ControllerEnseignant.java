package controller;

import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;
import PersonnelAPP.Personnel;
import PersonnelAPP.PersonnelHelper;
import swing.FormEventEnseignat;

public class ControllerEnseignant {

	private static Personnel personnelImpl ;

	public ControllerEnseignant(){
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

	public Enseignant[] getProfesseurs(){
		return personnelImpl.AfficherEnseigants();
	}
	
	public void addEnseignant(FormEventEnseignat ev) throws SQLException {
		String nom = ev.getNom();
		String prenom = ev.getPrenom();
		String courriel = ev.getCourriel();
		String domaine = ev.getDomaine();
		long phone = ev.getPhone();
		long poste = ev.getPoste();
		
		if(personnelImpl.chercherEtudiant(nom, prenom)!=null){
			JOptionPane.showMessageDialog(new JFrame(), "Erreur! Cette enseignat existe déja!",
					"Inane warning",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Enseignant enseignant = new Enseignant(new PersonInfo(nom,prenom,courriel,domaine),phone,poste) ;
		personnelImpl.creerEnseignant(enseignant);
	}

}