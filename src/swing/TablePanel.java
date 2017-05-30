package swing;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import PersonnelAPP.Enseignant;

public class TablePanel extends JPanel{
	
	private JTable table;
	private PersonnelTableModelEnseignant tableModel;
	
	public TablePanel(){
		tableModel = new PersonnelTableModelEnseignant();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	
	public void setData(List<Enseignant>db) {
		tableModel.setData(db);
	}
	public void refresh(){
		tableModel.fireTableDataChanged();
	}
}
