package swing;

import javax.swing.table.AbstractTableModel;

import PersonnelAPP.Enseignant;
import PersonnelAPP.Etudiant;

public class PersonnelTableModelEtudiant extends AbstractTableModel {
	private Etudiant[] db;
	public String[] colNames={"Nom","Prenom","Domaine","Mail","Matricule"};
	public PersonnelTableModelEtudiant (){
		
	}
	@Override
	public String getColumnName(int column){
		return colNames[column];
	}
	public void setData(Etudiant[] etudiants){
		this.db = etudiants;
	}
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		
		return db.length;
	}

	@Override
	public Object getValueAt(int row , int col) {
		Etudiant etudiant =db[row];
		
		switch(col){
		case 0:
			return etudiant.p.nom;
		case 1:
			return etudiant.p.prenom;
		case 2: 
			return etudiant.p.domain;
		case 3:
			return etudiant.p.mail;
		case 4:
			return etudiant.matricul;
		}
		return null;
	}

}
