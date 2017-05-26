package swing;

import java.util.EventObject;

public class FormEvent extends EventObject{
	
	private String nom;
	private String prenom;
	private String courriel;
	private String domaine;
	private String phone;
	private String poste;
	
	public FormEvent(Object source,String nom,String prenom,String courriel,String domaine,String phone,String poste) {
		super(source);
		this.nom=nom;
		this.prenom=prenom;
		this.courriel=courriel;
		this.domaine=domaine;
		this.phone=phone;
		this.poste=poste;
	}
	public FormEvent(Object source) {
		super(source);
		
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	

}
