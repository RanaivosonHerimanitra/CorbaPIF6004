package swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import PersonnelAPP.Etudiant;


public class TablePanelEtudiant extends JPanel{
	
	private JTable table;
	private PersonnelTableModelEtudiant tableModel;
	
	public TablePanelEtudiant(){
		tableModel = new PersonnelTableModelEtudiant();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	
	public void setData(Etudiant[] etudiants) {
		tableModel.setData(etudiants);
	}
	public void refresh(){
		tableModel.fireTableDataChanged();
	}
}