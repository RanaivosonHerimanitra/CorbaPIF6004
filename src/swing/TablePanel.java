package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import PersonnelAPP.Enseignant;
import PersonnelAPP.PersonInfo;

public class TablePanel extends JPanel{
	
	private JTable table;
	private PersonnelTableModelEnseignant tableModel;
	
	//add today debut
	private EnseignantTableListener enseignantListener;
	private JPopupMenu popup;
	//fin
	public TablePanel(){
		tableModel = new PersonnelTableModelEnseignant();
		table = new JTable(tableModel);
		//add today debut
		popup = new JPopupMenu();
		JMenuItem removeItem = new JMenuItem("Delete row");
		popup.add(removeItem);
		JMenuItem updateItem = new JMenuItem("Modifier");
		popup.add(updateItem);
		table.addMouseListener(new MouseAdapter(){

			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				System.out.print(row);
				if(e.getButton() == MouseEvent.BUTTON3){
					popup.show(table, e.getX(), e.getY());
				}
			}
			
		});
		removeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(enseignantListener !=null){
					enseignantListener.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}
			}
		});
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(enseignantListener !=null){
					enseignantListener.rowUpdate(row);
					tableModel.fireTableRowsDeleted(row, row);
				}

				
			}
		});
		//add today fin
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	
	public void setData(Enseignant[] enseignants) {
		tableModel.setData(enseignants);
	}
	public void refresh(){
		tableModel.fireTableDataChanged();
	}

	//today debut
	public void setEnseignantTableListener(EnseignantTableListener listener){
		this.enseignantListener =listener;
	}
	//today fin

	
	public Enseignant getSelectedEnseignat(int selectedRow){
		System.out.println("\n"+tableModel.getValueAt(selectedRow, 5));
		return new Enseignant(new PersonInfo((String)tableModel.getValueAt(selectedRow, 0),
				(String)tableModel.getValueAt(selectedRow, 1),(String)tableModel.getValueAt(selectedRow, 2),
				(String)tableModel.getValueAt(selectedRow, 3)),(long)tableModel.getValueAt(selectedRow, 4),
				(long)tableModel.getValueAt(selectedRow, 5));
	}
	

}
