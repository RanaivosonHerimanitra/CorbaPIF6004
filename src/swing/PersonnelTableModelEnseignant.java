package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import PersonnelAPP.Enseignant;

public class PersonnelTableModelEnseignant extends AbstractTableModel {
	private Enseignant[] db;
	public String[] colNames={"Nom","Prenom","Domaine","Mail","Poste","Téléphone"};
	public PersonnelTableModelEnseignant (){
		
	}
	@Override
	public String getColumnName(int column){
		return colNames[column];
	}
	public void setData(Enseignant[] enseignants){
		this.db = enseignants;
	}
	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		
		return db.length;
	}

	@Override
	public Object getValueAt(int row , int col) {
		Enseignant enseignant =db[row];
		
		switch(col){
		case 0:
			return enseignant.p.nom;
		case 1:
			return enseignant.p.prenom;
		case 2: 
			return enseignant.p.domain;
		case 3:
			return enseignant.p.mail;
		case 4:
			return enseignant.post;
		case 5:
			return enseignant.tel;
		}
		return null;
	}

}
