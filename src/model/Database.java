package model;

import java.util.ArrayList;
import java.util.List;

import PersonnelAPP.Enseignant;

public class Database {
	private ArrayList<Enseignant> professeur;
	
	public Database(){
		professeur = new ArrayList<Enseignant>();
	}
	
	public void addEnseignant(Enseignant enseignant){
		professeur.add(enseignant);
	}
	public List<Enseignant> getProfesseur(){
		return professeur;
	}
}
