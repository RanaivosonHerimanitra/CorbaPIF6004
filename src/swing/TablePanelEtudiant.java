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
import PersonnelAPP.Etudiant;
import PersonnelAPP.PersonInfo;


public class TablePanelEtudiant extends JPanel{

	private JTable table;
	private PersonnelTableModelEtudiant tableModel;
	private EtudiantTableListener etudiantTableListener;
	private JPopupMenu popup;

	public TablePanelEtudiant(){
		tableModel = new PersonnelTableModelEtudiant();
		table = new JTable(tableModel);

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
				if(etudiantTableListener !=null){
					etudiantTableListener.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}
			}
		});
		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(etudiantTableListener !=null){
					etudiantTableListener.rowUpdate(row);
					tableModel.fireTableRowsDeleted(row, row);
				}


			}
		});

		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);

	}

	public void setData(Etudiant[] etudiants) {
		tableModel.setData(etudiants);
	}
	public void refresh(){
		tableModel.fireTableDataChanged();
	}

	public Etudiant getSelectedEtudiant(int selectedRow) {
		return new Etudiant(new PersonInfo((String)tableModel.getValueAt(selectedRow, 0),
				(String)tableModel.getValueAt(selectedRow, 1),(String)tableModel.getValueAt(selectedRow, 3),
				(String)tableModel.getValueAt(selectedRow, 2)),(String)tableModel.getValueAt(selectedRow, 4));
	}

	public void setEtudiantTableListener(EtudiantTableListener listener){
		this.etudiantTableListener =listener;
	}

}