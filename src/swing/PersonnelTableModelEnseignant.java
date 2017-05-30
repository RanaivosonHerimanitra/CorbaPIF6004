package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import PersonnelAPP.Enseignant;

public class PersonnelTableModelEnseignant extends AbstractTableModel {
	private List<Enseignant> db;
	public String[] colNames={"ID","Nom","Prenom","Domaine","Mail","Poste","Téléphone"};
	public PersonnelTableModelEnseignant (){
		
	}
	@Override
	public String getColumnName(int column){
		return colNames[column];
	}
	public void setData(List<Enseignant> db){
		this.db=db;
	}
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		
		return db.size();
	}

	@Override
	public Object getValueAt(int row , int col) {
		Enseignant enseignant =db.get(row);
		
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
