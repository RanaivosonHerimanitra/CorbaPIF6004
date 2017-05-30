package swing;

import java.util.EventObject;

public class FormEvent extends EventObject{
	
	private String nom;
	private String prenom;
	private String courriel;
	private String domaine;
	private int phone;
	private int poste;
	
	public FormEvent(Object source) {
		super(source);
		
	}
	
	public FormEvent(Object source,String nom,String prenom,String courriel,String domaine,int phone2,int poste2) {
		super(source);
		this.nom=nom;
		this.prenom=prenom;
		this.courriel=courriel;
		this.domaine=domaine;
		this.phone=phone2;
		this.poste=poste2;
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


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public int getPoste() {
		return poste;
	}


	public void setPoste(int poste) {
		this.poste = poste;
	}


	

}
