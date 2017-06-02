package swing;

import java.util.EventObject;

public class FormEventEtudiant extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String courriel;
	private String domaine;
	private String matricule;
	
	public FormEventEtudiant(Object source) {
		super(source);
		
	}

	public FormEventEtudiant(Object source, String nom, String prenom,
			String courriel, String domaine, String matricule) {
		super(source);
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.domaine = domaine;
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
}
