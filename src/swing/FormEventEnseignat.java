package swing;

import java.util.EventObject;

public class FormEventEnseignat extends EventObject{
	
	private String nom;
	private String prenom;
	private String courriel;
	private String domaine;
	private long phone;
	private Long poste;
	
	public FormEventEnseignat(Object source) {
		super(source);
		
	}
	
	public FormEventEnseignat(Object source,String nom,String prenom,String courriel,String domaine,long phone2,Long poste2) {
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


	public Long getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Long getPoste() {
		return poste;
	}


	public void setPoste(Long poste) {
		this.poste = poste;
	}


	

}
