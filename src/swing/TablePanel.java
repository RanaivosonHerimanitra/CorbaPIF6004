package swing;

import java.awt.BorderLayout;
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
	
	public void setData(Enseignant[] enseignants) {
		tableModel.setData(enseignants);
	}
	public void refresh(){
		tableModel.fireTableDataChanged();
	}

	
	public Enseignant selectedRow(){
		int selectedRow= table.getSelectedRow();
		return new Enseignant(new PersonInfo((String)tableModel.getValueAt(selectedRow, 1),
				(String)tableModel.getValueAt(selectedRow, 1),(String)tableModel.getValueAt(selectedRow, 1),
				(String)tableModel.getValueAt(selectedRow, 1)),(long)tableModel.getValueAt(selectedRow, 1),
				(long)tableModel.getValueAt(selectedRow, 1));
	}
	

}
